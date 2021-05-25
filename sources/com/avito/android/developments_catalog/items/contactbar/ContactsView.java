package com.avito.android.developments_catalog.items.contactbar;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/developments_catalog/items/contactbar/ContactsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "Lkotlin/Function0;", "", "onClickListener", "bindAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "getButtonsVisibilityPercents", "()Ljava/lang/Integer;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface ContactsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ContactsView contactsView) {
            ItemView.DefaultImpls.onUnbind(contactsView);
        }
    }

    void bindAction(@NotNull String str, @NotNull Function0<Unit> function0);

    @Nullable
    Integer getButtonsVisibilityPercents();
}
