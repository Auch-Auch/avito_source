package com.avito.android.bundles.vas_union.item.performance.tabs;

import android.view.View;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemView;
import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.android.lib.design.segmented_control.SegmentedControl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J%\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\n\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u000f¨\u0006%"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemViewImpl;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;", "", "Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", "tabs", "", "selectedPosition", "", "setTabs", "(Ljava/util/List;I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "segmentPosition", "", "segmentText", "onSegmentClick", "(ILjava/lang/String;)V", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "(Ljava/util/List;)V", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "s", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "switcher", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceTabsItemViewImpl extends BaseViewHolder implements PerformanceTabsItemView, SegmentedControl.OnSegmentClickListener {
    public Function1<? super Tab, Unit> listener;
    public final SegmentedControl s;
    public List<Tab> tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerformanceTabsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        SegmentedControl segmentedControl = (SegmentedControl) view;
        this.s = segmentedControl;
        segmentedControl.setOnSegmentClickListener(this);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.bundles.vas_union.item.tabs.Tab, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.bundles.vas_union.item.tabs.Tab, kotlin.Unit> */
    @NotNull
    public final Function1<Tab, Unit> getListener() {
        Function1 function1 = this.listener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        return function1;
    }

    @NotNull
    public final List<Tab> getTabs() {
        List<Tab> list = this.tabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
        }
        return list;
    }

    @Override // com.avito.android.lib.design.segmented_control.SegmentedControl.OnSegmentClickListener
    public void onSegmentClick(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "segmentText");
        SegmentedControl.setSelectedPosition$default(this.s, i, false, 2, null);
        Function1<? super Tab, Unit> function1 = this.listener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        List<Tab> list = this.tabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
        }
        function1.invoke(list.get(i));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PerformanceTabsItemView.DefaultImpls.onUnbind(this);
    }

    public final void setListener(@NotNull Function1<? super Tab, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.listener = function1;
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemView
    public void setTabSelectedListener(@NotNull Function1<? super Tab, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = function1;
    }

    public final void setTabs(@NotNull List<Tab> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tabs = list;
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemView
    public void setTabs(@NotNull List<Tab> list, int i) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.tabs = list;
        SegmentedControl segmentedControl = this.s;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTitle());
        }
        segmentedControl.setSegments(arrayList, i);
    }
}
