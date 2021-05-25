package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.stats.CodePackage;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessaging;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
public class IidStore {
    public static final String[] c = {"*", FirebaseMessaging.INSTANCE_ID_SCOPE, CodePackage.GCM, ""};
    @GuardedBy("iidPrefs")
    public final SharedPreferences a;
    public final String b;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r0.isEmpty() != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IidStore(@androidx.annotation.NonNull com.google.firebase.FirebaseApp r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            java.lang.String r1 = "com.google.android.gms.appid"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.a = r0
            com.google.firebase.FirebaseOptions r0 = r4.getOptions()
            java.lang.String r0 = r0.getGcmSenderId()
            if (r0 == 0) goto L_0x001b
            goto L_0x004b
        L_0x001b:
            com.google.firebase.FirebaseOptions r4 = r4.getOptions()
            java.lang.String r0 = r4.getApplicationId()
            java.lang.String r4 = "1:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0034
            java.lang.String r4 = "2:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0034
            goto L_0x004b
        L_0x0034:
            java.lang.String r4 = ":"
            java.lang.String[] r4 = r0.split(r4)
            int r0 = r4.length
            r1 = 4
            r2 = 0
            if (r0 == r1) goto L_0x0041
        L_0x003f:
            r0 = r2
            goto L_0x004b
        L_0x0041:
            r0 = 1
            r0 = r4[r0]
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x004b
            goto L_0x003f
        L_0x004b:
            r3.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.IidStore.<init>(com.google.firebase.FirebaseApp):void");
    }

    @Nullable
    public final String a() {
        PublicKey publicKey;
        synchronized (this.a) {
            String str = null;
            String string = this.a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                String str2 = "Invalid key stored " + e;
                publicKey = null;
            }
            if (publicKey == null) {
                return null;
            }
            try {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
                digest[0] = (byte) (((digest[0] & Ascii.SI) + 112) & 255);
                str = Base64.encodeToString(digest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
            }
            return str;
        }
    }

    @Nullable
    public String readIid() {
        String string;
        synchronized (this.a) {
            synchronized (this.a) {
                string = this.a.getString("|S|id", null);
            }
            if (string != null) {
                return string;
            }
            return a();
        }
    }

    @Nullable
    public String readToken() {
        synchronized (this.a) {
            String[] strArr = c;
            int length = strArr.length;
            int i = 0;
            while (true) {
                String str = null;
                if (i >= length) {
                    return null;
                }
                String str2 = strArr[i];
                String str3 = this.b;
                String string = this.a.getString("|T|" + str3 + "|" + str2, null);
                if (string == null || string.isEmpty()) {
                    i++;
                } else {
                    if (string.startsWith("{")) {
                        try {
                            str = new JSONObject(string).getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
                        } catch (JSONException unused) {
                        }
                        string = str;
                    }
                    return string;
                }
            }
        }
    }

    @VisibleForTesting
    public IidStore(@NonNull SharedPreferences sharedPreferences, @Nullable String str) {
        this.a = sharedPreferences;
        this.b = str;
    }
}
