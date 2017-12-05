package com.example.chenxinsi.demo;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

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
        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "my-shortcut")
                .setShortLabel("Web site")
                .setLongLabel("Open the web site")
                .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.ic_launcher_round))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.xinsichen.com/")))
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));

        if (shortcutManager.isRequestPinShortcutSupported()) {
            ShortcutInfo pinShortcutInfo = new ShortcutInfo
                    .Builder(MainActivity.this,"my-shortcut")
                    .build();
            Intent pinnedShortcutCallbackIntent =
                    shortcutManager.createShortcutResultIntent(pinShortcutInfo);
            PendingIntent successCallback = PendingIntent.getBroadcast(MainActivity.this, 0,
                    pinnedShortcutCallbackIntent, 0);
            shortcutManager.requestPinShortcut(pinShortcutInfo, successCallback.getIntentSender());
        }
        //*/
    }

    public void onClick(View v){
        textView.setText(editText.getText().toString());
    }
}
