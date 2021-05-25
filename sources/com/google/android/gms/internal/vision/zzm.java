package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;
public final class zzm extends zzs<zzl> {
    private final zzk zzbs;

    public zzm(Context context, zzk zzk) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.zzbs = zzk;
        zzr();
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzu zzu) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) zzr()).zza(ObjectWrapper.wrap(byteBuffer), zzu);
        } catch (RemoteException unused) {
            return new Barcode[0];
        }
    }

    @Override // com.google.android.gms.internal.vision.zzs
    public final void zzp() throws RemoteException {
        if (isOperational()) {
            ((zzl) zzr()).zzo();
        }
    }

    public final Barcode[] zza(Bitmap bitmap, zzu zzu) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) zzr()).zzb(ObjectWrapper.wrap(bitmap), zzu);
        } catch (RemoteException unused) {
            return new Barcode[0];
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.vision.zzs
    public final /* synthetic */ zzl zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzn zzn;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (instantiate == null) {
            zzn = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            if (queryLocalInterface instanceof zzn) {
                zzn = (zzn) queryLocalInterface;
            } else {
                zzn = new zzp(instantiate);
            }
        }
        if (zzn == null) {
            return null;
        }
        return zzn.zza(ObjectWrapper.wrap(context), this.zzbs);
    }
}
