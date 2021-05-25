package com.avito.android.advert.actions;

import android.os.Parcelable;
import com.avito.android.view.ActionsMenuData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "Lcom/avito/android/advert/actions/AdvertItemActionsView;", "view", "Landroid/os/Parcelable;", "state", "", "attachView", "(Lcom/avito/android/advert/actions/AdvertItemActionsView;Landroid/os/Parcelable;)V", "detachView", "()V", "Lcom/avito/android/view/ActionsMenuData;", "menuOpenPayload", "onActionsMenuOpened", "(Lcom/avito/android/view/ActionsMenuData;)V", "onActionsMenuClosed", "saveState", "()Landroid/os/Parcelable;", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertItemActionsPresenter extends HiddenAdvertItemPresenter {
    void attachView(@NotNull AdvertItemActionsView advertItemActionsView, @Nullable Parcelable parcelable);

    void detachView();

    void onActionsMenuClosed();

    void onActionsMenuOpened(@NotNull ActionsMenuData actionsMenuData);

    @Nullable
    Parcelable saveState();
}
