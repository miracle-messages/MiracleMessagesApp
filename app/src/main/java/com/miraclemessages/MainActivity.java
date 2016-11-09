package com.miraclemessages;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText textName, textEmail, textPhone, textLocation;
    Button submit;
    public static final String myPreferences = "MyPreferences";
    public static final String Name = "name";
    public static final String Email = "email";
    public static final String Phone = "phone";
    public static final String Location = "location";
    LinearLayout homeback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeback = (LinearLayout) findViewById(R.id.homeback);
        homeback.setBackgroundResource(R.drawable.homeback);
        homeback.getBackground().setAlpha(120);
        textName=(EditText)findViewById(R.id.name);
        textEmail=(EditText)findViewById(R.id.email);
        textPhone=(EditText)findViewById(R.id.phone_number);
        textLocation=(EditText)findViewById(R.id.location);

        submit=(Button)findViewById(R.id.submit);
        //Log.v("Tits: ", "Niqqa");
        sharedpreferences = getSharedPreferences(myPreferences,
                Context.MODE_PRIVATE);

        if(sharedpreferences.getString(Name, null) != null
                && sharedpreferences.getString(Email, null) != null
                && sharedpreferences.getString(Phone, null) != null
                && sharedpreferences.getString(Location, null) != null)
            startActivity(new Intent(MainActivity.this, PreCameraActivity.class));

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String n = textName.getText().toString();
                if(n.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Please fill out all fields.",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                String e = textEmail.getText().toString();
                if(e.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Please fill out all fields.",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                String p = textPhone.getText().toString();
                if(p.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Please fill out all fields.",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                String l = textLocation.getText().toString();
                if(l.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Please fill out all fields.",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Email, e);
                editor.putString(Phone, p);
                editor.putString(Location, l);

                editor.commit();

                Toast.makeText(MainActivity.this,"Thank you!", Toast.LENGTH_LONG).show();
                Log.v("Bonjourno: ", "Hoe");
                startActivity(new Intent(MainActivity.this, PreCameraActivity.class));
            }
        });
    }


}