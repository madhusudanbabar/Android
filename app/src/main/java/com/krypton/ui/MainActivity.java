package com.krypton.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button cb,tt;
    TextView disp ;
    public static int count = 0;
    String tbd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp = (TextView) findViewById(R.id.display);
        disp.setText(getString(R.string.c).replace("%1$d",String.valueOf(count)));
        cb = (Button) findViewById(R.id.count);
        tbd = getResources().getString(R.string.c);
        tt = (Button) findViewById(R.id.button);

        tt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reset(v);
                return false;
            }
        });

        disp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reset(v);
                msg("long clicked");
                return false;
            }
        });

    }


    public void update(View v) {
        count++;
        disp.setText(getString(R.string.c,count));

    }

    public void reset(View v)
    {
        count=0;
        disp.setText(getString(R.string.c,count));
        msg("counter reset");
    }

    public void toast(View v)
    {
        msg(getString(R.string.c,count));
    }

    public void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
    }
}