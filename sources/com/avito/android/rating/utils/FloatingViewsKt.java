package com.avito.android.rating.utils;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/Function0;", "", "canAppend", "Lio/reactivex/rxjava3/core/Observable;", "floatingViewsChanges", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Observable;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class FloatingViewsKt {

    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    @NotNull
    public static final Observable<Boolean> floatingViewsChanges(@NotNull RecyclerView recyclerView, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$floatingViewsChanges");
        Intrinsics.checkNotNullParameter(function0, "canAppend");
        Observable<Boolean> create = Observable.create(new FloatingViewsKt$floatingViewsChanges$2(recyclerView, function0));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…r(scrollHandler) }\n\n    }");
        return create;
    }

    public static /* synthetic */ Observable floatingViewsChanges$default(RecyclerView recyclerView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = a.a;
        }
        return floatingViewsChanges(recyclerView, function0);
    }
}
