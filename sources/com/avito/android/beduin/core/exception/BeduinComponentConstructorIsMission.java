package com.avito.android.beduin.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/beduin/core/exception/BeduinComponentConstructorIsMission;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "component", "<init>", "(Ljava/lang/String;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinComponentConstructorIsMission extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeduinComponentConstructorIsMission(@NotNull String str) {
        super("Component " + str + " doesn't have two argument constructor. Argument must be model and action handler");
        Intrinsics.checkNotNullParameter(str, "component");
    }
}
