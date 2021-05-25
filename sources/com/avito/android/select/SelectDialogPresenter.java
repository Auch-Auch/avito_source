package com.avito.android.select;

import android.os.Bundle;
import com.avito.android.select.VariantItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/select/SelectDialogPresenter;", "Lcom/avito/android/select/VariantItemPresenter$Listener;", "Lcom/avito/android/select/SelectDialogView;", "view", "", "attachView", "(Lcom/avito/android/select/SelectDialogView;)V", "detachView", "()V", "Lcom/avito/android/select/SelectDialogRouter;", "router", "attachRouter", "(Lcom/avito/android/select/SelectDialogRouter;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "ResourceProvider", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectDialogPresenter extends VariantItemPresenter.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "", "", "getClearItemTitle", "()Ljava/lang/String;", "getSaveTitle", "getClearActionTitle", "select_release"}, k = 1, mv = {1, 4, 2})
    public interface ResourceProvider {
        @NotNull
        String getClearActionTitle();

        @NotNull
        String getClearItemTitle();

        @NotNull
        String getSaveTitle();
    }

    void attachRouter(@NotNull SelectDialogRouter selectDialogRouter);

    void attachView(@NotNull SelectDialogView selectDialogView);

    void detachRouter();

    void detachView();

    @NotNull
    Bundle onSaveState();
}
