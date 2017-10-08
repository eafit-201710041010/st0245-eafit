import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrazoRoboticoTest {

	@Test
	public void testMoveOnto() {
        BrazoRobotico brazo = new BrazoRobotico(3);
        String[] com = {"move","1","onto","0"};
        brazo.leerComandos(com);
        String[] com2 = {"move","2","onto","0"};
        brazo.leerComandos(com2);
        assertEquals((long)brazo.stacks[0].pop(),(long)2);
        assertEquals((long)brazo.stacks[0].pop(),(long)0);
        assertEquals((long)brazo.stacks[1].pop(),(long)1);
	}
	
	@Test
	public void testMoveOver() {
        BrazoRobotico brazo = new BrazoRobotico(3);
        String[] com = {"move","1","over","0"};
        brazo.leerComandos(com);
        String[] com2 = {"move","2","over","0"};
        brazo.leerComandos(com2);
        assertEquals((long)brazo.stacks[0].pop(),(long)2);
        assertEquals((long)brazo.stacks[0].pop(),(long)1);
        assertEquals((long)brazo.stacks[0].pop(),(long)0);
	}
	
	@Test
	public void testPileOnto() {
        BrazoRobotico brazo = new BrazoRobotico(3);
        String[] com = {"pile","1","onto","0"};
        brazo.leerComandos(com);
        String[] com2 = {"pile","0","onto","2"};
        brazo.leerComandos(com2);
        assertEquals((long)brazo.stacks[2].pop(),(long)1);
        assertEquals((long)brazo.stacks[2].pop(),(long)0);
        assertEquals((long)brazo.stacks[2].pop(),(long)2);
	}
	
	@Test
	public void testPileOver() {
        BrazoRobotico brazo = new BrazoRobotico(4);
        String[] com = {"pile","1","over","0"};
        brazo.leerComandos(com);
        String[] com2 = {"pile","3","over","2"};
        brazo.leerComandos(com2);
        String[] com3 = {"pile","2","over","0"};
        brazo.leerComandos(com3);
        assertEquals((long)brazo.stacks[0].pop(),(long)3);
        assertEquals((long)brazo.stacks[0].pop(),(long)2);
        assertEquals((long)brazo.stacks[0].pop(),(long)1);
        assertEquals((long)brazo.stacks[0].pop(),(long)0);
	}
	@Test
	public void testMismaPila() {
        BrazoRobotico brazo = new BrazoRobotico(2);
        String[] com = {"pile","1","over","1"};
        brazo.leerComandos(com);
        assertEquals((long)brazo.stacks[1].pop(),(long)1);
	}
}