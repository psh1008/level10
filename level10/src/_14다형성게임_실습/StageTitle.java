package _14다형성게임_실습;


public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("[시작] 입력 >> ");
		String start = GameManager.scan.next();
		if(start.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return false;
		}
		return true;
	}
	@Override
	public void init() {
		
	}

}