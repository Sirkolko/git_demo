package Program.PowerGridReader;

import java.io.*;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import static org.junit.Assert.*;

public class LineReaderTest {

    @org.junit.Test
    public void lineReader() throws IOException {
        String firstInput = "110\r\n70\r\n";
        //String secondInput = "70\r\n";

        StringBuilder sb = new StringBuilder();
        sb.append(firstInput);
        //sb.append(System.lineSeparator());
        //sb.append(secondInput);
        //sb.append(System.lineSeparator());

        String input = sb.toString();

        final ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes());
        BufferedInputStream controlledIn = new BufferedInputStream(byteIn);

        //ByteArrayInputStream in = new ByteArrayInputStream(secondInput.getBytes());

        System.setIn(controlledIn);

        LineReader line = new LineReader();
        double actual = line.lineReader();


        double expected = 0.432;

        assertEquals(expected,actual,0.1);
    }
}