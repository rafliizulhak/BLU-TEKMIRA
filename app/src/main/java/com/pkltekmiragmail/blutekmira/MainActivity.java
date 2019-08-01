package com.pkltekmiragmail.blutekmira;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_batubara = (ImageView)findViewById(R.id.batubaraHome);
        ImageView iv_mineral = (ImageView)findViewById(R.id.mineralHome);
        ImageView iv_tambang = (ImageView)findViewById(R.id.tambangHome);
        ImageView iv_lab = (ImageView)findViewById(R.id.labHome);

        iv_batubara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, batubara.class));
            }
        });
        iv_mineral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, mineral.class));
            }
        });
        iv_tambang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tambang.class));
            }
        });
        iv_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, lab.class));
            }
        });
    }
}
