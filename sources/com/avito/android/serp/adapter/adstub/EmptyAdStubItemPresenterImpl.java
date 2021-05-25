package com.avito.android.serp.adapter.adstub;

import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenterImpl;", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", "view", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/android/serp/adapter/SerpCommercialBanner;I)V", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyAdStubItemPresenterImpl implements EmptyAdStubItemPresenter {
    public void bindView(@NotNull ItemView itemView, @NotNull SerpCommercialBanner serpCommercialBanner, int i) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "item");
    }
}
