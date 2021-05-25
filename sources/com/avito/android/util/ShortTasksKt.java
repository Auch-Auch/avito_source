package com.avito.android.util;

import com.avito.android.BaseApp;
import com.avito.android.service.short_task.ShortTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "Lcom/avito/android/service/short_task/ShortTask;", "appComponent", "(Lcom/avito/android/service/short_task/ShortTask;)Ljava/lang/Object;", "application_release"}, k = 2, mv = {1, 4, 2})
public final class ShortTasksKt {
    public static final <T> T appComponent(@NotNull ShortTask shortTask) {
        Intrinsics.checkNotNullParameter(shortTask, "$this$appComponent");
        return (T) BaseApp.Companion.getInstance().getApplicationComponent();
    }
}
