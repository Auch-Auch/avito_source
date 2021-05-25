package com.avito.android.stories.adapter;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.stories.StoriesList;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/stories/adapter/StoriesItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lru/avito/component/stories/StoriesList;", "Lkotlin/Function0;", "", "getUnbindListener", "()Lkotlin/jvm/functions/Function0;", "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "unbindListener", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface StoriesItemView extends ItemView, StoriesList {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull StoriesItemView storiesItemView) {
            ItemView.DefaultImpls.onUnbind(storiesItemView);
        }
    }

    @Nullable
    Function0<Unit> getUnbindListener();

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
