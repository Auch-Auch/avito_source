package com.avito.android.remote.model.category_parameters;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lkotlin/Pair;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseParametersConverter$fields$4 extends Lambda implements Function1<Pair<? extends String, ? extends Object>, Boolean> {
    public static final BaseParametersConverter$fields$4 INSTANCE = new BaseParametersConverter$fields$4();

    public BaseParametersConverter$fields$4() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends Object> pair) {
        return Boolean.valueOf(invoke((Pair<String, ? extends Object>) pair));
    }

    public final boolean invoke(@NotNull Pair<String, ? extends Object> pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return pair.getSecond() != null;
    }
}
