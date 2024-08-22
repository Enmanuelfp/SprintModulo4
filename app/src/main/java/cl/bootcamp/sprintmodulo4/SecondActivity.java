package cl.bootcamp.sprintmodulo4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cl.bootcamp.sprintmodulo4.databinding.ActivityMainBinding;
import cl.bootcamp.sprintmodulo4.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String emailContent = binding.textInputLayout.getEditText().getText().toString();

        binding.btnsend.setOnClickListener(view -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"emmanuelperez11@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Me interesa contactarme contigo");
            emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
            try {
                startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(SecondActivity.this, "No hay aplicaciones de correo electrónico instaladas.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent linkedInIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/feed/?trk=guest_homepage-basic_google-one-tap-submit"));
                startActivity(linkedInIntent);
            }
        });

        binding.whatsaap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+56962550648"));
                startActivity(whatsAppIntent);
            }
        });

    }
}