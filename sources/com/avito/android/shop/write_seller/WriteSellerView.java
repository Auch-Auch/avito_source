package com.avito.android.shop.write_seller;

import android.graphics.drawable.Drawable;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\bJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\f\u0010\bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerView;", "", "", "showNetworkProblem", "()V", "", "message", "showMessage", "(Ljava/lang/String;)V", "showProgress", "hideProgress", "highlightNameError", "highlightEmailError", "highlightMessageError", "clearNameError", "clearEmailError", "clearMessageError", "name", "setNameInputValue", "email", "setEmailInputValue", "setMessageInputValue", PlatformActions.HIDE_KEYBOARD, "title", "Landroid/graphics/drawable/Drawable;", "icon", "setToolbar", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "Callback", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface WriteSellerView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerView$Callback;", "", "", "name", "", "onNameEntered", "(Ljava/lang/String;)V", "email", "onEmailEntered", "message", "onMessageEntered", "onSendClicked", "()V", "onBackClicked", "onProgressDialogCanceled", "shop_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onBackClicked();

        void onEmailEntered(@NotNull String str);

        void onMessageEntered(@NotNull String str);

        void onNameEntered(@NotNull String str);

        void onProgressDialogCanceled();

        void onSendClicked();
    }

    void clearEmailError();

    void clearMessageError();

    void clearNameError();

    void hideKeyboard();

    void hideProgress();

    void highlightEmailError(@Nullable String str);

    void highlightMessageError(@Nullable String str);

    void highlightNameError(@Nullable String str);

    void setEmailInputValue(@NotNull String str);

    void setMessageInputValue(@NotNull String str);

    void setNameInputValue(@NotNull String str);

    void setToolbar(@NotNull String str, @NotNull Drawable drawable);

    void showMessage(@NotNull String str);

    void showNetworkProblem();

    void showProgress();
}
