package com.avito.android.util;

import android.database.Cursor;
import com.avito.android.db.CachingCursor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001aF\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u001f\b\u0004\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"Landroid/database/Cursor;", "Lcom/avito/android/db/CachingCursor;", "toCachingCursor", "(Landroid/database/Cursor;)Lcom/avito/android/db/CachingCursor;", "T", "accumulator", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "operation", "fold", "(Landroid/database/Cursor;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "CursorsUtils")
public final class CursorsUtils {
    public static final <T> T fold(@NotNull Cursor cursor, T t, @NotNull Function2<? super Cursor, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(cursor, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        while (cursor.moveToNext()) {
            function2.invoke(cursor, t);
        }
        return t;
    }

    @NotNull
    public static final CachingCursor toCachingCursor(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$this$toCachingCursor");
        if (cursor instanceof CachingCursor) {
            return (CachingCursor) cursor;
        }
        return new CachingCursor(cursor);
    }
}
