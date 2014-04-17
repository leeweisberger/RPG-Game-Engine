package engine.menu;

public class MenuDisplayer {
	
	package engine.dialogue;

	import java.awt.Color;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;

	/**
	 * This is what actually will be displaying text/menus/whatever on the Canvas. A world will have an instance
	 * of one of these bad boys. This TextDislayer merely is a container for an object that implements
	 * the InteractionBox interface.
	 *
	 */

		InteractionBox myInteractionBox;
		
		
		public MenuDisplayer(InteractionBox b) {
			myInteractionBox = b;
		}
		
		/**
		 * Sets the current InteractionBox to be displayed
		 * @param b InteractionBox
		 */
		public void setInteractionBox(InteractionBox b) {
			myInteractionBox = b;
		}
		
		/**
		 * This method should be called from a Canvas.
		 * 
		 * @param g2d graphixxx object
		 * @param xSize size of canvas, in x direction
		 * @param ySize size of canvas, in y direction
		 * @param xOffset offset set by the camera
		 * @param yOffset offset set by the camera
		 */
		public void paintDisplayer(Graphics2D g2d, int xSize, int ySize, int xOffset, int yOffset) {
			if (myInteractionBox != null) {
				myInteractionBox.paintDisplay(g2d, xSize, ySize, xOffset, yOffset);
			}
		}
	


}