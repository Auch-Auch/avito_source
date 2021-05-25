package com.avito.android.auto_catalog.items.serp;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface SerpSecondaryButtonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SerpSecondaryButtonView serpSecondaryButtonView) {
            ItemView.DefaultImpls.onUnbind(serpSecondaryButtonView);
        }
    }

    void setButton(@NotNull String str, @NotNull Function0<Unit> function0);
}
