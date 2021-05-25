package a2.j.b.e.a.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.assetpacks.dd;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.splitinstall.z;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
public final class k2 implements AssetPackManager {
    public static final aa k = new aa("AssetPackManager");
    public final a0 a;
    public final ce<q2> b;
    public final v c;
    public final z d;
    public final i1 e;
    public final t0 f;
    public final m0 g;
    public final ce<Executor> h;
    public final Handler i = new Handler(Looper.getMainLooper());
    public boolean j;

    public k2(a0 a0Var, ce<q2> ceVar, v vVar, z zVar, i1 i1Var, t0 t0Var, m0 m0Var, ce<Executor> ceVar2) {
        this.a = a0Var;
        this.b = ceVar;
        this.c = vVar;
        this.d = zVar;
        this.e = i1Var;
        this.f = t0Var;
        this.g = m0Var;
        this.h = ceVar2;
    }

    public final void a() {
        a0 a0Var = this.a;
        a0Var.getClass();
        this.b.a().a().addOnSuccessListener(this.h.a(), new OnSuccessListener(a0Var) { // from class: a2.j.b.e.a.b.g2
            public final a0 a;

            {
                this.a = r1;
            }

            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                a0 a0Var2 = this.a;
                List list = (List) obj;
                int a3 = a0Var2.b.a();
                ArrayList arrayList = (ArrayList) a0Var2.u();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    File file = (File) arrayList.get(i2);
                    if (!list.contains(file.getName()) && a0.g(file) != ((long) a3)) {
                        a0.n(file);
                    }
                }
            }
        }).addOnFailureListener(this.h.a(), h2.a);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackStates cancel(List<String> list) {
        i1 i1Var = this.e;
        Map map = (Map) i1Var.a(new h1(i1Var, list) { // from class: a2.j.b.e.a.b.b1
            public final i1 a;
            public final List b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // a2.j.b.e.a.b.h1
            public final Object a() {
                int i2;
                i1 i1Var2 = this.a;
                List<String> list2 = this.b;
                Map map2 = (Map) i1Var2.a(new y0(i1Var2, list2));
                HashMap hashMap = new HashMap();
                for (String str : list2) {
                    f1 f1Var = (f1) map2.get(str);
                    if (f1Var == null) {
                        i2 = 8;
                    } else {
                        if (dd.a(f1Var.c.c)) {
                            try {
                                f1Var.c.c = 6;
                                i1Var2.d.a().execute(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  
                                      (wrap: java.util.concurrent.Executor : 0x0040: INVOKE  (r6v6 java.util.concurrent.Executor) = 
                                      (wrap: com.google.android.play.core.internal.ce<java.util.concurrent.Executor> : 0x003e: IGET  (r6v5 com.google.android.play.core.internal.ce<java.util.concurrent.Executor>) = (r0v0 'i1Var2' a2.j.b.e.a.b.i1) a2.j.b.e.a.b.i1.d com.google.android.play.core.internal.ce)
                                     type: INTERFACE call: com.google.android.play.core.internal.ce.a():java.lang.Object)
                                      (wrap: a2.j.b.e.a.b.c1 : 0x0048: CONSTRUCTOR  (r7v3 a2.j.b.e.a.b.c1) = (r0v0 'i1Var2' a2.j.b.e.a.b.i1), (r5v1 'f1Var' a2.j.b.e.a.b.f1) call: a2.j.b.e.a.b.c1.<init>(a2.j.b.e.a.b.i1, a2.j.b.e.a.b.f1):void type: CONSTRUCTOR)
                                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.j.b.e.a.b.b1.a():java.lang.Object, file: classes6.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:316)
                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: CONSTRUCTOR  (r7v3 a2.j.b.e.a.b.c1) = (r0v0 'i1Var2' a2.j.b.e.a.b.i1), (r5v1 'f1Var' a2.j.b.e.a.b.f1) call: a2.j.b.e.a.b.c1.<init>(a2.j.b.e.a.b.i1, a2.j.b.e.a.b.f1):void type: CONSTRUCTOR in method: a2.j.b.e.a.b.b1.a():java.lang.Object, file: classes6.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                    	... 39 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.e.a.b.c1, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                    	... 45 more
                                    */
                                /*
                                    this = this;
                                    a2.j.b.e.a.b.i1 r0 = r10.a
                                    java.util.List r1 = r10.b
                                    a2.j.b.e.a.b.y0 r2 = new a2.j.b.e.a.b.y0
                                    r2.<init>(r0, r1)
                                    java.lang.Object r2 = r0.a(r2)
                                    java.util.Map r2 = (java.util.Map) r2
                                    java.util.HashMap r3 = new java.util.HashMap
                                    r3.<init>()
                                    java.util.Iterator r1 = r1.iterator()
                                L_0x0018:
                                    boolean r4 = r1.hasNext()
                                    if (r4 == 0) goto L_0x0076
                                    java.lang.Object r4 = r1.next()
                                    java.lang.String r4 = (java.lang.String) r4
                                    java.lang.Object r5 = r2.get(r4)
                                    a2.j.b.e.a.b.f1 r5 = (a2.j.b.e.a.b.f1) r5
                                    if (r5 != 0) goto L_0x002f
                                    r5 = 8
                                    goto L_0x006e
                                L_0x002f:
                                    a2.j.b.e.a.b.e1 r6 = r5.c
                                    int r6 = r6.c
                                    boolean r6 = com.google.android.play.core.assetpacks.dd.a(r6)
                                    if (r6 == 0) goto L_0x006a
                                    a2.j.b.e.a.b.e1 r6 = r5.c     // Catch:{ q0 -> 0x0054 }
                                    r7 = 6
                                    r6.c = r7     // Catch:{ q0 -> 0x0054 }
                                    com.google.android.play.core.internal.ce<java.util.concurrent.Executor> r6 = r0.d     // Catch:{ q0 -> 0x0054 }
                                    java.lang.Object r6 = r6.a()     // Catch:{ q0 -> 0x0054 }
                                    java.util.concurrent.Executor r6 = (java.util.concurrent.Executor) r6     // Catch:{ q0 -> 0x0054 }
                                    a2.j.b.e.a.b.c1 r7 = new a2.j.b.e.a.b.c1     // Catch:{ q0 -> 0x0054 }
                                    r7.<init>(r0, r5)     // Catch:{ q0 -> 0x0054 }
                                    r6.execute(r7)     // Catch:{ q0 -> 0x0054 }
                                    a2.j.b.e.a.b.t0 r6 = r0.c     // Catch:{ q0 -> 0x0054 }
                                    r6.a(r4)     // Catch:{ q0 -> 0x0054 }
                                    goto L_0x006a
                                L_0x0054:
                                    com.google.android.play.core.internal.aa r6 = a2.j.b.e.a.b.i1.g
                                    r7 = 2
                                    java.lang.Object[] r7 = new java.lang.Object[r7]
                                    r8 = 0
                                    int r9 = r5.a
                                    java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                                    r7[r8] = r9
                                    r8 = 1
                                    r7[r8] = r4
                                    java.lang.String r8 = "Session %d with pack %s does not exist, no need to cancel."
                                    r6.c(r8, r7)
                                L_0x006a:
                                    a2.j.b.e.a.b.e1 r5 = r5.c
                                    int r5 = r5.c
                                L_0x006e:
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                    r3.put(r4, r5)
                                    goto L_0x0018
                                L_0x0076:
                                    return r3
                                */
                                throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.b.b1.a():java.lang.Object");
                            }
                        });
                        HashMap hashMap = new HashMap();
                        for (String str : list) {
                            Integer num = (Integer) map.get(str);
                            hashMap.put(str, AssetPackState.a(str, num != null ? num.intValue() : 0, 0, 0, 0, 0.0d));
                        }
                        this.b.a().a(list);
                        return AssetPackStates.a(0, hashMap);
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final void clearListeners() {
                        this.c.a();
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final Task<AssetPackStates> fetch(List<String> list) {
                        ArrayList arrayList = new ArrayList();
                        for (String str : list) {
                            if (!this.a.f(str)) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0);
                            bundle.putInt("error_code", 0);
                            for (String str2 : list) {
                                bundle.putInt(h.a("status", str2), 4);
                                bundle.putInt(h.a("error_code", str2), 0);
                                bundle.putLong(h.a("total_bytes_to_download", str2), 0);
                                bundle.putLong(h.a("bytes_downloaded", str2), 0);
                            }
                            bundle.putStringArrayList("pack_names", new ArrayList<>(list));
                            bundle.putLong("total_bytes_to_download", 0);
                            bundle.putLong("bytes_downloaded", 0);
                            return Tasks.a(AssetPackStates.a(bundle, this.f));
                        }
                        ArrayList arrayList2 = new ArrayList(list);
                        arrayList2.removeAll(arrayList);
                        return this.b.a().c(arrayList2, arrayList);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
                    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.google.android.play.core.assetpacks.AssetLocation getAssetLocation(java.lang.String r18, java.lang.String r19) {
                        /*
                        // Method dump skipped, instructions count: 339
                        */
                        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.b.k2.getAssetLocation(java.lang.String, java.lang.String):com.google.android.play.core.assetpacks.AssetLocation");
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final AssetPackLocation getPackLocation(String str) {
                        if (!this.j) {
                            this.h.a().execute(new i2(this));
                            this.j = true;
                        }
                        if (this.a.f(str)) {
                            try {
                                return this.a.h(str);
                            } catch (IOException unused) {
                                return null;
                            }
                        } else if (this.d.a().contains(str)) {
                            return AssetPackLocation.a;
                        } else {
                            return null;
                        }
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final Map<String, AssetPackLocation> getPackLocations() {
                        a0 a0Var = this.a;
                        Objects.requireNonNull(a0Var);
                        HashMap hashMap = new HashMap();
                        try {
                            Iterator it = ((ArrayList) a0Var.u()).iterator();
                            while (it.hasNext()) {
                                File file = (File) it.next();
                                AssetPackLocation h2 = a0Var.h(file.getName());
                                if (h2 != null) {
                                    hashMap.put(file.getName(), h2);
                                }
                            }
                        } catch (IOException e2) {
                            a0.c.b("Could not process directory while scanning installed packs: %s", e2);
                        }
                        HashMap hashMap2 = new HashMap();
                        for (String str : this.d.a()) {
                            hashMap2.put(str, AssetPackLocation.a);
                        }
                        hashMap.putAll(hashMap2);
                        return hashMap;
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final Task<AssetPackStates> getPackStates(List<String> list) {
                        return this.b.a().d(list, new x(this) { // from class: a2.j.b.e.a.b.s0
                            public final k2 a;

                            {
                                this.a = r1;
                            }

                            @Override // a2.j.b.e.a.b.x
                            public final int a(int i2, String str) {
                                k2 k2Var = this.a;
                                if (!k2Var.a.f(str) && i2 == 4) {
                                    return 8;
                                }
                                if (!k2Var.a.f(str) || i2 == 4) {
                                    return i2;
                                }
                                return 4;
                            }
                        });
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
                        boolean b2 = this.c.b();
                        this.c.a((StateUpdatedListener) assetPackStateUpdateListener);
                        if (!b2) {
                            a();
                        }
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final Task<Void> removePack(String str) {
                        i iVar = new i();
                        this.h.a().execute(new Runnable(this, str, iVar) { // from class: a2.j.b.e.a.b.p1
                            public final k2 a;
                            public final String b;
                            public final i c;

                            {
                                this.a = r1;
                                this.b = r2;
                                this.c = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                k2 k2Var = this.a;
                                String str2 = this.b;
                                i iVar2 = this.c;
                                if (k2Var.a.q(str2)) {
                                    iVar2.a((i) null);
                                    k2Var.b.a().a(str2);
                                    return;
                                }
                                iVar2.a((Exception) new IOException(String.format("Failed to remove pack %s.", str2)));
                            }
                        });
                        return iVar.a();
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
                        if (this.g.a == null) {
                            return Tasks.a((Exception) new AssetPackException(-12));
                        }
                        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
                        intent.putExtra("confirmation_intent", this.g.a);
                        i iVar = new i();
                        intent.putExtra("result_receiver", new j2(this, this.i, iVar));
                        activity.startActivity(intent);
                        return iVar.a();
                    }

                    @Override // com.google.android.play.core.assetpacks.AssetPackManager
                    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
                        this.c.b(assetPackStateUpdateListener);
                    }
                }
