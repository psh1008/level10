package _14다형성게임_실습;

public class UnitOrc extends Unit {

	UnitOrc(){
		name = "오크";
	}
	
	void skill() {
		System.out.println("한명에게 두배의 데미지 + 기절");
	}
	
}