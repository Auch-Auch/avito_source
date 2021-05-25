package com.avito.android.analytics.inhouse_transport;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.squareup.tape2.ObjectQueue;
import com.squareup.tape2.QueueFile;
import java.io.File;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B-\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010,\u001a\u00020)\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020-8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "", "T", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "event", "", ProductAction.ACTION_ADD, "(Ljava/lang/Object;)V", "", "events", "addAll", "(Ljava/util/List;)V", "extractAll", "()Ljava/util/List;", "markDirty", "()V", "Ljava/io/File;", "folder", AuthSource.SEND_ABUSE, "(Ljava/io/File;)V", "", "fileName", "Lcom/squareup/tape2/ObjectQueue;", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Lcom/squareup/tape2/ObjectQueue;", "Ljava/lang/Object;", "lock", "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "c", "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "fileStorage", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "e", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "diskConverter", "", "getEventCount", "()I", "eventCount", "Lcom/squareup/tape2/ObjectQueue;", "queue", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "d", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "settingsStorage", "", "isEmpty", "()Z", "Lcom/avito/android/util/RandomKeyProvider;", "f", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "<init>", "(Lcom/avito/android/analytics/inhouse_transport/FileStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;Lcom/avito/android/util/RandomKeyProvider;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public class OnDiskEventStorage<T> implements InHouseEventStorage<T> {
    public final Object a = new Object();
    @GuardedBy("lock")
    public ObjectQueue<T> b;
    public final FileStorage c;
    public final InHouseAnalyticsSettingsStorage d;
    public final DiskStorageConverter<T> e;
    public final RandomKeyProvider f;

    public OnDiskEventStorage(@NotNull FileStorage fileStorage, @NotNull InHouseAnalyticsSettingsStorage inHouseAnalyticsSettingsStorage, @NotNull DiskStorageConverter<T> diskStorageConverter, @NotNull RandomKeyProvider randomKeyProvider) {
        ObjectQueue<T> objectQueue;
        Intrinsics.checkNotNullParameter(fileStorage, "fileStorage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsSettingsStorage, "settingsStorage");
        Intrinsics.checkNotNullParameter(diskStorageConverter, "diskConverter");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.c = fileStorage;
        this.d = inHouseAnalyticsSettingsStorage;
        this.e = diskStorageConverter;
        this.f = randomKeyProvider;
        String storageFileName = inHouseAnalyticsSettingsStorage.getStorageFileName();
        File eventsFolder = fileStorage.getEventsFolder();
        if (inHouseAnalyticsSettingsStorage.isDirty() || storageFileName == null || m.isBlank(storageFileName)) {
            a(eventsFolder);
            String generateKey = randomKeyProvider.generateKey();
            inHouseAnalyticsSettingsStorage.saveStorageFileName(generateKey);
            objectQueue = b(generateKey);
        } else {
            objectQueue = b(storageFileName);
        }
        this.b = objectQueue;
    }

    public final void a(File file) {
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
        this.d.setDirty(false);
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void add(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "event");
        synchronized (this.a) {
            this.b.add(t);
        }
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void addAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        synchronized (this.a) {
            for (T t : list) {
                this.b.add(t);
            }
        }
    }

    public final ObjectQueue<T> b(String str) {
        File eventsFolder = this.c.getEventsFolder();
        int binaryFormatVersion = this.e.getBinaryFormatVersion();
        ObjectQueue<T> create = ObjectQueue.create(new QueueFile.Builder(new File(eventsFolder, 'v' + binaryFormatVersion + '_' + str)).build(), this.e);
        Intrinsics.checkNotNullExpressionValue(create, "ObjectQueue.create(storage, diskConverter)");
        return create;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    @NotNull
    public List<T> extractAll() {
        List<T> filterNotNull;
        synchronized (this.a) {
            List<T> asList = this.b.asList();
            this.b.clear();
            Intrinsics.checkNotNullExpressionValue(asList, "list");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(asList);
        }
        return filterNotNull;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public int getEventCount() {
        int size;
        synchronized (this.a) {
            size = this.b.size();
        }
        return size;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.a) {
            isEmpty = this.b.isEmpty();
        }
        return isEmpty;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseEventStorage
    public void markDirty() {
        this.d.setDirty(true);
    }
}
