package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  EditText distance = findViewById(R.id.distance);
        final  EditText time = findViewById(R.id.time);

        Button cal = findViewById(R.id.cal);
        Button clear = findViewById(R.id.clear);
        final TextView show = findViewById(R.id.show);

        cal.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {
                String d =distance.getText().toString();
                String t =time.getText().toString();

                if(d.length()==0 ||t.length()==0 ){
                    Toast tos = Toast.makeText(
                            MainActivity.this,
                            R.string.fieldrequire,
                            Toast.LENGTH_LONG
                    );
                    tos.show();

                }
                else{
                    double z = Double.parseDouble(t);
                    if(z==0){
                        Toast tos = Toast.makeText(
                                MainActivity.this,
                                R.string.greaterthan,
                                Toast.LENGTH_LONG
                        );
                        tos.show();
                    }
                    else{
                        double realtime = z*100;
                        double realdistance = Double.parseDouble(d);
                        double speed =(( (realdistance/realtime)*100 )*3.6);
                         show.setText(String.format("%.2f",speed));
                    }



                }


            }
        });

        //String d = distance.getText().toString();



       // String t = time.getText().toString();



    }
}