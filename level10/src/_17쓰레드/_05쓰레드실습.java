package _17쓰레드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class InputMachine implements Runnable {

	private Scanner sc = new Scanner(System.in);
	public static char input;

	private static StringBuffer buffer = new StringBuffer();
	private boolean isRun = true;
	
	public InputMachine() {
		System.out.println("input 쓰레드 생성");
		input ='0';
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(">>>>");
		while (isRun) {
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
				
				buffer.setLength(0);
				buffer.append(reader.readLine());
				input = buffer.charAt(0);
				
				if(input == 'q')isRun = false;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class StopWatch implements Runnable {

	private int time; // 소요시간 출력

	public StopWatch() {
		System.out.println("StopWatch 쓰레드 생성");
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		System.out.println("아무 버튼이나 누르면 시작");
		System.out.println("[q] quit [h]hold [x] return");
		while (true) {
			if (InputMachine.input == 'q') {
				System.out.printf("소요시간 : %d분 %d초 \n", time / 60, time % 60);
				System.out.println("종료");
				return;
			} else if (InputMachine.input == 'x') {
				System.out.println("강제 종료");
				return;
			} else if (InputMachine.input == 'h') {
				continue;
			}
				
				long preTime = System.currentTimeMillis();
				System.out.printf("%s [%d sec]\n", sdf.format(preTime), ++time);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
	}

}

public class _05쓰레드실습 {

	public static void main(String[] args) {

		new Thread(new InputMachine()).start();
		new Thread(new StopWatch()).start();

	}

}
