package com.avito.android.util;

import com.avito.android.db.sqlbrite.Database;
import com.squareup.sqlbrite2.BriteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, d2 = {"T", "Lcom/avito/android/db/sqlbrite/Database;", "Lkotlin/Function0;", "block", "inTransaction", "(Lcom/avito/android/db/sqlbrite/Database;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class DatabasesKt {
    public static final <T> T inTransaction(@NotNull Database database, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(database, "$this$inTransaction");
        Intrinsics.checkNotNullParameter(function0, "block");
        BriteDatabase.Transaction newTransaction = database.newTransaction();
        int i = 1;
        try {
            T t = (T) function0.invoke();
            newTransaction.markSuccessful();
            return t;
        } finally {
            InlineMarker.finallyStart(i);
            newTransaction.end();
            InlineMarker.finallyEnd(i);
        }
    }
}
