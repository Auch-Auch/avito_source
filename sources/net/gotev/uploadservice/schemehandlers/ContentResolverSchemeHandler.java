package net.gotev.uploadservice.schemehandlers;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/ContentResolverSchemeHandler;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "", MessageMetaInfo.COLUMN_PATH, "", "init", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "size", "(Landroid/content/Context;)J", "Ljava/io/InputStream;", "stream", "(Landroid/content/Context;)Ljava/io/InputStream;", "contentType", "(Landroid/content/Context;)Ljava/lang/String;", "name", "", PhoneActionStrings.REMOVE, "(Landroid/content/Context;)Z", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class ContentResolverSchemeHandler implements SchemeHandler {
    public Uri a;

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

    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ ContentResolverSchemeHandler a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ContentResolverSchemeHandler contentResolverSchemeHandler) {
            super(0);
            this.a = contentResolverSchemeHandler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("no cursor data for ");
            L.append(ContentResolverSchemeHandler.access$getUri$p(this.a));
            L.append(", returning size 0");
            return L.toString();
        }
    }

    public static final /* synthetic */ Uri access$getUri$p(ContentResolverSchemeHandler contentResolverSchemeHandler) {
        Uri uri = contentResolverSchemeHandler.a;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.MEDIA_URI);
        }
        return uri;
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @NotNull
    public String contentType(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = this.a;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.MEDIA_URI);
        }
        String type = contentResolver.getType(uri);
        return type == null || m.isBlank(type) ? StringExtensionsKt.APPLICATION_OCTET_STREAM : type;
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    public boolean delete(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = this.a;
            if (uri == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.MEDIA_URI);
            }
            return contentResolver.delete(uri, null, null) > 0;
        } catch (Throwable th) {
            String simpleName = ContentResolverSchemeHandler.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            UploadServiceLogger.error(simpleName, UploadServiceLogger.NA, th, a.a);
            return false;
        }
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    public void init(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(path)");
        this.a = parse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        throw r1;
     */
    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String name(@org.jetbrains.annotations.NotNull android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.content.ContentResolver r1 = r8.getContentResolver()
            android.net.Uri r2 = r7.a
            java.lang.String r8 = "uri"
            if (r2 != 0) goto L_0x0013
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x0013:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x003d
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0036 }
            r2 = 0
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = "_display_name"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            if (r1 == 0) goto L_0x003d
            goto L_0x006a
        L_0x0036:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            throw r1
        L_0x003d:
            android.net.Uri r0 = r7.a
            if (r0 != 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x0044:
            java.lang.String r1 = r0.toString()
            java.lang.String r8 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            r8 = 1
            java.lang.String[] r2 = new java.lang.String[r8]
            r8 = 0
            java.lang.String r0 = java.io.File.separator
            java.lang.String r3 = "File.separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r2[r8] = r0
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.split$default(r1, r2, r3, r4, r5, r6)
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.last(r8)
            r1 = r8
            java.lang.String r1 = (java.lang.String) r1
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler.name(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        throw r1;
     */
    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long size(@org.jetbrains.annotations.NotNull android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.content.ContentResolver r1 = r8.getContentResolver()
            android.net.Uri r2 = r7.a
            if (r2 != 0) goto L_0x0013
            java.lang.String r8 = "uri"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x0013:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0045
            boolean r0 = r8.moveToFirst()     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "_size"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ all -> 0x003e }
            long r2 = r8.getLong(r0)     // Catch:{ all -> 0x003e }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x003e }
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            kotlin.io.CloseableKt.closeFinally(r8, r1)
            if (r0 == 0) goto L_0x0045
            long r0 = r0.longValue()
            goto L_0x005f
        L_0x003e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            throw r1
        L_0x0045:
            java.lang.Class<net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler> r8 = net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler.class
            java.lang.String r0 = r8.getSimpleName()
            java.lang.String r8 = "javaClass.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            r2 = 0
            net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler$b r3 = new net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler$b
            r3.<init>(r7)
            r4 = 4
            r5 = 0
            java.lang.String r1 = "N/A"
            net.gotev.uploadservice.logger.UploadServiceLogger.error$default(r0, r1, r2, r3, r4, r5)
            r0 = 0
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler.size(android.content.Context):long");
    }

    @Override // net.gotev.uploadservice.schemehandlers.SchemeHandler
    @NotNull
    public InputStream stream(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = this.a;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.MEDIA_URI);
        }
        InputStream openInputStream = contentResolver.openInputStream(uri);
        if (openInputStream != null) {
            Intrinsics.checkNotNullExpressionValue(openInputStream, "context.contentResolver.…n input stream for $uri\")");
            return openInputStream;
        }
        StringBuilder L = a2.b.a.a.a.L("can't open input stream for ");
        Uri uri2 = this.a;
        if (uri2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.MEDIA_URI);
        }
        L.append(uri2);
        throw new IOException(L.toString());
    }
}
