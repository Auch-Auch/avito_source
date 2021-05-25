package com.avito.android.in_app_calls.ui.callReview.reviews;

import com.avito.android.analytics.Event;
import com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProviderImpl;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "callReview", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "answer", "Lcom/avito/android/analytics/Event;", "provide", "(Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)Lcom/avito/android/analytics/Event;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewAnalyticEventProviderImpl implements CallReviewAnalyticEventProvider {
    @Override // com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProvider
    @Nullable
    public Event provide(@NotNull CallReview callReview, @NotNull CallReviewAnswer callReviewAnswer) {
        Intrinsics.checkNotNullParameter(callReview, "callReview");
        Intrinsics.checkNotNullParameter(callReviewAnswer, "answer");
        if (m.isBlank(callReview.getCallId()) || callReviewAnswer.isNoAnswer()) {
            return null;
        }
        if (callReview instanceof CallReview.DeclineReasonReview) {
            return CallReviewAnalyticEventProviderKt.access$provideEventForAnswer((CallReview.DeclineReasonReview) callReview, callReviewAnswer);
        }
        if (callReview instanceof CallReview.CancelReasonReview) {
            return CallReviewAnalyticEventProviderKt.access$provideEventForAnswer((CallReview.CancelReasonReview) callReview, callReviewAnswer);
        }
        throw new NoWhenBranchMatchedException();
    }
}
