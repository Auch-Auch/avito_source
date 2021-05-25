package com.adjust.sdk.sig;

import android.content.Context;
import android.os.Build;
import java.util.Map;
public class Signer {
    private boolean didInit = false;
    private IKeystoreHelper keystoreHelper;
    private INativeLibHelper nativeLibHelper;
    private SignerInstance signerInstance;

    public static String getVersion() {
        return "1.3.7";
    }

    private void init() {
        this.signerInstance = new SignerInstance();
        this.keystoreHelper = new KeystoreHelper(Build.VERSION.SDK_INT);
        this.nativeLibHelper = new NativeLibHelper();
        this.didInit = true;
    }

    public void disableSigning() {
        if (!this.didInit) {
            init();
        }
        this.signerInstance.disableSigning();
    }

    public void enableSigning() {
        if (!this.didInit) {
            init();
        }
        this.signerInstance.enableSigning();
    }

    public void onResume() {
        if (!this.didInit) {
            init();
        }
        this.signerInstance.onResume(this.nativeLibHelper);
    }

    public void sign(Context context, Map<String, String> map, String str, String str2) throws Exception {
        if (!this.didInit) {
            init();
        }
        this.signerInstance.sign(context, this.keystoreHelper, this.nativeLibHelper, map, str, str2);
    }
}
