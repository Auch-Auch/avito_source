package a2.a.a.l0.a.c;

import android.util.SparseBooleanArray;
import android.view.MenuItem;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<MenuItem, Unit> {
    public final /* synthetic */ ToolbarSearchViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ToolbarSearchViewImpl toolbarSearchViewImpl) {
        super(1);
        this.a = toolbarSearchViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        Intrinsics.checkNotNullParameter(menuItem2, "it");
        SparseBooleanArray sparseBooleanArray = this.a.u;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(menuItem2.getItemId(), menuItem2.isVisible());
        }
        return Unit.INSTANCE;
    }
}
