package com.google.androidbrowserhelper.trusted;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class FocusActivity extends AppCompatActivity {
    public static Boolean c;

    public static void addToIntent(Intent intent, Context context) {
        Intent intent2 = new Intent(context, FocusActivity.class);
        if (c == null) {
            c = Boolean.valueOf(intent2.resolveActivityInfo(context.getPackageManager(), 0) != null);
        }
        if (!Boolean.FALSE.equals(c)) {
            intent2.setFlags(268435456);
            intent.putExtra("androidx.browser.customtabs.extra.FOCUS_INTENT", PendingIntent.getActivity(context, 0, intent2, 0));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
