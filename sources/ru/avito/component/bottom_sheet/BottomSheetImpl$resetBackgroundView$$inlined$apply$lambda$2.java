package ru.avito.component.bottom_sheet;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "ru/avito/component/bottom_sheet/BottomSheetImpl$resetBackgroundView$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BottomSheetImpl$resetBackgroundView$$inlined$apply$lambda$2 implements View.OnTouchListener {
    public final /* synthetic */ BottomSheetImpl a;

    public BottomSheetImpl$resetBackgroundView$$inlined$apply$lambda$2(BottomSheetImpl bottomSheetImpl, int i) {
        this.a = bottomSheetImpl;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.g.getState() != 3) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getActionMasked() != 1) {
            return true;
        }
        this.a.collapse();
        return true;
    }
}
