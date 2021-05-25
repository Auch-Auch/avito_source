package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzbfy {
    public static zzdvt<zzbfq> zza(Context context, zzbbg zzbbg, String str, zzeg zzeg, zzb zzb) {
        return zzdvl.zzb(zzdvl.zzaf(null), new zzduv(context, zzeg, zzbbg, zzb, str) { // from class: com.google.android.gms.internal.ads.zzbgb
            private final Context zzcxz;
            private final zzeg zzdgl;
            private final zzbbg zzene;
            private final zzb zzenf;
            private final String zzeng;

            {
                this.zzcxz = r1;
                this.zzdgl = r2;
                this.zzene = r3;
                this.zzenf = r4;
                this.zzeng = r5;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                Context context2 = this.zzcxz;
                zzeg zzeg2 = this.zzdgl;
                zzbbg zzbbg2 = this.zzene;
                zzb zzb2 = this.zzenf;
                String str2 = this.zzeng;
                zzp.zzkq();
                zzbfq zza = zzbfy.zza(context2, zzbhj.zzacu(), "", false, false, zzeg2, null, zzbbg2, null, null, zzb2, zzto.zzmy(), null, false);
                zzbbr zzl = zzbbr.zzl(zza);
                zza.zzabe().zza(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: INVOKE  
                      (wrap: com.google.android.gms.internal.ads.zzbhc : 0x0026: INVOKE  (r2v1 com.google.android.gms.internal.ads.zzbhc) = (r0v1 'zza' com.google.android.gms.internal.ads.zzbfq) type: INTERFACE call: com.google.android.gms.internal.ads.zzbfq.zzabe():com.google.android.gms.internal.ads.zzbhc)
                      (wrap: com.google.android.gms.internal.ads.zzbgd : 0x002c: CONSTRUCTOR  (r3v1 com.google.android.gms.internal.ads.zzbgd) = (r1v1 'zzl' com.google.android.gms.internal.ads.zzbbr) call: com.google.android.gms.internal.ads.zzbgd.<init>(com.google.android.gms.internal.ads.zzbbr):void type: CONSTRUCTOR)
                     type: INTERFACE call: com.google.android.gms.internal.ads.zzbhc.zza(com.google.android.gms.internal.ads.zzbhf):void in method: com.google.android.gms.internal.ads.zzbgb.zzf(java.lang.Object):com.google.android.gms.internal.ads.zzdvt, file: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: CONSTRUCTOR  (r3v1 com.google.android.gms.internal.ads.zzbgd) = (r1v1 'zzl' com.google.android.gms.internal.ads.zzbbr) call: com.google.android.gms.internal.ads.zzbgd.<init>(com.google.android.gms.internal.ads.zzbbr):void type: CONSTRUCTOR in method: com.google.android.gms.internal.ads.zzbgb.zzf(java.lang.Object):com.google.android.gms.internal.ads.zzdvt, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.gms.internal.ads.zzbgd, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    android.content.Context r0 = r14.zzcxz
                    com.google.android.gms.internal.ads.zzeg r5 = r14.zzdgl
                    com.google.android.gms.internal.ads.zzbbg r7 = r14.zzene
                    com.google.android.gms.ads.internal.zzb r10 = r14.zzenf
                    java.lang.String r15 = r14.zzeng
                    com.google.android.gms.ads.internal.zzp.zzkq()
                    com.google.android.gms.internal.ads.zzbhj r1 = com.google.android.gms.internal.ads.zzbhj.zzacu()
                    com.google.android.gms.internal.ads.zzto r11 = com.google.android.gms.internal.ads.zzto.zzmy()
                    java.lang.String r2 = ""
                    r3 = 0
                    r4 = 0
                    r6 = 0
                    r8 = 0
                    r9 = 0
                    r12 = 0
                    r13 = 0
                    com.google.android.gms.internal.ads.zzbfq r0 = com.google.android.gms.internal.ads.zzbfy.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    com.google.android.gms.internal.ads.zzbbr r1 = com.google.android.gms.internal.ads.zzbbr.zzl(r0)
                    com.google.android.gms.internal.ads.zzbhc r2 = r0.zzabe()
                    com.google.android.gms.internal.ads.zzbgd r3 = new com.google.android.gms.internal.ads.zzbgd
                    r3.<init>(r1)
                    r2.zza(r3)
                    r0.loadUrl(r15)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgb.zzf(java.lang.Object):com.google.android.gms.internal.ads.zzdvt");
            }
        }, zzbbi.zzedy);
    }

    public static zzbfq zza(Context context, zzbhj zzbhj, String str, boolean z, boolean z2, @Nullable zzeg zzeg, zzabt zzabt, zzbbg zzbbg, zzabk zzabk, zzk zzk, zzb zzb, zzto zzto, zzsq zzsq, boolean z3) throws zzbgc {
        zzaat.initialize(context);
        if (zzacz.zzdbz.get().booleanValue()) {
            return zzbhp.zza(context, zzbhj, str, z, z2, zzeg, zzabt, zzbbg, null, zzk, zzb, zzto, zzsq, z3);
        }
        try {
            return (zzbfq) zzbal.zza(new zzdsz(context, zzbhj, str, z, z2, zzeg, zzabt, zzbbg, null, zzk, zzb, zzto, zzsq, z3) { // from class: com.google.android.gms.internal.ads.zzbga
                private final Context zzcxz;
                private final String zzdin;
                private final zzbhj zzems;
                private final boolean zzemt;
                private final boolean zzemu;
                private final zzeg zzemv;
                private final zzabt zzemw;
                private final zzbbg zzemx;
                private final zzabk zzemy = null;
                private final zzk zzemz;
                private final zzb zzena;
                private final zzto zzenb;
                private final zzsq zzenc;
                private final boolean zzend;

                {
                    this.zzcxz = r1;
                    this.zzems = r2;
                    this.zzdin = r3;
                    this.zzemt = r4;
                    this.zzemu = r5;
                    this.zzemv = r6;
                    this.zzemw = r7;
                    this.zzemx = r8;
                    this.zzemz = r10;
                    this.zzena = r11;
                    this.zzenb = r12;
                    this.zzenc = r13;
                    this.zzend = r14;
                }

                @Override // com.google.android.gms.internal.ads.zzdsz
                public final Object get() {
                    Context context2 = this.zzcxz;
                    zzbhj zzbhj2 = this.zzems;
                    String str2 = this.zzdin;
                    boolean z4 = this.zzemt;
                    boolean z5 = this.zzemu;
                    zzeg zzeg2 = this.zzemv;
                    zzabt zzabt2 = this.zzemw;
                    zzbbg zzbbg2 = this.zzemx;
                    zzabk zzabk2 = this.zzemy;
                    zzk zzk2 = this.zzemz;
                    zzb zzb2 = this.zzena;
                    zzto zzto2 = this.zzenb;
                    zzbgf zzbgf = new zzbgf(zzbgg.zzb(context2, zzbhj2, str2, z4, z5, zzeg2, zzabt2, zzbbg2, zzabk2, zzk2, zzb2, zzto2, this.zzenc, this.zzend));
                    zzbgf.setWebViewClient(zzp.zzkr().zza(zzbgf, zzto2, z5));
                    zzbgf.setWebChromeClient(new zzbfi(zzbgf));
                    return zzbgf;
                }
            });
        } catch (Throwable th) {
            throw new zzbgc("Webview initialization failed.", th);
        }
    }
}
