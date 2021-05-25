package com.avito.android.str_calendar.seller.edit.konveyor.radiogroup;

import com.avito.android.items.SelectableItem;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\u0006JA\u0010\u0014\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "subTitle", "setSubTitle", "hint", "setHint", "error", "setError", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface RadioGroupSelectItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RadioGroupSelectItemView radioGroupSelectItemView) {
            ItemView.DefaultImpls.onUnbind(radioGroupSelectItemView);
        }
    }

    void setError(@Nullable String str);

    void setHint(@Nullable String str);

    void setSubTitle(@Nullable String str);

    void setTitle(@Nullable String str);

    void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2);
}
