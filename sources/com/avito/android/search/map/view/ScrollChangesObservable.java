package com.avito.android.search.map.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/map/view/ScrollChangesObservable;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lio/reactivex/rxjava3/core/Observable;", "", "scrollObservable", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/LinearLayoutManager;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "canAppend", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class ScrollChangesObservable {
    public final Function0<Boolean> a;

    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public ScrollChangesObservable() {
        this(null, 1, null);
    }

    public ScrollChangesObservable(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "canAppend");
        this.a = function0;
    }

    @NotNull
    public final Observable<Boolean> scrollObservable(@NotNull RecyclerView recyclerView, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Observable<Boolean> create = Observable.create(new ScrollChangesObservable$scrollObservable$1(this, linearLayoutManager, recyclerView));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…stener(handler)\n        }");
        return create;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollChangesObservable(Function0 function0, int i, j jVar) {
        this((i & 1) != 0 ? a.a : function0);
    }
}
