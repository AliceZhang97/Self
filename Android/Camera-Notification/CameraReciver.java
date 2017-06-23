import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by peter on 6/16/2017.
 */

public class CameraReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("CameraReciver","onreceive");

        Cursor cursor = context.getContentResolver().query(intent.getData(), null, null, null, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex("_data"));
        Toast.makeText(context, "New Photo is Saved as : " + path, Toast.LENGTH_LONG)
                .show();
        addNotification(context);
    }

    /* add image to res/drawable */
    private void addNotification(Context ctx) {
        Bitmap btm = BitmapFactory.decodeResource(ctx.getResources(),
                R.drawable.image);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                ctx).setSmallIcon(R.drawable.image)
                .setContentTitle("1 new picture")
                .setContentText("Click to View");
        mBuilder.setLargeIcon(btm);
        mBuilder.setAutoCancel(true);

        Intent resultIntent = new Intent(ctx,
                NotificationActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                ctx, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }

}
