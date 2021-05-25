package com.avito.android.item_map.view;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.georeference.GeoReferenceViewBinderImpl;
import com.avito.android.item_map.R;
import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import com.avito.android.item_map.amenity.AmenityButtonsViewBinderImpl;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.GeoReference;
import com.facebook.appevents.integrity.IntegrityManager;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004/012B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b-\u0010.J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "(I)I", "", "", "items", "updateData", "(Ljava/util/List;)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "createRouteRelay", "Lio/reactivex/rxjava3/core/Observable;", "f", "Lio/reactivex/rxjava3/core/Observable;", "getCreateRouteClicks", "()Lio/reactivex/rxjava3/core/Observable;", "createRouteClicks", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", g.a, "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "presenter", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "layoutInflater", "", "c", "Ljava/util/List;", "mapItems", "<init>", "(Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "ItemAmenityButtonsHolder", "ItemCreateRouteHolder", "ItemMapAddressHolder", "ItemMapGeoReferenceHolder", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapViewBottomSheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<? extends Object> c = CollectionsKt__CollectionsKt.emptyList();
    public LayoutInflater d;
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    public final AmenityButtonsPresenter g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter$ItemAmenityButtonsHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/item_map/view/AmenityButtonsItem;", "item", "", "bind", "(Lcom/avito/android/item_map/view/AmenityButtonsItem;)V", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "u", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "presenter", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinderImpl;", "s", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinderImpl;", "binder", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemAmenityButtonsHolder extends RecyclerView.ViewHolder {
        public final AmenityButtonsViewBinderImpl s;
        @NotNull
        public final View t;
        public final AmenityButtonsPresenter u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemAmenityButtonsHolder(@NotNull View view, @NotNull AmenityButtonsPresenter amenityButtonsPresenter) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(amenityButtonsPresenter, "presenter");
            this.t = view;
            this.u = amenityButtonsPresenter;
            View findViewById = view.findViewById(R.id.amenity_buttons_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.amenity_buttons_container)");
            this.s = new AmenityButtonsViewBinderImpl((ViewGroup) findViewById);
        }

        public final void bind(@NotNull AmenityButtonsItem amenityButtonsItem) {
            Intrinsics.checkNotNullParameter(amenityButtonsItem, "item");
            this.s.bindData(amenityButtonsItem.getButtons(), this.u);
        }

        @NotNull
        public final View getView() {
            return this.t;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter$ItemCreateRouteHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lio/reactivex/rxjava3/core/Observable;", "", "t", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "createRouteButton", "<init>", "(Landroid/view/View;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemCreateRouteHolder extends RecyclerView.ViewHolder {
        public final Button s;
        @NotNull
        public final Observable<Unit> t;
        @NotNull
        public final View u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemCreateRouteHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.u = view;
            View findViewById = view.findViewById(R.id.button_create_route);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.button_create_route)");
            Button button = (Button) findViewById;
            this.s = button;
            this.t = RxView.clicks(button);
        }

        @NotNull
        public final Observable<Unit> getClicks() {
            return this.t;
        }

        @NotNull
        public final View getView() {
            return this.u;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter$ItemMapAddressHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/item_map/view/ItemAddress;", "item", "", "bind", "(Lcom/avito/android/item_map/view/ItemAddress;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "<init>", "(Landroid/view/View;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemMapAddressHolder extends RecyclerView.ViewHolder {
        public final TextView s;
        @NotNull
        public final View t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemMapAddressHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = view;
            View findViewById = view.findViewById(R.id.addressText);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.addressText)");
            this.s = (TextView) findViewById;
        }

        public final void bind(@NotNull ItemAddress itemAddress) {
            Intrinsics.checkNotNullParameter(itemAddress, "item");
            this.s.setText(itemAddress.getText());
        }

        @NotNull
        public final View getView() {
            return this.t;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter$ItemMapGeoReferenceHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/remote/model/GeoReference;", "geoReference", "", "bind", "(Lcom/avito/android/remote/model/GeoReference;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinderImpl;", "s", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinderImpl;", "binder", "<init>", "(Landroid/view/View;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemMapGeoReferenceHolder extends RecyclerView.ViewHolder {
        public final GeoReferenceViewBinderImpl s;
        @NotNull
        public final View t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemMapGeoReferenceHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = view;
            View findViewById = view.findViewById(R.id.geo_reference_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.geo_reference_container)");
            this.s = new GeoReferenceViewBinderImpl((ViewGroup) findViewById);
        }

        public final void bind(@NotNull GeoReference geoReference) {
            Intrinsics.checkNotNullParameter(geoReference, "geoReference");
            this.s.bindData(geoReference);
        }

        @NotNull
        public final View getView() {
            return this.t;
        }
    }

    @Inject
    public ItemMapViewBottomSheetAdapter(@NotNull AmenityButtonsPresenter amenityButtonsPresenter) {
        Intrinsics.checkNotNullParameter(amenityButtonsPresenter, "presenter");
        this.g = amenityButtonsPresenter;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        this.f = create;
    }

    @NotNull
    public final Observable<Unit> getCreateRouteClicks() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof ItemAddress) {
            return 0;
        }
        if (obj instanceof GeoReference) {
            return 1;
        }
        return obj instanceof CreateRouteItem ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object obj = this.c.get(i);
        if (obj instanceof ItemAddress) {
            ((ItemMapAddressHolder) viewHolder).bind((ItemAddress) obj);
        } else if (obj instanceof GeoReference) {
            ((ItemMapGeoReferenceHolder) viewHolder).bind((GeoReference) obj);
        } else if (obj instanceof AmenityButtonsItem) {
            ((ItemAmenityButtonsHolder) viewHolder).bind((AmenityButtonsItem) obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater layoutInflater = this.d;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
            this.d = layoutInflater;
        }
        if (i == 0) {
            View inflate = layoutInflater.inflate(R.layout.recycler_item_address, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…m_address, parent, false)");
            return new ItemMapAddressHolder(inflate);
        } else if (i == 1) {
            View inflate2 = layoutInflater.inflate(R.layout.recycler_item_geo_reference, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(R.layou…reference, parent, false)");
            return new ItemMapGeoReferenceHolder(inflate2);
        } else if (i != 3) {
            View inflate3 = layoutInflater.inflate(R.layout.recycler_item_amenity_buttons, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflater.inflate(R.layou…y_buttons, parent, false)");
            return new ItemAmenityButtonsHolder(inflate3, this.g);
        } else {
            View inflate4 = layoutInflater.inflate(R.layout.recycler_item_create_route, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "inflater.inflate(R.layou…ate_route, parent, false)");
            ItemCreateRouteHolder itemCreateRouteHolder = new ItemCreateRouteHolder(inflate4);
            itemCreateRouteHolder.getClicks().subscribe(this.e);
            return itemCreateRouteHolder;
        }
    }

    public final void updateData(@Nullable List<Object> list) {
        if (list != null) {
            this.c = list;
            notifyDataSetChanged();
        }
    }
}
