package a2.a.a.b3.c.a;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModelImpl;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class r<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ SellerCalendarViewModelImpl a;

    public r(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
        this.a = sellerCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
        if (adapterPresenter != null) {
            Intrinsics.checkNotNullExpressionValue(list2, "newItems");
            adapterPresenter.onDataSourceChanged(new ListDataSource(list2));
        }
        this.a.getShowContentChanges().setValue(Unit.INSTANCE);
        MutableLiveData<DiffUtil.DiffResult> updateViewChanges = this.a.getUpdateViewChanges();
        SellerCalendarViewModelImpl sellerCalendarViewModelImpl = this.a;
        List<? extends Item> list3 = sellerCalendarViewModelImpl.getListItems();
        Intrinsics.checkNotNullExpressionValue(list2, "newItems");
        updateViewChanges.setValue(sellerCalendarViewModelImpl.calculateDiff(list3, list2));
        this.a.setListItems(CollectionsKt___CollectionsKt.toList(list2));
    }
}
