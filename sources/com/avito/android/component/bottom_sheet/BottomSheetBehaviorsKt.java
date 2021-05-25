package com.avito.android.component.bottom_sheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\b\u001a\u00020\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;", "Lio/reactivex/rxjava3/core/Observable;", "", "panelStateChanges", "(Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;)Lio/reactivex/rxjava3/core/Observable;", "Landroid/view/View;", "T", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "callbacks", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class BottomSheetBehaviorsKt {
    @NotNull
    public static final <T extends View> BottomSheetAdapter callbacks(@NotNull BottomSheetBehavior<T> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "$this$callbacks");
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter();
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetAdapter);
        return bottomSheetAdapter;
    }

    @NotNull
    public static final Observable<Integer> panelStateChanges(@NotNull BottomSheetAdapter bottomSheetAdapter) {
        Intrinsics.checkNotNullParameter(bottomSheetAdapter, "$this$panelStateChanges");
        Observable<Integer> create = Observable.create(new BottomSheetBehaviorsKt$panelStateChanges$1(bottomSheetAdapter));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…callback)\n        }\n    }");
        return create;
    }
}
