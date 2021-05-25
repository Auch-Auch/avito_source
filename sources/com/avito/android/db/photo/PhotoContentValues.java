package com.avito.android.db.photo;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.ContentValues;
import com.avito.android.db.ContentValuePropertyDelegate;
import com.avito.android.db.ContentValuePropertyDelegateKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u00106\u001a\u000201¢\u0006\u0004\b7\u00108J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR/\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R/\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR/\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR/\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR/\u00100\u001a\u0004\u0018\u00010*2\b\u0010\b\u001a\u0004\u0018\u00010*8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/db/photo/PhotoContentValues;", "", "T", "", "key", "Lcom/avito/android/db/ContentValuePropertyDelegate;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lcom/avito/android/db/ContentValuePropertyDelegate;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/ContentValuePropertyDelegate;", "getOperationId", "()Ljava/lang/String;", "setOperationId", "(Ljava/lang/String;)V", "operationId", "", "c", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", VKApiConst.POSITION, "e", "getUploadId", "setUploadId", "uploadId", g.a, "getErrorCode", "setErrorCode", CommonKt.TAG_ERROR_CODE, "h", "getSourceUri", "setSourceUri", "sourceUri", "getTypeId", "setTypeId", "typeId", "f", "getContentUri", "setContentUri", "contentUri", "", "d", "getCreated", "()Ljava/lang/Long;", "setCreated", "(Ljava/lang/Long;)V", "created", "Landroid/content/ContentValues;", "i", "Landroid/content/ContentValues;", "getValues", "()Landroid/content/ContentValues;", ResidentialComplexModuleKt.VALUES, "<init>", "(Landroid/content/ContentValues;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoContentValues {
    public static final /* synthetic */ KProperty[] j = {a.u0(PhotoContentValues.class, "typeId", "getTypeId()Ljava/lang/String;", 0), a.u0(PhotoContentValues.class, "operationId", "getOperationId()Ljava/lang/String;", 0), a.u0(PhotoContentValues.class, VKApiConst.POSITION, "getPosition()Ljava/lang/Integer;", 0), a.u0(PhotoContentValues.class, "created", "getCreated()Ljava/lang/Long;", 0), a.u0(PhotoContentValues.class, "uploadId", "getUploadId()Ljava/lang/String;", 0), a.u0(PhotoContentValues.class, "contentUri", "getContentUri()Ljava/lang/String;", 0), a.u0(PhotoContentValues.class, CommonKt.TAG_ERROR_CODE, "getErrorCode()Ljava/lang/Integer;", 0), a.u0(PhotoContentValues.class, "sourceUri", "getSourceUri()Ljava/lang/String;", 0)};
    @Nullable
    public final ContentValuePropertyDelegate a;
    @Nullable
    public final ContentValuePropertyDelegate b;
    @Nullable
    public final ContentValuePropertyDelegate c;
    @Nullable
    public final ContentValuePropertyDelegate d;
    @Nullable
    public final ContentValuePropertyDelegate e;
    @Nullable
    public final ContentValuePropertyDelegate f;
    @Nullable
    public final ContentValuePropertyDelegate g;
    @Nullable
    public final ContentValuePropertyDelegate h;
    @NotNull
    public final ContentValues i;

    public PhotoContentValues() {
        this(null, 1, null);
    }

    public PhotoContentValues(@NotNull ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, ResidentialComplexModuleKt.VALUES);
        this.i = contentValues;
        this.a = a(PhotoContract.TYPE_ID);
        this.b = a(PhotoContract.OPERATION_ID);
        this.c = a(PhotoContract.POSITION);
        this.d = a(PhotoContract.CREATED);
        this.e = a(PhotoContract.UPLOAD_ID);
        this.f = a(PhotoContract.CONTENT_URI);
        this.g = a(PhotoContract.ERROR_CODE);
        this.h = a(PhotoContract.SOURCE_URI);
    }

    public final <T> ContentValuePropertyDelegate<T> a(String str) {
        return ContentValuePropertyDelegateKt.createContentValueProperty(this.i, str);
    }

    @Nullable
    public final String getContentUri() {
        return (String) this.f.getValue(this, j[5]);
    }

    @Nullable
    public final Long getCreated() {
        return (Long) this.d.getValue(this, j[3]);
    }

    @Nullable
    public final Integer getErrorCode() {
        return (Integer) this.g.getValue(this, j[6]);
    }

    @Nullable
    public final String getOperationId() {
        return (String) this.b.getValue(this, j[1]);
    }

    @Nullable
    public final Integer getPosition() {
        return (Integer) this.c.getValue(this, j[2]);
    }

    @Nullable
    public final String getSourceUri() {
        return (String) this.h.getValue(this, j[7]);
    }

    @Nullable
    public final String getTypeId() {
        return (String) this.a.getValue(this, j[0]);
    }

    @Nullable
    public final String getUploadId() {
        return (String) this.e.getValue(this, j[4]);
    }

    @NotNull
    public final ContentValues getValues() {
        return this.i;
    }

    public final void setContentUri(@Nullable String str) {
        this.f.setValue(this, j[5], str);
    }

    public final void setCreated(@Nullable Long l) {
        this.d.setValue(this, j[3], l);
    }

    public final void setErrorCode(@Nullable Integer num) {
        this.g.setValue(this, j[6], num);
    }

    public final void setOperationId(@Nullable String str) {
        this.b.setValue(this, j[1], str);
    }

    public final void setPosition(@Nullable Integer num) {
        this.c.setValue(this, j[2], num);
    }

    public final void setSourceUri(@Nullable String str) {
        this.h.setValue(this, j[7], str);
    }

    public final void setTypeId(@Nullable String str) {
        this.a.setValue(this, j[0], str);
    }

    public final void setUploadId(@Nullable String str) {
        this.e.setValue(this, j[4], str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoContentValues(ContentValues contentValues, int i2, j jVar) {
        this((i2 & 1) != 0 ? new ContentValues() : contentValues);
    }
}
