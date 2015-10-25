package barqsoft.footballscores;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScoresWidgetProvider
 * Created by bp on 10/25/15.
 */

public class ScoresWidgetProvider extends AppWidgetProvider {

    //public static final String LOG_TAG = ScoresWidgetProvider.class.getSimpleName();
    private static final String SCORES_BY_DATE =
            DatabaseContract.scores_table.DATE_COL + " LIKE ?";
    public static int nextIndex = -1;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int count = appWidgetIds.length;

        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String[] fragmentdate = new String[1];
            fragmentdate[0] = dateFormat.format(new Date());
            ScoresDBHelper mOpenHelper = new ScoresDBHelper(context);
            Cursor cursor = mOpenHelper.getReadableDatabase().query(
                    DatabaseContract.SCORES_TABLE,
                    null, SCORES_BY_DATE, fragmentdate, null, null, null);
            nextIndex++;
            if (nextIndex >= cursor.getCount())
            {
                nextIndex = 0;
            }

            cursor.moveToPosition(nextIndex);

            String homeTeamName = cursor.getString(3);
            int homeGoals = Math.max(cursor.getInt(6), 0);
            String visitorTeamName = cursor.getString(4);
            int visitorGoals = Math.max(cursor.getInt(7), 0);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.scores_widget);
            remoteViews.setTextViewText(R.id.homeTextView, Integer.toString(homeGoals) + " " + homeTeamName);
            remoteViews.setTextViewText(R.id.visitorTextView, Integer.toString(visitorGoals) + " " + visitorTeamName);

            Intent intent = new Intent(context, ScoresWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.actionButton, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

}
