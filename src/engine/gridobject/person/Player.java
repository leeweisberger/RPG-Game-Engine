package engine.gridobject.person;

import java.awt.event.KeyEvent;
import engine.gridobject.Door;
import engine.item.Item;
import engine.state.AbstractState;
import engine.state.WalkAroundState;
import engine.world.SurroundingChecker;

//import engine.AbstractGameState;

public class Player extends Person {

	private static final int DEFAULT_PLAYER_HEIGHT = 1;
	private static final int DEFAULT_PLAYER_WIDTH = 1;
	public boolean aClick = false;
	private AbstractState myState;
	private SurroundingChecker mySurroundingChecker;
	private Door enteredDoor = null;
	private double originalSpeed;

	public Player(String[] animImages, String name, double speed, String[] items, String[] weps) {
		super(animImages, name, speed, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		myState = new WalkAroundState(this);
	}

	public void setSurroundingsChecker(SurroundingChecker surroundingChecker) {
		mySurroundingChecker = surroundingChecker;
	}

	public void setState(AbstractState state) {
		myState = state;
	}

	public AbstractState getState() {
		return myState;
	}

	public void keyPressed(KeyEvent e) {
		myState.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		myState.keyReleased(e);
	}

	public void setAClick(boolean b) {
		aClick = b;
	}

	public double getOriginalSpeed() {
		return originalSpeed;
	}

	public Door isDoorEntered() {
		Door door = enteredDoor;
		enteredDoor = null;
		return door;
	}

	public void enterDoor(Door door) {
		enteredDoor = door;
	}

	public SurroundingChecker getSurroundingChecker() {
		return mySurroundingChecker;
	}

	public boolean hasItem(String myItemName) {
		if (myItemName != null) {
			for (Item i : super.getItems()) {
				if (i.toString().equals(myItemName))
					return true;
			}
		}
		return false;
	}
}
