package com.avito.android.db;

import android.database.Cursor;
import android.database.CursorWrapper;
import androidx.collection.ArrayMap;
import com.avito.android.remote.auth.AuthSource;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010\tR\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010'R\u0013\u0010+\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/db/CachingCursor;", "Landroid/database/CursorWrapper;", "", "column", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "", "getInt", "(Ljava/lang/String;)I", "getIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getLong", "(Ljava/lang/String;)J", "getLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "", "getFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "getFloatOrNull", "", "getDouble", "(Ljava/lang/String;)Ljava/lang/Double;", "getDoubleOrNull", "", "getBoolean", "(Ljava/lang/String;)Z", "getBooleanOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Ljava/util/Date;", "getDateOrNull", "(Ljava/lang/String;)Ljava/util/Date;", "", "getBlob", "(Ljava/lang/String;)[B", "getBlobOrNull", AuthSource.SEND_ABUSE, "Landroidx/collection/ArrayMap;", "Landroidx/collection/ArrayMap;", "columnIndexes", "getId", "()J", "id", "Landroid/database/Cursor;", "cursor", "<init>", "(Landroid/database/Cursor;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class CachingCursor extends CursorWrapper {
    public final ArrayMap<String, Integer> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachingCursor(@NotNull Cursor cursor) {
        super(cursor);
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.a = new ArrayMap<>(cursor.getColumnCount());
    }

    public final int a(String str) {
        Integer num = this.a.get(str);
        if (num == null) {
            num = Integer.valueOf(super.getColumnIndexOrThrow(str));
            this.a.put(str, num);
        }
        return num.intValue();
    }

    @NotNull
    public final byte[] getBlob(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        byte[] blob = getBlob(a(str));
        Intrinsics.checkNotNullExpressionValue(blob, "getBlob(index)");
        return blob;
    }

    @Nullable
    public final byte[] getBlobOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return getBlob(a3);
    }

    public final boolean getBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        return getInt(a(str)) != 0;
    }

    @Nullable
    public final Boolean getBooleanOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return Boolean.valueOf(getInt(a3) != 0);
    }

    @Nullable
    public final Date getDateOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return new Date(getLong(a3));
    }

    @Nullable
    public final Double getDouble(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        return Double.valueOf(getDouble(a(str)));
    }

    @Nullable
    public final Double getDoubleOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return Double.valueOf(getDouble(a3));
    }

    @Nullable
    public final Float getFloat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        return Float.valueOf(getFloat(a(str)));
    }

    @Nullable
    public final Float getFloatOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return Float.valueOf(getFloat(a3));
    }

    public final long getId() {
        return getLong("_id");
    }

    public final int getInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        return getInt(a(str));
    }

    @Nullable
    public final Integer getIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return Integer.valueOf(getInt(a3));
    }

    public final long getLong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        return getLong(a(str));
    }

    @Nullable
    public final Long getLongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return Long.valueOf(getLong(a3));
    }

    @NotNull
    public final String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        String string = getString(a(str));
        Intrinsics.checkNotNullExpressionValue(string, "getString(index)");
        return string;
    }

    @Nullable
    public final String getStringOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        int a3 = a(str);
        if (isNull(a3)) {
            return null;
        }
        return getString(a3);
    }
}
