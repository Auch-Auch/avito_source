package com.avito.android.payment.top_up.form.items;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonItem;
import ru.avito.component.info_label.InfoLabelItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/TopUpFormItemsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", AuthSource.SEND_ABUSE, "Z", "otherwiseDoNotRebind", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormItemsComparator implements ContentsComparator {
    public final boolean a = true;

    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Boolean bool = null;
        boolean z = true;
        Boolean bool2 = Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null) ^ true ? Boolean.FALSE : null;
        if (bool2 == null) {
            bool2 = (!(item instanceof InfoLabelItem) || !(item2 instanceof InfoLabelItem)) ? null : Boolean.FALSE;
        }
        if (bool2 == null) {
            bool2 = (!(item instanceof TopUpInputItem) || !(item2 instanceof TopUpInputItem)) ? null : Boolean.valueOf(!((TopUpInputItem) item2).getHasUpdate());
        }
        if (bool2 == null) {
            if ((item instanceof ButtonItem) && (item2 instanceof ButtonItem)) {
                if (((ButtonItem) item).isEnabled() != ((ButtonItem) item2).isEnabled()) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
            bool2 = bool;
        }
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return this.a;
    }
}
