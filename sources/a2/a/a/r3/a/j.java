package a2.a.a.r3.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class j implements SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ Function0 a;

    public j(Function0 function0) {
        this.a = function0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final /* synthetic */ void onRefresh() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
