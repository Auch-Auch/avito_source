package com.avito.android.in_app_calls.ui.callReview;

import a2.b.a.a.a;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewItem;", "", "", "component1", "()I", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "component2", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "title", "answer", "copy", "(ILcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "getAnswer", AuthSource.SEND_ABUSE, "I", "getTitle", "<init>", "(ILcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewItem {
    public final int a;
    @NotNull
    public final CallReviewAnswer b;

    public CallReviewItem(@StringRes int i, @NotNull CallReviewAnswer callReviewAnswer) {
        Intrinsics.checkNotNullParameter(callReviewAnswer, "answer");
        this.a = i;
        this.b = callReviewAnswer;
    }

    public static /* synthetic */ CallReviewItem copy$default(CallReviewItem callReviewItem, int i, CallReviewAnswer callReviewAnswer, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = callReviewItem.a;
        }
        if ((i2 & 2) != 0) {
            callReviewAnswer = callReviewItem.b;
        }
        return callReviewItem.copy(i, callReviewAnswer);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final CallReviewAnswer component2() {
        return this.b;
    }

    @NotNull
    public final CallReviewItem copy(@StringRes int i, @NotNull CallReviewAnswer callReviewAnswer) {
        Intrinsics.checkNotNullParameter(callReviewAnswer, "answer");
        return new CallReviewItem(i, callReviewAnswer);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallReviewItem)) {
            return false;
        }
        CallReviewItem callReviewItem = (CallReviewItem) obj;
        return this.a == callReviewItem.a && Intrinsics.areEqual(this.b, callReviewItem.b);
    }

    @NotNull
    public final CallReviewAnswer getAnswer() {
        return this.b;
    }

    public final int getTitle() {
        return this.a;
    }

    public int hashCode() {
        int i = this.a * 31;
        CallReviewAnswer callReviewAnswer = this.b;
        return i + (callReviewAnswer != null ? callReviewAnswer.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CallReviewItem(title=");
        L.append(this.a);
        L.append(", answer=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
