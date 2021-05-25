package com.avito.android.phone_confirmation.view;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/avito/android/phone_confirmation/view/PhoneConfirmationInputView;", "", "Lio/reactivex/functions/Consumer;", "", "getNetworkError", "()Lio/reactivex/functions/Consumer;", "networkError", "Lcom/avito/android/phone_confirmation/view/VisibilityText;", "getValidationError", "validationError", "", "getUnknownError", "unknownError", "", "getSetConfirmationCode", "setConfirmationCode", "getSetTitleMessage", "setTitleMessage", "getShowLoader", "showLoader", "getTerminateDialog", "terminateDialog", "getCleanText", "cleanText", "getCodeButtonStatus", "codeButtonStatus", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneConfirmationInputView {
    @NotNull
    Consumer<Unit> getCleanText();

    @NotNull
    Consumer<VisibilityText> getCodeButtonStatus();

    @NotNull
    Consumer<Boolean> getNetworkError();

    @NotNull
    Consumer<String> getSetConfirmationCode();

    @NotNull
    Consumer<String> getSetTitleMessage();

    @NotNull
    Consumer<Boolean> getShowLoader();

    @NotNull
    Consumer<String> getTerminateDialog();

    @NotNull
    Consumer<Unit> getUnknownError();

    @NotNull
    Consumer<VisibilityText> getValidationError();
}
