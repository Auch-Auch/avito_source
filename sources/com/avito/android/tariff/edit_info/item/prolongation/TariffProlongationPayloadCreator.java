package com.avito.android.tariff.edit_info.item.prolongation;

import android.os.Bundle;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationPayloadCreator;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/konveyor/blueprint/Item;", "oldItem", "newItem", "", "getChangePayload", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Ljava/lang/Object;", "<init>", "()V", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffProlongationPayloadCreator implements ChangePayloadCreator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PAYLOAD = "payload";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationPayloadCreator$Companion;", "", "", "PAYLOAD", "Ljava/lang/String;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
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
        if ((item2 instanceof TariffProlongationItem) && (item instanceof TariffProlongationItem)) {
            TariffProlongationItem tariffProlongationItem = (TariffProlongationItem) item2;
            TariffProlongationItem tariffProlongationItem2 = (TariffProlongationItem) item;
            bundle.putParcelable("payload", new TariffProlongationPayload(tariffProlongationItem.isSwitchEnabled() != tariffProlongationItem2.isSwitchEnabled() ? Boolean.valueOf(tariffProlongationItem.isSwitchEnabled()) : null, tariffProlongationItem.isSwitchOn() != tariffProlongationItem2.isSwitchOn() ? Boolean.valueOf(tariffProlongationItem.isSwitchOn()) : null));
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }
}
