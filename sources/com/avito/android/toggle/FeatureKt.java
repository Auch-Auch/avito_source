package com.avito.android.toggle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lcom/avito/android/toggle/Feature;", "", "canBeRemote", "(Lcom/avito/android/toggle/Feature;)Z", "features_release"}, k = 2, mv = {1, 4, 2})
public final class FeatureKt {
    public static final <T> boolean canBeRemote(@NotNull Feature<? extends T> feature) {
        Intrinsics.checkNotNullParameter(feature, "$this$canBeRemote");
        return feature.isRemote() && (feature.getOriginalValue() instanceof Boolean);
    }
}
