package com.avito.android.notification_center.landing.main;

import com.avito.android.remote.model.Image;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\tJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainView;", "", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "text", "setActionButtonText", "Lio/reactivex/Observable;", "getActionButtonClicks", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getRetryButtonClicks", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingMainView {
    @NotNull
    Observable<Unit> getActionButtonClicks();

    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    void setActionButtonText(@NotNull String str);

    void setDescription(@NotNull String str);

    void setImage(@Nullable Image image);

    void setTitle(@NotNull String str);

    void showContent();

    void showError();

    void showError(@NotNull String str);

    void showProgress();
}
