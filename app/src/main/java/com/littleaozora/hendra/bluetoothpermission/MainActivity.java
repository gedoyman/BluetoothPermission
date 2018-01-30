package com.littleaozora.hendra.bluetoothpermission;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btbOn, btnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btbOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);

        btbOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick Button On");
                final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if(mBluetoothAdapter == null){
                    Toast.makeText(MainActivity.this, "This devide doesn't support Bluetooth", Toast.LENGTH_SHORT).show();
                }else if(mBluetoothAdapter.isEnabled()){
                    Toast.makeText(MainActivity.this, "Bluettoh already ON", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                }
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick Button On");
                final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if(mBluetoothAdapter == null){
                    Toast.makeText(MainActivity.this, "This devide doesn't support Bluetooth", Toast.LENGTH_SHORT).show();
                }else if(mBluetoothAdapter.isEnabled()){
                    mBluetoothAdapter.disable();
                }else{
                    Toast.makeText(MainActivity.this, "Bluetooth already off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
