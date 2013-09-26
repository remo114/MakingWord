package com.example.test2;

import java.sql.NClob;
import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseActivity;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.Log;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity {

	public static int CAMERA_WIDTH;
	public static int CAMERA_HEIGHT;
	public Scene mCurrentScene;
	public static BaseActivity instance;
	public Camera mCamera;
	
	public Sprite BgSprite;
	public static Sprite sprite1,sprite2;
	public static ArrayList<Spriteobject> SpriteList;
	public static VertexBufferObjectManager vobm;
	
	
	public static BuildableBitmapTextureAtlas BgBuildableBitmapTextureAtlas;
	public static ITextureRegion BgTextureReason;
	public static ITextureRegion Letter1TextureReason;
	public static ITextureRegion Letter2TextureReason;
	public static ITextureRegion Letter3TextureReason;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		instance = this;
		//vobm = getVertexBufferObjectManager();
		SpriteList = new ArrayList<Spriteobject>();
	    mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    final EngineOptions engOps = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
		engOps.getTouchOptions().setNeedsMultiTouch(true);
	    return engOps; 
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		BgBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1900, 1532,TextureOptions.DEFAULT);
		this.BgTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "jungle16.png");
		this.Letter1TextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "letter_lo.png");
		this.Letter2TextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "letter_mo.png");
		
		try {
			BgBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			BgBuildableBitmapTextureAtlas.load();

		} catch (TextureAtlasBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		mCurrentScene = new Scene();
		mCurrentScene.setTouchAreaBindingOnActionMoveEnabled(true);
	    mCurrentScene.setBackground(new Background(0.09804f, 0.7274f, 0.8f));
	    
		BgSprite = new Sprite(0, 0, BgTextureReason, getVertexBufferObjectManager());
	    BgSprite.setHeight(CAMERA_HEIGHT);
		BgSprite.setWidth(CAMERA_WIDTH);
		mCurrentScene.attachChild(BgSprite);
		
		for (int i = 0; i<2; i++){
			
			Spriteobject sp1 = new Spriteobject(10f, 10f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
			sprite1 = sp1.sprite1;
			sp1.sprite1.setUserData(i);
			mCurrentScene.registerTouchArea(sp1.sprite1);
			mCurrentScene.attachChild(sp1.sprite1);
			MainActivity.SpriteList.add(sp1);			
		}
		MainActivity.SpriteList.get(0).attachChild(MainActivity.SpriteList.get(1));
		
		return mCurrentScene;
	}
	
	public static int getIndexOfSprite(Sprite s){
		
		if (MainActivity.SpriteList.contains(s)){
			return MainActivity.SpriteList.indexOf(s);
		}
		return 0;
	}
	public static Sprite getColliedSprite(Spriteobject sp){
	    for(int i = 0;  i< MainActivity.SpriteList.size();i++)
	    {
	    	
	       if(MainActivity.SpriteList.get(i).collidesWith(sp))
	       	{
	    	   return MainActivity.SpriteList.get(i);
	        }
	     
	     }

		return sp;
	}
	public static void updatePos(Spriteobject s, int x, int y) {
	    s.updatePosition(x, y);
	}
	public static BaseActivity getSharedInstance() {
	    return instance;
	}
	 
	// to change the current main scene
	public void setCurrentScene(Scene scene) {
	    mCurrentScene = scene;
	    getEngine().setScene(mCurrentScene);
	}

}
