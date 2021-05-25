package com.avito.android.db;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Landroid/content/ContentValues;", "", "key", "Lcom/avito/android/db/ContentValuePropertyDelegate;", "createContentValueProperty", "(Landroid/content/ContentValues;Ljava/lang/String;)Lcom/avito/android/db/ContentValuePropertyDelegate;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class ContentValuePropertyDelegateKt {
    @NotNull
    public static final <T> ContentValuePropertyDelegate<T> createContentValueProperty(@NotNull ContentValues contentValues, @NotNull String str) {
        Intrinsics.checkNotNullParameter(contentValues, "$this$createContentValueProperty");
        Intrinsics.checkNotNullParameter(str, "key");
        return new ContentValuePropertyDelegate<>(contentValues, str);
    }
}
