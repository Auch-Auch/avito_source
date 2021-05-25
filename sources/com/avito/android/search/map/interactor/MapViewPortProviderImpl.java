package com.avito.android.search.map.interactor;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.R;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/search/map/interactor/MapViewPortProviderImpl;", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "Lkotlin/Pair;", "", "getViewPort", "()Lkotlin/Pair;", "getReducedViewPort", "getBottomOffset", "()I", "getTopOffset", "getOffsets", "advertsCount", "getOffsetForVisibleArea", "(I)I", "Landroid/view/View;", "c", "Landroid/view/View;", "rootView", AuthSource.SEND_ABUSE, "mapView", AuthSource.BOOKING_ORDER, "shortcutsContainer", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/view/View;Landroid/content/res/Resources;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapViewPortProviderImpl implements MapViewPortProvider {
    public View a;
    public View b;
    public final View c;
    public final Resources d;

    @Inject
    public MapViewPortProviderImpl(@Nullable View view, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.c = view;
        this.d = resources;
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    public int getBottomOffset() {
        return (int) (this.d.getDimension(R.dimen.search_map_adverts_collapsed_bar_offset) / this.d.getDisplayMetrics().density);
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    public int getOffsetForVisibleArea(int i) {
        int intValue = getViewPort().getFirst().intValue();
        if (intValue == 0) {
            return 0;
        }
        int i2 = intValue / 2;
        if (i == 1) {
            i2 = Math.min((int) (this.d.getDimension(R.dimen.search_map_pin_adverts_card_height) / this.d.getDisplayMetrics().density), i2);
        }
        int dimension = (int) (this.d.getDimension(R.dimen.search_map_search_bar_with_padding_height) / this.d.getDisplayMetrics().density);
        return (((intValue - dimension) - i2) / 2) + dimension;
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    public int getOffsets() {
        return getTopOffset() + getBottomOffset();
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    @NotNull
    public Pair<Integer, Integer> getReducedViewPort() {
        Pair<Integer, Integer> viewPort = getViewPort();
        return new Pair<>(Integer.valueOf(viewPort.component1().intValue()), Integer.valueOf(viewPort.component2().intValue() - (getBottomOffset() + getTopOffset())));
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    public int getTopOffset() {
        View view;
        if (this.b == null) {
            View view2 = this.c;
            if (view2 != null) {
                view = view2.findViewById(com.avito.android.ui_components.R.id.shortcuts_container);
                Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.View");
            } else {
                view = null;
            }
            this.b = view;
        }
        View view3 = this.b;
        if (view3 != null) {
            return (int) (((float) view3.getMeasuredHeight()) / this.d.getDisplayMetrics().density);
        }
        return 0;
    }

    @Override // com.avito.android.search.map.interactor.MapViewPortProvider
    @NotNull
    public Pair<Integer, Integer> getViewPort() {
        View view;
        DisplayMetrics displayMetrics = this.d.getDisplayMetrics();
        if (this.a == null) {
            View view2 = this.c;
            if (view2 != null) {
                view = view2.findViewById(R.id.map);
                Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.View");
            } else {
                view = null;
            }
            this.a = view;
        }
        View view3 = this.a;
        int i = 0;
        int width = view3 != null ? view3.getWidth() : 0;
        View view4 = this.a;
        if (view4 != null) {
            i = view4.getHeight();
        }
        if (width == 0 || i == 0) {
            width = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        float f = displayMetrics.density;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return new Pair<>(Integer.valueOf((int) (((float) width) / f)), Integer.valueOf((int) (((float) i) / f)));
    }
}
