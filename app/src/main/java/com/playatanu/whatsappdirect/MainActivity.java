package com.playatanu.whatsappdirect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    EditText mNumber, mMassage ;
    View cancel_button, send_btn;
    CountryCodePicker ccp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mNumber = findViewById(R.id.mNumber);
        mMassage = findViewById(R.id.mMassage);

        cancel_button = findViewById(R.id.cancel_button);
        send_btn = findViewById(R.id.send_btn);

        ccp = findViewById(R.id.countryCodeHolder);


        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String phoneNumber= ccp.getFullNumber()+ mNumber.getText().toString();
               String mainMassage = mMassage.getText().toString();



                try {

                  Uri mUri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber+ "&text="+mainMassage);

                    Intent intent = new Intent("android.intent.action.VIEW", mUri);
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                   // Toast.makeText(MainActivity.this, "Number " + phoneNumber, Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mNumber.setText("");

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"1111",Toast.LENGTH_LONG).show();
                break;
            case R.id.aboutus:
                Toast.makeText(this,"222222",Toast.LENGTH_LONG).show();
                break;
            case R.id.privacypolicy:
                Toast.makeText(this,"33333",Toast.LENGTH_LONG).show();
                break;



        }

        return super.onOptionsItemSelected(item);

    }


}