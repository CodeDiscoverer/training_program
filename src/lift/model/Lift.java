package lift.model;

public class Lift {
	
	private int liftId;
	private int[] liftAccessibleRange;
	private int liftCurrentFloor = 0;
	private int liftDestination;
	
	public int getLiftId() {
		return liftId;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public int getLiftCurrentFloor() {
		return liftCurrentFloor;
	}
	public void setLiftCurrentFloor(int liftCurrentFloor) {
		this.liftCurrentFloor = liftCurrentFloor;
	}
	public int getliftDestination() {
		return liftDestination;
	}
	public void setliftDestination(int liftMoveToFloor) {
		this.liftDestination = liftMoveToFloor;
	}
	public int[] getLiftAccessibleRange() {
		return liftAccessibleRange;
	}
	public void setLiftAccessibleRange(int[] liftAccessibleRange) {
		this.liftAccessibleRange = liftAccessibleRange;
	}
	
}
