package com.avito.android.publish.analytics;

import com.avito.android.publish.NavigationProvider;
import com.avito.android.util.preferences.GeoContract;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "", "", "subscribe", "()V", "unsubscribe", "Lcom/avito/android/publish/NavigationProvider;", GeoContract.PROVIDER, "setNavigationProvider", "(Lcom/avito/android/publish/NavigationProvider;)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "getStructureChangeConsumer", "()Lio/reactivex/functions/Consumer;", "structureChangeConsumer", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishInputsAnalyticTracker {
    @NotNull
    Consumer<DataSource<? extends Item>> getStructureChangeConsumer();

    void setNavigationProvider(@NotNull NavigationProvider navigationProvider);

    void subscribe();

    void unsubscribe();
}
