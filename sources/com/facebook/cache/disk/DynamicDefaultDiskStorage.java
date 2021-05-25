package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
public class DynamicDefaultDiskStorage implements DiskStorage {
    public final int a;
    public final Supplier<File> b;
    public final String c;
    public final CacheErrorLogger d;
    @VisibleForTesting
    public volatile a e = new a(null, null);

    @VisibleForTesting
    public static class a {
        @Nullable
        public final DiskStorage a;
        @Nullable
        public final File b;

        @VisibleForTesting
        public a(@Nullable File file, @Nullable DiskStorage diskStorage) {
            this.a = diskStorage;
            this.b = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.a = i;
        this.d = cacheErrorLogger;
        this.b = supplier;
        this.c = str;
    }

    public final void a() throws IOException {
        File file = new File(this.b.get(), this.c);
        try {
            FileUtils.mkdirs(file);
            FLog.d(DynamicDefaultDiskStorage.class, "Created cache directory %s", file.getAbsolutePath());
            this.e = new a(file, new DefaultDiskStorage(file, this.a, this.d));
        } catch (FileUtils.CreateDirectoryException e2) {
            this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, DynamicDefaultDiskStorage.class, "createRootDirectoryIfNecessary", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0017  */
    @com.facebook.common.internal.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.cache.disk.DiskStorage b() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.cache.disk.DynamicDefaultDiskStorage$a r0 = r2.e     // Catch:{ all -> 0x0039 }
            com.facebook.cache.disk.DiskStorage r1 = r0.a     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0014
            java.io.File r0 = r0.b     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x002d
            com.facebook.cache.disk.DynamicDefaultDiskStorage$a r0 = r2.e     // Catch:{ all -> 0x0039 }
            com.facebook.cache.disk.DiskStorage r0 = r0.a     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x002a
            com.facebook.cache.disk.DynamicDefaultDiskStorage$a r0 = r2.e     // Catch:{ all -> 0x0039 }
            java.io.File r0 = r0.b     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x002a
            com.facebook.cache.disk.DynamicDefaultDiskStorage$a r0 = r2.e     // Catch:{ all -> 0x0039 }
            java.io.File r0 = r0.b     // Catch:{ all -> 0x0039 }
            com.facebook.common.file.FileTree.deleteRecursively(r0)     // Catch:{ all -> 0x0039 }
        L_0x002a:
            r2.a()     // Catch:{ all -> 0x0039 }
        L_0x002d:
            com.facebook.cache.disk.DynamicDefaultDiskStorage$a r0 = r2.e     // Catch:{ all -> 0x0039 }
            com.facebook.cache.disk.DiskStorage r0 = r0.a     // Catch:{ all -> 0x0039 }
            java.lang.Object r0 = com.facebook.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0039 }
            com.facebook.cache.disk.DiskStorage r0 = (com.facebook.cache.disk.DiskStorage) r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return r0
        L_0x0039:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DynamicDefaultDiskStorage.b():com.facebook.cache.disk.DiskStorage");
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws IOException {
        b().clearAll();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) throws IOException {
        return b().contains(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return b().getDumpInfo();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return b().getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String str, Object obj) throws IOException {
        return b().getResource(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        try {
            return b().getStorageName();
        } catch (IOException unused) {
            return "";
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        return b().insert(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        try {
            return b().isEnabled();
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        try {
            return b().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        try {
            b().purgeUnexpectedResources();
        } catch (IOException e2) {
            FLog.e(DynamicDefaultDiskStorage.class, "purgeUnexpectedResources", e2);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) throws IOException {
        return b().remove(entry);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) throws IOException {
        return b().touch(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) throws IOException {
        return b().remove(str);
    }
}
