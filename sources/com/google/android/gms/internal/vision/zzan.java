package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
public final class zzan extends zzs<zzad> {
    private final zzam zzem;

    public zzan(Context context, zzam zzam) {
        super(context, "TextNativeHandle", "ocr");
        this.zzem = zzam;
        zzr();
    }

    public final zzah[] zza(Bitmap bitmap, zzu zzu, zzaj zzaj) {
        if (!isOperational()) {
            return new zzah[0];
        }
        try {
            return ((zzad) zzr()).zza(ObjectWrapper.wrap(bitmap), zzu, zzaj);
        } catch (RemoteException unused) {
            return new zzah[0];
        }
    }

    @Override // com.google.android.gms.internal.vision.zzs
    public final void zzp() throws RemoteException {
        ((zzad) zzr()).zzs();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.vision.zzs
    public final /* synthetic */ zzad zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzaf zzaf;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        if (instantiate == null) {
            zzaf = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            if (queryLocalInterface instanceof zzaf) {
                zzaf = (zzaf) queryLocalInterface;
            } else {
                zzaf = new zzae(instantiate);
            }
        }
        if (zzaf == null) {
            return null;
        }
        return zzaf.zza(ObjectWrapper.wrap(context), this.zzem);
    }
}
