package com.avito.android.shop.detailed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.FiltersIntentFactory;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.ShopAwardsIntentFactory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.deep_linking.links.ShowPinMapLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.filter.FilterCommons;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.OnBackPressedListener;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.di.DaggerShopDetailedComponent;
import com.avito.android.shop.detailed.di.ShopDetailedComponent;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.shop.detailed.item.ShopDetailedRedesignViewImpl;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenter;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenter;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenter;
import com.avito.android.shop.detailed.tracker.ShopDetailedTracker;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002þ\u0001B\b¢\u0006\u0005\bý\u0001\u0010\u0015J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010 J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010&JY\u00103\u001a\u00020\u00112\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010(2\b\u0010-\u001a\u0004\u0018\u00010(2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00112\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0011H\u0016¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u0011H\u0016¢\u0006\u0004\b:\u0010\u0015J-\u0010>\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010(2\b\u0010;\u001a\u0004\u0018\u00010(2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00112\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u001f\u0010H\u001a\u00020\u00112\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ!\u0010N\u001a\u00020\u00112\u0006\u0010K\u001a\u00020J2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ)\u0010U\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020P2\b\u0010T\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0011H\u0016¢\u0006\u0004\bW\u0010\u0015R\"\u0010Y\u001a\u00020X8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010f\u001a\u00020_8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R%\u0010}\u001a\u00020|8\u0006@\u0006X.¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010 \u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R*\u0010§\u0001\u001a\u00030¦\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R*\u0010®\u0001\u001a\u00030­\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R*\u0010µ\u0001\u001a\u00030´\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R*\u0010Ã\u0001\u001a\u00030Â\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R*\u0010Ê\u0001\u001a\u00030É\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R*\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R*\u0010Ø\u0001\u001a\u00030×\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R*\u0010ß\u0001\u001a\u00030Þ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R*\u0010æ\u0001\u001a\u00030å\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\bæ\u0001\u0010ç\u0001\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010ë\u0001R*\u0010ì\u0001\u001a\u00030»\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bì\u0001\u0010½\u0001\u001a\u0006\bí\u0001\u0010¿\u0001\"\u0006\bî\u0001\u0010Á\u0001R*\u0010ð\u0001\u001a\u00030ï\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R*\u0010÷\u0001\u001a\u00030ö\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001¨\u0006ÿ\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onStart", "onStop", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "onBackClicked", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followDeepLinkFromSubscriptions", "openFavoriteSellers", "Lcom/avito/android/public_profile/ui/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnBackPressedListener", "(Lcom/avito/android/public_profile/ui/OnBackPressedListener;)V", "removeOnBackPressedListener", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "openNotificationsSettings", "openAuthScreen", "description", "Lcom/avito/android/remote/model/Action;", "action", "showPopup", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "openAwards", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/FilterAnalyticsData;", "analyticsParams", "openFilters", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/FilterAnalyticsData;)V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "openPhoneRequest", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "closeShop", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$shop_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$shop_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "j", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "shopRegularItemPresenter", "Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "getShopRegularItemPresenter", "()Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "setShopRegularItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;)V", "Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "interactor", "Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "getInteractor", "()Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "setInteractor", "(Lcom/avito/android/shop/detailed/ShopDetailedInteractor;)V", "Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "shopGoldItemPresenter", "Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "getShopGoldItemPresenter", "()Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "setShopGoldItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;)V", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "showcaseItemPresenter", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "getShowcaseItemPresenter", "()Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "setShowcaseItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteShowcasePresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteShowcasePresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteShowcasePresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "getSubscriptionsPresenter", "()Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "setSubscriptionsPresenter", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;)V", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "presenter", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "getPresenter", "()Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "setPresenter", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartQuantityHandler$shop_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartQuantityHandler$shop_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "favoriteAdvertsPresenter", "getFavoriteAdvertsPresenter", "setFavoriteAdvertsPresenter", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;", "tracker", "Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;", "getTracker", "()Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;", "setTracker", "(Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;)V", "<init>", "Factory", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedFragment extends TabBaseFragment implements ShopDetailedPresenter.Router, SubscriptionsPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    @ShopDetailedModule.ItemResponsiveAdapter
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public CartQuantityChangesHandler cartQuantityHandler;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    @ShopDetailedModule.ShowcaseFavoritePresenter
    public FavoriteAdvertsPresenter favoriteShowcasePresenter;
    @Inject
    public Features features;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ShopDetailedInteractor interactor;
    @NotNull
    public NavigationState j = new NavigationState(false);
    @Inject
    public ShopDetailedPresenter presenter;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public ShopGoldItemPresenter shopGoldItemPresenter;
    @Inject
    public ShopRegularItemPresenter shopRegularItemPresenter;
    @Inject
    public ShowcaseItemPresenter showcaseItemPresenter;
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public SubscriptionsPresenter subscriptionsPresenter;
    @Inject
    public ShopDetailedTracker tracker;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedFragment$Factory;", "", "Lcom/avito/android/shop/detailed/ShopDetailedArguments;", "arguments", "Lcom/avito/android/shop/detailed/ShopDetailedFragment;", "newInstance", "(Lcom/avito/android/shop/detailed/ShopDetailedArguments;)Lcom/avito/android/shop/detailed/ShopDetailedFragment;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ ShopDetailedArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ShopDetailedArguments shopDetailedArguments) {
                super(1);
                this.a = shopDetailedArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final ShopDetailedFragment newInstance(@NotNull ShopDetailedArguments shopDetailedArguments) {
            Intrinsics.checkNotNullParameter(shopDetailedArguments, "arguments");
            return (ShopDetailedFragment) FragmentsKt.arguments$default(new ShopDetailedFragment(), 0, new a(shopDetailedArguments), 1, null);
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            Logs.error(exc2);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ ShopDetailedFragment a;
        public final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopDetailedFragment shopDetailedFragment, Uri uri) {
            super(1);
            this.a = shopDetailedFragment;
            this.b = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            ShopDetailedFragment shopDetailedFragment = this.a;
            FragmentsKt.startActivitySafely(shopDetailedFragment, NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(shopDetailedFragment.getActivityIntentFactory(), this.b, false, false, 6, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ ShopDetailedFragment b;
        public final /* synthetic */ BottomSheetDialog c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Action action, VerificationPopupViewImpl verificationPopupViewImpl, ShopDetailedFragment shopDetailedFragment, String str, String str2, Action action2, BottomSheetDialog bottomSheetDialog) {
            super(0);
            this.a = action;
            this.b = shopDetailedFragment;
            this.c = bottomSheetDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.followDeepLink(this.a.getDeepLink());
            this.c.close();
            return Unit.INSTANCE;
        }
    }

    public static final void access$makeCallSafely(ShopDetailedFragment shopDetailedFragment, String str) {
        ImplicitIntentFactory implicitIntentFactory2 = shopDetailedFragment.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        FragmentsKt.startActivitySafely(shopDetailedFragment, implicitIntentFactory2.dialIntent(str), new a2.a.a.s2.b.a(shopDetailedFragment));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void addOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void closeShop() {
        if (!features().getShopDetailedWithoutActivity().invoke().booleanValue() || (getActivity() instanceof ShopDetailedActivity)) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.shop.detailed.ShopDetailedActivity");
            ((ShopDetailedActivity) activity).closeSearch();
            return;
        }
        finish();
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ShowPinMapLink) {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getItemMapWithoutActivity().invoke().booleanValue() && currentTab() != null) {
                ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                ShowPinMapLink showPinMapLink = (ShowPinMapLink) deepLink;
                startActivity(ItemMapIntentFactory.DefaultImpls.itemMapIntent$default(activityIntentFactory2, showPinMapLink.getPin(), true, null, true, showPinMapLink.getAddress(), showPinMapLink.getTitle(), null, null, null, true, showPinMapLink.getCreateRoute(), currentTab(), false, null, 12740, null));
                return;
            }
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void followDeepLinkFromSubscriptions(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink);
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$shop_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartQuantityHandler$shop_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getDestroyableViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        return destroyableViewHolderBuilder2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteShowcasePresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteShowcasePresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteShowcasePresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ShopDetailedInteractor getInteractor() {
        ShopDetailedInteractor shopDetailedInteractor = this.interactor;
        if (shopDetailedInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return shopDetailedInteractor;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.j;
    }

    @NotNull
    public final ShopDetailedPresenter getPresenter() {
        ShopDetailedPresenter shopDetailedPresenter = this.presenter;
        if (shopDetailedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return shopDetailedPresenter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final ShopGoldItemPresenter getShopGoldItemPresenter() {
        ShopGoldItemPresenter shopGoldItemPresenter2 = this.shopGoldItemPresenter;
        if (shopGoldItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopGoldItemPresenter");
        }
        return shopGoldItemPresenter2;
    }

    @NotNull
    public final ShopRegularItemPresenter getShopRegularItemPresenter() {
        ShopRegularItemPresenter shopRegularItemPresenter2 = this.shopRegularItemPresenter;
        if (shopRegularItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRegularItemPresenter");
        }
        return shopRegularItemPresenter2;
    }

    @NotNull
    public final ShowcaseItemPresenter getShowcaseItemPresenter() {
        ShowcaseItemPresenter showcaseItemPresenter2 = this.showcaseItemPresenter;
        if (showcaseItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showcaseItemPresenter");
        }
        return showcaseItemPresenter2;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        return spanSizeLookup2;
    }

    @NotNull
    public final SubscriptionsPresenter getSubscriptionsPresenter() {
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        return subscriptionsPresenter2;
    }

    @NotNull
    public final ShopDetailedTracker getTracker() {
        ShopDetailedTracker shopDetailedTracker = this.tracker;
        if (shopDetailedTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return shopDetailedTracker;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        boolean z = false;
        boolean z2 = i2 == -1;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    super.onActivityResult(i, i2, intent);
                } else if (z2 && intent != null) {
                    DeepLink result = new FilterCommons().getResult(intent);
                    ShopDetailedPresenter shopDetailedPresenter = this.presenter;
                    if (shopDetailedPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    shopDetailedPresenter.onSearchClarified(result);
                }
            } else if (z2) {
                SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
                if (subscriptionsPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
                }
                subscriptionsPresenter2.onAuthCompleted();
            } else {
                SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
                if (subscriptionsPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
                }
                subscriptionsPresenter3.onAuthCanceled();
            }
        } else if (intent != null && (stringExtra = intent.getStringExtra("message")) != null) {
            if (stringExtra.length() > 0) {
                z = true;
            }
            if (!z) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                ShopDetailedPresenter shopDetailedPresenter2 = this.presenter;
                if (shopDetailedPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                shopDetailedPresenter2.showMessage(stringExtra);
            }
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void onBackClicked() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopDetailedTracker shopDetailedTracker = this.tracker;
        if (shopDetailedTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        shopDetailedTracker.startInit();
        return layoutInflater.inflate(R.layout.shop_detailed_rd_searchbar_default, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteShowcasePresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteShowcasePresenter");
        }
        favoriteAdvertsPresenter3.detachViews();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.detachView();
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
        ShopDetailedPresenter shopDetailedPresenter = this.presenter;
        if (shopDetailedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopDetailedPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getShopDetailedWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            ShopDetailedPresenter shopDetailedPresenter = this.presenter;
            if (shopDetailedPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Bundles.putKundle(bundle2, "presenter", shopDetailedPresenter.onSaveState());
            ShopDetailedInteractor shopDetailedInteractor = this.interactor;
            if (shopDetailedInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactor");
            }
            Bundles.putKundle(bundle2, "interactor", shopDetailedInteractor.onSaveState());
            ShopGoldItemPresenter shopGoldItemPresenter2 = this.shopGoldItemPresenter;
            if (shopGoldItemPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopGoldItemPresenter");
            }
            Bundles.putKundle(bundle2, "shop_gold_item_presenter_state", shopGoldItemPresenter2.onSaveState());
            ShopRegularItemPresenter shopRegularItemPresenter2 = this.shopRegularItemPresenter;
            if (shopRegularItemPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopRegularItemPresenter");
            }
            Bundles.putKundle(bundle2, "shop_regular_item_presenter_state", shopRegularItemPresenter2.onSaveState());
            ShowcaseItemPresenter showcaseItemPresenter2 = this.showcaseItemPresenter;
            if (showcaseItemPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showcaseItemPresenter");
            }
            Bundles.putKundle(bundle2, "shop_showcase_presenter_state", showcaseItemPresenter2.onSaveState());
            SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
            if (subscriptionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
            }
            Bundles.putKundle(bundle2, "shop_subscriptions_presenter_state", subscriptionsPresenter2.onSaveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        ShopDetailedPresenter shopDetailedPresenter2 = this.presenter;
        if (shopDetailedPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter", shopDetailedPresenter2.onSaveState());
        ShopDetailedInteractor shopDetailedInteractor2 = this.interactor;
        if (shopDetailedInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Bundles.putKundle(bundle, "interactor", shopDetailedInteractor2.onSaveState());
        ShopGoldItemPresenter shopGoldItemPresenter3 = this.shopGoldItemPresenter;
        if (shopGoldItemPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopGoldItemPresenter");
        }
        Bundles.putKundle(bundle, "shop_gold_item_presenter_state", shopGoldItemPresenter3.onSaveState());
        ShopRegularItemPresenter shopRegularItemPresenter3 = this.shopRegularItemPresenter;
        if (shopRegularItemPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRegularItemPresenter");
        }
        Bundles.putKundle(bundle, "shop_regular_item_presenter_state", shopRegularItemPresenter3.onSaveState());
        ShowcaseItemPresenter showcaseItemPresenter3 = this.showcaseItemPresenter;
        if (showcaseItemPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showcaseItemPresenter");
        }
        Bundles.putKundle(bundle, "shop_showcase_presenter_state", showcaseItemPresenter3.onSaveState());
        SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
        if (subscriptionsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        Bundles.putKundle(bundle, "shop_subscriptions_presenter_state", subscriptionsPresenter3.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ShopDetailedPresenter shopDetailedPresenter = this.presenter;
        if (shopDetailedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopDetailedPresenter.attachRouter(this);
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.attachRouter(this);
        ShopDetailedPresenter shopDetailedPresenter2 = this.presenter;
        if (shopDetailedPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopDetailedPresenter2.getMakeCallStream().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.shop.detailed.ShopDetailedFragment$onStart$$inlined$observeNotNull$1
            public final /* synthetic */ ShopDetailedFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ShopDetailedFragment.access$makeCallSafely(this.a, t);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ShopDetailedPresenter shopDetailedPresenter = this.presenter;
        if (shopDetailedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopDetailedPresenter.detachRouter();
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ShopDetailedPresenter shopDetailedPresenter = this.presenter;
        if (shopDetailedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        ShopDetailedRedesignViewImpl shopDetailedRedesignViewImpl = new ShopDetailedRedesignViewImpl(view, shopDetailedPresenter, responsiveAdapterPresenter, destroyableViewHolderBuilder2, spannedGridPositionProvider, spanSizeLookup2, analytics2, schedulersFactory3);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            View inflate = ((ViewStub) view.findViewById(R.id.cart_fab_stub)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
            CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
            if (cartFabViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
            }
            CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
            if (cartQuantityChangesHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
        }
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features3.getShopDetailedWithoutActivity().invoke().booleanValue() && bundle != null) {
            ShopDetailedPresenter shopDetailedPresenter2 = this.presenter;
            if (shopDetailedPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            shopDetailedPresenter2.setIsRestored();
        }
        ShopDetailedPresenter shopDetailedPresenter3 = this.presenter;
        if (shopDetailedPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopDetailedPresenter3.attachView(shopDetailedRedesignViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.attachView(shopDetailedRedesignViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter3.attachErrorMessageView(shopDetailedRedesignViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(shopDetailedRedesignViewImpl);
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.attachContainerView(shopDetailedRedesignViewImpl);
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.setDefaultElement(shopDetailedRedesignViewImpl);
        ShopDetailedTracker shopDetailedTracker = this.tracker;
        if (shopDetailedTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        shopDetailedTracker.trackInit();
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        FragmentsKt.startActivityForResultSafely(this, IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.SUBSCRIBE_SELLER, null, 5, null)), 2, a.a);
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void openAwards(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(ShopAwardsIntentFactory.DefaultImpls.showAwardsIntent$default(activityIntentFactory2, awardsItem, false, 2, null));
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory2, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2560, null));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openFavoriteSellers(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink);
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void openFilters(@NotNull SearchParams searchParams, @NotNull FilterAnalyticsData filterAnalyticsData) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(filterAnalyticsData, "analyticsParams");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent searchIntent$default = FiltersIntentFactory.DefaultImpls.searchIntent$default(activityIntentFactory2, searchParams, null, null, false, filterAnalyticsData, currentTab(), false, 78, null);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getFiltersWithoutActivity().invoke().booleanValue()) {
            startForResult(searchIntent$default, 3);
        } else {
            startActivityForResult(searchIntent$default, 3);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openNotificationsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void openPhoneRequest(@NotNull PhoneRequestLink phoneRequestLink, @Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData) {
        Intrinsics.checkNotNullParameter(phoneRequestLink, "link");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.createPhoneRequestIntent(phoneRequestLink, phoneRequestDeepLinkAnalyticsData));
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void openUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        FragmentsKt.startActivitySafely(this, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(implicitIntentFactory2, uri, false, 2, null), new b(this, uri));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void removeOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCartFabViewModel$shop_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCartQuantityHandler$shop_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setFavoriteShowcasePresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteShowcasePresenter = favoriteAdvertsPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setInteractor(@NotNull ShopDetailedInteractor shopDetailedInteractor) {
        Intrinsics.checkNotNullParameter(shopDetailedInteractor, "<set-?>");
        this.interactor = shopDetailedInteractor;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.j = navigationState;
    }

    public final void setPresenter(@NotNull ShopDetailedPresenter shopDetailedPresenter) {
        Intrinsics.checkNotNullParameter(shopDetailedPresenter, "<set-?>");
        this.presenter = shopDetailedPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setShopGoldItemPresenter(@NotNull ShopGoldItemPresenter shopGoldItemPresenter2) {
        Intrinsics.checkNotNullParameter(shopGoldItemPresenter2, "<set-?>");
        this.shopGoldItemPresenter = shopGoldItemPresenter2;
    }

    public final void setShopRegularItemPresenter(@NotNull ShopRegularItemPresenter shopRegularItemPresenter2) {
        Intrinsics.checkNotNullParameter(shopRegularItemPresenter2, "<set-?>");
        this.shopRegularItemPresenter = shopRegularItemPresenter2;
    }

    public final void setShowcaseItemPresenter(@NotNull ShowcaseItemPresenter showcaseItemPresenter2) {
        Intrinsics.checkNotNullParameter(showcaseItemPresenter2, "<set-?>");
        this.showcaseItemPresenter = showcaseItemPresenter2;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setSubscriptionsPresenter(@NotNull SubscriptionsPresenter subscriptionsPresenter2) {
        Intrinsics.checkNotNullParameter(subscriptionsPresenter2, "<set-?>");
        this.subscriptionsPresenter = subscriptionsPresenter2;
    }

    public final void setTracker(@NotNull ShopDetailedTracker shopDetailedTracker) {
        Intrinsics.checkNotNullParameter(shopDetailedTracker, "<set-?>");
        this.tracker = shopDetailedTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        ShopDetailedArguments shopDetailedArguments;
        Bundle retainStorage = features().getShopDetailedWithoutActivity().invoke().booleanValue() ? retainStorage() : bundle;
        Bundle arguments = getArguments();
        if (arguments == null || (shopDetailedArguments = (ShopDetailedArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("ShopDetailedArguments must be specified");
        }
        Kundle kundle = null;
        Kundle kundle2 = retainStorage != null ? Bundles.getKundle(retainStorage, "presenter") : null;
        Kundle kundle3 = retainStorage != null ? Bundles.getKundle(retainStorage, "interactor") : null;
        Kundle kundle4 = retainStorage != null ? Bundles.getKundle(retainStorage, "shop_regular_item_presenter_state") : null;
        Kundle kundle5 = retainStorage != null ? Bundles.getKundle(retainStorage, "shop_gold_item_presenter_state") : null;
        Kundle kundle6 = retainStorage != null ? Bundles.getKundle(retainStorage, "shop_showcase_presenter_state") : null;
        if (retainStorage != null) {
            kundle = Bundles.getKundle(retainStorage, "shop_subscriptions_presenter_state");
        }
        Timer B1 = a2.b.a.a.a.B1();
        ShopDetailedComponent.Factory factory = DaggerShopDetailedComponent.factory();
        String shopId = shopDetailedArguments.getShopId();
        String pageFrom = shopDetailedArguments.getPageFrom();
        String context = shopDetailedArguments.getContext();
        SearchParams searchParams = shopDetailedArguments.getSearchParams();
        TreeClickStreamParent treeParent = shopDetailedArguments.getTreeParent();
        SingleLiveEvent singleLiveEvent = new SingleLiveEvent();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(shopId, pageFrom, context, searchParams, kundle3, kundle2, treeParent, singleLiveEvent, resources, this, null, (ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)), new ShopDetailedModule(kundle4, kundle5, kundle6, kundle)).inject(this);
        ShopDetailedTracker shopDetailedTracker = this.tracker;
        if (shopDetailedTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        shopDetailedTracker.trackDiInject(B1.elapsed());
        return true;
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter.Router
    public void showPopup(@Nullable String str, @Nullable String str2, @Nullable Action action) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.verification_popup;
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View inflate = layoutInflater.inflate(i, (ViewGroup) view, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "popupView");
        VerificationPopupViewImpl verificationPopupViewImpl = new VerificationPopupViewImpl(inflate);
        verificationPopupViewImpl.setTitle(str);
        verificationPopupViewImpl.setDescription(str2);
        if (action != null) {
            verificationPopupViewImpl.setAction(action.getTitle(), new c(action, verificationPopupViewImpl, this, str, str2, action, bottomSheetDialog));
        }
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setPeekHeight(getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, false, 10, null);
        bottomSheetDialog.show();
    }
}
