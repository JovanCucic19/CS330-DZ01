package com.domaci.cs330_dz03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_KEY = "com.domaci.cs330_dz03.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prvoDugme = (Button) findViewById(R.id.btnOne);
        Button drugoDugme = (Button) findViewById(R.id.btnTwo);
        Button sledecaAktivnost = (Button) findViewById(R.id.nextActivity);
        final EditText mainEdit = (EditText) findViewById(R.id.mainTextBox);


        prvoDugme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), mainEdit.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        drugoDugme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri mapaUri = Uri.parse("https://www.google.rs/maps/@44.8299393,20.4570762,17z");
                Intent i = new Intent(Intent.ACTION_VIEW, mapaUri);
                startActivity(i);
            }
        });

        sledecaAktivnost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String poruka = "Nesto na drugoj aktivnosti";
                Intent otvoriDruguAktivnost = new Intent(MainActivity.this, DrugaAktivnost.class);
                otvoriDruguAktivnost.putExtra("MESSAGE_KEY", poruka);
                startActivity(otvoriDruguAktivnost);

            }
        });
    }


}
