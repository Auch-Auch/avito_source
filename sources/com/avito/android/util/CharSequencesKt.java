package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.a;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\t\"\u0017\u0010\u000b\u001a\u00020\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"", "", "isDigitsOnly", "(Ljava/lang/CharSequence;)Z", "isNotNullAndNotEmpty", "isNotNullAndEmpty", "isNotNullAndNotBlank", "", "toInt", "(Ljava/lang/CharSequence;)I", "getTrimmedLength", "trimmedLength", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class CharSequencesKt {
    public static final int getTrimmedLength(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimmedLength");
        int length = charSequence.length();
        int i = 0;
        while (i < length && a.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        while (length > i && a.isWhitespace(charSequence.charAt(length - 1))) {
            length--;
        }
        return length - i;
    }

    public static final boolean isDigitsOnly(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$isDigitsOnly");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isNotNullAndEmpty(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isNotNullAndNotBlank(@Nullable CharSequence charSequence) {
        return !(charSequence == null || m.isBlank(charSequence));
    }

    public static final boolean isNotNullAndNotEmpty(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public static final int toInt(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toInt");
        return Integer.parseInt(charSequence.toString(), a.checkRadix(10));
    }
}
