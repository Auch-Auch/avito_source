package com.avito.android.item_map.amenity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.item_map.R;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinderImpl;", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;", "", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "amenityButtons", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "presenter", "", "bindData", "(Ljava/util/List;Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "", "type", "", "loading", "showLoading", "(Ljava/lang/String;Z)V", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "viewState", "setButtonColors", "(Ljava/lang/String;Lcom/avito/android/item_map/amenity/ButtonViewState;)V", "", "Lcom/avito/android/item_map/amenity/AmenityButtonView;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "views", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButtonsViewBinderImpl implements AmenityButtonsViewBinder {
    public final LayoutInflater a;
    public final Map<String, AmenityButtonView> b = new LinkedHashMap();
    public final ViewGroup c;

    public AmenityButtonsViewBinderImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.c = viewGroup;
        this.a = LayoutInflater.from(viewGroup.getContext());
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsViewBinder
    public void bindData(@NotNull List<AmenityButton> list, @NotNull AmenityButtonsPresenter amenityButtonsPresenter) {
        Intrinsics.checkNotNullParameter(list, "amenityButtons");
        Intrinsics.checkNotNullParameter(amenityButtonsPresenter, "presenter");
        amenityButtonsPresenter.attachButtonsView(this);
        if (!(!this.b.isEmpty())) {
            for (T t : list) {
                String type = t.getType();
                if (type != null) {
                    if (type.length() > 0) {
                        View inflate = this.a.inflate(R.layout.amenity_button, this.c, false);
                        Intrinsics.checkNotNullExpressionValue(inflate, "view");
                        AmenityButtonViewImpl amenityButtonViewImpl = new AmenityButtonViewImpl(inflate);
                        this.b.put(type, amenityButtonViewImpl);
                        amenityButtonViewImpl.bind(t, amenityButtonsPresenter.getAmenityButtonViewState(type), amenityButtonsPresenter);
                        this.c.addView(inflate);
                    }
                }
            }
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsViewBinder
    public void setButtonColors(@NotNull String str, @NotNull ButtonViewState buttonViewState) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(buttonViewState, "viewState");
        AmenityButtonView amenityButtonView = this.b.get(str);
        if (amenityButtonView != null) {
            amenityButtonView.setButtonColors(buttonViewState);
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsViewBinder
    public void showLoading(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "type");
        AmenityButtonView amenityButtonView = this.b.get(str);
        if (amenityButtonView != null) {
            amenityButtonView.showLoading(z);
        }
    }
}
