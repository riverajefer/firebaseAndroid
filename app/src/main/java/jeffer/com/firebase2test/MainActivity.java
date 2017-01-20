package jeffer.com.firebase2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Switch mySwitch;
    Switch mySwitch2;
    DatabaseReference myRefLed1, myRefLed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        myRefLed1 = database.getReference("home/led1");
        myRefLed2 = database.getReference("home/led2");

        mySwitch = (Switch)findViewById(R.id.mySwitch);
        mySwitch2 = (Switch)findViewById(R.id.mySwitch2);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            myRefLed1.setValue(isChecked);
            if (isChecked) {
                mySwitch.setText("Led 1 On");
            } else {
                mySwitch.setText("Led 1 Off");
            }
            }
        });

        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                myRefLed2.setValue(isChecked);
                if (isChecked) {
                    mySwitch2.setText("Led 2 On");
                } else {
                    mySwitch2.setText("Led 2 Off");
                }
            }
        });

    }
}
