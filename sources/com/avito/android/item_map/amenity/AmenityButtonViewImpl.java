package com.avito.android.item_map.amenity;

import android.content.res.ColorStateList;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryKt;
import com.avito.android.item_map.R;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.util.TextViews;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020\u0017¢\u0006\u0004\b-\u0010.J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J'\u0010\u001a\u001a\u00020\b*\u00020\u00172\b\b\u0001\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonViewImpl;", "Lcom/avito/android/item_map/amenity/AmenityButtonView;", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "data", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "buttonViewState", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Lcom/avito/android/item_map/remote/model/AmenityButton;Lcom/avito/android/item_map/amenity/ButtonViewState;Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "", "loading", "showLoading", "(Z)V", "viewState", "setButtonColors", "(Lcom/avito/android/item_map/amenity/ButtonViewState;)V", "Lcom/avito/android/remote/model/Color;", "color", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Color;)V", "c", "Landroid/view/View;", "", "drawableRes", AuthSource.BOOKING_ORDER, "(Landroid/view/View;ILcom/avito/android/remote/model/Color;)V", "Landroid/view/View;", "container", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "image", "imageBg", "f", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "text", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "progress", "view", "<init>", "(Landroid/view/View;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButtonViewImpl implements AmenityButtonView {
    public final View a;
    public final ProgressBar b;
    public final View c;
    public final ImageView d;
    public final TextView e;
    public AmenityButton f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonViewState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AmenityButtonsPresenter a;
        public final /* synthetic */ AmenityButton b;

        public a(AmenityButtonsPresenter amenityButtonsPresenter, AmenityButton amenityButton) {
            this.a = amenityButtonsPresenter;
            this.b = amenityButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AmenityButtonsPresenter amenityButtonsPresenter = this.a;
            String type = this.b.getType();
            if (type == null) {
                type = "";
            }
            amenityButtonsPresenter.onAmenityButtonClick(type);
        }
    }

    public AmenityButtonViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getResources();
        View findViewById = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(itemMap_R.id.container)");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.progress);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(itemMap_R.id.progress)");
        this.b = (ProgressBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.image_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(itemMap_R.id.image_bg)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(itemMap_R.id.image)");
        this.d = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(itemMap_R.id.text)");
        this.e = (TextView) findViewById5;
    }

    public final void a(Color color) {
        b(this.a, R.drawable.bg_button_rounded, color);
    }

    public final void b(View view, @DrawableRes int i, Color color) {
        if (color != null) {
            int value = color.getValue();
            view.setBackground(view.getContext().getDrawable(i));
            view.setBackgroundTintList(ColorStateList.valueOf(value));
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonView
    public void bind(@NotNull AmenityButton amenityButton, @NotNull ButtonViewState buttonViewState, @NotNull AmenityButtonsPresenter amenityButtonsPresenter) {
        Intrinsics.checkNotNullParameter(amenityButton, "data");
        Intrinsics.checkNotNullParameter(buttonViewState, "buttonViewState");
        Intrinsics.checkNotNullParameter(amenityButtonsPresenter, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f = amenityButton;
        String type = amenityButton.getType();
        this.d.setImageDrawable(new ContextThemeWrapper(this.d.getContext(), com.avito.android.lib.design.avito.R.style.Theme_DesignSystem_Avito).getDrawable(AmenityMarkerIconFactoryKt.toPinType(type).getDrawableRes()));
        setButtonColors(buttonViewState);
        TextViews.bindText$default(this.e, amenityButton.getTitle(), false, 2, null);
        this.a.setOnClickListener(new a(amenityButtonsPresenter, amenityButton));
    }

    public final void c(Color color) {
        b(this.c, com.avito.android.ui_components.R.drawable.white_radius, color);
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonView
    public void setButtonColors(@NotNull ButtonViewState buttonViewState) {
        Intrinsics.checkNotNullParameter(buttonViewState, "viewState");
        int ordinal = buttonViewState.ordinal();
        Color color = null;
        if (ordinal == 0) {
            AmenityButton amenityButton = this.f;
            a(amenityButton != null ? amenityButton.getBgUnpressedColor() : null);
            AmenityButton amenityButton2 = this.f;
            if (amenityButton2 != null) {
                color = amenityButton2.getBgPressedColor();
            }
            c(color);
            this.a.setAlpha(1.0f);
        } else if (ordinal == 1) {
            AmenityButton amenityButton3 = this.f;
            a(amenityButton3 != null ? amenityButton3.getBgPressedColor() : null);
            AmenityButton amenityButton4 = this.f;
            if (amenityButton4 != null) {
                color = amenityButton4.getBgUnpressedColor();
            }
            c(color);
            this.a.setAlpha(1.0f);
        } else if (ordinal == 2) {
            AmenityButton amenityButton5 = this.f;
            a(amenityButton5 != null ? amenityButton5.getBgUnpressedColor() : null);
            AmenityButton amenityButton6 = this.f;
            if (amenityButton6 != null) {
                color = amenityButton6.getBgPressedColor();
            }
            c(color);
            this.a.setAlpha(0.5f);
        }
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonView
    public void showLoading(boolean z) {
        if (z) {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.b.setVisibility(8);
        this.d.setVisibility(0);
    }
}
