package com.avito.android.auto_catalog.items.specs_selector;

import com.avito.android.advert_core.specifications.SpecificationData;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJC\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "titleSelected", "Lkotlin/Pair;", "", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsData;", "specsData", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setSpecs", "(Ljava/lang/String;Lkotlin/Pair;Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;)V", "Listener", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface SpecsSelectorView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SpecsSelectorView specsSelectorView) {
            ItemView.DefaultImpls.onUnbind(specsSelectorView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;", "", "", "onSpecsClick", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onSpecsClick();
    }

    void setSpecs(@NotNull String str, @Nullable Pair<Integer, ? extends List<? extends SpecificationData>> pair, @Nullable Listener listener);
}
