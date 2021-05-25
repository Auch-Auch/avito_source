package ru.avito.component.serp;

import a2.g.r.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001CB%\u0012\u0006\u0010_\u001a\u00020]\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J#\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010 J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010 J\u001d\u0010)\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b+\u0010*J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010 J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010 J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0014¢\u0006\u0004\b\u001f\u00102J\u0019\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b4\u0010\u0006J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010>\u001a\u00020\u00042\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010A\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\bA\u0010\u0006J\u0019\u0010B\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\bB\u0010\u0006J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010:R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010L\u001a\n I*\u0004\u0018\u00010H0H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010FR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010FR\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010FR\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010g\u001a\n I*\u0004\u0018\u00010d0d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010FR\u0018\u0010k\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010FR\u0016\u0010o\u001a\u00020l8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010FR\u0018\u0010s\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010FR\u0016\u0010u\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010^R\u0018\u0010w\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010FR\u0016\u0010y\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010nR\u0016\u0010{\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010NR\u0016\u0010}\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010nR\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u0018\u0010\u0001\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010^R\u001a\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u001a\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u0018\u0010\u0001\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010nR\u001a\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u001a\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u001a\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010FR\u0018\u0010\u0001\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010n¨\u0006\u0001"}, d2 = {"Lru/avito/component/serp/RdsSerpAdvertCardImpl;", "Lru/avito/component/serp/RdsSerpAdvertCard;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "location", "setLocation", Sort.DISTANCE, "setDistance", "", "time", "setDate", "(J)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "visible", "setFavoriteVisible", "favorite", "setFavorite", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "isSafeDeal", "setSafeDealVisible", "isShowDelivery", "setDeliveryVisible", "", "alpha", "(F)V", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "()V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "bindBadges", "(Ljava/util/List;)V", "value", "setInStock", "setTrustFactor", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "distanceView", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "z", "Landroid/graphics/drawable/Drawable;", "normalPriceBackground", "C", "F", "activeAlpha", "n", "badgeView", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "verifiedSellerView", AuthSource.BOOKING_ORDER, "titleView", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "e", "discountView", "Landroid/view/View;", "Landroid/view/View;", "view", "Lcom/google/android/material/internal/CheckableImageButton;", "r", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "Landroid/content/res/ColorStateList;", "y", "Landroid/content/res/ColorStateList;", "normalPriceTextColor", "i", "locationView", "f", "discountPercentageView", "", VKApiConst.VERSION, "I", "highlightedPriceTextColor", "d", "priceWithoutDiscountView", AuthSource.OPEN_CHANNEL_LIST, "infoBadge", "s", "safeDealView", "h", "shopNameView", "w", "highlightedPriceBackgroundColor", "D", "inactiveAlpha", "x", "highlightedPriceHorizontalPadding", "Lru/avito/component/serp/RdsSerpAdvertCardImpl$a;", ExifInterface.LONGITUDE_EAST, "Lru/avito/component/serp/RdsSerpAdvertCardImpl$a;", "state", "c", "priceView", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "o", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "u", "deliveryView", g.a, "additionalNameView", "l", "dateView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "normalPriceLeftPadding", "k", "addressView", VKApiConst.Q, "trustFactorView", "p", "instockView", "B", "normalPriceRightPadding", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class RdsSerpAdvertCardImpl implements RdsSerpAdvertCard {
    public final int A;
    public final int B;
    public final float C;
    public final float D;
    public a E = new a(true, false);
    public final View F;
    public final DateTimeFormatter a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final CompactFlexibleLayout o;
    public final TextView p;
    public final TextView q;
    public final CheckableImageButton r;
    public final View s;
    public final ImageView t;
    public final View u;
    @ColorInt
    public final int v;
    public final int w;
    public final int x;
    public final ColorStateList y;
    public final Drawable z;

    public static final class a {
        public final boolean a;
        public final boolean b;

        public a(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            boolean z = this.a;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 * 31;
            boolean z2 = this.b;
            if (!z2) {
                i = z2 ? 1 : 0;
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(isActive=");
            L.append(this.a);
            L.append(", isViewed=");
            return a2.b.a.a.a.B(L, this.b, ")");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public RdsSerpAdvertCardImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.F = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        this.c = textView;
        View findViewById3 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        this.e = (TextView) view.findViewById(R.id.discount);
        this.f = (TextView) view.findViewById(R.id.discount_percentage);
        this.g = (TextView) view.findViewById(R.id.additional_name);
        this.h = (TextView) view.findViewById(R.id.shop_name);
        this.i = (TextView) view.findViewById(R.id.location);
        this.j = (TextView) view.findViewById(R.id.distance);
        this.k = (TextView) view.findViewById(R.id.address);
        this.l = (TextView) view.findViewById(R.id.date);
        this.m = (TextView) view.findViewById(R.id.card_info_badge);
        this.n = (TextView) view.findViewById(R.id.badge);
        this.o = (CompactFlexibleLayout) view.findViewById(R.id.badge_bar);
        this.p = (TextView) view.findViewById(R.id.marketplace_instock);
        this.q = (TextView) view.findViewById(R.id.marketplace_trust_factor);
        View findViewById4 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.r = (CheckableImageButton) findViewById4;
        View findViewById5 = view.findViewById(R.id.safe_deal);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById5;
        View findViewById6 = view.findViewById(R.id.verified_seller);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById6;
        this.t = imageView;
        View findViewById7 = view.findViewById(R.id.delivery);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById7;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.v = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.w = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.blue);
        this.x = view.getResources().getDimensionPixelOffset(R.dimen.rds_highlighted_price_horizontal_padding);
        this.y = textView.getTextColors();
        this.z = textView.getBackground();
        this.A = textView.getPaddingLeft();
        this.B = textView.getPaddingRight();
        Resources resources = this.F.getResources();
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.rds_active_alpha, typedValue, true);
        this.C = typedValue.getFloat();
        resources.getValue(R.dimen.rds_inactive_alpha, typedValue, true);
        this.D = typedValue.getFloat();
        Context context3 = this.F.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        Resources resources2 = context3.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.context.resources");
        this.a = new DateTimeFormatterImpl(timeSource, new DateTimeFormatterResourceProviderImpl(resources2), locale, 1);
        Views.hide(imageView);
    }

    public final void a() {
        TextView textView;
        setActive(this.E.a ? this.C : this.D);
        a aVar = this.E;
        boolean z2 = aVar.a;
        boolean z3 = z2 && (aVar.b ^ true);
        if (z2 && aVar.b) {
            TextView textView2 = this.m;
            if (textView2 != null) {
                Views.show(textView2);
            }
        } else if (z2 && (!aVar.b)) {
            TextView textView3 = this.m;
            if (textView3 != null) {
                Views.hide(textView3);
            }
        } else if ((!z2) && (textView = this.m) != null) {
            Views.hide(textView);
        }
        this.b.setEnabled(z3);
        this.c.setEnabled(z3);
        TextView textView4 = this.h;
        if (textView4 != null) {
            textView4.setEnabled(z3);
        }
        TextView textView5 = this.i;
        if (textView5 != null) {
            textView5.setEnabled(z3);
        }
        TextView textView6 = this.j;
        if (textView6 != null) {
            textView6.setEnabled(z3);
        }
        TextView textView7 = this.k;
        if (textView7 != null) {
            textView7.setEnabled(z3);
        }
        TextView textView8 = this.p;
        if (textView8 != null) {
            textView8.setEnabled(z3);
        }
        TextView textView9 = this.q;
        if (textView9 != null) {
            textView9.setEnabled(z3);
        }
        TextView textView10 = this.l;
        if (textView10 != null) {
            textView10.setEnabled(z3);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void bindBadges(@Nullable List<SerpBadge> list) {
        CompactFlexibleLayout compactFlexibleLayout = this.o;
        if (compactFlexibleLayout != null) {
            BadgeBarsKt.bindBadges$default(compactFlexibleLayout, list, null, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void hideBadge() {
        Views.setVisible(this.n, false);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setActive(boolean z2) {
        this.E = new a(z2, this.E.b);
        a();
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setAdditionalName(@Nullable String str) {
        TextView textView = this.g;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setAddress(@Nullable String str) {
        TextView textView = this.k;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        TextView textView = this.n;
        if (textView != null) {
            Views.setVisible(textView, true);
            BadgesKt.setBadge(this.n, badge);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.F.setOnClickListener(new b(function0));
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDate(long j2) {
        TextView textView = this.l;
        if (textView != null) {
            TextViews.bindText$default(textView, j2 > 0 ? this.a.format(Long.valueOf(j2), TimeUnit.SECONDS) : null, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDeliveryVisible(boolean z2) {
        Views.setVisible(this.u, z2);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDistance(@Nullable String str) {
        TextView textView = this.j;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setFavorite(boolean z2) {
        CheckableImageButton checkableImageButton = this.r;
        Objects.requireNonNull(checkableImageButton, "null cannot be cast to non-null type android.widget.Checkable");
        checkableImageButton.setChecked(z2);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.r, z2);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setInStock(@Nullable String str) {
        TextView textView = this.p;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setLocation(@Nullable String str) {
        TextView textView = this.i;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        TextView textView;
        TextView textView2 = this.e;
        if (textView2 != null && (textView = this.f) != null) {
            SerpAdvertTileCardKt.applyMarketplaceDiscountToViews(textView2, textView, str, str2, false);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.r.setOnClickListener(new c(function0));
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPrice(@Nullable String str, boolean z2) {
        TextViews.bindText$default(this.c, str, false, 2, null);
        if (z2) {
            TextView textView = this.c;
            int i2 = this.x;
            Views.changePadding$default(textView, i2, 0, i2, 0, 10, null);
            this.c.setBackgroundColor(this.w);
            this.c.setTextColor(this.v);
            return;
        }
        Views.changePadding$default(this.c, this.A, 0, this.B, 0, 10, null);
        this.c.setBackground(this.z);
        this.c.setTextColor(this.y);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setSafeDealVisible(boolean z2) {
        Views.setVisible(this.s, z2);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setShopName(@Nullable String str) {
        TextView textView = this.h;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setTrustFactor(@Nullable String str) {
        TextView textView = this.q;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setViewed(boolean z2) {
        this.E = new a(this.E.a, z2);
        a();
    }

    public void setActive(float f2) {
        this.s.setAlpha(f2);
        this.t.setAlpha(f2);
        this.u.setAlpha(f2);
    }
}
