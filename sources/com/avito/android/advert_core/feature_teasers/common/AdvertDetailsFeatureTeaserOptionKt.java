package com.avito.android.advert_core.feature_teasers.common;

import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "okOption", "(Ljava/lang/String;)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "option", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserOptionKt {
    @NotNull
    public static final AdvertDetailsFeatureTeaserOption okOption(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$okOption");
        return new AdvertDetailsFeatureTeaserOption(str, AdvertDetailsFeatureTeaserItem.Icon.Ok);
    }

    @NotNull
    public static final AdvertDetailsFeatureTeaserOption option(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$option");
        return new AdvertDetailsFeatureTeaserOption(str, null);
    }
}
