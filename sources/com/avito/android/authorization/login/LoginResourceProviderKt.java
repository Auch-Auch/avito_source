package com.avito.android.authorization.login;

import com.avito.android.util.Strings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "maskIfNeeded", "(Ljava/lang/String;)Ljava/lang/String;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class LoginResourceProviderKt {
    @NotNull
    public static final String maskIfNeeded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$maskIfNeeded");
        return Strings.isEmail(str) ? Strings.maskLogin(str) : str;
    }
}
