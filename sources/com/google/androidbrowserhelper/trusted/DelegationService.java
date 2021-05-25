package com.google.androidbrowserhelper.trusted;

import androidx.annotation.NonNull;
import androidx.browser.trusted.TokenStore;
import androidx.browser.trusted.TrustedWebActivityService;
public class DelegationService extends TrustedWebActivityService {
    @Override // androidx.browser.trusted.TrustedWebActivityService
    @NonNull
    public TokenStore getTokenStore() {
        return new SharedPreferencesTokenStore(this);
    }
}
