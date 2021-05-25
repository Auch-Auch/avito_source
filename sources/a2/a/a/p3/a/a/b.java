package a2.a.a.p3.a.a;

import a2.b.a.a.a;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
import com.avito.conveyor_item.Item;
import java.util.List;
public final class b<T> implements Observer<List<? extends Item>> {
    public final /* synthetic */ DiscountDialogFragment a;

    public b(DiscountDialogFragment discountDialogFragment) {
        this.a = discountDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        if (list2 != null) {
            a.s1(list2, this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = DiscountDialogFragment.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            DiscountDialogFragment.access$getRecyclerView$p(this.a).post(new a(this));
        }
    }
}
