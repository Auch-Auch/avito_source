package com.yandex.runtime.auth.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.auth.TokenListener;
public class TokenListenerBinding implements TokenListener {
    private final NativeObject nativeObject;

    public TokenListenerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.auth.TokenListener
    public native void onPasswordRequired(@NonNull Object obj);

    @Override // com.yandex.runtime.auth.TokenListener
    public native void onTokenReceived(@NonNull String str);

    @Override // com.yandex.runtime.auth.TokenListener
    public native void onTokenRefreshFailed(@NonNull String str);
}
