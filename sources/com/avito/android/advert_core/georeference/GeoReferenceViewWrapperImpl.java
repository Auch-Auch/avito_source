package com.avito.android.advert_core.georeference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.GeoReference;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/georeference/GeoReferenceViewWrapperImpl;", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewWrapper;", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "", "bindGeoReferences", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class GeoReferenceViewWrapperImpl implements GeoReferenceViewWrapper {
    public final LayoutInflater a;
    @NotNull
    public final ViewGroup b;

    public GeoReferenceViewWrapperImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.b = viewGroup;
        this.a = LayoutInflater.from(viewGroup.getContext());
    }

    @Override // com.avito.android.advert_core.georeference.GeoReferenceViewWrapper
    public void bindGeoReferences(@NotNull List<GeoReference> list) {
        Intrinsics.checkNotNullParameter(list, "geoReferences");
        for (T t : list) {
            View inflate = this.a.inflate(R.layout.advert_details_geo_reference, this.b, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) inflate;
            GeoReferenceViewBinderImpl geoReferenceViewBinderImpl = new GeoReferenceViewBinderImpl(viewGroup);
            List<String> colors = t.getColors();
            if (colors == null) {
                colors = CollectionsKt__CollectionsKt.emptyList();
            }
            geoReferenceViewBinderImpl.bindData(colors, t.getContent(), t.getAfter());
            this.b.addView(viewGroup);
        }
    }

    @NotNull
    public final ViewGroup getRootView() {
        return this.b;
    }
}
