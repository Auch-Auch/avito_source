package com.google.android.datatransport.runtime.scheduling.persistence;

import a2.j.b.a.c.m.d.i;
import a2.j.b.a.c.m.d.k;
import a2.j.b.a.c.m.d.l;
import a2.j.b.a.c.m.d.m;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.avito.android.remote.model.category_parameters.MultiselectParameterKt;
import com.facebook.applinks.AppLinkData;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
@WorkerThread
public class SQLiteEventStore implements EventStore, SynchronizationGuard {
    public static final Encoding e = Encoding.of("proto");
    public final SchemaManager a;
    public final Clock b;
    public final Clock c;
    public final a2.j.b.a.c.m.d.c d;

    public interface b<T, U> {
        U apply(T t);
    }

    public static class c {
        public final String a;
        public final String b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.b = str2;
        }
    }

    public interface d<T> {
        T a();
    }

    @Inject
    public SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, a2.j.b.a.c.m.d.c cVar, SchemaManager schemaManager) {
        this.a = schemaManager;
        this.b = clock;
        this.c = clock2;
        this.d = cVar;
    }

    public static String e(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T f(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @VisibleForTesting
    public SQLiteDatabase a() {
        SchemaManager schemaManager = this.a;
        schemaManager.getClass();
        return (SQLiteDatabase) d(new d(schemaManager) { // from class: a2.j.b.a.c.m.d.j
            public final SchemaManager a;

            {
                this.a = r1;
            }

            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.d
            public Object a() {
                return this.a.getWritableDatabase();
            }
        }, m.a);
    }

    @Nullable
    public final Long b(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long l;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))));
        if (transportContext.getExtras() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                l = null;
            } else {
                l = Long.valueOf(query.getLong(0));
            }
            return l;
        } finally {
            query.close();
        }
    }

    public final <T> T c(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase a3 = a();
        a3.beginTransaction();
        try {
            T apply = bVar.apply(a3);
            a3.setTransactionSuccessful();
            return apply;
        } finally {
            a3.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public int cleanUp() {
        long time = this.b.getTime() - this.d.b();
        SQLiteDatabase a3 = a();
        a3.beginTransaction();
        try {
            Integer valueOf = Integer.valueOf(a3.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(time)}));
            a3.setTransactionSuccessful();
            a3.endTransaction();
            return valueOf.intValue();
        } catch (Throwable th) {
            a3.endTransaction();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void clearDb() {
        SQLiteDatabase a3 = a();
        a3.beginTransaction();
        try {
            a3.delete("events", null, new String[0]);
            a3.delete("transport_contexts", null, new String[0]);
            a3.setTransactionSuccessful();
        } finally {
            a3.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public final <T> T d(d<T> dVar, b<Throwable, T> bVar) {
        long time = this.c.getTime();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.c.getTime() >= ((long) this.d.a()) + time) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public long getNextCallTime(TransportContext transportContext) {
        Long l;
        Cursor rawQuery = a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))});
        try {
            if (rawQuery.moveToNext()) {
                l = Long.valueOf(rawQuery.getLong(0));
            } else {
                l = 0L;
            }
            rawQuery.close();
            return l.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public boolean hasPendingEventsFor(TransportContext transportContext) {
        Boolean bool;
        SQLiteDatabase a3 = a();
        a3.beginTransaction();
        try {
            Long b2 = b(a3, transportContext);
            if (b2 == null) {
                bool = Boolean.FALSE;
            } else {
                bool = (Boolean) f(a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{b2.toString()}), l.a);
            }
            a3.setTransactionSuccessful();
            a3.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            a3.endTransaction();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<TransportContext> loadActiveContexts() {
        SQLiteDatabase a3 = a();
        a3.beginTransaction();
        try {
            List list = (List) f(a3.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), k.a);
            a3.setTransactionSuccessful();
            return list;
        } finally {
            a3.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        return (Iterable) c(new b(this, transportContext) { // from class: a2.j.b.a.c.m.d.e
            public final SQLiteEventStore a;
            public final TransportContext b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX INFO: finally extract failed */
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.b
            public Object apply(Object obj) {
                SQLiteEventStore sQLiteEventStore = this.a;
                TransportContext transportContext2 = this.b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding = SQLiteEventStore.e;
                Objects.requireNonNull(sQLiteEventStore);
                ArrayList arrayList = new ArrayList();
                Long b2 = sQLiteEventStore.b(sQLiteDatabase, transportContext2);
                if (b2 != null) {
                    SQLiteEventStore.f(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", MultiselectParameterKt.DISPLAY_TYPE_INLINE}, "context_id = ?", new String[]{b2.toString()}, null, null, null, String.valueOf(sQLiteEventStore.d.c())), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE  
                          (wrap: android.database.Cursor : 0x0047: INVOKE  (r2v20 android.database.Cursor) = 
                          (r15v1 'sQLiteDatabase' android.database.sqlite.SQLiteDatabase)
                          ("events")
                          (wrap: java.lang.String[] : 0x0029: FILLED_NEW_ARRAY  (r4v9 java.lang.String[]) = 
                          ("_id")
                          ("transport_name")
                          ("timestamp_ms")
                          ("uptime_ms")
                          ("payload_encoding")
                          ("payload")
                          ("code")
                          (wrap: java.lang.String : ?: SGET   com.avito.android.remote.model.category_parameters.MultiselectParameterKt.DISPLAY_TYPE_INLINE java.lang.String)
                         elemType: java.lang.String)
                          ("context_id = ?")
                          (wrap: java.lang.String[] : ?: FILLED_NEW_ARRAY  (r6v2 java.lang.String[]) = 
                          (wrap: java.lang.String : 0x002f: INVOKE  (r2v1 'b2' java.lang.Long) type: VIRTUAL call: java.lang.Long.toString():java.lang.String)
                         elemType: java.lang.String)
                          (null java.lang.String)
                          (null java.lang.String)
                          (null java.lang.String)
                          (wrap: java.lang.String : 0x003e: INVOKE  (r10v1 java.lang.String) = 
                          (wrap: int : 0x003a: INVOKE  (r2v18 int) = 
                          (wrap: a2.j.b.a.c.m.d.c : 0x0038: IGET  (r2v17 a2.j.b.a.c.m.d.c) = (r0v0 'sQLiteEventStore' com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore) com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.d a2.j.b.a.c.m.d.c)
                         type: VIRTUAL call: a2.j.b.a.c.m.d.c.c():int)
                         type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
                         type: VIRTUAL call: android.database.sqlite.SQLiteDatabase.query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.database.Cursor)
                          (wrap: a2.j.b.a.c.m.d.f : 0x004d: CONSTRUCTOR  (r3v22 a2.j.b.a.c.m.d.f) = 
                          (r0v0 'sQLiteEventStore' com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore)
                          (r11v0 'arrayList' java.util.ArrayList)
                          (r1v0 'transportContext2' com.google.android.datatransport.runtime.TransportContext)
                         call: a2.j.b.a.c.m.d.f.<init>(com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore, java.util.List, com.google.android.datatransport.runtime.TransportContext):void type: CONSTRUCTOR)
                         type: STATIC call: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.f(android.database.Cursor, com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$b):java.lang.Object in method: a2.j.b.a.c.m.d.e.apply(java.lang.Object):java.lang.Object, file: classes5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: CONSTRUCTOR  (r3v22 a2.j.b.a.c.m.d.f) = 
                          (r0v0 'sQLiteEventStore' com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore)
                          (r11v0 'arrayList' java.util.ArrayList)
                          (r1v0 'transportContext2' com.google.android.datatransport.runtime.TransportContext)
                         call: a2.j.b.a.c.m.d.f.<init>(com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore, java.util.List, com.google.android.datatransport.runtime.TransportContext):void type: CONSTRUCTOR in method: a2.j.b.a.c.m.d.e.apply(java.lang.Object):java.lang.Object, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 21 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.a.c.m.d.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 27 more
                        */
                    /*
                    // Method dump skipped, instructions count: 319
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.b.a.c.m.d.e.apply(java.lang.Object):java.lang.Object");
                }
            });
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
        @Nullable
        public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
            Logging.d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName());
            long longValue = ((Long) c(new b(this, transportContext, eventInternal) { // from class: a2.j.b.a.c.m.d.n
                public final SQLiteEventStore a;
                public final TransportContext b;
                public final EventInternal c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.b
                public Object apply(Object obj) {
                    long j;
                    SQLiteEventStore sQLiteEventStore = this.a;
                    TransportContext transportContext2 = this.b;
                    EventInternal eventInternal2 = this.c;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                    Encoding encoding = SQLiteEventStore.e;
                    if (sQLiteEventStore.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.a().compileStatement("PRAGMA page_count").simpleQueryForLong() >= sQLiteEventStore.d.e()) {
                        return -1L;
                    }
                    Long b2 = sQLiteEventStore.b(sQLiteDatabase, transportContext2);
                    if (b2 != null) {
                        j = b2.longValue();
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("backend_name", transportContext2.getBackendName());
                        contentValues.put(Constants.FirelogAnalytics.PARAM_PRIORITY, Integer.valueOf(PriorityMapping.toInt(transportContext2.getPriority())));
                        contentValues.put("next_request_ms", (Integer) 0);
                        if (transportContext2.getExtras() != null) {
                            contentValues.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, Base64.encodeToString(transportContext2.getExtras(), 0));
                        }
                        j = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                    }
                    int d2 = sQLiteEventStore.d.d();
                    byte[] bytes = eventInternal2.getEncodedPayload().getBytes();
                    boolean z = bytes.length <= d2;
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("context_id", Long.valueOf(j));
                    contentValues2.put("transport_name", eventInternal2.getTransportName());
                    contentValues2.put("timestamp_ms", Long.valueOf(eventInternal2.getEventMillis()));
                    contentValues2.put("uptime_ms", Long.valueOf(eventInternal2.getUptimeMillis()));
                    contentValues2.put("payload_encoding", eventInternal2.getEncodedPayload().getEncoding().getName());
                    contentValues2.put("code", eventInternal2.getCode());
                    contentValues2.put("num_attempts", (Integer) 0);
                    contentValues2.put(MultiselectParameterKt.DISPLAY_TYPE_INLINE, Boolean.valueOf(z));
                    contentValues2.put("payload", z ? bytes : new byte[0]);
                    long insert = sQLiteDatabase.insert("events", null, contentValues2);
                    if (!z) {
                        int ceil = (int) Math.ceil(((double) bytes.length) / ((double) d2));
                        for (int i = 1; i <= ceil; i++) {
                            byte[] copyOfRange = Arrays.copyOfRange(bytes, (i - 1) * d2, Math.min(i * d2, bytes.length));
                            ContentValues contentValues3 = new ContentValues();
                            contentValues3.put("event_id", Long.valueOf(insert));
                            contentValues3.put("sequence_num", Integer.valueOf(i));
                            contentValues3.put("bytes", copyOfRange);
                            sQLiteDatabase.insert("event_payloads", null, contentValues3);
                        }
                    }
                    for (Map.Entry<String, String> entry : eventInternal2.getMetadata().entrySet()) {
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("event_id", Long.valueOf(insert));
                        contentValues4.put("name", entry.getKey());
                        contentValues4.put("value", entry.getValue());
                        sQLiteDatabase.insert("event_metadata", null, contentValues4);
                    }
                    return Long.valueOf(insert);
                }
            })).longValue();
            if (longValue < 1) {
                return null;
            }
            return PersistedEvent.create(longValue, transportContext, eventInternal);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
        public void recordFailure(Iterable<PersistedEvent> iterable) {
            if (iterable.iterator().hasNext()) {
                StringBuilder L = a2.b.a.a.a.L("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
                L.append(e(iterable));
                String sb = L.toString();
                SQLiteDatabase a3 = a();
                a3.beginTransaction();
                try {
                    a3.compileStatement(sb).execute();
                    a3.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    a3.setTransactionSuccessful();
                } finally {
                    a3.endTransaction();
                }
            }
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
        public void recordNextCallTime(TransportContext transportContext, long j) {
            c(new b(j, transportContext) { // from class: a2.j.b.a.c.m.d.d
                public final long a;
                public final TransportContext b;

                {
                    this.a = r1;
                    this.b = r3;
                }

                @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.b
                public Object apply(Object obj) {
                    long j2 = this.a;
                    TransportContext transportContext2 = this.b;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                    Encoding encoding = SQLiteEventStore.e;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("next_request_ms", Long.valueOf(j2));
                    if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext2.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext2.getPriority()))}) < 1) {
                        contentValues.put("backend_name", transportContext2.getBackendName());
                        contentValues.put(Constants.FirelogAnalytics.PARAM_PRIORITY, Integer.valueOf(PriorityMapping.toInt(transportContext2.getPriority())));
                        sQLiteDatabase.insert("transport_contexts", null, contentValues);
                    }
                    return null;
                }
            });
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
        public void recordSuccess(Iterable<PersistedEvent> iterable) {
            if (iterable.iterator().hasNext()) {
                StringBuilder L = a2.b.a.a.a.L("DELETE FROM events WHERE _id in ");
                L.append(e(iterable));
                a().compileStatement(L.toString()).execute();
            }
        }

        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
        public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
            SQLiteDatabase a3 = a();
            d(new d(a3) { // from class: a2.j.b.a.c.m.d.h
                public final SQLiteDatabase a;

                {
                    this.a = r1;
                }

                @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.d
                public Object a() {
                    SQLiteDatabase sQLiteDatabase = this.a;
                    Encoding encoding = SQLiteEventStore.e;
                    sQLiteDatabase.beginTransaction();
                    return null;
                }
            }, i.a);
            try {
                T execute = criticalSection.execute();
                a3.setTransactionSuccessful();
                return execute;
            } finally {
                a3.endTransaction();
            }
        }
    }
