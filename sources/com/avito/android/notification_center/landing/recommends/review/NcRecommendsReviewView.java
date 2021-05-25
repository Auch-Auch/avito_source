package com.avito.android.notification_center.landing.recommends.review;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewView;", "", "", "enableButton", "()V", "disableButton", "", "hint", "showHint", "(Ljava/lang/String;)V", "", "text", "showText", "(Ljava/lang/CharSequence;)V", "showProgressDialog", "hideProgressDialog", "message", "showMessage", "Lio/reactivex/Observable;", "getTextChangeCallback", "()Lio/reactivex/Observable;", "getSaveButtonClicks", "getCancelDialogCallback", "getBackButtonClicks", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NcRecommendsReviewView {
    void disableButton();

    void enableButton();

    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getCancelDialogCallback();

    @NotNull
    Observable<Unit> getSaveButtonClicks();

    @NotNull
    Observable<String> getTextChangeCallback();

    void hideProgressDialog();

    void showHint(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgressDialog();

    void showText(@NotNull CharSequence charSequence);
}
