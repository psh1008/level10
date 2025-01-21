package _08열거타입enum;

class Button2{
	enum Mode{
		LIGHT,DARK
	};
	enum Space{
		SINGLE,DOUBLE
	};
	
	private Mode mode = Mode.LIGHT;
	private Space space = Space.SINGLE;
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public Space getSpace() {
		return space;
	}
	public void setSpace(Space space) {
		this.space = space;
	}
	
	
}

public class _02enum개념2 {

	public static void main(String[] args) {

		Button2 btn = new Button2();
		System.out.println(btn.getMode());
		System.out.println(btn.getSpace());
		btn.setSpace(Button2.Space.DOUBLE);
		System.out.println(btn.getSpace());
		
	}

}
