package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdzw;
import com.google.android.gms.internal.ads.zzeaa;
import com.google.android.gms.internal.ads.zzeam;
import com.google.android.gms.internal.ads.zzebl;
import java.security.GeneralSecurityException;
import java.util.Arrays;
public final class zzdzg implements zzedk {
    private final String zzhsx;
    private final int zzhsy;
    private zzeam zzhsz;
    private zzdzw zzhta;
    private int zzhtb;

    public zzdzg(zzebw zzebw) throws GeneralSecurityException {
        String zzbay = zzebw.zzbay();
        this.zzhsx = zzbay;
        if (zzbay.equals(zzdxs.zzhru)) {
            try {
                zzeap zzl = zzeap.zzl(zzebw.zzbaz(), zzegc.zzbex());
                this.zzhsz = (zzeam) zzdxm.zzb(zzebw);
                this.zzhsy = zzl.getKeySize();
            } catch (zzegz e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zzbay.equals(zzdxs.zzhrt)) {
            try {
                zzdzz zzf = zzdzz.zzf(zzebw.zzbaz(), zzegc.zzbex());
                this.zzhta = (zzdzw) zzdxm.zzb(zzebw);
                this.zzhtb = zzf.zzayu().getKeySize();
                this.zzhsy = this.zzhtb + zzf.zzayv().getKeySize();
            } catch (zzegz e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(zzbay);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedk
    public final int zzayh() {
        return this.zzhsy;
    }

    @Override // com.google.android.gms.internal.ads.zzedk
    public final zzdwq zzn(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzhsy) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzhsx.equals(zzdxs.zzhru)) {
            return (zzdwq) zzdxm.zza(this.zzhsx, (zzeam) ((zzegp) ((zzeam.zza) zzeam.zzazm().zza(this.zzhsz)).zzw(zzeff.zzi(bArr, 0, this.zzhsy)).zzbfx()), zzdwq.class);
        } else if (this.zzhsx.equals(zzdxs.zzhrt)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzhtb);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzhtb, this.zzhsy);
            zzdzw.zza zzb = zzdzw.zzays().zzet(this.zzhta.getVersion()).zzb((zzeaa) ((zzegp) ((zzeaa.zza) zzeaa.zzayy().zza(this.zzhta.zzayq())).zzu(zzeff.zzu(copyOfRange)).zzbfx()));
            return (zzdwq) zzdxm.zza(this.zzhsx, (zzdzw) ((zzegp) zzb.zzb((zzebl) ((zzegp) ((zzebl.zza) zzebl.zzbaq().zza(this.zzhta.zzayr())).zzad(zzeff.zzu(copyOfRange2)).zzbfx())).zzbfx()), zzdwq.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
