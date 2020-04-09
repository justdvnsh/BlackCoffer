package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.divyansh.blackcoffer.R;
import com.divyansh.blackcoffer.viewModels.SignupViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private SignupViewModel viewModel;

    @BindView(R.id.email_login)
    EditText email;
    @BindView(R.id.password_login)
    EditText password;

    GoogleSignInOptions gso;
    GoogleSignInClient googleSignInClient;

    private final int RC_SIGN_IN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        initViewModel();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
    }

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                viewModel.signinWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.i("Google sign in failed", e.getMessage());
                // ...
            }
        }
    }

    @OnClick(R.id.google_signin_login_activity)
    public void signinWithGoogle(){
        signIn();
    }

    private boolean validateFields() {
        if (email.getText().length() > 0 && password.getText().length() > 0) {
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Fill out all the fields and agree to privacy policy", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @OnClick(R.id.login_btn_loginActivity)
    public void startLogin(){
        if (validateFields()) {
            viewModel.login(email.getText().toString(), password.getText().toString());
            Toast.makeText(getApplicationContext(), "Signing Up. PLease Wait", Toast.LENGTH_SHORT).show();
            email.setText(null);
            password.setText(null);
        }
    }

    @OnClick(R.id.signup_text_login)
    public void startSignup() {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}
