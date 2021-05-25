package com.avito.android.shop.detailed;

import a2.a.a.s2.b.h;
import a2.a.a.s2.b.i;
import a2.a.a.s2.b.j;
import a2.a.a.s2.b.k;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.Features;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShopAdvertItemsLongViewedEvent;
import com.avito.android.analytics.event.ShopAdvertItemsShortViewedEvent;
import com.avito.android.analytics.event.ShopCallButtonClickEvent;
import com.avito.android.analytics.event.ShopContactCallEvent;
import com.avito.android.analytics.event.ShopContactSelectEvent;
import com.avito.android.analytics.event.ShopContactsDisplayEvent;
import com.avito.android.analytics.event.ShowShopScreenEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.source.ShopContactsSource;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.deep_linking.links.ShopRatingDetailsLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.analytics.event.PublicRatingDetailsOpenEvent;
import com.avito.android.public_profile.analytics.event.ShowPublicProfileEvent;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.remote.shop.detailed.ShopGold;
import com.avito.android.remote.shop.detailed.ShopRegular;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItem;
import com.avito.android.shop.detailed.item.ShopDetailedRedesignView;
import com.avito.android.shop.detailed.item.ShopGoldItem;
import com.avito.android.shop.detailed.tracker.ShopDetailedTracker;
import com.avito.android.util.Collections;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002Bç\u0001\b\u0007\u0012\t\b\u0001\u0010\u0001\u001a\u00020\u0003\u0012\t\b\u0001\u0010¤\u0001\u001a\u00020a\u0012\b\u0010Æ\u0001\u001a\u00030Ã\u0001\u0012\u0007\u0010\u0001\u001a\u00020}\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Ê\u0001\u001a\u00030Ç\u0001\u0012\b\u0010¨\u0001\u001a\u00030¥\u0001\u0012\u0006\u0010|\u001a\u00020y\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00100i\u0012\b\u0010»\u0001\u001a\u00030¸\u0001\u0012\u0006\u0010h\u001a\u00020e\u0012\b\u0010Â\u0001\u001a\u00030¿\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\u0010¡\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010¯\u0001\u001a\u00030¬\u0001\u0012\u000b\b\u0001\u0010Í\u0001\u001a\u0004\u0018\u00010$\u0012\b\u0010Ñ\u0001\u001a\u00030Î\u0001\u0012\u0006\u0010x\u001a\u00020u\u0012\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030²\u0001¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u000bJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\u000bJ\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010\u000bJ\u000f\u00106\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u0010\u000bJ\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010\u000bJ\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010\u000bJ\u0017\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0003H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\fH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0007H\u0016¢\u0006\u0004\b>\u0010\u000bJ\u000f\u0010?\u001a\u00020\u0007H\u0016¢\u0006\u0004\b?\u0010\u000bJ\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u000bJ\u001f\u0010B\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0005H\u0016¢\u0006\u0004\bB\u0010CJ-\u0010H\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\u00032\b\u0010E\u001a\u0004\u0018\u00010\u00032\b\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u0010\u000bJ\u0017\u0010K\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\bK\u0010+J)\u0010R\u001a\u00020\u00072\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u000bJ\u0019\u0010W\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b[\u0010\\J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010^\u001a\u00020]H\u0001¢\u0006\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00100i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010mR\u0016\u0010p\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010oR\u0016\u0010q\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010oR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010oR\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010tR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u0001R\u0019\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010\u0001R\"\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R\u0017\u0010¢\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010oR\u0018\u0010¤\u0001\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010cR\u001a\u0010¨\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010«\u0001\u001a\u00030©\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\b\u0010ª\u0001R\u001a\u0010¯\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u0018\u0010±\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010oR(\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030²\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010¼\u0001\u001a\u00030©\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\"\u0010ª\u0001R\"\u0010¾\u0001\u001a\u000b\u0012\u0004\u0012\u00020F\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u0001R\u001a\u0010Â\u0001\u001a\u00030¿\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001a\u0010Æ\u0001\u001a\u00030Ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u001a\u0010Ñ\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006Ô\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedPresenterImpl;", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "", "phone", "Lcom/avito/android/analytics/source/ShopContactsSource;", "source", "", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Lcom/avito/android/analytics/source/ShopContactsSource;)V", g.a, "()V", "", "shouldRefreshPage", "f", "(Z)V", "", "throwable", "e", "(Ljava/lang/Throwable;)V", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "shopDetailedData", "k", "(Lcom/avito/android/shop/detailed/ShopDetailedData;)V", "h", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "c", "()Lcom/avito/android/remote/model/SerpDisplayType;", "i", "(Lcom/avito/android/analytics/source/ShopContactsSource;)V", "d", "()Ljava/lang/String;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", AuthSource.BOOKING_ORDER, "()Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "setIsRestored", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;", "view", "attachView", "(Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;)V", "detachView", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;)V", "detachRouter", "onAppend", "onRefresh", "onCallFailed", "message", "showMessage", "(Ljava/lang/String;)V", "canAppend", "()Z", "onCallButtonPressed", "onPhoneDialogDismissed", "onDescriptionCollapsed", "shopContactsSource", "onDeepLinkFollowed", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/source/ShopContactsSource;)V", "title", "description", "Lcom/avito/android/remote/model/Action;", "action", "onShowPopup", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "onContactsExpanded", "onAdditionalActionClicked", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "onUpPressed", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "onSubscribeInfoChanged", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "onAwardsClicked", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lcom/avito/android/remote/model/SearchParams;", "p", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/util/Formatter;", "y", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "shopAdvertsData", "Z", "isLoading", "isHeaderSet", "l", "isQueryChanging", "Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;", "Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;", "J", "Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;", "tracker", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "x", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "t", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Lcom/avito/android/shop/detailed/ShopItemVisibilityProvider;", "D", "Lcom/avito/android/shop/detailed/ShopItemVisibilityProvider;", "shopItemVisibilityProvider", "Ljava/lang/String;", "query", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "u", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/analytics/Analytics;", "C", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", AuthSource.OPEN_CHANNEL_LIST, "isFiltersApplied", "Ljava/lang/Throwable;", "error", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "Ljava/util/List;", "data", VKApiConst.Q, "shopId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "F", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "hasMorePages", "r", "initialSearchParams", "Lcom/avito/android/util/SchedulersFactory3;", "w", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "G", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "o", "phoneDialogShown", "Landroidx/lifecycle/MutableLiveData;", "K", "Landroidx/lifecycle/MutableLiveData;", "getMakeCallStream", "()Landroidx/lifecycle/MutableLiveData;", "makeCallStream", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "z", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "viewCallbacksDisposables", "n", "phones", "Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "B", "Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "shopItemConverter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "s", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", VKApiConst.VERSION, "Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "interactor", "H", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/Features;", "I", "Lcom/avito/android/Features;", "features", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/shop/detailed/ShopDetailedInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/shop/detailed/ShopItemVisibilityProvider;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/util/Kundle;Lcom/avito/android/Features;Lcom/avito/android/shop/detailed/tracker/ShopDetailedTracker;Landroidx/lifecycle/MutableLiveData;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedPresenterImpl implements ShopDetailedPresenter, FavoriteButtonClickListener {
    public final ViewedAdvertsPresenter A;
    public final ShopDetailedItemsConverter B;
    public final Analytics C;
    public final ShopItemVisibilityProvider D;
    public final TreeStateIdGenerator E;
    public final TreeClickStreamParent F;
    public final CompositeSnackbarPresenter G;
    public final Kundle H;
    public final Features I;
    public final ShopDetailedTracker J;
    @NotNull
    public final MutableLiveData<String> K;
    public CompositeDisposable a = new CompositeDisposable();
    public CompositeDisposable b = new CompositeDisposable();
    public boolean c;
    public String d;
    public ShopDetailedData e;
    public List<? extends SpannedItem> f;
    public ShopDetailedRedesignView g;
    public ShopDetailedPresenter.Router h;
    public boolean i;
    public Throwable j;
    public boolean k;
    public boolean l;
    public boolean m;
    public List<Action> n;
    public boolean o;
    public SearchParams p;
    public final String q;
    public final SearchParams r;
    public final AdapterPresenter s;
    public final SerpSpanProvider t;
    public final SpannedGridPositionProvider u;
    public final ShopDetailedInteractor v;
    public final SchedulersFactory3 w;
    public final ShopAdvertsResourceProvider x;
    public final Formatter<Throwable> y;
    public final FavoriteAdvertsPresenter z;

    public static final class a<T> implements Consumer<ShopDetailedData> {
        public final /* synthetic */ ShopDetailedPresenterImpl a;

        public a(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
            this.a = shopDetailedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ShopDetailedData shopDetailedData) {
            ShopDetailedData shopDetailedData2 = shopDetailedData;
            this.a.J.trackShopLoaded();
            this.a.J.startShopDraw();
            ShopDetailedPresenterImpl shopDetailedPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(shopDetailedData2, "it");
            ShopDetailedPresenterImpl.access$onAdvertsDataLoaded(shopDetailedPresenterImpl, shopDetailedData2);
            this.a.J.trackShopDraw();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ShopDetailedPresenterImpl a;

        public b(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
            this.a = shopDetailedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.J.trackShopLoadError();
            this.a.J.startShopDraw();
            ShopDetailedPresenterImpl shopDetailedPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ShopDetailedPresenterImpl.access$onErrorReceived(shopDetailedPresenterImpl, th2);
            this.a.J.trackShopErrorDraw();
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ ShopDetailedPresenterImpl a;

        public c(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
            this.a = shopDetailedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            ShopDetailedRedesignView shopDetailedRedesignView = this.a.g;
            if (shopDetailedRedesignView != null) {
                Intrinsics.checkNotNullExpressionValue(num2, "selectedFilters");
                shopDetailedRedesignView.showSelectedFiltersCount(num2.intValue());
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class e<T> implements Consumer<List<? extends SpannedItem>> {
        public final /* synthetic */ ShopDetailedPresenterImpl a;

        public e(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
            this.a = shopDetailedPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends SpannedItem> list) {
            this.a.f = list;
        }
    }

    public static final class f extends Lambda implements Function1<List<? extends SpannedItem>, Unit> {
        public final /* synthetic */ ShopDetailedPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
            super(1);
            this.a = shopDetailedPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(List<? extends SpannedItem> list) {
            List<? extends SpannedItem> list2 = list;
            ShopDetailedPresenterImpl shopDetailedPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            ShopDetailedPresenterImpl.access$onDataSourceUpdated(shopDetailedPresenterImpl, new ListDataSource(list2));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopDetailedPresenterImpl(@ShopDetailedModule.ShopId @NotNull String str, @ShopDetailedModule.SearchParams @NotNull SearchParams searchParams, @NotNull AdapterPresenter adapterPresenter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull ShopDetailedInteractor shopDetailedInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ShopAdvertsResourceProvider shopAdvertsResourceProvider, @NotNull Formatter<Throwable> formatter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull ShopDetailedItemsConverter shopDetailedItemsConverter, @NotNull Analytics analytics, @NotNull ShopItemVisibilityProvider shopItemVisibilityProvider, @NotNull TreeStateIdGenerator treeStateIdGenerator, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @ShopDetailedModule.PresenterState @Nullable Kundle kundle, @NotNull Features features, @NotNull ShopDetailedTracker shopDetailedTracker, @NotNull MutableLiveData<String> mutableLiveData) {
        SearchParams copy$default;
        CompressedParcelable compressedParcelable;
        Boolean bool;
        CompressedParcelable compressedParcelable2;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(searchParams, "initialSearchParams");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "serpSpanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(shopDetailedInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(shopAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(shopDetailedItemsConverter, "shopItemConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(shopItemVisibilityProvider, "shopItemVisibilityProvider");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(shopDetailedTracker, "tracker");
        Intrinsics.checkNotNullParameter(mutableLiveData, "makeCallStream");
        this.q = str;
        this.r = searchParams;
        this.s = adapterPresenter;
        this.t = serpSpanProvider;
        this.u = spannedGridPositionProvider;
        this.v = shopDetailedInteractor;
        this.w = schedulersFactory3;
        this.x = shopAdvertsResourceProvider;
        this.y = formatter;
        this.z = favoriteAdvertsPresenter;
        this.A = viewedAdvertsPresenter;
        this.B = shopDetailedItemsConverter;
        this.C = analytics;
        this.D = shopItemVisibilityProvider;
        this.E = treeStateIdGenerator;
        this.F = treeClickStreamParent;
        this.G = compositeSnackbarPresenter;
        this.H = kundle;
        this.I = features;
        this.J = shopDetailedTracker;
        this.K = mutableLiveData;
        this.c = (kundle == null || (bool2 = kundle.getBoolean("has_more_pages")) == null) ? true : bool2.booleanValue();
        List<Action> list = null;
        this.d = kundle != null ? kundle.getString("query") : null;
        this.e = (kundle == null || (compressedParcelable2 = (CompressedParcelable) kundle.getParcelable("shop_adverts")) == null) ? null : (ShopDetailedData) compressedParcelable2.restore(ShopDetailedData.class);
        this.j = kundle != null ? (Throwable) kundle.getSerializable("has_error") : null;
        this.n = kundle != null ? kundle.getParcelableList("phone_action") : list;
        this.o = (kundle == null || (bool = kundle.getBoolean("phone_dialog_shown")) == null) ? false : bool.booleanValue();
        this.p = (kundle == null || (compressedParcelable = (CompressedParcelable) kundle.getParcelable("search_params")) == null || (copy$default = (SearchParams) compressedParcelable.restore(SearchParams.class)) == null) ? SearchParams.copy$default(searchParams, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, 7340031, null) : copy$default;
        serpSpanProvider.setAppendingListener(this);
    }

    public static final String access$getProProfileType(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
        ShopDetailedData shopDetailedData = shopDetailedPresenterImpl.e;
        ShopElement shop = shopDetailedData != null ? shopDetailedData.getShop() : null;
        if (shop instanceof ShopGold) {
            return ((ShopGold) shop).getProfProfileType();
        }
        if (shop instanceof ShopRegular) {
            return ((ShopRegular) shop).getProfProfileType();
        }
        return null;
    }

    public static final void access$onAdvertsDataLoaded(ShopDetailedPresenterImpl shopDetailedPresenterImpl, ShopDetailedData shopDetailedData) {
        shopDetailedPresenterImpl.i = false;
        shopDetailedPresenterImpl.j = null;
        ShopDetailedData shopDetailedData2 = shopDetailedPresenterImpl.e;
        if (shopDetailedData2 != null) {
            ShopDetailedData shopDetailedData3 = new ShopDetailedData(shopDetailedData2.getShop(), shopDetailedData2.getCount(), CollectionsKt___CollectionsKt.plus((Collection) shopDetailedData2.getElements(), (Iterable) shopDetailedData.getElements()), shopDetailedData.getFirebaseParams(), shopDetailedData.getSearchHint(), shopDetailedData.getDisplayType());
            shopDetailedPresenterImpl.e = shopDetailedData3;
            shopDetailedPresenterImpl.k(shopDetailedData3);
            if (shopDetailedPresenterImpl.I.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                shopDetailedPresenterImpl.C.track(new ShowPublicProfileEvent(shopDetailedPresenterImpl.E.nextStateId(), shopDetailedPresenterImpl.F, shopDetailedPresenterImpl.q));
            }
        } else {
            shopDetailedPresenterImpl.e = shopDetailedData;
            shopDetailedPresenterImpl.k(shopDetailedData);
            shopDetailedPresenterImpl.j();
        }
        Map<String, String> firebaseParams = shopDetailedData.getFirebaseParams();
        if (firebaseParams != null) {
            shopDetailedPresenterImpl.C.track(new ShowShopScreenEvent(firebaseParams));
        }
        String searchHint = shopDetailedData.getSearchHint();
        if (searchHint == null) {
            searchHint = shopDetailedPresenterImpl.x.getSearchBarHint();
        }
        ShopDetailedRedesignView shopDetailedRedesignView = shopDetailedPresenterImpl.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.setHint(searchHint);
        }
    }

    public static final void access$onDataSourceUpdated(ShopDetailedPresenterImpl shopDetailedPresenterImpl, DataSource dataSource) {
        List<Action> phones;
        ShopDetailedRedesignView shopDetailedRedesignView = shopDetailedPresenterImpl.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.hideLoading();
        }
        shopDetailedPresenterImpl.t.onDataSourceChanged(dataSource);
        shopDetailedPresenterImpl.s.onDataSourceChanged(dataSource);
        shopDetailedPresenterImpl.u.onDataSourceChanged(dataSource);
        shopDetailedPresenterImpl.z.onDataSourceChanged(dataSource);
        shopDetailedPresenterImpl.A.onDataSourceChanged(dataSource);
        ShopDetailedRedesignView shopDetailedRedesignView2 = shopDetailedPresenterImpl.g;
        if (shopDetailedRedesignView2 != null) {
            shopDetailedRedesignView2.onDataSourceChanged();
        }
        if (dataSource.getCount() > 1) {
            Item item = (Item) DataSources.second(dataSource);
            if (!shopDetailedPresenterImpl.k) {
                shopDetailedPresenterImpl.k = true;
                if ((item instanceof ShopGoldItem) && (phones = ((ShopGoldItem) item).getPhones()) != null) {
                    shopDetailedPresenterImpl.n = phones;
                    ShopDetailedRedesignView shopDetailedRedesignView3 = shopDetailedPresenterImpl.g;
                    if (shopDetailedRedesignView3 != null) {
                        shopDetailedRedesignView3.showCallButton();
                    }
                    for (T t2 : phones) {
                        ShopDetailedRedesignView shopDetailedRedesignView4 = shopDetailedPresenterImpl.g;
                        if (shopDetailedRedesignView4 != null) {
                            shopDetailedRedesignView4.addPhoneToDialog(t2.getTitle(), new h(t2, shopDetailedPresenterImpl));
                        }
                    }
                }
            }
        }
        if (shopDetailedPresenterImpl.l) {
            shopDetailedPresenterImpl.l = false;
            shopDetailedPresenterImpl.h();
        }
        if (shopDetailedPresenterImpl.m) {
            shopDetailedPresenterImpl.m = false;
            shopDetailedPresenterImpl.h();
        }
    }

    public static final void access$onErrorReceived(ShopDetailedPresenterImpl shopDetailedPresenterImpl, Throwable th) {
        shopDetailedPresenterImpl.i = false;
        shopDetailedPresenterImpl.l = false;
        shopDetailedPresenterImpl.m = false;
        shopDetailedPresenterImpl.j = th;
        shopDetailedPresenterImpl.e(th);
    }

    public static final void access$onQuerySubmitted(ShopDetailedPresenterImpl shopDetailedPresenterImpl, String str) {
        if (Intrinsics.areEqual(shopDetailedPresenterImpl.d, str)) {
            ShopDetailedRedesignView shopDetailedRedesignView = shopDetailedPresenterImpl.g;
            if (shopDetailedRedesignView != null) {
                shopDetailedRedesignView.showError(shopDetailedPresenterImpl.x.getChangeQueryError());
                return;
            }
            return;
        }
        shopDetailedPresenterImpl.d = str;
        shopDetailedPresenterImpl.p = SearchParams.copy$default(shopDetailedPresenterImpl.p, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388095, null);
        shopDetailedPresenterImpl.l = true;
        shopDetailedPresenterImpl.a.clear();
        shopDetailedPresenterImpl.i = false;
        shopDetailedPresenterImpl.e = null;
        shopDetailedPresenterImpl.c = true;
        ShopDetailedRedesignView shopDetailedRedesignView2 = shopDetailedPresenterImpl.g;
        if (shopDetailedRedesignView2 != null) {
            shopDetailedRedesignView2.showLoading();
        }
        ShopDetailedRedesignView shopDetailedRedesignView3 = shopDetailedPresenterImpl.g;
        if (shopDetailedRedesignView3 != null) {
            shopDetailedRedesignView3.close();
        }
        shopDetailedPresenterImpl.f(true);
    }

    public final void a(String str, ShopContactsSource shopContactsSource) {
        getMakeCallStream().postValue(str);
        String d2 = d();
        if (d2 != null) {
            this.C.track(new ShopContactCallEvent(d2, shopContactsSource.getValue()));
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void attachRouter(@NotNull ShopDetailedPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.h = router;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void attachView(@NotNull ShopDetailedRedesignView shopDetailedRedesignView) {
        Intrinsics.checkNotNullParameter(shopDetailedRedesignView, "view");
        this.g = shopDetailedRedesignView;
        j();
        ShopDetailedRedesignView shopDetailedRedesignView2 = this.g;
        if (shopDetailedRedesignView2 != null) {
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = shopDetailedRedesignView2.submitCallbacks().observeOn(this.w.mainThread()).subscribe(new i(this), l1.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.submitCallbacks()\n …uerySubmitted(it) }, { })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.b;
            Disposable subscribe2 = shopDetailedRedesignView2.navigationCallbacks().observeOn(this.w.mainThread()).subscribe(new j(this), l1.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationCallbacks…?.onBackClicked() }, { })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.b;
            Disposable subscribe3 = shopDetailedRedesignView2.menuCallbacks().observeOn(this.w.mainThread()).subscribe(new k(this), l1.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view.menuCallbacks()\n   …Data)\n            }, { })");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        }
        shopDetailedRedesignView.showLoading();
        if (this.o) {
            shopDetailedRedesignView.showPhoneDialog();
        }
        shopDetailedRedesignView.setHint(this.x.getSearchBarHint());
        ShopDetailedData shopDetailedData = this.e;
        Throwable th = this.j;
        if (th != null) {
            e(th);
            return;
        }
        if (shopDetailedData == null) {
            f(false);
        } else {
            this.v.refreshSubscriptionState(shopDetailedData);
            k(shopDetailedData);
        }
        g();
    }

    public final PhoneRequestDeepLinkAnalyticsData b() {
        String d2 = d();
        if (d2 != null) {
            return new PhoneRequestDeepLinkAnalyticsData.ShopDetails(d2, ShopContactsSource.PHONE.getValue());
        }
        return null;
    }

    public final SerpDisplayType c() {
        SerpDisplayType displayType;
        ShopDetailedData shopDetailedData = this.e;
        return (shopDetailedData == null || (displayType = shopDetailedData.getDisplayType()) == null) ? SerpDisplayTypeKt.orDefault(this.p.getDisplayType()) : displayType;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.c;
    }

    public final String d() {
        ShopDetailedData shopDetailedData = this.e;
        ShopElement shop = shopDetailedData != null ? shopDetailedData.getShop() : null;
        if (shop instanceof ShopGold) {
            return ((ShopGold) shop).getUserKey();
        }
        if (shop instanceof ShopRegular) {
            return ((ShopRegular) shop).getUserKey();
        }
        return null;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void detachRouter() {
        this.h = null;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void detachView() {
        ShopItemsVisibilityData andClearItemsData = this.D.getAndClearItemsData();
        int shortTimeVisibleCount = andClearItemsData.getShortTimeVisibleCount();
        if (shortTimeVisibleCount > 0) {
            this.C.track(new ShopAdvertItemsShortViewedEvent(this.q, shortTimeVisibleCount));
        }
        int longTimeVisibleCount = andClearItemsData.getLongTimeVisibleCount();
        if (longTimeVisibleCount > 0) {
            this.C.track(new ShopAdvertItemsLongViewedEvent(this.q, longTimeVisibleCount));
        }
        this.a.clear();
        this.b.clear();
        this.g = null;
    }

    public final void e(Throwable th) {
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.hideLoading();
        }
        if (th instanceof ShopNotFoundException) {
            ShopDetailedRedesignView shopDetailedRedesignView2 = this.g;
            if (shopDetailedRedesignView2 != null) {
                shopDetailedRedesignView2.showNotFoundError(((ShopNotFoundException) th).getMessage());
            }
        } else if (Throwables.isNetworkProblem(th)) {
            ShopDetailedRedesignView shopDetailedRedesignView3 = this.g;
            if (shopDetailedRedesignView3 != null) {
                shopDetailedRedesignView3.showRetryOverlay();
            }
        } else {
            ShopDetailedRedesignView shopDetailedRedesignView4 = this.g;
            if (shopDetailedRedesignView4 != null) {
                shopDetailedRedesignView4.showError(this.y.format(th));
            }
        }
    }

    public final void f(boolean z2) {
        SerpDisplayType serpDisplayType;
        this.J.startShopServerLoading();
        this.i = true;
        this.a.clear();
        ShopDetailedData shopDetailedData = this.e;
        if (shopDetailedData == null || (serpDisplayType = shopDetailedData.getDisplayType()) == null) {
            serpDisplayType = this.p.getDisplayType();
        }
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.v.loadShopAdvertsData(this.d, serpDisplayType, this.p, z2).observeOn(this.w.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadShopAdver…Draw()\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void g() {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.v.getFiltersCount(this.p).observeOn(this.w.mainThread()).subscribeOn(this.w.io()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getFiltersCou…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void h() {
        ShopDetailedData shopDetailedData = this.e;
        SpannedItem spannedItem = null;
        if (Collections.isNullOrEmpty(shopDetailedData != null ? shopDetailedData.getElements() : null)) {
            ShopDetailedRedesignView shopDetailedRedesignView = this.g;
            if (shopDetailedRedesignView != null) {
                shopDetailedRedesignView.scrollToPosition(this.s.getCount() - 1);
                return;
            }
            return;
        }
        ShopDetailedRedesignView shopDetailedRedesignView2 = this.g;
        if (shopDetailedRedesignView2 != null) {
            List<? extends SpannedItem> list = this.f;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    if (next instanceof AdvertsCountCaptionItem) {
                        spannedItem = next;
                        break;
                    }
                }
                spannedItem = spannedItem;
            }
            List<? extends SpannedItem> list2 = this.f;
            shopDetailedRedesignView2.scrollToPosition(list2 != null ? CollectionsKt___CollectionsKt.indexOf(list2, spannedItem) : 0);
        }
    }

    public final void i(ShopContactsSource shopContactsSource) {
        String d2 = d();
        if (d2 != null) {
            this.C.track(new ShopContactsDisplayEvent(d2, shopContactsSource.getValue()));
        }
    }

    public final void j() {
        int i2;
        if (c() == SerpDisplayType.List) {
            i2 = 1;
        } else {
            i2 = this.x.getColumnsCount();
        }
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.setColumnsCount(i2);
        }
        this.t.setColumnsCount(i2);
        this.u.setColumnsCount(i2);
    }

    public final void k(ShopDetailedData shopDetailedData) {
        ShopDetailedData shopDetailedData2 = this.e;
        boolean z2 = false;
        this.c = shopDetailedData2 == null || ((long) shopDetailedData2.getElements().size()) < shopDetailedData2.getCount();
        CompositeDisposable compositeDisposable = this.a;
        ShopDetailedItemsConverter shopDetailedItemsConverter = this.B;
        String str = this.d;
        if (str == null || str.length() == 0) {
            z2 = true;
        }
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.w, shopDetailedItemsConverter.convertToItems(shopDetailedData, z2, this.m, c()).doOnNext(new e(this)).subscribeOn(this.w.computation()), "shopItemConverter.conver…(schedulers.mainThread())"), new f(this)));
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        ShopDetailedPresenter.Router router;
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null && (router = this.h) != null) {
            router.openFastAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, new TreeClickStreamParent(this.E.nextStateId(), ScreenIdField.SHOP_DETAILS.name(), null, null), advertItem.isMarketplace());
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (!this.i) {
            f(false);
        }
    }

    @Override // com.avito.android.shop.detailed.AwardsClickListener
    public void onAwardsClicked(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        ShopDetailedPresenter.Router router = this.h;
        if (router != null) {
            router.openAwards(awardsItem);
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedViewPresenter
    public void onCallButtonPressed() {
        ShopDetailedPresenter.Router router;
        this.C.track(new ShopCallButtonClickEvent(this.q));
        List<Action> list = this.n;
        if (list == null) {
            return;
        }
        if (list.size() == 1) {
            DeepLink deepLink = list.get(0).getDeepLink();
            if (deepLink instanceof PhoneLink.Call) {
                ShopContactsSource shopContactsSource = ShopContactsSource.PHONE;
                i(shopContactsSource);
                a(((PhoneLink.Call) deepLink).getPhone(), shopContactsSource);
            } else if ((deepLink instanceof PhoneRequestLink) && (router = this.h) != null) {
                router.openPhoneRequest((PhoneRequestLink) deepLink, b());
            }
        } else {
            ShopDetailedRedesignView shopDetailedRedesignView = this.g;
            if (shopDetailedRedesignView != null) {
                shopDetailedRedesignView.showPhoneDialog();
            }
            i(ShopContactsSource.PHONE);
            this.o = true;
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void onCallFailed() {
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.showError(this.x.getCantDoCallString());
        }
    }

    @Override // com.avito.android.shop.detailed.ShopHeaderListener
    public void onContactsExpanded() {
        i(ShopContactsSource.CONTACTS);
    }

    @Override // com.avito.android.shop.detailed.ShopHeaderListener
    public void onDeepLinkFollowed(@NotNull DeepLink deepLink, @NotNull ShopContactsSource shopContactsSource) {
        String str;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(shopContactsSource, "shopContactsSource");
        if (deepLink instanceof PhoneLink.Call) {
            this.C.track(new ShopContactSelectEvent("phone", this.q));
            a(((PhoneLink.Call) deepLink).getPhone(), shopContactsSource);
        } else if (deepLink instanceof PromoLink) {
            this.C.track(new ShopContactSelectEvent("web", this.q));
            ShopDetailedPresenter.Router router = this.h;
            if (router != null) {
                router.openUrl(((PromoLink) deepLink).getExtendedUrl());
            }
        } else if (deepLink instanceof ShopRatingDetailsLink) {
            ShopDetailedData shopDetailedData = this.e;
            Map<String, String> map = null;
            ShopElement shop = shopDetailedData != null ? shopDetailedData.getShop() : null;
            if (shop instanceof ShopGold) {
                map = ((ShopGold) shop).getAnalytics();
            } else if (shop instanceof ShopRegular) {
                map = ((ShopRegular) shop).getAnalytics();
            }
            if (!(map == null || (str = map.get("rating")) == null)) {
                this.C.track(new PublicRatingDetailsOpenEvent(str));
            }
            ShopDetailedPresenter.Router router2 = this.h;
            if (router2 != null) {
                router2.followDeepLink(deepLink);
            }
        } else if (deepLink instanceof PhoneRequestLink) {
            ShopDetailedPresenter.Router router3 = this.h;
            if (router3 != null) {
                router3.openPhoneRequest((PhoneRequestLink) deepLink, b());
            }
        } else {
            ShopDetailedPresenter.Router router4 = this.h;
            if (router4 != null) {
                router4.followDeepLink(deepLink);
            }
        }
    }

    @Override // com.avito.android.shop.detailed.ShopHeaderListener
    public void onDescriptionCollapsed() {
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.scrollToPosition(0);
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.z.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ShopDetailedPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedViewPresenter
    public void onPhoneDialogDismissed() {
        this.o = false;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedViewPresenter
    public void onRefresh() {
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.showLoading();
        }
        f(true);
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putBoolean("has_more_pages", Boolean.valueOf(this.c));
        kundle.putSerializable("has_error", this.j);
        kundle.putString("query", this.d);
        kundle.putParcelable("shop_adverts", new CompressedParcelable(this.e));
        kundle.putParcelableList("phone_action", this.n);
        kundle.putBoolean("phone_dialog_shown", Boolean.valueOf(this.o));
        kundle.putParcelable("search_params", new CompressedParcelable(this.p));
        return kundle;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void onSearchClarified(@NotNull DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        if (!(deepLink2 instanceof ItemsSearchLink)) {
            deepLink2 = null;
        }
        ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink2;
        if (itemsSearchLink != null) {
            this.m = true;
            this.a.clear();
            this.i = false;
            this.e = null;
            this.c = true;
            ShopDetailedRedesignView shopDetailedRedesignView = this.g;
            if (shopDetailedRedesignView != null) {
                shopDetailedRedesignView.showLoading();
            }
            SearchParams searchParams = itemsSearchLink.getSearchParams();
            this.p = searchParams;
            SerpDisplayType displayType = searchParams.getDisplayType();
            if (displayType != null && displayType.isInformative()) {
                this.p = SearchParams.copy$default(this.p, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, SerpDisplayType.List, null, null, null, 7864319, null);
            }
            j();
            f(true);
            g();
        }
    }

    @Override // com.avito.android.shop.detailed.ShopHeaderListener
    public void onShowPopup(@Nullable String str, @Nullable String str2, @Nullable Action action) {
        ShopDetailedPresenter.Router router = this.h;
        if (router != null) {
            router.showPopup(str, str2, action);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionStateListener
    public void onSubscribeInfoChanged(@Nullable SubscribeInfo subscribeInfo) {
        ShopDetailedData shopDetailedData = this.e;
        if (shopDetailedData != null) {
            ShopElement shop = shopDetailedData.getShop();
            if (shop instanceof ShopGold) {
                ((ShopGold) shop).setSubscribeInfo(subscribeInfo);
            } else if (shop instanceof ShopRegular) {
                ((ShopRegular) shop).setSubscribeInfo(subscribeInfo);
            }
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedViewPresenter
    public void onUpPressed() {
        ShopDetailedPresenter.Router router = this.h;
        if (router != null) {
            router.closeShop();
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void setIsRestored() {
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ShopDetailedRedesignView shopDetailedRedesignView = this.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.showMessage(str);
        }
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedPresenter
    @NotNull
    public MutableLiveData<String> getMakeCallStream() {
        return this.K;
    }
}
