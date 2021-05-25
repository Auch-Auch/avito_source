package com.avito.android.advert_core.map;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Sort;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 JK\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006!"}, d2 = {"Lcom/avito/android/advert_core/map/MapView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "pins", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", TariffPackageInfoConverterKt.HEADER_STRING_ID, "objects", Sort.DISTANCE, "", "setMap", "(Lcom/avito/android/remote/model/Coordinates;Ljava/util/List;Lcom/avito/android/avito_map/AvitoMap$MapClickListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/advert_core/map/MapLiteModeView;", "getLiteModeMapView", "()Lcom/avito/android/advert_core/map/MapLiteModeView;", "liteModeMapView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "headerText", "t", "objectsText", "u", "distanceText", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class MapView extends BaseViewHolder implements ItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.developments_catalog_map_header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.d…ments_catalog_map_header)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.developments_catalog_map_objects);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.d…ents_catalog_map_objects)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.developments_catalog_map_distance);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.d…nts_catalog_map_distance)");
        this.u = (TextView) findViewById3;
    }

    @NotNull
    public abstract MapLiteModeView getLiteModeMapView();

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if ((r6.length() > 0) != false) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMap(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.Coordinates r2, @org.jetbrains.annotations.NotNull java.util.List<com.avito.android.item_map.remote.model.AmenityPin> r3, @org.jetbrains.annotations.NotNull com.avito.android.avito_map.AvitoMap.MapClickListener r4, @org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r1 = this;
            java.lang.String r0 = "coords"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "pins"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.avito.android.advert_core.map.MapLiteModeView r0 = r1.getLiteModeMapView()
            r0.bindView(r2, r3, r4)
            r2 = 1
            r3 = 0
            if (r6 == 0) goto L_0x0026
            int r4 = r6.length()
            if (r4 <= 0) goto L_0x0022
            r4 = 1
            goto L_0x0023
        L_0x0022:
            r4 = 0
        L_0x0023:
            if (r4 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x003b
            android.widget.TextView r2 = r1.s
            r4 = 2
            r0 = 0
            com.avito.android.util.TextViews.bindText$default(r2, r5, r3, r4, r0)
            android.widget.TextView r2 = r1.t
            com.avito.android.util.TextViews.bindText$default(r2, r6, r3, r4, r0)
            android.widget.TextView r2 = r1.u
            com.avito.android.util.TextViews.bindText$default(r2, r7, r3, r4, r0)
            goto L_0x004a
        L_0x003b:
            android.widget.TextView r2 = r1.s
            com.avito.android.util.Views.hide(r2)
            android.widget.TextView r2 = r1.t
            com.avito.android.util.Views.hide(r2)
            android.widget.TextView r2 = r1.u
            com.avito.android.util.Views.hide(r2)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.map.MapView.setMap(com.avito.android.remote.model.Coordinates, java.util.List, com.avito.android.avito_map.AvitoMap$MapClickListener, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
