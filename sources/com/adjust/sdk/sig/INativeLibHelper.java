package com.adjust.sdk.sig;

import android.content.Context;
public interface INativeLibHelper {
    void onResume();

    byte[] sign(Context context, Object obj, byte[] bArr, int i);
}
