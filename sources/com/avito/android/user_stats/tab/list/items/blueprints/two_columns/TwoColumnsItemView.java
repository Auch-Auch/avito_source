package com.avito.android.user_stats.tab.list.items.blueprints.two_columns;

import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "setLeftText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "setRightText", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface TwoColumnsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TwoColumnsItemView twoColumnsItemView) {
            ItemView.DefaultImpls.onUnbind(twoColumnsItemView);
        }
    }

    void setLeftText(@Nullable AttributedText attributedText);

    void setRightText(@Nullable AttributedText attributedText);
}
