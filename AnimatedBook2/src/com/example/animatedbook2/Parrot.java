package com.example.animatedbook2;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import android.content.Context;
import android.util.Log;

public class Parrot extends AnimatedSprite{
	AnimatedSprite parrotFlying;
	Context cont;
	VertexBufferObjectManager vobm;
	Sprite Next,mLetter;
	ITextureRegion LetterTextureReason;
	
	public Parrot(float pX, float pY, float pWidth, float pHeight,ITiledTextureRegion pTiledTextureRegion,VertexBufferObjectManager pVertexBufferObject,int audio, Context con, ITextureRegion pTextureRegion) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion,pVertexBufferObject);
		vobm = pVertexBufferObject;
		cont = con;
		LetterTextureReason = pTextureRegion;
		mLetter = new Sprite(pX, pY, pTextureRegion, pVertexBufferObject);

		this.parrotFlying = new AnimatedSprite(pX,pY,pWidth,pHeight, pTiledTextureRegion, vobm){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
				final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					
					break;
				}
				case TouchEvent.ACTION_UP: {
					TiledImage.playAudio2(R.raw.mo);
					break;
				}
				default: {

				}
				}
				return false;
			}
		};
		//parrotFlying.setPosition(BaseActivity.CAMERA_WIDTH - 100, BaseActivity.CAMERA_HIGHT / 2 - 400);
		parrotFlying.animate(new long[]{200, 200, 200, 200, 200, 200, 200, 200}, 0, 7, true);
		parrotFlying.setFlippedHorizontal(true);
		parrotFlying.setHeight(BaseActivity.CAMERA_HIGHT/2);
		parrotFlying.setWidth(BaseActivity.CAMERA_WIDTH/4);
		mLetter.setHeight(BaseActivity.CAMERA_HIGHT/6);
		mLetter.setWidth(BaseActivity.CAMERA_WIDTH/8);
		loadMparrot();
		
	}
	
	void loadMparrot() {
		MoveModifier mMod = new MoveModifier(4.0f, BaseActivity.CAMERA_WIDTH + 100,BaseActivity.CAMERA_WIDTH - 250, BaseActivity.CAMERA_HIGHT / 10.55f,BaseActivity.CAMERA_HIGHT /10.55f);
		MoveModifier mModLetter = new MoveModifier(4.0f, BaseActivity.CAMERA_WIDTH + 100,BaseActivity.CAMERA_WIDTH - 220, BaseActivity.CAMERA_HIGHT/2.1f ,BaseActivity.CAMERA_HIGHT /2.1f);
		DelayModifier dMod = new DelayModifier(1,new IEntityModifierListener() {

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) {
						
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1) {
						TiledImage.playAudio(R.raw.parrot_introducing_mo);
						//mLetter.setVisible(false);
						
					}
				});
		SequenceEntityModifier macch_sm = new SequenceEntityModifier(mMod,dMod);
		SequenceEntityModifier mLetter_sm = new SequenceEntityModifier(mModLetter,dMod);
		RotationModifier rm1 = new RotationModifier(0.4f, 0.0f, 0.9f);
		RotationModifier rm2 = new RotationModifier(0.4f, 0.9f, 0.0f);
		parrotFlying.registerEntityModifier(macch_sm);
		mLetter.registerEntityModifier(mLetter_sm);
		SequenceEntityModifier mLetter_sm2 = new SequenceEntityModifier(rm1,rm2);
		LoopEntityModifier Lpm = new LoopEntityModifier(mLetter_sm2);
		mLetter.registerEntityModifier(Lpm);
	}
	void createNextArrow(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion, int voice){
		this.Next = new Sprite(pX, pY, pTextureRegion, this.vobm){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
//				Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN: {
						//this.setScale(1.09f);	
						break;
					}
					case TouchEvent.ACTION_MOVE: {
						//Log.d("TitledImage", "move");
						break;
					}
					case TouchEvent.ACTION_UP: {
						Log.d("next", "up ");
						BaseActivity.mMainScene.detachChildren();
						break;
					}
					default: {
	
					}
				}
				return false;
			}
		};
	}
}
