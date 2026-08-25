package com.neueda.leap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    
    @Test
    public void testMainMethodRunsWithoutException() {
        // Capture the system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // This should not throw an exception
            Main.main(new String[]{});
            
            // Verify output contains expected messages
            String output = outContent.toString();
            assertNotNull(output, "Main method should produce output");
            assertTrue(output.contains("Hello Everyone!"), "Output should contain greeting");
            assertTrue(output.contains("Lebron"), "Output should mention Lebron");
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
    
    @Test
    public void testMainMethodAcceptsArguments() {
        // Test that main method accepts arguments without throwing exception
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Should handle arguments gracefully
            Main.main(new String[]{"arg1", "arg2"});
            assertNotNull(outContent.toString(), "Main method should handle arguments");
        } finally {
            System.setOut(originalOut);
        }
    }
    
    @Test
    public void testMainMethodWithEmptyArguments() {
        // Test with empty string array
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            Main.main(new String[]{});
            String output = outContent.toString();
            assertTrue(output.contains("I really really love Lebron!!!!"), 
                "Output should contain the complete message");
        } finally {
            System.setOut(originalOut);
        }
    }
}
