package com.example.tareabutton;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
                R.id.botonAzul,
                R.id.botonRojo
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new ReceptorBoton());
        }
    }

    private class ReceptorBoton implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            TextView textView = findViewById(R.id.texto1);
            SpannableStringBuilder cadena = new SpannableStringBuilder("Mensaje de colores");
            if(v.getId() == R.id.botonAzul) {
                cadena.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 18, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            }else {
                cadena.setSpan(new ForegroundColorSpan(Color.RED), 0, 18, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            }
            textView.setText(cadena);
        }
    }
}