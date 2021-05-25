package com.jakewharton.rxbinding3.widget;

import a2.k.a.f.h;
import android.widget.AutoCompleteTextView;
import androidx.annotation.CheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxAutoCompleteTextView {
    @CheckResult
    @NotNull
    public static final Observable<AdapterViewItemClickEvent> itemClickEvents(@NotNull AutoCompleteTextView autoCompleteTextView) {
        Intrinsics.checkParameterIsNotNull(autoCompleteTextView, "$this$itemClickEvents");
        return new h(autoCompleteTextView);
    }
}
