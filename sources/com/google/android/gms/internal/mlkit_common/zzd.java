package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
public final class zzd {
    private static final String[] zza = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzb;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  (r0v3 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r5v1 java.lang.String) */
    static {
        String[] strArr = new String[4];
        boolean z = false;
        strArr[0] = "media";
        int i = Build.VERSION.SDK_INT;
        String str = "";
        strArr[1] = i <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : str;
        strArr[2] = i <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : str;
        String str2 = Build.HARDWARE;
        if (str2.equals("goldfish") || str2.equals("ranchu")) {
            z = true;
        }
        if (z) {
            str = "com.google.android.apps.common.testing.services.storage.runfiles";
        }
        strArr[3] = str;
        zzb = strArr;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        return zza(context, uri, str, zzh.zza);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static AssetFileDescriptor zza(Context context, Uri uri, String str, zzh zzh) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse(uri.toString());
        String scheme = parse.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(parse, str);
        }
        if ("content".equals(scheme)) {
            str.hashCode();
            char c = 65535;
            int i = 2;
            switch (str.hashCode()) {
                case 114:
                    if (str.equals("r")) {
                        c = 0;
                        break;
                    }
                    break;
                case 119:
                    if (str.equals("w")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3653:
                    if (str.equals("rw")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3805:
                    if (str.equals("wt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 113359:
                    if (str.equals("rwt")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 1;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            if (zza(context, parse, i, zzh)) {
                return (AssetFileDescriptor) zza(contentResolver.openAssetFileDescriptor(parse, str));
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) zza(contentResolver.openAssetFileDescriptor(parse, str));
            try {
                zza(context, assetFileDescriptor.getParcelFileDescriptor(), parse, zzh);
                return assetFileDescriptor;
            } catch (FileNotFoundException e) {
                zza(assetFileDescriptor, e);
                throw e;
            } catch (IOException e2) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e2);
                zza(assetFileDescriptor, fileNotFoundException);
                throw fileNotFoundException;
            }
        } else {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
    }

    public static InputStream zza(Context context, Uri uri) throws FileNotFoundException {
        return zza(context, uri, zzh.zza);
    }

    private static InputStream zza(Context context, Uri uri, zzh zzh) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse(uri.toString());
        String scheme = parse.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openInputStream(parse);
        }
        if ("content".equals(scheme)) {
            if (zza(context, parse, 1, zzh)) {
                return (InputStream) zza(contentResolver.openInputStream(parse));
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(parse.getPath()).getCanonicalFile()), "r");
                try {
                    zza(context, openFileDescriptor, parse, zzh);
                    return new ParcelFileDescriptor.AutoCloseInputStream(openFileDescriptor);
                } catch (FileNotFoundException e) {
                    zza(openFileDescriptor, e);
                    throw e;
                } catch (IOException e2) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e2);
                    zza(openFileDescriptor, fileNotFoundException);
                    throw fileNotFoundException;
                }
            } catch (IOException e3) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
                fileNotFoundException2.initCause(e3);
                throw fileNotFoundException2;
            }
        } else {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
    }

    private static boolean zza(Context context, Uri uri, int i, zzh zzh) {
        String authority = uri.getAuthority();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (resolveContentProvider == null) {
            int lastIndexOf = authority.lastIndexOf(64);
            if (lastIndexOf >= 0) {
                authority = authority.substring(lastIndexOf + 1);
                resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (resolveContentProvider == null) {
                return !(zzh.zzc);
            }
        }
        int i2 = zze.zza[zzh.zza(zzh, context, new zzr(uri, resolveContentProvider, authority)) - 1];
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        if (context.getPackageName().equals(resolveContentProvider.packageName)) {
            return zzh.zzc;
        }
        if (zzh.zzc) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), i) == 0) {
            return true;
        }
        for (String str : zzb) {
            if (str.equals(authority)) {
                return true;
            }
        }
        if (resolveContentProvider.exported) {
            String[] strArr = zza;
            for (String str2 : strArr) {
                if (str2.charAt(str2.length() - 1) == '.') {
                    if (resolveContentProvider.packageName.startsWith(str2)) {
                        return false;
                    }
                } else if (resolveContentProvider.packageName.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dd, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010a, code lost:
        if (r9 == r12.zzc) goto L_0x010e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(android.content.Context r9, android.os.ParcelFileDescriptor r10, android.net.Uri r11, com.google.android.gms.internal.mlkit_common.zzh r12) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzd.zza(android.content.Context, android.os.ParcelFileDescriptor, android.net.Uri, com.google.android.gms.internal.mlkit_common.zzh):void");
    }

    private static File[] zza(Callable<File[]> callable) {
        try {
            return callable.call();
        } catch (NullPointerException e) {
            if (Build.VERSION.SDK_INT < 22) {
                return new File[0];
            }
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void zza(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            zza(fileNotFoundException, e);
        }
    }

    private static void zza(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            zza(fileNotFoundException, e);
        }
    }

    private static void zza(Exception exc, Exception exc2) {
        zzan.zza(exc, exc2);
    }

    private static <T> T zza(T t) throws FileNotFoundException {
        if (t != null) {
            return t;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }
}
