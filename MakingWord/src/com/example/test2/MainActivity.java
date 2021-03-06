package com.example.test2;

import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.ITouchArea;
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
import org.andengine.util.color.Color;

import android.util.Log;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity {

	public static int CAMERA_WIDTH;
	public static int CAMERA_HEIGHT;
	public static Scene mCurrentScene;
	public static Scene mCurrentScene1;
	public static BaseActivity instance;
	public Camera mCamera;
	
	
	//public static Entity en1 = new Entity();
	
	
	public Sprite BgSprite;
	public static Sprite sprite1,sprite2;
	public static ArrayList<sprite2> SpriteList;
	public static VertexBufferObjectManager vobm;	
	public static ArrayList<sprite3> SpriteContainer;
	public static ArrayList<sprite3> SpriteContainer1;
	
	public static sprite2 sp1,sp2,sp3,spg;
	public static sprite3 sp3a,sp3b,sp3c,sp3d;
	
	
	//public static GroupSprite myRectangle1;
	/*GroupSprite myRectangle2;
	GroupSprite myRectangle3;*/
	
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
		SpriteList = new ArrayList<sprite2>();
		SpriteContainer = new ArrayList<sprite3>();
		SpriteContainer1 = new ArrayList<sprite3>();
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
		mCurrentScene.setUserData("MainScene");
		
		//myRectangle1 = new GroupSprite(110f, 110f, 50f, 30f, this.getVertexBufferObjectManager());
		//myRectangle1.myRectangle.attachChild(en1);
		//en1.setUserData("Entity1");
//		mCurrentScene.attachChild(myRectangle1.myRectangle);
//		mCurrentScene.registerTouchArea(myRectangle1.myRectangle);
		
		sp3a = new sprite3(30f, 10f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		sp3b = new sprite3(410f, 170f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		sp3c = new sprite3(560f, 210f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		
		sp3a.s3 = sp3a;
		sp3b.s3 = sp3b;
		sp3c.s3 = sp3c;
		
		sp3a.sprite1.setUserData("sprite1");
		sp3b.sprite1.setUserData("sprite2");
		sp3c.sprite1.setUserData("sprite3");
		
		SpriteContainer1.add(sp3a);
		SpriteContainer1.add(sp3b);
		SpriteContainer1.add(sp3c);
		
		sp3b.single = false;
		
		/*sp1 = new sprite2(10f, 10f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		sp2 = new sprite2(140f, 111f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		sp3 = new sprite2(230f, 111f, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1);
		
		spg = new sprite2(430f, 111f, 180f, 180f, Letter2TextureReason, getVertexBufferObjectManager(),1);
		spg.sprite1.setAlpha(0.1f);
		spg.container = true;
		spg.sprite1.setZIndex(5);
		
		sp1.sp2 = sp1;
		sp2.sp2 = sp2;
		sp3.sp2 = sp3;
		spg.sp2 = spg;
		
		
		sp1.sprite1.setUserData("sprite1");
		sp2.sprite1.setUserData("sprite2");
		sp3.sprite1.setUserData("sprite3");
		spg.sprite1.setUserData("sprite4");
		
		SpriteList.add(sp1);
		SpriteList.add(sp2);
		SpriteList.add(sp3);
		SpriteList.add(spg);
		
		mCurrentScene.attachChild(sp1.sprite1);
		mCurrentScene.attachChild(sp2.sprite1);
		mCurrentScene.attachChild(sp3.sprite1);
		mCurrentScene.attachChild(spg.sprite1);
		
		mCurrentScene.sortChildren();*/
		mCurrentScene.attachChild(sp3a.sprite1);
		mCurrentScene.attachChild(sp3b.sprite1);
		mCurrentScene.attachChild(sp3c.sprite1);
		
		return mCurrentScene;
	}
	
	public static int getIndexOfSprite(Sprite s){
		
		if (MainActivity.SpriteList.contains(s)){
			return MainActivity.SpriteList.indexOf(s);
		}
		return 0; 
	}
	
	public static sprite3 getColliedobj(Sprite sp){
	    for(int i = 0;  i< SpriteContainer1.size();i++)
	    {
	    	//Log.d("chk colution ", "Size " + SpriteList.size() +"array list : " + SpriteList.get(i).sprite1.getUserData());	    	
	       if(SpriteContainer1.get(i).sprite1.collidesWith(sp) && !(SpriteContainer1.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
    		   return SpriteContainer1.get(i);
	        }
	       else if(SpriteContainer1.get(i).sprite1.collidesWith(sp) && !(SpriteContainer1.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
	    	   return SpriteContainer1.get(i);
	        }
	     }

		return null;
	}
	public static sprite2 getColliedSprite(Sprite sp){
	    for(int i = 0;  i< SpriteList.size();i++)
	    {
	    	//Log.d("chk colution ", "Size " + SpriteList.size() +"array list : " + SpriteList.get(i).sprite1.getUserData());	    	
	       if(SpriteList.get(i).sprite1.collidesWith(sp) && !(SpriteList.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
    		   return SpriteList.get(i);
	        }
	       else if(SpriteList.get(i).sprite1.collidesWith(sp) && !(SpriteList.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
	    	   return SpriteList.get(i);
	        }
	     }

		return null;
	}
	public static void makeGroup(sprite2 s1){
		mCurrentScene.detachChild(s1.sprite1);
		spg.sprite1.attachChild(s1.sprite1);
		s1.frizz = true;
		//if(spg.sprite1.getChildCount() !=0 ){
			s1.sprite1.setPosition(spg.sprite1.getChildCount()*100, spg.sprite1.getChildCount()*100);
			spg.setWidth(spg.sprite1.getChildCount()*100);
		//}
		s1.sprite1.setPosition(0f, 0f);
		
	}
	public static void reposition(){
		for(int i=0; i < spg.sprite1.getChildCount(); i++ ){
			spg.getChildByIndex(i).setPosition(2*100, 0);
			spg.setWidth(spg.sprite1.getChildCount()*100);
		}
		
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
