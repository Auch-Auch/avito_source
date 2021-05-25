package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SearchParamsConverter$convertToMap$1 extends Lambda implements Function1<String, String> {
    public static final SearchParamsConverter$convertToMap$1 INSTANCE = new SearchParamsConverter$convertToMap$1();

    public SearchParamsConverter$convertToMap$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return str;
    }
}
