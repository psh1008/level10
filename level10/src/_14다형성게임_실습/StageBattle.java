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
	private int skillPercent;
	
	
	void print_character() {
		System.out.println("====[BATTLE]====");
		System.out.println("====[PLAYER]====");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("====[MONSTER]====");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}
	
	void mon_attack(int idx) {
		Unit m = monList.get(idx);
		if(m.curhp <=0)return;
		while(true) {
			int rdIdx = rd.nextInt(playerList.size());
			if(playerList.get(rdIdx).curhp > 0) {
				m.attack(playerList.get(rdIdx));
				break;
			}
		}
	}

	void player_attack(int idx) {
		Player p = playerList.get(idx);
		if (p.curhp <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		while (true) {
			try {
				System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
				int sel = GameManager.scan.nextInt();
				if (sel == 1) {
					int rdIdx = rd.nextInt(monList.size());
					if(monList.get(rdIdx).curhp > 0) {
						p.attack(monList.get(rdIdx));
						break;
					}
				} else if (sel == 2) {
					
				} else {
					System.out.println("다시 입력해 주세요");
					continue;
				}
			}catch(Exception e) {
				System.out.println("숫자를 입력해 주세요");
			}finally {
				GameManager.scan.nextLine();
			}
		}
	}

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			if (turn) {
				print_character();
				if (p_index < playerList.size()) {
					if(!stunCheck(p_index)) {
						player_attack(p_index);
					}else {
						System.out.println("스턴에 걸렸다");
						playerList.get(p_index).stunCnt++;
						playerList.get(p_index).stunCheck();
					}
					p_index++;
				}else {
					turn = !turn;
					p_index = 0;
				}
			}else {
				if(m_index < monList.size()) {
					skillPercent = rd.nextInt(5);
					if(skillPercent == 0) {
						m_skillCast(m_index);
					}else {
					mon_attack(m_index);
					}
					m_index++;
				}else {
					turn = !turn;
					m_index = 0;
				}
			}
			check_live();
			if(monDead <=0 || playerDead <=0) {
				break;
			}
		}

		GameManager.nextStage = "LOBBY";
		if(playerDead <=0)System.out.println("전투에서 패배 했습니다");
		if(monDead <=0)System.out.println("전투에서 승리 했습니다");
		return false;
	}

	boolean stunCheck(int idx){
		
		if(((Unit)playerList.get(idx)).isStun) {
			return true;
		}
		return false;
		
	}
	
	void m_skillCast(int idx) {
		
		if(monList.get(idx).name.equals("오크")) {
			((UnitOrc) monList.get(idx)).skill();
			Unit m = monList.get(idx);
			if(m.curhp <=0)return;
			while(true) {
				int rdIdx = rd.nextInt(playerList.size());
				if(playerList.get(rdIdx).curhp > 0) {
					m.critical_attack(playerList.get(rdIdx));
					break;
				}
			}
		}//else if(monList.get(idx).name.equals("늑대")) {
//			((UnitWolf) monList.get(idx)).skill();
//			return;
//		}else if(monList.get(idx).name.equals("박쥐")) {
//			((UnitBat) monList.get(idx)).skill();
//			return;
//		}
		
	}
	
	void check_live() {
		int cnt = 0;
		for(int i=0;i<playerList.size();i++) {
			if(playerList.get(i).curhp <=0) {
				cnt++;
			}
		}
		playerDead = playerList.size()-cnt;
		cnt = 0;
		for(int i=0;i<monList.size();i++) {
			if(monList.get(i).curhp <=0) {
				cnt++;
			}
		}
		monDead = monList.size() - cnt;
	}
	
	@Override
	public void init() {
		unitManager.mList.clear();
		unitManager.monster_rand_set(4);
		playerList = null;
		playerList = unitManager.pList;
		monList = null;
		monList = unitManager.mList;
		monDead = monList.size();
		playerDead = playerList.size();
	}
}