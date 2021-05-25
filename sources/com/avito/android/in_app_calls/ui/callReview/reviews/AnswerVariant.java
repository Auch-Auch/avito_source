package com.avito.android.in_app_calls.ui.callReview.reviews;

import androidx.annotation.StringRes;
import com.avito.android.in_app_calls.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;", "", "", AuthSource.BOOKING_ORDER, "I", "getStrResource", "()I", "strResource", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "DECLINE_REASON_CANT_ANSWER", "DECLINE_REASON_DONT_WANT", "DECLINE_REASON_DONT_UNDERSTAND", "DECLINE_REASON_NO_LONGER_RELEVANT", "DECLINE_REASON_MISS_CLICK", "CANCEL_REASON_DONT_UNDERSTAND", "CANCEL_REASON_WANT_PHONE_NUMBER", "CANCEL_REASON_NOBODY_ANSWERED", "CANCEL_REASON_DONT_WANT", "ANSWER_CUSTOM", "NO_ANSWER", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public enum AnswerVariant {
    DECLINE_REASON_CANT_ANSWER("cant_answer", R.string.calls_decline_reason_cant_call),
    DECLINE_REASON_DONT_WANT("dont_want", R.string.calls_decline_reason_dont_want),
    DECLINE_REASON_DONT_UNDERSTAND("dont_understand", R.string.calls_decline_reason_dont_understand),
    DECLINE_REASON_NO_LONGER_RELEVANT("no_longer_relevant", R.string.calls_decline_reason_no_longer_relevant),
    DECLINE_REASON_MISS_CLICK("miss_click", R.string.calls_decline_reason_missclick),
    CANCEL_REASON_DONT_UNDERSTAND("dont_understand", R.string.calls_cancel_reason_dont_understand),
    CANCEL_REASON_WANT_PHONE_NUMBER("want_phone_number", R.string.calls_cancel_reason_want_phone_number),
    CANCEL_REASON_NOBODY_ANSWERED("nobody_answered", R.string.calls_cancel_reason_nobody_answered),
    CANCEL_REASON_DONT_WANT("dont_want", R.string.calls_cancel_reason_dont_want),
    ANSWER_CUSTOM("custom", R.string.call_review_answer_other),
    NO_ANSWER("", 0);
    
    @NotNull
    public final String a;
    public final int b;

    /* access modifiers changed from: public */
    AnswerVariant(String str, @StringRes int i) {
        this.a = str;
        this.b = i;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    public final int getStrResource() {
        return this.b;
    }
}
