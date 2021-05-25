package com.sumsub.sns.core.common;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "pattern", "", "ignoreCase", "Lcom/sumsub/sns/core/common/Alphabet;", "initAlphabet", "(Ljava/lang/String;Z)Lcom/sumsub/sns/core/common/Alphabet;", "", AuthSource.SEND_ABUSE, "bits", "bitShiftPattern", "(II)I", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class BitapKt {
    public static final int bitShiftPattern(int i, int i2) {
        return (i >> 1) | (1 << (i2 - 1));
    }

    @NotNull
    public static final Alphabet initAlphabet(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        Alphabet alphabet = new Alphabet();
        if (z) {
            str = ExtensionsKt.lowerCased(str);
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            alphabet.put(Character.valueOf(str.charAt(i2)), 0);
        }
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            alphabet.put(Character.valueOf(charAt), Integer.valueOf((1 << ((str.length() - i3) - 1)) | ((Number) alphabet.get(Character.valueOf(charAt))).intValue()));
            i++;
            i3++;
        }
        return alphabet;
    }

    public static /* synthetic */ Alphabet initAlphabet$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return initAlphabet(str, z);
    }
}
