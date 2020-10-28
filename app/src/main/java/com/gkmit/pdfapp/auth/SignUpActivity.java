package com.gkmit.pdfapp.auth;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gkmit.pdfapp.MainActivity;
import com.gkmit.pdfapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.hasAccount) TextView SignInBtn;
    //TextViews/Input
    @BindView(R.id.editTextName)
    EditText getName;

    @BindView(R.id.editTextMobile)
    EditText getPhoneNumber;

    @BindView(R.id.editTextEmail)
    EditText getEmail;

    @BindView(R.id.editTextPassword)
    EditText getPassword;

    @BindView(R.id.registerUser)
    Button regUser;


    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();

    }
    @OnClick(R.id.hasAccount)
    public void getSignIn(View view) {
        Intent s = new Intent(this, LoginActivity.class);
        startActivity(s);

        // TODO submit data to server...
    }

    @OnClick(R.id.registerUser)
    public void regAccount (View view) {
        String email = getEmail.getText().toString();
        String password = getPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please fill in the required email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please fill in the required password",Toast.LENGTH_SHORT).show();
        }

        if(password.length()<6){
            Toast.makeText(getApplicationContext(),"Your Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"E-mail or password is wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    }
        // TODO submit data to server...




}
