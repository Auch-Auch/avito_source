package com.avito.android.payment;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.payments.method.list.CheckablePaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/PaymentMethodsContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentMethodsContentsComparator implements ContentsComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Long l = null;
        if (!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) {
            return false;
        }
        if (!(item instanceof CheckablePaymentMethodItem) || !(item2 instanceof CheckablePaymentMethodItem)) {
            Long valueOf = item != null ? Long.valueOf(item.getId()) : null;
            if (item2 != null) {
                l = Long.valueOf(item2.getId());
            }
            return Intrinsics.areEqual(valueOf, l);
        } else if (item.getId() == item2.getId() && ((CheckablePaymentMethodItem) item).isChecked() == ((CheckablePaymentMethodItem) item2).isChecked()) {
            return true;
        } else {
            return false;
        }
    }
}
