package com.avito.android.serp;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.ui_components.R;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\bC\u0018\u00002\u00020\u0001:\u0002)\u0018B\u0013\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0006\b\u0001\u0010\u0001B\u001d\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0006\b\u0001\u0010\u0001B%\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001B,\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0005\b\u0001\u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010!J1\u0010'\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b)\u0010*J9\u0010,\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\r\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010.R\u0018\u00108\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010.R\u0018\u0010<\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010.R\u0016\u0010?\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u00104R\u0018\u0010A\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u00101R\u0018\u0010C\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u00101R\u0018\u0010E\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u00101R\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010.R\u0018\u0010H\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u00101R\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010JR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010.R\u0016\u0010O\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\bN\u00101R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010.R\u0018\u0010S\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u00101R\u0018\u0010U\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u00101R\u0018\u0010W\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u00101R\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010.R\u0016\u0010[\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010.R\u0018\u0010]\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u00101R\u0016\u0010^\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010.R\u0018\u0010`\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u00101R\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010.R\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010.R\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010.R\u0018\u0010h\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u00101R\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010.R\u0018\u0010l\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u00101R\u0018\u0010n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u00101R\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010.R\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010.R\u0018\u0010t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u00101R\u0018\u0010v\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u00101R\u0016\u0010x\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010.R\u0018\u0010z\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u00101R\u0016\u0010|\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010.R\u0018\u0010~\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b}\u00101R\u0017\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010.R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010.R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010.R\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u00101R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010.¨\u0006\u0001"}, d2 = {"Lcom/avito/android/serp/AdvertItemLayout;", "Landroid/view/ViewGroup;", "", "getRecommendationItemHeight", "()I", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "swapPriceAndTitle", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "view", "Lcom/avito/android/serp/AdvertItemLayout$b;", "state", "topMargin", "needTopMarginAfterView", "d", "(Landroid/view/View;Lcom/avito/android/serp/AdvertItemLayout$b;IZ)V", AuthSource.SEND_ABUSE, "(Landroid/view/View;)I", "leftPosition", "c", "(Landroid/view/View;ILcom/avito/android/serp/AdvertItemLayout$b;IZ)V", "I", "columnMargin", "C", "Landroid/view/View;", "marketplaceDiscount", "T", "Z", "h", "imageHeightRatio", "z", "badgeBar", "R", "imageBottomOffset", "k", "favoriteButton", "columns", ExifInterface.LATITUDE_SOUTH, "fixedHeightRecSection", AuthSource.OPEN_CHANNEL_LIST, "verifiedSeller", "n", "delivery", "w", Sort.DATE, "J", "badgeMargin", "safeDeal", "Lcom/avito/android/serp/AdvertItemLayout$a;", "Lcom/avito/android/serp/AdvertItemLayout$a;", "imagePosition", "e", "imageId", "i", "image", "D", "Lcom/avito/android/serp/AdvertItemLayout$b;", "textStartOffset", "location", "y", "badge", "B", "trustFactor", "K", "favoritesMargin", "L", "bottomPageIndicatorMargin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "inStock", "iconBorderMargin", "x", "callButton", "G", "distanceTextMargin", ExifInterface.LONGITUDE_EAST, "betweenTextMargin", g.a, "imageWidthRatio", VKApiConst.Q, "priceWithoutDiscount", "F", "callButtonMargin", "j", "pageIndicator", VKApiConst.VERSION, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "N", "textLeftOffset", "M", "textBottomOffset", "u", Sort.DISTANCE, "p", "price", "H", "betweenIconMargin", "o", "title", "P", "imageLeftOffset", "s", "shopName", "O", "textRightOffset", "Q", "imageTopOffset", "f", "imageColumn", "description", "U", "cachedRecommendationFixedHeight", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemLayout extends ViewGroup {
    public View A;
    public View B;
    public View C;
    public final b D = new b(0, false);
    public final int E = getResources().getDimensionPixelOffset(R.dimen.advert_between_text_margin);
    public final int F = getResources().getDimensionPixelOffset(R.dimen.advert_call_button_margin);
    public final int G = getResources().getDimensionPixelOffset(R.dimen.advert_distance_text_margin);
    public final int H = getResources().getDimensionPixelOffset(R.dimen.advert_between_icon_margin);
    public final int I = getResources().getDimensionPixelOffset(R.dimen.advert_icon_border_margin);
    public final int J = getResources().getDimensionPixelOffset(R.dimen.card_badge_margin_left);
    public final int K = getResources().getDimensionPixelOffset(R.dimen.card_favorites_margin);
    public final int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public int U;
    public int a;
    public int b;
    public a c = a.TOP;
    public int d;
    public int e = R.id.image;
    public int f;
    public int g;
    public int h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            a.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            a.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            a.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
            a.values();
            int[] iArr4 = new int[2];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[0] = 1;
            iArr4[1] = 2;
        }
    }

    public enum a {
        TOP,
        LEFT
    }

    public static final class b {
        public int a;
        public boolean b;

        public b(int i, boolean z) {
            this.a = i;
            this.b = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertItemLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        getResources().getDimensionPixelOffset(R.dimen.card_favorites_size);
        this.L = getResources().getDimensionPixelOffset(R.dimen.advert_page_indicator_bottom_margin);
        b(context, null, 0, 0);
    }

    private final int getRecommendationItemHeight() {
        int i2 = this.U;
        if (i2 > 0) {
            return i2;
        }
        View view = this.o;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        View view2 = this.p;
        Objects.requireNonNull(view2, "null cannot be cast to non-null type android.widget.TextView");
        View view3 = this.t;
        Objects.requireNonNull(view3, "null cannot be cast to non-null type android.widget.TextView");
        int lineHeight = (this.E * 2) + ((TextView) view2).getLineHeight() + (((TextView) view).getLineHeight() * 2) + this.d + this.Q + ((TextView) view3).getLineHeight();
        this.U = lineHeight;
        return lineHeight;
    }

    public final int a(View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == this.e) {
            this.i = view;
        } else if (id == R.id.page_indicator) {
            this.j = view;
        } else if (id == R.id.btn_favorite) {
            this.k = view;
        } else if (id == R.id.safe_deal) {
            this.l = view;
        } else if (id == R.id.verified_seller) {
            this.m = view;
        } else if (id == R.id.delivery) {
            this.n = view;
        } else if (id == R.id.title) {
            this.o = view;
        } else if (id == R.id.price) {
            this.p = view;
        } else if (id == R.id.price_without_discount) {
            this.q = view;
        } else if (id == R.id.description) {
            this.r = view;
        } else if (id == R.id.shop_name) {
            this.s = view;
        } else if (id == R.id.location) {
            this.t = view;
        } else if (id == R.id.distance) {
            this.u = view;
        } else if (id == R.id.address) {
            this.v = view;
        } else if (id == R.id.date) {
            this.w = view;
        } else if (id == R.id.call_button) {
            this.x = view;
        } else if (id == R.id.badge) {
            this.y = view;
        } else if (id == R.id.badge_bar) {
            this.z = view;
        } else if (id == R.id.marketplace_instock) {
            this.A = view;
        } else if (id == R.id.marketplace_trust_factor) {
            this.B = view;
        } else if (id == R.id.marketplace_discount) {
            this.C = view;
        }
    }

    public final void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdvertItemLayout, i2, i3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…efStyleAttr, defStyleRes)");
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == R.styleable.AdvertItemLayout_columns) {
                this.a = obtainStyledAttributes.getInt(index, this.a);
            } else if (index == R.styleable.AdvertItemLayout_column_margin) {
                this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
            } else if (index == R.styleable.AdvertItemLayout_image_position) {
                this.c = a.values()[obtainStyledAttributes.getInt(index, this.c.ordinal())];
            } else if (index == R.styleable.AdvertItemLayout_text_start_offset) {
                this.d = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
            } else if (index == R.styleable.AdvertItemLayout_image_id) {
                this.e = obtainStyledAttributes.getResourceId(index, this.e);
            } else if (index == R.styleable.AdvertItemLayout_image_columns) {
                this.f = obtainStyledAttributes.getInt(index, this.f);
            } else if (index == R.styleable.AdvertItemLayout_image_width_ratio) {
                this.g = obtainStyledAttributes.getInt(index, this.g);
            } else if (index == R.styleable.AdvertItemLayout_image_height_ratio) {
                this.h = obtainStyledAttributes.getInt(index, this.h);
            } else if (index == R.styleable.AdvertItemLayout_text_bottom_margin) {
                this.M = obtainStyledAttributes.getDimensionPixelOffset(index, this.M);
            } else if (index == R.styleable.AdvertItemLayout_text_left_margin) {
                this.N = obtainStyledAttributes.getDimensionPixelOffset(index, this.N);
            } else if (index == R.styleable.AdvertItemLayout_text_right_margin) {
                this.O = obtainStyledAttributes.getDimensionPixelOffset(index, this.O);
            } else if (index == R.styleable.AdvertItemLayout_image_bottom_margin) {
                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
            } else if (index == R.styleable.AdvertItemLayout_image_left_margin) {
                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
            } else if (index == R.styleable.AdvertItemLayout_image_top_margin) {
                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
            } else if (index == R.styleable.AdvertItemLayout_rec_section_height) {
                this.S = obtainStyledAttributes.getBoolean(index, this.S);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void c(View view, int i2, b bVar, int i3, boolean z2) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() > 0) {
            if (bVar.b) {
                bVar.a += i3;
            }
            view.layout(i2, bVar.a, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + bVar.a);
            bVar.a = view.getMeasuredHeight() + bVar.a;
            bVar.b = z2;
        }
    }

    public final void d(View view, b bVar, int i2, boolean z2) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() > 0) {
            if (bVar.b) {
                bVar.a += i2;
            }
            bVar.a = view.getMeasuredHeight() + bVar.a;
            bVar.b = z2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        View view = this.i;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        }
        int measuredWidth = view.getMeasuredWidth();
        View view2 = this.i;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        }
        int measuredHeight2 = view2.getMeasuredHeight();
        View view3 = this.i;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        }
        view3.layout(this.P, this.Q, measuredWidth, measuredHeight2);
        View view4 = this.k;
        if (!(view4 == null || view4.getVisibility() == 8)) {
            int measuredWidth2 = measuredWidth - view4.getMeasuredWidth();
            View view5 = this.i;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            int measuredHeight3 = view5.getMeasuredHeight() + this.K;
            view4.layout(measuredWidth2, measuredHeight3, view4.getMeasuredWidth() + measuredWidth2, view4.getMeasuredHeight() + measuredHeight3);
        }
        View view6 = this.j;
        if (!(view6 == null || view6.getVisibility() == 8 || view6.getMeasuredHeight() <= 0)) {
            int measuredWidth3 = (measuredWidth - view6.getMeasuredWidth()) / 2;
            int i10 = measuredHeight2 - this.L;
            view6.layout(measuredWidth3, i10 - view6.getMeasuredHeight(), view6.getMeasuredWidth() + measuredWidth3, i10);
        }
        int i11 = this.I;
        int i12 = measuredWidth - i11;
        int i13 = measuredHeight2 - i11;
        View view7 = this.n;
        if (!(view7 == null || view7.getVisibility() == 8)) {
            view7.layout(i12 - view7.getMeasuredWidth(), i13 - view7.getMeasuredHeight(), i12, i13);
            i12 -= view7.getMeasuredWidth() - this.H;
        }
        View view8 = this.m;
        if (!(view8 == null || view8.getVisibility() == 8)) {
            view8.layout(i12 - view8.getMeasuredWidth(), i13 - view8.getMeasuredHeight(), i12, i13);
            i12 -= view8.getMeasuredWidth() - this.H;
        }
        View view9 = this.l;
        if (!(view9 == null || view9.getVisibility() == 8)) {
            view9.layout(i12 - view9.getMeasuredWidth(), i13 - view9.getMeasuredHeight(), i12, i13);
            view9.getMeasuredWidth();
        }
        View view10 = this.y;
        if (!(view10 == null || view10.getVisibility() == 8)) {
            int i14 = this.P;
            int i15 = this.J;
            int i16 = i14 + i15;
            int i17 = measuredHeight2 - i15;
            view10.layout(i16, i17 - view10.getMeasuredHeight(), view10.getMeasuredWidth() + i16, i17);
        }
        View view11 = this.z;
        if (!(view11 == null || view11.getVisibility() == 8)) {
            int i18 = this.P;
            int i19 = this.J;
            int i20 = measuredHeight2 - i19;
            view11.layout(i18 + i19, i20 - view11.getMeasuredHeight(), measuredWidth - i19, i20);
        }
        int ordinal = this.c.ordinal();
        if (ordinal == 0) {
            i6 = this.N;
            i7 = this.P;
        } else if (ordinal == 1) {
            View view12 = this.i;
            if (view12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            i6 = view12.getMeasuredWidth() + this.b;
            i7 = this.P;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i21 = i6 + i7;
        b bVar = this.D;
        int ordinal2 = this.c.ordinal();
        if (ordinal2 == 0) {
            View view13 = this.i;
            if (view13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            measuredHeight = view13.getMeasuredHeight();
            i8 = this.d;
        } else if (ordinal2 == 1) {
            measuredHeight = this.d;
            i8 = this.Q;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        bVar.a = measuredHeight + i8;
        b bVar2 = this.D;
        bVar2.b = false;
        if (this.T) {
            c(this.p, i21, bVar2, this.E, true);
            c(this.q, i21, this.D, this.E, true);
            c(this.o, i21, this.D, this.E, true);
        } else {
            c(this.o, i21, bVar2, this.E, true);
            c(this.p, i21, this.D, this.E, true);
            c(this.q, i21, this.D, this.E, true);
        }
        c(this.C, i21, this.D, this.E, false);
        c(this.r, i21, this.D, this.E, true);
        c(this.s, i21, this.D, this.E, false);
        int max = Math.max(a(this.t), a(this.u));
        if (max > 0) {
            b bVar3 = this.D;
            if (bVar3.b) {
                bVar3.a += this.E;
            }
            View view14 = this.t;
            if (view14 == null || view14.getVisibility() == 8 || view14.getMeasuredWidth() <= 0) {
                i9 = i21;
            } else {
                view14.layout(i21, this.D.a, view14.getMeasuredWidth() + i21, view14.getMeasuredHeight() + this.D.a);
                i9 = view14.getMeasuredWidth() + this.G + i21;
            }
            View view15 = this.u;
            if (!(view15 == null || view15.getVisibility() == 8 || view15.getMeasuredWidth() <= 0)) {
                view15.layout(i9, this.D.a, view15.getMeasuredWidth() + i9, view15.getMeasuredHeight() + this.D.a);
            }
            b bVar4 = this.D;
            bVar4.a += max;
            bVar4.b = false;
        }
        c(this.v, i21, this.D, this.E, false);
        c(this.A, i21, this.D, this.E, false);
        c(this.B, i21, this.D, this.E, false);
        c(this.w, i21, this.D, this.E, false);
        View view16 = this.x;
        if (view16 != null && view16.getVisibility() != 8 && view16.getMeasuredHeight() > 0) {
            int i22 = i5 - i3;
            view16.layout(i21, (i22 - view16.getMeasuredHeight()) - this.M, view16.getMeasuredWidth() + i21, i22 - this.M);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 608
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.AdvertItemLayout.onMeasure(int, int):void");
    }

    public final void swapPriceAndTitle() {
        this.T = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        getResources().getDimensionPixelOffset(R.dimen.card_favorites_size);
        this.L = getResources().getDimensionPixelOffset(R.dimen.advert_page_indicator_bottom_margin);
        b(context, attributeSet, 0, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        getResources().getDimensionPixelOffset(R.dimen.card_favorites_size);
        this.L = getResources().getDimensionPixelOffset(R.dimen.advert_page_indicator_bottom_margin);
        b(context, attributeSet, i2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        getResources().getDimensionPixelOffset(R.dimen.card_favorites_size);
        this.L = getResources().getDimensionPixelOffset(R.dimen.advert_page_indicator_bottom_margin);
        b(context, attributeSet, i2, i3);
    }
}
