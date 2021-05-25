package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
public final class zzdlz {
    public static ParcelFileDescriptor zzf(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzbbi.zzedu.execute(new Runnable(inputStream, createPipe[1]) { // from class: com.google.android.gms.internal.ads.zzdmc
            private final InputStream zzhcm;
            private final ParcelFileDescriptor zzhcn;

            {
                this.zzhcm = r1;
                this.zzhcn = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InputStream inputStream2 = this.zzhcm;
                try {
                    ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.zzhcn);
                    try {
                        IOUtils.copyStream(inputStream2, autoCloseOutputStream);
                        autoCloseOutputStream.close();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        zzeeo.zza(th, th);
                    }
                    throw th;
                    throw th;
                } catch (Throwable th2) {
                    zzeeo.zza(th, th2);
                }
            }
        });
        return parcelFileDescriptor;
    }
}
