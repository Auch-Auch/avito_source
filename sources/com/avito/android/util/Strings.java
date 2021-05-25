package com.avito.android.util;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\b\u001a\u0010\u0010\u000b\u001a\u00020\u0000H\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0002\u001a\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b\"\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001b\"\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001b¨\u0006#"}, d2 = {"", "md5", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/math/BigInteger;", "md5rawNumber", "(Ljava/lang/String;)Ljava/math/BigInteger;", "prefix", "ensureStartsWith", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "suffix", "ensureEndsWith", "emptyString", "()Ljava/lang/String;", "", "isEmail", "(Ljava/lang/String;)Z", "isPhone", "maskLogin", "", "rawPhone", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "divider", "formatAsNumber", "(Ljava/lang/String;C)Ljava/lang/String;", "Lkotlin/text/Regex;", AuthSource.SEND_ABUSE, "Lkotlin/text/Regex;", "EMAIL_REGEX", "c", "MASK_LOGIN_REGEX", AuthSource.BOOKING_ORDER, "PHONE_REGEX", "d", "DIGITS_REGEX", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Strings")
public final class Strings {
    public static final Regex a = new Regex("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    public static final Regex b = new Regex("^(?:8|\\+7)? ?\\(?\\d{3}\\)? ?\\d{3}(?:[- ])?\\d{2}(?:[- ])?\\d{2}$");
    public static final Regex c = new Regex("(^[^@]{3}|(?!^)\\G)[^@]");
    public static final Regex d = new Regex("[^\\d]");

    @NotNull
    public static final String emptyString() {
        return "";
    }

    @NotNull
    public static final String ensureEndsWith(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$ensureEndsWith");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        return m.endsWith$default(str, str2, false, 2, null) ? str : a.c3(str, str2);
    }

    @NotNull
    public static final String ensureStartsWith(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$ensureStartsWith");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        return m.startsWith$default(str, str2, false, 2, null) ? str : a.c3(str2, str);
    }

    @Nullable
    public static final String formatAsNumber(@Nullable String str, char c2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Intrinsics.checkNotNull(str);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        String str2 = "";
        while (true) {
            if (sb2.length() > 0) {
                str2 = StringsKt___StringsKt.takeLast(sb2, 3) + c2 + str2;
                sb2 = StringsKt___StringsKt.dropLast(sb2, 3);
            } else {
                Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                return StringsKt__StringsKt.trim(str2).toString();
            }
        }
    }

    public static /* synthetic */ String formatAsNumber$default(String str, char c2, int i, Object obj) {
        if ((i & 1) != 0) {
            c2 = ' ';
        }
        return formatAsNumber(str, c2);
    }

    public static final boolean isEmail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$isEmail");
        return a.matches(str);
    }

    public static final boolean isPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$isPhone");
        return b.matches(str);
    }

    @NotNull
    public static final String maskLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$maskLogin");
        return c.replace(str, "$1*");
    }

    @NotNull
    public static final String md5(@NotNull String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "$this$md5");
        String bigInteger = md5rawNumber(str).toString(16);
        while (bigInteger.length() < 32) {
            bigInteger = a.c3("0", bigInteger);
        }
        Intrinsics.checkNotNullExpressionValue(bigInteger, "md5Value");
        return bigInteger;
    }

    @NotNull
    public static final BigInteger md5rawNumber(@NotNull String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "$this$md5rawNumber");
        MessageDigest instance = MessageDigest.getInstance(Constants.MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        instance.update(bytes);
        return new BigInteger(1, instance.digest());
    }

    @NotNull
    public static final CharSequence rawPhone(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$rawPhone");
        return d.replace(charSequence, "");
    }
}
