package com.avito.android.util;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a:\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0005*\u00020\u0000*\u00028\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u000e\u001a\u00028\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0000\"\u0004\b\u0001\u0010\f*\u00028\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"Landroid/database/Cursor;", "", "isEmpty", "(Landroid/database/Cursor;)Z", "isNotEmpty", "T", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "operation", "forEach", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)V", "R", "block", "useCursor", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class CursorsKt {
    public static final <T extends Cursor> void forEach(@NotNull T t, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "operation");
        while (t.moveToNext()) {
            function1.invoke(t);
        }
    }

    public static final boolean isEmpty(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$this$isEmpty");
        return cursor.getCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$this$isNotEmpty");
        return !isEmpty(cursor);
    }

    public static final <T extends Cursor, R> R useCursor(@NotNull T t, @NotNull Function1<? super T, ? extends R> function1) {
        Throwable th;
        boolean z;
        Intrinsics.checkNotNullParameter(t, "$this$useCursor");
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            R r = (R) function1.invoke(t);
            InlineMarker.finallyStart(1);
            t.close();
            InlineMarker.finallyEnd(1);
            return r;
        } catch (Exception e) {
            try {
                t.close();
            } catch (Exception unused) {
            }
            throw e;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        InlineMarker.finallyStart(1);
        if (!z) {
            t.close();
        }
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
