package cl.bootcamp.sprintmodulo4;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cl.bootcamp.sprintmodulo4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
        private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}