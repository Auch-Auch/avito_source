package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/AvitoTextUtils;", "", "", "text", "", "isNullOrEmpty", "(Ljava/lang/String;)Z", "value", "notNull", "(Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public final class AvitoTextUtils {
    @NotNull
    public static final AvitoTextUtils INSTANCE = new AvitoTextUtils();

    @JvmStatic
    public static final boolean isNullOrEmpty(@Nullable String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated(message = "Use {@link kotlin.text.StringsKt#orEmpty(String)} instead")
    @JvmStatic
    @NotNull
    public static final String notNull(@Nullable String str) {
        return str != null ? str : "";
    }

    @NotNull
    public final CharSequence notNull(@Nullable CharSequence charSequence) {
        return charSequence != null ? charSequence : "";
    }

    @NotNull
    public final String notNull(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        return str != null ? str : str2;
    }
}
