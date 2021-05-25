package com.avito.android.design.widget;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/design/widget/RatioViewGroup;", "", "", "heightRatio", "widthRatio", "", "setRatio", "(II)V", "", "ratio", "(F)V", "widthMeasureSpec", "heightMeasureSpec", "Lcom/avito/android/design/widget/MutableMeasurementPair;", "measureRatio", "(II)Lcom/avito/android/design/widget/MutableMeasurementPair;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface RatioViewGroup {
    @NotNull
    MutableMeasurementPair measureRatio(int i, int i2);

    void setRatio(float f);

    void setRatio(int i, int i2);
}
