package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;
public class DefaultScheduler implements Scheduler {
    public static final Logger f = Logger.getLogger(TransportRuntime.class.getName());
    public final WorkScheduler a;
    public final Executor b;
    public final BackendRegistry c;
    public final EventStore d;
    public final SynchronizationGuard e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.b = executor;
        this.c = backendRegistry;
        this.a = workScheduler;
        this.d = eventStore;
        this.e = synchronizationGuard;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.b.execute(new Runnable(this, transportContext, transportScheduleCallback, eventInternal) { // from class: a2.j.b.a.c.m.a
            public final DefaultScheduler a;
            public final TransportContext b;
            public final TransportScheduleCallback c;
            public final EventInternal d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                DefaultScheduler defaultScheduler = this.a;
                TransportContext transportContext2 = this.b;
                TransportScheduleCallback transportScheduleCallback2 = this.c;
                EventInternal eventInternal2 = this.d;
                Logger logger = DefaultScheduler.f;
                try {
                    TransportBackend transportBackend = defaultScheduler.c.get(transportContext2.getBackendName());
                    if (transportBackend == null) {
                        String format = String.format("Transport backend '%s' is not registered", transportContext2.getBackendName());
                        DefaultScheduler.f.warning(format);
                        transportScheduleCallback2.onSchedule(new IllegalArgumentException(format));
                        return;
                    }
                    defaultScheduler.e.runCriticalSection(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE  
                          (wrap: com.google.android.datatransport.runtime.synchronization.SynchronizationGuard : 0x0038: IGET  (r4v4 com.google.android.datatransport.runtime.synchronization.SynchronizationGuard) = (r0v0 'defaultScheduler' com.google.android.datatransport.runtime.scheduling.DefaultScheduler) com.google.android.datatransport.runtime.scheduling.DefaultScheduler.e com.google.android.datatransport.runtime.synchronization.SynchronizationGuard)
                          (wrap: a2.j.b.a.c.m.b : 0x003c: CONSTRUCTOR  (r5v1 a2.j.b.a.c.m.b) = 
                          (r0v0 'defaultScheduler' com.google.android.datatransport.runtime.scheduling.DefaultScheduler)
                          (r1v0 'transportContext2' com.google.android.datatransport.runtime.TransportContext)
                          (wrap: com.google.android.datatransport.runtime.EventInternal : 0x0034: INVOKE  (r3v4 com.google.android.datatransport.runtime.EventInternal) = 
                          (r4v3 'transportBackend' com.google.android.datatransport.runtime.backends.TransportBackend)
                          (r3v0 'eventInternal2' com.google.android.datatransport.runtime.EventInternal)
                         type: INTERFACE call: com.google.android.datatransport.runtime.backends.TransportBackend.decorate(com.google.android.datatransport.runtime.EventInternal):com.google.android.datatransport.runtime.EventInternal)
                         call: a2.j.b.a.c.m.b.<init>(com.google.android.datatransport.runtime.scheduling.DefaultScheduler, com.google.android.datatransport.runtime.TransportContext, com.google.android.datatransport.runtime.EventInternal):void type: CONSTRUCTOR)
                         type: INTERFACE call: com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.runCriticalSection(com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection):java.lang.Object in method: a2.j.b.a.c.m.a.run():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:316)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: CONSTRUCTOR  (r5v1 a2.j.b.a.c.m.b) = 
                          (r0v0 'defaultScheduler' com.google.android.datatransport.runtime.scheduling.DefaultScheduler)
                          (r1v0 'transportContext2' com.google.android.datatransport.runtime.TransportContext)
                          (wrap: com.google.android.datatransport.runtime.EventInternal : 0x0034: INVOKE  (r3v4 com.google.android.datatransport.runtime.EventInternal) = 
                          (r4v3 'transportBackend' com.google.android.datatransport.runtime.backends.TransportBackend)
                          (r3v0 'eventInternal2' com.google.android.datatransport.runtime.EventInternal)
                         type: INTERFACE call: com.google.android.datatransport.runtime.backends.TransportBackend.decorate(com.google.android.datatransport.runtime.EventInternal):com.google.android.datatransport.runtime.EventInternal)
                         call: a2.j.b.a.c.m.b.<init>(com.google.android.datatransport.runtime.scheduling.DefaultScheduler, com.google.android.datatransport.runtime.TransportContext, com.google.android.datatransport.runtime.EventInternal):void type: CONSTRUCTOR in method: a2.j.b.a.c.m.a.run():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 25 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.a.c.m.b, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 31 more
                        */
                    /*
                        this = this;
                        com.google.android.datatransport.runtime.scheduling.DefaultScheduler r0 = r6.a
                        com.google.android.datatransport.runtime.TransportContext r1 = r6.b
                        com.google.android.datatransport.TransportScheduleCallback r2 = r6.c
                        com.google.android.datatransport.runtime.EventInternal r3 = r6.d
                        java.util.logging.Logger r4 = com.google.android.datatransport.runtime.scheduling.DefaultScheduler.f
                        com.google.android.datatransport.runtime.backends.BackendRegistry r4 = r0.c     // Catch:{ Exception -> 0x0047 }
                        java.lang.String r5 = r1.getBackendName()     // Catch:{ Exception -> 0x0047 }
                        com.google.android.datatransport.runtime.backends.TransportBackend r4 = r4.get(r5)     // Catch:{ Exception -> 0x0047 }
                        if (r4 != 0) goto L_0x0034
                        java.lang.String r0 = "Transport backend '%s' is not registered"
                        r3 = 1
                        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0047 }
                        r4 = 0
                        java.lang.String r1 = r1.getBackendName()     // Catch:{ Exception -> 0x0047 }
                        r3[r4] = r1     // Catch:{ Exception -> 0x0047 }
                        java.lang.String r0 = java.lang.String.format(r0, r3)     // Catch:{ Exception -> 0x0047 }
                        java.util.logging.Logger r1 = com.google.android.datatransport.runtime.scheduling.DefaultScheduler.f     // Catch:{ Exception -> 0x0047 }
                        r1.warning(r0)     // Catch:{ Exception -> 0x0047 }
                        java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0047 }
                        r1.<init>(r0)     // Catch:{ Exception -> 0x0047 }
                        r2.onSchedule(r1)     // Catch:{ Exception -> 0x0047 }
                        goto L_0x0061
                    L_0x0034:
                        com.google.android.datatransport.runtime.EventInternal r3 = r4.decorate(r3)     // Catch:{ Exception -> 0x0047 }
                        com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r4 = r0.e     // Catch:{ Exception -> 0x0047 }
                        a2.j.b.a.c.m.b r5 = new a2.j.b.a.c.m.b     // Catch:{ Exception -> 0x0047 }
                        r5.<init>(r0, r1, r3)     // Catch:{ Exception -> 0x0047 }
                        r4.runCriticalSection(r5)     // Catch:{ Exception -> 0x0047 }
                        r0 = 0
                        r2.onSchedule(r0)     // Catch:{ Exception -> 0x0047 }
                        goto L_0x0061
                    L_0x0047:
                        r0 = move-exception
                        java.util.logging.Logger r1 = com.google.android.datatransport.runtime.scheduling.DefaultScheduler.f
                        java.lang.String r3 = "Error scheduling event "
                        java.lang.StringBuilder r3 = a2.b.a.a.a.L(r3)
                        java.lang.String r4 = r0.getMessage()
                        r3.append(r4)
                        java.lang.String r3 = r3.toString()
                        r1.warning(r3)
                        r2.onSchedule(r0)
                    L_0x0061:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.a.c.m.a.run():void");
                }
            });
        }
    }
