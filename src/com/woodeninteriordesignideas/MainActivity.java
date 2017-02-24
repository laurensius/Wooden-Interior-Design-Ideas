package com.woodeninteriordesignideas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	WebView webViewContent;
	Dialog dialogExit;
	Button btnExitYa, btnExitTidak;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		WebView webViewContent = (WebView)findViewById(R.id.webViewContent);
		webViewContent.getSettings().setJavaScriptEnabled(true);
		webViewContent.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		String uriSplashScreen = getResources().getString(R.string.uri_content).toString();
		webViewContent.loadUrl(uriSplashScreen);
	}
	
	@Override
	public void onBackPressed(){
		keluarAplikasi();
	}
	
	void keluarAplikasi(){		
		dialogExit = new Dialog(MainActivity.this);
		dialogExit.setContentView(R.layout.activity_dialogexit);
		dialogExit.setTitle("Quit Application");
		btnExitYa = (Button) dialogExit.findViewById(R.id.btnExitYa);
		btnExitTidak = (Button) dialogExit.findViewById(R.id.btnExitTidak);
		dialogExit.show();
		
		btnExitYa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		btnExitTidak.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialogExit.dismiss();
			}
		});
	}
}
