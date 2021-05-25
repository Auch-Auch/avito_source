package com.avito.android.delivery.summary.konveyor.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.summary.konveyor.header.HeaderItemView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/header/HeaderItemViewImpl;", "Lcom/avito/android/delivery/summary/konveyor/header/HeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", ProductAction.ACTION_ADD, "addTopMargin", "(Z)V", "visible", "setVisibilityChangeButton", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnChangeClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "container", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "Lcom/avito/android/lib/design/button/Button;", "u", "Lcom/avito/android/lib/design/button/Button;", "changeButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewImpl extends BaseViewHolder implements HeaderItemView {
    public final TextView s;
    public final ViewGroup t;
    public final Button u;
    public Function0<Unit> v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HeaderItemViewImpl a;

        public a(HeaderItemViewImpl headerItemViewImpl) {
            this.a = headerItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.v;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.text_view)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.t = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.change_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.change_button)");
        Button button = (Button) findViewById3;
        this.u = button;
        button.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.delivery.summary.konveyor.header.HeaderItemView
    public void addTopMargin(boolean z) {
        ViewGroup viewGroup = this.t;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = z ? viewGroup.getResources().getDimensionPixelOffset(R.dimen.delivery_summary_header_top_margin) : 0;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        HeaderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.summary.konveyor.header.HeaderItemView
    public void setOnChangeClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = function0;
    }

    @Override // com.avito.android.delivery.summary.konveyor.header.HeaderItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }

    @Override // com.avito.android.delivery.summary.konveyor.header.HeaderItemView
    public void setVisibilityChangeButton(boolean z) {
        Views.setVisible(this.u, z);
    }
}
