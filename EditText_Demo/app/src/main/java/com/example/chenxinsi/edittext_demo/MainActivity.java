package com.example.chenxinsi.edittext_demo;

import android.content.pm.ShortcutManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        Typeface typeface = getResources().getFont(R.font.dancing_script);
        textView.setTypeface(typeface);

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

    }

    public void onClick(View v){
        textView.setText(editText.getText().toString());
    }
}
