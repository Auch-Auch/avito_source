package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
public class DefaultDiskStorage implements DiskStorage {
    public static final long f = TimeUnit.MINUTES.toMillis(30);
    public static final /* synthetic */ int g = 0;
    public final File a;
    public final boolean b;
    public final File c;
    public final CacheErrorLogger d;
    public final Clock e;

    public @interface FileType {
        public static final String CONTENT = ".cnt";
        public static final String TEMP = ".tmp";
    }

    public class b implements FileTreeVisitor {
        public final List<DiskStorage.Entry> a = new ArrayList();

        public b(a aVar) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            d a3 = DefaultDiskStorage.a(DefaultDiskStorage.this, file);
            if (a3 != null && a3.a == FileType.CONTENT) {
                this.a.add(new c(a3.b, file, null));
            }
        }
    }

    @VisibleForTesting
    public static class c implements DiskStorage.Entry {
        public final String a;
        public final FileBinaryResource b;
        public long c = -1;
        public long d = -1;

        public c(String str, File file, a aVar) {
            Preconditions.checkNotNull(file);
            this.a = (String) Preconditions.checkNotNull(str);
            this.b = FileBinaryResource.createOrNull(file);
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.a;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public BinaryResource getResource() {
            return this.b;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.c < 0) {
                this.c = this.b.size();
            }
            return this.c;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.d < 0) {
                this.d = this.b.getFile().lastModified();
            }
            return this.d;
        }
    }

    public static class d {
        @FileType
        public final String a;
        public final String b;

        public d(@FileType String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("(");
            return a2.b.a.a.a.t(sb, this.b, ")");
        }
    }

    public static class e extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(long r3, long r5) {
            /*
                r2 = this;
                java.lang.String r0 = "File was not written completely. Expected: "
                java.lang.String r1 = ", found: "
                java.lang.StringBuilder r3 = a2.b.a.a.a.O(r0, r3, r1)
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.e.<init>(long, long):void");
        }
    }

    @VisibleForTesting
    public class f implements DiskStorage.Inserter {
        public final String a;
        @VisibleForTesting
        public final File b;

        public f(String str, File file) {
            this.a = str;
            this.b = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            return !this.b.exists() || this.b.delete();
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File c2 = DefaultDiskStorage.this.c(this.a);
            try {
                FileUtils.rename(this.b, c2);
                if (c2.exists()) {
                    c2.setLastModified(DefaultDiskStorage.this.e.now());
                }
                return FileBinaryResource.createOrNull(c2);
            } catch (FileUtils.RenameException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.d;
                int i = DefaultDiskStorage.g;
                cacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.class, "commit", e);
                throw e;
            }
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.b);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long count = countingOutputStream.getCount();
                    fileOutputStream.close();
                    if (this.b.length() != count) {
                        throw new e(count, this.b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.d;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND;
                int i = DefaultDiskStorage.g;
                cacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.class, "updateResource", e);
                throw e;
            }
        }
    }

    public class g implements FileTreeVisitor {
        public boolean a;

        public g(a aVar) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            if (!DefaultDiskStorage.this.a.equals(file) && !this.a) {
                file.delete();
            }
            if (this.a && file.equals(DefaultDiskStorage.this.c)) {
                this.a = false;
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            if (!this.a && file.equals(DefaultDiskStorage.this.c)) {
                this.a = true;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
            if (r10.lastModified() > (r9.b.e.now() - com.facebook.cache.disk.DefaultDiskStorage.f)) goto L_0x0031;
         */
        @Override // com.facebook.common.file.FileTreeVisitor
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitFile(java.io.File r10) {
            /*
                r9 = this;
                boolean r0 = r9.a
                if (r0 == 0) goto L_0x0034
                com.facebook.cache.disk.DefaultDiskStorage r0 = com.facebook.cache.disk.DefaultDiskStorage.this
                com.facebook.cache.disk.DefaultDiskStorage$d r0 = com.facebook.cache.disk.DefaultDiskStorage.a(r0, r10)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x000f
                goto L_0x0032
            L_0x000f:
                java.lang.String r0 = r0.a
                java.lang.String r3 = ".tmp"
                if (r0 != r3) goto L_0x0029
                long r3 = r10.lastModified()
                com.facebook.cache.disk.DefaultDiskStorage r0 = com.facebook.cache.disk.DefaultDiskStorage.this
                com.facebook.common.time.Clock r0 = r0.e
                long r5 = r0.now()
                long r7 = com.facebook.cache.disk.DefaultDiskStorage.f
                long r5 = r5 - r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x0032
                goto L_0x0031
            L_0x0029:
                java.lang.String r3 = ".cnt"
                if (r0 != r3) goto L_0x002e
                r1 = 1
            L_0x002e:
                com.facebook.common.internal.Preconditions.checkState(r1)
            L_0x0031:
                r1 = 1
            L_0x0032:
                if (r1 != 0) goto L_0x0037
            L_0x0034:
                r10.delete()
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.g.visitFile(java.io.File):void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[SYNTHETIC, Splitter:B:23:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultDiskStorage(java.io.File r8, int r9, com.facebook.cache.common.CacheErrorLogger r10) {
        /*
            r7 = this;
            java.lang.Class<com.facebook.cache.disk.DefaultDiskStorage> r0 = com.facebook.cache.disk.DefaultDiskStorage.class
            r7.<init>()
            com.facebook.common.internal.Preconditions.checkNotNull(r8)
            r7.a = r8
            r1 = 0
            r2 = 0
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x003a }
            if (r3 == 0) goto L_0x0042
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x003a }
            java.lang.String r8 = r8.getCanonicalPath()     // Catch:{ IOException -> 0x0021 }
            boolean r8 = r8.contains(r3)     // Catch:{ IOException -> 0x001f }
            goto L_0x0043
        L_0x001f:
            r3 = move-exception
            goto L_0x0023
        L_0x0021:
            r3 = move-exception
            r8 = r1
        L_0x0023:
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r4 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "failed to read folder to check if external: "
            r5.append(r6)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r10.logError(r4, r0, r8, r3)
            goto L_0x0042
        L_0x003a:
            r8 = move-exception
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r3 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER
            java.lang.String r4 = "failed to get the external storage directory!"
            r10.logError(r3, r0, r4, r8)
        L_0x0042:
            r8 = 0
        L_0x0043:
            r7.b = r8
            java.io.File r8 = new java.io.File
            java.io.File r3 = r7.a
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "v2"
            r4[r2] = r5
            r5 = 100
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 1
            r4[r6] = r5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r5 = 2
            r4[r5] = r9
            java.lang.String r9 = "%s.ols%d.%d"
            java.lang.String r9 = java.lang.String.format(r1, r9, r4)
            r8.<init>(r3, r9)
            r7.c = r8
            r7.d = r10
            java.io.File r9 = r7.a
            boolean r9 = r9.exists()
            if (r9 != 0) goto L_0x0076
            goto L_0x0081
        L_0x0076:
            boolean r9 = r8.exists()
            if (r9 != 0) goto L_0x0082
            java.io.File r9 = r7.a
            com.facebook.common.file.FileTree.deleteRecursively(r9)
        L_0x0081:
            r2 = 1
        L_0x0082:
            if (r2 == 0) goto L_0x009e
            com.facebook.common.file.FileUtils.mkdirs(r8)     // Catch:{ CreateDirectoryException -> 0x0088 }
            goto L_0x009e
        L_0x0088:
            com.facebook.cache.common.CacheErrorLogger r8 = r7.d
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r9 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR
            java.lang.String r10 = "version directory could not be created: "
            java.lang.StringBuilder r10 = a2.b.a.a.a.L(r10)
            java.io.File r2 = r7.c
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r8.logError(r9, r0, r10, r1)
        L_0x009e:
            com.facebook.common.time.SystemClock r8 = com.facebook.common.time.SystemClock.get()
            r7.e = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.<init>(java.io.File, int, com.facebook.cache.common.CacheErrorLogger):void");
    }

    public static d a(DefaultDiskStorage defaultDiskStorage, File file) {
        d dVar;
        Objects.requireNonNull(defaultDiskStorage);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            String substring = name.substring(lastIndexOf);
            String str = FileType.CONTENT;
            if (!str.equals(substring)) {
                str = FileType.TEMP.equals(substring) ? FileType.TEMP : null;
            }
            if (str != null) {
                String substring2 = name.substring(0, lastIndexOf);
                if (str.equals(FileType.TEMP)) {
                    int lastIndexOf2 = substring2.lastIndexOf(46);
                    if (lastIndexOf2 > 0) {
                        substring2 = substring2.substring(0, lastIndexOf2);
                    }
                }
                dVar = new d(str, substring2);
                if (dVar == null && new File(defaultDiskStorage.d(dVar.b)).equals(file.getParentFile())) {
                    return dVar;
                }
                return null;
            }
        }
        dVar = null;
        if (dVar == null) {
            return null;
        }
        return dVar;
    }

    public final long b(File file) {
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1;
    }

    @VisibleForTesting
    public File c(String str) {
        return new File(a2.b.a.a.a.u(a2.b.a.a.a.L(d(str)), File.separator, str, FileType.CONTENT));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        FileTree.deleteContents(this.a);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        return e(str, false);
    }

    public final String d(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        return a2.b.a.a.a.t(sb, File.separator, valueOf);
    }

    public final boolean e(String str, boolean z) {
        File c2 = c(str);
        boolean exists = c2.exists();
        if (z && exists) {
            c2.setLastModified(this.e.now());
        }
        return exists;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6 A[SYNTHETIC] */
    @Override // com.facebook.cache.disk.DiskStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.getDumpInfo():com.facebook.cache.disk.DiskStorage$DiskDumpInfo");
    }

    @Override // com.facebook.cache.disk.DiskStorage
    @Nullable
    public BinaryResource getResource(String str, Object obj) {
        File c2 = c(str);
        if (!c2.exists()) {
            return null;
        }
        c2.setLastModified(this.e.now());
        return FileBinaryResource.createOrNull(c2);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        String absolutePath = this.a.getAbsolutePath();
        StringBuilder L = a2.b.a.a.a.L("_");
        L.append(absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()));
        L.append("_");
        L.append(absolutePath.hashCode());
        return L.toString();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        File file = new File(d(str));
        if (!file.exists()) {
            try {
                FileUtils.mkdirs(file);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, DefaultDiskStorage.class, "insert", e2);
                throw e2;
            }
        }
        try {
            return new f(str, File.createTempFile(str + ".", FileType.TEMP, file));
        } catch (IOException e3) {
            this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, DefaultDiskStorage.class, "insert", e3);
            throw e3;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.b;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.a, new g(null));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return b(((c) entry).b.getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) {
        return e(str, true);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getEntries() throws IOException {
        b bVar = new b(null);
        FileTree.walkFileTree(this.c, bVar);
        return Collections.unmodifiableList(bVar.a);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        return b(c(str));
    }
}
