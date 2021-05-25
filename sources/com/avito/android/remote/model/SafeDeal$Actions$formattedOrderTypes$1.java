package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SafeDeal$Actions$formattedOrderTypes$1 extends Lambda implements Function1<String, CharSequence> {
    public static final SafeDeal$Actions$formattedOrderTypes$1 INSTANCE = new SafeDeal$Actions$formattedOrderTypes$1();

    public SafeDeal$Actions$formattedOrderTypes$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return '\'' + str + '\'';
    }
}
