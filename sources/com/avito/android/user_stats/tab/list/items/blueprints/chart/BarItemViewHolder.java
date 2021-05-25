package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR*\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u001c8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001aR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setLabel", "(Ljava/lang/String;)V", "", "setBarValue", "(F)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "s", "Landroid/content/res/Resources;", "resources", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "shadow", "", "x", "Z", "isSelected", "()Z", "setSelected", "(Z)V", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "labelView", "Landroid/widget/FrameLayout;", VKApiConst.VERSION, "Landroid/widget/FrameLayout;", "barView", "u", "barContainer", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemViewHolder extends BaseViewHolder implements BarItemView {
    public final Resources s;
    public final ViewGroup t;
    public final ViewGroup u;
    public final FrameLayout v;
    public final TextView w;
    public boolean x;
    public final View y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BarItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        this.s = view.getResources();
        View findViewById = view.findViewById(R.id.shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.shadow)");
        this.t = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.bar_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.bar_container)");
        this.u = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.bar)");
        this.v = (FrameLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.label);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.label)");
        this.w = (TextView) findViewById4;
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public boolean isSelected() {
        return this.x;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BarItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public void setBarValue(float f) {
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        layoutParams2.matchConstraintPercentHeight = f;
        this.v.setLayoutParams(layoutParams2);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public void setColor(@NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        FrameLayout frameLayout = this.v;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        frameLayout.setBackgroundTintList(ContextsKt.createColorStateList(context, universalColor));
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public void setLabel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.w.setText(str);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemView
    public void setSelected(boolean z) {
        this.x = z;
        Integer valueOf = Integer.valueOf(this.s.getDimensionPixelSize(R.dimen.user_stats_bar_shadow_padding));
        valueOf.intValue();
        Integer num = null;
        if (!isSelected()) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : 0;
        Integer valueOf2 = Integer.valueOf(this.s.getDimensionPixelSize(R.dimen.user_stats_bar_item_card_padding));
        valueOf2.intValue();
        if (isSelected()) {
            num = valueOf2;
        }
        int intValue2 = num != null ? num.intValue() : 0;
        Views.changePadding$default(this.u, intValue, 0, intValue, 0, 10, null);
        Views.changePadding$default(this.y, intValue2, 0, intValue2, 0, 10, null);
        Views.setVisible(this.t, isSelected());
        int i = isSelected() ? com.avito.android.lib.design.R.attr.black : com.avito.android.lib.design.R.attr.gray48;
        TextView textView = this.w;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
    }
}
