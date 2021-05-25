package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.ui.adapter.tab.TabItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabView;", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "", "hasRedBadge", "", "bind", "(Lcom/avito/android/remote/model/text/AttributedText;Z)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface PeriodTabView extends TabItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setSelected(@NotNull PeriodTabView periodTabView, int i, int i2, boolean z) {
            TabItemView.DefaultImpls.setSelected(periodTabView, i, i2, z);
        }

        public static void setSelected(@NotNull PeriodTabView periodTabView, boolean z) {
            TabItemView.DefaultImpls.setSelected(periodTabView, z);
        }
    }

    void bind(@Nullable AttributedText attributedText, boolean z);
}
