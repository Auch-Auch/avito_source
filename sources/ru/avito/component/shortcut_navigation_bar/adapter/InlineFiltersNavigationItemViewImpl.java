package ru.avito.component.shortcut_navigation_bar.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.ui_components.R;
import com.avito.android.util.ViewSizeKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation.ShortcutNavigationButton;
import ru.avito.component.shortcut_navigation.ShortcutNavigationButtonImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u001e\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/InlineFiltersNavigationItemViewImpl;", "Lru/avito/component/shortcut_navigation_bar/adapter/InlineFiltersNavigationItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/shortcut_navigation/ShortcutNavigationButton;", "", "text", "", "setText", "(Ljava/lang/String;)V", "", "resId", "setBackgroundResId", "(I)V", "", "set", "setDrawableEndArrow", "(Z)V", "showTooltip", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersNavigationItemViewImpl extends BaseViewHolder implements InlineFiltersNavigationItemView, ShortcutNavigationButton {
    public final TextView s;
    public final /* synthetic */ ShortcutNavigationButtonImpl t;

    public static final class a extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setBody(this.a);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineFiltersNavigationItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new ShortcutNavigationButtonImpl(view);
        View findViewById = view.findViewById(R.id.inline_filters_navigation_button_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InlineFiltersNavigationItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemView
    public void setBackgroundResId(int i) {
        int paddingLeft = this.s.getPaddingLeft();
        int paddingRight = this.s.getPaddingRight();
        int paddingTop = this.s.getPaddingTop();
        int paddingBottom = this.s.getPaddingBottom();
        this.s.setBackgroundResource(i);
        this.s.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setClickListener(function0);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemView
    public void setDrawableEndArrow(boolean z) {
        int i = R.drawable.ic_expand_14_blue;
        if (!z) {
            i = 0;
        }
        this.s.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i, 0);
        if (!z) {
            int paddingLeft = this.s.getPaddingLeft();
            Context context = this.s.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.inline_filter_horizontal_padding);
            this.s.setPadding(paddingLeft, this.s.getPaddingTop(), dimensionPixelSize, this.s.getPaddingBottom());
        }
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemView
    public void showTooltip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Context context = this.s.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        TooltipContentKt.content(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.Start(new AnchorPositions.Center())).setAnchorOffset(ViewSizeKt.getDp(-8))), new a(str)).show(this.s);
    }
}
