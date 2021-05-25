package com.adjust.sdk.sig;

import android.content.Context;
import com.adjust.sdk.sig.KeystoreHelper;
import com.avito.android.util.preferences.SessionContract;
import java.security.InvalidKeyException;
import java.security.UnrecoverableKeyException;
import java.util.Map;
public class SignerInstance {
    public static final int MAX_SIGNER_RETRIES = 2;
    private static final int SHA256_BLOCK_SIZE = 32;
    private static final String TAG = "SignerInstance";
    private static boolean didEnableSigning = true;
    private static boolean didReceiveError = false;

    private void initMap(Map<String, String> map, String str, String str2) {
        map.put("activity_kind", str);
        map.put("client_sdk", str2);
    }

    private void restoreMap(Map<String, String> map) {
        map.remove("activity_kind");
        map.remove("client_sdk");
    }

    public void disableSigning() {
        didEnableSigning = false;
    }

    public void enableSigning() {
        didEnableSigning = true;
    }

    public void onResume(INativeLibHelper iNativeLibHelper) {
        if (!didReceiveError && didEnableSigning) {
            iNativeLibHelper.onResume();
        }
    }

    public void resetLibrary(Context context, IKeystoreHelper iKeystoreHelper) throws Exception {
        didReceiveError = false;
        iKeystoreHelper.deleteKeys(context);
    }

    public void sign(Context context, IKeystoreHelper iKeystoreHelper, INativeLibHelper iNativeLibHelper, Map<String, String> map, String str, String str2) throws Exception {
        if (!didReceiveError && didEnableSigning && map != null && map.size() != 0 && str != null && str2 != null) {
            initMap(map, str, str2);
            int i = 2;
            byte[] bArr = null;
            while (i > 0) {
                try {
                    iKeystoreHelper.initKeys(context);
                    bArr = iKeystoreHelper.getHmac(context, map.toString().getBytes("UTF-8"));
                    break;
                } catch (KeystoreHelper.UnsupportedApiException e) {
                    didReceiveError = true;
                    restoreMap(map);
                    throw e;
                } catch (InvalidKeyException | UnrecoverableKeyException e2) {
                    e2.getMessage();
                    i--;
                    iKeystoreHelper.deleteKeys(context);
                } catch (Exception e3) {
                    e3.getMessage();
                    restoreMap(map);
                    throw e3;
                }
            }
            if (i == 0) {
                didReceiveError = true;
                restoreMap(map);
                return;
            }
            byte[] sign = iNativeLibHelper.sign(context, map, bArr, iKeystoreHelper.getApiLevel());
            if (sign.length != 32) {
                restoreMap(map);
                return;
            }
            map.put(SessionContract.SIGNATURE, Util.bytesToHex(sign, 32));
            restoreMap(map);
        }
    }
}
