package cam.heloworld.rescuex;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignConfirm extends Login {
    Button logNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signconfirm_layout);
        logNext=(Button)findViewById(R.id.log_next);
        logNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logNextClick= new Intent(SignConfirm.this, MenuActivity.class);
                logNextClick.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logNextClick);
                finish();
            }
        });
    }
}
