package com.example.animatedbook2;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.content.Entity;
import android.util.Log;
import android.view.Display;

public class BaseActivity extends SimpleBaseGameActivity {
	public static int CAMERA_HIGHT;
	public static int CAMERA_WIDTH;
	public static Camera mCamera;
	static float ImageWidth;
	static float ImageHight;
	
	
	int NextCount=1;
	static boolean ArrowTouchEnable = false;
	
	static float ImagePosX;
	static float ImagePosY;
	
	//Background 
	public static BuildableBitmapTextureAtlas BgBuildableBitmapTextureAtlas;
	public static ITextureRegion BgTextureReason;
	public static ITextureRegion SpriteBgTextureReason;
	public static Scene mMainScene;
	public static Sprite BgSprite;
	public static Sprite NextSprite;
	public static Sprite SpriteBg;
	
	//Letters 
	public static BuildableBitmapTextureAtlas LetterBuildableBitmapTextureAtlas;
	
	//Letter images 1 Aaa
	public static ITextureRegion MangoTextureReason;
	public static ITextureRegion AppleTextureReason;
	public static ITextureRegion GingerTextureReason;
	public static ITextureRegion PineappleTextureReason;
	public static ITextureRegion PotatoTextureReason;
	public static ITextureRegion SkyTextureReason;
	
	//Letter images 2 Moo
	public static BuildableBitmapTextureAtlas Letter2BuildableBitmapTextureAtlas;
	public static ITextureRegion MaTextureReason;
	public static ITextureRegion MamaTextureReason;
	public static ITextureRegion MoiTextureReason;
	public static ITextureRegion MeghTextureReason;
	public static ITextureRegion MulaTextureReason;
	public static ITextureRegion MohisTextureReason;
	
	//Letter images 3 Taa
	public static BuildableBitmapTextureAtlas Letter3BuildableBitmapTextureAtlas;
	public static ITextureRegion SelfTextureReason;
	public static ITextureRegion TalTextureReason;
	public static ITextureRegion TalaTextureReason;
	public static ITextureRegion TaraTextureReason;
	public static ITextureRegion TuliTextureReason;
	public static ITextureRegion TamaTextureReason;
	
	//Letter images 4 Laa
	public static BuildableBitmapTextureAtlas Letter4BuildableBitmapTextureAtlas;
	public static ITextureRegion LalTextureReason;
	public static ITextureRegion LangolTextureReason;
	public static ITextureRegion LataTextureReason;
	public static ITextureRegion LatimTextureReason;
	public static ITextureRegion LauuTextureReason;
	public static ITextureRegion LebuTextureReason;
	
	//Letter images 5 Ko
	public static BuildableBitmapTextureAtlas Letter5BuildableBitmapTextureAtlas;
	public static ITextureRegion KakTextureReason;
	public static ITextureRegion KaramTextureReason;
	public static ITextureRegion KolaTextureReason;
	public static ITextureRegion KolTextureReason;
	public static ITextureRegion KolomTextureReason;
	public static ITextureRegion KomlaTextureReason;
	
	//Next Arrow
	public static ITextureRegion NextTextureReason;
	
	//Parrot image Flying
	public BitmapTextureAtlas ParrotBitmapTextureAtlus;
	public static TiledTextureRegion ParrotTextureReason;

	//Letter 
	public static BuildableBitmapTextureAtlas LetterAllBuildableBitmapTextureAtlas;
	public static ITextureRegion LetterKoTextureReason;
	public static ITextureRegion LetterMoTextureReason;
	public static ITextureRegion LetterLaTextureReason;
	public static ITextureRegion LetterToTextureReason;
	public static ITextureRegion LetterAaaTextureReason;
	
	
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		
		ImageHight = CAMERA_HIGHT/2.5f;
		ImageWidth = CAMERA_WIDTH/4.5f;
		
		ImagePosX = CAMERA_WIDTH/100;
		ImagePosY = CAMERA_HIGHT/20;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HIGHT);		
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HIGHT), mCamera);
	}
	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		BgBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1800, 1432,TextureOptions.DEFAULT);
		this.BgTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "jungle16.png");
		
		//Letter Image
		LetterBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1400, 900,TextureOptions.DEFAULT);
		
		this.SpriteBgTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "spritebg.png");
		
		this.MangoTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/mango2.png");
		this.AppleTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/apple.png");
		this.GingerTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/ginger.png");
		this.PineappleTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/pineapple.png");
		this.PotatoTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/potato.png");
		this.SkyTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/sky.png");
		this.NextTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "arrow_right.png");
		
		//Letter Group 2 Moo
		Letter2BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		this.MaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/ma.png");
		this.MamaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mama.png");
		this.MulaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mula.png");
		this.MeghTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/megh.png");
		this.MoiTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/moi.png");
		this.MohisTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mohis.png");
		
		//Letter Group 3 Taa 
		Letter3BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1300, 800,TextureOptions.DEFAULT);
		this.SelfTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/shelfe.png");
		this.TalTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tal.png");
		this.TalaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tala.png");
		this.TaraTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tara.png");
		this.TuliTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tulee.png");
		this.TamaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tama.png");
				
		//Letter Group 4 Laa
		Letter4BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		this.LalTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lal.png");
		this.LangolTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/langol.png");
		this.LataTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lata.png");
		this.LatimTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/latim.png");
		this.LauuTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lauu.png");
		this.LebuTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lebu.png");
								
		//Letter Group 5 Ko
		Letter5BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		this.KakTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kak.png");
		this.KaramTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/karam.png");
		this.KolTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kol.png");
		this.KolaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kola.png");
		this.KolomTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kolom.png");
		this.KomlaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/komla.png");
					
		// Letter All 
		LetterAllBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1200, 1200,TextureOptions.DEFAULT);
		this.LetterKoTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp5/letter_ko.png");
		this.LetterMoTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp2/letter_mo.png");
		this.LetterLaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp4/letter_lo.png");
		this.LetterToTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp3/letter_to.png");
		this.LetterAaaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp1/letter_aa.png");
		//this.LetterAaaTextureReason = this.LetterToTextureReason;
		
		
		ParrotBitmapTextureAtlus = new BitmapTextureAtlas(this.getTextureManager(), 900, 228,TextureOptions.DEFAULT);
		this.ParrotTextureReason = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(ParrotBitmapTextureAtlus, this, "sprite_parrot4.png",0,0,8,2);
		
		
		try {
			BgBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			BgBuildableBitmapTextureAtlas.load();
			
			LetterBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			LetterBuildableBitmapTextureAtlas.load();
			Letter2BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter2BuildableBitmapTextureAtlas.load();
			Letter3BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter3BuildableBitmapTextureAtlas.load();
			Letter4BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter4BuildableBitmapTextureAtlas.load();
			Letter5BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter5BuildableBitmapTextureAtlas.load();
			LetterAllBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			LetterAllBuildableBitmapTextureAtlas.load();
			
			
			//ParrotBitmapTextureAtlus.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			ParrotBitmapTextureAtlus.load();
			
			
			//bgbitmapTextureAtlas.load();

		} catch (TextureAtlasBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected Scene onCreateScene() {
		
		mEngine.registerUpdateHandler(new FPSLogger());
		mMainScene = new Scene();
		mMainScene.setTouchAreaBindingOnActionMoveEnabled(true);
		
		BgSprite = new Sprite(0, 0, BgTextureReason,this.getVertexBufferObjectManager());
		BgSprite.setHeight(CAMERA_HIGHT);
		BgSprite.setWidth(CAMERA_WIDTH);
		mMainScene.attachChild(BgSprite);
		
		//String d= "On Create Sprite";
		//Mango Image
		//Log.d(d,"Width : " + CAMERA_WIDTH + "Hight : " + CAMERA_HIGHT );
						
		loadImage1(MangoTextureReason,R.raw.mama);
		loadImage2(AppleTextureReason,R.raw.mama);
		loadImage3(GingerTextureReason,R.raw.mama);
		loadImage4(PineappleTextureReason,R.raw.mama);
		loadImage5(PotatoTextureReason,R.raw.mama);
		loadImage6(SkyTextureReason,R.raw.mama);
		loadParrotAndNext(ParrotTextureReason,NextTextureReason,LetterAaaTextureReason);
		//CAMERA_WIDTH + 200,CAMERA_WIDTH - 250, CAMERA_HIGHT / 2 -30,CAMERA_HIGHT / 2 - 80
		return mMainScene;
	}
	  void nextStage(int stage){
		if(stage == 2){
			
			loadImage1(MamaTextureReason,R.raw.mama);
			loadImage2(MaTextureReason,R.raw.mama);
			loadImage3(MohisTextureReason,R.raw.mama);
			loadImage4(MulaTextureReason,R.raw.mama);
			loadImage5(MoiTextureReason,R.raw.mama);
			loadImage6(MeghTextureReason,R.raw.mama);
			loadParrotAndNext(ParrotTextureReason,NextTextureReason,LetterMoTextureReason);
		}
		if(stage == 3){
			Letter2BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			Log.d("TitledImage", " In 3 ");
			loadImage1(SelfTextureReason,R.raw.mama);
			loadImage2(TalTextureReason,R.raw.mama);
			loadImage3(TalaTextureReason,R.raw.mama);
			loadImage4(TaraTextureReason,R.raw.mama);
			loadImage5(TuliTextureReason,R.raw.mama);
			loadImage6(TamaTextureReason,R.raw.mama);
			loadParrotAndNext(ParrotTextureReason,NextTextureReason,LetterToTextureReason);
		}
		if(stage == 4){
			Letter3BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			Log.d("TitledImage", " In 4 ");
			loadImage1(LalTextureReason,R.raw.mama);
			loadImage2(LangolTextureReason,R.raw.mama);
			loadImage3(LataTextureReason,R.raw.mama);
			loadImage4(LatimTextureReason,R.raw.mama);
			loadImage5(LauuTextureReason,R.raw.mama);
			loadImage6(LebuTextureReason,R.raw.mama);
			loadParrotAndNext(ParrotTextureReason,NextTextureReason,LetterLaTextureReason);
		}
		if(stage == 5){
			Letter3BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			Log.d("TitledImage", " In 5 ");
			loadImage1(KakTextureReason,R.raw.mama);
			loadImage2(KaramTextureReason,R.raw.mama);
			loadImage3(KolTextureReason,R.raw.mama);
			loadImage4(KolaTextureReason,R.raw.mama);
			loadImage5(KolomTextureReason,R.raw.mama);
			loadImage6(KomlaTextureReason,R.raw.mama);
			loadParrotAndNext(ParrotTextureReason,NextTextureReason,LetterKoTextureReason);
		}
	}
	
	void loadImage1(ITextureRegion r1, int voice){
		TiledImage t1 = new TiledImage(ImagePosX, ImagePosY, ImageWidth , ImageHight, r1, this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t1.Letter);
		mMainScene.attachChild(t1.Letter);

		t1.detachSelf();
	}
	
	void loadImage2(ITextureRegion r1, int voice){
		TiledImage t2 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.22f), ImagePosY, ImageWidth , ImageHight, r1, this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t2.Letter);
		mMainScene.attachChild(t2.Letter);
		t2.detachSelf();
	}
	
	void loadImage3(ITextureRegion r1,int voice){
		TiledImage t3 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.44f), ImagePosY, ImageWidth , ImageHight, r1, this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t3.Letter);
		mMainScene.attachChild(t3.Letter);
		
		t3.detachSelf();
	}
	
	void loadImage4(ITextureRegion r1,int voice){
		TiledImage t4 = new TiledImage(ImagePosX, ImagePosY+(CAMERA_HIGHT*0.44f), ImageWidth , ImageHight,r1 , this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t4.Letter);
		mMainScene.attachChild(t4.Letter);
		
		t4.detachSelf();
	}
	
	void loadImage5(ITextureRegion r1, int voice){
		TiledImage t5 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.22f), ImagePosY+(CAMERA_HIGHT*0.44f), ImageWidth , ImageHight, r1, this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t5.Letter);
		mMainScene.attachChild(t5.Letter);
		
		t5.detachSelf();
	}
	
	void loadImage6(ITextureRegion r1 , int voice){
		TiledImage t6 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.44f), ImagePosY+(CAMERA_HIGHT*0.44f), ImageWidth , ImageHight, r1, this.getVertexBufferObjectManager(),voice,getApplicationContext());
		mMainScene.registerTouchArea(t6.Letter);
		mMainScene.attachChild(t6.Letter);
		
		t6.detachSelf();
	}
	
	//Loading parrot and Next arrow 
	void loadParrotAndNext(TiledTextureRegion p , ITextureRegion n,ITextureRegion l){
		Parrot p1 = new Parrot(CAMERA_WIDTH + 200,CAMERA_WIDTH - 250, CAMERA_HIGHT / 2 ,CAMERA_HIGHT / 2, p, this.getVertexBufferObjectManager(), R.raw.mama, getApplicationContext(),l);
		mMainScene.registerTouchArea(p1.parrotFlying);
		mMainScene.attachChild(p1.parrotFlying);
		createNextArrow(CAMERA_WIDTH-100f, CAMERA_HIGHT-100f, 200f, 200f, n, 1);
		mMainScene.registerTouchArea(this.NextSprite);
		mMainScene.attachChild(this.NextSprite);
		mMainScene.attachChild(p1.mLetter);
	}
	void createNextArrow(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion, int voice){
		this.NextSprite = new Sprite(pX, pY, pTextureRegion, this.getVertexBufferObjectManager()){
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
						if(ArrowTouchEnable){
							ArrowTouchEnable = false;
							Log.d("next", "up ");
							BaseActivity.mMainScene.detachChildren();
							mMainScene.attachChild(BgSprite);
							TiledImage.ObjNo = 0;
							NextCount++;
							nextStage(NextCount);
						}
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
