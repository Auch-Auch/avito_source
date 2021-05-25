package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
import com.avito.android.util.RecyclerViewsKt;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Observer<DiffUtil.DiffResult> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public n(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DiffUtil.DiffResult diffResult) {
        RecyclerView.Adapter adapter;
        DiffUtil.DiffResult diffResult2 = diffResult;
        if (diffResult2 != null && !this.a.b.isComputingLayout() && (adapter = this.a.b.getAdapter()) != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "recyclerView.adapter ?: return@Observer");
            diffResult2.dispatchUpdatesTo(adapter);
            RecyclerViewsKt.invalidateItemDecorationsSafely(this.a.b);
        }
    }
}
