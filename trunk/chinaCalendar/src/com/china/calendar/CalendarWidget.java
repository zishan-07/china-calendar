package com.china.calendar;


import java.util.Calendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class CalendarWidget extends AppWidgetProvider {
	
	private int lastDay;
	
	private int lastHour;
	
	private static RemoteViews views;
	

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            Log.i("ID", ""+i+":"+appWidgetId);
            updateAppWidget(context, appWidgetManager,appWidgetId);
        }
       
	}

	public static void updateAppWidget(Context context,
			AppWidgetManager appWidgetManager,int appWidgetId) {
		 
		if(views == null){
			views = new RemoteViews(context.getPackageName(),R.layout.my_widget);
			
			// 创建一个Intent来启动 ExampleActivity
			Intent intent = new Intent(context, MainActivity.class);
			PendingIntent pendingIntent =PendingIntent.getActivity(context, 0, intent, 0);
			views.setOnClickPendingIntent(R.id.my_widget, pendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
		  
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		
			views.setTextViewText(R.id.top1, "2010-6-6 周日");
			views.setTextViewText(R.id.top2,"农历：2010/5/12");
		
		
		
	}
	
	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
	}
	
	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
	}

}
