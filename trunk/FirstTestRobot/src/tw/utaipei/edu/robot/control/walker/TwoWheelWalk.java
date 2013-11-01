package tw.utaipei.edu.robot.control.walker;

public abstract class TwoWheelWalk {

	protected WalkBehavior walk;

	public void move() {
		walk.move();
	}

	public void moveSync() {
		walk.moveSync();
	}

}
