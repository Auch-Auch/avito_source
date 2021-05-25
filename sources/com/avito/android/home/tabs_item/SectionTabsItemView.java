package com.avito.android.home.tabs_item;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/home/tabs_item/TabItem;", "items", "", "setItems", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "", "invokeListener", "setSelectedPosition", "(IZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedItemListener", "(Lkotlin/jvm/functions/Function1;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SectionTabsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SectionTabsItemView sectionTabsItemView) {
            ItemView.DefaultImpls.onUnbind(sectionTabsItemView);
        }

        public static /* synthetic */ void setSelectedPosition$default(SectionTabsItemView sectionTabsItemView, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = true;
                }
                sectionTabsItemView.setSelectedPosition(i, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSelectedPosition");
        }
    }

    void setItems(@NotNull List<? extends TabItem> list);

    void setSelectedItemListener(@NotNull Function1<? super Integer, Unit> function1);

    void setSelectedPosition(int i, boolean z);
}
