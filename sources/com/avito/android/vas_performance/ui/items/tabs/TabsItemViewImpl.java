package com.avito.android.vas_performance.ui.items.tabs;

import android.view.View;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemViewImpl;", "Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/vas_performance/ui/items/tabs/Tab;", "tabs", "", "setTabs", "(Ljava/util/List;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/lib/design/chips/Chips;", "s", "Lcom/avito/android/lib/design/chips/Chips;", "chips", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class TabsItemViewImpl extends BaseViewHolder implements TabsItemView {
    public final Chips s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (Chips) view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TabsItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.vas_performance.ui.items.tabs.TabsItemView
    public void setTabSelectedListener(@NotNull Function1<? super Tab, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setChipsSelectedListener(new Chips.ChipSelectedListener(function1) { // from class: com.avito.android.vas_performance.ui.items.tabs.TabsItemViewImpl$setTabSelectedListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                Tab tab = (Tab) chipable;
                tab.setSelected(true);
                this.a.invoke(tab);
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipUnSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                ((Tab) chipable).setSelected(false);
            }
        });
    }

    @Override // com.avito.android.vas_performance.ui.items.tabs.TabsItemView
    public void setTabs(@NotNull List<Tab> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.s.setData(list);
        this.s.setDisplayType(Chips.DisplayType.SINGLE_LINE_FIXED);
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getSelected()) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            this.s.select((Chipable) t2);
        }
    }
}
