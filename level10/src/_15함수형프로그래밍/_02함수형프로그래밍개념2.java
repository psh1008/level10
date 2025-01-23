package _15함수형프로그래밍;

@FunctionalInterface
interface Type1{
	void call();
}
@FunctionalInterface
interface Type2{
	void call(int num,String str);
}
@FunctionalInterface
interface Type3{
	int call();
}
@FunctionalInterface
interface Type4{
	boolean call(int num);
}

public class _02함수형프로그래밍개념2 {

	public static void main(String[] args) {

		Type1 t1 = ()-> System.out.println("타입 1 호출!");
		t1.call();
		
		Type2 t2 = (int a,String b)-> System.out.printf("타입 2 호출! a = %d , b = %s \n",a,b);
		t2.call(100, "test");
		
		Type3 t3 = () -> {
			System.out.println("타입 3 호출!");
			return 100;
		};
		
		int num = t3.call();
		System.out.println(num);
		
		Type4 t4 = (int x) -> x < 100; // 딱 한줄이면 중괄호 , return 생략 가능
		Type4 t5 = x -> x<10; // 매개 변수가 하나라면 매개변수 소괄호 생략가능
		
		System.out.println(t4.call(1000));
		System.out.println(t4.call(1));
		
		
	}

}
