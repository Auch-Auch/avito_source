package com.avito.android.user_favorites;

import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "", "Lcom/avito/android/user_favorites/UserFavoritesView;", "view", "", "attachView", "(Lcom/avito/android/user_favorites/UserFavoritesView;)V", "detachView", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", VKApiConst.POSITION, "changeTab", "(I)V", "onResume", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public interface UserFavoritesPresenter {
    void attachView(@NotNull UserFavoritesView userFavoritesView);

    void changeTab(int i);

    void detachView();

    void onResume();

    @NotNull
    Kundle onSaveState();
}
