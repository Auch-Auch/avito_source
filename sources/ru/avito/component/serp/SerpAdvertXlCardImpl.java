package ru.avito.component.serp;

import a2.g.r.g;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.CircularGallery;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001a\u0012\u0007\u0010\u0001\u001a\u00020v\u0012\u0006\u0010s\u001a\u00020p¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u001d\u0010 \u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u0010J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010(J\u0019\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b,\u0010\u0010J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010(J\u001f\u00101\u001a\u00020\u00052\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00052\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0016¢\u0006\u0004\b3\u00102J\u0019\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b5\u0010\u0010J\u001f\u00106\u001a\u00020\u00052\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0016¢\u0006\u0004\b6\u00102J\u001f\u00109\u001a\u00020\u00052\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0002H\u0016¢\u0006\u0004\b9\u0010:J%\u0010<\u001a\u00020\u00052\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0002H\u0016¢\u0006\u0004\b?\u0010(J\u0017\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0002H\u0016¢\u0006\u0004\bA\u0010(J\u0017\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020\u001eH\u0016¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bG\u0010\u0010J\u0017\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0005H\u0016¢\u0006\u0004\bL\u0010#J)\u0010Q\u001a\u00020\u00052\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\u001d2\b\u0010P\u001a\u0004\u0018\u00010OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0002H\u0016¢\u0006\u0004\bT\u0010(J\u0019\u0010V\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bV\u0010\u0010J#\u0010X\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010\r2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0002H\u0016¢\u0006\u0004\b_\u0010(R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010bR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010bR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010bR\u0016\u0010x\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010bR\u0018\u0010|\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010wR\u0016\u0010~\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010bR\u001b\u0010\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u0018\u0010\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u0018\u0010\u0001\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010wR\u0019\u0010\u0001\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010wR\u0018\u0010\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u001a\u0010\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u0018\u0010\u0001\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010wR\u0018\u0010\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010bR\u001c\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010¥\u0001\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010hR\u0018\u0010§\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¦\u0001\u0010bR\u0018\u0010©\u0001\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¨\u0001\u0010hR\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010¯\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b®\u0001\u0010bR\u0018\u0010±\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b°\u0001\u0010b¨\u0006´\u0001"}, d2 = {"Lru/avito/component/serp/SerpAdvertXlCardImpl;", "Lru/avito/component/serp/SerpAdvertXlCard;", "", "isActive", "isViewed", "", AuthSource.SEND_ABUSE, "(ZZ)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setupGallerySize", "(II)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "seller", "setSeller", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "isVisible", "setDeliveryVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "actionText", "setCallActionText", "setCallActionListener", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "Lkotlin/Function1;", "setPictureChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "active", "setActive", "viewed", "setViewed", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "oldPrice", "setClassifiedDiscount", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "Lru/avito/component/serp/PhoneLoadingState;", "state", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "hasVideo", "setHasVideo", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "priceWithoutDiscountView", "f", "titleView", "", "y", "F", "activeAlpha", "k", FirebaseAnalytics.Param.DISCOUNT, "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "fieldsContainer", "Lru/avito/component/serp/SerpItemViewConfig;", ExifInterface.LONGITUDE_EAST, "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", g.a, "sellerView", "Landroid/view/View;", "Landroid/view/View;", "advertContent", "d", "badgeView", VKApiConst.VERSION, "delivery", "o", "dateView", "Landroid/widget/ImageView;", "w", "Landroid/widget/ImageView;", "hasVideoBadge", "u", "additionalNameView", "i", "priceView", "r", "callButton", "C", "I", "titleRightMargin", "Lru/avito/component/serp/cyclic_gallery/CircularGallery;", "B", "Lru/avito/component/serp/cyclic_gallery/CircularGallery;", "gallery", "s", "phoneLoader", "t", "callButtonText", "l", "discountView", "D", "view", "h", "locationView", "Lcom/google/android/material/internal/CheckableImageButton;", VKApiConst.Q, "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "c", "infoBadge", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "e", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "viewedAlpha", "n", "addressView", "z", "inactiveAlpha", "Lru/avito/component/serp/HighlightDelegate;", "x", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", AuthSource.OPEN_CHANNEL_LIST, "discountPercentageView", "p", "descriptionView", "<init>", "(Landroid/view/View;Lru/avito/component/serp/SerpItemViewConfig;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertXlCardImpl implements SerpAdvertXlCard {
    public final float A;
    public final CircularGallery B;
    public final int C;
    public final View D;
    public final SerpItemViewConfig E;
    public final View a;
    public final ViewGroup b;
    public final TextView c;
    public final TextView d;
    public final CompactFlexibleLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final CheckableImageButton q;
    public final View r;
    public final View s;
    public final TextView t;
    public final TextView u;
    public final View v;
    public final ImageView w;
    public final HighlightDelegate x;
    public final float y;
    public final float z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneLoadingState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
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

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(SerpAdvertXlCardImpl serpAdvertXlCardImpl, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public SerpAdvertXlCardImpl(@NotNull View view, @NotNull SerpItemViewConfig serpItemViewConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        this.D = view;
        this.E = serpItemViewConfig;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewWithTag = view.findViewWithTag("fieldsContainer");
        Intrinsics.checkNotNullExpressionValue(findViewWithTag, "view.findViewWithTag(\"fieldsContainer\")");
        this.b = (ViewGroup) findViewWithTag;
        View findViewById2 = view.findViewById(R.id.card_info_badge);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        this.d = (TextView) view.findViewById(R.id.badge);
        this.e = (CompactFlexibleLayout) view.findViewById(R.id.badge_bar);
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.seller);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById6;
        this.i = textView;
        View findViewById7 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById7;
        int i2 = R.id.discount;
        View findViewById8 = view.findViewById(i2);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById8;
        this.k = textView2;
        this.l = (TextView) view.findViewById(i2);
        this.m = (TextView) view.findViewById(R.id.discount_percentage);
        View findViewById9 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.n = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.o = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.p = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.q = (CheckableImageButton) findViewById12;
        View findViewById13 = view.findViewById(R.id.call_button);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.view.View");
        this.r = findViewById13;
        View findViewById14 = view.findViewById(R.id.phone_loader);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById14;
        View findViewById15 = view.findViewById(R.id.call_button_text);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById15;
        this.u = (TextView) view.findViewById(R.id.additional_name);
        this.v = view.findViewById(R.id.delivery);
        ImageView imageView = (ImageView) view.findViewById(R.id.has_video);
        this.w = imageView;
        this.x = new PriceHighlightDelegate(textView, false, serpItemViewConfig.isTextPrefetchEnabled());
        View findViewById16 = view.findViewById(R.id.pager);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.view.View");
        this.B = new CircularGallery(findViewById16, R.layout.advert_xl_image_page);
        this.C = view.getResources().getDimensionPixelSize(R.dimen.xl_advert_title_margin_right);
        TypedValue typedValue = new TypedValue();
        this.D.getResources().getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.z = typedValue.getFloat();
        this.D.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        this.y = typedValue.getFloat();
        this.D.getResources().getValue(R.dimen.viewed_alpha, typedValue, true);
        this.A = typedValue.getFloat();
        if (imageView != null) {
            imageView.setBackground(BadgesKt.getBadgeBackground$default(this.D, null, 1, null));
        }
        if (this.E.isPriceOnTop()) {
            SerpAdvertTileCardKt.lowerDownTitle(this.b, this.f, textView2);
        }
    }

    public final void a(boolean z2, boolean z3) {
        if (z2 && z3) {
            this.a.setAlpha(this.A);
            Views.show(this.c);
        } else if (z2 && (!z3)) {
            this.a.setAlpha(this.y);
            Views.hide(this.c);
        } else if (!z2) {
            this.a.setAlpha(this.z);
            Views.hide(this.c);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        CompactFlexibleLayout compactFlexibleLayout = this.e;
        if (compactFlexibleLayout != null) {
            BadgeBarsKt.bindBadges(compactFlexibleLayout, list, badgeViewListener);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void clearPictures() {
        this.B.setPictures(CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        View findViewById = this.D.findViewById(R.id.pager);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        return picture.getUri(findViewById);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void hideBadge() {
        Views.setVisible(this.d, false);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setActive(boolean z2) {
        boolean z3 = this.a.getAlpha() == this.A;
        this.D.setClickable(z2);
        a(z2, z3);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setAdditionalName(@Nullable String str) {
        TextView textView = this.u;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.E.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setAddress(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.n, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        TextView textView = this.d;
        if (textView != null) {
            Views.setVisible(textView, true);
            BadgesKt.setBadge(this.d, badge);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCallActionListener(@Nullable Function0<Unit> function0) {
        this.r.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCallActionText(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.t, str, this.E.isTextPrefetchEnabled());
        Views.setVisible(this.r, str != null);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setClassifiedDiscount(@Nullable String str) {
        SerpAdvertTileCardKt.applyClassifiedDiscountToViews$default(this.k, this.i, str, this.E.isTextPrefetchEnabled(), false, 16, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.D.setOnClickListener(null);
            this.B.setOnClickListener(null);
            return;
        }
        this.D.setOnClickListener(new b(function0));
        this.B.setOnClickListener(new c(function0));
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCurrentPicture(int i2, boolean z2) {
        this.B.setCurrentPicture(i2, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDate(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.o, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDeliveryVisible(boolean z2) {
        View view = this.v;
        if (view == null) {
            TextViews.setCompoundDrawables$default(this.i, 0, 0, z2 ? R.drawable.ic_delivery_16 : 0, 0, 11, (Object) null);
        } else {
            Views.setVisible(view, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDescription(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.p, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setFavorite(boolean z2) {
        CheckableImageButton checkableImageButton = this.q;
        Objects.requireNonNull(checkableImageButton, "null cannot be cast to non-null type android.widget.Checkable");
        checkableImageButton.setChecked(z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.q, z2);
        int i2 = this.C;
        if (i2 != 0) {
            if (!z2) {
                i2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i2;
            this.f.requestLayout();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setHasVideo(boolean z2) {
        ImageView imageView = this.w;
        if (imageView != null) {
            Views.setVisible(imageView, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setLocation(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.h, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        TextView textView;
        TextView textView2 = this.l;
        if (textView2 != null && (textView = this.m) != null) {
            SerpAdvertTileCardKt.applyMarketplaceDiscountToViews(textView2, textView, str, str2, this.E.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.q.setOnClickListener(new d(this, function0));
        } else {
            this.q.setOnClickListener(null);
        }
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.r.setEnabled(phoneLoadingState == PhoneLoadingState.IDLE);
        if (phoneLoadingState.ordinal() != 1) {
            Views.show(this.t);
            Views.hide(this.s);
            return;
        }
        Views.conceal(this.t);
        Views.show(this.s);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPictureChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.B.setPictureChangeListener(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.B.setPictures(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPrice(@Nullable String str, boolean z2) {
        this.x.setText(str, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        TextViews.bindText$default(this.j, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setSeller(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.g, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        PrecomputedTextViewKt.bindTextAsync(this.f, str, this.E.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setVideoIconEnlarged(boolean z2) {
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setImageResource(z2 ? R.drawable.ic_video_17 : R.drawable.video_16);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setViewed(boolean z2) {
        a(this.a.getAlpha() != this.z, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setupGallerySize(int i2, int i3) {
        this.B.setupSize(i2, i3);
    }
}
