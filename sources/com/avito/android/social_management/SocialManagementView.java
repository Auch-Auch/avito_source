package com.avito.android.social_management;

import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/social_management/SocialManagementView;", "", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "retryClicks", "", "message", "showError", "(Ljava/lang/String;)V", "showProgress", "()V", "hideProgress", "notifyItemsChanged", "", VKApiConst.POSITION, "notifyItemRemoved", "(I)V", "showMessage", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public interface SocialManagementView {
    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemRemoved(int i);

    void notifyItemsChanged();

    @NotNull
    Observable<Unit> retryClicks();

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgress();
}
