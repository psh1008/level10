package _14다형성게임_실습;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	ArrayList<Player> pList = new ArrayList<>();
	ArrayList<Unit> mList = new ArrayList<>();
	String path = UnitManager.class.getPackageName()+".";
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random rd = new Random();
	
	UnitManager(){
		
		pList.add(new Player("전사",1000,45));
		pList.add(new Player("마법사", 800, 60));
		pList.add(new Player("힐러", 500, 70));
		
	}
	
	void monster_rand_set(int size) {
		for(int i=0;i<size;i++) {
			int num = rd.nextInt(mons.length);
			try {
				
				Class<?> clazz = Class.forName(path+mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				int hp = rd.nextInt(100)+100;				
				int pow = rd.nextInt(10)+10;	
				temp.init(hp, pow);
				mList.add(temp);
			}catch(Exception e){
				
			}
		}
	}
	
}