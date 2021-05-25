package a2.j.b.e.a.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.listener.b;
import java.util.ArrayList;
import java.util.concurrent.Executor;
public final class v extends b<AssetPackState> {
    public final i1 g;
    public final r0 h;
    public final ce<q2> i;
    public final m0 j;
    public final t0 k;
    public final ce<Executor> l;
    public final ce<Executor> m;
    public final Handler n = new Handler(Looper.getMainLooper());

    public v(Context context, i1 i1Var, r0 r0Var, ce<q2> ceVar, t0 t0Var, m0 m0Var, ce<Executor> ceVar2, ce<Executor> ceVar3) {
        super(new aa("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.g = i1Var;
        this.h = r0Var;
        this.i = ceVar;
        this.k = t0Var;
        this.j = m0Var;
        this.l = ceVar2;
        this.m = ceVar3;
    }

    @Override // com.google.android.play.core.listener.b
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.a.b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            AssetPackState a = AssetPackState.a(bundleExtra, stringArrayList.get(0), this.k, w.a);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.j.a = pendingIntent;
            }
            this.m.a().execute(new Runnable(this, bundleExtra, a) { // from class: a2.j.b.e.a.b.t
                public final v a;
                public final Bundle b;
                public final AssetPackState c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v vVar = this.a;
                    Bundle bundle = this.b;
                    AssetPackState assetPackState = this.c;
                    i1 i1Var = vVar.g;
                    if (((Boolean) i1Var.a(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  (r1v3 boolean) = 
                          (wrap: java.lang.Boolean : 0x0011: CHECK_CAST (r1v2 java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x000d: INVOKE  (r1v1 java.lang.Object) = 
                          (r3v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.w0 : 0x000a: CONSTRUCTOR  (r4v0 a2.j.b.e.a.b.w0) = (r3v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.w0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object))
                         type: VIRTUAL call: java.lang.Boolean.booleanValue():boolean in method: a2.j.b.e.a.b.t.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:125)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CHECK_CAST (r1v2 java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x000d: INVOKE  (r1v1 java.lang.Object) = 
                          (r3v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.w0 : 0x000a: CONSTRUCTOR  (r4v0 a2.j.b.e.a.b.w0) = (r3v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.w0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object) in method: a2.j.b.e.a.b.t.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:749)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 21 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  (r1v1 java.lang.Object) = 
                          (r3v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.w0 : 0x000a: CONSTRUCTOR  (r4v0 a2.j.b.e.a.b.w0) = (r3v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.w0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object in method: a2.j.b.e.a.b.t.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:317)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 27 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r4v0 a2.j.b.e.a.b.w0) = (r3v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.w0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR in method: a2.j.b.e.a.b.t.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 31 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.e.a.b.w0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 37 more
                        */
                    /*
                        this = this;
                        a2.j.b.e.a.b.v r0 = r5.a
                        android.os.Bundle r1 = r5.b
                        com.google.android.play.core.assetpacks.AssetPackState r2 = r5.c
                        a2.j.b.e.a.b.i1 r3 = r0.g
                        a2.j.b.e.a.b.w0 r4 = new a2.j.b.e.a.b.w0
                        r4.<init>(r3, r1)
                        java.lang.Object r1 = r3.a(r4)
                        java.lang.Boolean r1 = (java.lang.Boolean) r1
                        boolean r1 = r1.booleanValue()
                        if (r1 == 0) goto L_0x002e
                        android.os.Handler r1 = r0.n
                        a2.j.b.e.a.b.s r3 = new a2.j.b.e.a.b.s
                        r3.<init>(r0, r2)
                        r1.post(r3)
                        com.google.android.play.core.internal.ce<a2.j.b.e.a.b.q2> r0 = r0.i
                        java.lang.Object r0 = r0.a()
                        a2.j.b.e.a.b.q2 r0 = (a2.j.b.e.a.b.q2) r0
                        r0.b()
                    L_0x002e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.b.t.run():void");
                }
            });
            this.l.a().execute(new Runnable(this, bundleExtra) { // from class: a2.j.b.e.a.b.u
                public final v a;
                public final Bundle b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v vVar = this.a;
                    Bundle bundle = this.b;
                    i1 i1Var = vVar.g;
                    if (((Boolean) i1Var.a(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  (r1v3 boolean) = 
                          (wrap: java.lang.Boolean : 0x000f: CHECK_CAST (r1v2 java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x000b: INVOKE  (r1v1 java.lang.Object) = 
                          (r2v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.v0 : 0x0008: CONSTRUCTOR  (r3v0 a2.j.b.e.a.b.v0) = (r2v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.v0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object))
                         type: VIRTUAL call: java.lang.Boolean.booleanValue():boolean in method: a2.j.b.e.a.b.u.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:125)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: CHECK_CAST (r1v2 java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x000b: INVOKE  (r1v1 java.lang.Object) = 
                          (r2v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.v0 : 0x0008: CONSTRUCTOR  (r3v0 a2.j.b.e.a.b.v0) = (r2v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.v0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object) in method: a2.j.b.e.a.b.u.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:749)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  (r1v1 java.lang.Object) = 
                          (r2v0 'i1Var' a2.j.b.e.a.b.i1)
                          (wrap: a2.j.b.e.a.b.v0 : 0x0008: CONSTRUCTOR  (r3v0 a2.j.b.e.a.b.v0) = (r2v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.v0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR)
                         type: VIRTUAL call: a2.j.b.e.a.b.i1.a(a2.j.b.e.a.b.h1):java.lang.Object in method: a2.j.b.e.a.b.u.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:317)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 25 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r3v0 a2.j.b.e.a.b.v0) = (r2v0 'i1Var' a2.j.b.e.a.b.i1), (r1v0 'bundle' android.os.Bundle) call: a2.j.b.e.a.b.v0.<init>(a2.j.b.e.a.b.i1, android.os.Bundle):void type: CONSTRUCTOR in method: a2.j.b.e.a.b.u.run():void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.e.a.b.v0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 231
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.b.u.run():void");
                }
            });
            return;
        }
        this.a.b("Empty bundle received from broadcast.", new Object[0]);
    }
}
