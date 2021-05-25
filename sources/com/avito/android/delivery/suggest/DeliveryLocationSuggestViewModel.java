package com.avito.android.delivery.suggest;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.Coordinates;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "", "", "query", "", "searchSuggestions", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinatesChanges", "()Landroidx/lifecycle/LiveData;", "coordinatesChanges", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "getDataChanges", "dataChanges", "", "getErrorChanges", "errorChanges", "Lio/reactivex/rxjava3/functions/Consumer;", "getCoordinatesConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "coordinatesConsumer", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryLocationSuggestViewModel {
    @NotNull
    LiveData<Coordinates> getCoordinatesChanges();

    @NotNull
    Consumer<Coordinates> getCoordinatesConsumer();

    @NotNull
    LiveData<DataSource<Item>> getDataChanges();

    @NotNull
    LiveData<Boolean> getErrorChanges();

    void searchSuggestions(@NotNull String str);
}
