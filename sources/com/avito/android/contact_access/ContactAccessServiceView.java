package com.avito.android.contact_access;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServiceView;", "", "", "showProgress", "()V", "hideProgress", "networkError", "", "message", "serverError", "(Ljava/lang/String;)V", "Lcom/avito/android/contact_access/PresentationAccessServiceModel;", "presentationModel", "setContent", "(Lcom/avito/android/contact_access/PresentationAccessServiceModel;)V", "", "formattedText", "setUpLegalTextView", "(Ljava/lang/CharSequence;)V", "showSnackbar", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface ContactAccessServiceView {
    void hideProgress();

    void networkError();

    void serverError(@NotNull String str);

    void setContent(@NotNull PresentationAccessServiceModel presentationAccessServiceModel);

    void setUpLegalTextView(@Nullable CharSequence charSequence);

    void showProgress();

    void showSnackbar(@NotNull String str);
}
