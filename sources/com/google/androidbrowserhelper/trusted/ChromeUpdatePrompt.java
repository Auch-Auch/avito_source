package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.widget.Toast;
public class ChromeUpdatePrompt {
    public static void promptIfNeeded(Context context, String str) {
        int identifier;
        if (ChromeLegacyUtils.b.contains(str)) {
            int b = ChromeLegacyUtils.b(context.getPackageManager(), str);
            boolean z = false;
            if (b != 0 && b < 362600000) {
                z = true;
            }
            if (z && (identifier = context.getResources().getIdentifier("string/update_chrome_toast", null, context.getPackageName())) != 0) {
                Toast.makeText(context, identifier, 1).show();
            }
        }
    }
}
