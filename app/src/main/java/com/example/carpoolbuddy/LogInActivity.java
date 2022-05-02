package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogInActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private String selected;

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(mAuth.getCurrentUser()!=null) {
//            updateUI(mAuth.getCurrentUser());
//        }
//    }

    public void logIn(View v)
    {
        System.out.println("log in");
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        System.out.println(email+" "+password);

    }

//    public void signUp(View v)
//    {
//        System.out.println("sign up");
//        String email = this.email.getText().toString();
//        String password = this.password.getText().toString();
//
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    Log.d("Sign up", "Succesfully signed up the user");
//
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    updateUI(user);
//                } else
//                {
//                    Log.w("Sign up", "createUserWithEmail:failure", task.getException());
//
//                    updateUI(null);
//                }
//            }
//
//        });
//    }

    public void signUp2(View v)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void updateUI(FirebaseUser currentUser)
    {
        if(currentUser != null)
        {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         String text = parent.getItemAtPosition(position).toString();
         Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}