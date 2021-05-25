package com.avito.android.in_app_calls.ui.callReview.reviews;

import com.avito.android.analytics.Event;
import com.avito.android.in_app_calls.analytics.AskCancelReasonEvent;
import com.avito.android.in_app_calls.analytics.AskDeclineReasonEvent;
import com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import com.avito.android.util.Logs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallReviewAnalyticEventProviderKt {
    public static final Event access$provideEventForAnswer(CallReview.DeclineReasonReview declineReasonReview, CallReviewAnswer callReviewAnswer) {
        Logs.debug$default("CallReviewAnalyticEventProvider", "Provide event for decline reason review, given answer (id=" + callReviewAnswer + "), declined=" + declineReasonReview.getDeclinedCalls(), null, 4, null);
        return new AskDeclineReasonEvent(declineReasonReview.getCallId(), callReviewAnswer.getVariant().getId(), callReviewAnswer.getCustom(), declineReasonReview.getDeclinedCalls());
    }

    public static final Event access$provideEventForAnswer(CallReview.CancelReasonReview cancelReasonReview, CallReviewAnswer callReviewAnswer) {
        Logs.debug$default("CallReviewAnalyticEventProvider", "Provide event for cancel reason review, given answer (id=" + callReviewAnswer + ')', null, 4, null);
        return new AskCancelReasonEvent(cancelReasonReview.getCallId(), callReviewAnswer.getVariant().getId(), callReviewAnswer.getCustom());
    }
}
