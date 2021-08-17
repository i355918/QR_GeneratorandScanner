package com.example.qr_generatorandscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText qrText;
    Button generateButton,scanButton;
    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrText = findViewById(R.id.qrText);
        generateButton = findViewById(R.id.generateButton);
        scanButton = findViewById(R.id.scanButton);
        qrImage = findViewById(R.id.qrImage);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qrData = qrText.getText().toString();
                QRGEncoder qrgEncoder = new QRGEncoder(qrData,null, QRGContents.Type.TEXT,50);
                Bitmap BitsQR = qrgEncoder.getBitmap();
                qrImage.setImageBitmap(BitsQR);
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QR_Scanner.class));
            }
        });
    }
}