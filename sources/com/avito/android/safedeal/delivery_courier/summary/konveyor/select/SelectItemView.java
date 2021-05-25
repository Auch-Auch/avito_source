package com.avito.android.safedeal.delivery_courier.summary.konveyor.select;

import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemView;", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface SelectItemView extends InputItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SelectItemView selectItemView) {
            InputItemView.DefaultImpls.onUnbind(selectItemView);
        }
    }

    void setOnClickListener(@NotNull Function0<Unit> function0);
}
