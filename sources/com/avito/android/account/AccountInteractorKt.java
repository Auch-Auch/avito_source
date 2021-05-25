package com.avito.android.account;

import a2.a.a.e.g;
import a2.a.a.e.h;
import a2.a.a.e.i;
import a2.a.a.e.j;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"account-storage_release"}, k = 2, mv = {1, 4, 2})
public final class AccountInteractorKt {
    public static final Observable access$filterError(Observable observable, Function1 function1) {
        Observable dematerialize = observable.materialize().filter(new g(function1)).dematerialize(h.a);
        Intrinsics.checkNotNullExpressionValue(dematerialize, "this\n    .materialize()\n…ialize { value -> value }");
        return dematerialize;
    }

    public static final Observable access$toLoginLoadingState(Observable observable) {
        Observable map = observable.map(i.a);
        Intrinsics.checkNotNullExpressionValue(map, "map { response ->\n      …        }\n        }\n    }");
        return map;
    }

    public static final Observable access$toSocialLoadingState(Observable observable) {
        Observable map = observable.map(j.a);
        Intrinsics.checkNotNullExpressionValue(map, "map { response ->\n      …se.error)\n        }\n    }");
        return map;
    }
}
