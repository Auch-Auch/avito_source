package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services;

import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServiceRadioButtonItem;", "radioButtons", "Lkotlin/Function1;", "", "onCheckedChangeListener", "setRadioButtons", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "hint", "setHint", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface RadioGroupItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RadioGroupItemView radioGroupItemView) {
            ItemView.DefaultImpls.onUnbind(radioGroupItemView);
        }
    }

    void setHint(@Nullable String str);

    void setRadioButtons(@NotNull List<CourierServiceRadioButtonItem> list, @NotNull Function1<? super CourierServiceRadioButtonItem, Unit> function1);

    void setSubtitle(@Nullable String str);

    void setTitle(@Nullable String str);
}
