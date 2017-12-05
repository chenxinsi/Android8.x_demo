package com.example.chenxinsi.demo;

import android.content.pm.ShortcutManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*/freeme.xinsi 2017.12.05 findViewById
        editText = findViewById(R.id.edit_text);
        //*/

        textView = findViewById(R.id.text_view);
        //*/freeme.xinsi 2017.12.05 Fonts in XML
        Typeface typeface = getResources().getFont(R.font.dancing_script);
        textView.setTypeface(typeface);
        //*/

        //*/freeme.xinsi 2017.12.05 shortcuts
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        //*/
    }

    public void onClick(View v){
        textView.setText(editText.getText().toString());
    }
}
