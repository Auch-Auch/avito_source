package com.avito.android.serp.adapter;

import android.view.View;
import android.widget.TextView;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.serp.adapter.SellerPinItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/serp/adapter/SellerPinItemViewImpl;", "Lcom/avito/android/serp/adapter/SellerPinItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setDescription", "Landroid/view/View;", "s", "Landroid/view/View;", "container", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "title", "u", "description", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SellerPinItemViewImpl extends BaseSerpViewHolder implements SellerPinItemView {
    public final View s;
    public final TextView t;
    public final TextView u;

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
    public SellerPinItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SellerPinItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.SellerPinItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.serp.adapter.SellerPinItemView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.SellerPinItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }
}
