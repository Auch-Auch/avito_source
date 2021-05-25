package com.avito.android.design.widget.lifecycle_view;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/design/widget/lifecycle_view/StateListener;", "", "Lcom/avito/android/util/Kundle;", "state", "", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface StateListener {
    void onRestoreState(@Nullable Kundle kundle);

    @Nullable
    Kundle onSaveState();
}
