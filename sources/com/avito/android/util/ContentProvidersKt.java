package com.avito.android.util;

import android.content.ContentProvider;
import android.content.Context;
import com.avito.android.app.di.HasApplicationComponent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "Landroid/content/ContentProvider;", "appComponent", "(Landroid/content/ContentProvider;)Ljava/lang/Object;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ContentProvidersKt {
    public static final <T> T appComponent(@NotNull ContentProvider contentProvider) {
        Intrinsics.checkNotNullParameter(contentProvider, "$this$appComponent");
        Context context = contentProvider.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.avito.android.app.di.HasApplicationComponent");
        return (T) ((HasApplicationComponent) context).getApplicationComponent();
    }
}
