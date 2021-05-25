package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
public final class zzhs extends zzhq<zzid.zzd> {
    @Override // com.google.android.gms.internal.vision.zzhq
    public final <UT, UB> UB zza(zzkc zzkc, Object obj, zzho zzho, zzht<zzid.zzd> zzht, UB ub, zzkx<UT, UB> zzkx) throws IOException {
        Object zza;
        zzid.zzg zzg = (zzid.zzg) obj;
        zzid.zzd zzd = zzg.zzyr;
        int i = zzd.number;
        boolean z = zzd.zzye;
        zzlk zzlk = zzd.zzyd;
        Object obj2 = null;
        if (zzlk != zzlk.ENUM) {
            int[] iArr = zzhr.zztn;
            switch (iArr[zzlk.ordinal()]) {
                case 1:
                    obj2 = Double.valueOf(zzkc.readDouble());
                    break;
                case 2:
                    obj2 = Float.valueOf(zzkc.readFloat());
                    break;
                case 3:
                    obj2 = Long.valueOf(zzkc.zzer());
                    break;
                case 4:
                    obj2 = Long.valueOf(zzkc.zzeq());
                    break;
                case 5:
                    obj2 = Integer.valueOf(zzkc.zzes());
                    break;
                case 6:
                    obj2 = Long.valueOf(zzkc.zzet());
                    break;
                case 7:
                    obj2 = Integer.valueOf(zzkc.zzeu());
                    break;
                case 8:
                    obj2 = Boolean.valueOf(zzkc.zzev());
                    break;
                case 9:
                    obj2 = Integer.valueOf(zzkc.zzey());
                    break;
                case 10:
                    obj2 = Integer.valueOf(zzkc.zzfa());
                    break;
                case 11:
                    obj2 = Long.valueOf(zzkc.zzfb());
                    break;
                case 12:
                    obj2 = Integer.valueOf(zzkc.zzfc());
                    break;
                case 13:
                    obj2 = Long.valueOf(zzkc.zzfd());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    obj2 = zzkc.zzex();
                    break;
                case 16:
                    obj2 = zzkc.readString();
                    break;
                case 17:
                    obj2 = zzkc.zzb(zzg.zzyq.getClass(), zzho);
                    break;
                case 18:
                    obj2 = zzkc.zza(zzg.zzyq.getClass(), zzho);
                    break;
            }
            zzid.zzd zzd2 = zzg.zzyr;
            if (zzd2.zzye) {
                zzht.zzb((zzht<zzid.zzd>) zzd2, obj2);
            } else {
                int i2 = iArr[zzd2.zzyd.ordinal()];
                if ((i2 == 17 || i2 == 18) && (zza = zzht.zza((zzht<zzid.zzd>) zzg.zzyr)) != null) {
                    obj2 = zzie.zzb(zza, obj2);
                }
                zzht.zza((zzht<zzid.zzd>) zzg.zzyr, obj2);
            }
            return ub;
        }
        zzkc.zzes();
        throw null;
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final boolean zze(zzjn zzjn) {
        return zzjn instanceof zzid.zze;
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final zzht<zzid.zzd> zzh(Object obj) {
        return ((zzid.zze) obj).zzyg;
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final zzht<zzid.zzd> zzi(Object obj) {
        return ((zzid.zze) obj).zzhe();
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final void zzj(Object obj) {
        zzh(obj).zzej();
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzid.zzd) entry.getKey()).number;
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final void zza(zzlq zzlq, Map.Entry<?, ?> entry) throws IOException {
        zzid.zzd zzd = (zzid.zzd) entry.getKey();
        if (zzd.zzye) {
            switch (zzhr.zztn[zzd.zzyd.ordinal()]) {
                case 1:
                    zzkh.zza(zzd.number, (List<Double>) ((List) entry.getValue()), zzlq, false);
                    return;
                case 2:
                    zzkh.zzb(zzd.number, (List<Float>) ((List) entry.getValue()), zzlq, false);
                    return;
                case 3:
                    zzkh.zzc(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 4:
                    zzkh.zzd(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 5:
                    zzkh.zzh(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 6:
                    zzkh.zzf(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 7:
                    zzkh.zzk(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 8:
                    zzkh.zzn(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 9:
                    zzkh.zzi(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 10:
                    zzkh.zzl(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 11:
                    zzkh.zzg(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 12:
                    zzkh.zzj(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 13:
                    zzkh.zze(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 14:
                    zzkh.zzh(zzd.number, (List) entry.getValue(), zzlq, false);
                    return;
                case 15:
                    zzkh.zzb(zzd.number, (List) entry.getValue(), zzlq);
                    return;
                case 16:
                    zzkh.zza(zzd.number, (List) entry.getValue(), zzlq);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzkh.zzb(zzd.number, (List) entry.getValue(), zzlq, zzkb.zzik().zzf(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzkh.zza(zzd.number, (List) entry.getValue(), zzlq, zzkb.zzik().zzf(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzhr.zztn[zzd.zzyd.ordinal()]) {
                case 1:
                    zzlq.zza(zzd.number, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzlq.zza(zzd.number, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzlq.zzi(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzlq.zza(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzlq.zzj(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzlq.zzc(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzlq.zzm(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzlq.zza(zzd.number, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzlq.zzk(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzlq.zzt(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzlq.zzj(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzlq.zzl(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzlq.zzb(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzlq.zzj(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzlq.zza(zzd.number, (zzgs) entry.getValue());
                    return;
                case 16:
                    zzlq.zza(zzd.number, (String) entry.getValue());
                    return;
                case 17:
                    zzlq.zzb(zzd.number, entry.getValue(), zzkb.zzik().zzf(entry.getValue().getClass()));
                    return;
                case 18:
                    zzlq.zza(zzd.number, entry.getValue(), zzkb.zzik().zzf(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final Object zza(zzho zzho, zzjn zzjn, int i) {
        return zzho.zza(zzjn, i);
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final void zza(zzkc zzkc, Object obj, zzho zzho, zzht<zzid.zzd> zzht) throws IOException {
        zzid.zzg zzg = (zzid.zzg) obj;
        zzht.zza((zzht<zzid.zzd>) zzg.zzyr, zzkc.zza(zzg.zzyq.getClass(), zzho));
    }

    @Override // com.google.android.gms.internal.vision.zzhq
    public final void zza(zzgs zzgs, Object obj, zzho zzho, zzht<zzid.zzd> zzht) throws IOException {
        byte[] bArr;
        zzid.zzg zzg = (zzid.zzg) obj;
        zzjn zzgv = zzg.zzyq.zzhd().zzgv();
        int size = zzgs.size();
        if (size == 0) {
            bArr = zzie.zzys;
        } else {
            byte[] bArr2 = new byte[size];
            zzgs.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzgr zzgr = new zzgr(wrap, true);
            zzkb.zzik().zzx(zzgv).zza(zzgv, zzgr, zzho);
            zzht.zza((zzht<zzid.zzd>) zzg.zzyr, zzgv);
            if (zzgr.zzeo() != Integer.MAX_VALUE) {
                throw zzin.zzhl();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
