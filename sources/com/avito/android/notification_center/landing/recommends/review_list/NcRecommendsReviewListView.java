package com.avito.android.notification_center.landing.recommends.review_list;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListView;", "", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "showProgressDialog", "hideProgressDialog", "message", "showMessage", "Lio/reactivex/Observable;", "getCancelDialogCallback", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getRetryButtonClicks", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NcRecommendsReviewListView {
    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getCancelDialogCallback();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    void hideProgressDialog();

    void notifyDataChanged();

    void showContent();

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgress();

    void showProgressDialog();
}
