package com.avito.android.developments_catalog.items.avitoOffers;

import a2.a.a.n0.d.a.b;
import android.view.View;
import android.widget.TextView;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.remote.model.AvitoOffer;
import com.avito.android.developments_catalog.remote.model.AvitoOffers;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersView;", "Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;", "avitoOffers", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOfferListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bindAvitoOffers", "(Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOfferListener;)V", "La2/a/a/n0/d/a/b;", "t", "La2/a/a/n0/d/a/b;", "reusableAvitoOffersView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoOffersViewImpl extends BaseViewHolder implements AvitoOffersView {
    public final TextView s;
    public final b t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvitoOffersViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.avito_offers_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.avito_offers_title)");
        this.s = (TextView) findViewById;
        this.t = new b(view);
    }

    @Override // com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersView
    public void bindAvitoOffers(@NotNull AvitoOffers avitoOffers, @NotNull AvitoOfferListener avitoOfferListener) {
        Intrinsics.checkNotNullParameter(avitoOffers, "avitoOffers");
        Intrinsics.checkNotNullParameter(avitoOfferListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        TextViews.bindText$default(this.s, avitoOffers.getTitle(), false, 2, null);
        b bVar = this.t;
        List<AvitoOffer> mainOffers = avitoOffers.getMainOffers();
        if (mainOffers == null) {
            mainOffers = CollectionsKt__CollectionsKt.emptyList();
        }
        Objects.requireNonNull(bVar);
        Intrinsics.checkNotNullParameter(mainOffers, "data");
        Intrinsics.checkNotNullParameter(avitoOfferListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        bVar.b = avitoOfferListener;
        bVar.d = mainOffers.size() - 1;
        bVar.reuseChildrenView(bVar.a, mainOffers);
    }
}
