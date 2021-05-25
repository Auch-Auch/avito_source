package com.avito.android.lib.design.chips;

import android.view.View;
import com.avito.android.lib.design.chips.Chips;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JY\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010¸\u0006\u0000"}, d2 = {"com/avito/android/util/Views$runOnNextLayoutChange$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", VKApiConst.VERSION, "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Chips$scheduleFitCheck$$inlined$runOnNextLayoutChange$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Chips b;

    public Chips$scheduleFitCheck$$inlined$runOnNextLayoutChange$1(View view, Chips chips) {
        this.a = view;
        this.b = chips;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@Nullable View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.b.getDisplayType() == Chips.DisplayType.SINGLE_LINE_FIXED) {
            Chips chips = this.b;
            if (!(chips.a(chips.m))) {
                this.b.setDisplayType(Chips.DisplayType.SINGLE_LINE_SCROLLABLE);
            }
        }
        if (this.b.getDisplayType() == Chips.DisplayType.SINGLE_LINE_STRETCH) {
            Chips.access$correctView(this.b);
        }
        this.a.removeOnLayoutChangeListener(this);
    }
}
