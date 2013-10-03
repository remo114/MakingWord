package com.example.test2;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class sprite3 extends Sprite {

	Sprite sprite1;
	sprite3 s3,collution;
	boolean single=true;
	

	public sprite3(float pX, float pY, float pWidth, float pHeight,
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pSpriteVertexBufferObject, final int a) {
		super(pX, pY, pWidth, pHeight, pTextureRegion,
				pSpriteVertexBufferObject);
		sprite1 = new Sprite(pX, pY, pTextureRegion, pSpriteVertexBufferObject) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					
						for(int i = 0;i< MainActivity.SpriteContainer.size();i++){
							if(!(MainActivity.SpriteContainer.get(i).sprite1.equals(sprite1))){
							
								//Log.d("Sprite3",MainActivity.SpriteContainer.get(i).sprite1.getUserData() + " Distande: " +MainActivity.SpriteContainer.get(i).distance + " Degree : "+ MainActivity.SpriteContainer.get(i).angle);
							}
						}
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					if(s3.single){
						// If single obj
						sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
						collution = MainActivity.getColliedobj(sprite1);
						Log.d("Sprite3", "Collution " + collution);
						if(collution != null){
							collution.single = false;
							s3.single = false;
							if(!MainActivity.SpriteContainer.contains(s3)){
								MainActivity.SpriteContainer.add(s3);
							}
							if(!MainActivity.SpriteContainer.contains(collution)){
								MainActivity.SpriteContainer.add(collution);
							}
						}
					}
					else if(!s3.single){
						// joint obj
						float px = sprite1.getX(),py = sprite1.getY();					
						Log.d("Sprite3", " X: " +px + " Y: "+ py);
						sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
						
						float nx = sprite1.getX() - px,ny = sprite1.getY() - py;
						
						Log.d("Sprite3", "Size of array : "+MainActivity.SpriteContainer.size()+" X: " +nx + " Y: "+ ny);

						
						for(int i = 0;i< MainActivity.SpriteContainer.size();i++){
							if(!(MainActivity.SpriteContainer.get(i).sprite1.equals(sprite1))){
								MainActivity.SpriteContainer.get(i).sprite1.setPosition(MainActivity.SpriteContainer.get(i).sprite1.getX() + nx  ,	MainActivity.SpriteContainer.get(i).sprite1.getY() + ny );
							}
						}
						
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
		MainActivity.mCurrentScene.registerTouchArea(sprite1);
		sprite1.setAlpha(0.5f);
		sprite1.setHeight(pHeight);
		sprite1.setWidth(pWidth);
		//sprite1.setZIndex(2);

	}
}
