package abstractcomponent;

public abstract class AbstractClass {
	
	//it contains both implemented and unimplemented methods.
	//Constructor can be created
	//Object can't be created of Abstract class.
	public abstract  void UnImplementedMethod();
	public abstract void UnImplementedMethod2();
	
	public void implementedMethod() {
		System.out.println("this is implemented Method");
	}
	
	public AbstractClass(int Age) {
		System.out.println("this is constructor of AbstractClass"+Age);
	}
	public AbstractClass() {
		System.out.println("this is constructor of AbstractClass");
	}
	

}
