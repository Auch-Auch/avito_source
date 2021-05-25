package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class zzbm implements zzbo {
    private static Logger zzda = Logger.getLogger(zzbm.class.getName());
    private ThreadLocal<ByteBuffer> zzdb = new zzbl(this);

    @Override // com.google.android.gms.internal.ads.zzbo
    public final zzbp zza(zzela zzela, zzbs zzbs) throws IOException {
        int read;
        long j;
        long position = zzela.position();
        this.zzdb.get().rewind().limit(8);
        do {
            read = zzela.read(this.zzdb.get());
            if (read == 8) {
                this.zzdb.get().rewind();
                long zzf = zzbq.zzf(this.zzdb.get());
                byte[] bArr = null;
                if (zzf >= 8 || zzf <= 1) {
                    String zzk = zzbq.zzk(this.zzdb.get());
                    if (zzf == 1) {
                        this.zzdb.get().limit(16);
                        zzela.read(this.zzdb.get());
                        this.zzdb.get().position(8);
                        j = zzbq.zzh(this.zzdb.get()) - 16;
                    } else {
                        j = zzf == 0 ? zzela.size() - zzela.position() : zzf - 8;
                    }
                    if ("uuid".equals(zzk)) {
                        this.zzdb.get().limit(this.zzdb.get().limit() + 16);
                        zzela.read(this.zzdb.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzdb.get().position() - 16; position2 < this.zzdb.get().position(); position2++) {
                            bArr[position2 - (this.zzdb.get().position() - 16)] = this.zzdb.get().get(position2);
                        }
                        j -= 16;
                    }
                    zzbp zza = zza(zzk, bArr, zzbs instanceof zzbp ? ((zzbp) zzbs).getType() : "");
                    zza.zza(zzbs);
                    this.zzdb.get().rewind();
                    zza.zza(zzela, this.zzdb.get(), j, this);
                    return zza;
                }
                Logger logger = zzda;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zzf);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzela.zzfc(position);
        throw new EOFException();
    }

    public abstract zzbp zza(String str, byte[] bArr, String str2);
}
