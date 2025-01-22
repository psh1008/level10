package _14다형성게임_실습;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {

	UnitManager unitManager = new UnitManager();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monList = null;
	Random rd = new Random();
	int monDead = 0;
	int playerDead = 0;
	
	@Override
	public boolean update() {
		
		return false;
	}

	@Override
	public void init() {
		unitManager.mList.clear();
	}
}