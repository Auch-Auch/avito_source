package com.avito.android.messenger.conversation.mvi.file_attachment;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import arrow.core.Option;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Files;
import com.avito.android.util.Strings;
import io.reactivex.rxjava3.core.Single;
import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0007\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b3\u00104J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0011R#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8B@\u0002X\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010(\u001a\u00020\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u00020\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010'R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R%\u00102\u001a\n 0*\u0004\u0018\u00010\u000f0\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b1\u0010!\u001a\u0004\b%\u0010'¨\u00066"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelperImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "", "fileName", "originalMimeType", "concretizeMimeType", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "contentUri", "fallbackMimeType", "Lio/reactivex/rxjava3/core/Single;", "Larrow/core/Option;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "readFileInfoByContentUri", "(Landroid/net/Uri;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Ljava/io/File;", "createTempFileInInternalDownloadCacheDir", "()Lio/reactivex/rxjava3/core/Single;", "srcFile", "destFileName", "destFileMimeType", "copyFileToDownloads", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "copyToInternalUploadCacheDirAndGet", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "filePath", "", "deleteFileFromInternalUploadCacheDir", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "deleteFileFromInternalDownloadCacheDir", "clearInternalUploadCacheDir", "", "d", "Lkotlin/Lazy;", "getRequiredColumns", "()[Ljava/lang/String;", "requiredColumns", AuthSource.SEND_ABUSE, "getInternalUploadCacheDir", "()Ljava/io/File;", "internalUploadCacheDir", AuthSource.BOOKING_ORDER, "getInternalDownloadCacheDir", "internalDownloadCacheDir", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "kotlin.jvm.PlatformType", "c", "downloadDir", "<init>", "(Landroid/content/Context;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileStorageHelperImpl implements FileStorageHelper {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Lazy a = t6.c.lazy(new a(1, this));
    public final Lazy b = t6.c.lazy(new a(0, this));
    public final Lazy c = t6.c.lazy(h.a);
    public final Lazy d = t6.c.lazy(j.a);
    public final Context e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelperImpl$Companion;", "", "", "GENERIC_BINARY_DATA_MIME_TYPE", "Ljava/lang/String;", "INTERNAL_DOWNLOAD_CACHE_FOLDER_NAME", "INTERNAL_UPLOAD_CACHE_FOLDER_NAME", "TEMP_FILE_PREFIX", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(t6.r.a.j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<File> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            int i = this.a;
            if (i == 0) {
                return new File(((FileStorageHelperImpl) this.b).e.getFilesDir(), "messenger_file_download_cache");
            }
            if (i == 1) {
                return new File(((FileStorageHelperImpl) this.b).e.getFilesDir(), "messenger_file_upload_cache");
            }
            throw null;
        }
    }

    public static final class b<V> implements Callable<Boolean> {
        public final /* synthetic */ FileStorageHelperImpl a;

        public b(FileStorageHelperImpl fileStorageHelperImpl) {
            this.a = fileStorageHelperImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(t6.q.e.deleteRecursively(FileStorageHelperImpl.access$getInternalUploadCacheDir$p(this.a)));
        }
    }

    public static final class c<V> implements Callable<Option<? extends Uri>> {
        public final /* synthetic */ FileStorageHelperImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;

        public c(FileStorageHelperImpl fileStorageHelperImpl, String str, String str2, File file) {
            this.a = fileStorageHelperImpl;
            this.b = str;
            this.c = str2;
            this.d = file;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a9, code lost:
            kotlin.io.CloseableKt.closeFinally(r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
            throw r1;
         */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public arrow.core.Option<? extends android.net.Uri> call() {
            /*
                r9 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto L_0x0035
                android.content.ContentValues r0 = new android.content.ContentValues
                r0.<init>()
                java.lang.String r1 = r9.b
                java.lang.String r2 = "_display_name"
                r0.put(r2, r1)
                java.lang.String r1 = r9.c
                java.lang.String r2 = "mime_type"
                r0.put(r2, r1)
                java.io.File r1 = r9.d
                long r1 = com.avito.android.util.Files.size(r1)
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                java.lang.String r2 = "_size"
                r0.put(r2, r1)
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r1 = r9.a
                android.content.ContentResolver r1 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r1)
                android.net.Uri r2 = android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI
                android.net.Uri r0 = r1.insert(r2, r0)
                goto L_0x006b
            L_0x0035:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r1 = r9.a
                android.content.Context r1 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getContext$p(r1)
                java.lang.String r1 = r1.getPackageName()
                r0.append(r1)
                java.lang.String r1 = ".provider"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r1 = r9.a
                java.io.File r2 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getDownloadDir$p(r1)
                java.lang.String r3 = "downloadDir"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                java.lang.String r3 = r9.b
                java.io.File r1 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$createFileAndEnsureUniqueName(r1, r2, r3)
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r2 = r9.a
                android.content.Context r2 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getContext$p(r2)
                android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r2, r0, r1)
            L_0x006b:
                r1 = 0
                if (r0 == 0) goto L_0x00ad
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r2 = r9.a
                android.content.ContentResolver r2 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r2)
                java.io.OutputStream r2 = r2.openOutputStream(r0)
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r4 = new byte[r3]     // Catch:{ all -> 0x00a6 }
                java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00a6 }
                java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x00a6 }
                java.io.File r7 = r9.d     // Catch:{ all -> 0x00a6 }
                java.io.File r7 = r7.getAbsoluteFile()     // Catch:{ all -> 0x00a6 }
                r6.<init>(r7)     // Catch:{ all -> 0x00a6 }
                r5.<init>(r6)     // Catch:{ all -> 0x00a6 }
            L_0x008c:
                r6 = 0
                int r7 = r5.read(r4, r6, r3)     // Catch:{ all -> 0x00a6 }
                r8 = -1
                if (r7 == r8) goto L_0x009a
                if (r2 == 0) goto L_0x008c
                r2.write(r4, r6, r7)     // Catch:{ all -> 0x00a6 }
                goto L_0x008c
            L_0x009a:
                if (r2 == 0) goto L_0x009f
                r2.flush()     // Catch:{ all -> 0x00a6 }
            L_0x009f:
                r5.close()     // Catch:{ all -> 0x00a6 }
                kotlin.io.CloseableKt.closeFinally(r2, r1)
                goto L_0x00ae
            L_0x00a6:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x00a8 }
            L_0x00a8:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r2, r0)
                throw r1
            L_0x00ad:
                r0 = r1
            L_0x00ae:
                arrow.core.Option r0 = arrow.core.OptionKt.toOption(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.c.call():java.lang.Object");
        }
    }

    public static final class d<V> implements Callable<File> {
        public final /* synthetic */ FileStorageHelperImpl a;
        public final /* synthetic */ Uri b;

        public d(FileStorageHelperImpl fileStorageHelperImpl, Uri uri) {
            this.a = fileStorageHelperImpl;
            this.b = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
            kotlin.io.CloseableKt.closeFinally(r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            kotlin.io.CloseableKt.closeFinally(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            throw r1;
         */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File call() {
            /*
                r5 = this;
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r0 = r5.a
                java.io.File r0 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getInternalUploadCacheDir$p(r0)
                com.avito.android.util.Files.ensureDirectoryExists(r0)
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r0 = r5.a
                java.io.File r0 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getInternalUploadCacheDir$p(r0)
                r1 = 0
                java.lang.String r2 = "file-"
                java.io.File r0 = java.io.File.createTempFile(r2, r1, r0)
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r2 = r5.a
                android.content.ContentResolver r2 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r2)
                android.net.Uri r3 = r5.b
                java.lang.String r4 = "r"
                android.os.ParcelFileDescriptor r2 = r2.openFileDescriptor(r3, r4, r1)
                if (r2 == 0) goto L_0x0053
                java.lang.String r3 = "resolver\n               … descriptor $contentUri\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                java.io.FileInputStream r3 = new java.io.FileInputStream
                java.io.FileDescriptor r2 = r2.getFileDescriptor()
                r3.<init>(r2)
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x004c }
                r2.<init>(r0)     // Catch:{ all -> 0x004c }
                r4 = 1024(0x400, float:1.435E-42)
                kotlin.io.ByteStreamsKt.copyTo(r3, r2, r4)     // Catch:{ all -> 0x0045 }
                kotlin.io.CloseableKt.closeFinally(r2, r1)
                kotlin.io.CloseableKt.closeFinally(r3, r1)
                return r0
            L_0x0045:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0047 }
            L_0x0047:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r2, r0)
                throw r1
            L_0x004c:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x004e }
            L_0x004e:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r3, r0)
                throw r1
            L_0x0053:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Can't get file descriptor "
                java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
                android.net.Uri r2 = r5.b
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.d.call():java.lang.Object");
        }
    }

    public static final class e<V> implements Callable<File> {
        public final /* synthetic */ FileStorageHelperImpl a;

        public e(FileStorageHelperImpl fileStorageHelperImpl) {
            this.a = fileStorageHelperImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public File call() {
            File file = new File(this.a.e.getFilesDir(), "messenger_file_download_cache");
            Files.ensureDirectoryExists(file);
            return File.createTempFile("file-", null, file);
        }
    }

    public static final class f<V> implements Callable<Boolean> {
        public final /* synthetic */ FileStorageHelperImpl a;
        public final /* synthetic */ String b;

        public f(FileStorageHelperImpl fileStorageHelperImpl, String str) {
            this.a = fileStorageHelperImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            String path = FileStorageHelperImpl.access$getInternalDownloadCacheDir$p(this.a).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "internalDownloadCacheDir.path");
            if (m.startsWith$default(this.b, Strings.ensureEndsWith(path, "/"), false, 2, null)) {
                return Boolean.valueOf(new File(this.b).delete());
            }
            throw new IllegalArgumentException("Given uri points to a file not from /messenger_file_download_cache/ directory");
        }
    }

    public static final class g<V> implements Callable<Boolean> {
        public final /* synthetic */ FileStorageHelperImpl a;
        public final /* synthetic */ String b;

        public g(FileStorageHelperImpl fileStorageHelperImpl, String str) {
            this.a = fileStorageHelperImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            String path = FileStorageHelperImpl.access$getInternalUploadCacheDir$p(this.a).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "internalUploadCacheDir.path");
            if (m.startsWith$default(this.b, Strings.ensureEndsWith(path, "/"), false, 2, null)) {
                return Boolean.valueOf(new File(this.b).delete());
            }
            throw new IllegalArgumentException("Given uri points to a file not from /messenger_file_upload_cache/ directory");
        }
    }

    public static final class h extends Lambda implements Function0<File> {
        public static final h a = new h();

        public h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
    }

    public static final class i<V> implements Callable<Option<? extends FileInfo>> {
        public final /* synthetic */ FileStorageHelperImpl a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ String c;

        public i(FileStorageHelperImpl fileStorageHelperImpl, Uri uri, String str) {
            this.a = fileStorageHelperImpl;
            this.b = uri;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
            kotlin.io.CloseableKt.closeFinally(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
            throw r2;
         */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public arrow.core.Option<? extends com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo> call() {
            /*
                r7 = this;
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r0 = r7.a
                android.content.ContentResolver r1 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r0)
                android.net.Uri r2 = r7.b
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r0 = r7.a
                java.lang.String[] r3 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getRequiredColumns$p(r0)
                r4 = 0
                r5 = 0
                r6 = 0
                android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
                r1 = 0
                if (r0 == 0) goto L_0x008b
                boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0084 }
                if (r2 == 0) goto L_0x006b
                java.lang.String r2 = "mime_type"
                int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0084 }
                if (r2 < 0) goto L_0x002b
                java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0084 }
                goto L_0x0037
            L_0x002b:
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r2 = r7.a     // Catch:{ all -> 0x0084 }
                android.content.ContentResolver r2 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r2)     // Catch:{ all -> 0x0084 }
                android.net.Uri r3 = r7.b     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = r2.getType(r3)     // Catch:{ all -> 0x0084 }
            L_0x0037:
                java.lang.String r3 = "application/octet-stream"
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)     // Catch:{ all -> 0x0084 }
                if (r3 == 0) goto L_0x0045
                java.lang.String r3 = r7.c     // Catch:{ all -> 0x0084 }
                if (r3 == 0) goto L_0x0045
                r2 = r3
                goto L_0x004a
            L_0x0045:
                if (r2 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0048:
                java.lang.String r2 = r7.c     // Catch:{ all -> 0x0084 }
            L_0x004a:
                if (r2 == 0) goto L_0x006b
                com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo r3 = new com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo     // Catch:{ all -> 0x0084 }
                java.lang.String r4 = "_display_name"
                int r4 = r0.getColumnIndex(r4)     // Catch:{ all -> 0x0084 }
                java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0084 }
                java.lang.String r5 = "getString(getColumnIndex…ent.COLUMN_DISPLAY_NAME))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x0084 }
                java.lang.String r5 = "_size"
                int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x0084 }
                long r5 = r0.getLong(r5)     // Catch:{ all -> 0x0084 }
                r3.<init>(r4, r2, r5)     // Catch:{ all -> 0x0084 }
                goto L_0x006c
            L_0x006b:
                r3 = r1
            L_0x006c:
                kotlin.io.CloseableKt.closeFinally(r0, r1)
                if (r3 == 0) goto L_0x008b
                com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl r0 = r7.a
                android.content.ContentResolver r0 = com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.access$getResolver$p(r0)
                android.net.Uri r2 = r7.b
                java.io.InputStream r0 = r0.openInputStream(r2)
                if (r0 == 0) goto L_0x008b
                kotlin.io.CloseableKt.closeFinally(r0, r1)
                r1 = r3
                goto L_0x008b
            L_0x0084:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x0086 }
            L_0x0086:
                r2 = move-exception
                kotlin.io.CloseableKt.closeFinally(r0, r1)
                throw r2
            L_0x008b:
                arrow.core.Option r0 = arrow.core.OptionKt.toOption(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl.i.call():java.lang.Object");
        }
    }

    public static final class j extends Lambda implements Function0<String[]> {
        public static final j a = new j();

        public j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String[] invoke() {
            return new String[]{"_display_name", "_size"};
        }
    }

    @Inject
    public FileStorageHelperImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
    }

    public static final File access$createFileAndEnsureUniqueName(FileStorageHelperImpl fileStorageHelperImpl, File file, String str) {
        String str2;
        Objects.requireNonNull(fileStorageHelperImpl);
        File file2 = new File(fileStorageHelperImpl.a(), str);
        String nameWithoutExtension = t6.q.e.getNameWithoutExtension(file2);
        String extension = t6.q.e.getExtension(file2);
        int i2 = 0;
        while (file2.exists()) {
            StringBuilder Q = a2.b.a.a.a.Q(nameWithoutExtension, " (");
            boolean z = true;
            i2++;
            Q.append(i2);
            Q.append(')');
            if (extension.length() <= 0) {
                z = false;
            }
            if (z) {
                str2 = FormatterType.defaultDecimalSeparator + extension;
            } else {
                str2 = "";
            }
            Q.append(str2);
            file2 = new File(fileStorageHelperImpl.a(), Q.toString());
        }
        return file2;
    }

    public static final File access$getInternalDownloadCacheDir$p(FileStorageHelperImpl fileStorageHelperImpl) {
        return (File) fileStorageHelperImpl.b.getValue();
    }

    public static final File access$getInternalUploadCacheDir$p(FileStorageHelperImpl fileStorageHelperImpl) {
        return (File) fileStorageHelperImpl.a.getValue();
    }

    public static final String[] access$getRequiredColumns$p(FileStorageHelperImpl fileStorageHelperImpl) {
        return (String[]) fileStorageHelperImpl.d.getValue();
    }

    public static final ContentResolver access$getResolver$p(FileStorageHelperImpl fileStorageHelperImpl) {
        Objects.requireNonNull(fileStorageHelperImpl);
        return fileStorageHelperImpl.e.getContentResolver();
    }

    public final File a() {
        return (File) this.c.getValue();
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<Boolean> clearInternalUploadCacheDir() {
        Single<Boolean> fromCallable = Single.fromCallable(new b(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { in…Dir.deleteRecursively() }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public String concretizeMimeType(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "originalMimeType");
        if (Intrinsics.areEqual(str2, StringExtensionsKt.APPLICATION_OCTET_STREAM)) {
            String substringAfterLast = StringsKt__StringsKt.substringAfterLast(str, (char) FormatterType.defaultDecimalSeparator, "");
            if (!(!m.isBlank(substringAfterLast))) {
                substringAfterLast = null;
            }
            if (substringAfterLast != null) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                String lowerCase = substringAfterLast.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                if (mimeTypeFromExtension != null) {
                    str2 = mimeTypeFromExtension;
                }
            }
            Intrinsics.checkNotNullExpressionValue(str2, "fileName.substringAfterL…      ?: originalMimeType");
        }
        return str2;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<Option<Uri>> copyFileToDownloads(@NotNull File file, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(file, "srcFile");
        Intrinsics.checkNotNullParameter(str, "destFileName");
        Intrinsics.checkNotNullParameter(str2, "destFileMimeType");
        Single<Option<Uri>> fromCallable = Single.fromCallable(new c(this, str, str2, file));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …   }.toOption()\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<File> copyToInternalUploadCacheDirAndGet(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Single<File> fromCallable = Single.fromCallable(new d(this, uri));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …           file\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<File> createTempFileInInternalDownloadCacheDir() {
        Single<File> fromCallable = Single.fromCallable(new e(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …l, cacheFolder)\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<Boolean> deleteFileFromInternalDownloadCacheDir(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Single<Boolean> fromCallable = Single.fromCallable(new f(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<Boolean> deleteFileFromInternalUploadCacheDir(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Single<Boolean> fromCallable = Single.fromCallable(new g(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper
    @NotNull
    public Single<Option<FileInfo>> readFileInfoByContentUri(@NotNull Uri uri, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Single<Option<FileInfo>> fromCallable = Single.fromCallable(new i(this, uri, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …   }.toOption()\n        }");
        return fromCallable;
    }
}
