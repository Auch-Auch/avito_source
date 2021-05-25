package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;
public class WorkInitializer {
    public final Executor a;
    public final EventStore b;
    public final WorkScheduler c;
    public final SynchronizationGuard d;

    @Inject
    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.a = executor;
        this.b = eventStore;
        this.c = workScheduler;
        this.d = synchronizationGuard;
    }

    public void ensureContextsScheduled() {
        this.a.execute(new Runnable(this) { // from class: a2.j.b.a.c.m.c.j
            public final WorkInitializer a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                WorkInitializer workInitializer = this.a;
                workInitializer.d.runCriticalSection(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                      (wrap: com.google.android.datatransport.runtime.synchronization.SynchronizationGuard : 0x0002: IGET  (r1v0 com.google.android.datatransport.runtime.synchronization.SynchronizationGuard) = (r0v0 'workInitializer' com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer) com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer.d com.google.android.datatransport.runtime.synchronization.SynchronizationGuard)
                      (wrap: a2.j.b.a.c.m.c.k : 0x0006: CONSTRUCTOR  (r2v0 a2.j.b.a.c.m.c.k) = (r0v0 'workInitializer' com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer) call: a2.j.b.a.c.m.c.k.<init>(com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer):void type: CONSTRUCTOR)
                     type: INTERFACE call: com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.runCriticalSection(com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection):java.lang.Object in method: a2.j.b.a.c.m.c.j.run():void, file: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r2v0 a2.j.b.a.c.m.c.k) = (r0v0 'workInitializer' com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer) call: a2.j.b.a.c.m.c.k.<init>(com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer):void type: CONSTRUCTOR in method: a2.j.b.a.c.m.c.j.run():void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.a.c.m.c.k, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer r0 = r3.a
                    com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r1 = r0.d
                    a2.j.b.a.c.m.c.k r2 = new a2.j.b.a.c.m.c.k
                    r2.<init>(r0)
                    r1.runCriticalSection(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.j.b.a.c.m.c.j.run():void");
            }
        });
    }
}
