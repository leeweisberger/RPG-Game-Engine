package authoring.gameObjects;

import java.util.List;

import authoring.SpriteImageChooser;

import util.Constants;

public class NPCData extends GridObjectData{
	private NPCResponseNode myRoot;
	private String[] myImages;
	
	public NPCData(int x, int y, int width, int height, String image, NPCResponseNode root) {
		super(x, y, width, height, image, root, Constants.NPC);
		myRoot = root;
		init();
		SpriteImageChooser imageChoose=new SpriteImageChooser();
		myImages=imageChoose.getSpriteImages("Ash");
		setHeight(height);
		setWidth(width);
	}
	
	public NPCResponseNode getDialogue(){
		return myRoot;
	}
	
	public String[] getImages(){
		return myImages;
	}
	
}