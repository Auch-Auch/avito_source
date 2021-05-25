package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
public final class zzbkj extends zzxn {
    private final zzbbg zzbpa;
    private final zzawb zzbqm;
    private final zzcji zzfkk;
    private final zzcrf<zzdlx, zzcsn> zzfkl;
    private final zzcwu zzfkm;
    private final zzcmi zzfkn;
    private final zzcjk zzfko;
    private final Context zzvr;
    @GuardedBy("this")
    private boolean zzzh = false;

    public zzbkj(Context context, zzbbg zzbbg, zzcji zzcji, zzcrf<zzdlx, zzcsn> zzcrf, zzcwu zzcwu, zzcmi zzcmi, zzawb zzawb, zzcjk zzcjk) {
        this.zzvr = context;
        this.zzbpa = zzbbg;
        this.zzfkk = zzcji;
        this.zzfkl = zzcrf;
        this.zzfkm = zzcwu;
        this.zzfkn = zzcmi;
        this.zzbqm = zzawb;
        this.zzfko = zzcjk;
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final String getVersionString() {
        return this.zzbpa.zzbra;
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized void initialize() {
        if (this.zzzh) {
            zzbbd.zzfe("Mobile ads is initialized already.");
            return;
        }
        zzaat.initialize(this.zzvr);
        zzp.zzkt().zzd(this.zzvr, this.zzbpa);
        zzp.zzkv().initialize(this.zzvr);
        this.zzzh = true;
        this.zzfkn.zzaox();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpt)).booleanValue()) {
            this.zzfkm.zzanu();
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsf)).booleanValue()) {
            this.zzfko.zzanu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized void setAppMuted(boolean z) {
        zzp.zzku().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized void setAppVolume(float f) {
        zzp.zzku().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zza(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzaat.initialize(this.zzvr);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsg)).booleanValue()) {
            zzp.zzkp();
            str2 = zzayh.zzbd(this.zzvr);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcse)).booleanValue();
            zzaai<Boolean> zzaai = zzaat.zzcoa;
            boolean booleanValue2 = booleanValue | ((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue();
            zzbkm zzbkm = null;
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                booleanValue2 = true;
                zzbkm = new Runnable(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper)) { // from class: com.google.android.gms.internal.ads.zzbkm
                    private final zzbkj zzfkp;
                    private final Runnable zzfkq;

                    {
                        this.zzfkp = r1;
                        this.zzfkq = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbbi.zzedy.execute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                              (wrap: com.google.android.gms.internal.ads.zzdvw : 0x0004: SGET  (r2v0 com.google.android.gms.internal.ads.zzdvw) =  com.google.android.gms.internal.ads.zzbbi.zzedy com.google.android.gms.internal.ads.zzdvw)
                              (wrap: com.google.android.gms.internal.ads.zzbkl : 0x0008: CONSTRUCTOR  (r3v0 com.google.android.gms.internal.ads.zzbkl) = 
                              (wrap: com.google.android.gms.internal.ads.zzbkj : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzbkj) = (r4v0 'this' com.google.android.gms.internal.ads.zzbkm A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzbkm.zzfkp com.google.android.gms.internal.ads.zzbkj)
                              (wrap: java.lang.Runnable : 0x0002: IGET  (r1v0 java.lang.Runnable) = (r4v0 'this' com.google.android.gms.internal.ads.zzbkm A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzbkm.zzfkq java.lang.Runnable)
                             call: com.google.android.gms.internal.ads.zzbkl.<init>(com.google.android.gms.internal.ads.zzbkj, java.lang.Runnable):void type: CONSTRUCTOR)
                             type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: com.google.android.gms.internal.ads.zzbkm.run():void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r3v0 com.google.android.gms.internal.ads.zzbkl) = 
                              (wrap: com.google.android.gms.internal.ads.zzbkj : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzbkj) = (r4v0 'this' com.google.android.gms.internal.ads.zzbkm A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzbkm.zzfkp com.google.android.gms.internal.ads.zzbkj)
                              (wrap: java.lang.Runnable : 0x0002: IGET  (r1v0 java.lang.Runnable) = (r4v0 'this' com.google.android.gms.internal.ads.zzbkm A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzbkm.zzfkq java.lang.Runnable)
                             call: com.google.android.gms.internal.ads.zzbkl.<init>(com.google.android.gms.internal.ads.zzbkj, java.lang.Runnable):void type: CONSTRUCTOR in method: com.google.android.gms.internal.ads.zzbkm.run():void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 15 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.gms.internal.ads.zzbkl, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 21 more
                            */
                        /*
                            this = this;
                            com.google.android.gms.internal.ads.zzbkj r0 = r4.zzfkp
                            java.lang.Runnable r1 = r4.zzfkq
                            com.google.android.gms.internal.ads.zzdvw r2 = com.google.android.gms.internal.ads.zzbbi.zzedy
                            com.google.android.gms.internal.ads.zzbkl r3 = new com.google.android.gms.internal.ads.zzbkl
                            r3.<init>(r0, r1)
                            r2.execute(r3)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkm.run():void");
                    }
                };
            }
            if (booleanValue2) {
                zzp.zzkx().zza(this.zzvr, this.zzbpa, str, zzbkm);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbbd.zzfc("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzbbd.zzfc("Context is null. Failed to open debug menu.");
            return;
        }
        zzayy zzayy = new zzayy(context);
        zzayy.setAdUnitId(str);
        zzayy.zzae(this.zzbpa.zzbra);
        zzayy.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized void zzch(String str) {
        zzaat.initialize(this.zzvr);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcse)).booleanValue()) {
                zzp.zzkx().zza(this.zzvr, this.zzbpa, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zzci(String str) {
        this.zzfkm.zzgq(str);
    }

    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzamp> zzwr = zzp.zzkt().zzwj().zzxe().zzwr();
        if (!(zzwr == null || zzwr.isEmpty())) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzbbd.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfkk.zzans()) {
                HashMap hashMap = new HashMap();
                for (zzamp zzamp : zzwr.values()) {
                    for (zzamq zzamq : zzamp.zzdiq) {
                        String str = zzamq.zzdjv;
                        for (String str2 : zzamq.zzdjn) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzcrg<zzdlx, zzcsn> zzf = this.zzfkl.zzf(str3, jSONObject);
                        if (zzf != null) {
                            AdapterT adaptert = zzf.zzdkn;
                            if (!adaptert.isInitialized()) {
                                if (adaptert.zztt()) {
                                    adaptert.zza(this.zzvr, (zzcsn) zzf.zzglc, (List) entry.getValue());
                                    String valueOf = String.valueOf(str3);
                                    zzbbd.zzef(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdlr e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str3);
                        sb.append("\"");
                        zzbbd.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized float zzqd() {
        return zzp.zzku().zzqd();
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final synchronized boolean zzqe() {
        return zzp.zzku().zzqe();
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final List<zzaif> zzqf() throws RemoteException {
        return this.zzfkn.zzaoy();
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zzqg() {
        this.zzfkn.disable();
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zza(zzamu zzamu) throws RemoteException {
        this.zzfkk.zzb(zzamu);
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zza(zzaim zzaim) throws RemoteException {
        this.zzfkn.zzb(zzaim);
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void zza(zzzw zzzw) throws RemoteException {
        this.zzbqm.zza(this.zzvr, zzzw);
    }
}
