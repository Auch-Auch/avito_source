package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "tabs", "", "bindTabs", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "setSelectedTab", "(I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "unbindListener", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TabsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TabsItemView tabsItemView) {
            ItemView.DefaultImpls.onUnbind(tabsItemView);
        }
    }

    void bindTabs(@NotNull List<PeriodTab> list);

    void setOnTabSelectedListener(@NotNull Function1<? super Integer, Unit> function1);

    void setSelectedTab(int i);

    void unbindListener();
}
