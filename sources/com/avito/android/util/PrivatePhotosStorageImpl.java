package com.avito.android.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.q.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\u00020\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0015\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/util/PrivatePhotosStorageImpl;", "Lcom/avito/android/util/PrivatePhotosStorage;", "Ljava/io/File;", "createTempFile", "()Ljava/io/File;", "file", "", "deleteFile", "(Ljava/io/File;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "checkFileExists", "(Landroid/net/Uri;)Z", "", "exceptUris", "clearCache", "(Ljava/util/List;)V", "directory", AuthSource.SEND_ABUSE, "(Ljava/io/File;Ljava/util/List;)V", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "c", "internalCacheDirectory", "externalCacheDirectory", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PrivatePhotosStorageImpl implements PrivatePhotosStorage {
    public final Lazy a = c.lazy(new a(0, this));
    public final Lazy b = c.lazy(new a(1, this));
    public final Context c;

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
                File file = new File(PrivatePhotosStorageImpl.access$getExternalCacheRootDir((PrivatePhotosStorageImpl) this.b), "photos-cache");
                Files.ensureDirectoryExists(file);
                return file;
            } else if (i == 1) {
                File file2 = new File(((PrivatePhotosStorageImpl) this.b).c.getCacheDir(), "photos-cache");
                Files.ensureDirectoryExists(file2);
                return file2;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public PrivatePhotosStorageImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = context;
    }

    public static final File access$getExternalCacheRootDir(PrivatePhotosStorageImpl privatePhotosStorageImpl) {
        File externalFilesDir = privatePhotosStorageImpl.c.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null || !Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
            return null;
        }
        return externalFilesDir;
    }

    public final void a(File file, List<? extends Uri> list) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            listFiles = new File[0];
        }
        for (File file2 : listFiles) {
            if (!list.contains(Uri.fromFile(file2))) {
                file2.delete();
            }
        }
    }

    public final File b() {
        return (File) this.a.getValue();
    }

    public final File c() {
        return (File) this.b.getValue();
    }

    @Override // com.avito.android.util.PrivatePhotosStorage
    public boolean checkFileExists(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        File b2 = b();
        return (b2 != null ? b2.exists() : false) || Files.contains(c(), uri);
    }

    @Override // com.avito.android.util.PrivatePhotosStorage
    public void clearCache(@NotNull List<? extends Uri> list) {
        Intrinsics.checkNotNullParameter(list, "exceptUris");
        a(c(), list);
        File b2 = b();
        if (b2 != null) {
            a(b2, list);
        }
    }

    @Override // com.avito.android.util.PrivatePhotosStorage
    @NotNull
    public File createTempFile() {
        File b2 = b();
        if (b2 == null) {
            b2 = c();
        }
        return e.createTempFile("avito-", null, b2);
    }

    @Override // com.avito.android.util.PrivatePhotosStorage
    public void deleteFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        file.delete();
    }
}
