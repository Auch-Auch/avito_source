package com.avito.android.search.map.view.resolvers;

import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.search.map.view.MarkerItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/search/map/view/resolvers/MarkerAnchorResolverImpl;", "Lcom/avito/android/search/map/view/resolvers/MarkerAnchorResolver;", "Lcom/avito/android/search/map/view/MarkerItem;", "item", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "resolveAnchor", "(Lcom/avito/android/search/map/view/MarkerItem;)Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerAnchorResolverImpl implements MarkerAnchorResolver {
    @Override // com.avito.android.search.map.view.resolvers.MarkerAnchorResolver
    @NotNull
    public AvitoMapMarker.Anchor resolveAnchor(@NotNull MarkerItem markerItem) {
        Intrinsics.checkNotNullParameter(markerItem, "item");
        if (markerItem instanceof MarkerItem.Pin) {
            return AvitoMapMarker.Anchor.BOTTOM_CENTER;
        }
        if (markerItem instanceof MarkerItem.MyLocation) {
            return AvitoMapMarker.Anchor.CENTER;
        }
        if (markerItem instanceof MarkerItem.Rash) {
            if (((MarkerItem.Rash) markerItem).getSelected()) {
                return AvitoMapMarker.Anchor.BOTTOM_CENTER;
            }
            return AvitoMapMarker.Anchor.CENTER;
        } else if (markerItem instanceof MarkerItem.SpecialPin) {
            return AvitoMapMarker.Anchor.BOTTOM_CENTER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
