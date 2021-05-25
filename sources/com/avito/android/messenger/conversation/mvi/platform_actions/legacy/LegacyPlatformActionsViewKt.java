package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a@\u0010\t\u001a\u00020\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "T", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "P", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "presenter", "", "bindContentPresenter", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;)V", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class LegacyPlatformActionsViewKt {
    public static final /* synthetic */ <T extends LegacyPlatformActionsPresenter.ContentData, P extends LegacyPlatformActionsView.ContentPresenter<T>> void bindContentPresenter(LegacyPlatformActionsView legacyPlatformActionsView, LifecycleOwner lifecycleOwner, P p) {
        Intrinsics.checkNotNullParameter(legacyPlatformActionsView, "$this$bindContentPresenter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(p, "presenter");
        Intrinsics.reifiedOperationMarker(4, "T");
        legacyPlatformActionsView.bindContentPresenter(LegacyPlatformActionsPresenter.ContentData.class, lifecycleOwner, p);
    }
}
