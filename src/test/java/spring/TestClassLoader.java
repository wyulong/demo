package spring;

public class TestClassLoader {
	public static void main(String[] args) {
		Byte a = 1;
		System.out.println(a.getClass().getClassLoader());
	}
}
