package com.avito.android.component.search.list;

import com.avito.android.component.search.SuggestItemListener;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/component/search/list/BubblesItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "paddingTop", "paddingBottom", "", "setPadding", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem;", "words", "Lcom/avito/android/component/search/SuggestItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBubbles", "(Ljava/util/List;Lcom/avito/android/component/search/SuggestItemListener;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface BubblesItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BubblesItemView bubblesItemView) {
            ItemView.DefaultImpls.onUnbind(bubblesItemView);
        }
    }

    void setBubbles(@NotNull List<SuggestBubbleItem> list, @NotNull SuggestItemListener suggestItemListener);

    void setPadding(@Nullable Integer num, @Nullable Integer num2);
}
