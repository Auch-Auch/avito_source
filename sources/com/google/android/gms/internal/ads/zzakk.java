package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzakk {
    private final Object lock;
    private int status;
    private final zzbbg zzbpa;
    private final String zzdgn;
    private zzazm<zzajx> zzdgo;
    private zzazm<zzajx> zzdgp;
    @Nullable
    private zzalb zzdgq;
    private final Context zzvr;

    public zzakk(Context context, zzbbg zzbbg, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdgn = str;
        this.zzvr = context.getApplicationContext();
        this.zzbpa = zzbbg;
        this.zzdgo = new zzaky();
        this.zzdgp = new zzaky();
    }

    public final zzalb zza(@Nullable zzeg zzeg) {
        zzalb zzalb = new zzalb(this.zzdgp);
        zzbbi.zzedy.execute(new Runnable(this, zzeg, zzalb) { // from class: com.google.android.gms.internal.ads.zzakj
            private final zzakk zzdgk;
            private final zzeg zzdgl;
            private final zzalb zzdgm;

            {
                this.zzdgk = r1;
                this.zzdgl = r2;
                this.zzdgm = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdgk.zza(this.zzdgl, this.zzdgm);
            }
        });
        zzalb.zza(new zzakt(this, zzalb), new zzakw(this, zzalb));
        return zzalb;
    }

    public final zzakx zzb(@Nullable zzeg zzeg) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                zzalb zzalb = this.zzdgq;
                if (zzalb != null && this.status == 0) {
                    zzalb.zza(new zzbbu(this) { // from class: com.google.android.gms.internal.ads.zzakm
                        private final zzakk zzdgk;

                        {
                            this.zzdgk = r1;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbbu
                        public final void zzh(Object obj) {
                            this.zzdgk.zza((zzajx) obj);
                        }
                    }, zzakl.zzdgr);
                }
            }
            zzalb zzalb2 = this.zzdgq;
            if (zzalb2 == null || zzalb2.getStatus() == -1) {
                this.status = 2;
                zzalb zza = zza((zzeg) null);
                this.zzdgq = zza;
                return zza.zztg();
            }
            int i = this.status;
            if (i == 0) {
                return this.zzdgq.zztg();
            } else if (i == 1) {
                this.status = 2;
                zza((zzeg) null);
                return this.zzdgq.zztg();
            } else if (i == 2) {
                return this.zzdgq.zztg();
            } else {
                return this.zzdgq.zztg();
            }
        }
    }

    public final /* synthetic */ void zza(zzajx zzajx) {
        if (zzajx.isDestroyed()) {
            this.status = 1;
        }
    }

    public final /* synthetic */ void zza(zzeg zzeg, zzalb zzalb) {
        zzajx zzajx;
        try {
            Context context = this.zzvr;
            zzbbg zzbbg = this.zzbpa;
            if (zzacz.zzdca.get().booleanValue()) {
                zzajx = new zzajj(context, zzbbg);
            } else {
                zzajx = new zzajz(context, zzbbg, zzeg, null);
            }
            zzajx.zza(new zzaka(this, zzalb, zzajx) { // from class: com.google.android.gms.internal.ads.zzako
                private final zzakk zzdgk;
                private final zzalb zzdgs;
                private final zzajx zzdgt;

                {
                    this.zzdgk = r1;
                    this.zzdgs = r2;
                    this.zzdgt = r3;
                }

                @Override // com.google.android.gms.internal.ads.zzaka
                public final void zzte() {
                    zzayh.zzeaj.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: INVOKE  
                          (wrap: com.google.android.gms.internal.ads.zzdsf : 0x0006: SGET  (r3v0 com.google.android.gms.internal.ads.zzdsf) =  com.google.android.gms.internal.ads.zzayh.zzeaj com.google.android.gms.internal.ads.zzdsf)
                          (wrap: com.google.android.gms.internal.ads.zzakn : 0x000a: CONSTRUCTOR  (r4v0 com.google.android.gms.internal.ads.zzakn) = 
                          (wrap: com.google.android.gms.internal.ads.zzakk : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzakk) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgk com.google.android.gms.internal.ads.zzakk)
                          (wrap: com.google.android.gms.internal.ads.zzalb : 0x0002: IGET  (r1v0 com.google.android.gms.internal.ads.zzalb) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgs com.google.android.gms.internal.ads.zzalb)
                          (wrap: com.google.android.gms.internal.ads.zzajx : 0x0004: IGET  (r2v0 com.google.android.gms.internal.ads.zzajx) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgt com.google.android.gms.internal.ads.zzajx)
                         call: com.google.android.gms.internal.ads.zzakn.<init>(com.google.android.gms.internal.ads.zzakk, com.google.android.gms.internal.ads.zzalb, com.google.android.gms.internal.ads.zzajx):void type: CONSTRUCTOR)
                          (wrap: long : 0x000f: CAST (r0v2 long) = (long) (wrap: int : 0x000d: SGET  (r0v1 int) =  com.google.android.gms.internal.ads.zzakv.zzdhc int))
                         type: VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean in method: com.google.android.gms.internal.ads.zzako.zzte():void, file: classes5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r4v0 com.google.android.gms.internal.ads.zzakn) = 
                          (wrap: com.google.android.gms.internal.ads.zzakk : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzakk) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgk com.google.android.gms.internal.ads.zzakk)
                          (wrap: com.google.android.gms.internal.ads.zzalb : 0x0002: IGET  (r1v0 com.google.android.gms.internal.ads.zzalb) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgs com.google.android.gms.internal.ads.zzalb)
                          (wrap: com.google.android.gms.internal.ads.zzajx : 0x0004: IGET  (r2v0 com.google.android.gms.internal.ads.zzajx) = (r5v0 'this' com.google.android.gms.internal.ads.zzako A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzako.zzdgt com.google.android.gms.internal.ads.zzajx)
                         call: com.google.android.gms.internal.ads.zzakn.<init>(com.google.android.gms.internal.ads.zzakk, com.google.android.gms.internal.ads.zzalb, com.google.android.gms.internal.ads.zzajx):void type: CONSTRUCTOR in method: com.google.android.gms.internal.ads.zzako.zzte():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.gms.internal.ads.zzakn, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 21 more
                        */
                    /*
                        this = this;
                        com.google.android.gms.internal.ads.zzakk r0 = r5.zzdgk
                        com.google.android.gms.internal.ads.zzalb r1 = r5.zzdgs
                        com.google.android.gms.internal.ads.zzajx r2 = r5.zzdgt
                        com.google.android.gms.internal.ads.zzdsf r3 = com.google.android.gms.internal.ads.zzayh.zzeaj
                        com.google.android.gms.internal.ads.zzakn r4 = new com.google.android.gms.internal.ads.zzakn
                        r4.<init>(r0, r1, r2)
                        int r0 = com.google.android.gms.internal.ads.zzakv.zzdhc
                        long r0 = (long) r0
                        r3.postDelayed(r4, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzako.zzte():void");
                }
            });
            zzajx.zza("/jsLoaded", new zzakp(this, zzalb, zzajx));
            zzbai zzbai = new zzbai();
            zzaks zzaks = new zzaks(this, zzeg, zzajx, zzbai);
            zzbai.set(zzaks);
            zzajx.zza("/requestReload", zzaks);
            if (this.zzdgn.endsWith(".js")) {
                zzajx.zzcz(this.zzdgn);
            } else if (this.zzdgn.startsWith("<html>")) {
                zzajx.zzda(this.zzdgn);
            } else {
                zzajx.zzdb(this.zzdgn);
            }
            zzayh.zzeaj.postDelayed(new zzakr(this, zzalb, zzajx), (long) zzakv.zzdhb);
        } catch (Throwable th) {
            zzbbd.zzc("Error creating webview.", th);
            zzp.zzkt().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalb.reject();
        }
    }

    public zzakk(Context context, zzbbg zzbbg, String str, zzazm<zzajx> zzazm, zzazm<zzajx> zzazm2) {
        this(context, zzbbg, str);
        this.zzdgo = zzazm;
        this.zzdgp = zzazm2;
    }

    public final /* synthetic */ void zza(zzalb zzalb, zzajx zzajx) {
        synchronized (this.lock) {
            if (zzalb.getStatus() != -1) {
                if (zzalb.getStatus() != 1) {
                    zzalb.reject();
                    zzdvw zzdvw = zzbbi.zzedy;
                    zzajx.getClass();
                    zzdvw.execute(zzakq.zzb(zzajx));
                    zzaxy.zzei("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }
    }
}
