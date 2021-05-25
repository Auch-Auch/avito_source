package com.avito.android.db.photo;

import android.database.Cursor;
import com.avito.android.db.CachingCursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0013\u0010\u000f\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0013\u0010\u0013\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/db/photo/PhotoCursor;", "Lcom/avito/android/db/CachingCursor;", "", "getOperationId", "()Ljava/lang/String;", "operationId", "", "getCreated", "()J", "created", "getContentUri", "contentUri", "", "getErrorCode", "()I", CommonKt.TAG_ERROR_CODE, "getTypeId", "typeId", "getPhotoPosition", "photoPosition", "getUploadId", "uploadId", "getSourceUri", "sourceUri", "Landroid/database/Cursor;", "cursor", "<init>", "(Landroid/database/Cursor;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoCursor extends CachingCursor {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoCursor(@NotNull Cursor cursor) {
        super(cursor);
        Intrinsics.checkNotNullParameter(cursor, "cursor");
    }

    @Nullable
    public final String getContentUri() {
        return getStringOrNull(PhotoContract.CONTENT_URI);
    }

    public final long getCreated() {
        return getLong(PhotoContract.CREATED);
    }

    public final int getErrorCode() {
        return getInt(PhotoContract.ERROR_CODE);
    }

    @NotNull
    public final String getOperationId() {
        return getString(PhotoContract.OPERATION_ID);
    }

    public final int getPhotoPosition() {
        return getInt(PhotoContract.POSITION);
    }

    @Nullable
    public final String getSourceUri() {
        return getStringOrNull(PhotoContract.SOURCE_URI);
    }

    @NotNull
    public final String getTypeId() {
        return getString(PhotoContract.TYPE_ID);
    }

    @Nullable
    public final String getUploadId() {
        return getStringOrNull(PhotoContract.UPLOAD_ID);
    }
}
