package com.china.calendar;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.Toast;

import com.china.calendar.util.ConfigCenter;
import com.china.calendar.util.Constant;

public class MainActivity extends Activity {
	
	private WebView webView;
	
	private String contentUri = "file:///android_asset/calendar.html";
	
	private Handler mHandler = new Handler();  
	
	private Timer timer = new Timer();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        webView = (WebView)this.findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);        
//        webView.addJavascriptInterface(new Object() {  
//            public String setVal(double year, double month) { 
//            	MainActivity.this.year = year;
//            	MainActivity.this.month = month;
//            	return "resource type is " + year + " and id is " + month;
//             }
//            public double getYear() { 
//            	return MainActivity.this.year;
//             }
//            public double getMonth() { 
//            	return MainActivity.this.month;
//             }
//            }, "demo");
        
                        
//        webView.addJavascriptInterface(new Object() {  
//            public void clickOnAndroid() {  
//                mHandler.post(new Runnable() {  
//                	public void run() {  
//                    	webView.loadUrl("javascript:pushBtm('MU')");  
//                    	webView.loadUrl("javascript:pushBtm('MD')"); 
//                    }
//                });  
//            }  
//        }, "demo");  
        
        
        
        webView.loadUrl(contentUri);
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        
        webView.loadUrl("javascript:pushBtm('MU')");  
    	webView.loadUrl("javascript:pushBtm('MD')"); 
    	

    	if(!ConfigCenter.getValue(this, Constant.KEY_WIDGET_ADDED, false)){ 
    		Toast.makeText(MainActivity.this, "温馨提示：您还可以添加桌面小部件显示漂亮的日历！", Toast.LENGTH_LONG).show();
    	}
    	
        
    }
    
}