package com.avito.android.profile;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/UserProfileView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showLogoutProgress", "showError", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "showContent", "onDataChanged", "destroy", PlatformActions.HIDE_KEYBOARD, "Presenter", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfileView extends AppBar {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/UserProfileView$Presenter;", "", "", "onRetryClicked", "()V", "", VKApiConst.POSITION, "onActionClicked", "(I)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter {
        void onActionClicked(int i);

        void onRetryClicked();
    }

    void destroy();

    void hideKeyboard();

    void onDataChanged();

    void showContent();

    void showError();

    void showLogoutProgress();

    void showProgress();

    void showSnackbar(@NotNull String str);
}
