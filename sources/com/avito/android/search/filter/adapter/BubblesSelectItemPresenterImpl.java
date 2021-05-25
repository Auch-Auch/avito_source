package com.avito.android.search.filter.adapter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.search.filter.di.FiltersModule;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/BubblesSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "scrollPositions", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "state", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;Lcom/avito/android/util/Kundle;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class BubblesSelectItemPresenterImpl implements BubblesSelectItemPresenter {
    public final Consumer<ParameterElement.Select> a;
    public final Map<String, Integer> b;

    public static final class a implements SelectableBubbleContainer.Item {
        public final long a;
        @NotNull
        public final String b;

        public a(@NotNull SelectableItem selectableItem) {
            Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
            this.a = selectableItem.getId();
            this.b = selectableItem.getTitle();
        }

        @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer.Item
        public long getId() {
            return this.a;
        }

        @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer.Item
        @NotNull
        public String getTitle() {
            return this.b;
        }
    }

    public static final class b extends Lambda implements Function2<Integer, SelectableBubbleContainer.Item, Unit> {
        public final /* synthetic */ BubblesSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BubblesSelectItemPresenterImpl bubblesSelectItemPresenterImpl, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = bubblesSelectItemPresenterImpl;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Integer num, SelectableBubbleContainer.Item item) {
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(item, "<anonymous parameter 1>");
            this.a.b.put(this.b.getStringId(), Integer.valueOf(intValue));
            ParameterElement.Select.Flat flat = this.b;
            flat.setSelectedValue(flat.getValues().get(intValue));
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ BubblesSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(BubblesSelectItemPresenterImpl bubblesSelectItemPresenterImpl, ParameterElement.Select.Flat flat) {
            super(1);
            this.a = bubblesSelectItemPresenterImpl;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            this.a.b.put(this.b.getStringId(), Integer.valueOf(num.intValue()));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public BubblesSelectItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider, @FiltersModule.BubblePresenterState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.a = filtersChangeProvider.getSelectChangeConsumer();
        this.b = new LinkedHashMap();
        if (kundle != null) {
            for (T t : kundle.keySet()) {
                Map<String, Integer> map = this.b;
                Integer num = kundle.getInt(t);
                map.put(t, Integer.valueOf(num != null ? num.intValue() : 0));
            }
        }
    }

    @Override // com.avito.android.search.filter.adapter.BubblesSelectItemPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
            kundle.putInt(entry.getKey(), Integer.valueOf(entry.getValue().intValue()));
        }
        return kundle;
    }

    public void bindView(@NotNull BubblesSelectItemView bubblesSelectItemView, @NotNull ParameterElement.Select.Flat flat, int i) {
        Intrinsics.checkNotNullParameter(bubblesSelectItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        bubblesSelectItemView.setTitle(flat.getTitle());
        List<SelectableItem> values = flat.getValues();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next()));
        }
        bubblesSelectItemView.setItems(arrayList);
        SelectableItem selectedValue = flat.getSelectedValue();
        int max = Math.max(0, selectedValue != null ? flat.getValues().indexOf(selectedValue) : 0);
        bubblesSelectItemView.setSelectedItem(max);
        Integer num = this.b.get(flat.getStringId());
        if (num != null) {
            max = num.intValue();
        }
        bubblesSelectItemView.scrollToPosition(max);
        bubblesSelectItemView.setSelectedItemListener(new b(this, flat));
        bubblesSelectItemView.setOnScrollPositionChangeListener(new c(this, flat));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BubblesSelectItemPresenterImpl(FiltersChangeProvider filtersChangeProvider, Kundle kundle, int i, j jVar) {
        this(filtersChangeProvider, (i & 2) != 0 ? null : kundle);
    }
}
