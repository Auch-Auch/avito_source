package com.avito.android.in_app_calls.ui.callReview;

import a2.b.a.a.a;
import com.avito.android.in_app_calls.ui.callReview.reviews.AnswerVariant;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "", "", "isNoAnswer", "()Z", "isCustom", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;", "component1", "()Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;", "", "component2", "()Ljava/lang/String;", "variant", "custom", "copy", "(Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;Ljava/lang/String;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCustom", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;", "getVariant", "<init>", "(Lcom/avito/android/in_app_calls/ui/callReview/reviews/AnswerVariant;Ljava/lang/String;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewAnswer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final AnswerVariant a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer$Companion;", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "noAnswer", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "", "answer", "customAnswer", "(Ljava/lang/String;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CallReviewAnswer customAnswer(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "answer");
            return new CallReviewAnswer(AnswerVariant.ANSWER_CUSTOM, str);
        }

        @NotNull
        public final CallReviewAnswer noAnswer() {
            return new CallReviewAnswer(AnswerVariant.NO_ANSWER, null, 2, null);
        }

        public Companion(j jVar) {
        }
    }

    public CallReviewAnswer(@NotNull AnswerVariant answerVariant, @NotNull String str) {
        Intrinsics.checkNotNullParameter(answerVariant, "variant");
        Intrinsics.checkNotNullParameter(str, "custom");
        this.a = answerVariant;
        this.b = str;
    }

    public static /* synthetic */ CallReviewAnswer copy$default(CallReviewAnswer callReviewAnswer, AnswerVariant answerVariant, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            answerVariant = callReviewAnswer.a;
        }
        if ((i & 2) != 0) {
            str = callReviewAnswer.b;
        }
        return callReviewAnswer.copy(answerVariant, str);
    }

    @NotNull
    public final AnswerVariant component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final CallReviewAnswer copy(@NotNull AnswerVariant answerVariant, @NotNull String str) {
        Intrinsics.checkNotNullParameter(answerVariant, "variant");
        Intrinsics.checkNotNullParameter(str, "custom");
        return new CallReviewAnswer(answerVariant, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallReviewAnswer)) {
            return false;
        }
        CallReviewAnswer callReviewAnswer = (CallReviewAnswer) obj;
        return Intrinsics.areEqual(this.a, callReviewAnswer.a) && Intrinsics.areEqual(this.b, callReviewAnswer.b);
    }

    @NotNull
    public final String getCustom() {
        return this.b;
    }

    @NotNull
    public final AnswerVariant getVariant() {
        return this.a;
    }

    public int hashCode() {
        AnswerVariant answerVariant = this.a;
        int i = 0;
        int hashCode = (answerVariant != null ? answerVariant.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isCustom() {
        return this.a == AnswerVariant.ANSWER_CUSTOM;
    }

    public final boolean isNoAnswer() {
        return this.a == AnswerVariant.NO_ANSWER;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CallReviewAnswer(variant=");
        L.append(this.a);
        L.append(", custom=");
        return a.t(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallReviewAnswer(AnswerVariant answerVariant, String str, int i, j jVar) {
        this(answerVariant, (i & 2) != 0 ? "" : str);
    }
}
