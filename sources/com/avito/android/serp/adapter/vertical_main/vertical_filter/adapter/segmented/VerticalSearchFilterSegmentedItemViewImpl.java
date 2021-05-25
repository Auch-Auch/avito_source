package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import android.view.View;
import com.avito.android.lib.design.segmented_control.SegmentedControl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J%\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u0011\u001a\u00020\t2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemViewImpl;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemView;", "", "", "texts", "", "selectedPosition", "", "setTexts", "(Ljava/util/List;I)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "currentSelected", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "", "enabled", "setIsEnabled", "(Z)V", "value", "t", "(Ljava/util/List;Ljava/util/List;)Z", "u", "I", "cachedPosition", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "s", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "segmentedControl", "Ljava/util/List;", "cachedText", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalSearchFilterSegmentedItemViewImpl extends BaseViewHolder implements ItemView, VerticalSearchFilterSegmentedItemView {
    public final SegmentedControl s;
    public List<String> t = CollectionsKt__CollectionsKt.emptyList();
    public int u;

    public static final class a extends Lambda implements Function2<Integer, String, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Integer num, String str) {
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(str, "text");
            this.a.invoke(Integer.valueOf(intValue));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalSearchFilterSegmentedItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SegmentedControl) view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemView
    public void setIsEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemView
    public void setOnClickListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnSegmentClickListener(new a(function1));
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemView
    public void setTexts(@NotNull List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "texts");
        if (!t(this.t, list) || this.u != i) {
            if (!t(this.t, list) || this.u == i) {
                this.s.setSegments(list, i);
            } else {
                SegmentedControl.setSelectedPosition$default(this.s, i, false, 2, null);
            }
            this.t = list;
            this.u = i;
        }
    }

    public final boolean t(List<String> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        for (T t2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual(t2, list2.get(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }
}
