package Zombie;

import java.util.Random;

// 유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
// 맵은 ~10까지 존재하며 한칸씩 이동 가능하다
// 유닛들은 전부 attack 메서드를 구현한다 

abstract public class Unit {
	private String name;
	private int pos; // 현재위치
	private int hp; // 현재 hp
	private final int MAX_HP;
	private int power; // 랜덤 공격 1부터 max 까지의 범위
	private Random rd; // 각각 하위 유닛들이 이 랜덤 클래스 사용해서 공격 범위 지정
	private int damage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Random getRd() {
		return rd;
	}
	public void setRd(Random rd) {
		this.rd = rd;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMAX_HP() {
		return MAX_HP;
	}
	Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		MAX_HP = hp;
		this.power = power;
		rd = new Random();
	}
	
	
	
}