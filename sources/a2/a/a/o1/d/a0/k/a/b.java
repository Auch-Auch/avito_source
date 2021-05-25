package a2.a.a.o1.d.a0.k.a;

import android.view.View;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsViewImpl;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.v.e;
public final class b extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ LegacyPlatformActionsViewImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ View c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl, boolean z, View view) {
        super(0);
        this.a = legacyPlatformActionsViewImpl;
        this.b = z;
        this.c = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        int i;
        boolean z = false;
        if (this.b) {
            View view = this.c;
            if (view == null || !Views.isVisible(view)) {
                i = e.coerceAtMost(this.a.h.getView().getHeight(), this.a.n);
            } else {
                i = this.a.i.getTop() + this.c.getHeight();
            }
        } else {
            i = 0;
        }
        boolean z2 = !this.a.u.setExtraPaddingBottom(i);
        int coerceAtLeast = e.coerceAtLeast(i - this.a.m, 0);
        View view2 = this.a.e;
        Intrinsics.checkNotNullExpressionValue(view2, "newMessagesIndicator");
        if (view2.getPaddingBottom() != coerceAtLeast) {
            View view3 = this.a.e;
            Intrinsics.checkNotNullExpressionValue(view3, "newMessagesIndicator");
            Views.changePadding$default(view3, 0, 0, 0, coerceAtLeast, 7, null);
            z2 = false;
        }
        BottomSheet.PeekHeight.Absolute absolute = new BottomSheet.PeekHeight.Absolute(i);
        if (!Intrinsics.areEqual(absolute, this.a.h.getPeekHeight())) {
            this.a.h.setPeekHeight(absolute);
        } else {
            z = z2;
        }
        return Boolean.valueOf(z);
    }
}
