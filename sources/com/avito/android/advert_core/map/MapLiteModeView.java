package com.avito.android.advert_core.map;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/map/MapLiteModeView;", "", "Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "pins", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "clickListener", "", "bindView", "(Lcom/avito/android/remote/model/Coordinates;Ljava/util/List;Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface MapLiteModeView {
    void bindView(@NotNull Coordinates coordinates, @NotNull List<AmenityPin> list, @NotNull AvitoMap.MapClickListener mapClickListener);
}
