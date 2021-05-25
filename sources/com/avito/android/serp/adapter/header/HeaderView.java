package com.avito.android.serp.adapter.header;

import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/adapter/header/HeaderView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "descriptions", "", "setData", "(Ljava/lang/String;Ljava/util/List;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface HeaderView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HeaderView headerView) {
            ItemView.DefaultImpls.onUnbind(headerView);
        }
    }

    void setData(@Nullable String str, @Nullable List<String> list);
}
