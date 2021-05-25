package com.avito.android.brandspace.items.text;

import com.avito.konveyor.blueprint.ItemView;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/brandspace/items/text/TextItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "value", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "bottomMarginRes", "", "setText", "(Ljava/lang/CharSequence;Lcom/avito/android/brandspace/items/text/TextItemViewStyle;I)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface TextItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TextItemView textItemView) {
            ItemView.DefaultImpls.onUnbind(textItemView);
        }
    }

    void setText(@Nullable CharSequence charSequence, @NotNull TextItemViewStyle textItemViewStyle, int i);
}
