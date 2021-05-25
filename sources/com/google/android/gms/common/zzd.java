package com.google.android.gms.common;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
public abstract class zzd extends zzo {
    private int zza;

    public zzd(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    public static byte[] zza(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        IObjectWrapper zzb;
        if (obj != null && (obj instanceof zzm)) {
            try {
                zzm zzm = (zzm) obj;
                if (zzm.zzc() == hashCode() && (zzb = zzm.zzb()) != null) {
                    return Arrays.equals(zza(), (byte[]) ObjectWrapper.unwrap(zzb));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.zza;
    }

    public abstract byte[] zza();

    @Override // com.google.android.gms.common.internal.zzm
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(zza());
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() {
        return hashCode();
    }
}
