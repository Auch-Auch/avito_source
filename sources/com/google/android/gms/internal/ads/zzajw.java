package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public class zzajw<ReferenceT> implements zzajt {
    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzahf<? super ReferenceT>>> zzdfz = new HashMap();
    private ReferenceT zzdga;

    private final synchronized void zzb(String str, Map<String, String> map) {
        if (zzbbd.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzaxy.zzei(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzaxy.zzei(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzahf<? super ReferenceT>> copyOnWriteArrayList = this.zzdfz.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcwx)).booleanValue() && zzp.zzkt().zzwd() != null) {
                zzbbi.zzedu.execute(new Runnable(str) { // from class: com.google.android.gms.internal.ads.zzajy
                    private final String zzdgb;

                    {
                        this.zzdgb = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzp.zzkt().zzwd().zzcv(this.zzdgb.substring(1));
                    }
                });
                return;
            }
            return;
        }
        Iterator<zzahf<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzbbi.zzedy.execute(new Runnable(this, it.next(), map) { // from class: com.google.android.gms.internal.ads.zzajv
                private final zzajw zzdfw;
                private final zzahf zzdfx;
                private final Map zzdfy;

                {
                    this.zzdfw = r1;
                    this.zzdfx = r2;
                    this.zzdfy = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdfw.zza(this.zzdfx, this.zzdfy);
                }
            });
        }
    }

    public final synchronized void reset() {
        this.zzdfz.clear();
    }

    public final synchronized void zza(String str, zzahf<? super ReferenceT> zzahf) {
        CopyOnWriteArrayList<zzahf<? super ReferenceT>> copyOnWriteArrayList = this.zzdfz.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.zzdfz.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzahf);
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final boolean zzdg(@Nullable String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final void zzg(ReferenceT referencet) {
        this.zzdga = referencet;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        zzp.zzkp();
        zzb(path, zzayh.zzj(uri));
    }

    public final boolean zzg(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        zzh(uri);
        return true;
    }

    public final synchronized void zza(String str, Predicate<zzahf<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzahf<? super ReferenceT>> copyOnWriteArrayList = this.zzdfz.get(str);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<zzahf<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzahf<? super ReferenceT> next = it.next();
                if (predicate.apply(next)) {
                    arrayList.add(next);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    public final /* synthetic */ void zza(zzahf zzahf, Map map) {
        zzahf.zza(this.zzdga, map);
    }

    public final synchronized void zzb(String str, zzahf<? super ReferenceT> zzahf) {
        CopyOnWriteArrayList<zzahf<? super ReferenceT>> copyOnWriteArrayList = this.zzdfz.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzahf);
        }
    }
}
