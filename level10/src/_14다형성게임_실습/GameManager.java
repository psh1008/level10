package _14다형성게임_실습;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

	Random ran = new Random();
	static Scanner scan = new Scanner(System.in);
	static String nextStage = "";
	String curStage = "";
	Map<String, Stage> stageList = new HashMap<String, Stage>();

	GameManager() {

		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());

		nextStage = "TITLE";
	}

	boolean changeStage() {

		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		while (true) {
			if (stage.update() == false)
				break;
		}

		if (nextStage.equals(""))
			return false;
		else
			return true;

	}

}
