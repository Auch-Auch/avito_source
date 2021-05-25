package com.avito.android.grouping_adverts;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialogEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerConfirmedEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhoneRequestData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenter;
import com.avito.android.grouping_adverts.GroupingAdvertsRouter;
import com.avito.android.grouping_adverts.GroupingAdvertsView;
import com.avito.android.home.appending_item.loader.AppendingLoaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.AreaSearchParams;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParam;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.serp.CallInfo;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B½\u0001\b\u0007\u0012\b\u0010·\u0001\u001a\u00030´\u0001\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010g\u001a\u00020d\u0012\b\u0010¥\u0001\u001a\u00030¢\u0001\u0012\u0006\u0010u\u001a\u00020r\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010«\u0001\u001a\u00030¨\u0001\u0012\u0006\u0010}\u001a\u00020z\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010n\u001a\u00020k\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u000e\b\u0001\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00110v\u0012\u0006\u0010^\u001a\u00020[\u0012\u000e\b\u0001\u0010c\u001a\b\u0012\u0004\u0012\u00020`0_\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010Z\u001a\u00020W\u0012\t\u0010¸\u0001\u001a\u0004\u0018\u000104¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J'\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0005J)\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b7\u00103J3\u0010:\u001a\u00020\u00032\u0006\u0010,\u001a\u0002082\u0006\u0010-\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b:\u0010;J3\u0010<\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b<\u0010=J'\u0010>\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b>\u0010\u0018J'\u0010?\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b?\u0010\u0018J\u0017\u0010@\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b@\u00103J'\u0010D\u001a\u00020\u00032\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\bD\u0010EJ!\u0010J\u001a\u00020\u00032\u0006\u0010G\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0003H\u0016¢\u0006\u0004\bL\u0010\u0005J\u000f\u0010M\u001a\u00020FH\u0016¢\u0006\u0004\bM\u0010NJ\u0018\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020OH\u0001¢\u0006\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020`0_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00110v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\f\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001R\u0018\u0010\u0001\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010 \u0001\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010iR\u0018\u0010¡\u0001\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0004\u0010\u0001R\u001a\u0010¥\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R \u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010¦\u0001R\u001a\u0010«\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R#\u0010³\u0001\u001a\f\u0012\u0005\u0012\u00030°\u0001\u0018\u00010¯\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001a\u0010·\u0001\u001a\u00030´\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001¨\u0006»\u0001"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenterImpl;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "", a2.g.r.g.a, "()V", "", "Lcom/avito/android/remote/model/SerpElement;", "data", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/SerpDisplayType;", "c", "()Lcom/avito/android/remote/model/SerpDisplayType;", "", "d", "()I", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "h", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "e", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "f", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "source", "i", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "Lcom/avito/android/grouping_adverts/GroupingAdvertsView;", "view", "attachView", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsView;)V", "Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;", "router", "attachRouter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;)V", "detachRouter", "detachView", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "onAdditionalActionClicked", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "galleryPosition", "onRichAdvertXlClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "onRichAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "onCallActionClicked", "onWriteActionClicked", "onDeepLinkActionClicked", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "src", "showAuth", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "", "success", "Landroid/os/Parcelable;", "authResultData", "onUserAuthorized", "(ZLandroid/os/Parcelable;)V", "onAppend", "canAppend", "()Z", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "o", "Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "interactor", "Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;", "D", "Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;", "itemsFilter", "Lcom/avito/android/analytics/Analytics;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "B", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "justDialSellerPhoneTestGroup", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "p", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "serpAnalyticsInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "w", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "r", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/Formatter;", "z", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "u", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "y", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "clickStreamLinkHandler", "Lcom/avito/android/grouping_adverts/GroupingAdvertsView;", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "C", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/grouping_adverts/GroupingAdvertsRouter;", "Z", "isLoading", "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "l", "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "asyncPhoneRequestData", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "s", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "I", "page", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", VKApiConst.VERSION, "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/CallInfo;", "Lcom/avito/android/serp/CallInfo;", "callInfo", "Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;", "x", "Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;", "resourcesProvider", AuthSource.SEND_ABUSE, "disposables", "hasMorePages", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/SerpItemProcessor;", "t", "Lcom/avito/android/serp/SerpItemProcessor;", "serpItemProcessor", "j", "Ljava/lang/Integer;", "authRequestedFor", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "k", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "n", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "advertsArguments", "state", "<init>", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;Lcom/avito/android/deep_linking/ClickStreamLinkHandler;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;Lcom/avito/android/util/Kundle;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsPresenterImpl implements GroupingAdvertsPresenter, FavoriteButtonClickListener {
    public final Analytics A;
    public final AbTestGroup<SimpleTestGroupWithControl2> B;
    public final AsyncPhonePresenter C;
    public final GroupingAdvertsItemsFilter D;
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public GroupingAdvertsView c;
    public GroupingAdvertsRouter d;
    public boolean e;
    public List<? extends SerpElement> f;
    public boolean g;
    public int h;
    public CallInfo i;
    public Integer j;
    public DataSource<ViewTypeSerpItem> k;
    public AsyncPhoneRequestData l;
    public SerpDisplayType m;
    public GroupingAdvertsArguments n;
    public final GroupingAdvertsInteractor o;
    public final SerpAnalyticsInteractor p;
    public final SchedulersFactory3 q;
    public final AdapterPresenter r;
    public final FavoriteAdvertsPresenter s;
    public final SerpItemProcessor t;
    public final ViewedAdvertsPresenter u;
    public final SerpSpanProvider v;
    public final SpannedGridPositionProvider w;
    public final GroupingAdvertsResourcesProvider x;
    public final ClickStreamLinkHandler y;
    public final Formatter<String> z;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        public a(int i) {
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
            } else if (i == 2) {
                Logs.error(th);
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
                ((GroupingAdvertsPresenterImpl) this.b).g();
            } else if (i == 1) {
                GroupingAdvertsRouter groupingAdvertsRouter = ((GroupingAdvertsPresenterImpl) this.b).d;
                if (groupingAdvertsRouter != null) {
                    groupingAdvertsRouter.leaveScreen();
                }
            } else if (i == 2) {
                GroupingAdvertsArguments groupingAdvertsArguments = ((GroupingAdvertsPresenterImpl) this.b).n;
                Objects.requireNonNull(groupingAdvertsArguments, "null cannot be cast to non-null type com.avito.android.grouping_adverts.GroupingAdvertsArguments.Search");
                SearchParams params = ((GroupingAdvertsArguments.Search) groupingAdvertsArguments).getParams();
                GroupingAdvertsRouter groupingAdvertsRouter2 = ((GroupingAdvertsPresenterImpl) this.b).d;
                if (groupingAdvertsRouter2 != null) {
                    groupingAdvertsRouter2.showFiltersScreen(params, params.getArea());
                }
            } else {
                throw null;
            }
        }
    }

    public static final class c<T, R> implements Function<List<? extends ViewTypeSerpItem>, List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;

        public c(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl) {
            this.a = groupingAdvertsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends ViewTypeSerpItem> apply(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            if (!this.a.g) {
                return list2;
            }
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
            GroupingAdvertsPresenterImpl.access$addLoader(this.a, mutableList);
            return CollectionsKt___CollectionsKt.toList(mutableList);
        }
    }

    public static final class d<T> implements Consumer<List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;

        public d(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl) {
            this.a = groupingAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            GroupingAdvertsPresenterImpl.access$bindData(groupingAdvertsPresenterImpl, list2);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class f<T> implements Consumer<LoadingState<? super SerpElementResult>> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;

        public f(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl) {
            this.a = groupingAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super SerpElementResult> loadingState) {
            LoadingState<? super SerpElementResult> loadingState2 = loadingState;
            GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            GroupingAdvertsPresenterImpl.access$onGroupingAdvertsLoadingStateChanged(groupingAdvertsPresenterImpl, loadingState2);
            this.a.e = false;
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;

        public g(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl) {
            this.a = groupingAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.e = false;
            GroupingAdvertsView groupingAdvertsView = this.a.c;
            if (groupingAdvertsView != null) {
                GroupingAdvertsView.DefaultImpls.showLoadingError$default(groupingAdvertsView, null, 1, null);
            }
        }
    }

    public static final class h extends Lambda implements Function1<DeepLink, Unit> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, String str, ContactSource contactSource) {
            super(1);
            this.a = groupingAdvertsPresenterImpl;
            this.b = str;
            this.c = contactSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullParameter(deepLink2, "link");
            this.a.i = new CallInfo(this.b, deepLink2, this.c);
            this.a.e();
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PhoneLink d;
        public final /* synthetic */ String e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, String str, String str2, PhoneLink phoneLink, String str3) {
            super(0);
            this.a = groupingAdvertsPresenterImpl;
            this.b = str;
            this.c = str2;
            this.d = phoneLink;
            this.e = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i = null;
            this.a.A.track(new CallToSellerConfirmedEvent(this.b, this.c));
            GroupingAdvertsRouter groupingAdvertsRouter = this.a.d;
            if (groupingAdvertsRouter != null) {
                groupingAdvertsRouter.followPhoneLink(this.d, new d4(0, this), new d4(1, this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GroupingAdvertsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl) {
            super(0);
            this.a = groupingAdvertsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i = null;
            return Unit.INSTANCE;
        }
    }

    @Inject
    public GroupingAdvertsPresenterImpl(@NotNull GroupingAdvertsArguments groupingAdvertsArguments, @NotNull GroupingAdvertsInteractor groupingAdvertsInteractor, @NotNull SerpAnalyticsInteractor serpAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdapterPresenter adapterPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SerpItemProcessor serpItemProcessor, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GroupingAdvertsResourcesProvider groupingAdvertsResourcesProvider, @NotNull ClickStreamLinkHandler clickStreamLinkHandler, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull Analytics analytics, @JustDialSellerPhoneTestGroup @NotNull AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull GroupingAdvertsItemsFilter groupingAdvertsItemsFilter, @Nullable Kundle kundle) {
        Integer num;
        Integer num2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(groupingAdvertsArguments, "advertsArguments");
        Intrinsics.checkNotNullParameter(groupingAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(serpAnalyticsInteractor, "serpAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "serpItemProcessor");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(groupingAdvertsResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(clickStreamLinkHandler, "clickStreamLinkHandler");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(abTestGroup, "justDialSellerPhoneTestGroup");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(groupingAdvertsItemsFilter, "itemsFilter");
        this.n = groupingAdvertsArguments;
        this.o = groupingAdvertsInteractor;
        this.p = serpAnalyticsInteractor;
        this.q = schedulersFactory3;
        this.r = adapterPresenter;
        this.s = favoriteAdvertsPresenter;
        this.t = serpItemProcessor;
        this.u = viewedAdvertsPresenter;
        this.v = serpSpanProvider;
        this.w = spannedGridPositionProvider;
        this.x = groupingAdvertsResourcesProvider;
        this.y = clickStreamLinkHandler;
        this.z = formatter;
        this.A = analytics;
        this.B = abTestGroup;
        this.C = asyncPhonePresenter;
        this.D = groupingAdvertsItemsFilter;
        SerpDisplayType serpDisplayType = null;
        this.f = kundle != null ? kundle.getParcelableList("key_data") : null;
        int i2 = 1;
        this.g = (kundle == null || (bool = kundle.getBoolean("key_has_more_pages")) == null) ? true : bool.booleanValue();
        if (!(kundle == null || (num2 = kundle.getInt("key_page")) == null)) {
            i2 = num2.intValue();
        }
        this.h = i2;
        this.i = kundle != null ? (CallInfo) kundle.getParcelable("call_info") : null;
        this.j = Integer.valueOf((kundle == null || (num = kundle.getInt("auth_requester_for")) == null) ? -1 : num.intValue());
        this.m = kundle != null ? (SerpDisplayType) kundle.getSerializable("display_type") : serpDisplayType;
        serpSpanProvider.setAppendingListener(this);
    }

    public static void a(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, DeepLink deepLink, String str, String str2, String str3, Image image, Integer num, boolean z2, int i2) {
        GroupingAdvertsRouter groupingAdvertsRouter;
        DeepLink deepLink2 = deepLink;
        String str4 = (i2 & 4) != 0 ? null : str2;
        String str5 = (i2 & 8) != 0 ? null : str3;
        Image image2 = (i2 & 16) != 0 ? null : image;
        int i3 = i2 & 32;
        boolean z3 = deepLink2 instanceof AdvertDetailsLink;
        if (z3) {
            if (!z3) {
                deepLink2 = null;
            }
            AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink2;
            if (advertDetailsLink != null && (groupingAdvertsRouter = groupingAdvertsPresenterImpl.d) != null) {
                groupingAdvertsRouter.openFastAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), str, str4, str5, image2, groupingAdvertsPresenterImpl.p.getParent(), null, z2);
                return;
            }
            return;
        }
        GroupingAdvertsRouter groupingAdvertsRouter2 = groupingAdvertsPresenterImpl.d;
        if (groupingAdvertsRouter2 != null) {
            groupingAdvertsRouter2.followDeepLink(deepLink);
        }
    }

    public static final void access$addLoader(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, List list) {
        Objects.requireNonNull(groupingAdvertsPresenterImpl);
        if ((!list.isEmpty()) && !(CollectionsKt___CollectionsKt.last((List<? extends Object>) list) instanceof AppendingLoaderItem)) {
            list.add(new AppendingLoaderItem(Long.MAX_VALUE, String.valueOf(Long.MAX_VALUE), groupingAdvertsPresenterImpl.d(), false, false, 24, null));
        }
    }

    public static final void access$bindData(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, List list) {
        Objects.requireNonNull(groupingAdvertsPresenterImpl);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (groupingAdvertsPresenterImpl.D.hasRegisteredBlueprint((ViewTypeSerpItem) obj)) {
                arrayList.add(obj);
            }
        }
        ListDataSource listDataSource = new ListDataSource(arrayList);
        groupingAdvertsPresenterImpl.k = listDataSource;
        groupingAdvertsPresenterImpl.r.onDataSourceChanged(listDataSource);
        groupingAdvertsPresenterImpl.s.onDataSourceChanged(listDataSource);
        groupingAdvertsPresenterImpl.u.onDataSourceChanged(listDataSource);
        groupingAdvertsPresenterImpl.v.onDataSourceChanged(listDataSource);
        groupingAdvertsPresenterImpl.w.onDataSourceChanged(listDataSource);
        GroupingAdvertsView groupingAdvertsView = groupingAdvertsPresenterImpl.c;
        if (groupingAdvertsView != null) {
            groupingAdvertsView.notifyDataChanged();
        }
        GroupingAdvertsView groupingAdvertsView2 = groupingAdvertsPresenterImpl.c;
        if (groupingAdvertsView2 != null) {
            groupingAdvertsView2.hideProgress();
        }
    }

    public static final void access$onGroupingAdvertsLoadingStateChanged(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(groupingAdvertsPresenterImpl);
        if (loadingState instanceof LoadingState.Error) {
            GroupingAdvertsView groupingAdvertsView = groupingAdvertsPresenterImpl.c;
            if (groupingAdvertsView != null) {
                groupingAdvertsView.hideProgress();
            }
            TypedError error = ((LoadingState.Error) loadingState).getError();
            if (error instanceof ErrorResult) {
                GroupingAdvertsView groupingAdvertsView2 = groupingAdvertsPresenterImpl.c;
                if (groupingAdvertsView2 != null) {
                    groupingAdvertsView2.showLoadingError(((ErrorResult) error).getMessage());
                    return;
                }
                return;
            }
            GroupingAdvertsView groupingAdvertsView3 = groupingAdvertsPresenterImpl.c;
            if (groupingAdvertsView3 != null) {
                GroupingAdvertsView.DefaultImpls.showLoadingError$default(groupingAdvertsView3, null, 1, null);
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            boolean z2 = false;
            groupingAdvertsPresenterImpl.e = false;
            List<? extends SerpElement> list = groupingAdvertsPresenterImpl.f;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            List<? extends SerpElement> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            mutableList.addAll(((SerpElementResult) loaded.getData()).getElements());
            groupingAdvertsPresenterImpl.f = mutableList;
            if ((!((SerpElementResult) loaded.getData()).getElements().isEmpty()) && (groupingAdvertsPresenterImpl.n instanceof GroupingAdvertsArguments.Search)) {
                z2 = true;
            }
            groupingAdvertsPresenterImpl.g = z2;
            if (z2) {
                groupingAdvertsPresenterImpl.h++;
            }
            groupingAdvertsPresenterImpl.m = ((SerpElementResult) loaded.getData()).getSerpDisplayType();
            GroupingAdvertsView groupingAdvertsView4 = groupingAdvertsPresenterImpl.c;
            if (groupingAdvertsView4 != null) {
                groupingAdvertsView4.setWhiteBackground(groupingAdvertsPresenterImpl.c().isInformative());
            }
            int d2 = groupingAdvertsPresenterImpl.d();
            GroupingAdvertsView groupingAdvertsView5 = groupingAdvertsPresenterImpl.c;
            if (groupingAdvertsView5 != null) {
                groupingAdvertsView5.updateSpanCount(d2);
            }
            groupingAdvertsPresenterImpl.v.setColumnsCount(d2);
            groupingAdvertsPresenterImpl.b(mutableList);
        }
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void attachRouter(@NotNull GroupingAdvertsRouter groupingAdvertsRouter) {
        Intrinsics.checkNotNullParameter(groupingAdvertsRouter, "router");
        this.d = groupingAdvertsRouter;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void attachView(@NotNull GroupingAdvertsView groupingAdvertsView) {
        Intrinsics.checkNotNullParameter(groupingAdvertsView, "view");
        this.c = groupingAdvertsView;
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = groupingAdvertsView.getRetryButtonClicks().observeOn(this.q.mainThread()).subscribe(new b(0, this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.getRetryButtonClick…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = groupingAdvertsView.getUpButtonClicks().observeOn(this.q.mainThread()).subscribe(new b(1, this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.getUpButtonClicks()…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        if (this.n instanceof GroupingAdvertsArguments.Search) {
            groupingAdvertsView.showFilters();
            CompositeDisposable compositeDisposable3 = this.b;
            Disposable subscribe3 = groupingAdvertsView.filterButtonClicks().observeOn(this.q.mainThread()).subscribe(new b(2, this), a.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view.filterButtonClicks(…      }\n                )");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        }
        if (this.f == null) {
            groupingAdvertsView.showProgress();
            g();
        } else {
            e();
            List<? extends SerpElement> list = this.f;
            if (list != null) {
                b(list);
            }
        }
        int d2 = d();
        GroupingAdvertsView groupingAdvertsView2 = this.c;
        if (groupingAdvertsView2 != null) {
            groupingAdvertsView2.updateSpanCount(d2);
        }
        this.v.setColumnsCount(d2);
    }

    public final void b(List<? extends SerpElement> list) {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.t.convert(list, d(), c()).subscribeOn(this.q.io()).observeOn(this.q.mainThread()).map(new c(this)).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "serpItemProcessor.conver…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final SerpDisplayType c() {
        return SerpDisplayTypeKt.orDefault(this.m);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.g;
    }

    public final int d() {
        if (c().isSingleColumn()) {
            return this.x.getColumnsCountForList();
        }
        return this.x.getColumnsCount();
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void detachView() {
        this.a.clear();
        this.b.clear();
        this.c = null;
    }

    public final void e() {
        CallInfo callInfo = this.i;
        if (callInfo != null) {
            DeepLink callLink = callInfo.getCallLink();
            if (callLink instanceof PhoneLink) {
                f((PhoneLink) callLink, callInfo.getStringId(), callInfo.getContactSource());
            } else if (callLink instanceof CreateChannelLink) {
                CreateChannelLink createChannelLink = (CreateChannelLink) callLink;
                this.p.sendWriteToSellerClick(createChannelLink.getItemId(), callInfo.getContactSource(), createChannelLink.getContext());
                GroupingAdvertsRouter groupingAdvertsRouter = this.d;
                if (groupingAdvertsRouter != null) {
                    groupingAdvertsRouter.followDeepLink(createChannelLink);
                }
            } else if (callLink instanceof AuthenticateLink) {
                this.j = 0;
                GroupingAdvertsRouter groupingAdvertsRouter2 = this.d;
                if (groupingAdvertsRouter2 != null) {
                    GroupingAdvertsRouter.DefaultImpls.showAuth$default(groupingAdvertsRouter2, AuthSource.OPEN_CHANNEL, null, 2, null);
                }
            }
        }
    }

    public final void f(PhoneLink phoneLink, String str, ContactSource contactSource) {
        if (this.B.getTestGroup().isTest()) {
            GroupingAdvertsRouter groupingAdvertsRouter = this.d;
            if (groupingAdvertsRouter == null || !groupingAdvertsRouter.dialPhone(phoneLink)) {
                this.A.track(new ShowPhoneDialerEvent(str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, false, null, null, 24, null));
                i(phoneLink, str, "error", contactSource);
                return;
            }
            this.i = null;
            this.A.track(new ShowPhoneDialerEvent(str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, true, null, null, 24, null));
            return;
        }
        i(phoneLink, str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, contactSource);
    }

    public final void g() {
        Observable<LoadingState<SerpElementResult>> observable;
        this.e = true;
        this.a.clear();
        CompositeDisposable compositeDisposable = this.a;
        GroupingAdvertsArguments groupingAdvertsArguments = this.n;
        if (groupingAdvertsArguments instanceof GroupingAdvertsArguments.Search) {
            observable = this.o.loadGroupedElements(((GroupingAdvertsArguments.Search) groupingAdvertsArguments).getParams(), Integer.valueOf(this.h), this.m);
        } else if (groupingAdvertsArguments instanceof GroupingAdvertsArguments.ItemList) {
            observable = this.o.loadElementsByIds((GroupingAdvertsArguments.ItemList) groupingAdvertsArguments, "landing");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Disposable subscribe = observable.observeOn(this.q.mainThread()).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "loadSerpElements(adverts…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelableList("key_data", this.f).putInt("key_page", Integer.valueOf(this.h)).putBoolean("key_has_more_pages", Boolean.valueOf(this.g)).putParcelable("call_info", this.i).putInt("auth_requester_for", this.j).putSerializable("display_type", this.m);
    }

    public final void h(String str, DeepLink deepLink, ContactSource contactSource) {
        if (deepLink instanceof ClickStreamLink) {
            this.y.handleDeepLink((ClickStreamLink) deepLink, new h(this, str, contactSource));
        } else if (deepLink instanceof PhoneLink) {
            this.i = new CallInfo(str, deepLink, contactSource);
            f((PhoneLink) deepLink, str, contactSource);
        } else if (deepLink instanceof CreateChannelLink) {
            CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
            this.p.sendWriteToSellerClick(createChannelLink.getItemId(), contactSource, createChannelLink.getContext());
            GroupingAdvertsRouter groupingAdvertsRouter = this.d;
            if (groupingAdvertsRouter != null) {
                groupingAdvertsRouter.followDeepLink(createChannelLink);
            }
        } else if (deepLink instanceof AuthenticateLink) {
            this.j = 0;
            GroupingAdvertsRouter groupingAdvertsRouter2 = this.d;
            if (groupingAdvertsRouter2 != null) {
                GroupingAdvertsRouter.DefaultImpls.showAuth$default(groupingAdvertsRouter2, AuthSource.OPEN_CHANNEL, null, 2, null);
            }
        } else {
            GroupingAdvertsRouter groupingAdvertsRouter3 = this.d;
            if (groupingAdvertsRouter3 != null) {
                groupingAdvertsRouter3.followDeepLink(deepLink);
            }
        }
    }

    public final void i(PhoneLink phoneLink, String str, String str2, ContactSource contactSource) {
        Boolean bool = null;
        PhoneLink.Call call = (PhoneLink.Call) (!(phoneLink instanceof PhoneLink.Call) ? null : phoneLink);
        String context = call != null ? call.getContext() : null;
        this.p.sendCallToSellerClick(str, context, contactSource);
        GroupingAdvertsView groupingAdvertsView = this.c;
        if (groupingAdvertsView != null) {
            bool = Boolean.valueOf(groupingAdvertsView.showCallDialog(this.z.format(phoneLink.getPhone()), new i(this, str, context, phoneLink, str2), new j(this)));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            this.A.track(new ShowPhoneDialogEvent(str, str2));
        }
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        a(this, advertItem.getDeepLink(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, null, advertItem.isMarketplace(), 32);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (!this.e) {
            g();
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onCallActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        h(str, deepLink, contactSource);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onDeepLinkActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        GroupingAdvertsRouter groupingAdvertsRouter = this.d;
        if (groupingAdvertsRouter != null) {
            groupingAdvertsRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.s.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        GroupingAdvertsPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        a(this, advertItem.getDeepLink(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, null, advertItem.isMarketplace(), 32);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertXlClicked(@NotNull AdvertXlItem advertXlItem, int i2, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        a(this, advertXlItem.getDeepLink(), advertXlItem.getTitle(), advertXlItem.getPrice(), advertXlItem.getPreviousPrice(), image, null, advertXlItem.isMarketplace(), 32);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void onSearchClarified(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ItemsSearchLink) {
            GroupingAdvertsArguments groupingAdvertsArguments = this.n;
            Objects.requireNonNull(groupingAdvertsArguments, "null cannot be cast to non-null type com.avito.android.grouping_adverts.GroupingAdvertsArguments.Search");
            SearchParams params = ((GroupingAdvertsArguments.Search) groupingAdvertsArguments).getParams();
            Area area = params.getArea();
            this.n = new GroupingAdvertsArguments.Search(((ItemsSearchLink) deepLink).getSearchParams());
            if (area != null) {
                Map<String, SearchParam<?>> params2 = params.getParams();
                params.setParams(params2 != null ? r.plus(params2, new Pair("searchArea", new AreaSearchParams(area))) : null);
            }
            this.h = 1;
            this.f = CollectionsKt__CollectionsKt.emptyList();
            GroupingAdvertsView groupingAdvertsView = this.c;
            if (groupingAdvertsView != null) {
                groupingAdvertsView.showProgress();
            }
            g();
            return;
        }
        GroupingAdvertsRouter groupingAdvertsRouter = this.d;
        if (groupingAdvertsRouter != null) {
            groupingAdvertsRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsPresenter
    public void onUserAuthorized(boolean z2, @Nullable Parcelable parcelable) {
        AsyncPhoneRequestData asyncPhoneRequestData;
        ContactSource contactSource;
        AsyncPhoneRequestData asyncPhoneRequestData2;
        AsyncPhoneItem item;
        Integer num = null;
        if (!(parcelable instanceof AsyncPhoneRequestData)) {
            parcelable = null;
        }
        AsyncPhoneRequestData asyncPhoneRequestData3 = (AsyncPhoneRequestData) parcelable;
        this.l = asyncPhoneRequestData3;
        Integer num2 = this.j;
        if (num2 == null) {
            if (asyncPhoneRequestData3 != null) {
                num2 = 1;
            } else {
                return;
            }
        }
        this.j = null;
        if (!z2) {
            return;
        }
        if (num2 != null && num2.intValue() == 0) {
            GroupingAdvertsView groupingAdvertsView = this.c;
            if (groupingAdvertsView != null) {
                groupingAdvertsView.showProgress();
            }
            g();
        } else if (num2 != null && num2.intValue() == 1 && (asyncPhoneRequestData = this.l) != null && (contactSource = asyncPhoneRequestData.getContactSource()) != null && (asyncPhoneRequestData2 = this.l) != null && (item = asyncPhoneRequestData2.getItem()) != null) {
            SerpItem serpItem = (SerpItem) (!(item instanceof SerpItem) ? null : item);
            if (serpItem != null) {
                DataSource<ViewTypeSerpItem> dataSource = this.k;
                if (dataSource != null) {
                    num = DataSources.itemPosition(dataSource, item.getStringId());
                }
                DeepLink targetLink = AdvertRichItemPresenterKt.getTargetLink(serpItem);
                if (targetLink == null) {
                    return;
                }
                if (targetLink instanceof PhoneRequestLink) {
                    this.C.loadPhoneLink(item, null, targetLink, contactSource, new a2.a.a.x0.a(this, item, contactSource));
                    if (num != null) {
                        int intValue = num.intValue();
                        GroupingAdvertsView groupingAdvertsView2 = this.c;
                        if (groupingAdvertsView2 != null) {
                            groupingAdvertsView2.onItemChanged(intValue);
                            return;
                        }
                        return;
                    }
                    return;
                }
                GroupingAdvertsRouter groupingAdvertsRouter = this.d;
                if (groupingAdvertsRouter != null) {
                    groupingAdvertsRouter.followDeepLink(targetLink);
                }
            }
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onWriteActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        h(str, deepLink, contactSource);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "src");
        GroupingAdvertsPresenter.DefaultImpls.showAuth(this, str);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull String str, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.j = 1;
        AsyncPhoneRequestData asyncPhoneRequestData = new AsyncPhoneRequestData(asyncPhoneItem, contactSource);
        GroupingAdvertsRouter groupingAdvertsRouter = this.d;
        if (groupingAdvertsRouter != null) {
            groupingAdvertsRouter.showAuth(str, asyncPhoneRequestData);
        }
    }
}
