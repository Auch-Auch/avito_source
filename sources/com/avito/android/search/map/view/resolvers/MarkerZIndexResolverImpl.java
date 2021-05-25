package com.avito.android.search.map.view.resolvers;

import com.avito.android.remote.model.search.map.Highlight;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.MarkerWithFavorite;
import com.avito.android.search.map.view.MarkerWithHighlight;
import com.avito.android.search.map.view.MarkerWithPrice;
import com.avito.android.search.map.view.SelectableMarker;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/search/map/view/resolvers/MarkerZIndexResolverImpl;", "Lcom/avito/android/search/map/view/resolvers/MarkerZIndexResolver;", "Lcom/avito/android/search/map/view/MarkerItem;", "item", "", "resolveZIndex", "(Lcom/avito/android/search/map/view/MarkerItem;)F", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerZIndexResolverImpl implements MarkerZIndexResolver {
    @Override // com.avito.android.search.map.view.resolvers.MarkerZIndexResolver
    public float resolveZIndex(@NotNull MarkerItem markerItem) {
        Intrinsics.checkNotNullParameter(markerItem, "item");
        if (markerItem instanceof MarkerItem.MyLocation) {
            return 7.0f;
        }
        if (markerItem instanceof MarkerItem.Pin) {
            Objects.requireNonNull(markerItem, "null cannot be cast to non-null type com.avito.android.search.map.view.SelectableMarker");
            if (!((SelectableMarker) markerItem).getSelected()) {
                if ((markerItem instanceof MarkerWithFavorite) && ((MarkerWithFavorite) markerItem).isFavorite()) {
                    return 5.0f;
                }
                if ((markerItem instanceof MarkerWithHighlight) && ((MarkerWithHighlight) markerItem).getHighlight() == Highlight.Bright) {
                    return 4.0f;
                }
                if (!(markerItem instanceof MarkerWithPrice) || ((MarkerWithPrice) markerItem).getPrice() == null) {
                    return 2.0f;
                }
                return 3.0f;
            }
        } else if (markerItem instanceof MarkerItem.Rash) {
            Objects.requireNonNull(markerItem, "null cannot be cast to non-null type com.avito.android.search.map.view.SelectableMarker");
            if (!((SelectableMarker) markerItem).getSelected()) {
                return 1.0f;
            }
        } else if (markerItem instanceof MarkerItem.SpecialPin) {
            return 2.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return 6.0f;
    }
}
