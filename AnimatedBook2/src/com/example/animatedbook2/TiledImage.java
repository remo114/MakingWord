package com.example.animatedbook2;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.FadeInModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.color.Color;
import org.andengine.util.modifier.IModifier;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class TiledImage extends Sprite{
	
	Sprite Letter,s;
	IEntity en ;
	static boolean audioPlay= false;
	static int ObjNo=0,audio,audioPlayCount=0;
	static float APPEARING_TIME=3f;
	static MediaPlayer mediaPlayer;
	static Context con;
	
	public TiledImage(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,VertexBufferObjectManager vertexBufferObjectManager, int voice, Context cont) {
		super(pX, pY, pWidth, pHeight, pTextureRegion, vertexBufferObjectManager);
		con=cont;
		ObjNo++;
		audioPlayCount=0;
		audio = voice;
		audioPlay = false;
		mediaPlayer= new MediaPlayer();
		this.Letter = new Sprite(pX, pY, pTextureRegion, vertexBufferObjectManager) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN: {
						this.setScale(1.09f);	
						break;
					}
					case TouchEvent.ACTION_MOVE: {
						//Log.d("TitledImage", "move");
						break;
					}
					case TouchEvent.ACTION_UP: {
						this.setScale(1.0f);	
						playAudio2(audio);
						break;
					}
					default: {
	
					}
				}
				return false;
			}
		};
		en = new Entity(0,0);
		//s = new Sprite(pX, pY, BaseActivity.SpriteBgTextureReason, vertexBufferObjectManager);
		s = new Sprite(0,0, BaseActivity.SpriteBgTextureReason, vertexBufferObjectManager);
		Letter.setWidth(pHeight);
		Letter.setHeight(pHeight);		
		s.setWidth(pHeight);
		s.setHeight(pHeight);
		s.setZIndex(-1);
		s.setAlpha(0.8f);
		//Letter.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		Letter.attachChild(s);
		
		s.setVisible(false);
		Letter.setVisible(false);	
//		en.attachChild(s);
//		en.attachChild(Letter);
//		en.setVisible(false);
		AnimateImage();
		
	}
	
	void AnimateImage() {
		DelayModifier dMod = new DelayModifier(ObjNo * 5,new IEntityModifierListener() {

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) {
						
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
								IEntity arg1) {
						Letter.setVisible(true);
						s.setVisible(true);
						//en.setVisible(true);
						playAudio(R.raw.m_moi);
						audioPlayCount++;
						//Log.d("obj", " obj "+ audioPlayCount + " audioPlay "+ audioPlay);
						if(audioPlayCount==6){
							audioPlay = true;
							BaseActivity.ArrowTouchEnable = true;
						}
					}
				});
		FadeInModifier macch_fim2 = new FadeInModifier(APPEARING_TIME);
		//FadeInModifier macch_fim2c = new FadeInModifier(APPEARING_TIME);
		//ParallelEntityModifier pm =new ParallelEntityModifier(macch_fim2,macch_fim2c);
		//s.registerEntityModifier(pm);
		SequenceEntityModifier macch_sm = new SequenceEntityModifier(dMod,macch_fim2);
		
		Letter.registerEntityModifier(macch_sm);
//		s.registerEntityModifier(macch_sm);
	//	en.registerEntityModifier(macch_sm);
		
		
	}

	static void playAudio(int val) {
		if(mediaPlayer.isPlaying() == false ){
			mediaPlayer.reset();
		mediaPlayer = MediaPlayer.create(con,val);
			try {				
				mediaPlayer.start();
				mediaPlayer.setLooping(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	static void playAudio2(int val) {
	
		if(audioPlay){
			if (!mediaPlayer.isPlaying()){
				mediaPlayer.reset();
				//Log.d(d, "Is Playing: " + mediaPlayer.isPlaying());
				mediaPlayer = MediaPlayer.create(con,val);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			audioPlay = true;			
		}
	}
	
// NB: audioPlay will true after a surtain time After Loading Last sprite  
}
 