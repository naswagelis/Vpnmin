package com.vpnmin.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnConnect, btnSelectServer;
    private TextView tvSelectedLocation;
    private boolean isConnected = false;
    public static String currentServer = "⚡ Lag rich";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = findViewById(R.id.btnConnect);
        btnSelectServer = findViewById(R.id.btnSelectServer);
        tvSelectedLocation = findViewById(R.id.tvSelectedLocation);
        tvSelectedLocation.setText(currentServer);

        btnConnect.setOnClickListener(v -> {
            isConnected = !isConnected;
            if (isConnected) {
                btnConnect.setText("Отключить");
                btnConnect.setBackgroundColor(0xFFEF4444);
                Toast.makeText(this, "Подключено к " + currentServer, Toast.LENGTH_SHORT).show();
            } else {
                btnConnect.setText("Подключить");
                btnConnect.setBackgroundColor(0xFF6366F1);
                Toast.makeText(this, "Отключено", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelectServer.setOnClickListener(v -> {
            startActivity(new Intent(this, ServerSelectActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvSelectedLocation.setText(currentServer);
    }
}
