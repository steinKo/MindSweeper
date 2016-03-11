import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MineFieldTest {
	MineField mineField =new MineField();

	@SuppressWarnings("deprecation")
	@Test
	public void testMaximumNumberOfRows() {
		assertEquals("shoul be 5",mineField.maksimumNuberofRows(),5);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testMaximumNumberOfColumns() {
		assertEquals("shoul be 10",mineField.maksimumNumberofColumns(),10);
	}

}
