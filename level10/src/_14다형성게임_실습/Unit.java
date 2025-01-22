package _14다형성게임_실습;


public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	Unit(){
	}
	Unit(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};

	void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	}
	void attack(Unit target) {
		target.curhp -= power;
		System.out.println("[" + name + "] 이 " + "[" + target.name + "] 에게 " + power + "의 데미지를 입혔다 ");
		if (target.curhp <= 0) {
			System.out.println("[" + target.name + "] 을 처치했습니다.");
			target.curhp = 0;
		}
	}

	void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
	
}