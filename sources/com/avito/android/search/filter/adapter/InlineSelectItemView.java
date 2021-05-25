package com.avito.android.search.filter.adapter;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u000e\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineSelectItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface InlineSelectItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InlineSelectItemView inlineSelectItemView) {
            ItemView.DefaultImpls.onUnbind(inlineSelectItemView);
        }
    }

    void setTitle(@NotNull String str);

    void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2);
}
