package com.divyansh.blackcoffer.repo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseEmailAndPassword {

    private FirebaseAuth firebaseAuth;

    public FirebaseEmailAndPassword() {
        firebaseAuth = FirebaseAuth.getInstance();
    }


}
