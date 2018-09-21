package fox.main;

import fox.test.FoxTest;

public class FoxMain extends FoxTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FoxTest test=new FoxTest();
		test.setUp();
		test.testFox();
		test.tearDown();
	}

}
