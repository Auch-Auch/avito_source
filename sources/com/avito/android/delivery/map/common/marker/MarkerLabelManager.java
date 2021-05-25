package com.avito.android.delivery.map.common.marker;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "", "Lcom/avito/android/avito_map/AvitoMapBounds;", "projection", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "", "", "getLabels", "(Lcom/avito/android/avito_map/AvitoMapBounds;Ljava/util/List;)Ljava/util/Set;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "helper", "", "setMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface MarkerLabelManager {
    @NotNull
    Set<String> getLabels(@Nullable AvitoMapBounds avitoMapBounds, @NotNull List<? extends Marker> list);

    void setMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper);
}
