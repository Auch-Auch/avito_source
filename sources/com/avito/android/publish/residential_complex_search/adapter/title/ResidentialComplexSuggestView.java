package com.avito.android.publish.residential_complex_search.adapter.title;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "name", "", "bindName", "(Ljava/lang/String;)V", "description", "bindDescription", "Lkotlin/Function0;", "action", "setClickAction", "(Lkotlin/jvm/functions/Function0;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ResidentialComplexSuggestView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ResidentialComplexSuggestView residentialComplexSuggestView) {
            ItemView.DefaultImpls.onUnbind(residentialComplexSuggestView);
        }
    }

    void bindDescription(@NotNull String str);

    void bindName(@NotNull String str);

    void setClickAction(@NotNull Function0<Unit> function0);
}
