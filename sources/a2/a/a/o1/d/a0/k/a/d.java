package a2.a.a.o1.d.a0.k.a;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsViewImpl;
import kotlin.jvm.internal.Intrinsics;
public final class d implements Runnable {
    public final /* synthetic */ LegacyPlatformActionsViewImpl a;

    public d(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
        this.a = legacyPlatformActionsViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl = this.a;
        if (Intrinsics.areEqual(legacyPlatformActionsViewImpl.q, Boolean.TRUE) && !legacyPlatformActionsViewImpl.p) {
            legacyPlatformActionsViewImpl.j.scrollTo(0, 0);
        }
        this.a.r = false;
    }
}
