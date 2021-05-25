package a2.a.a.v2.b.i.a;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

    public j(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = hotelsFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
        if (adapterPresenter != null) {
            Intrinsics.checkNotNullExpressionValue(list2, "newItems");
            adapterPresenter.onDataSourceChanged(new ListDataSource(list2));
        }
        this.a.getShowContentChanges().setValue(Unit.INSTANCE);
        MutableLiveData<DiffUtil.DiffResult> updateViewChanges = this.a.getUpdateViewChanges();
        HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl = this.a;
        List<? extends Item> list3 = hotelsFiltersCalendarViewModelImpl.getListItems();
        Intrinsics.checkNotNullExpressionValue(list2, "newItems");
        updateViewChanges.setValue(hotelsFiltersCalendarViewModelImpl.calculateDiff(list3, list2));
        this.a.setListItems(CollectionsKt___CollectionsKt.toList(list2));
    }
}
