package vn.edu.hust.thangtb.aicaro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    TextView txtUsername ;
    TextView txtPassword ;
    TextView txtSignUp ;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login();

    }
    public void Login(){
         txtUsername = findViewById(R.id.username);
         txtPassword = findViewById(R.id.password);
         btn_login = findViewById(R.id.btn_login);
         txtSignUp = findViewById(R.id.txtSignUp);
         btn_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(CheckAccout(txtUsername.toString(),
                         txtPassword.toString())) MoveToActivity(SetupActivity.class);
                 else Toast.makeText(LoginActivity.this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
             }
         });
         txtSignUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 MoveToActivity(SignupActivity.class);
             }
         });



    }
    public void MoveToActivity(Class<?> cls, String ...s){
        Intent intent = new Intent(this,cls);
        if(s.length>=2) {
            intent.putExtra(s[0],s[1]);
        }
        startActivity(intent);
    }
    public boolean CheckAccout(String usr, String pass){
        //TODO
        return true;
    }
}
