package org.usfirst.frc.team5667.robot;
import edu.wpi.first.wpilibj.PWMTalonSRX;
public class Drivetrain {
  private PWMTalonSRX r1;
  private PWMTalonSRX r2;
  private PWMTalonSRX l1;
  private PWMTalonSRX l2;
  private final double TURNING_CONSTANT = .5;
  public Drivetrain() {
	r1 = new PWMTalonSRX(0);
	r2 = new PWMTalonSRX(1);
	l1 = new PWMTalonSRX(2);
	l2 = new PWMTalonSRX(3);
	
  }
  public void Stop() {
	 r1.setSpeed(0);
	 r2.setSpeed(0);
	 l1.setSpeed(0);
	 l2.setSpeed(0);
  }
  public void forback(double speed) {
	  r1.setSpeed(speed);
	  r2.setSpeed(speed);
	  l1.setSpeed(speed);
	  l2.setSpeed(speed);
  }
  public void drive(double speed, double turn)
  {
	  if (turn == 0) {
		  forback(speed);
	  }
	  else if (turn < 0) {
		  //positive X is right, negative X is left
		  r1.setSpeed(speed);
		  r2.setSpeed(speed);
		  l1.setSpeed(speed - TURNING_CONSTANT * turn);
		  l2.setSpeed(speed - TURNING_CONSTANT * turn);
	  }
	  else if (turn > 0)
	  {
		  l1.setSpeed(speed);
		  l2.setSpeed(speed);
		  r1.setSpeed(speed - TURNING_CONSTANT * turn);
		  r2.setSpeed(speed - TURNING_CONSTANT * turn);
	  }
  }
}
