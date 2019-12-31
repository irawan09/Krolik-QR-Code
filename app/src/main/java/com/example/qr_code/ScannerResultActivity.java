package com.example.qr_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qr_code.RecyclerView.DetailsAssetsActivity;

public class ScannerResultActivity extends AppCompatActivity {

    public static TextView tvresult;
    private Button btn, showdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_result);

        tvresult = findViewById(R.id.tvresult);
        btn = findViewById(R.id.btn);
        showdata = findViewById(R.id.show_data);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScannerResultActivity.this, ScannerActivity.class);
                startActivity(intent);
            }
        });

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvresult.getText().toString();
                if (!result.equals("Result will be here")){
                    if (result != null && !result.isEmpty()){
                        String result1 = tvresult.getText().toString();

                        Bundle bundle = new Bundle();
                        bundle.putString("id", result1);

                        Intent intent = new Intent(getApplicationContext(), DetailsAssetsActivity.class);
                        intent.putExtras(bundle);
                        getApplicationContext().startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Please Scan Barcode first !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Please Scan Barcode first !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent myIntent = new Intent(ScannerResultActivity.this, MainActivity.class);
        ScannerResultActivity.this.startActivity(myIntent);
    }
}
