package tests.T127_SlaytTest;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class fgfgf {

    @Test

    public void givenString_whenCallIsEmpty_thenReturnCorrectValues() {
        assertFalse("Example text".isEmpty());
        assertTrue("".isEmpty());
        assertFalse("  ".isEmpty());
        assertFalse("\t\n".isEmpty());
    }
}
