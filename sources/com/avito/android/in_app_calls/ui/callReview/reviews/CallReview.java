package com.avito.android.in_app_calls.ui.callReview.reviews;

import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0015\u0016R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "c", "Ljava/util/List;", "getAnswers", "()Ljava/util/List;", "answers", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCallId", "()Ljava/lang/String;", "callId", "", AuthSource.SEND_ABUSE, "I", "getTitle", "()I", "title", "CancelReasonReview", "DeclineReasonReview", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$DeclineReasonReview;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$CancelReasonReview;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallReview {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final List<CallReviewAnswer> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$CancelReasonReview;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "", "callId", "<init>", "(Ljava/lang/String;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelReasonReview extends CallReview {
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$CancelReasonReview$Companion;", "", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public static final List access$provideItems(Companion companion) {
                Objects.requireNonNull(companion);
                List<AnswerVariant> plus = CollectionsKt___CollectionsKt.plus((Collection<? extends AnswerVariant>) d.shuffled(CollectionsKt__CollectionsKt.listOf((Object[]) new AnswerVariant[]{AnswerVariant.CANCEL_REASON_DONT_UNDERSTAND, AnswerVariant.CANCEL_REASON_DONT_WANT, AnswerVariant.CANCEL_REASON_NOBODY_ANSWERED, AnswerVariant.CANCEL_REASON_WANT_PHONE_NUMBER})), AnswerVariant.ANSWER_CUSTOM);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(plus, 10));
                for (AnswerVariant answerVariant : plus) {
                    arrayList.add(new CallReviewAnswer(answerVariant, null, 2, null));
                }
                return arrayList;
            }

            public Companion(j jVar) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelReasonReview(@NotNull String str) {
            super(R.string.calls_cancel_reason_title, str, Companion.access$provideItems(Companion), null);
            Intrinsics.checkNotNullParameter(str, "callId");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$DeclineReasonReview;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "", "d", "I", "getDeclinedCalls", "()I", "declinedCalls", "", "callId", "<init>", "(Ljava/lang/String;I)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeclineReasonReview extends CallReview {
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final int d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview$DeclineReasonReview$Companion;", "", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public static final List access$provideItems(Companion companion) {
                Objects.requireNonNull(companion);
                List<AnswerVariant> plus = CollectionsKt___CollectionsKt.plus((Collection<? extends AnswerVariant>) d.shuffled(CollectionsKt__CollectionsKt.listOf((Object[]) new AnswerVariant[]{AnswerVariant.DECLINE_REASON_CANT_ANSWER, AnswerVariant.DECLINE_REASON_DONT_WANT, AnswerVariant.DECLINE_REASON_DONT_UNDERSTAND, AnswerVariant.DECLINE_REASON_NO_LONGER_RELEVANT, AnswerVariant.DECLINE_REASON_MISS_CLICK})), AnswerVariant.ANSWER_CUSTOM);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(plus, 10));
                for (AnswerVariant answerVariant : plus) {
                    arrayList.add(new CallReviewAnswer(answerVariant, null, 2, null));
                }
                return arrayList;
            }

            public Companion(j jVar) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeclineReasonReview(@NotNull String str, int i) {
            super(R.string.calls_decline_reason_title, str, Companion.access$provideItems(Companion), null);
            Intrinsics.checkNotNullParameter(str, "callId");
            this.d = i;
        }

        public final int getDeclinedCalls() {
            return this.d;
        }
    }

    public CallReview(int i, String str, List list, j jVar) {
        this.a = i;
        this.b = str;
        this.c = list;
    }

    @NotNull
    public final List<CallReviewAnswer> getAnswers() {
        return this.c;
    }

    @NotNull
    public final String getCallId() {
        return this.b;
    }

    public final int getTitle() {
        return this.a;
    }
}
