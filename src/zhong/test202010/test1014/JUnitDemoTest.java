package zhong.test202010.test1014;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JUnitDemoTest {

    private JUnitDemo jUnitDemo;

    @Before
    public void setUp() throws Exception {
        //
        jUnitDemo = new JUnitDemo();
    }

    @Test
    public void add() {
        assertEquals(jUnitDemo.add(5 , 5), 10);
    }
}