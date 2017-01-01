package com.example.vickymahendra.aplikasi;
/**
 * Created by Vicky Mahendra on 12/31/2016.
 */


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    //Defining views
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Context context;
    private AppCompatButton buttonLogin,buttonregistrasi;
    private ProgressDialog pDialog;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = Login.this;
        sessionManager = new SessionManager(getApplicationContext());

        //Initializing views
        pDialog = new ProgressDialog(context);
        editTextEmail = (EditText) findViewById(R.id.eEmail);
        editTextPassword = (EditText) findViewById(R.id.ePassword);

        buttonLogin = (AppCompatButton) findViewById(R.id.buttonLogin);
        buttonregistrasi = (AppCompatButton) findViewById(R.id.buttonregistrasi);
        //Adding click listener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        buttonregistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideDialog();
                gotoregister();
            }
        });
        //editTextEmail.setText("admin@agusharyanto.net");
        //editTextPassword.setText("abcd1234");
    }

    private void login() {
        //Getting values from edit texts
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        pDialog.setMessage("Login Process...");
        showDialog();
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppVar.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server
                        if (response.contains(AppVar.LOGIN_SUCCESS)) {
                            sessionManager.createSession(editTextEmail.getText().toString());
                            hideDialog();
                            gotoBeranda();

                        } else {
                            hideDialog();
                            //Displaying an error message on toast
                            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        hideDialog();
                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(AppVar.KEY_EMAIL, email);
                params.put(AppVar.KEY_PASSWORD, password);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void gotoBeranda() {
        Intent intent = new Intent(context, Beranda.class);
        startActivity(intent);
        finish();
    }
    private void gotoregister() {
        Intent intent = new Intent(context, Registrasi.class);
        startActivity(intent);
        finish();
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}


