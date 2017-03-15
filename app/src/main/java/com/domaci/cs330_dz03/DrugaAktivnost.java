package com.domaci.cs330_dz03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DrugaAktivnost extends AppCompatActivity {

    boolean fit = false;
    boolean fam = false;
    boolean fdu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_aktivnost);

        Button trecaAktivnost = (Button) findViewById(R.id.nextActivity);

        trecaAktivnost.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent otvoriTrecuAktivnost = new Intent(DrugaAktivnost.this, TrecaAktivnost.class);
                startActivity(otvoriTrecuAktivnost);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuChoice(item);
    }

    private void CreateMenu(Menu menu) {
        MenuItem mnu1 = menu.add(0, 0, 0, "FIT");
        {
            mnu1.setIcon(R.mipmap.ic_launcher);
            mnu1.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM |
                            MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }
        MenuItem mnu2 = menu.add(0, 1, 1, "FAM");
        {
            mnu2.setIcon(R.mipmap.ic_launcher);
            mnu2.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM |
                            MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }
        MenuItem mnu3 = menu.add(0, 2, 2, "FDU");
        {
            mnu3.setIcon(R.mipmap.ic_launcher);
            mnu3.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM |
                            MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }
    }

    private boolean MenuChoice(MenuItem item) {

        switch (item.getItemId()) {
            case 0:
                fit = true;
                fam = false;
                fdu = false;
                return true;
            case 1:
                fam = true;
                fit = false;
                fdu = false;
                return true;
            case 2:
                fdu = true;
                fit = false;
                fam = false;
                return true;
        }
        return false;
    }

    public void btnDaAkcija(View v) {
        if (fit) {
            Toast.makeText(this, "Student ste FIT-a", Toast.LENGTH_SHORT).show();
        } else if (fam) {
            Toast.makeText(this, "Student ste FAM-a", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Student ste FDU-a", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnNeAkcija(View v) {
        if (fit) {
            Toast.makeText(this, "Niste student ste FIT-a", Toast.LENGTH_SHORT).show();
        } else if (fam) {
            Toast.makeText(this, "Niste student ste FAM-a", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Niste student ste FDU-a", Toast.LENGTH_SHORT).show();
        }

    }
}
