package com.avito.android.avito_map;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "Lkotlin/Pair;", "denormalizeCoordinates", "(DD)Lkotlin/Pair;", "", "DEFAULT_ANIMATION_DURATION", "F", "avito-map_release"}, k = 2, mv = {1, 4, 2})
public final class AvitoMapKt {
    public static final float DEFAULT_ANIMATION_DURATION = 0.5f;

    @NotNull
    public static final Pair<Double, Double> denormalizeCoordinates(double d, double d2) {
        if (d2 > d) {
            return new Pair<>(Double.valueOf(d), Double.valueOf(d2));
        }
        if (Math.abs(d2) > Math.abs(d)) {
            return new Pair<>(Double.valueOf(d), Double.valueOf(d2 + ((double) 360)));
        }
        return new Pair<>(Double.valueOf(d - ((double) 360)), Double.valueOf(d2));
    }
}
