package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class s {
    @NonNull
    private final Context a;
    @NonNull
    private final mo b;
    @NonNull
    private final String c;
    @NonNull
    private final ado d;

    public s(@NonNull Context context, @NonNull mo moVar) {
        this(context, moVar, context.getPackageName(), new ado());
    }

    @NonNull
    private List<String> b() {
        return this.b.o();
    }

    @NonNull
    private List<String> c() {
        Signature[] signatureArr;
        ArrayList arrayList = new ArrayList();
        try {
            if (dl.a(28)) {
                signatureArr = d();
            } else {
                signatureArr = this.d.a(this.a, this.c, 64).signatures;
            }
            if (signatureArr != null) {
                for (Signature signature : signatureArr) {
                    String a3 = a(signature);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @TargetApi(28)
    @Nullable
    private Signature[] d() {
        SigningInfo signingInfo = this.d.a(this.a, this.c, 134217728).signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            return signingInfo.getApkContentsSigners();
        }
        return signingInfo.getSigningCertificateHistory();
    }

    @NonNull
    public List<String> a() {
        List<String> b2 = b();
        if (b2.isEmpty()) {
            b2 = c();
            if (!b2.isEmpty()) {
                a(b2);
            }
        }
        return b2;
    }

    @VisibleForTesting
    public s(@NonNull Context context, @NonNull mo moVar, @NonNull String str, @NonNull ado ado) {
        this.a = context;
        this.b = moVar;
        this.c = str;
        this.d = ado;
    }

    @Nullable
    private String a(@NonNull Signature signature) {
        try {
            return dh.b(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(@NonNull List<String> list) {
        this.b.a(list).q();
    }
}
