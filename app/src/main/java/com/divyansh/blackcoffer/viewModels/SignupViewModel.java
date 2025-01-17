package com.divyansh.blackcoffer.viewModels;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.divyansh.blackcoffer.ui.MainActivity;
import com.divyansh.blackcoffer.ui.PhoneNumberActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignupViewModel extends AndroidViewModel {

    private FirebaseAuth firebaseAuth;

    public SignupViewModel(@NonNull Application application) {

        super(application);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void signUp(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i("Task->", String.valueOf(task.isComplete()));
                        Log.i("Succesfull->", String.valueOf(task.isSuccessful()));
                        if (task.isComplete()) {
                            getApplication().startActivity(new Intent(getApplication().getApplicationContext(), PhoneNumberActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        } else {
                            Log.i("Error->", task.toString());
                        }
                    }
                });
    }

    public void login(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            getApplication().startActivity(new Intent(getApplication().getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                    }
                });
    }

    public void signinWithGoogle(GoogleSignInAccount account) {
        AuthCredential creds = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(creds)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            getApplication().startActivity(new Intent(getApplication(), PhoneNumberActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                    }
                });
    }
}
