package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;
public final class zzadp extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdcj = new ArrayList();
    private final zzado zzdcu;

    public zzadp(zzado zzado) {
        zzadw zzadw;
        IBinder iBinder;
        this.zzdcu = zzado;
        try {
            this.text = zzado.getText();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            this.text = "";
        }
        try {
            for (zzadw zzadw2 : zzado.zzry()) {
                if (!(zzadw2 instanceof IBinder) || (iBinder = (IBinder) zzadw2) == null) {
                    zzadw = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzadw = queryLocalInterface instanceof zzadw ? (zzadw) queryLocalInterface : new zzady(iBinder);
                }
                if (zzadw != null) {
                    this.zzdcj.add(new zzadx(zzadw));
                }
            }
        } catch (RemoteException e2) {
            zzbbd.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdcj;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }
}
