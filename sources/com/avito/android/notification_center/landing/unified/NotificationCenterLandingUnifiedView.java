package com.avito.android.notification_center.landing.unified;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.legacy_mvp.ErrorMessageView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedView;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "showProgress", "()V", "showContent", "", "error", "showLoadingError", "(Ljava/lang/String;)V", "notifyDataChanged", "Lio/reactivex/Observable;", "getBackButtonClicks", "()Lio/reactivex/Observable;", "getRetryButtonClicks", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingUnifiedView extends ErrorMessageView, FavoriteAdvertsView, ViewedAdvertsView {
    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    void notifyDataChanged();

    void showContent();

    void showLoadingError();

    void showLoadingError(@NotNull String str);

    void showProgress();
}
