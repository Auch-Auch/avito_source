package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.browser.trusted.Token;
import androidx.browser.trusted.TokenStore;
public class SharedPreferencesTokenStore implements TokenStore {
    public Context a;

    public SharedPreferencesTokenStore(Context context) {
        this.a = context;
    }

    @Override // androidx.browser.trusted.TokenStore
    @Nullable
    public Token load() {
        String string = this.a.getSharedPreferences("com.google.androidbrowserhelper", 0).getString("SharedPreferencesTokenStore.TOKEN", null);
        if (string == null) {
            return null;
        }
        return Token.deserialize(Base64.decode(string, 3));
    }

    public void setVerifiedProvider(String str, PackageManager packageManager) {
        store(Token.create(str, packageManager));
    }

    @Override // androidx.browser.trusted.TokenStore
    public void store(@Nullable Token token) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("com.google.androidbrowserhelper", 0);
        if (token == null) {
            sharedPreferences.edit().remove("SharedPreferencesTokenStore.TOKEN").apply();
            return;
        }
        sharedPreferences.edit().putString("SharedPreferencesTokenStore.TOKEN", Base64.encodeToString(token.serialize(), 3)).apply();
    }
}
