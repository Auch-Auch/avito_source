package com.avito.android.in_app_calls.ui;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.ui.call.CallFragment;
import com.avito.android.in_app_calls.ui.callReview.CallReviewFragment;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/InAppCallsRouterImpl;", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "", "openCallScreen", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "", "callId", "", "declinedCalls", "openDeclineReasonScreen", "(Ljava/lang/String;I)V", "openCancelReasonScreen", "(Ljava/lang/String;)V", "Landroidx/fragment/app/Fragment;", "fragment", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;)V", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", AuthSource.BOOKING_ORDER, "I", "containerId", "<init>", "(Landroidx/fragment/app/FragmentManager;I)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallsRouterImpl implements InAppCallsRouter {
    public final FragmentManager a;
    public final int b;

    @Inject
    public InAppCallsRouterImpl(@NotNull FragmentManager fragmentManager, @IdRes int i) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.a = fragmentManager;
        this.b = i;
    }

    public final void a(Fragment fragment) {
        this.a.beginTransaction().replace(this.b, fragment).commit();
    }

    @Override // com.avito.android.in_app_calls.ui.InAppCallsRouter
    public void openCallScreen(@NotNull CallActivityRequest callActivityRequest) {
        Intrinsics.checkNotNullParameter(callActivityRequest, "request");
        a(CallFragment.Companion.newInstance(callActivityRequest));
    }

    @Override // com.avito.android.in_app_calls.ui.InAppCallsRouter
    public void openCancelReasonScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callId");
        a(CallReviewFragment.Companion.cancelReasonReviewInstance(str));
    }

    @Override // com.avito.android.in_app_calls.ui.InAppCallsRouter
    public void openDeclineReasonScreen(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "callId");
        a(CallReviewFragment.Companion.declineReasonReviewInstance(str, i));
    }
}
