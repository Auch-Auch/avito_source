package com.avito.android.advert_core.discount.item.discount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.model.UniversalColorKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/advert_core/discount/item/discount/DiscountItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/discount/item/discount/DiscountItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "colorName", "", "isBold", "setValue", "(Ljava/lang/String;Ljava/lang/String;Z)V", "description", "showDescription", "hideDescription", "()V", "onUnbind", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "container", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "valueView", "t", "titleView", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "descriptionView", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "w", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "descriptionTooltip", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "view", "<init>", "(Landroid/view/View;)V", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountItemViewImpl extends BaseViewHolder implements DiscountItemView {
    public static final int BOLD_VALUE_TOP_MARGIN_DP = 12;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int REGULAR_VALUE_TOP_MARGIN_DP = 16;
    public final ViewGroup s;
    public final TextView t;
    public final TextView u;
    public final View v;
    public Tooltip w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/discount/item/discount/DiscountItemViewImpl$Companion;", "", "", "BOLD_VALUE_TOP_MARGIN_DP", "I", "REGULAR_VALUE_TOP_MARGIN_DP", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DiscountItemViewImpl a;
        public final /* synthetic */ String b;

        /* renamed from: com.avito.android.advert_core.discount.item.discount.DiscountItemViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0131a extends Lambda implements Function1<TooltipContent, Unit> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0131a(a aVar) {
                super(1);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(TooltipContent tooltipContent) {
                TooltipContent tooltipContent2 = tooltipContent;
                Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
                tooltipContent2.setBody(this.a.b);
                return Unit.INSTANCE;
            }
        }

        public a(DiscountItemViewImpl discountItemViewImpl, String str) {
            this.a = discountItemViewImpl;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.w = TooltipContentKt.content(new Tooltip(this.a.getContext(), 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Top(new TailPositions.End(new AnchorPositions.Center()))), new C0131a(this)).show(this.a.v);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscountItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.discount_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.discount_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.s = viewGroup;
        View findViewById2 = viewGroup.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R.id.value)");
        this.u = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.description)");
        this.v = findViewById4;
    }

    public final Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }

    @Override // com.avito.android.advert_core.discount.item.discount.DiscountItemView
    public void hideDescription() {
        this.s.setOnClickListener(null);
        Views.hide(this.v);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        super.onUnbind();
        Tooltip tooltip = this.w;
        if (tooltip != null) {
            tooltip.dismiss();
        }
        this.w = null;
    }

    @Override // com.avito.android.advert_core.discount.item.discount.DiscountItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }

    @Override // com.avito.android.advert_core.discount.item.discount.DiscountItemView
    public void setValue(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "value");
        if (z) {
            TextViewCompat.setTextAppearance(this.u, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Heading_Large);
            Views.changeMargin$default(this.s, 0, Views.dpToPx(getContext(), 12), 0, 0, 13, null);
        } else {
            TextViewCompat.setTextAppearance(this.u, com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Body);
            Views.changeMargin$default(this.s, 0, Views.dpToPx(getContext(), 16), 0, 0, 13, null);
        }
        this.u.setTextColor(ContextsKt.getColorFrom(getContext(), UniversalColorKt.universalColorOf(str2, Contexts.getColorByAttr(getContext(), com.avito.android.lib.design.R.attr.black))));
        this.u.setText(str);
    }

    @Override // com.avito.android.advert_core.discount.item.discount.DiscountItemView
    public void showDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.s.setOnClickListener(new a(this, str));
        Views.show(this.v);
    }
}
