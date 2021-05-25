package com.avito.android.favorite_sellers;

import a2.a.a.s0.a0;
import a2.a.a.s0.b0;
import a2.a.a.s0.c0;
import a2.a.a.s0.d0;
import a2.a.a.s0.e0;
import a2.a.a.s0.f0;
import a2.a.a.s0.g0;
import a2.a.a.s0.x;
import a2.a.a.s0.y;
import a2.a.a.s0.z;
import android.net.Uri;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.FavoriteSeller;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscribeSellerButtonEvent;
import com.avito.android.analytics.event.favorite.UnsubscribeSellerButtonEvent;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEventKt;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.favorite_sellers.FavoriteSellersPresenter;
import com.avito.android.favorite_sellers.action.DeepLinkAction;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.action.OpenSubscriptionSettings;
import com.avito.android.favorite_sellers.adapter.error.ErrorItem;
import com.avito.android.favorite_sellers.adapter.error.action.ErrorItemAction;
import com.avito.android.favorite_sellers.adapter.info.InfoItem;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItem;
import com.avito.android.favorite_sellers.adapter.loading.action.LoadingItemAction;
import com.avito.android.favorite_sellers.adapter.seller.SellerItem;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Singles;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002Ä\u0001Bä\u0001\b\u0007\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010\u001a\u00020|\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020i0h\u0012\u0006\u0010V\u001a\u00020S\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010©\u0001\u001a\u00030¦\u0001\u0012\u0006\u0010v\u001a\u00020s\u0012\b\u0010·\u0001\u001a\u00030´\u0001\u0012\b\u0010¡\u0001\u001a\u00030\u0001\u0012\u0006\u0010`\u001a\u00020]\u0012\b\u0010¥\u0001\u001a\u00030¢\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010»\u0001\u001a\u00030¸\u0001\u0012\b\u0010²\u0001\u001a\u00030¯\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\b\u0001\u0010J\u001a\u00020G\u0012\b\u0010À\u0001\u001a\u00030¿\u0001\u0012\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010y\u001a\u00020w\u0012\u000e\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010h\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010r\u001a\u00020m¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\u0015J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0015J\u0019\u0010*\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u001aH\u0002¢\u0006\u0004\b*\u0010\u001dJ<\u00103\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+2#\b\u0002\u00102\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00050-H\u0002¢\u0006\u0004\b3\u00104J9\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020.2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u00108\u001a\u00020\u001aH\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0005H\u0002¢\u0006\u0004\b;\u0010\u0015J\u001f\u0010=\u001a\u00020\u00052\u0006\u00105\u001a\u00020.2\u0006\u0010<\u001a\u00020\u001aH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0005H\u0002¢\u0006\u0004\bB\u0010\u0015J\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C*\b\u0012\u0004\u0012\u00020D0CH\u0002¢\u0006\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010NR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010QR\u0016\u0010d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010fR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020i0h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0019\u0010r\u001a\u00020m8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010xR\u0016\u0010{\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010cR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010QR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b3\u0010\u0001R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b9\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010QR \u0010\u0001\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b=\u0010\u0001R\u0017\u0010\u0001\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010QR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R\u001a\u0010¥\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010«\u0001\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bª\u0001\u0010LR,\u0010®\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020D0­\u00010¬\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b;\u0010\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0017\u0010³\u0001\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010QR\u001a\u0010·\u0001\u001a\u00030´\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001f\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010h8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010k¨\u0006Å\u0001"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "view", "", "attachView", "(Lcom/avito/android/favorite_sellers/FavoriteSellersView;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "visibleToUser", "onVisibilityChanged", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", a2.g.r.g.a, "h", "f", "isRefresh", "c", "", "error", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "message", "defaultHandler", AuthSource.SEND_ABUSE, "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function1;)V", "userKey", "isSubscribed", "isNotificationsActivated", "fromUser", AuthSource.OPEN_CHANNEL_LIST, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)Z", "j", "withUndo", "i", "(Ljava/lang/String;Z)V", "visible", "e", "(I)V", "k", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "o", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/performance/ContentTracker;", "H", "Lcom/avito/android/performance/ContentTracker;", "sellersTracker", VKApiConst.Q, "I", "indexMarkedAsRead", "Ljava/lang/String;", "lastUserId", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "visibleDisposables", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.VERSION, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter$Router;", "Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;", "s", "Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;", "interactor", "Lcom/avito/android/dialog/DialogPresenter;", "B", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "loadDisposables", "n", "Z", "isScreenVisible", "Landroid/net/Uri;", "Landroid/net/Uri;", "currentLoadingNextPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "u", "Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "Lcom/avito/android/Features;", "L", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "y", "Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "converter", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "l", "isSellersViewed", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "t", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "G", "Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "tabOpenAnalytics", "Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;", "w", "Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;", "resourceProvider", "markAsReadDisposables", "Lcom/avito/android/performance/ScreenTracker;", "D", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl$VisibleContent;", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl$VisibleContent;", "visibleContentState", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "r", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "currentConfiguringSeller", "d", "viewDisposables", "Ljava/util/List;", "items", "subscribeDisposables", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "K", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/account/AccountStateProvider;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/error_helper/ErrorHelper;", "C", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "x", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "p", "indexOfLastVisibleItem", "", "Lkotlin/Pair;", "removedItems", "Lcom/avito/android/analytics/Analytics;", "F", "Lcom/avito/android/analytics/Analytics;", "analytics", "disposables", "Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "z", "Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "advertsStatusProcessor", "Lcom/avito/android/favorite_sellers/ScreenModeButtons;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/favorite_sellers/ScreenModeButtons;", "screenModeControllers", "Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "J", "changeNotificationSettingsObservable", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "state", "<init>", "(Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/performance/ScreenTracker;Lcom/avito/android/favorite_sellers/ScreenModeButtons;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/favorite_sellers/TabOpenAnalytics;Lcom/avito/android/performance/ContentTracker;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/util/Kundle;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;)V", "VisibleContent", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersPresenterImpl implements FavoriteSellersPresenter, FavoriteButtonClickListener {
    public final AccountStateProvider A;
    public final DialogPresenter B;
    public final ErrorHelper C;
    public final ScreenTracker D;
    public final ScreenModeButtons E;
    public final Analytics F;
    public final TabOpenAnalytics G;
    public final ContentTracker H;
    public final ConnectivityProvider I;
    public final Observable<NotificationSettingsChangeEvent> J;
    public final CompositeSnackbarPresenter K;
    @NotNull
    public final Features L;
    public final /* synthetic */ FavoriteAdvertsPresenter M;
    public FavoriteSellersView a;
    public FavoriteSellersPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public CompositeDisposable e = new CompositeDisposable();
    public final CompositeDisposable f = new CompositeDisposable();
    public final CompositeDisposable g = new CompositeDisposable();
    public final CompositeDisposable h = new CompositeDisposable();
    public List<? extends FavoriteSellersItem> i;
    public List<Pair<Integer, FavoriteSellersItem>> j;
    public String k;
    public boolean l;
    public VisibleContent m;
    public boolean n;
    public Uri o;
    public int p;
    public int q;
    public SellerItem r;
    public final FavoriteSellersInteractor s;
    public final AdapterPresenter t;
    public final Observable<FavoriteSellersItemAction> u;
    public final SchedulersFactory3 v;
    public final FavoriteSellersResourceProvider w;
    public final NotificationManagerProvider x;
    public final FavoriteSellersConverter y;
    public final FavoriteSellerAdvertsStatusProcessor z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersPresenterImpl$VisibleContent;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY_MESSAGE", "SELLERS_LIST", "COMMON_ERROR", "NO_INTERNET_ERROR", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public enum VisibleContent {
        EMPTY_MESSAGE,
        SELLERS_LIST,
        COMMON_ERROR,
        NO_INTERNET_ERROR
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VisibleContent.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[3] = 1;
            VisibleContent.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[2] = 2;
            iArr2[1] = 3;
            iArr2[3] = 4;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((FavoriteSellersView) this.c).hideOverlayError();
                FavoriteSellersPresenterImpl.d((FavoriteSellersPresenterImpl) this.b, false, 1);
            } else if (i == 1) {
                ((FavoriteSellersView) this.c).dismissUndoSnackbar();
                ((FavoriteSellersPresenterImpl) this.b).c(true);
            } else if (i == 2) {
                ((FavoriteSellersView) this.c).setCommonErrorVisible(false);
                ((FavoriteSellersPresenterImpl) this.b).c(false);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                SellerItem sellerItem = ((FavoriteSellersPresenterImpl) this.b).r;
                if (sellerItem != null) {
                    FavoriteSellersPresenterImpl.access$changeNotifications((FavoriteSellersPresenterImpl) this.b, sellerItem);
                }
            } else if (i == 1) {
                SellerItem sellerItem2 = ((FavoriteSellersPresenterImpl) this.b).r;
                if (sellerItem2 != null) {
                    FavoriteSellersPresenterImpl.access$unsubscribeFrom((FavoriteSellersPresenterImpl) this.b, sellerItem2);
                }
            } else if (i == 2) {
                ((FavoriteSellersPresenterImpl) this.b).r = null;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Throwable> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class d<T, R> implements Function<String, Boolean> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public d(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(String str) {
            String str2 = str;
            boolean z = true;
            if (this.a.k == null || !(!Intrinsics.areEqual(this.a.k, str2))) {
                z = false;
            }
            this.a.k = str2;
            return Boolean.valueOf(z);
        }
    }

    public static final class e<T> implements Consumer<Boolean> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public e(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "needToReload");
            if (bool2.booleanValue()) {
                this.a.h();
            }
        }
    }

    public static final class f<T> implements Consumer<Unit> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public f(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.g();
        }
    }

    public static final class g<T> implements Predicate<NotificationSettingsChangeEvent> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(NotificationSettingsChangeEvent notificationSettingsChangeEvent) {
            NotificationSettingsChangeEvent notificationSettingsChangeEvent2 = notificationSettingsChangeEvent;
            Intrinsics.checkNotNullExpressionValue(notificationSettingsChangeEvent2, "it");
            return NotificationSettingsChangeEventKt.isFavoriteSellersPush(notificationSettingsChangeEvent2);
        }
    }

    public static final class h<T> implements Consumer<NotificationSettingsChangeEvent> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public h(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(NotificationSettingsChangeEvent notificationSettingsChangeEvent) {
            this.a.h();
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class j<T> implements Consumer<FavoriteSellersItemAction> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public j(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(FavoriteSellersItemAction favoriteSellersItemAction) {
            FavoriteSellersItemAction favoriteSellersItemAction2 = favoriteSellersItemAction;
            if (favoriteSellersItemAction2 instanceof DeepLinkAction) {
                FavoriteSellersPresenter.Router router = this.a.b;
                if (router != null) {
                    router.followDeepLink(((DeepLinkAction) favoriteSellersItemAction2).getDeepLink());
                }
            } else if (favoriteSellersItemAction2 instanceof OpenSubscriptionSettings) {
                this.a.r = ((OpenSubscriptionSettings) favoriteSellersItemAction2).getItem();
                FavoriteSellersPresenterImpl.access$openSubscriptionSettings(this.a);
            } else if (favoriteSellersItemAction2 instanceof ErrorItemAction.Retry) {
                FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
                List list = favoriteSellersPresenterImpl.i;
                List access$withoutErrors = list != null ? FavoriteSellersPresenterImpl.access$withoutErrors(this.a, list) : null;
                if (access$withoutErrors == null) {
                    access$withoutErrors = CollectionsKt__CollectionsKt.emptyList();
                }
                favoriteSellersPresenterImpl.i = CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) access$withoutErrors, new LoadingItem(((ErrorItemAction.Retry) favoriteSellersItemAction2).getFailedUri()));
                FavoriteSellersPresenterImpl.l(this.a, null, 1);
            } else if (favoriteSellersItemAction2 instanceof LoadingItemAction.NextPage) {
                FavoriteSellersPresenterImpl.access$loadNextItems(this.a, ((LoadingItemAction.NextPage) favoriteSellersItemAction2).getNextPage());
            }
        }
    }

    public static final class k<T> implements Consumer<DeepLink> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public k(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            FavoriteSellersPresenter.Router router = this.a.b;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                router.followDeepLink(deepLink2);
            }
        }
    }

    public static final class l<T> implements Consumer<List<? extends FavoriteSellersItem>> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public l(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends FavoriteSellersItem> list) {
            List<? extends FavoriteSellersItem> list2 = list;
            FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            FavoriteSellersPresenterImpl.access$onLoadItemsSuccess(favoriteSellersPresenterImpl, list2);
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public m(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            FavoriteSellersPresenterImpl.access$onLoadItemsError(favoriteSellersPresenterImpl, th2);
        }
    }

    public static final class n implements Action {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;
        public final /* synthetic */ int b;

        public n(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, int i) {
            this.a = favoriteSellersPresenterImpl;
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.q = this.b;
        }
    }

    public static final class o<T> implements Consumer<Throwable> {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class p<T> implements Predicate<Integer> {
        public static final p a = new p();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Integer num) {
            return num.intValue() > 0;
        }
    }

    public static final class q<T> implements Consumer<Integer> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public q(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.s.resetCounter();
        }
    }

    public static final class r<T> implements Consumer<Throwable> {
        public static final r a = new r();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class s implements Action {
        public static final s a = new s();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    public static final class t<T> implements Consumer<Throwable> {
        public static final t a = new t();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class u<T> implements Consumer<Set<? extends FavoriteSeller>> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;

        public u(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
            this.a = favoriteSellersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Set<? extends FavoriteSeller> set) {
            Set<? extends FavoriteSeller> set2 = set;
            Intrinsics.checkNotNullExpressionValue(set2, SellersTrackerModule.NAME);
            Iterator<T> it = set2.iterator();
            while (true) {
                boolean z = true;
                if (it.hasNext()) {
                    T next = it.next();
                    if (!this.a.m(next.getUserKey(), Boolean.valueOf(next.isSubscribed()), next.isNotificationsActivated(), false) && !FavoriteSellersPresenterImpl.access$updateRecommendationState(this.a, next.getUserKey(), Boolean.valueOf(next.isSubscribed()), next.isNotificationsActivated())) {
                        z = false;
                    }
                    if (!z && next.isSubscribed()) {
                        this.a.h();
                    }
                } else {
                    FavoriteSellersPresenterImpl.l(this.a, null, 1);
                    return;
                }
            }
        }
    }

    public static final class v extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoriteSellersPresenterImpl a;
        public final /* synthetic */ SellerItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, SellerItem sellerItem) {
            super(0);
            this.a = favoriteSellersPresenterImpl;
            this.b = sellerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            SellerItem sellerItem = this.b;
            if (sellerItem != null) {
                FavoriteSellersPresenterImpl.access$subscribeTo(this.a, sellerItem);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class w extends Lambda implements Function1<SubscribableItem, Boolean> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(SubscribableItem subscribableItem) {
            SubscribableItem subscribableItem2 = subscribableItem;
            Intrinsics.checkNotNullParameter(subscribableItem2, "it");
            return Boolean.valueOf(Intrinsics.areEqual(subscribableItem2.getUserKey(), this.a));
        }
    }

    @Inject
    public FavoriteSellersPresenterImpl(@NotNull FavoriteSellersInteractor favoriteSellersInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull Observable<FavoriteSellersItemAction> observable, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteSellersResourceProvider favoriteSellersResourceProvider, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersConverter favoriteSellersConverter, @NotNull FavoriteSellerAdvertsStatusProcessor favoriteSellerAdvertsStatusProcessor, @NotNull AccountStateProvider accountStateProvider, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull ScreenTracker screenTracker, @NotNull ScreenModeButtons screenModeButtons, @NotNull Analytics analytics, @NotNull TabOpenAnalytics tabOpenAnalytics, @Named("sellers") @NotNull ContentTracker contentTracker, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @Nullable Kundle kundle, @NotNull ConnectivityProvider connectivityProvider, @NotNull Observable<NotificationSettingsChangeEvent> observable2, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features) {
        Integer num;
        String string;
        Boolean bool;
        Intrinsics.checkNotNullParameter(favoriteSellersInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "itemClicks");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteSellersResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersConverter, "converter");
        Intrinsics.checkNotNullParameter(favoriteSellerAdvertsStatusProcessor, "advertsStatusProcessor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(screenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(screenModeButtons, "screenModeControllers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(tabOpenAnalytics, "tabOpenAnalytics");
        Intrinsics.checkNotNullParameter(contentTracker, "sellersTracker");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(observable2, "changeNotificationSettingsObservable");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.M = favoriteAdvertsPresenter;
        this.s = favoriteSellersInteractor;
        this.t = adapterPresenter;
        this.u = observable;
        this.v = schedulersFactory3;
        this.w = favoriteSellersResourceProvider;
        this.x = notificationManagerProvider;
        this.y = favoriteSellersConverter;
        this.z = favoriteSellerAdvertsStatusProcessor;
        this.A = accountStateProvider;
        this.B = dialogPresenter;
        this.C = errorHelper;
        this.D = screenTracker;
        this.E = screenModeButtons;
        this.F = analytics;
        this.G = tabOpenAnalytics;
        this.H = contentTracker;
        this.I = connectivityProvider;
        this.J = observable2;
        this.K = compositeSnackbarPresenter;
        this.L = features;
        Kundle kundle2 = null;
        this.i = kundle != null ? kundle.getParcelableList("items") : null;
        this.j = new ArrayList();
        this.k = kundle != null ? kundle.getString("auth_state") : null;
        this.l = (kundle == null || (bool = kundle.getBoolean("sellers_viewed")) == null) ? true : bool.booleanValue();
        this.m = (kundle == null || (string = kundle.getString("loading_result")) == null) ? null : VisibleContent.valueOf(string);
        this.p = 1;
        this.q = (kundle == null || (num = kundle.getInt("index_marked_as_read")) == null) ? 0 : num.intValue();
        tabOpenAnalytics.initWithState(kundle != null ? kundle.getKundle("tab_open_analytics") : kundle2);
    }

    public static final void access$changeNotifications(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, SubscribableItem subscribableItem) {
        FavoriteSellersView favoriteSellersView = favoriteSellersPresenterImpl.a;
        if (favoriteSellersView == null) {
            return;
        }
        if (!favoriteSellersPresenterImpl.x.getAreNotificationsEnabled()) {
            CompositeDisposable compositeDisposable = favoriteSellersPresenterImpl.d;
            Disposable subscribe = favoriteSellersView.showEnableNotificationsDialog().subscribe(new a2.a.a.s0.b(favoriteSellersPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.showEnableNotificat…NotificationsSettings() }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        Boolean isNotificationsActivated = subscribableItem.isNotificationsActivated();
        if (isNotificationsActivated != null) {
            boolean booleanValue = isNotificationsActivated.booleanValue();
            String userKey = subscribableItem.getUserKey();
            boolean z2 = !booleanValue;
            CompositeDisposable compositeDisposable2 = favoriteSellersPresenterImpl.f;
            Disposable subscribe2 = favoriteSellersPresenterImpl.s.changeNotifications(userKey, z2, FavoriteSellersPresenterKt.access$getSource$p()).observeOn(favoriteSellersPresenterImpl.v.mainThread()).doOnSubscribe(new a2.a.a.s0.c(subscribableItem, favoriteSellersView)).doOnTerminate(new o3(0, favoriteSellersPresenterImpl, subscribableItem, userKey, favoriteSellersView)).doOnDispose(new o3(1, favoriteSellersPresenterImpl, subscribableItem, userKey, favoriteSellersView)).subscribe(new a2.a.a.s0.d(favoriteSellersPresenterImpl, z2, userKey, favoriteSellersView), new a2.a.a.s0.e(favoriteSellersPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.changeNotific…leError(it)\n            }");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    public static final void access$loadNextItems(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Uri uri) {
        List<? extends FavoriteSellersItem> list = favoriteSellersPresenterImpl.i;
        FavoriteSellersItem favoriteSellersItem = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next instanceof ErrorItem) {
                    favoriteSellersItem = next;
                    break;
                }
            }
            favoriteSellersItem = favoriteSellersItem;
        }
        if (!((favoriteSellersItem == null && favoriteSellersPresenterImpl.m == VisibleContent.SELLERS_LIST) ? false : true) && !Intrinsics.areEqual(uri, favoriteSellersPresenterImpl.o)) {
            favoriteSellersPresenterImpl.o = uri;
            favoriteSellersPresenterImpl.g.clear();
            CompositeDisposable compositeDisposable = favoriteSellersPresenterImpl.g;
            Disposable subscribe = favoriteSellersPresenterImpl.s.loadSubscribes(uri).flatMap(new a2.a.a.s0.j(favoriteSellersPresenterImpl)).observeOn(favoriteSellersPresenterImpl.v.mainThread()).map(a2.a.a.s0.k.a).doFinally(new a2.a.a.s0.l(favoriteSellersPresenterImpl)).subscribe(new a2.a.a.s0.m(favoriteSellersPresenterImpl), new a2.a.a.s0.n(favoriteSellersPresenterImpl, uri));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadSubscribe…temsError(it, nextPage) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final void access$onLoadItemsError(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Throwable th) {
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        if (th instanceof FavoriteSellersCacheExpiredException) {
            favoriteSellersPresenterImpl.h();
            return;
        }
        ContentTracker contentTracker = favoriteSellersPresenterImpl.H;
        ContentTracker.State state = ContentTracker.State.Failure;
        contentTracker.loaded(state);
        favoriteSellersPresenterImpl.H.preparing();
        favoriteSellersPresenterImpl.i = null;
        favoriteSellersPresenterImpl.H.prepared(state);
        favoriteSellersPresenterImpl.H.drawing();
        l(favoriteSellersPresenterImpl, null, 1);
        favoriteSellersPresenterImpl.a(th, new a2.a.a.s0.w(favoriteSellersPresenterImpl));
        favoriteSellersPresenterImpl.H.drawn(state);
    }

    public static final void access$onLoadItemsSuccess(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, List list) {
        VisibleContent visibleContent;
        ContentTracker.DefaultImpls.loaded$default(favoriteSellersPresenterImpl.H, null, 1, null);
        favoriteSellersPresenterImpl.H.preparing();
        favoriteSellersPresenterImpl.h.clear();
        favoriteSellersPresenterImpl.p = 1;
        favoriteSellersPresenterImpl.i = list;
        if (list.isEmpty()) {
            visibleContent = VisibleContent.EMPTY_MESSAGE;
        } else {
            visibleContent = VisibleContent.SELLERS_LIST;
        }
        favoriteSellersPresenterImpl.m = visibleContent;
        ContentTracker.DefaultImpls.prepared$default(favoriteSellersPresenterImpl.H, null, 1, null);
        favoriteSellersPresenterImpl.H.drawing();
        favoriteSellersPresenterImpl.g();
        favoriteSellersPresenterImpl.k();
        ContentTracker.DefaultImpls.drawn$default(favoriteSellersPresenterImpl.H, null, 1, null);
        favoriteSellersPresenterImpl.f();
    }

    public static final void access$onLoadNextItemsError(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Throwable th, Uri uri) {
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        if (th instanceof FavoriteSellersCacheExpiredException) {
            favoriteSellersPresenterImpl.h();
            return;
        }
        List<? extends FavoriteSellersItem> list = favoriteSellersPresenterImpl.i;
        favoriteSellersPresenterImpl.i = list != null ? favoriteSellersPresenterImpl.o(list) : null;
        favoriteSellersPresenterImpl.a(th, new x(favoriteSellersPresenterImpl, uri));
        favoriteSellersPresenterImpl.m = VisibleContent.SELLERS_LIST;
        l(favoriteSellersPresenterImpl, null, 1);
    }

    public static final void access$openSubscriptionSettings(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        SellerItem sellerItem = favoriteSellersPresenterImpl.r;
        if (sellerItem != null) {
            FavoriteSellersView favoriteSellersView = favoriteSellersPresenterImpl.a;
            boolean z2 = true;
            if (favoriteSellersView != null) {
                favoriteSellersView.setSubscribed(sellerItem.isSubscribed(), !sellerItem.isDisabled());
            }
            FavoriteSellersView favoriteSellersView2 = favoriteSellersPresenterImpl.a;
            if (favoriteSellersView2 != null) {
                Boolean isNotificationsActivated = sellerItem.isNotificationsActivated();
                if (!(isNotificationsActivated != null ? isNotificationsActivated.booleanValue() : false) || !favoriteSellersPresenterImpl.x.getAreNotificationsEnabled()) {
                    z2 = false;
                }
                favoriteSellersView2.setNotificationActivated(z2);
            }
            FavoriteSellersView favoriteSellersView3 = favoriteSellersPresenterImpl.a;
            if (favoriteSellersView3 != null) {
                favoriteSellersView3.setUnsubscribeLoading(sellerItem.isSubscribeInProgress);
            }
            FavoriteSellersView favoriteSellersView4 = favoriteSellersPresenterImpl.a;
            if (favoriteSellersView4 != null) {
                favoriteSellersView4.setNotificationLoading(sellerItem.isNotificationsInProgress);
            }
        }
        FavoriteSellersView favoriteSellersView5 = favoriteSellersPresenterImpl.a;
        if (favoriteSellersView5 != null) {
            favoriteSellersView5.openSubscriptionSettings();
        }
    }

    public static final void access$restoreRemovedItems(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        List<? extends FavoriteSellersItem> list = favoriteSellersPresenterImpl.i;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            if (true ^ (t2 instanceof InfoItem)) {
                arrayList.add(t2);
            }
        }
        List<? extends FavoriteSellersItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        for (T t3 : favoriteSellersPresenterImpl.j) {
            mutableList.add(((Number) t3.getFirst()).intValue(), t3.getSecond());
        }
        favoriteSellersPresenterImpl.i = mutableList;
        favoriteSellersPresenterImpl.m = VisibleContent.SELLERS_LIST;
        favoriteSellersPresenterImpl.k();
        l(favoriteSellersPresenterImpl, null, 1);
    }

    public static final void access$showUndoSnackbarWithDelay(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, long j2) {
        CompositeDisposable compositeDisposable = favoriteSellersPresenterImpl.d;
        Disposable subscribe = Observable.timer(j2, TimeUnit.MILLISECONDS, favoriteSellersPresenterImpl.v.io()).observeOn(favoriteSellersPresenterImpl.v.mainThread()).subscribe(new y(favoriteSellersPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.timer(delayMi…oSnackbar()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$subscribeTo(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, SubscribableItem subscribableItem) {
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        String userKey = subscribableItem.getUserKey();
        favoriteSellersPresenterImpl.F.track(new SubscribeSellerButtonEvent(userKey, FavoriteSellersPresenterKt.access$getSource$p()));
        CompositeDisposable compositeDisposable = favoriteSellersPresenterImpl.f;
        Disposable subscribe = favoriteSellersPresenterImpl.s.subscribe(userKey, FavoriteSellersPresenterKt.access$getSource$p()).observeOn(favoriteSellersPresenterImpl.v.mainThread()).doOnSubscribe(new c0(favoriteSellersPresenterImpl, subscribableItem)).doOnTerminate(new o0(0, favoriteSellersPresenterImpl, subscribableItem)).doOnDispose(new o0(1, favoriteSellersPresenterImpl, subscribableItem)).subscribe(new d0(favoriteSellersPresenterImpl, userKey), new e0(favoriteSellersPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.subscribe(use…Delay(2500)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$unsubscribeFrom(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, SubscribableItem subscribableItem) {
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        String userKey = subscribableItem.getUserKey();
        favoriteSellersPresenterImpl.F.track(new UnsubscribeSellerButtonEvent(userKey, FavoriteSellersPresenterKt.access$getSource$p()));
        CompositeDisposable compositeDisposable = favoriteSellersPresenterImpl.f;
        Disposable subscribe = favoriteSellersPresenterImpl.s.unsubscribe(userKey, FavoriteSellersPresenterKt.access$getSource$p()).observeOn(favoriteSellersPresenterImpl.v.mainThread()).doOnSubscribe(new f0(favoriteSellersPresenterImpl, subscribableItem)).doOnTerminate(new p1(0, favoriteSellersPresenterImpl, subscribableItem)).doOnDispose(new p1(1, favoriteSellersPresenterImpl, subscribableItem)).subscribe(new p1(2, favoriteSellersPresenterImpl, subscribableItem), new g0(favoriteSellersPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.unsubscribe(u…leError(it)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final boolean access$updateRecommendationState(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, String str, Boolean bool, Boolean bool2) {
        Parcelable parcelable;
        Object obj;
        boolean z2;
        List<? extends FavoriteSellersItem> list = favoriteSellersPresenterImpl.i;
        Parcelable parcelable2 = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (T t2 : list) {
                if (t2 instanceof RecommendationItem) {
                    arrayList.add(t2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t6.n.h.addAll(arrayList2, ((RecommendationItem) it.next()).getCarousel());
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                RecommendationCarouselItem recommendationCarouselItem = (RecommendationCarouselItem) obj;
                if (!(recommendationCarouselItem instanceof SellerCarouselItem) || !Intrinsics.areEqual(((SellerCarouselItem) recommendationCarouselItem).getUserKey(), str)) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            parcelable = (RecommendationCarouselItem) obj;
        } else {
            parcelable = null;
        }
        if (parcelable instanceof SellerCarouselItem) {
            parcelable2 = parcelable;
        }
        SellerCarouselItem sellerCarouselItem = (SellerCarouselItem) parcelable2;
        if (sellerCarouselItem == null) {
            return false;
        }
        if (bool != null) {
            sellerCarouselItem.setSubscribed(bool.booleanValue());
        }
        if (bool2 != null) {
            sellerCarouselItem.setNotificationsActivated(Boolean.valueOf(bool2.booleanValue()));
        }
        return true;
    }

    public static final void access$updateVisibleContent(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Throwable th) {
        VisibleContent visibleContent;
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        if (Throwables.isAuthProblem(th)) {
            favoriteSellersPresenterImpl.G.setResult(null);
            visibleContent = VisibleContent.EMPTY_MESSAGE;
        } else if (!favoriteSellersPresenterImpl.I.isConnectionAvailable()) {
            visibleContent = VisibleContent.NO_INTERNET_ERROR;
        } else {
            visibleContent = VisibleContent.COMMON_ERROR;
        }
        favoriteSellersPresenterImpl.m = visibleContent;
    }

    public static final List access$withoutErrors(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, List list) {
        Objects.requireNonNull(favoriteSellersPresenterImpl);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((FavoriteSellersItem) obj) instanceof ErrorItem)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void b(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Throwable th, Function1 function1, int i2) {
        favoriteSellersPresenterImpl.a(th, (i2 & 2) != 0 ? new a2.a.a.s0.h(favoriteSellersPresenterImpl) : null);
    }

    public static /* synthetic */ void d(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, boolean z2, int i2) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        favoriteSellersPresenterImpl.c(z2);
    }

    public static void l(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, List list, int i2) {
        List<? extends FavoriteSellersItem> list2;
        if ((i2 & 1) != 0) {
            list2 = favoriteSellersPresenterImpl.i;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
        } else {
            list2 = null;
        }
        AdapterPresentersKt.updateItems(favoriteSellersPresenterImpl.t, CollectionsKt___CollectionsKt.toMutableList((Collection) list2));
        FavoriteSellersView favoriteSellersView = favoriteSellersPresenterImpl.a;
        if (favoriteSellersView != null) {
            favoriteSellersView.notifyItemsChanged();
        }
        VisibleContent visibleContent = favoriteSellersPresenterImpl.m;
        if (visibleContent != null) {
            int ordinal = visibleContent.ordinal();
            if (ordinal == 0) {
                FavoriteSellersView favoriteSellersView2 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView2 != null) {
                    favoriteSellersView2.setEmptyVisible(true);
                }
                FavoriteSellersView favoriteSellersView3 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView3 != null) {
                    favoriteSellersView3.setCommonErrorVisible(false);
                }
            } else if (ordinal == 1) {
                FavoriteSellersView favoriteSellersView4 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView4 != null) {
                    favoriteSellersView4.setCommonErrorVisible(false);
                }
                FavoriteSellersView favoriteSellersView5 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView5 != null) {
                    favoriteSellersView5.setEmptyVisible(false);
                }
            } else if (ordinal == 2) {
                FavoriteSellersView favoriteSellersView6 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView6 != null) {
                    favoriteSellersView6.setCommonErrorVisible(true);
                }
                FavoriteSellersView favoriteSellersView7 = favoriteSellersPresenterImpl.a;
                if (favoriteSellersView7 != null) {
                    favoriteSellersView7.setEmptyVisible(false);
                }
            }
        }
    }

    public static /* synthetic */ boolean n(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, String str, Boolean bool, Boolean bool2, boolean z2, int i2) {
        if ((i2 & 2) != 0) {
            bool = null;
        }
        if ((i2 & 4) != 0) {
            bool2 = null;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return favoriteSellersPresenterImpl.m(str, bool, bool2, z2);
    }

    public final void a(Throwable th, Function1<? super String, Unit> function1) {
        TypedError handle = this.C.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = InteropKt.toV3(this.B.showDialog(((ErrorResult.ErrorDialog) handle).getUserDialog())).subscribe(new k(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        function1.invoke(this.C.recycle(handle));
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    public void attachRouter(@NotNull FavoriteSellersPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        k();
        VisibleContent visibleContent = this.m;
        if (!(visibleContent == VisibleContent.COMMON_ERROR || visibleContent == VisibleContent.NO_INTERNET_ERROR)) {
            c(false);
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.A.userId().observeOn(this.v.mainThread()).map(new d(this)).subscribe(new e(this), c.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = this.s.updates().observeOn(this.v.mainThread()).subscribe(new f(this), c.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.updates()\n   …error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = this.J.filter(g.a).subscribe(new h(this), i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "changeNotificationSettin…ibe({ reloadItems() }) {}");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    public void attachView(@NotNull FavoriteSellersView favoriteSellersView) {
        Intrinsics.checkNotNullParameter(favoriteSellersView, "view");
        this.a = favoriteSellersView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.u.subscribe(new j(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { a…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = favoriteSellersView.retryClicks().subscribe(new a(0, this, favoriteSellersView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.retryClicks().subsc…    loadItems()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = favoriteSellersView.refreshClicks().subscribe(new a(1, this, favoriteSellersView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.refreshClicks().sub…Refresh = true)\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = favoriteSellersView.retryButtonClick().subscribe(new a(2, this, favoriteSellersView));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.retryButtonClick().…efresh = false)\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.d;
        Disposable subscribe5 = favoriteSellersView.notificationClicks().subscribe(new b(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.notificationClicks(…ns(item = it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.d;
        Disposable subscribe6 = favoriteSellersView.unsubscribeClicks().subscribe(new b(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "view.unsubscribeClicks()…om(item = it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.d;
        Disposable subscribe7 = favoriteSellersView.dismissEvents().subscribe(new b(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "view.dismissEvents().sub…ngSeller = null\n        }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        favoriteSellersView.setPullToRefreshEnabled(this.E.getWithPullToRefresh());
        l(this, null, 1);
    }

    public final void c(boolean z2) {
        Single single;
        Single doOnSubscribe;
        Single observeOn;
        Single map;
        this.D.resetSession();
        this.f.clear();
        this.g.clear();
        CompositeDisposable compositeDisposable = this.g;
        List<? extends FavoriteSellersItem> list = this.i;
        Single<R> single2 = null;
        if (list != null) {
            if (!(!z2)) {
                list = null;
            }
            if (!(list == null || (single = Singles.toSingle(list)) == null || (doOnSubscribe = single.doOnSubscribe(new a2.a.a.s0.f(this))) == null || (observeOn = doOnSubscribe.observeOn(this.v.computation())) == null || (map = observeOn.map(new a2.a.a.s0.g(this))) == null)) {
                single2 = map.observeOn(this.v.mainThread());
            }
        }
        if (single2 == null) {
            single2 = this.s.loadSubscribes().doOnSubscribe(new a2.a.a.s0.o(this, z2)).flatMap(new a2.a.a.s0.q(this)).flatMap(new a2.a.a.s0.r(this)).observeOn(this.v.mainThread()).map(new a2.a.a.s0.s(this)).doOnSuccess(new a2.a.a.s0.t(this)).doOnError(new a2.a.a.s0.u(this)).doOnTerminate(new a2.a.a.s0.v(this));
            Intrinsics.checkNotNullExpressionValue(single2, "interactor.loadSubscribe… { view?.hideProgress() }");
        }
        Disposable subscribe = single2.subscribe(new l(this), new m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "(getLocalSellers(isRefre… { onLoadItemsError(it) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    public void detachRouter() {
        this.j.clear();
        FavoriteSellersView favoriteSellersView = this.a;
        if (favoriteSellersView != null) {
            favoriteSellersView.closeSubscriptionSettings();
        }
        this.h.clear();
        this.f.clear();
        this.g.clear();
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x006a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.FavoriteSellersInteractor] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r10) {
        /*
            r9 = this;
            com.avito.android.favorite_sellers.FavoriteSellersView r0 = r9.a
            if (r0 == 0) goto L_0x000f
            com.avito.android.favorite_sellers.ViewPortState r0 = r0.getViewPortState()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.getLastCompletelyVisible()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            int r1 = r9.p
            int r0 = java.lang.Math.max(r0, r1)
            r9.p = r0
            int r1 = r9.q
            java.util.List<? extends com.avito.android.favorite_sellers.FavoriteSellersItem> r2 = r9.i
            r3 = 1
            if (r2 == 0) goto L_0x0066
            if (r0 < r3) goto L_0x0061
            int r2 = r2.size()
            if (r0 >= r2) goto L_0x0061
            if (r1 < r0) goto L_0x002a
            goto L_0x0061
        L_0x002a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List<? extends com.avito.android.favorite_sellers.FavoriteSellersItem> r4 = r9.i
            if (r4 == 0) goto L_0x006a
        L_0x0033:
            if (r1 >= r0) goto L_0x006a
            java.lang.Object r5 = r4.get(r1)
            com.avito.android.favorite_sellers.FavoriteSellersItem r5 = (com.avito.android.favorite_sellers.FavoriteSellersItem) r5
            int r1 = r1 + 1
            java.lang.Object r6 = r4.get(r1)
            com.avito.android.favorite_sellers.FavoriteSellersItem r6 = (com.avito.android.favorite_sellers.FavoriteSellersItem) r6
            boolean r7 = r5 instanceof com.avito.android.favorite_sellers.adapter.seller.SellerItem
            if (r7 == 0) goto L_0x0033
            com.avito.android.favorite_sellers.adapter.seller.SellerItem r5 = (com.avito.android.favorite_sellers.adapter.seller.SellerItem) r5
            java.lang.Boolean r7 = r5.getHasNewItems()
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 == 0) goto L_0x0033
            boolean r6 = r6 instanceof com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItem
            if (r6 == 0) goto L_0x0033
            java.lang.String r5 = r5.getUserKey()
            r2.add(r5)
            goto L_0x0033
        L_0x0061:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x006a
        L_0x0066:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x006a:
            boolean r0 = r2.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x009b
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r9.h
            r0.clear()
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r9.h
            com.avito.android.favorite_sellers.FavoriteSellersInteractor r1 = r9.s
            io.reactivex.rxjava3.core.Completable r1 = r1.markSellersAsRead(r2)
            com.avito.android.util.SchedulersFactory3 r2 = r9.v
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Completable r1 = r1.observeOn(r2)
            com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl$n r2 = new com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl$n
            r2.<init>(r9, r10)
            com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl$o r10 = com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl.o.a
            io.reactivex.rxjava3.disposables.Disposable r10 = r1.subscribe(r2, r10)
            java.lang.String r1 = "interactor.markSellersAs…kedAsRead = visible }) {}"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r10)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl.e(int):void");
    }

    public final void f() {
        if (this.n && !this.l) {
            this.l = true;
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.s.markSellersAsViewed().observeOn(this.v.mainThread()).subscribe(s.a, t.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.markSellersAs…e({}, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void g() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.s.getSellers().observeOn(this.v.mainThread()).subscribe(new u(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSellers()\n…dateItems()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final Features getFeatures() {
        return this.L;
    }

    public final void h() {
        this.m = null;
        this.i = null;
        l(this, null, 1);
        this.G.reset();
        k();
        c(false);
    }

    public final void i(String str, boolean z2) {
        this.j.clear();
        ArrayList arrayList = new ArrayList();
        List<? extends FavoriteSellersItem> list = this.i;
        if (list != null) {
            int i2 = 0;
            for (T t2 : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                String str2 = null;
                T t4 = !(t3 instanceof SubscribableItem) ? null : t3;
                if (t4 != null) {
                    str2 = t4.getUserKey();
                }
                if (!Intrinsics.areEqual(str2, str)) {
                    arrayList.add(t3);
                } else if (z2) {
                    this.j.add(new Pair<>(Integer.valueOf(i2), t3));
                }
                i2 = i3;
            }
        }
        int i4 = this.q;
        List<? extends FavoriteSellersItem> list2 = this.i;
        this.q = Math.max((i4 - (list2 != null ? list2.size() : 0)) - arrayList.size(), 0);
        this.i = arrayList;
    }

    public final void j() {
        Object obj;
        if (this.n) {
            List<Pair<Integer, FavoriteSellersItem>> list = this.j;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((FavoriteSellersItem) it.next().getSecond());
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (obj instanceof SellerItem) {
                    break;
                }
            }
            SellerItem sellerItem = (SellerItem) obj;
            FavoriteSellersView favoriteSellersView = this.a;
            if (favoriteSellersView != null) {
                favoriteSellersView.showUndoSnackbar(new v(this, sellerItem));
            }
        }
    }

    public final void k() {
        if (this.m == VisibleContent.NO_INTERNET_ERROR) {
            FavoriteSellersView favoriteSellersView = this.a;
            if (favoriteSellersView != null) {
                favoriteSellersView.showOverlayError();
                return;
            }
            return;
        }
        FavoriteSellersView favoriteSellersView2 = this.a;
        if (favoriteSellersView2 != null) {
            favoriteSellersView2.hideOverlayError();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(java.lang.String r6, java.lang.Boolean r7, java.lang.Boolean r8, boolean r9) {
        /*
            r5 = this;
            java.util.List<? extends com.avito.android.favorite_sellers.FavoriteSellersItem> r0 = r5.i
            r1 = 0
            if (r0 == 0) goto L_0x00b5
            kotlin.sequences.Sequence r0 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r0)
            if (r0 == 0) goto L_0x00b5
            java.lang.Class<com.avito.android.favorite_sellers.SubscribableItem> r2 = com.avito.android.favorite_sellers.SubscribableItem.class
            kotlin.sequences.Sequence r0 = t6.x.f.filterIsInstance(r0, r2)
            if (r0 == 0) goto L_0x00b5
            com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl$w r2 = new com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl$w
            r2.<init>(r6)
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt___SequencesKt.filter(r0, r2)
            if (r0 == 0) goto L_0x00b5
            java.util.List r0 = kotlin.sequences.SequencesKt___SequencesKt.toList(r0)
            if (r0 == 0) goto L_0x00b5
            boolean r2 = r0.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = r4
        L_0x002f:
            if (r0 == 0) goto L_0x00b5
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)
            if (r2 == 0) goto L_0x0077
            if (r9 == 0) goto L_0x0055
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.first(r0)
            boolean r2 = r0 instanceof com.avito.android.favorite_sellers.adapter.seller.SellerItem
            if (r2 != 0) goto L_0x0044
            r0 = r4
        L_0x0044:
            com.avito.android.favorite_sellers.adapter.seller.SellerItem r0 = (com.avito.android.favorite_sellers.adapter.seller.SellerItem) r0
            if (r0 == 0) goto L_0x0055
            boolean r0 = r0.isDisabled()
            if (r0 != 0) goto L_0x0055
            r5.i(r6, r3)
            r5.j()
            goto L_0x0058
        L_0x0055:
            r5.i(r6, r1)
        L_0x0058:
            java.util.List<? extends com.avito.android.favorite_sellers.FavoriteSellersItem> r0 = r5.i
            if (r0 == 0) goto L_0x0071
            java.util.Iterator r0 = r0.iterator()
        L_0x0060:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006f
            java.lang.Object r1 = r0.next()
            boolean r2 = r1 instanceof com.avito.android.favorite_sellers.adapter.seller.SellerItem
            if (r2 == 0) goto L_0x0060
            r4 = r1
        L_0x006f:
            com.avito.android.favorite_sellers.adapter.seller.SellerItem r4 = (com.avito.android.favorite_sellers.adapter.seller.SellerItem) r4
        L_0x0071:
            if (r4 != 0) goto L_0x009e
            r5.c(r3)
            goto L_0x009e
        L_0x0077:
            java.util.Iterator r0 = r0.iterator()
        L_0x007b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x009e
            java.lang.Object r1 = r0.next()
            com.avito.android.favorite_sellers.SubscribableItem r1 = (com.avito.android.favorite_sellers.SubscribableItem) r1
            if (r7 == 0) goto L_0x0090
            boolean r2 = r7.booleanValue()
            r1.setSubscribed(r2)
        L_0x0090:
            if (r8 == 0) goto L_0x007b
            boolean r2 = r8.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.setNotificationsActivated(r2)
            goto L_0x007b
        L_0x009e:
            if (r9 == 0) goto L_0x00b4
            io.reactivex.rxjava3.disposables.CompositeDisposable r9 = r5.c
            com.avito.android.favorite_sellers.FavoriteSellersInteractor r0 = r5.s
            io.reactivex.rxjava3.core.Completable r6 = r0.updateSeller(r6, r7, r8)
            io.reactivex.rxjava3.disposables.Disposable r6 = r6.subscribe()
            java.lang.String r7 = "interactor.updateSeller(…            ).subscribe()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r9, r6)
        L_0x00b4:
            return r3
        L_0x00b5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl.m(java.lang.String, java.lang.Boolean, java.lang.Boolean, boolean):boolean");
    }

    public final List<FavoriteSellersItem> o(List<? extends FavoriteSellersItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            if (!(t2 instanceof LoadingItem)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        FavoriteSellersPresenter.Router router;
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null && (router = this.b) != null) {
            router.openFastAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, null, advertItem.isMarketplace());
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.M.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        FavoriteSellersPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle putInt = new Kundle().putParcelableList("items", this.i).putString("auth_state", this.k).putBoolean("sellers_viewed", Boolean.valueOf(this.l)).putKundle("tab_open_analytics", this.G.onSaveState()).putInt("index_marked_as_read", Integer.valueOf(this.q));
        VisibleContent visibleContent = this.m;
        if (visibleContent != null) {
            putInt.putString("loading_result", visibleContent.name());
        }
        return putInt;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter
    public void onVisibilityChanged(boolean z2) {
        if (z2) {
            FavoriteSellersView favoriteSellersView = this.a;
            if (favoriteSellersView != null) {
                CompositeDisposable compositeDisposable = this.e;
                Disposable subscribe = favoriteSellersView.viewPortChanges().distinctUntilChanged().map(new z(this)).distinctUntilChanged().throttleLast(1000, TimeUnit.MILLISECONDS).subscribe(new a0(this), b0.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "it.viewPortChanges()\n   …ersAsRead(visible) }, {})");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
            CompositeDisposable compositeDisposable2 = this.e;
            Disposable subscribe2 = this.s.counterChanges().filter(p.a).delay(2, TimeUnit.SECONDS, this.v.computation()).observeOn(this.v.mainThread()).subscribe(new q(this), r.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.counterChange…ctor.resetCounter() }) {}");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        } else {
            e(this.p);
            this.s.resetCounter();
            this.e.clear();
            FavoriteSellersView favoriteSellersView2 = this.a;
            if (favoriteSellersView2 != null) {
                favoriteSellersView2.dismissUndoSnackbar();
            }
        }
        this.n = z2;
        this.G.onVisibilityChanged(z2);
        f();
    }
}
