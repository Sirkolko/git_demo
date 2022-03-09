package Program.PowerGridReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountFileRowsTest {

    @Test
    void countFile1Rows() {
        CountFileRows c1 = new CountFileRows();
        assertEquals(8,c1.countFile1Rows());
    }

    @Test
    void countFile2Rows() {
        CountFileRows c1 = new CountFileRows();
        assertEquals(5,c1.countFile2Rows());
    }
}