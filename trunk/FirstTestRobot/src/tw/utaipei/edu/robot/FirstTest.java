package tw.utaipei.edu.robot;

import tw.utaipei.edu.robot.control.Walker;

public class FirstTest {

	public static void main(String[] args) {
		System.out.println("Hi, baby. \nI'm rabbit robot.");

		Walker walker = Walker.getRunTimeWalker();
		walker.goCross(Walker.MINIMUM, 4);
		walker.goStraight(Walker.MAXIUM, 2);

	}

}
