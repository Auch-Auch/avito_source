package com.avito.android.search.map.view.marker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.map.Highlight;
import com.avito.android.search.map.R;
import com.avito.android.search.map.view.PartialMarker;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002)*B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u0019\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%B!\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b!\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007R\u001f\u0010\u0011\u001a\u0004\u0018\u00010\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00128B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00178B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001e\u001a\u0004\u0018\u00010\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010¨\u0006+"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerPinView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/search/map/view/marker/MarkerView;", "Lcom/avito/android/search/map/view/PartialMarker;", "pin", "", "setMarginTopForTextAndFavourite", "(Lcom/avito/android/search/map/view/PartialMarker;)V", "setText", "setFavourite", "setPinView", "setTextAndFavorite", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getBackgroundImage", "()Landroid/widget/ImageView;", "backgroundImage", "Landroid/widget/LinearLayout;", "d", "getPinContainer", "()Landroid/widget/LinearLayout;", "pinContainer", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "getDataText", "()Landroid/widget/TextView;", "dataText", "c", "getFavorite", "favorite", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Pin", "PinType", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerPinView extends FrameLayout implements MarkerView {
    public final Lazy a = t6.c.lazy(new a(0, this));
    public final Lazy b = t6.c.lazy(new b(this));
    public final Lazy c = t6.c.lazy(new a(1, this));
    public final Lazy d = t6.c.lazy(new c(this));

    /* JADX WARN: Init of enum NO_DIGIT can be incorrect */
    /* JADX WARN: Init of enum ONE_DIGIT can be incorrect */
    /* JADX WARN: Init of enum TWO_DIGITS can be incorrect */
    /* JADX WARN: Init of enum THREE_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FOUR_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FIVE_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FAVOURITE_ONE_DIGIT can be incorrect */
    /* JADX WARN: Init of enum FAVOURITE_TWO_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FAVOURITE_THREE_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FAVOURITE_FOUR_DIGITS can be incorrect */
    /* JADX WARN: Init of enum FAVOURITE_FIVE_DIGITS can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_NO_DIGIT can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_ONE_DIGIT can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_TWO_DIGITS can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_THREE_DIGITS can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_FOUR_DIGITS can be incorrect */
    /* JADX WARN: Init of enum BRIGHT_FIVE_DIGITS can be incorrect */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006j\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerPinView$Pin;", "", "", "c", "I", "getBackgroundViewed", "()I", "backgroundViewed", AuthSource.BOOKING_ORDER, "getBackgroundSelected", "backgroundSelected", AuthSource.SEND_ABUSE, "getBackgroundNormal", "backgroundNormal", "<init>", "(Ljava/lang/String;IIII)V", "NO_DIGIT", "ONE_DIGIT", "TWO_DIGITS", "THREE_DIGITS", "FOUR_DIGITS", "FIVE_DIGITS", "FAVOURITE_ONE_DIGIT", "FAVOURITE_TWO_DIGITS", "FAVOURITE_THREE_DIGITS", "FAVOURITE_FOUR_DIGITS", "FAVOURITE_FIVE_DIGITS", "BRIGHT_NO_DIGIT", "BRIGHT_ONE_DIGIT", "BRIGHT_TWO_DIGITS", "BRIGHT_THREE_DIGITS", "BRIGHT_FOUR_DIGITS", "BRIGHT_FIVE_DIGITS", "map_release"}, k = 1, mv = {1, 4, 2})
    public enum Pin {
        NO_DIGIT(r4, r12, R.drawable.search_map_no_digit_viewed),
        ONE_DIGIT(r16, r6, R.drawable.search_map_one_digit_viewed),
        TWO_DIGITS(r16, r23, R.drawable.search_map_two_digits_viewed),
        THREE_DIGITS(r16, r24, R.drawable.search_map_three_digits_viewed),
        FOUR_DIGITS(r16, r25, R.drawable.search_map_four_digits_viewed),
        FIVE_DIGITS(r16, r26, R.drawable.search_map_five_digits_viewed),
        FAVOURITE_ONE_DIGIT(r18, R.drawable.search_map_one_favorites_selected, r18),
        FAVOURITE_TWO_DIGITS(r22, r23, r22),
        FAVOURITE_THREE_DIGITS(r22, r24, r22),
        FAVOURITE_FOUR_DIGITS(r22, r25, r22),
        FAVOURITE_FIVE_DIGITS(r22, r26, r22),
        BRIGHT_NO_DIGIT(R.drawable.search_map_no_digit_bright, r12, R.drawable.search_map_no_digit_viewed_bright),
        BRIGHT_ONE_DIGIT(R.drawable.search_map_one_digit_bright, r6, R.drawable.search_map_one_digit_viewed_bright),
        BRIGHT_TWO_DIGITS(R.drawable.search_map_two_digits_bright, r23, R.drawable.search_map_two_digits_viewed_bright),
        BRIGHT_THREE_DIGITS(R.drawable.search_map_three_digits_bright, r24, R.drawable.search_map_three_digits_viewed_bright),
        BRIGHT_FOUR_DIGITS(R.drawable.search_map_four_digits_bright, r25, R.drawable.search_map_four_digits_viewed_bright),
        BRIGHT_FIVE_DIGITS(R.drawable.search_map_five_digits_bright, r26, R.drawable.search_map_five_digits_viewed_bright);
        
        public final int a;
        public final int b;
        public final int c;

        /* access modifiers changed from: public */
        static {
            int i = R.drawable.search_map_no_digit;
            int i2 = R.drawable.search_map_no_digit_selected;
            int i3 = R.drawable.search_map_one_digit;
            int i4 = R.drawable.search_map_one_digit_selected;
            int i5 = R.drawable.search_map_two_digits;
            int i6 = R.drawable.search_map_two_digits_selected;
            int i7 = R.drawable.search_map_three_digits;
            int i8 = R.drawable.search_map_three_digits_selected;
            int i9 = R.drawable.search_map_four_digits;
            int i10 = R.drawable.search_map_four_digits_selected;
            int i11 = R.drawable.search_map_five_digits;
            int i12 = R.drawable.search_map_five_digits_selected;
            int i13 = R.drawable.search_map_one_favorites;
            int i14 = R.drawable.search_map_two_digits_favorites;
            int i15 = R.drawable.search_map_three_digits_favorites;
            int i16 = R.drawable.search_map_four_digits_favorites;
            int i17 = R.drawable.search_map_five_digits_favorites;
        }

        /* access modifiers changed from: public */
        Pin(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int getBackgroundNormal() {
            return this.a;
        }

        public final int getBackgroundSelected() {
            return this.b;
        }

        public final int getBackgroundViewed() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/search/map/view/marker/MarkerPinView$PinType;", "", "<init>", "(Ljava/lang/String;I)V", MessengerShareContentUtility.PREVIEW_DEFAULT, "SELECTED", "VIEWED", "map_release"}, k = 1, mv = {1, 4, 2})
    public enum PinType {
        DEFAULT,
        SELECTED,
        VIEWED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PinType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[1] = 3;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<ImageView> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            int i = this.a;
            if (i == 0) {
                return (ImageView) ((MarkerPinView) this.b).findViewById(R.id.image_view);
            }
            if (i == 1) {
                return (ImageView) ((MarkerPinView) this.b).findViewById(R.id.favorites);
            }
            throw null;
        }
    }

    public static final class b extends Lambda implements Function0<TextView> {
        public final /* synthetic */ MarkerPinView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MarkerPinView markerPinView) {
            super(0);
            this.a = markerPinView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) this.a.findViewById(R.id.text);
        }
    }

    public static final class c extends Lambda implements Function0<LinearLayout> {
        public final /* synthetic */ MarkerPinView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MarkerPinView markerPinView) {
            super(0);
            this.a = markerPinView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            return (LinearLayout) this.a.findViewById(R.id.marker_pin_container);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView getBackgroundImage() {
        return (ImageView) this.a.getValue();
    }

    private final TextView getDataText() {
        return (TextView) this.b.getValue();
    }

    private final ImageView getFavorite() {
        return (ImageView) this.c.getValue();
    }

    private final LinearLayout getPinContainer() {
        return (LinearLayout) this.d.getValue();
    }

    private final void setFavourite(PartialMarker partialMarker) {
        ImageView favorite = getFavorite();
        if (favorite != null) {
            ViewGroup.LayoutParams layoutParams = favorite.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (!partialMarker.isFavorite() || partialMarker.getCount() <= 1) {
                favorite.setImageDrawable(null);
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                    return;
                }
                return;
            }
            favorite.setImageDrawable(favorite.getContext().getDrawable(R.drawable.search_map_favorites));
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(Views.dpToPx(favorite, 6), 0, 0, 0);
            }
        }
    }

    private final void setMarginTopForTextAndFavourite(PartialMarker partialMarker) {
        int i;
        LinearLayout pinContainer = getPinContainer();
        if (pinContainer != null) {
            ViewGroup.LayoutParams layoutParams = pinContainer.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (partialMarker.isFavorite()) {
                int count = partialMarker.getCount();
                if (2 <= count && 10 > count) {
                    i = Views.dpToPx(pinContainer, 8);
                } else if (10 <= count && 100 > count) {
                    i = Views.dpToPx(pinContainer, 12);
                } else if (100 <= count && 1000 > count) {
                    i = Views.dpToPx(pinContainer, 16);
                } else {
                    i = Views.dpToPx(pinContainer, 20);
                }
            } else if (partialMarker.getCount() < 10) {
                i = Views.dpToPx(pinContainer, 6);
            } else {
                int count2 = partialMarker.getCount();
                if (10 <= count2 && 100 > count2) {
                    i = Views.dpToPx(pinContainer, 8);
                } else {
                    int count3 = partialMarker.getCount();
                    if (100 <= count3 && 1000 > count3) {
                        i = Views.dpToPx(pinContainer, 12);
                    } else {
                        int count4 = partialMarker.getCount();
                        if (1000 <= count4 && 10000 > count4) {
                            i = Views.dpToPx(pinContainer, 16);
                        } else {
                            i = Views.dpToPx(pinContainer, 20);
                        }
                    }
                }
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, i, 0, 0);
            }
            pinContainer.setLayoutParams(marginLayoutParams);
        }
    }

    private final void setText(PartialMarker partialMarker) {
        int i;
        TextView dataText = getDataText();
        if (dataText != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            TextViews.bindText$default(dataText, partialMarker.getText(), false, 2, null);
            ViewGroup.LayoutParams layoutParams = dataText.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            if (marginLayoutParams2 != null) {
                if (partialMarker.isFavorite() || partialMarker.getCount() < 10) {
                    i = (partialMarker.getCount() >= 10 || partialMarker.isFavorite()) ? 0 : Views.dpToPx(dataText, 12);
                } else {
                    i = Views.dpToPx(dataText, 10);
                }
                marginLayoutParams2.setMargins(i, 0, 0, 0);
            }
        }
    }

    @Override // com.avito.android.search.map.view.marker.MarkerView
    public void setPinView(@NotNull PartialMarker partialMarker) {
        Pin pin;
        PinType pinType;
        int i;
        Intrinsics.checkNotNullParameter(partialMarker, "pin");
        ImageView backgroundImage = getBackgroundImage();
        if (backgroundImage != null) {
            if (partialMarker.isFavorite()) {
                int count = partialMarker.getCount();
                if (count == 1) {
                    pin = Pin.FAVOURITE_ONE_DIGIT;
                } else if (2 <= count && 10 > count) {
                    pin = Pin.FAVOURITE_TWO_DIGITS;
                } else if (10 <= count && 100 > count) {
                    pin = Pin.FAVOURITE_THREE_DIGITS;
                } else if (100 <= count && 1000 > count) {
                    pin = Pin.FAVOURITE_FOUR_DIGITS;
                } else {
                    pin = Pin.FAVOURITE_FIVE_DIGITS;
                }
            } else if (partialMarker.getHighlight() == Highlight.Bright) {
                int count2 = partialMarker.getCount();
                if (count2 == 1) {
                    pin = Pin.BRIGHT_NO_DIGIT;
                } else if (2 <= count2 && 10 > count2) {
                    pin = Pin.BRIGHT_ONE_DIGIT;
                } else if (10 <= count2 && 100 > count2) {
                    pin = Pin.BRIGHT_TWO_DIGITS;
                } else if (100 <= count2 && 1000 > count2) {
                    pin = Pin.BRIGHT_THREE_DIGITS;
                } else if (1000 <= count2 && 10000 > count2) {
                    pin = Pin.BRIGHT_FOUR_DIGITS;
                } else {
                    pin = Pin.BRIGHT_FOUR_DIGITS;
                }
            } else {
                int count3 = partialMarker.getCount();
                if (count3 == 1) {
                    pin = Pin.NO_DIGIT;
                } else if (2 <= count3 && 10 > count3) {
                    pin = Pin.ONE_DIGIT;
                } else if (10 <= count3 && 100 > count3) {
                    pin = Pin.TWO_DIGITS;
                } else if (100 <= count3 && 1000 > count3) {
                    pin = Pin.THREE_DIGITS;
                } else if (1000 <= count3 && 10000 > count3) {
                    pin = Pin.FOUR_DIGITS;
                } else {
                    pin = Pin.FOUR_DIGITS;
                }
            }
            if (partialMarker.getSelected()) {
                pinType = PinType.SELECTED;
            } else if (partialMarker.isViewed()) {
                pinType = PinType.VIEWED;
            } else {
                pinType = PinType.DEFAULT;
            }
            int ordinal = pinType.ordinal();
            if (ordinal == 0) {
                i = pin.getBackgroundNormal();
            } else if (ordinal == 1) {
                i = pin.getBackgroundSelected();
            } else if (ordinal == 2) {
                i = pin.getBackgroundViewed();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            backgroundImage.setImageResource(i);
        }
    }

    @Override // com.avito.android.search.map.view.marker.MarkerView
    public void setTextAndFavorite(@NotNull PartialMarker partialMarker) {
        Intrinsics.checkNotNullParameter(partialMarker, "pin");
        setMarginTopForTextAndFavourite(partialMarker);
        setText(partialMarker);
        setFavourite(partialMarker);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerPinView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
