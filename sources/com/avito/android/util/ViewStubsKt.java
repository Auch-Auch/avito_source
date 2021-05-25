package com.avito.android.util;

import android.view.ViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/ViewStub;", "", "isInflated", "(Landroid/view/ViewStub;)Z", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ViewStubsKt {
    public static final boolean isInflated(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "$this$isInflated");
        return viewStub.getParent() == null;
    }
}
