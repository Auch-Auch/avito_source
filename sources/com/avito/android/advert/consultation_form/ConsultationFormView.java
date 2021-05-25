package com.avito.android.advert.consultation_form;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.ConsultationFormData;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00140\u0011H&¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H&¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormView;", "", "", "name", "phone", "", "fillFieldsWithContactInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "errorMessage", "handleNameInputError", "(Ljava/lang/String;)V", "handlePhoneInputError", "showErrorInSnackBar", "message", "handleRequestError", "stopLoading", "()V", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "submitButtonClicks", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLinkClicks", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "initiateWithData", "(Lcom/avito/android/remote/model/ConsultationFormData;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface ConsultationFormView {
    @NotNull
    Observable<DeepLink> deepLinkClicks();

    void fillFieldsWithContactInfo(@Nullable String str, @Nullable String str2);

    void handleNameInputError(@Nullable String str);

    void handlePhoneInputError(@Nullable String str);

    void handleRequestError(@NotNull String str);

    void initiateWithData(@NotNull ConsultationFormData consultationFormData);

    void showErrorInSnackBar(@NotNull String str);

    void stopLoading();

    @NotNull
    Observable<Pair<String, String>> submitButtonClicks();

    @NotNull
    Observable<Unit> upButtonClicks();
}
