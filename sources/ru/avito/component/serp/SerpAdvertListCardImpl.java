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
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B:\u0012\u0007\u0010\u0001\u001a\u00020k\u0012\b\u0010Ä\u0001\u001a\u00030Ã\u0001\u0012\b\u0010Æ\u0001\u001a\u00030Å\u0001\u0012\b\b\u0002\u0010r\u001a\u00020o\u0012\b\u0010º\u0001\u001a\u00030·\u0001¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ#\u0010\u0016\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ!\u0010 \u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u0017J!\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\u0017J!\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b(\u0010\u000bJ\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010+J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010+J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0002H\u0017¢\u0006\u0004\b3\u0010+J\u0017\u00104\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u0010+J\u001f\u00107\u001a\u00020\u00052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u00020\u00052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000105H\u0016¢\u0006\u0004\b9\u00108J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0002H\u0016¢\u0006\u0004\b;\u0010+J\u0017\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010A\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bA\u0010\u000bJ\u0017\u0010C\u001a\u00020B2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0005H\u0016¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bH\u0010\u000bJ\u001f\u0010I\u001a\u00020\u00052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000105H\u0016¢\u0006\u0004\bI\u00108J\u0019\u0010J\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bJ\u0010\u000bJ\u0017\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0005H\u0016¢\u0006\u0004\bO\u0010FJ)\u0010U\u001a\u00020\u00052\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0002H\u0016¢\u0006\u0004\bX\u0010+J\u0019\u0010Z\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bZ\u0010\u000bJ#\u0010\\\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\b2\b\u0010[\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0002H\u0016¢\u0006\u0004\b_\u0010+J\u0019\u0010a\u001a\u00020\u00052\b\u0010`\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\ba\u0010\u000bJ\u0019\u0010b\u001a\u00020\u00052\b\u0010`\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bb\u0010\u000bR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010iR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010~R\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010mR\u0018\u0010\u0001\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010¡\u0001\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b \u0001\u0010iR\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010§\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010\u0001R\u001a\u0010ª\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010®\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R\u001a\u0010°\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¯\u0001\u0010iR\u001a\u0010²\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b±\u0001\u0010iR\u001a\u0010´\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b³\u0001\u0010iR\u001a\u0010¶\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¤\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001a\u0010¼\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b»\u0001\u0010iR\u001a\u0010¾\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010iR\u0018\u0010À\u0001\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¿\u0001\u0010iR\u0018\u0010Â\u0001\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÁ\u0001\u0010i¨\u0006É\u0001"}, d2 = {"Lru/avito/component/serp/SerpAdvertListCardImpl;", "Lru/avito/component/serp/SerpAdvertListCard;", "", "isActive", "isViewed", "", AuthSource.SEND_ABUSE, "(ZZ)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", Sort.DISTANCE, "setDistance", "", "time", "setDate", "(J)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "setRadiusAddress", "setRadiusLocation", "Lcom/avito/android/image_loader/Picture;", "picture", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "enabled", "setFavoriteButtonEnabled", "visible", "setFavoriteVisible", "favorite", "setFavorite", "setTitleRightMarginEnabled", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "isShowDelivery", "setDeliveryVisible", "", "widthPx", "setWidth", "(I)V", "tag", "setShortTermRentTag", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "setFavoritesButtonImageResource", "()V", "text", "setAdditionalActionText", "setOnAdditionalActionClickListener", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "oldPrice", "setClassifiedDiscount", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "hasVideo", "setHasVideo", "value", "setInStock", "setTrustFactor", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/TextView;", "discountPercentageView", "Landroid/view/View;", "z", "Landroid/view/View;", "delivery", "Lru/avito/component/serp/SerpItemViewConfig;", "H", "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", "Lru/avito/component/serp/HighlightDelegate;", "B", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", "w", "trustFactorView", "Landroid/content/res/Resources;", "x", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "n", "shortTermRentTagTextView", "Lcom/avito/android/image_loader/ForegroundConverter;", "C", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "t", "badgeView", "l", "discountView", "o", "dateView", "r", "additionalNameView", "Landroid/widget/ImageView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "hasVideoBadge", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "u", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "G", "view", "p", "addressView", "k", "priceWithoutDiscountView", "", "D", "F", "activeAlpha", "s", "infoBadge", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "additionalFieldsContainer", AuthSource.BOOKING_ORDER, "advertContent", ExifInterface.LONGITUDE_EAST, "inactiveAlpha", "viewedAlpha", "Lcom/google/android/material/internal/CheckableImageButton;", "y", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", g.a, "locationView", VKApiConst.VERSION, "instockView", VKApiConst.Q, "additionalActionView", "c", "fieldsContainer", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "I", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "h", "distanceView", "f", "shopNameView", "j", "priceView", "i", "titleView", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lru/avito/component/serp/SerpItemViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertListCardImpl implements SerpAdvertListCard {
    public final ImageView A;
    public final HighlightDelegate B;
    public final ForegroundConverter C;
    public final float D;
    public final float E;
    public final float F;
    public final View G;
    public final SerpItemViewConfig H;
    public final ConnectivityProvider I;
    public final DateTimeFormatter a;
    public final ViewGroup b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final SimpleDraweeView e;
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
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final CompactFlexibleLayout u;
    public final TextView v;
    public final TextView w;
    public final Resources x;
    public final CheckableImageButton y;
    public final View z;

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

    public static final class b implements Runnable {
        public final /* synthetic */ SerpAdvertListCardImpl a;
        public final /* synthetic */ RadiusInfo b;
        public final /* synthetic */ String c;

        public b(SerpAdvertListCardImpl serpAdvertListCardImpl, RadiusInfo radiusInfo, String str) {
            this.a = serpAdvertListCardImpl;
            this.b = radiusInfo;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RadiusInfo radiusInfo = this.b;
            if (radiusInfo != null) {
                this.a.setRadiusLocation(this.c, radiusInfo);
            } else {
                this.a.setLocation(this.c);
            }
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
        public final /* synthetic */ SerpAdvertListCardImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SerpAdvertListCardImpl serpAdvertListCardImpl) {
            super(0);
            this.a = serpAdvertListCardImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(this.a.I.isConnectionAvailable());
        }
    }

    public SerpAdvertListCardImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemViewConfig serpItemViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.G = view;
        this.H = serpItemViewConfig;
        this.I = connectivityProvider;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.fields_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById2;
        this.d = (ViewGroup) view.findViewById(R.id.additional_fields_container);
        View findViewById3 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.e = (SimpleDraweeView) findViewById3;
        this.f = (TextView) view.findViewById(R.id.shop_name);
        this.g = (TextView) view.findViewById(R.id.location);
        this.h = (TextView) view.findViewById(R.id.distance);
        View findViewById4 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById5;
        this.j = textView;
        this.k = (TextView) view.findViewById(R.id.price_without_discount);
        this.l = (TextView) view.findViewById(R.id.discount);
        this.m = (TextView) view.findViewById(R.id.discount_percentage);
        TextView textView2 = (TextView) view.findViewById(R.id.short_term_rent_tag);
        this.n = textView2;
        TextView textView3 = (TextView) view.findViewById(R.id.date);
        this.o = textView3;
        View findViewById6 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.p = (TextView) findViewById6;
        this.q = (TextView) view.findViewById(R.id.additional_action);
        this.r = (TextView) view.findViewById(R.id.additional_name);
        View findViewById7 = view.findViewById(R.id.card_info_badge);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById7;
        this.t = (TextView) view.findViewById(R.id.badge);
        this.u = (CompactFlexibleLayout) view.findViewById(R.id.badge_bar);
        this.v = (TextView) view.findViewById(R.id.marketplace_instock);
        this.w = (TextView) view.findViewById(R.id.marketplace_trust_factor);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.x = resources;
        View findViewById8 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.y = (CheckableImageButton) findViewById8;
        this.z = view.findViewById(R.id.delivery);
        ImageView imageView = (ImageView) this.G.findViewById(R.id.has_video);
        this.A = imageView;
        this.B = new PriceHighlightDelegate(textView, false, this.H.isTextPrefetchEnabled());
        this.C = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
        TypedValue typedValue = new TypedValue();
        this.G.getResources().getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.E = typedValue.getFloat();
        this.G.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        this.D = typedValue.getFloat();
        this.G.getResources().getValue(R.dimen.viewed_alpha, typedValue, true);
        this.F = typedValue.getFloat();
        Context context = this.G.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources2 = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.context.resources");
        this.a = new DateTimeFormatterImpl(timeSource, new DateTimeFormatterResourceProviderImpl(resources2), locale, 1);
        if (imageView != null) {
            imageView.setBackground(BadgesKt.getBadgeBackground$default(this.G, null, 1, null));
        }
        if (this.H.isPriceOnTop()) {
            ViewGroup viewGroup = this.c;
            TextView textView4 = this.i;
            TextView textView5 = this.l;
            SerpAdvertTileCardKt.lowerDownTitle(viewGroup, textView4, textView5 == null ? this.j : textView5);
            int dpToPx = Views.dpToPx(this.G, 3);
            ViewGroup viewGroup2 = this.d;
            if (viewGroup2 != null) {
                Views.changeMargin$default(viewGroup2, 0, dpToPx, 0, 0, 13, null);
            }
            if (textView2 != null) {
                Views.changeMargin$default(textView2, 0, dpToPx, 0, 0, 13, null);
            }
            if (textView3 != null) {
                Views.changeMargin$default(textView3, 0, dpToPx, 0, 0, 13, null);
            }
            Views.changeMargin$default(this.i, 0, dpToPx, 0, 0, 5, null);
        }
    }

    public final void a(boolean z2, boolean z3) {
        if (z2 && z3) {
            this.b.setAlpha(this.F);
            Views.show(this.s);
        } else if (z2 && (!z3)) {
            this.b.setAlpha(this.D);
            Views.hide(this.s);
        } else if (!z2) {
            this.b.setAlpha(this.E);
            Views.hide(this.s);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void bindBadgeBar(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        CompactFlexibleLayout compactFlexibleLayout = this.u;
        if (compactFlexibleLayout != null) {
            BadgeBarsKt.bindBadges(compactFlexibleLayout, list, badgeViewListener);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return picture.getUri(this.e);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void hideBadge() {
        Views.setVisible(this.t, false);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setActive(boolean z2) {
        a(z2, this.b.getAlpha() == this.F);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalActionText(@Nullable String str) {
        TextView textView = this.q;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalName(@Nullable String str) {
        TextView textView = this.r;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAddress(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.p, str, this.H.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        TextView textView = this.t;
        if (textView != null) {
            Views.setVisible(textView, true);
            BadgesKt.setBadge(this.t, badge);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClassifiedDiscount(@Nullable String str) {
        TextView textView = this.l;
        if (textView != null) {
            SerpAdvertTileCardKt.applyClassifiedDiscountToViews$default(textView, this.j, str, this.H.isTextPrefetchEnabled(), false, 16, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.G.setOnClickListener(null);
        } else {
            this.G.setOnClickListener(new a(function0));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDate(long j2) {
        TextView textView = this.o;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, j2 > 0 ? this.a.format(Long.valueOf(j2), TimeUnit.SECONDS) : null, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDeliveryVisible(boolean z2) {
        View view = this.z;
        if (view == null) {
            TextViews.setCompoundDrawables$default(this.j, 0, 0, z2 ? R.drawable.ic_delivery_16 : 0, 0, 11, (Object) null);
        } else {
            Views.setVisible(view, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDistance(@Nullable String str) {
        TextView textView = this.h;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2) {
        this.y.setChecked(z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteButtonEnabled(boolean z2) {
        this.y.setEnabled(z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.y, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoritesButtonImageResource() {
        this.y.setImageResource(R.drawable.advert_item_list_favorite_red);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setHasVideo(boolean z2) {
        ImageView imageView = this.A;
        if (imageView != null) {
            Views.setVisible(imageView, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setInStock(@Nullable String str) {
        TextView textView = this.v;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocation(@Nullable String str) {
        TextView textView = this.g;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocationPostponed(@Nullable String str, @Nullable RadiusInfo radiusInfo) {
        TextView textView = this.g;
        if (textView != null) {
            textView.post(new b(this, radiusInfo, str));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        TextView textView;
        TextView textView2 = this.l;
        if (textView2 != null && (textView = this.m) != null) {
            SerpAdvertTileCardKt.applyMarketplaceDiscountToViews(textView2, textView, str, str2, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            TextView textView = this.q;
            if (textView != null) {
                textView.setOnClickListener(null);
                return;
            }
            return;
        }
        TextView textView2 = this.q;
        if (textView2 != null) {
            textView2.setOnClickListener(new c(function0));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.y.setOnClickListener(null);
        } else {
            this.y.setOnClickListener(new d(function0));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        ForegroundConverter foregroundConverter = this.C;
        Context context = this.G.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        SimpleDraweeViewsKt.getRequestBuilder(this.e).picture(picture).foreground(ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null)).sourcePlace(ImageRequest.SourcePlace.SNIPPET).advertId(str).isConnectionAvailable(new e(this)).load();
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPrice(@Nullable String str, boolean z2) {
        this.B.setText(str, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        TextView textView = this.k;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        PrecomputedTextViewKt.bindTextAsync(this.p, SerpAdvertTileCardKt.applyRadiusInfoSpan(new SpannableString(SerpAdvertTileCardKt.formatGeoAddress(str, radiusInfo)), radiusInfo), this.H.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        TextView textView = this.g;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, SerpAdvertTileCardKt.applyRadiusInfoSpan(new SpannableString(SerpAdvertTileCardKt.formatGeoAddress(str, radiusInfo)), radiusInfo), this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShopName(@Nullable String str) {
        TextView textView = this.f;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShortTermRentTag(@Nullable String str) {
        TextView textView = this.n;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.H.isTextPrefetchEnabled());
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        PrecomputedTextViewKt.bindTextAsync(this.i, str, this.H.isTextPrefetchEnabled());
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitleRightMarginEnabled(boolean z2) {
        int dimensionPixelSize = z2 ? this.x.getDimensionPixelSize(R.dimen.list_serp_card_title_right_margin) : 0;
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelSize;
        this.i.requestLayout();
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTrustFactor(@Nullable String str) {
        TextView textView = this.w;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setVideoIconEnlarged(boolean z2) {
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setImageResource(z2 ? R.drawable.ic_video_17 : R.drawable.video_16);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setViewed(boolean z2) {
        a(this.b.getAlpha() != this.E, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setWidth(int i2) {
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        layoutParams.width = i2;
        this.G.setLayoutParams(layoutParams);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpAdvertListCardImpl(View view, TimeSource timeSource, Locale locale, SerpItemViewConfig serpItemViewConfig, ConnectivityProvider connectivityProvider, int i2, j jVar) {
        this(view, timeSource, locale, (i2 & 8) != 0 ? new SerpItemDefaultViewConfig(null, 1, null) : serpItemViewConfig, connectivityProvider);
    }
}
