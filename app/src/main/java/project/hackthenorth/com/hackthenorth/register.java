package project.hackthenorth.com.hackthenorth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {

    private EditText emailText;
    private EditText passText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
    }

    public void createAccount(View view) {
        //EditText
        emailText = (EditText) findViewById(R.id.emailRegister);
        passText = (EditText) findViewById(R.id.passwordRegister);

        if (!validateForm()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailText.getText().toString(), passText.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Sign up successful
                    Intent intent = new Intent(register.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    //Invalid sign up
                    Toast.makeText(register.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClick(View view) {
        //EditText
        emailText = (EditText) findViewById(R.id.emailRegister);
        passText = (EditText) findViewById(R.id.passwordRegister);


    }

    private boolean validateForm () {
        //Validates form and sets error if incorrect
        boolean valid = true;

        String email = emailText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Required.");
            valid = false;
        } else {
            emailText.setError(null);
        }

        String password = passText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passText.setError("Required.");
            valid = false;
        } else {
            passText.setError(null);
        }

        return valid;
    }


}
