package com.avito.android.in_app_calls.ui.callReview;

import a2.b.a.a.a;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "type", "", "onTypeChanged", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;)V", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "callReviewAnswer", "onAnswerSelected", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)V", "Landroidx/lifecycle/LiveData;", "getFinishStream", "()Landroidx/lifecycle/LiveData;", "finishStream", "CallReviewAnswerType", "State", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallReviewPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "", "<init>", "(Ljava/lang/String;I)V", "PREDEFINED", "CUSTOM", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public enum CallReviewAnswerType {
        PREDEFINED,
        CUSTOM
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000b¨\u0006%"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "component1", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "", "component2", "()I", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewItem;", "component3", "()Ljava/util/List;", "type", "title", "answers", "copy", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;ILjava/util/List;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "getType", AuthSource.BOOKING_ORDER, "I", "getTitle", "c", "Ljava/util/List;", "getAnswers", "<init>", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;ILjava/util/List;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State d = new State(CallReviewAnswerType.PREDEFINED, 0, CollectionsKt__CollectionsKt.emptyList());
        @NotNull
        public final CallReviewAnswerType a;
        public final int b;
        @NotNull
        public final List<CallReviewItem> c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State$Companion;", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "getDEFAULT", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.d;
            }

            public Companion(j jVar) {
            }
        }

        public State(@NotNull CallReviewAnswerType callReviewAnswerType, @StringRes int i, @NotNull List<CallReviewItem> list) {
            Intrinsics.checkNotNullParameter(callReviewAnswerType, "type");
            Intrinsics.checkNotNullParameter(list, "answers");
            this.a = callReviewAnswerType;
            this.b = i;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, CallReviewAnswerType callReviewAnswerType, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                callReviewAnswerType = state.a;
            }
            if ((i2 & 2) != 0) {
                i = state.b;
            }
            if ((i2 & 4) != 0) {
                list = state.c;
            }
            return state.copy(callReviewAnswerType, i, list);
        }

        @NotNull
        public final CallReviewAnswerType component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final List<CallReviewItem> component3() {
            return this.c;
        }

        @NotNull
        public final State copy(@NotNull CallReviewAnswerType callReviewAnswerType, @StringRes int i, @NotNull List<CallReviewItem> list) {
            Intrinsics.checkNotNullParameter(callReviewAnswerType, "type");
            Intrinsics.checkNotNullParameter(list, "answers");
            return new State(callReviewAnswerType, i, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && this.b == state.b && Intrinsics.areEqual(this.c, state.c);
        }

        @NotNull
        public final List<CallReviewItem> getAnswers() {
            return this.c;
        }

        public final int getTitle() {
            return this.b;
        }

        @NotNull
        public final CallReviewAnswerType getType() {
            return this.a;
        }

        public int hashCode() {
            CallReviewAnswerType callReviewAnswerType = this.a;
            int i = 0;
            int hashCode = (((callReviewAnswerType != null ? callReviewAnswerType.hashCode() : 0) * 31) + this.b) * 31;
            List<CallReviewItem> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(type=");
            L.append(this.a);
            L.append(", title=");
            L.append(this.b);
            L.append(", answers=");
            return a.w(L, this.c, ")");
        }
    }

    @NotNull
    LiveData<Unit> getFinishStream();

    void onAnswerSelected(@NotNull CallReviewAnswer callReviewAnswer);

    void onTypeChanged(@NotNull CallReviewAnswerType callReviewAnswerType);
}
