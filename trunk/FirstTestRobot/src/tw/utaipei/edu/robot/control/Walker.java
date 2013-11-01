package tw.utaipei.edu.robot.control;

import tw.utaipei.edu.robot.control.walker.TwoWheelWalk;

public class Walker extends TwoWheelWalk {

	public static final int MAXIUM = 900;
	public static final int MINIMUM = 100;
	public static final int MEDIUM = (MAXIUM - MINIMUM) / 2;

	private static Walker walker = null;

	private Walker() {
	}

	public static Walker getRunTimeWalker() {
		if (walker == null) {
			synchronized (Walker.class) {
				if (walker == null) {
					walker = new Walker();
				}
			}
		}
		return walker;
	}

	public void goCross() {
		walk = new CrossWalk();
		go();
	}

	public void goCross(int ratio, int iteration) {
		walk = new CrossWalk(ratio, iteration);
		go();
	}

	public void goStraight() {
		walk = new StraightWalk();
		go();
	}

	public void goStraight(int ratio, int iteration) {
		walk = new StraightWalk(ratio, iteration);
		go();
	}

	private void go() {
		walk.move();
	}
}
