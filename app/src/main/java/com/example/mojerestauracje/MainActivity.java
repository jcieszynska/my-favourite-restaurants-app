package com.example.mojerestauracje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mojerestauracje.R;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button login;
    public EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.loginBtn);
        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.pwdEditText);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    //zalogowany
                    Log.d("Uwaga", "Użytkownik jest zalogowany");
                } else {
                    //niezalogowany
                    Log.d("Uwaga", "Użytkownik nie jest zalogowany");
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailToString = email.getText().toString();
                String pwdToString = password.getText().toString();
                if(!emailToString.equals("") && !pwdToString.equals("")) {
                    mAuth.signInWithEmailAndPassword(emailToString,pwdToString).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Logowanie nie powiodło się.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
                                startActivity(intent);

                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Wprowadź dane logowania", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
