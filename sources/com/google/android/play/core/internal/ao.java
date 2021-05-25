package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.android.play.core.splitcompat.d;
import com.google.android.play.core.splitcompat.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public final class ao {
    public final e a;
    public final Context b;

    public ao(Context context, e eVar, d dVar, byte[] bArr) {
        this.a = eVar;
        this.b = context;
    }

    public final boolean a() {
        Signature[] signatureArr;
        String absolutePath;
        X509Certificate x509Certificate;
        try {
            File c = this.a.c();
            ArrayList<X509Certificate> arrayList = null;
            try {
                signatureArr = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException unused) {
                signatureArr = null;
            }
            if (signatureArr != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Signature signature : signatureArr) {
                    try {
                        x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    } catch (CertificateException unused2) {
                        x509Certificate = null;
                    }
                    if (x509Certificate != null) {
                        arrayList2.add(x509Certificate);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return false;
            }
            File[] listFiles = c.listFiles();
            Arrays.sort(listFiles);
            int length = listFiles.length;
            loop1:
            while (true) {
                length--;
                if (length < 0) {
                    return true;
                }
                File file = listFiles[length];
                try {
                    absolutePath = file.getAbsolutePath();
                    try {
                        X509Certificate[][] a3 = h.a(absolutePath);
                        if (a3 == null || a3.length == 0 || a3[0].length == 0) {
                            break;
                        } else if (arrayList.isEmpty()) {
                            break;
                        } else {
                            for (X509Certificate x509Certificate2 : arrayList) {
                                int length2 = a3.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length2) {
                                        break loop1;
                                    } else if (!a3[i][0].equals(x509Certificate2)) {
                                        i++;
                                    }
                                }
                            }
                            try {
                                file.renameTo(this.a.a(file));
                            } catch (IOException unused3) {
                                return false;
                            }
                        }
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                }
            }
            return false;
            String.valueOf(absolutePath).length();
            return false;
        } catch (IOException unused6) {
            return false;
        }
    }

    public final boolean a(List<Intent> list) throws IOException {
        for (Intent intent : list) {
            if (!this.a.b(intent.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
