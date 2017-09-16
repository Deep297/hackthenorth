package project.hackthenorth.com.hackthenorth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterOrLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login);

        //Register and login buttons
        Button registerButton = (Button) findViewById(R.id.RegisterButton);
    }

    public void registerButtonClick(View view) {
        Intent intent = new Intent(RegisterOrLogin.this, register.class);
        startActivity(intent);
    }

    public void loginButtonClick(View view) {
        Intent intent = new Intent(RegisterOrLogin.this, login.class);
        startActivity(intent);
    }
}
