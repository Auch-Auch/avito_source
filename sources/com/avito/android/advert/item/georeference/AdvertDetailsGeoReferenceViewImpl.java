package com.avito.android.advert.item.georeference;

import android.view.View;
import android.widget.LinearLayout;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.advert_core.georeference.GeoReferenceViewBinderImpl;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.Coordinates;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceView;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "item", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bindContent", "(Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;)V", "Landroid/widget/LinearLayout;", "s", "Landroid/widget/LinearLayout;", "container", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinderImpl;", "t", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinderImpl;", "geoReferenceViewBinder", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReferenceViewImpl extends BaseViewHolder implements AdvertDetailsGeoReferenceView {
    public LinearLayout s;
    public final GeoReferenceViewBinderImpl t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Coordinates a;
        public final /* synthetic */ AdvertDetailsGeoReferencePresenter.OpenMapListener b;
        public final /* synthetic */ AdvertDetailsGeoReferenceItem c;

        public a(Coordinates coordinates, AdvertDetailsGeoReferenceViewImpl advertDetailsGeoReferenceViewImpl, AdvertDetailsGeoReferencePresenter.OpenMapListener openMapListener, AdvertDetailsGeoReferenceItem advertDetailsGeoReferenceItem) {
            this.a = coordinates;
            this.b = openMapListener;
            this.c = advertDetailsGeoReferenceItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.onOpenMap(this.c.getAddress(), this.a, this.c.getAdvertTitle());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsGeoReferenceViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.s = linearLayout;
        this.t = new GeoReferenceViewBinderImpl(linearLayout);
    }

    @Override // com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceView
    public void bindContent(@NotNull AdvertDetailsGeoReferenceItem advertDetailsGeoReferenceItem, @NotNull AdvertDetailsGeoReferencePresenter.OpenMapListener openMapListener) {
        Intrinsics.checkNotNullParameter(advertDetailsGeoReferenceItem, "item");
        Intrinsics.checkNotNullParameter(openMapListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.removeAllViews();
        GeoReferenceViewBinderImpl geoReferenceViewBinderImpl = this.t;
        List<String> colors = advertDetailsGeoReferenceItem.getColors();
        if (colors == null) {
            colors = CollectionsKt__CollectionsKt.emptyList();
        }
        geoReferenceViewBinderImpl.bindData(colors, advertDetailsGeoReferenceItem.getContent(), advertDetailsGeoReferenceItem.getAfter());
        Coordinates coordinates = advertDetailsGeoReferenceItem.getCoordinates();
        if (coordinates != null) {
            this.s.setOnClickListener(new a(coordinates, this, openMapListener, advertDetailsGeoReferenceItem));
        }
    }
}
