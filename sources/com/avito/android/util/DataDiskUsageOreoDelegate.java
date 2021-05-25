package com.avito.android.util;

import android.annotation.TargetApi;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Process;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\u000b\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R#\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060$8B@\u0002X\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/util/DataDiskUsageOreoDelegate;", "Lcom/avito/android/util/DataDiskUsageDelegate;", "", "getAppSize", "()J", "Lkotlin/Function1;", "Ljava/util/UUID;", "Lkotlin/ParameterName;", "name", "uuid", "statForPackage", AuthSource.SEND_ABUSE, "(Lkotlin/jvm/functions/Function1;)J", "getCacheSize", "cacheSize", "Landroid/os/storage/StorageManager;", AuthSource.BOOKING_ORDER, "Landroid/os/storage/StorageManager;", "storageManager", "getDataSize", "dataSize", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/os/UserHandle;", "c", "Landroid/os/UserHandle;", "getUser", "()Landroid/os/UserHandle;", "user", "Landroid/app/usage/StorageStatsManager;", "Landroid/app/usage/StorageStatsManager;", "storageStatsManager", "", "d", "Lkotlin/Lazy;", "getUuids", "()Ljava/util/Set;", "uuids", "<init>", "(Landroid/content/Context;)V", "application_release"}, k = 1, mv = {1, 4, 2})
@TargetApi(26)
public final class DataDiskUsageOreoDelegate implements DataDiskUsageDelegate {
    public final StorageStatsManager a;
    public final StorageManager b;
    @NotNull
    public final UserHandle c;
    public final Lazy d = t6.c.lazy(new e(this));
    @NotNull
    public final Context e;

    public static final class a extends Lambda implements Function1<UUID, Long> {
        public final /* synthetic */ DataDiskUsageOreoDelegate a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate) {
            super(1);
            this.a = dataDiskUsageOreoDelegate;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Long invoke(UUID uuid) {
            UUID uuid2 = uuid;
            Intrinsics.checkNotNullParameter(uuid2, "it");
            return Long.valueOf(DataDiskUsageOreoDelegate.access$getStats(this.a, uuid2).getCacheBytes());
        }
    }

    public static final class b extends Lambda implements Function1<UUID, Long> {
        public final /* synthetic */ DataDiskUsageOreoDelegate a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate) {
            super(1);
            this.a = dataDiskUsageOreoDelegate;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Long invoke(UUID uuid) {
            UUID uuid2 = uuid;
            Intrinsics.checkNotNullParameter(uuid2, "it");
            return Long.valueOf(DataDiskUsageOreoDelegate.access$getStats(this.a, uuid2).getDataBytes());
        }
    }

    public static final class c extends Lambda implements Function1<UUID, Long> {
        public final /* synthetic */ DataDiskUsageOreoDelegate a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate) {
            super(1);
            this.a = dataDiskUsageOreoDelegate;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Long invoke(UUID uuid) {
            UUID uuid2 = uuid;
            Intrinsics.checkNotNullParameter(uuid2, "it");
            return Long.valueOf(DataDiskUsageOreoDelegate.access$getStats(this.a, uuid2).getAppBytes());
        }
    }

    public static final class d extends Lambda implements Function1<UUID, Long> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Long invoke(UUID uuid) {
            UUID uuid2 = uuid;
            Intrinsics.checkNotNullParameter(uuid2, "it");
            return Long.valueOf(((Number) this.a.invoke(uuid2)).longValue());
        }
    }

    public static final class e extends Lambda implements Function0<Set<? extends UUID>> {
        public final /* synthetic */ DataDiskUsageOreoDelegate a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate) {
            super(0);
            this.a = dataDiskUsageOreoDelegate;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends UUID> invoke() {
            List<StorageVolume> storageVolumes = this.a.b.getStorageVolumes();
            Intrinsics.checkNotNullExpressionValue(storageVolumes, "storageManager.storageVolumes");
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(storageVolumes, 10));
            for (T t : storageVolumes) {
                DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate = this.a;
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList.add(DataDiskUsageOreoDelegate.access$safeUUID(dataDiskUsageOreoDelegate, t));
            }
            return CollectionsKt___CollectionsKt.toSet(arrayList);
        }
    }

    public DataDiskUsageOreoDelegate(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
        Object systemService = context.getSystemService("storagestats");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.usage.StorageStatsManager");
        this.a = (StorageStatsManager) systemService;
        Object systemService2 = context.getSystemService("storage");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.os.storage.StorageManager");
        this.b = (StorageManager) systemService2;
        UserHandle myUserHandle = Process.myUserHandle();
        Intrinsics.checkNotNullExpressionValue(myUserHandle, "Process.myUserHandle()");
        this.c = myUserHandle;
    }

    public static final StorageStats access$getStats(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate, UUID uuid) {
        StorageStats queryStatsForPackage = dataDiskUsageOreoDelegate.a.queryStatsForPackage(uuid, dataDiskUsageOreoDelegate.e.getPackageName(), dataDiskUsageOreoDelegate.c);
        Intrinsics.checkNotNullExpressionValue(queryStatsForPackage, "storageStatsManager.quer…ontext.packageName, user)");
        return queryStatsForPackage;
    }

    public static final UUID access$safeUUID(DataDiskUsageOreoDelegate dataDiskUsageOreoDelegate, StorageVolume storageVolume) {
        Objects.requireNonNull(dataDiskUsageOreoDelegate);
        String uuid = storageVolume.getUuid();
        if (uuid != null) {
            Intrinsics.checkNotNullExpressionValue(uuid, "this.uuid ?: return StorageManager.UUID_DEFAULT");
            try {
                UUID fromString = UUID.fromString(uuid);
                Intrinsics.checkNotNullExpressionValue(fromString, "UUID.fromString(raw)");
                return fromString;
            } catch (IllegalArgumentException unused) {
                byte[] bytes = uuid.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
                Intrinsics.checkNotNullExpressionValue(nameUUIDFromBytes, "UUID.nameUUIDFromBytes(raw.toByteArray())");
                return nameUUIDFromBytes;
            }
        } else {
            UUID uuid2 = StorageManager.UUID_DEFAULT;
            Intrinsics.checkNotNullExpressionValue(uuid2, "StorageManager.UUID_DEFAULT");
            return uuid2;
        }
    }

    public final long a(Function1<? super UUID, Long> function1) {
        return SequencesKt___SequencesKt.sumOfLong(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence((Set) this.d.getValue()), new d(function1)));
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    public long getAppSize() {
        return a(new c(this));
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    public long getCacheSize() {
        return a(new a(this));
    }

    @NotNull
    public final Context getContext() {
        return this.e;
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    public long getDataSize() {
        return a(new b(this));
    }

    @NotNull
    public final UserHandle getUser() {
        return this.c;
    }
}
