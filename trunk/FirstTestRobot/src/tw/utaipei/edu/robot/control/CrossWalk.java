package tw.utaipei.edu.robot.control;

import tw.utaipei.edu.robot.control.walker.WalkBehavior;
import lejos.nxt.Motor;
import lejos.util.Delay;

class CrossWalk implements WalkBehavior {

	public int ratio;
	public int iteration;

	private Thread action;

	/**
	 * With default ratio = 100; iteration =4; Left is Motor A, Right is Motor C
	 */
	public CrossWalk() {
		ratio = 100;
		iteration = 4;
	}

	/**
	 * With detail
	 * 
	 * @param int ratio
	 * @param int iteration
	 */
	public CrossWalk(int ratio, int iteration) {
		this.ratio = ratio;
		this.iteration = iteration;
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
		int A = ratio * 2;
		int C = ratio * 1;
		while (count < iteration) {
			Motor.A.setSpeed(A);
			Motor.C.setSpeed(C);
			Motor.A.forward();
			Motor.C.forward();
			Delay.msDelay(1000);

			int temp;
			temp = A;
			A = C;
			C = temp;

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
