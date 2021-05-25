package com.avito.android.search.map.view.marker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.avito.android.search.map.R;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerSpecialPinViewImpl;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/search/map/view/marker/MarkerSpecialPinView;", "Lcom/avito/android/search/map/view/MarkerItem$SpecialPin;", "item", "", "setSpecialItem", "(Lcom/avito/android/search/map/view/MarkerItem$SpecialPin;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerSpecialPinViewImpl extends FrameLayout implements MarkerSpecialPinView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerSpecialPinViewImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.avito.android.search.map.view.marker.MarkerSpecialPinView
    public void setSpecialItem(@NotNull MarkerItem.SpecialPin specialPin) {
        Intrinsics.checkNotNullParameter(specialPin, "item");
        Views.setBackgroundCompat(this, R.drawable.christmas_tree);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerSpecialPinViewImpl(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerSpecialPinViewImpl(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
