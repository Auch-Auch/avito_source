package com.avito.android.rating.details.adapter.action;

import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/rating/details/adapter/action/ActionItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/clickable_element/ClickableElement;", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ActionItemView extends ItemView, ClickableElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ActionItemView actionItemView) {
            ItemView.DefaultImpls.onUnbind(actionItemView);
        }
    }
}
