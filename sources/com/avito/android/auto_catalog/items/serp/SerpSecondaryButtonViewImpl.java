package com.avito.android.auto_catalog.items.serp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.auto_catalog.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/auto_catalog/items/serp/SerpSecondaryButtonView;", "", "title", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "buttonContainer", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "buttonView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SerpSecondaryButtonViewImpl extends BaseViewHolder implements SerpSecondaryButtonView {
    public final TextView s;
    public final ViewGroup t;

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
    public SerpSecondaryButtonViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.serp_secondary_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.serp_secondary_button)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.auto_catalog_serp_secondary_button_root);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a…rp_secondary_button_root)");
        this.t = (ViewGroup) findViewById2;
    }

    @Override // com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonView
    public void setButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        TextViews.bindText$default(this.s, str, false, 2, null);
        this.t.setOnClickListener(new a(function0));
    }
}
