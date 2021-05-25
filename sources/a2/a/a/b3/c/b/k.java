package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
import java.util.Set;
public final class k<T> implements Observer<Set<? extends Integer>> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public k(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Set<? extends Integer> set) {
        Set<? extends Integer> set2 = set;
        if (set2 != null && !this.a.b.isComputingLayout()) {
            RecyclerView.ItemDecoration itemDecoration = this.a.h;
            if (itemDecoration != null) {
                this.a.b.removeItemDecoration(itemDecoration);
            }
            SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl = this.a;
            RecyclerView.ItemDecoration access$getRecyclerGroupsDecoration = SellerCalendarParametersViewImpl.access$getRecyclerGroupsDecoration(sellerCalendarParametersViewImpl, set2);
            this.a.b.addItemDecoration(access$getRecyclerGroupsDecoration);
            sellerCalendarParametersViewImpl.h = access$getRecyclerGroupsDecoration;
        }
    }
}
