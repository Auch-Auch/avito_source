package com.avito.android.ui.widget.tagged_input;

import a2.a.a.g3.c.b.d;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.util.RecyclerViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class TagsListViewKt {
    public static final void access$postDecorationsInvalidation(RecyclerView recyclerView) {
        recyclerView.postDelayed(new d(new Function0<Unit>(recyclerView) { // from class: a2.a.a.g3.c.b.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RecyclerViewsKt.invalidateItemDecorationsSafely((RecyclerView) this.receiver);
                return Unit.INSTANCE;
            }
        }), 300);
    }
}
