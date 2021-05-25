package com.avito.android.publish.cpa_tariff;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00120\u000fH&¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffView;", "", "", "name", "phone", "", "fillFieldsWithContactInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "handleNameInputError", "()V", "handlePhoneInputError", "message", "handleRequestError", "(Ljava/lang/String;)V", "stopLoading", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "submitButtonClicks", "errorMessage", "showErrorInSnackBar", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface CpaTariffView {
    void fillFieldsWithContactInfo(@Nullable String str, @Nullable String str2);

    void handleNameInputError();

    void handlePhoneInputError();

    void handleRequestError(@NotNull String str);

    void showErrorInSnackBar(@NotNull String str);

    void stopLoading();

    @NotNull
    Observable<Pair<String, String>> submitButtonClicks();

    @NotNull
    Observable<Unit> upButtonClicks();
}
