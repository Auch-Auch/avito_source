package com.avito.android.in_app_calls.ui.call;

import com.avito.android.in_app_calls.analytics.AppCallRating;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "", "onStart", "()V", "onStop", "Lio/reactivex/Observable;", "getSpeakerClicks", "()Lio/reactivex/Observable;", "speakerClicks", "getDeclineClicks", "declineClicks", "getCloseClicks", "closeClicks", "getHangupClicks", "hangupClicks", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "getRatingButtonClicks", "ratingButtonClicks", "getAnswerClicks", "answerClicks", "getMicClicks", "micClicks", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallView extends Renderer<CallPresenter.State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull CallView callView, @NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(callView, state);
        }
    }

    @NotNull
    Observable<Unit> getAnswerClicks();

    @NotNull
    Observable<Unit> getCloseClicks();

    @NotNull
    Observable<Unit> getDeclineClicks();

    @NotNull
    Observable<Unit> getHangupClicks();

    @NotNull
    Observable<Unit> getMicClicks();

    @NotNull
    Observable<AppCallRating> getRatingButtonClicks();

    @NotNull
    Observable<Unit> getSpeakerClicks();

    void onStart();

    void onStop();
}
