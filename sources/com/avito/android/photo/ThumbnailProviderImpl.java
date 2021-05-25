package com.avito.android.photo;

import android.content.ContentResolver;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Maybe;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo/ThumbnailProviderImpl;", "Lcom/avito/android/photo/ThumbnailProvider;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lio/reactivex/Maybe;", "getThumbnail", "(Landroid/net/Uri;)Lio/reactivex/Maybe;", "Landroid/content/ContentResolver;", AuthSource.SEND_ABUSE, "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "contentResolver", "<init>", "(Landroid/content/ContentResolver;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ThumbnailProviderImpl implements ThumbnailProvider {
    @NotNull
    public final ContentResolver a;

    public static final class a<V> implements Callable<Uri> {
        public final /* synthetic */ ThumbnailProviderImpl a;
        public final /* synthetic */ Uri b;

        public a(ThumbnailProviderImpl thumbnailProviderImpl, Uri uri) {
            this.a = thumbnailProviderImpl;
            this.b = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Uri call() {
            return ThumbnailProviderImpl.access$loadThumbnail(this.a, this.b);
        }
    }

    public ThumbnailProviderImpl(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.a = contentResolver;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri access$loadThumbnail(com.avito.android.photo.ThumbnailProviderImpl r7, android.net.Uri r8) {
        /*
            java.util.Objects.requireNonNull(r7)
            r0 = 0
            java.lang.String r1 = android.provider.DocumentsContract.getDocumentId(r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = "documentId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = ":"
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x002c }
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.split$default(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x002c }
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x002c }
            if (r8 == 0) goto L_0x002c
            long r1 = java.lang.Long.parseLong(r8)     // Catch:{ Exception -> 0x002c }
            java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x002c }
            goto L_0x002d
        L_0x002c:
            r8 = r0
        L_0x002d:
            if (r8 == 0) goto L_0x0073
            long r1 = r8.longValue()
            android.content.ContentResolver r7 = r7.a
            r8 = 1
            android.database.Cursor r7 = android.provider.MediaStore.Images.Thumbnails.queryMiniThumbnail(r7, r1, r8, r0)
            if (r7 == 0) goto L_0x0073
            boolean r1 = com.avito.android.util.CursorsKt.isNotEmpty(r7)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            r7.moveToFirst()     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            java.lang.String r1 = "_data"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            r2 = -1
            if (r1 != r2) goto L_0x004f
            goto L_0x005c
        L_0x004f:
            java.lang.String r0 = r7.getString(r1)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            android.net.Uri r0 = android.net.Uri.fromFile(r1)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
        L_0x005c:
            r7.close()
            goto L_0x0073
        L_0x0060:
            r8 = move-exception
            r0 = 0
            r0 = r8
            r8 = 0
            goto L_0x006d
        L_0x0065:
            r0 = move-exception
            r7.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x006c
        L_0x006a:
            r0 = move-exception
            goto L_0x006d
        L_0x006c:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x006d:
            if (r8 != 0) goto L_0x0072
            r7.close()
        L_0x0072:
            throw r0
        L_0x0073:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo.ThumbnailProviderImpl.access$loadThumbnail(com.avito.android.photo.ThumbnailProviderImpl, android.net.Uri):android.net.Uri");
    }

    @NotNull
    public final ContentResolver getContentResolver() {
        return this.a;
    }

    @Override // com.avito.android.photo.ThumbnailProvider
    @NotNull
    public Maybe<Uri> getThumbnail(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Maybe<Uri> fromCallable = Maybe.fromCallable(new a(this, uri));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Maybe.fromCallable {\n   …dThumbnail(uri)\n        }");
        return fromCallable;
    }
}
