package a2.j.b.e.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.v;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
public final class r0 implements SplitInstallManager {
    public final Executor a;
    public final Context b;
    public volatile SplitInstallManager c;

    public r0(Context context, Executor executor, g gVar) {
        this.b = v.a(context);
        this.a = executor;
    }

    public final synchronized SplitInstallManager a() {
        String string;
        SplitInstallManager splitInstallManager = this.c;
        if (splitInstallManager != null) {
            return splitInstallManager;
        }
        Context context = this.b;
        File file = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (!(bundle == null || (string = bundle.getString("local_testing_dir")) == null)) {
                file = new File(context.getExternalFilesDir(null), string);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        SplitInstallManager fVar = file == null ? new f(new z(context), context) : FakeSplitInstallManagerFactory.create(context, file);
        this.c = fVar;
        return fVar;
    }

    public final <T> Task<T> b(p0<T> p0Var) {
        SplitInstallManager splitInstallManager = this.c;
        if (splitInstallManager != null) {
            return p0Var.a(splitInstallManager);
        }
        i iVar = new i();
        i iVar2 = new i();
        iVar2.a().addOnCompleteListener(new OnCompleteListener(p0Var, iVar) { // from class: a2.j.b.e.a.i.d0
            public final p0 a;
            public final i b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.android.play.core.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                p0 p0Var2 = this.a;
                i iVar3 = this.b;
                if (task.isSuccessful()) {
                    p0Var2.a((SplitInstallManager) task.getResult()).addOnCompleteListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: INVOKE  
                          (wrap: com.google.android.play.core.tasks.Task : 0x0010: INVOKE  (r4v4 com.google.android.play.core.tasks.Task) = 
                          (r0v0 'p0Var2' a2.j.b.e.a.i.p0)
                          (wrap: com.google.android.play.core.splitinstall.SplitInstallManager : 0x000e: CHECK_CAST (r4v3 com.google.android.play.core.splitinstall.SplitInstallManager) = (com.google.android.play.core.splitinstall.SplitInstallManager) (wrap: java.lang.Object : 0x000a: INVOKE  (r4v2 java.lang.Object) = (r4v0 'task' com.google.android.play.core.tasks.Task) type: VIRTUAL call: com.google.android.play.core.tasks.Task.getResult():java.lang.Object))
                         type: INTERFACE call: a2.j.b.e.a.i.p0.a(com.google.android.play.core.splitinstall.SplitInstallManager):com.google.android.play.core.tasks.Task)
                          (wrap: a2.j.b.e.a.i.f0 : 0x0016: CONSTRUCTOR  (r0v1 a2.j.b.e.a.i.f0) = (r1v0 'iVar3' com.google.android.play.core.tasks.i) call: a2.j.b.e.a.i.f0.<init>(com.google.android.play.core.tasks.i):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.google.android.play.core.tasks.Task.addOnCompleteListener(com.google.android.play.core.tasks.OnCompleteListener):com.google.android.play.core.tasks.Task in method: a2.j.b.e.a.i.d0.onComplete(com.google.android.play.core.tasks.Task):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CONSTRUCTOR  (r0v1 a2.j.b.e.a.i.f0) = (r1v0 'iVar3' com.google.android.play.core.tasks.i) call: a2.j.b.e.a.i.f0.<init>(com.google.android.play.core.tasks.i):void type: CONSTRUCTOR in method: a2.j.b.e.a.i.d0.onComplete(com.google.android.play.core.tasks.Task):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 21 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.e.a.i.f0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 27 more
                        */
                    /*
                        this = this;
                        a2.j.b.e.a.i.p0 r0 = r3.a
                        com.google.android.play.core.tasks.i r1 = r3.b
                        boolean r2 = r4.isSuccessful()
                        if (r2 == 0) goto L_0x001d
                        java.lang.Object r4 = r4.getResult()
                        com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
                        com.google.android.play.core.tasks.Task r4 = r0.a(r4)
                        a2.j.b.e.a.i.f0 r0 = new a2.j.b.e.a.i.f0
                        r0.<init>(r1)
                        r4.addOnCompleteListener(r0)
                        return
                    L_0x001d:
                        java.lang.Exception r4 = r4.getException()
                        r1.a(r4)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.i.d0.onComplete(com.google.android.play.core.tasks.Task):void");
                }
            });
            this.a.execute(new Runnable(this, iVar2) { // from class: a2.j.b.e.a.i.e0
                public final r0 a;
                public final i b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    r0 r0Var = this.a;
                    i iVar3 = this.b;
                    try {
                        iVar3.a((i) r0Var.a());
                    } catch (Exception e) {
                        iVar3.a(e);
                    }
                }
            });
            return iVar.a();
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Void> cancelInstall(int i) {
            return b(new p0(i) { // from class: a2.j.b.e.a.i.i0
                public final int a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.cancelInstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Void> deferredInstall(List<String> list) {
            return b(new p0(list) { // from class: a2.j.b.e.a.i.m0
                public final List a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.deferredInstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Void> deferredLanguageInstall(List<Locale> list) {
            return b(new p0(list) { // from class: a2.j.b.e.a.i.n0
                public final List a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.deferredLanguageInstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
            return b(new p0(list) { // from class: a2.j.b.e.a.i.o0
                public final List a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.deferredLanguageUninstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Void> deferredUninstall(List<String> list) {
            return b(new p0(list) { // from class: a2.j.b.e.a.i.l0
                public final List a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.deferredUninstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Set<String> getInstalledLanguages() {
            return a().getInstalledLanguages();
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Set<String> getInstalledModules() {
            return a().getInstalledModules();
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<SplitInstallSessionState> getSessionState(int i) {
            return b(new p0(i) { // from class: a2.j.b.e.a.i.j0
                public final int a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.getSessionState(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<List<SplitInstallSessionState>> getSessionStates() {
            return b(k0.a);
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
            b(new p0(splitInstallStateUpdatedListener) { // from class: a2.j.b.e.a.i.c0
                public final SplitInstallStateUpdatedListener a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    splitInstallManager.registerListener(this.a);
                    return Tasks.a((Object) null);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
            return a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
            return a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
            return b(new p0(splitInstallRequest) { // from class: a2.j.b.e.a.i.h0
                public final SplitInstallRequest a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    return splitInstallManager.startInstall(this.a);
                }
            });
        }

        @Override // com.google.android.play.core.splitinstall.SplitInstallManager
        public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
            b(new p0(splitInstallStateUpdatedListener) { // from class: a2.j.b.e.a.i.g0
                public final SplitInstallStateUpdatedListener a;

                {
                    this.a = r1;
                }

                @Override // a2.j.b.e.a.i.p0
                public final Task a(SplitInstallManager splitInstallManager) {
                    splitInstallManager.unregisterListener(this.a);
                    return Tasks.a((Object) null);
                }
            });
        }
    }
