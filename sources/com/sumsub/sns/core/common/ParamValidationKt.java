package com.sumsub.sns.core.common;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"", "", "isValidApplicant", "(Ljava/lang/String;)Z", "isValidToken", "isValidUrl", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class ParamValidationKt {
    public static final boolean isValidApplicant(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$isValidApplicant");
        return new Regex("[0-9a-f]{24}").matches(str);
    }

    public static final boolean isValidToken(@Nullable String str) {
        return str != null && str.length() >= 5;
    }

    public static final boolean isValidUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$isValidUrl");
        try {
            new URL(str).toURI();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
