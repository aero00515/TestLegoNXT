package tw.utaipei.edu.robot.control;

import tw.utaipei.edu.robot.control.walker.WalkBehavior;
import lejos.nxt.Motor;
import lejos.util.Delay;

class StraightWalk implements WalkBehavior {

	public int ratio;
	public int times;

	private Thread action;

	/**
	 * With default ratio = 100; times =4; Left is Motor A, Right is Motor C
	 */
	public StraightWalk() {
		ratio = 100;
		times = 4;
		// walk = ;
	}

	/**
	 * With your motor and detail
	 * 
	 * @param int ratio
	 * @param int iteration
	 */
	public StraightWalk(int ratio, int iteration) {
		this.ratio = ratio;
		this.times = iteration;
	}

	@Override
	public void moveSync() {
		action = new Thread(runCrossWalk);
		action.start();
	}

	@Override
	public void move() {
		action();
	}

	private void action() {
		int count = 0;
		while (count < times) {
			Motor.A.setSpeed(ratio);
			Motor.C.setSpeed(ratio);
			Motor.A.forward();
			Motor.C.forward();
			Delay.msDelay(1000);

			count++;
		}
	}

	Runnable runCrossWalk = new Runnable() {

		@Override
		public void run() {
			action();
		}
	};

}
