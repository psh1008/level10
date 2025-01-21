package _07Zombie;

import java.util.Scanner;

public class _gameMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Hero hero = new Hero("히어로", 1, 200, 30, 2);
		Zombie zombi = new Zombie("좀비", 5, 100, 10);

		//						 pos,hp,power,shield
		Boss boss = new Boss("보스", 9, 300, 20, 100);

		int pos = 1;
		
	}
}