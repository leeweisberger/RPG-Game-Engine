package engine.state;

import java.awt.event.KeyEvent;

import engine.Control;
import engine.gridobject.GridObject;
import engine.gridobject.Pickupable;
import engine.gridobject.person.Player;

public class WalkAroundState extends AbstractState {

	
	private Player myPlayer;
	
	public WalkAroundState(Player p) {
		super();
		myPlayer = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == Control.UP){
			myPlayer.setDY(-myPlayer.getSpeed());	
		}
		if (e.getKeyCode() == Control.DOWN){
			myPlayer.setDY(myPlayer.getSpeed());
		}
		if (e.getKeyCode() == Control.RIGHT){
			myPlayer.setDX(myPlayer.getSpeed());
		}
		if (e.getKeyCode() == Control.LEFT){
			myPlayer.setDX(-myPlayer.getSpeed());
		}		
		if (e.getKeyCode() == Control.A) {
			GridObject surrounding = myPlayer.getSurroundingChecker().checkSurroundings(myPlayer).get(0);
			if(surrounding!=null){
				surrounding.doAction();
				if(surrounding.getPickupable()!=null){
					(surrounding.getPickupable()).pickUp(myPlayer);
					surrounding.setPickupable(null);
				}
			}
		}	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == Control.UP
				|| e.getKeyCode() == Control.DOWN)
			myPlayer.setDY(0);

		if (e.getKeyCode() == Control.RIGHT
				|| e.getKeyCode() == Control.LEFT)
			myPlayer.setDX(0);
		if (e.getKeyCode() == Control.A)
			myPlayer.setAClick(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}