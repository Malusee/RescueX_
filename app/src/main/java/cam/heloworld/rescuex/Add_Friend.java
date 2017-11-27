package cam.heloworld.rescuex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import cam.heloworld.rescuex.Adapter.ContactAdapter;
import cam.heloworld.rescuex.UI_Activities.Contact;

public class Add_Friend extends AppCompatActivity {
  Button add_friendbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__friend);
        final TextView contactView = (TextView)findViewById(R.id.my_contact_display_name);
        final TextView numberview=(TextView)findViewById(R.id.number);
        Intent contIntent = getIntent();
        String number=contIntent.getStringExtra("contact_number");
        String name=contIntent.getStringExtra("contacts_username");
        contactView.setText(name);
        numberview.setText(number);

        add_friendbtn=(Button)findViewById(R.id.add_my_friend);
        add_friendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String friend=contactView.getText().toString();
                Intent addfrndIntent= new Intent(Add_Friend.this, Friends.class);
                addfrndIntent.putExtra("my_friend", friend);
                startActivity(addfrndIntent);
            }
        });




    }
}
