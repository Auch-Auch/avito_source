package com.avito.android.messenger.conversation;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.NetworkProblemView;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelProgressOverlay;", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "Landroid/view/ViewGroup;", "containerView", "Lcom/avito/android/design/widget/NetworkProblemView;", "overlay", "", "showOverlay", "(Landroid/view/ViewGroup;Lcom/avito/android/design/widget/NetworkProblemView;)V", "Landroid/view/View;", "removeOverlay", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelProgressOverlay extends ProgressOverlay {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelProgressOverlay(@NotNull ViewGroup viewGroup, @NotNull Analytics analytics) {
        super(viewGroup, 0, analytics, false, 0, 26, null);
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
    }

    @Override // com.avito.android.progress_overlay.ProgressOverlay
    public void removeOverlay(@NotNull ViewGroup viewGroup, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        if (view != null) {
            TransitionManager.beginDelayedTransition(viewGroup, new Fade().addTarget(view));
            Views.conceal(view);
        }
    }

    @Override // com.avito.android.progress_overlay.ProgressOverlay
    public void showOverlay(@NotNull ViewGroup viewGroup, @NotNull NetworkProblemView networkProblemView) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        Intrinsics.checkNotNullParameter(networkProblemView, "overlay");
        TransitionManager.beginDelayedTransition(viewGroup, new Fade().addTarget(networkProblemView));
        Views.show(networkProblemView);
    }
}
