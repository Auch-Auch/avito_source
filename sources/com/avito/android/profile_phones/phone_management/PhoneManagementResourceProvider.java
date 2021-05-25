package com.avito.android.profile_phones.phone_management;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "", "", "attachPhoneNumberTitle", "()Ljava/lang/String;", "replacePhoneNumberTitle", "phone", "", "itemsCount", "phoneUsedInAdverts", "(Ljava/lang/String;I)Ljava/lang/String;", "phoneNumberHint", "newPhoneNumberHint", "attachButtonText", "replaceButtonText", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneManagementResourceProvider {
    @NotNull
    String attachButtonText();

    @NotNull
    String attachPhoneNumberTitle();

    @NotNull
    String newPhoneNumberHint();

    @NotNull
    String phoneNumberHint();

    @NotNull
    String phoneUsedInAdverts(@NotNull String str, int i);

    @NotNull
    String replaceButtonText();

    @NotNull
    String replacePhoneNumberTitle();
}
