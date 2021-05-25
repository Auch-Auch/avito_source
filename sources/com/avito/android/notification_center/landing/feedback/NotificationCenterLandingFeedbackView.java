package com.avito.android.notification_center.landing.feedback;

import com.avito.android.remote.model.Image;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u000bJ\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;", "", "", "showProgress", "()V", "showContent", "showProgressDialog", "hideProgressDialog", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "text", "setPositiveActionButtonText", "setNegativeActionButtonText", "Lio/reactivex/Observable;", "getPositiveActionButtonClicks", "()Lio/reactivex/Observable;", "getNegativeActionButtonClicks", "getBackButtonClicks", "getRetryButtonClicks", "message", "showResultMessage", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingFeedbackView {
    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getNegativeActionButtonClicks();

    @NotNull
    Observable<Unit> getPositiveActionButtonClicks();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    void hideProgressDialog();

    void setDescription(@NotNull String str);

    void setImage(@NotNull Image image);

    void setNegativeActionButtonText(@NotNull String str);

    void setPositiveActionButtonText(@NotNull String str);

    void setTitle(@NotNull String str);

    void showContent();

    void showError();

    void showError(@NotNull String str);

    void showProgress();

    void showProgressDialog();

    void showResultMessage(@NotNull String str);
}
