package com.avito.android.short_term_rent.start_booking.items.guest_count;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "count", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionClickListener", "(Lkotlin/jvm/functions/Function1;)V", "guestsCount", "setSelectedItem", "(I)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface GuestsCountItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull GuestsCountItemView guestsCountItemView) {
            ItemView.DefaultImpls.onUnbind(guestsCountItemView);
        }
    }

    void setActionClickListener(@NotNull Function1<? super Integer, Unit> function1);

    void setSelectedItem(int i);
}
