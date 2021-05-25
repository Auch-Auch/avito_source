package com.avito.android.user_adverts.items_search.advert_list.suggests;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", "func", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SuggestItemView suggestItemView) {
            ItemView.DefaultImpls.onUnbind(suggestItemView);
        }
    }

    void setClickListener(@NotNull Function0<Unit> function0);

    void setTitle(@NotNull String str);
}
