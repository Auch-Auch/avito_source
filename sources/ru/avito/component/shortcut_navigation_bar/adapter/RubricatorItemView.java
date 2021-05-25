package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;", "category", "", "text", "", "setContent", "(Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface RubricatorItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RubricatorItemView rubricatorItemView) {
            ItemView.DefaultImpls.onUnbind(rubricatorItemView);
        }
    }

    void setClickListener(@NotNull Function0<Unit> function0);

    void setContent(@NotNull RubricatorCategory rubricatorCategory, @NotNull String str);
}
