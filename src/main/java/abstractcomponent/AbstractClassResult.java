package abstractcomponent;

import java.io.IOException;

import org.testng.annotations.Test;

public class AbstractClassResult extends AbstractClass {
//	public void xyz
//	AbstractClass abs = new AbstractClass();

//	public AbstractClassResult(int i) {
//		super(i);
//	}
//	public AbstractClassResult() {
//		super();
//	}

	public AbstractClassResult(int i) {
		// TODO Auto-generated constructor stub
	}

	public void UnImplementedMethod() {
		// TODO Auto-generated method stub

	}

	public void UnImplementedMethod2() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void implementedMethod() {
//		System.out.println("this is implemented Method1");
//	}

	@Test
	public void fdfdkj() {
		super.implementedMethod();
		try {
			int x = 1 / 0;
			System.out.println("aaaaaaaaaaa");
		} catch (ArithmeticException e4) {
			System.out.println("sssssssss");
		} catch (Exception e1) {

		} catch (Throwable e2) {

		} finally {
			System.out.println("hhhhhhhhhh");
		}

		switch ("c") {
		case "a":
			System.out.println("print a");
			break;
		case "b":
			System.out.println("print b");
			break;
		default:
			System.out.println("print d");

		}

	}

}
