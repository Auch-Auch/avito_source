package com.avito.android.search.map.view.marker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.map.Highlight;
import com.avito.android.search.map.R;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001a\u0010\u001eB!\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001a\u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u001f\u0010\r\u001a\u0004\u0018\u00010\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u000e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerPinWithPriceView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/search/map/view/MarkerItem$Pin;", "pin", "", "setView", "(Lcom/avito/android/search/map/view/MarkerItem$Pin;)V", "setTextAndFavorite", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getPrice", "()Landroid/widget/TextView;", "price", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "getFavorite", "()Landroid/widget/ImageView;", "favorite", "Landroid/widget/LinearLayout;", "c", "getPinContainer", "()Landroid/widget/LinearLayout;", "pinContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PinWithPriceType", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerPinWithPriceView extends FrameLayout {
    public final Lazy a = t6.c.lazy(new c(this));
    public final Lazy b = t6.c.lazy(new a(this));
    public final Lazy c = t6.c.lazy(new b(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerPinWithPriceView$PinWithPriceType;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "SELECTED", "VIEWED", "FAVORITE", "FAVORITE_SELECTED", "BRIGHT", "BRIGHT_VIEWED", "map_release"}, k = 1, mv = {1, 4, 2})
    public enum PinWithPriceType {
        REGULAR,
        SELECTED,
        VIEWED,
        FAVORITE,
        FAVORITE_SELECTED,
        BRIGHT,
        BRIGHT_VIEWED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PinWithPriceType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
            iArr[5] = 6;
            iArr[6] = 7;
        }
    }

    public static final class a extends Lambda implements Function0<ImageView> {
        public final /* synthetic */ MarkerPinWithPriceView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MarkerPinWithPriceView markerPinWithPriceView) {
            super(0);
            this.a = markerPinWithPriceView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) this.a.findViewById(R.id.favorites);
        }
    }

    public static final class b extends Lambda implements Function0<LinearLayout> {
        public final /* synthetic */ MarkerPinWithPriceView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MarkerPinWithPriceView markerPinWithPriceView) {
            super(0);
            this.a = markerPinWithPriceView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            return (LinearLayout) this.a.findViewById(R.id.marker_pin_container);
        }
    }

    public static final class c extends Lambda implements Function0<TextView> {
        public final /* synthetic */ MarkerPinWithPriceView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MarkerPinWithPriceView markerPinWithPriceView) {
            super(0);
            this.a = markerPinWithPriceView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) this.a.findViewById(R.id.text);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinWithPriceView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView getFavorite() {
        return (ImageView) this.b.getValue();
    }

    private final LinearLayout getPinContainer() {
        return (LinearLayout) this.c.getValue();
    }

    private final TextView getPrice() {
        return (TextView) this.a.getValue();
    }

    public final void setTextAndFavorite(@NotNull MarkerItem.Pin pin) {
        Intrinsics.checkNotNullParameter(pin, "pin");
        ImageView favorite = getFavorite();
        if (favorite != null) {
            if (pin.isFavorite()) {
                favorite.setImageDrawable(favorite.getContext().getDrawable(R.drawable.search_map_favorites));
                ViewGroup.LayoutParams layoutParams = favorite.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(0, 0, Views.dpToPx(favorite, 1), 0);
                }
            } else {
                favorite.setImageDrawable(null);
            }
        }
        TextView price = getPrice();
        if (price != null) {
            if (pin.getPrice() != null) {
                TextViews.bindText$default(price, pin.getPrice(), false, 2, null);
            }
            Context context = price.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            price.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite));
        }
    }

    public final void setView(@NotNull MarkerItem.Pin pin) {
        PinWithPriceType pinWithPriceType;
        Intrinsics.checkNotNullParameter(pin, "pin");
        LinearLayout pinContainer = getPinContainer();
        if (pinContainer != null) {
            if (pin.isFavorite() && !pin.getSelected()) {
                pinWithPriceType = PinWithPriceType.FAVORITE;
            } else if (pin.isFavorite()) {
                pinWithPriceType = PinWithPriceType.FAVORITE_SELECTED;
            } else if (pin.getSelected() || pin.isViewed()) {
                if (pin.getSelected() || !pin.isViewed()) {
                    if (pin.getSelected()) {
                        pinWithPriceType = PinWithPriceType.SELECTED;
                    } else {
                        pinWithPriceType = PinWithPriceType.REGULAR;
                    }
                } else if (pin.getHighlight() == Highlight.Bright) {
                    pinWithPriceType = PinWithPriceType.BRIGHT_VIEWED;
                } else {
                    pinWithPriceType = PinWithPriceType.VIEWED;
                }
            } else if (pin.getHighlight() == Highlight.Bright) {
                pinWithPriceType = PinWithPriceType.BRIGHT;
            } else {
                pinWithPriceType = PinWithPriceType.REGULAR;
            }
            switch (pinWithPriceType.ordinal()) {
                case 0:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_default);
                    return;
                case 1:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_selected);
                    return;
                case 2:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_viewed);
                    return;
                case 3:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_favorites);
                    return;
                case 4:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_favorite_selected);
                    return;
                case 5:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_bright_default);
                    return;
                case 6:
                    Views.setBackgroundCompat(pinContainer, R.drawable.search_map_marker_with_price_bright_viewed);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinWithPriceView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinWithPriceView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
