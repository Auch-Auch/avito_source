package com.avito.android.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.avito.android.remote.model.Size;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.a;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/avito/android/remote/model/Size;", "parseSize", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Size;", "parseSizeEfficently", "", "parseColorOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "models_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "StringUtils")
public final class StringUtils {
    @Nullable
    public static final Integer parseColorOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$parseColorOrNull");
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static final Size parseSize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$parseSize");
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"x"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return null;
        }
        String str2 = (String) split$default.get(0);
        String str3 = (String) split$default.get(1);
        if (m.isBlank(str2) || m.isBlank(str3) || !TextUtils.isDigitsOnly(str2) || !TextUtils.isDigitsOnly(str3)) {
            return null;
        }
        return new Size(Integer.parseInt(str2.toString(), a.checkRadix(10)), Integer.parseInt(str3.toString(), a.checkRadix(10)));
    }

    @Nullable
    public static final Size parseSizeEfficently(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$parseSizeEfficently");
        try {
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) VKApiPhotoSize.X, 0, false, 6, (Object) null);
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring.toString(), a.checkRadix(10));
            String substring2 = str.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            return new Size(parseInt, Integer.parseInt(substring2.toString(), a.checkRadix(10)));
        } catch (Exception unused) {
            Logs.debug$default("Parse size error", null, 2, null);
            return null;
        }
    }
}
