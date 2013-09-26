package com.example.test2;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.vbo.ISpriteVertexBufferObject;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class Spriteobject extends Sprite {

	Sprite sprite1;
	//int a = 1;
	
	public Spriteobject(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,VertexBufferObjectManager pSpriteVertexBufferObject,final int a) {
		super(pX, pY, pWidth, pHeight, pTextureRegion, pSpriteVertexBufferObject);
		// TODO Auto-generated constructor stub
		
		sprite1 = new Sprite(pX, pY, pTextureRegion,getVertexBufferObjectManager()) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					sprite1.setScale(1.09f);					
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					//Log.d("Move ", "move  X:" + pTouchAreaLocalX + " move Y: " + pTouchAreaLocalY);
					//sprite1.setPosition(pTouchAreaLocalX, pTouchAreaLocalY);
					sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
					//(MainActivity.getColliedSprite(this)).;
					
					
//					if(sprite1.collidesWith(MainActivity.sprite2)){
//						 Log.d("Collied", "sp1.sprite1 ");
//					}
					//a = 2;
					if(a==1){
					//	MainActivity.updatePos((MainActivity.getColliedSprite(this), (int)pSceneTouchEvent.getX() - sprite1.getWidth(), (int)pSceneTouchEvent.getY() - sprite1.getHeight());
					}
					break;
				}
				case TouchEvent.ACTION_UP: {

					break;
				}
				default: {

				}
				}
				return true;
			}
		};
		sprite1.setHeight(pHeight);
		sprite1.setWidth(pWidth);
		
	}
	void updatePosition(int x, int y){
		sprite1.setPosition(x, y);
	}

}
