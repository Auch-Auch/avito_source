package com.avito.android.remote;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/RetrofitFactory;", "", "T", "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "retrofit"}, k = 1, mv = {1, 4, 2})
public interface RetrofitFactory {
    <T> T create(@NotNull Class<T> cls);
}
