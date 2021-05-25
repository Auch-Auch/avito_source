package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "", "", "context", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "", "requestReview", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "getReviewRequestEvents", "()Lio/reactivex/Observable;", "reviewRequestEvents", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface RequestReviewInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "", "<init>", "()V", "Empty", "Error", "Success", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Success;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Error;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State$Success;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends State {
            @NotNull
            public static final Success INSTANCE = new Success();

            public Success() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    @NotNull
    Observable<State> getReviewRequestEvents();

    @NotNull
    Observable<TypedResult<Unit>> requestReview(@NotNull String str);
}
