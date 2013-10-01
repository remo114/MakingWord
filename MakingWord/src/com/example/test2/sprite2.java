package com.example.test2;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class sprite2 extends Sprite {
	
	sprite2 sp2,colution;
	Sprite sprite1;
	boolean chk = true;
	IEntity EnSp = new Entity();
public sprite2(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,VertexBufferObjectManager pSpriteVertexBufferObject,final int a) {
	super(pX, pY, pWidth, pHeight, pTextureRegion, pSpriteVertexBufferObject);
	// TODO Auto-generated constructor stub
	
	sprite1 = new Sprite(pX, pY, pTextureRegion,pSpriteVertexBufferObject) {
		@Override
		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
			// Log.d("TitledImage", "Before ");
			switch (pSceneTouchEvent.getAction()) { 
			case TouchEvent.ACTION_DOWN: {
				//sprite1.setScale(1.09f);					
				break;
			}
			case TouchEvent.ACTION_MOVE: {
				//Log.d("Move ", "move  X:" + pTouchAreaLocalX + " move Y: " + pTouchAreaLocalY + " Sprite: " + sprite1.getUserData());
				if(sprite1.getParent().getUserData().equals("MainScene")){
					sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
					
						if(MainActivity.isChildOfEntity(MainActivity.spg.sprite1,sprite1)){
							if(!(sprite1.getParent().getUserData().equals("sprite4"))){
								colution = MainActivity.getColliedSprite(sprite1);
									if(!(colution==null)){
										if(MainActivity.isChildOfEntity(MainActivity.spg, colution.sprite1) == false){
											Log.d("Sprite2", "In Touch Move if if " + sprite1.getUserData());
											MainActivity.mCurrentScene.detachChild(colution.sprite1);
											//MainActivity.en1.attachChild(colution.sprite1);
											MainActivity.spg.sprite1.attachChild(colution.sprite1);
											Log.d("Sprite2", "In Touch Move if if after added as a child " + sprite1.getParent().getUserData());
										}
									}
							}
						}
					}
				//if((sprite1.getChildCount()!=0)){
					Log.d("Sprite","Sprite "+sprite1.getUserData() +" Child count  " + sprite1.getChildCount());
				//}

				break;
			}
			case TouchEvent.ACTION_UP: {
				Log.d("Sprite2", "parrent " + sprite1.getParent().getUserData());
				if(sprite1.getParent().getUserData().equals("MainScene")){
					//MainActivity.mCurrentScene.detachChild(sprite1);
					//MainActivity.en1.attachChild(sprite1);
					//MainActivity.myRectangle1.myRectangle.setWidth(200);
					
					//Log.d("Sprite2", "In Touch Up if ");
				}
				else if(sprite1.getParent().getUserData().equals("Entity1")){
//					MainActivity.en1.detachChild(sprite1);
//					MainActivity.mCurrentScene.attachChild(sprite1);
					//Log.d("Sprite2", "In Touch Up else if ");
				}
				else{
					//Log.d("Sprite2", "In Touch Up else ");
				}			
				
				break;
			}
			default: {

			}
			}
			return true;
		}
	};
	MainActivity.mCurrentScene.registerTouchArea(sprite1);
	//EnSp.attachChild(sprite1);
	sprite1.setHeight(pHeight);
	sprite1.setWidth(pWidth);
	sprite1.setZIndex(2);
	
}
}
