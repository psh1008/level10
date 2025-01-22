package _14다형성게임_실습;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	ArrayList<Player> pList = new ArrayList<>();
	ArrayList<Unit> mList = new ArrayList<>();
	String path = UnitManager.class.getPackageName()+".";
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random ran = new Random();
	
	UnitManager(){
		pList.add(new Player("전사",1000,45));
		pList.add(new Player("마법사", 800, 60));
		pList.add(new Player("힐러", 500, 70));
	}
	
	
}