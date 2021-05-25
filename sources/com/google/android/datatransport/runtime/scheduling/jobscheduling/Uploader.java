package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
public class Uploader {
    public final Context a;
    public final BackendRegistry b;
    public final EventStore c;
    public final WorkScheduler d;
    public final Executor e;
    public final SynchronizationGuard f;
    public final Clock g;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock) {
        this.a = context;
        this.b = backendRegistry;
        this.c = eventStore;
        this.d = workScheduler;
        this.e = executor;
        this.f = synchronizationGuard;
        this.g = clock;
    }

    public void a(TransportContext transportContext, int i) {
        BackendResponse send;
        TransportBackend transportBackend = this.b.get(transportContext.getBackendName());
        Iterable<PersistedEvent> iterable = (Iterable) this.f.runCriticalSection(new SynchronizationGuard.CriticalSection(this, transportContext) { // from class: a2.j.b.a.c.m.c.f
            public final Uploader a;
            public final TransportContext b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public Object execute() {
                Uploader uploader = this.a;
                return uploader.c.loadBatch(this.b);
            }
        });
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.d("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                send = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent persistedEvent : iterable) {
                    arrayList.add(persistedEvent.getEvent());
                }
                send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.f.runCriticalSection(new SynchronizationGuard.CriticalSection(this, send, iterable, transportContext, i) { // from class: a2.j.b.a.c.m.c.g
                public final Uploader a;
                public final BackendResponse b;
                public final Iterable c;
                public final TransportContext d;
                public final int e;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                    this.e = r5;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public Object execute() {
                    Uploader uploader = this.a;
                    BackendResponse backendResponse = this.b;
                    Iterable<PersistedEvent> iterable2 = this.c;
                    TransportContext transportContext2 = this.d;
                    int i2 = this.e;
                    if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                        uploader.c.recordFailure(iterable2);
                        uploader.d.schedule(transportContext2, i2 + 1);
                        return null;
                    }
                    uploader.c.recordSuccess(iterable2);
                    if (backendResponse.getStatus() == BackendResponse.Status.OK) {
                        uploader.c.recordNextCallTime(transportContext2, backendResponse.getNextRequestWaitMillis() + uploader.g.getTime());
                    }
                    if (!uploader.c.hasPendingEventsFor(transportContext2)) {
                        return null;
                    }
                    uploader.d.schedule(transportContext2, 1);
                    return null;
                }
            });
        }
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.e.execute(new Runnable(this, transportContext, i, runnable) { // from class: a2.j.b.a.c.m.c.e
            public final Uploader a;
            public final TransportContext b;
            public final int c;
            public final Runnable d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Uploader uploader = this.a;
                TransportContext transportContext2 = this.b;
                int i2 = this.c;
                Runnable runnable2 = this.d;
                try {
                    SynchronizationGuard synchronizationGuard = uploader.f;
                    EventStore eventStore = uploader.c;
                    eventStore.getClass();
                    synchronizationGuard.runCriticalSection(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                          (r5v0 'synchronizationGuard' com.google.android.datatransport.runtime.synchronization.SynchronizationGuard)
                          (wrap: a2.j.b.a.c.m.c.h : 0x0012: CONSTRUCTOR  (r7v0 a2.j.b.a.c.m.c.h) = (r6v0 'eventStore' com.google.android.datatransport.runtime.scheduling.persistence.EventStore) call: a2.j.b.a.c.m.c.h.<init>(com.google.android.datatransport.runtime.scheduling.persistence.EventStore):void type: CONSTRUCTOR)
                         type: INTERFACE call: com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.runCriticalSection(com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection):java.lang.Object in method: a2.j.b.a.c.m.c.e.run():void, file: classes5.dex
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r7v0 a2.j.b.a.c.m.c.h) = (r6v0 'eventStore' com.google.android.datatransport.runtime.scheduling.persistence.EventStore) call: a2.j.b.a.c.m.c.h.<init>(com.google.android.datatransport.runtime.scheduling.persistence.EventStore):void type: CONSTRUCTOR in method: a2.j.b.a.c.m.c.e.run():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 21 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.a.c.m.c.h, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 27 more
                        */
                    /*
                        this = this;
                        com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader r0 = r8.a
                        com.google.android.datatransport.runtime.TransportContext r1 = r8.b
                        int r2 = r8.c
                        java.lang.Runnable r3 = r8.d
                        r4 = 1
                        com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r5 = r0.f     // Catch:{ SynchronizationException -> 0x0044 }
                        com.google.android.datatransport.runtime.scheduling.persistence.EventStore r6 = r0.c     // Catch:{ SynchronizationException -> 0x0044 }
                        r6.getClass()     // Catch:{ SynchronizationException -> 0x0044 }
                        a2.j.b.a.c.m.c.h r7 = new a2.j.b.a.c.m.c.h     // Catch:{ SynchronizationException -> 0x0044 }
                        r7.<init>(r6)     // Catch:{ SynchronizationException -> 0x0044 }
                        r5.runCriticalSection(r7)     // Catch:{ SynchronizationException -> 0x0044 }
                        android.content.Context r5 = r0.a     // Catch:{ SynchronizationException -> 0x0044 }
                        java.lang.String r6 = "connectivity"
                        java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ SynchronizationException -> 0x0044 }
                        android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ SynchronizationException -> 0x0044 }
                        android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ SynchronizationException -> 0x0044 }
                        if (r5 == 0) goto L_0x0030
                        boolean r5 = r5.isConnected()     // Catch:{ SynchronizationException -> 0x0044 }
                        if (r5 == 0) goto L_0x0030
                        r5 = 1
                        goto L_0x0031
                    L_0x0030:
                        r5 = 0
                    L_0x0031:
                        if (r5 != 0) goto L_0x003e
                        com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r5 = r0.f     // Catch:{ SynchronizationException -> 0x0044 }
                        a2.j.b.a.c.m.c.i r6 = new a2.j.b.a.c.m.c.i     // Catch:{ SynchronizationException -> 0x0044 }
                        r6.<init>(r0, r1, r2)     // Catch:{ SynchronizationException -> 0x0044 }
                        r5.runCriticalSection(r6)     // Catch:{ SynchronizationException -> 0x0044 }
                        goto L_0x004a
                    L_0x003e:
                        r0.a(r1, r2)     // Catch:{ SynchronizationException -> 0x0044 }
                        goto L_0x004a
                    L_0x0042:
                        r0 = move-exception
                        goto L_0x004e
                    L_0x0044:
                        com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r0.d     // Catch:{ all -> 0x0042 }
                        int r2 = r2 + r4
                        r0.schedule(r1, r2)     // Catch:{ all -> 0x0042 }
                    L_0x004a:
                        r3.run()
                        return
                    L_0x004e:
                        r3.run()
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.a.c.m.c.e.run():void");
                }
            });
        }
    }
