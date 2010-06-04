package com.china.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;

public class MainActivity extends Activity {
	
	private WebView webView;
	
	private String contentUri = "file:///android_asset/calendar.html";
	
	private Handler mHandler = new Handler();  
	
	private double year = -1;
	
	private double month = -1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        webView = (WebView)this.findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        
        webView.addJavascriptInterface(new Object() {  
            public String setVal(double year, double month) { 
            	MainActivity.this.year = year;
            	MainActivity.this.month = month;
            	return "resource type is " + year + " and id is " + month;
             }
            public double getYear() { 
            	return MainActivity.this.year;
             }
            public double getMonth() { 
            	return MainActivity.this.month;
             }
            }, "demo");
        
        webView.loadUrl(contentUri);
        
    }
}