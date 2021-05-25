package a2.a.a.n0.d.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOfferListener;
import com.avito.android.developments_catalog.remote.model.AvitoOffer;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends ReuseChildrenHelper<AvitoOffer, View> {
    public final ViewGroup a;
    public AvitoOfferListener b;
    public final LayoutInflater c;
    public int d;

    public b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.avito_offers_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.avito_offers_container)");
        this.a = (ViewGroup) findViewById;
        this.c = LayoutInflater.from(view.getContext());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public void bindData(View view, AvitoOffer avitoOffer, int i) {
        AvitoOffer avitoOffer2 = avitoOffer;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(avitoOffer2, "data");
        View findViewById = view.findViewById(R.id.avito_offer_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.avito_offer_title)");
        View findViewById2 = view.findViewById(R.id.avito_offer_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.avito_offer_subtitle)");
        View findViewById3 = view.findViewById(R.id.avito_offer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.avito_offer_container)");
        View findViewById4 = view.findViewById(R.id.avito_offer_bottom_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.avito_offer_bottom_divider)");
        TextViews.bindText$default((TextView) findViewById, avitoOffer2.getTitle(), false, 2, null);
        TextViews.bindText$default((TextView) findViewById2, avitoOffer2.getSubtitle(), false, 2, null);
        findViewById3.setOnClickListener(new a(this, avitoOffer2));
        if (this.d == i) {
            Views.hide(findViewById4);
        } else {
            Views.show(findViewById4);
        }
    }

    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    @NotNull
    public View createChild() {
        View inflate = this.c.inflate(R.layout.avito_offer, this.a, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.View");
        return inflate;
    }
}
