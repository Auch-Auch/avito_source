package com.avito.android.messenger.map.search.adapter;

import android.view.View;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "name", "description", "", "setText", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface GeoSearchSuggestItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull GeoSearchSuggestItemView geoSearchSuggestItemView) {
            ItemView.DefaultImpls.onUnbind(geoSearchSuggestItemView);
        }
    }

    void setClickListener(@NotNull View.OnClickListener onClickListener);

    void setText(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2);
}
