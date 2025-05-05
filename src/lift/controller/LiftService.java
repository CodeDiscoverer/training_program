package lift.controller;

public interface LiftService {
	
	void initial();
	void installLift();
	void moveLift();
	void moveLift(int id);
	void liftStatus();
	
}
