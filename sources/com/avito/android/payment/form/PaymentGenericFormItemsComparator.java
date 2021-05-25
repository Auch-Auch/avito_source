package com.avito.android.payment.form;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.info_label.InfoLabelItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormItemsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", AuthSource.SEND_ABUSE, "Z", "otherwiseDoNotRebind", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormItemsComparator implements ContentsComparator {
    public final boolean a = true;

    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Boolean bool;
        Boolean bool2 = null;
        if (!(item instanceof PhoneInputItem) || !(item2 instanceof PhoneInputItem)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(((PhoneInputItem) item).getHasError() == ((PhoneInputItem) item2).getHasError());
        }
        if (bool == null) {
            if ((item instanceof InfoLabelItem) && (item2 instanceof InfoLabelItem)) {
                bool2 = Boolean.FALSE;
            }
            bool = bool2;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return this.a;
    }
}
