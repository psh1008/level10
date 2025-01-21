package _06다형성실습;

import java.util.ArrayList;
import java.util.Random;

/*
 // damage() 메소드를 가진
 // Interface Damageable 를 정의하고
 // 최하위 유닛들 (모든) 에게 Damageable 상속
 // main 에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기
 */

interface Damageable{ 
	 void damage(int damage);
}

class Unit implements Damageable{
	final int MAX_HP;
	int hp;
	final int ATTACK_POWER;
	String name;
	public Unit(int hp , int attack,String name) {
		MAX_HP = hp;
		this.hp = MAX_HP;
		ATTACK_POWER = attack;
		this.name = name;
	}
	@Override
	public void damage(int damage) {
		hp -= damage;
	}
	
}

class Zombie extends Unit{
	public Zombie() {
		super(5,2,"좀비");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Man extends Unit {

	public Man() {
		super(5,2,"남자");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Woman extends Unit{

	public Woman() {
		super(3,1,"여자");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Baby extends Unit{

	public Baby() {
		super(2,1,"아기");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}
class Boy extends Unit{

	public Boy() {
		super(4,2,"소년");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Girl extends Unit{

	public Girl() {
		super(3,1,"소녀");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Dog extends Unit{

	public Dog() {
		super(2,2,"개");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Gangster extends Unit{

	public Gangster() {
		super(6,3,"건달");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}
class Oldman extends Unit{

	public Oldman() {
		super(2,2,"노인");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}
class Monster extends Unit {

	public Monster() {
		super(7,4,"괴물");
	}
	@Override
	public String toString() {
		return String.format("%s (%d / %d ) 공격력 : %d ",name , hp, MAX_HP,ATTACK_POWER);
	}
}

class Run {
	ArrayList<Unit> uList = new ArrayList<>();
	void init(){
		uList.add(new Zombie());
		uList.add(new Man());
		uList.add(new Woman());
		uList.add(new Boy());
		uList.add(new Girl());
		uList.add(new Dog());
		uList.add(new Baby());
		uList.add(new Gangster());
		uList.add(new Oldman());
		uList.add(new Monster());
	}
	void printUnits() {
		for(int i=0;i<uList.size();i++) {
			System.out.println("[생성] "+uList.get(i));
		}
	}
	void fight() {
		
		Random rd = new Random();
		while(uList.size() > 1) {
			int attIdx = rd.nextInt(uList.size());
			int hitIdx = rd.nextInt(uList.size());
			
			if(attIdx == hitIdx)continue;
			System.out.printf("%s(이)가 %s(를)을 공격했습니다\n",uList.get(attIdx).name,uList.get(hitIdx).name);
			uList.get(hitIdx).damage(uList.get(attIdx).ATTACK_POWER);	
			System.out.println(uList.get(hitIdx));
			if(uList.get(hitIdx).hp <= 0) {
				System.out.println(uList.get(hitIdx).name+" 사망");
				uList.remove(hitIdx);
			}
		}
		System.out.printf("최종 생존자 = %s",uList.get(0).name);
	}
}

public class _02스타크래프트 {

	public static void main(String[] args) {

		Run run = new Run();
		run.init();
		run.printUnits();
		run.fight();
		
		// 10개 유닛 만들어서
		
		// 서로 랜덤하게 공격하다가
		// 한명 살아남을떄까지 반복!
		
	}

}
