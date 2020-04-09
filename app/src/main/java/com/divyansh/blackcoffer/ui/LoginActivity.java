package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.divyansh.blackcoffer.R;
import com.divyansh.blackcoffer.viewModels.SignupViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private SignupViewModel viewModel;

    @BindView(R.id.email_login)
    EditText email;
    @BindView(R.id.password_login)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        initViewModel();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
    }

    @OnClick(R.id.login_btn_loginActivity)
    public void startLogin(){
        if (email.getText().toString() == "") {
            Toast.makeText(getApplicationContext(), "Fill Out Fields", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.login(email.getText().toString(), password.getText().toString());
        }
    }

    @OnClick(R.id.signup_text_login)
    public void startSignup() {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}
