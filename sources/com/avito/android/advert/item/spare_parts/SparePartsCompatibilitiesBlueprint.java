package com.avito.android.advert.item.spare_parts;

import com.avito.android.advert.item.spare_parts.di.SparePartsModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsCompatibilitiesBlueprint;", "Lcom/avito/android/advert/item/spare_parts/SparePartsBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "presenter", "<init>", "(Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsCompatibilitiesBlueprint extends SparePartsBlueprint {
    @NotNull
    public final SparePartsPresenter b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SparePartsCompatibilitiesBlueprint(@SparePartsModule.CompatibilitiesPresenter @NotNull SparePartsPresenter sparePartsPresenter) {
        super(null);
        Intrinsics.checkNotNullParameter(sparePartsPresenter, "presenter");
        this.b = sparePartsPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof SparePartsItem) && ((SparePartsItem) item).getType() == SparePartsItemType.COMPATIBILITIES;
    }

    /* Return type fixed from 'com.avito.android.advert.item.spare_parts.SparePartsPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SparePartsView, SparePartsItem> getPresenter() {
        return this.b;
    }
}
