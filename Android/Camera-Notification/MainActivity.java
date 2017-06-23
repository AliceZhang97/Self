import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button myButton;
    CameraReceiver cr = new CameraReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Camera Filter
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CAMERA_BUTTON);
        Log.i("MainActivity", "Action Camera Button");
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        registerReceiver(cr, intentFilter);

        myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent();
                cameraIntent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(cameraIntent);
                Log.i("MainActivity", "onClick");
            }
        });
    }

}
