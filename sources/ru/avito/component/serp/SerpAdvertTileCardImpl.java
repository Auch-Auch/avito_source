package ru.avito.component.serp;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewPropertyAnimatorUtilKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.drawee.view.SimpleDraweeView;
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
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¿\u0001\u001a\u00030¾\u0001\u0012\b\u0010Á\u0001\u001a\u00030À\u0001\u0012\b\u0010©\u0001\u001a\u00030¦\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ!\u0010\u0016\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ!\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010(J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010(J\u001f\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0017¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u00020\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000502H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\u00020\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000502H\u0016¢\u0006\u0004\b6\u00105J\u0017\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0002H\u0016¢\u0006\u0004\b8\u0010(J\u0017\u0010:\u001a\u0002092\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0002H\u0016¢\u0006\u0004\b=\u0010(J\u0019\u0010?\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b?\u0010\u000bJ\u0017\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0005H\u0016¢\u0006\u0004\bD\u0010EJ)\u0010K\u001a\u00020\u00052\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0002H\u0016¢\u0006\u0004\bN\u0010(J%\u0010P\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00022\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000502H\u0016¢\u0006\u0004\bP\u0010QJ\u001f\u0010T\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u0002H\u0016¢\u0006\u0004\bT\u0010\u0007J\u0019\u0010V\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bV\u0010\u000bJ#\u0010Y\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010\b2\b\u0010X\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b[\u0010\u000bJ\u001f\u0010\\\u001a\u00020\u00052\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000102H\u0016¢\u0006\u0004\b\\\u00105J\u0017\u0010^\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0002H\u0016¢\u0006\u0004\b^\u0010(J\u0019\u0010`\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b`\u0010\u000bJ\u0019\u0010a\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\ba\u0010\u000bR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010dR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010dR\u0016\u0010s\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010dR\u0018\u0010u\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010dR\u0018\u0010w\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010dR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bz\u0010\u0001R\u0018\u0010\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010<\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010\u0001R\u0018\u0010\u0001\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010hR\u001a\u0010\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u0018\u0010\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010dR\u001a\u0010£\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010¥\u0001\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010zR\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010«\u0001\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bª\u0001\u0010dR\u001a\u0010¯\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001a\u0010µ\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010dR\u0018\u0010·\u0001\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¶\u0001\u0010zR\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010\u0001R\u001c\u0010»\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bº\u0001\u0010\u0001R\u001a\u0010½\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¼\u0001\u0010d¨\u0006Ä\u0001"}, d2 = {"Lru/avito/component/serp/SerpAdvertTileCardImpl;", "Lru/avito/component/serp/SerpAdvertTileCard;", "", "isActive", "isViewed", "", AuthSource.SEND_ABUSE, "(ZZ)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setRadiusLocation", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setRadiusAddress", "", "time", "setDate", "(J)V", "setAddress", "Lcom/avito/android/image_loader/Picture;", "picture", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "visible", "setFavoriteVisible", "favorite", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "setFavorite", "(ZLcom/avito/android/remote/model/SerpDisplayType;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "isShowDelivery", "setDeliveryVisible", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "isDoubleItem", "setIsDoubleItem", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "()V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "callback", "setMoreActions", "(ZLkotlin/jvm/functions/Function0;)V", PanelStateKt.PANEL_HIDDEN, "animated", "showHiddenStub", "newPrice", "setClassifiedDiscount", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setAdditionalActionText", "setOnAdditionalActionClickListener", "hasVideo", "setHasVideo", "value", "setInStock", "setTrustFactor", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "priceView", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "textContent", "x", "additionalAction", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "t", "additionalNameView", g.a, "titleView", "o", "badgeView", "l", "dateView", "", "B", "F", "activeAlpha", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "p", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "e", "shopNameView", "Landroid/view/View;", "Landroid/view/View;", "view", AuthSource.OPEN_CHANNEL_LIST, "addressView", "w", "delivery", ExifInterface.LONGITUDE_EAST, "Z", "f", "locationView", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", AuthSource.BOOKING_ORDER, "advertContent", "r", "trustFactorView", "Lcom/google/android/material/internal/CheckableImageButton;", "s", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "Lru/avito/component/serp/SerpItemViewConfig;", "G", "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", "i", "priceWithoutDiscountView", "n", "infoBadge", "Lru/avito/component/serp/HighlightDelegate;", "z", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", "D", "viewedAlpha", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "H", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "j", "discountView", "Lcom/avito/android/image_loader/ForegroundConverter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "Landroid/widget/ImageView;", "y", "Landroid/widget/ImageView;", "hasVideoBadge", VKApiConst.Q, "instockView", "C", "inactiveAlpha", VKApiConst.VERSION, "hiddenStub", "u", "moreActionsButton", "k", "discountPercentageView", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lru/avito/component/serp/SerpItemViewConfig;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertTileCardImpl implements SerpAdvertTileCard {
    public final ForegroundConverter A = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public final float B;
    public final float C;
    public final float D;
    public boolean E;
    public final View F;
    public final SerpItemViewConfig G;
    public final ConnectivityProvider H;
    public final DateTimeFormatter a;
    public final ViewGroup b;
    public final ViewGroup c;
    public final SimpleDraweeView d;
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
    public final TextView o;
    public final CompactFlexibleLayout p;
    public final TextView q;
    public final TextView r;
    public final CheckableImageButton s;
    public final TextView t;
    public final View u;
    public final View v;
    public final View w;
    public final TextView x;
    public final ImageView y;
    public final HighlightDelegate z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
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
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class e extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ SerpAdvertTileCardImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SerpAdvertTileCardImpl serpAdvertTileCardImpl) {
            super(0);
            this.a = serpAdvertTileCardImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(this.a.H.isConnectionAvailable());
        }
    }

    public SerpAdvertTileCardImpl(@NotNull View view, @NotNull SerpItemViewConfig serpItemViewConfig, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.F = view;
        this.G = serpItemViewConfig;
        this.H = connectivityProvider;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.text_content);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.d = (SimpleDraweeView) findViewById3;
        View findViewById4 = view.findViewById(R.id.shop_name);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById7;
        this.h = textView;
        View findViewById8 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById9;
        this.j = textView2;
        this.k = (TextView) view.findViewById(R.id.discount_percentage);
        this.l = (TextView) view.findViewById(R.id.date);
        View findViewById10 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.card_info_badge);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.n = (TextView) findViewById11;
        this.o = (TextView) view.findViewById(R.id.badge);
        this.p = (CompactFlexibleLayout) view.findViewById(R.id.badge_bar);
        this.q = (TextView) view.findViewById(R.id.marketplace_instock);
        this.r = (TextView) view.findViewById(R.id.marketplace_trust_factor);
        View findViewById12 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.s = (CheckableImageButton) findViewById12;
        this.t = (TextView) view.findViewById(R.id.additional_name);
        this.u = view.findViewById(R.id.more_actions_button);
        this.v = view.findViewById(R.id.hidden_stub);
        this.w = view.findViewById(R.id.delivery);
        this.x = (TextView) view.findViewById(R.id.additional_action);
        ImageView imageView = (ImageView) view.findViewById(R.id.has_video);
        this.y = imageView;
        this.z = new PriceHighlightDelegate(textView, false, serpItemViewConfig.isTextPrefetchEnabled());
        Views.dpToPx(this.F, 18);
        TypedValue typedValue = new TypedValue();
        this.F.getResources().getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.C = typedValue.getFloat();
        this.F.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        this.B = typedValue.getFloat();
        this.F.getResources().getValue(R.dimen.viewed_alpha, typedValue, true);
        this.D = typedValue.getFloat();
        Context context = this.F.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
        this.a = new DateTimeFormatterImpl(timeSource, new DateTimeFormatterResourceProviderImpl(resources), locale, 1);
        if (imageView != null) {
            imageView.setBackground(BadgesKt.getBadgeBackground$default(this.F, null, 1, null));
        }
        if (this.G.isPriceOnTop()) {
            SerpAdvertTileCardKt.lowerDownTitle(this.c, this.g, textView2);
        }
    }

    public final void a(boolean z2, boolean z3) {
        if (z2 && z3) {
            this.b.setAlpha(this.D);
            Views.show(this.n);
        } else if (z2 && (!z3)) {
            this.b.setAlpha(this.B);
            Views.hide(this.n);
        } else if (!z2) {
            this.b.setAlpha(this.C);
            Views.hide(this.n);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        CompactFlexibleLayout compactFlexibleLayout = this.p;
        if (compactFlexibleLayout != null) {
            BadgeBarsKt.bindBadges(compactFlexibleLayout, list, badgeViewListener);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return picture.getUri(this.d);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void hideBadge() {
        Views.setVisible(this.o, false);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setActive(boolean z2) {
        a(z2, this.b.getAlpha() == this.D);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAdditionalActionText(@Nullable String str) {
        TextView textView = this.x;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAdditionalName(@Nullable String str) {
        TextView textView = this.t;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.G.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAddress(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.m, str, this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        TextView textView = this.o;
        if (textView != null) {
            Views.setVisible(textView, true);
            BadgesKt.setBadge(this.o, badge);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setClassifiedDiscount(@Nullable String str) {
        SerpAdvertTileCardKt.applyClassifiedDiscountToViews$default(this.j, this.h, str, this.G.isTextPrefetchEnabled(), false, 16, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.F.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setDate(long j2) {
        TextView textView = this.l;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, j2 > 0 ? this.a.format(Long.valueOf(j2), TimeUnit.SECONDS) : null, this.G.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setDeliveryVisible(boolean z2) {
        View view = this.w;
        if (view == null) {
            TextViews.setCompoundDrawables$default(this.h, 0, 0, z2 ? R.drawable.ic_delivery_16 : 0, 0, 11, (Object) null);
        } else {
            Views.setVisible(view, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.s.setChecked(z2);
        if (this.E && serpDisplayType.isList()) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.rightMargin = Views.dpToPx(this.F, 6);
            }
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.s, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setHasVideo(boolean z2) {
        ImageView imageView = this.y;
        if (imageView != null) {
            Views.setVisible(imageView, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setInStock(@Nullable String str) {
        TextView textView = this.q;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setIsDoubleItem(boolean z2) {
        this.E = z2;
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setLocation(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.f, str, this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        TextView textView;
        TextView textView2 = this.j;
        if (textView2 != null && (textView = this.k) != null) {
            SerpAdvertTileCardKt.applyMarketplaceDiscountToViews(textView2, textView, str, str2, this.G.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setMoreActions(boolean z2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        View view = this.u;
        if (view != null) {
            Views.setVisible(view, z2);
            this.u.setOnClickListener(new b(function0));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setOnClickListener(new c(function0));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new d(function0));
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        ForegroundConverter foregroundConverter = this.A;
        Context context = this.F.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        SimpleDraweeViewsKt.getRequestBuilder(this.d).picture(picture).foreground(ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null)).sourcePlace(ImageRequest.SourcePlace.SNIPPET).advertId(str).isConnectionAvailable(new e(this)).load();
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPrice(@Nullable String str, boolean z2) {
        this.z.setText(str, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        TextViews.bindText$default(this.i, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        PrecomputedTextViewKt.bindTextAsync(this.m, SerpAdvertTileCardKt.applyRadiusInfoSpan(new SpannableString(SerpAdvertTileCardKt.formatGeoAddress(str, radiusInfo)), radiusInfo), this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        PrecomputedTextViewKt.bindTextAsync(this.f, SerpAdvertTileCardKt.applyRadiusInfoSpan(new SpannableString(SerpAdvertTileCardKt.applyRadiusInfoSpan(new SpannableString(SerpAdvertTileCardKt.formatGeoAddress(str, radiusInfo)), radiusInfo)), radiusInfo), this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setShopName(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.e, str, this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        PrecomputedTextViewKt.bindTextAsync(this.g, str, this.G.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setTrustFactor(@Nullable String str) {
        TextView textView = this.r;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setVideoIconEnlarged(boolean z2) {
        ImageView imageView = this.y;
        if (imageView != null) {
            imageView.setImageResource(z2 ? R.drawable.ic_video_17 : R.drawable.video_16);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setViewed(boolean z2) {
        a(this.b.getAlpha() != this.C, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void showHiddenStub(boolean z2, boolean z3) {
        View view = this.v;
        if (view != null) {
            if (!z2) {
                Views.hide(view);
                Views.show(this.b);
            } else if (view != null) {
                Views.show(view);
                if (z3) {
                    this.v.setAlpha(0.0f);
                    ViewPropertyAnimator duration = this.v.animate().alpha(1.0f).setDuration(200);
                    Intrinsics.checkNotNullExpressionValue(duration, "hiddenStub.animate()\n   …_STUB_ANIMATION_DURATION)");
                    ViewPropertyAnimatorUtilKt.withEnd(duration, new a7.a.a.g.b(this)).start();
                    return;
                }
                this.v.setAlpha(1.0f);
                Views.conceal(this.b);
            }
        }
    }
}
