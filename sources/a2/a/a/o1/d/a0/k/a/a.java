package a2.a.a.o1.d.a0.k.a;

import android.view.View;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsViewImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.bottom_sheet.BottomSheet;
public final class a implements View.OnClickListener {
    public final /* synthetic */ LegacyPlatformActionsViewImpl a;

    public a(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
        this.a = legacyPlatformActionsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (Intrinsics.areEqual(this.a.h.getVisibility(), BottomSheet.Visibility.Expanded.INSTANCE)) {
            this.a.q = Boolean.TRUE;
            this.a.h.collapse();
            return;
        }
        this.a.q = Boolean.FALSE;
        this.a.h.expand();
    }
}
