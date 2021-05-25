package com.avito.android.public_profile.analytics.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/public_profile/analytics/event/ClosedTabSwitchEvent;", "Lcom/avito/android/public_profile/analytics/event/TabSwitchEvent;", "", "userKey", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedTabSwitchEvent extends TabSwitchEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClosedTabSwitchEvent(@NotNull String str) {
        super(2, str);
        Intrinsics.checkNotNullParameter(str, "userKey");
    }
}
