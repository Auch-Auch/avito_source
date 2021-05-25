package com.avito.android.publish.residential_complex_search.adapter.button;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", "action", "setClickAction", "(Lkotlin/jvm/functions/Function0;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ResidentialComplexButtonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ResidentialComplexButtonView residentialComplexButtonView) {
            ItemView.DefaultImpls.onUnbind(residentialComplexButtonView);
        }
    }

    void setClickAction(@NotNull Function0<Unit> function0);
}
