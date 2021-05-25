package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import l6.h.d.a.a;
@Deprecated
public class FingerprintManagerCompat {
    public final Context a;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        public final CryptoObject a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.a;
        }
    }

    public FingerprintManagerCompat(Context context) {
        this.a = context;
    }

    @Nullable
    @RequiresApi(23)
    public static FingerprintManager a(@NonNull Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager a3;
        FingerprintManager.CryptoObject cryptoObject2;
        FingerprintManager.CryptoObject cryptoObject3;
        if (Build.VERSION.SDK_INT >= 23 && (a3 = a(this.a)) != null) {
            FingerprintManager.CryptoObject cryptoObject4 = null;
            android.os.CancellationSignal cancellationSignal2 = cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null;
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    cryptoObject3 = new FingerprintManager.CryptoObject(cryptoObject.getCipher());
                } else if (cryptoObject.getSignature() != null) {
                    cryptoObject3 = new FingerprintManager.CryptoObject(cryptoObject.getSignature());
                } else if (cryptoObject.getMac() != null) {
                    cryptoObject4 = new FingerprintManager.CryptoObject(cryptoObject.getMac());
                }
                cryptoObject2 = cryptoObject3;
                a3.authenticate(cryptoObject2, cancellationSignal2, i, new a(authenticationCallback), handler);
            }
            cryptoObject2 = cryptoObject4;
            a3.authenticate(cryptoObject2, cancellationSignal2, i, new a(authenticationCallback), handler);
        }
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager a3;
        if (Build.VERSION.SDK_INT < 23 || (a3 = a(this.a)) == null || !a3.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager a3;
        if (Build.VERSION.SDK_INT < 23 || (a3 = a(this.a)) == null || !a3.isHardwareDetected()) {
            return false;
        }
        return true;
    }

    public static class CryptoObject {
        public final Signature a;
        public final Cipher b;
        public final Mac c;

        public CryptoObject(@NonNull Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.b;
        }

        @Nullable
        public Mac getMac() {
            return this.c;
        }

        @Nullable
        public Signature getSignature() {
            return this.a;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.b = cipher;
            this.a = null;
            this.c = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.c = mac;
            this.b = null;
            this.a = null;
        }
    }
}
