package com.avito.android.authorization.login_protection.formatter;

import com.avito.android.authorization.login_protection.di.IsPhoneListForAntihackMode;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatterImpl;", "Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "", "rawPhone", "searchText", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "formatPhoneNumber", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "formattedPhone", "trimPhone", "(Ljava/lang/String;)Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "phoneMask", "", "isAntihackMode", "<init>", "(Z)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginProtectionPhoneFormatterImpl implements LoginProtectionPhoneFormatter {
    public final String a;

    @Inject
    public LoginProtectionPhoneFormatterImpl(@IsPhoneListForAntihackMode boolean z) {
        this.a = z ? "+# ### ### ∙ ∙ ∙ ∙" : "+# ### ###-##-##";
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    @Override // com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.authorization.login_protection.adapter.phone.PhoneItem formatPhoneNumber(@org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = "rawPhone"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 0
            r1 = 1
            if (r15 == 0) goto L_0x0016
            int r2 = r15.length()
            if (r2 <= 0) goto L_0x0011
            r2 = 1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            r3 = -1
            if (r2 == 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r14
            r5 = r15
            int r2 = kotlin.text.StringsKt__StringsKt.indexOf$default(r4, r5, r6, r7, r8, r9)
            goto L_0x0029
        L_0x0028:
            r2 = -1
        L_0x0029:
            java.lang.String r4 = "result.append(maskSymbol)"
            r5 = 35
            java.lang.String r6 = "result.toString()"
            if (r2 != r3) goto L_0x0070
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = r13.a
            r2 = 0
        L_0x0039:
            int r3 = r1.length()
            if (r0 >= r3) goto L_0x005e
            char r3 = r1.charAt(r0)
            if (r3 != r5) goto L_0x0055
            int r3 = r14.length()
            if (r2 >= r3) goto L_0x005b
            char r3 = r14.charAt(r2)
            r15.append(r3)
            int r2 = r2 + 1
            goto L_0x005b
        L_0x0055:
            r15.append(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r4)
        L_0x005b:
            int r0 = r0 + 1
            goto L_0x0039
        L_0x005e:
            com.avito.android.authorization.login_protection.adapter.phone.PhoneItem r14 = new com.avito.android.authorization.login_protection.adapter.phone.PhoneItem
            java.lang.String r8 = r15.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r12)
            goto L_0x00cd
        L_0x0070:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            int r15 = r15.length()
            int r15 = r15 + r2
            int r15 = r15 - r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = r13.a
            r3 = 0
            r8 = 0
            r9 = -1
            r10 = -1
        L_0x0084:
            int r11 = r7.length()
            if (r0 >= r11) goto L_0x00b4
            char r11 = r7.charAt(r0)
            int r12 = r3 + 1
            if (r11 != r5) goto L_0x00aa
            int r11 = r14.length()
            if (r8 >= r11) goto L_0x00b0
            char r11 = r14.charAt(r8)
            r1.append(r11)
            if (r8 != r2) goto L_0x00a2
            r9 = r3
        L_0x00a2:
            if (r8 != r15) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r3 = r10
        L_0x00a6:
            int r8 = r8 + 1
            r10 = r3
            goto L_0x00b0
        L_0x00aa:
            r1.append(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x00b0:
            int r0 = r0 + 1
            r3 = r12
            goto L_0x0084
        L_0x00b4:
            com.avito.android.authorization.login_protection.adapter.phone.PhoneItem r14 = new com.avito.android.authorization.login_protection.adapter.phone.PhoneItem
            java.lang.String r15 = r1.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            java.util.Objects.requireNonNull(r15, r0)
            java.lang.CharSequence r15 = kotlin.text.StringsKt__StringsKt.trim(r15)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15, r9, r10)
        L_0x00cd:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatterImpl.formatPhoneNumber(java.lang.String, java.lang.String):com.avito.android.authorization.login_protection.adapter.phone.PhoneItem");
    }

    @Override // com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter
    @NotNull
    public String trimPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "formattedPhone");
        if (str.length() <= 10) {
            return str;
        }
        String substring = str.substring(0, 10);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
