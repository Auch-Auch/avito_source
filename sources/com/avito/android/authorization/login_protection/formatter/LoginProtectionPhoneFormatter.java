package com.avito.android.authorization.login_protection.formatter;

import com.avito.android.authorization.login_protection.adapter.phone.PhoneItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "", "", "rawPhone", "searchText", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "formatPhoneNumber", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "formattedPhone", "trimPhone", "(Ljava/lang/String;)Ljava/lang/String;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginProtectionPhoneFormatter {
    @NotNull
    PhoneItem formatPhoneNumber(@NotNull String str, @Nullable String str2);

    @NotNull
    String trimPhone(@NotNull String str);
}
