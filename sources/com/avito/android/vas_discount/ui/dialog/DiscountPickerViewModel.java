package com.avito.android.vas_discount.ui.dialog;

import androidx.lifecycle.LiveData;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "subscribeToItemClicks", "(Ljava/util/Set;)V", "Landroidx/lifecycle/LiveData;", "getErrorEvents", "()Landroidx/lifecycle/LiveData;", "errorEvents", "", "Lcom/avito/conveyor_item/Item;", "getDataChanges", "dataChanges", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "getRoutingEvents", "routingEvents", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public interface DiscountPickerViewModel {
    @NotNull
    LiveData<List<Item>> getDataChanges();

    @NotNull
    LiveData<Unit> getErrorEvents();

    @NotNull
    LiveData<StartActivityEvent> getRoutingEvents();

    void subscribeToItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);
}
