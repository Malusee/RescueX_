package cam.heloworld.rescuex;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FlashLight extends AppCompatActivity {
ImageButton imageButton;
    Camera camera;
    Camera.Parameters parameters;
    boolean isflash=false;
    boolean isOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        imageButton=(ImageButton)findViewById(R.id.flashbtn);
        if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){

            camera=Camera.open();
            parameters=camera.getParameters();
            isflash=true;
        }
     imageButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             if (isflash){

                 if (!isOn){
                     imageButton.setImageResource(R.drawable.off);
                     parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                     camera.setParameters(parameters);
                     camera.startPreview();
                     isOn=true;
                 }
                 else{
                     imageButton.setImageResource(R.drawable.on_ic);
                     parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                     camera.setParameters(parameters);
                     camera.stopPreview();
                     isOn=false;
                 }

             }
             else{
                 AlertDialog.Builder builder= new AlertDialog.Builder(FlashLight.this);
                 builder.setTitle("Error....");
                 builder.setMessage("FlashLight is not available for this device...");
                 builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                         finish();
                     }
                 });
                 AlertDialog alertDialog= builder.create();
                 alertDialog.show();
             }
         }
     });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera!=null){
            camera.release();
            camera=null;

        }
    }
}
