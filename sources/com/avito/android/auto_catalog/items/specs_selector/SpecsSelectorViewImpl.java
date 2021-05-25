package com.avito.android.auto_catalog.items.specs_selector;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.specifications.SpecificationData;
import com.avito.android.advert_core.specifications.SpecificationView;
import com.avito.android.auto_catalog.R;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorView;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 JC\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016¨\u0006!"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView;", "", "titleSelected", "Lkotlin/Pair;", "", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsData;", "specsData", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setSpecs", "(Ljava/lang/String;Lkotlin/Pair;Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "selectedView", "Landroid/view/View;", "u", "Landroid/view/View;", "selectedContainer", "Lcom/avito/android/advert_core/specifications/SpecificationView;", VKApiConst.VERSION, "Lcom/avito/android/advert_core/specifications/SpecificationView;", "specsView", "s", "arrowView", "view", "<init>", "(Landroid/view/View;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SpecsSelectorViewImpl extends BaseViewHolder implements SpecsSelectorView {
    public final View s;
    public final TextView t;
    public final View u;
    public final SpecificationView v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SpecsSelectorView.Listener a;

        public a(SpecsSelectorView.Listener listener) {
            this.a = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onSpecsClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecsSelectorViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.specs_selector_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.specs_selector_arrow)");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.specs_selector_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.specs_selector_text)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.specs_selector_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.specs_selector_container)");
        this.u = findViewById3;
        View findViewById4 = view.findViewById(R.id.specs_selector_specifications);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.s…_selector_specifications)");
        this.v = (SpecificationView) findViewById4;
    }

    @Override // com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorView
    public void setSpecs(@NotNull String str, @Nullable Pair<Integer, ? extends List<? extends SpecificationData>> pair, @Nullable SpecsSelectorView.Listener listener) {
        Intrinsics.checkNotNullParameter(str, "titleSelected");
        TextViews.bindText$default(this.t, str, false, 2, null);
        if (listener != null) {
            this.u.setOnClickListener(new a(listener));
            Views.show(this.s);
        } else {
            this.u.setOnClickListener(null);
            Views.hide(this.s);
        }
        if (pair != null) {
            this.v.setData(pair.getFirst().intValue(), (List) pair.getSecond());
        }
    }
}
