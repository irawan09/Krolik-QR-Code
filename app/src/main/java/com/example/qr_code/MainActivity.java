package com.example.qr_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qr_code.RecyclerView.AssetsListActivity;

public class MainActivity extends AppCompatActivity {

    Button generator, scanner, listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generator = findViewById(R.id.generate);
        scanner = findViewById(R.id.scan);
        listData = findViewById(R.id.list);

        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, GeneratorActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ScannerResultActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        listData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AssetsListActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
