package com.avito.android.ui.adapter.tab;

import android.view.View;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/ui/adapter/tab/TabItemView;", "", "", VKApiConst.POSITION, "count", "", "isSelected", "", "setSelected", "(IIZ)V", "(Z)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TabItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setSelected(@NotNull TabItemView tabItemView, int i, int i2, boolean z) {
            tabItemView.setSelected(z);
        }

        public static void setSelected(@NotNull TabItemView tabItemView, boolean z) {
        }
    }

    @NotNull
    View getView();

    void setSelected(int i, int i2, boolean z);

    void setSelected(boolean z);

    void setView(@NotNull View view);
}
