package vn.edu.hust.thangtb.aicaro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
     TextView txtUsername ;
    TextView txtPassword ;
    TextView txtEmail ;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SignUp();
    }
    public void SignUp(){
        txtUsername = findViewById(R.id.username);
        txtPassword = findViewById(R.id.password);
        txtEmail = findViewById(R.id.email);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString().trim();
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (SaveAccount(username, email, password)) {
                    MoveToActivity(SetupActivity.class);
                }

            }
        });
    }
    public boolean SaveAccount(String ...s){
                //TODO

        return true;
    }
    public void MoveToActivity(Class<?> cls, String ...s){
        Intent intent = new Intent(this,cls);
        if(s.length>=2) {
            intent.putExtra(s[0],s[1]);
        }
        startActivity(intent);
    }
}
