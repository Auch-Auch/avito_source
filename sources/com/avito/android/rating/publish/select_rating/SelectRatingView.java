package com.avito.android.rating.publish.select_rating;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/select_rating/SelectRatingView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "continueClicks", "", "scoreChanges", "score", "setScore", "(I)V", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "()V", "showSendButton", "isLoading", "showLoadingState", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface SelectRatingView {
    @NotNull
    Observable<Unit> continueClicks();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<Integer> scoreChanges();

    void setButtonEnabled(boolean z);

    void setScore(int i);

    void showContinueButton();

    void showLoadingState(boolean z);

    void showSendButton();
}
