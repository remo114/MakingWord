package com.example.test2;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class sprite3 extends Sprite {

	Sprite sprite1;

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
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					// Log.d("Move ", "move  X:" + pTouchAreaLocalX +
					// " move Y: " + pTouchAreaLocalY + " Sprite: " +
					// sprite1.getUserData());

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
