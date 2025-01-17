package 다형성실습;

/*
 // damage() 메소드를 가진
 // Interface Damageable 를 정의하고
 // 최하위 유닛들 (모든) 에게 Damageable 상속
 // main 에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기
 */

class Unit {
	final int MAX_HP;
	int hp;
	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

public class _02스타크래프트 {

	public static void main(String[] args) {

		// 10개 유닛 만들어서
		
		// 서로 랜덤하게 공격하다가
		// 한명 살아남을떄까지 반복!
		
	}

}
