package com.avito.android.location_list;

import android.widget.EditText;
import com.jakewharton.rxbinding3.widget.RxTextView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"location-list_release"}, k = 2, mv = {1, 4, 2})
public final class LocationListViewKt {
    public static final Observable access$textChangesOmitInitialEvent(EditText editText) {
        Observable<CharSequence> skip = RxTextView.textChanges(editText).skip(1);
        Intrinsics.checkNotNullExpressionValue(skip, "this.textChanges().skip(1)");
        return skip;
    }
}
