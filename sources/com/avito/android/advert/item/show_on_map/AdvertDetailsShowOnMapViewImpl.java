package com.avito.android.advert.item.show_on_map;

import android.view.View;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "item", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addClickListener", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShowOnMapViewImpl extends BaseViewHolder implements AdvertDetailsShowOnMapView {
    @NotNull
    public final View s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsShowOnMapView.Listener a;
        public final /* synthetic */ AdvertDetailsShowOnMapItem b;

        public a(AdvertDetailsShowOnMapView.Listener listener, AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem) {
            this.a = listener;
            this.b = advertDetailsShowOnMapItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onShowOnMapClick(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsShowOnMapViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view;
    }

    @Override // com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapView
    public void addClickListener(@NotNull AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem, @NotNull AdvertDetailsShowOnMapView.Listener listener) {
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapItem, "item");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(listener, advertDetailsShowOnMapItem));
    }

    @NotNull
    public final View getView() {
        return this.s;
    }
}
