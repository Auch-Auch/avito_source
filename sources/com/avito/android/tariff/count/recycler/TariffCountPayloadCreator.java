package com.avito.android.tariff.count.recycler;

import android.os.Bundle;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.tariff.count.item.CountItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/count/recycler/TariffCountPayloadCreator;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/konveyor/blueprint/Item;", "oldItem", "newItem", "", "getChangePayload", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Ljava/lang/Object;", "<init>", "()V", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountPayloadCreator implements ChangePayloadCreator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PAYLOAD_BONUS = "bonus";
    @NotNull
    public static final String PAYLOAD_CHECKED = "checked";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/count/recycler/TariffCountPayloadCreator$Companion;", "", "", "PAYLOAD_BONUS", "Ljava/lang/String;", "PAYLOAD_CHECKED", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.recycler.data_aware.ChangePayloadCreator
    @Nullable
    public Object getChangePayload(@Nullable Item item, @Nullable Item item2) {
        Bundle bundle = new Bundle();
        if ((item2 instanceof CountItem) && (item instanceof CountItem)) {
            CountItem countItem = (CountItem) item2;
            CountItem countItem2 = (CountItem) item;
            if (countItem.isChecked() != countItem2.isChecked()) {
                bundle.putBoolean("checked", countItem.isChecked());
            }
            if (countItem.getHasBonus() != countItem2.getHasBonus()) {
                bundle.putBoolean(PAYLOAD_BONUS, countItem.getHasBonus());
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }
}
