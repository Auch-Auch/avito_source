package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
public class TwaSharedPreferencesManager {
    public final SharedPreferences a;

    public TwaSharedPreferencesManager(Context context) {
        this.a = context.getSharedPreferences("TrustedWebActivityLauncherPrefs", 0);
    }

    @Nullable
    public String readLastLaunchedProviderPackageName() {
        return this.a.getString("KEY_PROVIDER_PACKAGE", null);
    }

    public void writeLastLaunchedProviderPackageName(String str) {
        this.a.edit().putString("KEY_PROVIDER_PACKAGE", str).apply();
    }
}
