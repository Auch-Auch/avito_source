package com.avito.android.search.filter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeItem;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005¨\u0006%"}, d2 = {"Lcom/avito/android/search/filter/FiltersChangeProvider;", "", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "getMultiselectClearConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "multiselectClearConsumer", "Lcom/avito/android/items/CheckBoxItem;", "getCheckBoxConsumer", "checkBoxConsumer", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/category_parameters/ParameterElement;", "getClearObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clearObservable", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "getInputItemConsumer", "inputItemConsumer", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "getSelectChangeConsumer", "selectChangeConsumer", "getMultiselectClickConsumer", "multiselectClickConsumer", "getSelectClearConsumer", "selectClearConsumer", "getMultiselectChangeConsumer", "multiselectChangeConsumer", "Lcom/avito/conveyor_item/Item;", "getChangeObservable", "changeObservable", "getClickObservable", "clickObservable", "getSelectClickConsumer", "selectClickConsumer", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeItem;", "getDisplayTypeChangeConsumer", "displayTypeChangeConsumer", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersChangeProvider {
    @NotNull
    Observable<Item> getChangeObservable();

    @NotNull
    Consumer<CheckBoxItem> getCheckBoxConsumer();

    @NotNull
    Observable<ParameterElement> getClearObservable();

    @NotNull
    Observable<ParameterElement> getClickObservable();

    @NotNull
    Consumer<ChangeDisplayTypeItem> getDisplayTypeChangeConsumer();

    @NotNull
    Consumer<ParameterElement.Input> getInputItemConsumer();

    @NotNull
    Consumer<ParameterElement.Multiselect> getMultiselectChangeConsumer();

    @NotNull
    Consumer<ParameterElement.Multiselect> getMultiselectClearConsumer();

    @NotNull
    Consumer<ParameterElement.Multiselect> getMultiselectClickConsumer();

    @NotNull
    Consumer<ParameterElement.Select> getSelectChangeConsumer();

    @NotNull
    Consumer<ParameterElement.Select> getSelectClearConsumer();

    @NotNull
    Consumer<ParameterElement.Select> getSelectClickConsumer();
}
