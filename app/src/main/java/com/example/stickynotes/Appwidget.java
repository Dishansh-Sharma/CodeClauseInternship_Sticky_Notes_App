package com.example.stickynotes;

import static android.os.Build.VERSION_CODES.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class Appwidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent launchActivity = new Intent(context, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchActivity, 0);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), com.example.stickynotes.R.layout.widget_layout);
            remoteViews.setOnClickPendingIntent(com.example.stickynotes.R.id.idTVwidget, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }

        }
}
