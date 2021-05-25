package com.jakewharton.rxbinding3.view;

import a2.k.a.d.i;
import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxViewGroup {
    @CheckResult
    @NotNull
    public static final Observable<ViewGroupHierarchyChangeEvent> changeEvents(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$changeEvents");
        return new i(viewGroup);
    }
}
