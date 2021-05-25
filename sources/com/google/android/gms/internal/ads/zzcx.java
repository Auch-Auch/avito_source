package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public final class zzcx {
    private static boolean zznr = false;
    private static MessageDigest zzns;
    private static final Object zznt = new Object();
    private static final Object zznu = new Object();
    public static CountDownLatch zznv = new CountDownLatch(1);

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznt) {
            MessageDigest zzbp = zzbp();
            if (zzbp != null) {
                zzbp.reset();
                zzbp.update(bArr);
                digest = zzns.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    public static void zzbo() {
        synchronized (zznu) {
            if (!zznr) {
                zznr = true;
                new Thread(new zzcz()).start();
            }
        }
    }

    private static MessageDigest zzbp() {
        boolean z;
        MessageDigest messageDigest;
        zzbo();
        try {
            z = zznv.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zzns) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String zzj(zzcf.zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqu)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzcf.zzf.zza zzbl = zzcf.zzf.zzbl();
                Iterator<byte[]> it = zza2.iterator();
                while (it.hasNext()) {
                    zzbl.zzj(zzeff.zzu(zza(it.next(), str, false)));
                }
                zzbl.zzk(zzeff.zzu(zzb(byteArray)));
                bArr = ((zzcf.zzf) ((zzegp) zzbl.zzbfx())).toByteArray();
            }
        } else if (zzfe.zzaaa != null) {
            bArr = ((zzcf.zzf) ((zzegp) zzcf.zzf.zzbl().zzj(zzeff.zzu(zzfe.zzaaa.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcm.TINK_HYBRID).zzbfx())).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcv.zza(bArr, true);
    }

    private static zzcf.zza zza(zzcf.zza.zzd zzd) {
        zzcf.zza.C0192zza zzaq = zzcf.zza.zzaq();
        zzaq.zzn((long) zzd.zzv());
        return (zzcf.zza) ((zzegp) zzaq.zzbfx());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zzb(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        for (zzde zzde : new zzdc().zzvo) {
            zzde.zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzees(str.getBytes("UTF-8")).zzt(bArr4);
        }
        return bArr4;
    }
}
