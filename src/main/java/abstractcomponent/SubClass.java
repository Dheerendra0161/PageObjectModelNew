package abstractcomponent;

public class SubClass extends AbstractClassResult{

	public SubClass(int i) {
		super(i);
	}

	public static void main(String[] args) {
		new AbstractClassResult(10).implementedMethod();
	}

}

