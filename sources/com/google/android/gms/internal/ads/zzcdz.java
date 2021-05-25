package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.view.View;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
public final class zzcdz {
    private final zzcdd zzfwx;
    private final zzchc zzfzs;
    private final zzcih zzfzy;
    private final zzbmj zzfzz;

    public zzcdz(zzcih zzcih, zzchc zzchc, zzbmj zzbmj, zzcdd zzcdd) {
        this.zzfzy = zzcih;
        this.zzfzs = zzchc;
        this.zzfzz = zzbmj;
        this.zzfwx = zzcdd;
    }

    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zzbbd.zzfd("Hiding native ads overlay.");
        zzbfq.getView().setVisibility(8);
        this.zzfzz.zzbf(false);
    }

    public final View zzamy() throws zzbgc {
        zzbfq zza = this.zzfzy.zza(zzvj.zzpi(), false);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzcec
            private final zzcdz zzgaa;

            {
                this.zzgaa = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgaa.zzd((zzbfq) obj, map);
            }
        });
        zza.zza("/adMuted", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzceb
            private final zzcdz zzgaa;

            {
                this.zzgaa = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgaa.zzc((zzbfq) obj, map);
            }
        });
        this.zzfzs.zza(new WeakReference(zza), "/loadHtml", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzcee
            private final zzcdz zzgaa;

            {
                this.zzgaa = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                zzbfq zzbfq = (zzbfq) obj;
                zzbfq.zzabe().zza(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
                      (wrap: com.google.android.gms.internal.ads.zzbhc : 0x0005: INVOKE  (r8v1 com.google.android.gms.internal.ads.zzbhc) = (r1v1 'zzbfq' com.google.android.gms.internal.ads.zzbfq) type: INTERFACE call: com.google.android.gms.internal.ads.zzbfq.zzabe():com.google.android.gms.internal.ads.zzbhc)
                      (wrap: com.google.android.gms.internal.ads.zzcef : 0x000b: CONSTRUCTOR  (r2v0 com.google.android.gms.internal.ads.zzcef) = 
                      (wrap: com.google.android.gms.internal.ads.zzcdz : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzcdz) = (r7v0 'this' com.google.android.gms.internal.ads.zzcee A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzcee.zzgaa com.google.android.gms.internal.ads.zzcdz)
                      (r9v0 'map' java.util.Map)
                     call: com.google.android.gms.internal.ads.zzcef.<init>(com.google.android.gms.internal.ads.zzcdz, java.util.Map):void type: CONSTRUCTOR)
                     type: INTERFACE call: com.google.android.gms.internal.ads.zzbhc.zza(com.google.android.gms.internal.ads.zzbhf):void in method: com.google.android.gms.internal.ads.zzcee.zza(java.lang.Object, java.util.Map):void, file: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r2v0 com.google.android.gms.internal.ads.zzcef) = 
                      (wrap: com.google.android.gms.internal.ads.zzcdz : 0x0000: IGET  (r0v0 com.google.android.gms.internal.ads.zzcdz) = (r7v0 'this' com.google.android.gms.internal.ads.zzcee A[IMMUTABLE_TYPE, THIS]) com.google.android.gms.internal.ads.zzcee.zzgaa com.google.android.gms.internal.ads.zzcdz)
                      (r9v0 'map' java.util.Map)
                     call: com.google.android.gms.internal.ads.zzcef.<init>(com.google.android.gms.internal.ads.zzcdz, java.util.Map):void type: CONSTRUCTOR in method: com.google.android.gms.internal.ads.zzcee.zza(java.lang.Object, java.util.Map):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.gms.internal.ads.zzcef, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    com.google.android.gms.internal.ads.zzcdz r0 = r7.zzgaa
                    r1 = r8
                    com.google.android.gms.internal.ads.zzbfq r1 = (com.google.android.gms.internal.ads.zzbfq) r1
                    com.google.android.gms.internal.ads.zzbhc r8 = r1.zzabe()
                    com.google.android.gms.internal.ads.zzcef r2 = new com.google.android.gms.internal.ads.zzcef
                    r2.<init>(r0, r9)
                    r8.zza(r2)
                    java.lang.String r8 = "overlayHtml"
                    java.lang.Object r8 = r9.get(r8)
                    r3 = r8
                    java.lang.String r3 = (java.lang.String) r3
                    java.lang.String r8 = "baseUrl"
                    java.lang.Object r8 = r9.get(r8)
                    r2 = r8
                    java.lang.String r2 = (java.lang.String) r2
                    boolean r8 = android.text.TextUtils.isEmpty(r2)
                    if (r8 == 0) goto L_0x0031
                    java.lang.String r8 = "text/html"
                    java.lang.String r9 = "UTF-8"
                    r1.loadData(r3, r8, r9)
                    return
                L_0x0031:
                    r6 = 0
                    java.lang.String r4 = "text/html"
                    java.lang.String r5 = "UTF-8"
                    r1.loadDataWithBaseURL(r2, r3, r4, r5, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcee.zza(java.lang.Object, java.util.Map):void");
            }
        });
        this.zzfzs.zza(new WeakReference(zza), "/showOverlay", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzced
            private final zzcdz zzgaa;

            {
                this.zzgaa = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgaa.zzb((zzbfq) obj, map);
            }
        });
        this.zzfzs.zza(new WeakReference(zza), "/hideOverlay", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzceg
            private final zzcdz zzgaa;

            {
                this.zzgaa = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgaa.zza((zzbfq) obj, map);
            }
        });
        return zza.getView();
    }

    public final /* synthetic */ void zzb(zzbfq zzbfq, Map map) {
        zzbbd.zzfd("Showing native ads overlay.");
        zzbfq.getView().setVisibility(0);
        this.zzfzz.zzbf(true);
    }

    public final /* synthetic */ void zzc(zzbfq zzbfq, Map map) {
        this.zzfwx.zzald();
    }

    public final /* synthetic */ void zzd(zzbfq zzbfq, Map map) {
        this.zzfzs.zza("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap k0 = a.k0(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "htmlLoaded");
        k0.put("id", (String) map.get("id"));
        this.zzfzs.zza("sendMessageToNativeJs", k0);
    }
}
