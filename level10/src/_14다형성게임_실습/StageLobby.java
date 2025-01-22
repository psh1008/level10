package _14다형성게임_실습;

public class StageLobby extends Stage {

	@Override
	public boolean update() {

		while(true) {
		try {
			System.out.println("====[LOBBY]====");
			System.out.println("[1.전투] [2.종료]");
			
			int sel = GameManager.scan.nextInt();
			if(sel == 1) {
				GameManager.nextStage = "BATTLE";
				return false;
			}if(sel == 2) {
				GameManager.nextStage = "";
				return false;
			}
		}catch(Exception e){
			System.out.println("입력 오류");
		}finally {
			GameManager.scan.nextLine();
		}
		}
	}

	@Override
	public void init() {
		
	}

}