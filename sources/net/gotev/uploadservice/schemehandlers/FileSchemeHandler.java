package net.gotev.uploadservice.schemehandlers;

import android.content.Context;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/FileSchemeHandler;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "", MessageMetaInfo.COLUMN_PATH, "", "init", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "size", "(Landroid/content/Context;)J", "Ljava/io/FileInputStream;", "stream", "(Landroid/content/Context;)Ljava/io/FileInputStream;", "contentType", "(Landroid/content/Context;)Ljava/lang/String;", "name", "", PhoneActionStrings.REMOVE, "(Landroid/content/Context;)Z", "Ljava/io/File;", AuthSource.SEND_ABUSE, "Ljava/io/File;", "file", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class FileSchemeHandler implements SchemeHandler {
    public File a;

    public static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "File deletion error";
        }
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @NotNull
    public String contentType(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = this.a;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return StringExtensionsKt.autoDetectMimeType(absolutePath);
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    public boolean delete(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file = this.a;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
            }
            return file.delete();
        } catch (Throwable th) {
            String simpleName = FileSchemeHandler.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            UploadServiceLogger.error(simpleName, UploadServiceLogger.NA, th, a.a);
            return false;
        }
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    public void init(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        this.a = new File(str);
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @NotNull
    public String name(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = this.a;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        String name = file.getName();
        if (name != null) {
            return name;
        }
        StringBuilder L = a2.b.a.a.a.L("Can't get file name for ");
        File file2 = this.a;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        L.append(file2.getAbsolutePath());
        throw new IOException(L.toString());
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    public long size(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = this.a;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        return file.length();
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @NotNull
    public FileInputStream stream(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = this.a;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        return new FileInputStream(file);
    }
}
