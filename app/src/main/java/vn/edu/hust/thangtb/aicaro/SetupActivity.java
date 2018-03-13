package vn.edu.hust.thangtb.aicaro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SetupActivity extends AppCompatActivity {
    Button btnGo;
    RadioButton rbX, rbO, rbP,rbAI;
    int firstPlayer=0;
    int shape=0;
    boolean checkFP=false;
    boolean checkXO=false;
    // 0 may, 1 nguoi
    // neu ng chon X : 3, neu ng chon Y 4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        rbX = findViewById(R.id.rbX);
        rbO = findViewById(R.id.rbO);
        rbP = findViewById(R.id.rbP);
        rbAI = findViewById(R.id.rbAI);
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbX.isChecked() || rbO.isChecked()){
                    checkXO=true;
                    if(rbX.isChecked()) shape =3;
                    else shape=4;
                }
                 if(rbP.isChecked() || rbAI.isChecked()){
                    checkFP=true;
                    if(rbAI.isChecked()) firstPlayer =0;
                    else firstPlayer=1;
                }
                Toast.makeText(SetupActivity.this,checkFP+"  "+checkXO,Toast.LENGTH_LONG).show();;
                if(checkXO && checkFP) {
                    MoveToActivity(MainActivity.class, "fistPlayer", firstPlayer + "", "shape", shape + "");
                }
            }
        });


    }
    public void MoveToActivity(Class<?> cls, String ...s){
        Intent intent = new Intent(this,cls);
        Bundle bundle = new Bundle();
        if(s.length>=2) {
            bundle.putString(s[0],s[1]);
        }
        if(s.length>=4)  bundle.putString(s[2],s[3]);
        intent.putExtra("SetUp",bundle);
        startActivity(intent);
    }
}
