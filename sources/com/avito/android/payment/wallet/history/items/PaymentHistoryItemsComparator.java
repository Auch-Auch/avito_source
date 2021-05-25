package com.avito.android.payment.wallet.history.items;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/wallet/history/items/PaymentHistoryItemsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", AuthSource.SEND_ABUSE, "Z", "otherwiseDoNotRebind", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryItemsComparator implements ContentsComparator {
    public final boolean a = true;

    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Boolean bool = null;
        if (!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) {
            bool = Boolean.FALSE;
        }
        return bool != null ? bool.booleanValue() : this.a;
    }
}
