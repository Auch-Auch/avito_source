package com.adjust.sdk.sig;

import android.content.Context;
public class NativeLibHelper implements INativeLibHelper {
    private static final String TAG = "NativeLibHelper";

    static {
        try {
            System.loadLibrary("signer");
        } catch (UnsatisfiedLinkError e) {
            e.getMessage();
        }
    }

    private native void nOnResume();

    private native byte[] nSign(Context context, Object obj, byte[] bArr, int i);

    @Override // com.adjust.sdk.sig.INativeLibHelper
    public void onResume() {
        nOnResume();
    }

    @Override // com.adjust.sdk.sig.INativeLibHelper
    public byte[] sign(Context context, Object obj, byte[] bArr, int i) {
        return nSign(context, obj, bArr, i);
    }
}
