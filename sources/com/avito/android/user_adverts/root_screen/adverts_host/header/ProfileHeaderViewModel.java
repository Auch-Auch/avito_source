package com.avito.android.user_adverts.root_screen.adverts_host.header;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.OrdersInfo;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.notification.NotificationsCount;
import com.avito.android.user_adverts.ProfileConfig;
import com.avito.android.user_adverts.SoaData;
import com.avito.android.user_adverts.SoaProgressState;
import com.avito.android.user_adverts.events.OrdersInfoWasClickedEvent;
import com.avito.android.user_adverts.events.SoaStatisticsWasShownEvent;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardState;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.LiveDatasKt;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0001B\\\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020}\u0012\u0006\u0010q\u001a\u00020n\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010u\u001a\u00020r\u0012\u0006\u0010|\u001a\u00020y\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010@\u001a\u00020=¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u000bJ\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u000bJ\r\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u000bJ\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000bJ\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000bJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u000bJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\tH\u0014¢\u0006\u0004\b!\u0010\u000bJ\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b\"\u0010\u000bJ\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJ\r\u0010$\u001a\u00020\t¢\u0006\u0004\b$\u0010\u000bR\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020\f*\u00020)8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001f\u00106\u001a\b\u0012\u0004\u0012\u00020\f018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010'R\u001f\u0010<\u001a\b\u0012\u0004\u0012\u000209018\u0006@\u0006¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u00105R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u0002090-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010/R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001f\u0010a\u001a\b\u0012\u0004\u0012\u00020W018\u0006@\u0006¢\u0006\f\n\u0004\b_\u00103\u001a\u0004\b`\u00105R\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020b0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010/R\u0018\u0010f\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010'R\u001f\u0010i\u001a\b\u0012\u0004\u0012\u00020b018\u0006@\u0006¢\u0006\f\n\u0004\bg\u00103\u001a\u0004\bh\u00105R\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020v0V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010YR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020v018\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u00105R\u0019\u0010\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0007\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010'¨\u0006\u0001"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "smbStats", "", "statsOnboarding", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loaded;", "d", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;Ljava/lang/String;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loaded;", "", "onUpdateNotifications", "()V", "", "delaySoaUpdate", "soaUpdateText", "soaAdvertId", "setSoaUpdateParams", "(ZLjava/lang/String;Ljava/lang/String;)V", "checkShowSearchIfRequired", "updateSoaIfNecessary", "onClickProfile", "onClickSettings", "onClickNotifications", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "onOrdersInfoClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onClickSmbStats", "onCloseSoaOnboarding", "onCloseSmbStatsOnboarding", "onClickStartPublish", "onSoaUpdateAnimationFinished", "dispose", "onCleared", "updateSoaImmediately", "updateOrdersInfo", "loadBootstrapConfig", "Lio/reactivex/disposables/Disposable;", "i", "Lio/reactivex/disposables/Disposable;", "soaDisposable", "Lcom/avito/android/user_adverts/SoaData;", "e", "(Lcom/avito/android/user_adverts/SoaData;)Z", "isEmpty", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "o", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "profileSearchLiveData", "Landroidx/lifecycle/LiveData;", "t", "Landroidx/lifecycle/LiveData;", "getProfileItemsSearch", "()Landroidx/lifecycle/LiveData;", "profileItemsSearch", "k", "notificationDisposable", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "u", "getRouter", "router", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "D", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "resourcesProvider", "Lcom/avito/android/remote/model/OrdersInfo;", "Lcom/avito/android/remote/model/OrdersInfo;", "ordersInfoCache", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "y", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "charityInteractor", "p", "routerActionLiveData", "Lio/reactivex/disposables/CompositeDisposable;", a2.g.r.g.a, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/analytics/Analytics;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState;", VKApiConst.Q, "Landroidx/lifecycle/MutableLiveData;", "menuPanelLiveData", "Lcom/avito/android/util/SchedulersFactory;", "z", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", VKApiConst.VERSION, "getMenuPanelState", "menuPanelState", "", "n", "notificationLiveData", "j", "ordersDisposable", "s", "getNotificationCounter", "notificationCounter", "La2/a/a/i3/c/a/i/d;", "c", "La2/a/a/i3/c/a/i/d;", "soaUpdateParamsCache", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "x", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "profileHeaderInteractor", "Lcom/avito/android/account/AccountStateProvider;", "B", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/remote/model/ProfileInfo;", AuthSource.OPEN_CHANNEL_LIST, "profileLiveData", "Lcom/avito/android/Features;", "C", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "w", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "r", "getProfileInfo", "profileInfo", "l", "Z", "soaInvalidated", "Lcom/avito/android/user_adverts/SoaData;", "soaCache", "Lcom/avito/android/user_adverts/ProfileConfig;", "f", "Lcom/avito/android/user_adverts/ProfileConfig;", "bootConfigCache", "h", "profileSearchDisposable", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;Lcom/avito/android/user_adverts_common/charity/CharityInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "RouterAction", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderViewModel extends ViewModel {
    public final Analytics A;
    public final AccountStateProvider B;
    public final Features C;
    public final ProfileHeaderResourceProvider D;
    public UserAdvertsTabTestGroup E;
    public a2.a.a.i3.c.a.i.d c;
    public SoaData d;
    public OrdersInfo e;
    public ProfileConfig f;
    public final CompositeDisposable g;
    public Disposable h;
    public Disposable i;
    public Disposable j;
    public Disposable k;
    public boolean l;
    public final MutableLiveData<ProfileInfo> m;
    public final SingleLiveEvent<Integer> n;
    public final SingleLiveEvent<Boolean> o;
    public final SingleLiveEvent<RouterAction> p;
    public final MutableLiveData<MenuPanelState> q;
    @NotNull
    public final LiveData<ProfileInfo> r;
    @NotNull
    public final LiveData<Integer> s;
    @NotNull
    public final LiveData<Boolean> t;
    @NotNull
    public final LiveData<RouterAction> u;
    @NotNull
    public final LiveData<MenuPanelState> v;
    public final NotificationCenterCounterInteractor w;
    public final ProfileHeaderInteractor x;
    public final CharityInteractor y;
    public final SchedulersFactory z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "", "<init>", "()V", "DetailsSheet", "Notification", "Orders", "Profile", "Settings", "SmbStats", "StartPublish", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Profile;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Settings;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Notification;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$StartPublish;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$SmbStats;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Orders;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$DetailsSheet;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RouterAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$DetailsSheet;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "component1", "()Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "component2", "()Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", SDKConstants.PARAM_A2U_BODY, "clickEvent", "copy", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$DetailsSheet;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "getBody", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "getClickEvent", "<init>", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class DetailsSheet extends RouterAction {
            @NotNull
            public final DetailsSheetLinkBody a;
            @Nullable
            public final ParametrizedClickStreamEvent b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DetailsSheet(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
                super(null);
                Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
                this.a = detailsSheetLinkBody;
                this.b = parametrizedClickStreamEvent;
            }

            public static /* synthetic */ DetailsSheet copy$default(DetailsSheet detailsSheet, DetailsSheetLinkBody detailsSheetLinkBody, ParametrizedClickStreamEvent parametrizedClickStreamEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    detailsSheetLinkBody = detailsSheet.a;
                }
                if ((i & 2) != 0) {
                    parametrizedClickStreamEvent = detailsSheet.b;
                }
                return detailsSheet.copy(detailsSheetLinkBody, parametrizedClickStreamEvent);
            }

            @NotNull
            public final DetailsSheetLinkBody component1() {
                return this.a;
            }

            @Nullable
            public final ParametrizedClickStreamEvent component2() {
                return this.b;
            }

            @NotNull
            public final DetailsSheet copy(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
                Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
                return new DetailsSheet(detailsSheetLinkBody, parametrizedClickStreamEvent);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DetailsSheet)) {
                    return false;
                }
                DetailsSheet detailsSheet = (DetailsSheet) obj;
                return Intrinsics.areEqual(this.a, detailsSheet.a) && Intrinsics.areEqual(this.b, detailsSheet.b);
            }

            @NotNull
            public final DetailsSheetLinkBody getBody() {
                return this.a;
            }

            @Nullable
            public final ParametrizedClickStreamEvent getClickEvent() {
                return this.b;
            }

            public int hashCode() {
                DetailsSheetLinkBody detailsSheetLinkBody = this.a;
                int i = 0;
                int hashCode = (detailsSheetLinkBody != null ? detailsSheetLinkBody.hashCode() : 0) * 31;
                ParametrizedClickStreamEvent parametrizedClickStreamEvent = this.b;
                if (parametrizedClickStreamEvent != null) {
                    i = parametrizedClickStreamEvent.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("DetailsSheet(body=");
                L.append(this.a);
                L.append(", clickEvent=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Notification;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Notification extends RouterAction {
            @NotNull
            public static final Notification INSTANCE = new Notification();

            public Notification() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Orders;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Orders;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Orders extends RouterAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Orders(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                this.a = deepLink;
            }

            public static /* synthetic */ Orders copy$default(Orders orders, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = orders.a;
                }
                return orders.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final Orders copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                return new Orders(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Orders) && Intrinsics.areEqual(this.a, ((Orders) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.m(a2.b.a.a.a.L("Orders(deeplink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Profile;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Profile extends RouterAction {
            @NotNull
            public static final Profile INSTANCE = new Profile();

            public Profile() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$Settings;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Settings extends RouterAction {
            @NotNull
            public static final Settings INSTANCE = new Settings();

            public Settings() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$SmbStats;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$SmbStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class SmbStats extends RouterAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SmbStats(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                this.a = deepLink;
            }

            public static /* synthetic */ SmbStats copy$default(SmbStats smbStats, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = smbStats.a;
                }
                return smbStats.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final SmbStats copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                return new SmbStats(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof SmbStats) && Intrinsics.areEqual(this.a, ((SmbStats) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.m(a2.b.a.a.a.L("SmbStats(deeplink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction$StartPublish;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel$RouterAction;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class StartPublish extends RouterAction {
            @NotNull
            public static final StartPublish INSTANCE = new StartPublish();

            public StartPublish() {
                super(null);
            }
        }

        public RouterAction() {
        }

        public RouterAction(t6.r.a.j jVar) {
        }
    }

    public static final class a<T> implements Consumer<ProfileInfo> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public a(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ProfileInfo profileInfo) {
            ProfileInfo profileInfo2 = profileInfo;
            this.a.m.setValue(profileInfo2);
            if (profileInfo2.getName() != null) {
                this.a.updateSoaImmediately();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observe user profile info", th);
        }
    }

    public static final class c<T> implements Predicate<Boolean> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "it");
            return bool2.booleanValue();
        }
    }

    public static final class d<T, R> implements Function<Boolean, SingleSource<? extends ProfileConfig>> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public d(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ProfileConfig> apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return this.a.x.loadProfileItemsConfig();
        }
    }

    public static final class e<T> implements Consumer<ProfileConfig> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public e(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ProfileConfig profileConfig) {
            ProfileConfig profileConfig2 = profileConfig;
            this.a.f = profileConfig2;
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
            this.a.o.setValue(Boolean.valueOf(profileConfig2.isSearchAvailable()));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public f(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.o.setValue(null);
            ProfileHeaderViewModel profileHeaderViewModel = this.a;
            ProfileConfig profileConfig = profileHeaderViewModel.f;
            if (profileConfig == null) {
                profileConfig = ProfileHeaderViewModelKt.getDEFAULT_BOOT_CONFIG();
            }
            profileHeaderViewModel.f = profileConfig;
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
            Logs.error("profileItemsSearchCheck", th2);
        }
    }

    public static final class g<T> implements Consumer<SoaData> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public g(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(SoaData soaData) {
            a2.a.a.i3.c.a.i.d dVar = this.a.c;
            String str = dVar != null ? dVar.c : null;
            this.a.c = null;
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
            ProfileHeaderViewModel.access$requestCharityDialog(this.a, str);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to delay cached soa", th);
        }
    }

    public static final class i<T> implements Consumer<NotificationsCount> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public i(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(NotificationsCount notificationsCount) {
            this.a.n.setValue(Integer.valueOf(notificationsCount.getUnread()));
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observe notification center", th);
        }
    }

    public static final class k extends Lambda implements Function1<Boolean, Boolean> {
        public static final k a = new k();

        public k() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Boolean bool) {
            Boolean bool2 = bool;
            return Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
        }
    }

    public static final class l<T> implements Consumer<LoadingState<? super OrdersInfo>> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public l(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super OrdersInfo> loadingState) {
            LoadingState<? super OrdersInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.e = (OrdersInfo) ((LoadingState.Loaded) loadingState2).getData();
            } else if (loadingState2 instanceof LoadingState.Error) {
                ProfileHeaderViewModel profileHeaderViewModel = this.a;
                OrdersInfo ordersInfo = profileHeaderViewModel.e;
                if (ordersInfo == null) {
                    ordersInfo = ProfileHeaderViewModelKt.getDEFAULT_ORDERS_INFO();
                }
                profileHeaderViewModel.e = ordersInfo;
            }
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class n<T> implements Consumer<SoaData.Value> {
        public final /* synthetic */ ProfileHeaderViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public n(ProfileHeaderViewModel profileHeaderViewModel, String str, boolean z, String str2) {
            this.a = profileHeaderViewModel;
            this.b = str;
            this.c = z;
            this.d = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(SoaData.Value value) {
            String currentUserId;
            SoaData.Value value2 = value;
            ProfileHeaderViewModel profileHeaderViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(value2, "soaData");
            if (!profileHeaderViewModel.e(value2) && (currentUserId = this.a.B.getCurrentUserId()) != null) {
                this.a.A.track(new SoaStatisticsWasShownEvent(currentUserId));
            }
            String str = this.b;
            boolean z = false;
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                this.a.c = new a2.a.a.i3.c.a.i.d(this.c, this.b, this.d, SoaProgressState.COLLAPSE);
            } else {
                ProfileHeaderViewModel.access$requestCharityDialog(this.a, this.d);
            }
            this.a.d = value2;
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
        }
    }

    public static final class o<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileHeaderViewModel a;

        public o(ProfileHeaderViewModel profileHeaderViewModel) {
            this.a = profileHeaderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ProfileHeaderViewModel profileHeaderViewModel = this.a;
            SoaData soaData = profileHeaderViewModel.d;
            if (soaData == null) {
                soaData = SoaData.Failure.INSTANCE;
            }
            profileHeaderViewModel.d = soaData;
            this.a.q.setValue(ProfileHeaderViewModel.c(this.a, null, null, null, null, null, null, 63));
        }
    }

    public ProfileHeaderViewModel(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @NotNull ProfileHeaderInteractor profileHeaderInteractor, @NotNull CharityInteractor charityInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider, @NotNull Features features, @NotNull ProfileHeaderResourceProvider profileHeaderResourceProvider, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(profileHeaderInteractor, "profileHeaderInteractor");
        Intrinsics.checkNotNullParameter(charityInteractor, "charityInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(profileHeaderResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        this.w = notificationCenterCounterInteractor;
        this.x = profileHeaderInteractor;
        this.y = charityInteractor;
        this.z = schedulersFactory;
        this.A = analytics;
        this.B = accountStateProvider;
        this.C = features;
        this.D = profileHeaderResourceProvider;
        this.E = userAdvertsTabTestGroup;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.g = compositeDisposable;
        MutableLiveData<ProfileInfo> mutableLiveData = new MutableLiveData<>();
        this.m = mutableLiveData;
        SingleLiveEvent<Integer> singleLiveEvent = new SingleLiveEvent<>();
        this.n = singleLiveEvent;
        SingleLiveEvent<Boolean> singleLiveEvent2 = new SingleLiveEvent<>();
        this.o = singleLiveEvent2;
        SingleLiveEvent<RouterAction> singleLiveEvent3 = new SingleLiveEvent<>();
        this.p = singleLiveEvent3;
        MutableLiveData<MenuPanelState> mutableLiveData2 = new MutableLiveData<>();
        this.q = mutableLiveData2;
        this.r = mutableLiveData;
        this.s = singleLiveEvent;
        this.t = LiveDatasKt.map(singleLiveEvent2, k.a);
        this.u = singleLiveEvent3;
        this.v = mutableLiveData2;
        loadBootstrapConfig();
        updateOrdersInfo();
        if (this.E.isTest()) {
            updateSoaImmediately();
            return;
        }
        Disposable subscribe = InteropKt.toV2(accountStorageInteractor.profileInfo()).distinctUntilChanged().observeOn(schedulersFactory.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStorageInteractor…\", it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$requestCharityDialog(ProfileHeaderViewModel profileHeaderViewModel, String str) {
        if (profileHeaderViewModel.C.getCharityDialogs().invoke().booleanValue() && str != null) {
            CompositeDisposable compositeDisposable = profileHeaderViewModel.g;
            Disposable subscribe = InteropKt.toV2(profileHeaderViewModel.y.requestDialog(str, CharityInteractor.Source.SOA)).observeOn(profileHeaderViewModel.z.mainThread()).subscribe(new a2.a.a.i3.c.a.i.a(profileHeaderViewModel), a2.a.a.i3.c.a.i.b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "charityInteractor.reques…alog\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.avito.android.user_adverts.root_screen.adverts_host.header.MenuPanelState c(com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel r20, com.avito.android.user_adverts.SoaData r21, com.avito.android.remote.model.OrdersInfo r22, a2.a.a.i3.c.a.i.d r23, com.avito.android.user_adverts.ProfileConfig r24, java.lang.String r25, java.lang.String r26, int r27) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel.c(com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel, com.avito.android.user_adverts.SoaData, com.avito.android.remote.model.OrdersInfo, a2.a.a.i3.c.a.i.d, com.avito.android.user_adverts.ProfileConfig, java.lang.String, java.lang.String, int):com.avito.android.user_adverts.root_screen.adverts_host.header.MenuPanelState");
    }

    public final void checkShowSearchIfRequired() {
        if (this.o.getValue() == null) {
            Disposable disposable = this.h;
            if (disposable != null) {
                disposable.dispose();
            }
            loadBootstrapConfig();
        }
    }

    public final CardState.Loaded d(CardData cardData, String str) {
        return new CardState.Loaded(cardData, str != null ? new OnboardingData(str, ProfileHeaderView.ClickTarget.CloseSmbOnboarding.INSTANCE) : null, null, 4, null);
    }

    public final void dispose() {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean e(SoaData soaData) {
        if (soaData instanceof SoaData.Value) {
            if (((SoaData.Value) soaData).getValue().length() == 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final LiveData<MenuPanelState> getMenuPanelState() {
        return this.v;
    }

    @NotNull
    public final LiveData<Integer> getNotificationCounter() {
        return this.s;
    }

    @NotNull
    public final LiveData<ProfileInfo> getProfileInfo() {
        return this.r;
    }

    @NotNull
    public final LiveData<Boolean> getProfileItemsSearch() {
        return this.t;
    }

    @NotNull
    public final LiveData<RouterAction> getRouter() {
        return this.u;
    }

    public final void loadBootstrapConfig() {
        this.h = InteropKt.toV2(this.B.authorized()).filter(c.a).switchMapSingle(new d(this)).observeOn(this.z.mainThread()).subscribe(new e(this), new f(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.i;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.h;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.j;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.g.dispose();
        dispose();
        super.onCleared();
    }

    public final void onClickNotifications() {
        this.p.setValue(RouterAction.Notification.INSTANCE);
    }

    public final void onClickProfile() {
        this.p.setValue(RouterAction.Profile.INSTANCE);
        this.l = true;
    }

    public final void onClickSettings() {
        this.p.setValue(RouterAction.Settings.INSTANCE);
    }

    public final void onClickSmbStats(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.p.setValue(new RouterAction.SmbStats(deepLink));
    }

    public final void onClickStartPublish() {
        this.p.setValue(RouterAction.StartPublish.INSTANCE);
    }

    public final void onCloseSmbStatsOnboarding() {
        this.x.setSmbOnboardingClosed();
        this.q.setValue(c(this, null, null, null, null, null, null, 15));
    }

    public final void onCloseSoaOnboarding() {
        this.x.setSoaOnboardingShown();
        this.q.setValue(c(this, null, null, null, null, null, null, 15));
    }

    public final void onOrdersInfoClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.A.track(new OrdersInfoWasClickedEvent(null, 1, null));
        this.p.setValue(new RouterAction.Orders(deepLink));
    }

    public final void onSoaUpdateAnimationFinished() {
        SoaData soaData = this.d;
        if (soaData != null) {
            CompositeDisposable compositeDisposable = this.g;
            Observable just = Observable.just(soaData);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            Disposable subscribe = just.delay(1, TimeUnit.SECONDS, this.z.computation()).observeOn(this.z.mainThread()).subscribe(new g(this), h.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "cachedSoa.toSingletonObs… soa\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void onUpdateNotifications() {
        if (!this.E.isTest()) {
            Disposable disposable = this.k;
            if (disposable != null) {
                disposable.dispose();
            }
            this.k = InteropKt.toV2(this.w.getCount()).observeOn(this.z.mainThread()).subscribe(new i(this), j.a);
        }
    }

    public final void setSoaUpdateParams(boolean z2, @Nullable String str, @Nullable String str2) {
        SoaProgressState soaProgressState = SoaProgressState.PROGRESS;
        boolean z3 = false;
        if (str != null) {
            if (str.length() > 0) {
                z3 = true;
            }
        }
        if (!z3) {
            soaProgressState = null;
        }
        this.c = new a2.a.a.i3.c.a.i.d(z2, str, str2, soaProgressState);
    }

    public final void updateOrdersInfo() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j = this.x.getOrdersInfo().observeOn(this.z.mainThread()).subscribe(new l(this), m.a);
    }

    public final void updateSoaIfNecessary() {
        Disposable disposable;
        if (this.l || (((disposable = this.i) == null || disposable.isDisposed()) && Intrinsics.areEqual(this.d, SoaData.Failure.INSTANCE))) {
            this.l = false;
            this.d = null;
            updateSoaImmediately();
        }
        if (this.f == null) {
            loadBootstrapConfig();
        }
        OrdersInfo ordersInfo = this.e;
        if (ordersInfo == null || Intrinsics.areEqual(ordersInfo, ProfileHeaderViewModelKt.getDEFAULT_ORDERS_INFO())) {
            updateOrdersInfo();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSoaImmediately() {
        /*
            r14 = this;
            a2.a.a.i3.c.a.i.d r0 = r14.c
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.lang.String r2 = r0.b
            goto L_0x0009
        L_0x0008:
            r2 = r1
        L_0x0009:
            r3 = 0
            if (r0 == 0) goto L_0x000f
            boolean r4 = r0.a
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0014
            java.lang.String r1 = r0.c
        L_0x0014:
            r0 = 1
            if (r2 == 0) goto L_0x0024
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x001f
            r5 = 1
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            if (r5 == 0) goto L_0x0039
            androidx.lifecycle.MutableLiveData<com.avito.android.user_adverts.root_screen.adverts_host.header.MenuPanelState> r5 = r14.q
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r6 = r14
            com.avito.android.user_adverts.root_screen.adverts_host.header.MenuPanelState r6 = c(r6, r7, r8, r9, r10, r11, r12, r13)
            r5.setValue(r6)
        L_0x0039:
            io.reactivex.disposables.Disposable r5 = r14.i
            if (r5 == 0) goto L_0x0040
            r5.dispose()
        L_0x0040:
            if (r2 == 0) goto L_0x004e
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x004a
            r5 = 1
            goto L_0x004b
        L_0x004a:
            r5 = 0
        L_0x004b:
            if (r5 == 0) goto L_0x004e
            r3 = 1
        L_0x004e:
            if (r4 == 0) goto L_0x0068
            r5 = 1
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            com.avito.android.util.SchedulersFactory r7 = r14.z
            io.reactivex.Scheduler r7 = r7.computation()
            io.reactivex.Observable r0 = io.reactivex.Observable.timer(r5, r0, r7)
            a2.a.a.i3.c.a.i.c r5 = new a2.a.a.i3.c.a.i.c
            r5.<init>(r14)
            io.reactivex.Observable r0 = r0.flatMap(r5)
            goto L_0x006e
        L_0x0068:
            com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor r0 = r14.x
            io.reactivex.Observable r0 = r0.getSoaInfo()
        L_0x006e:
            if (r3 == 0) goto L_0x007e
            r5 = 6
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            io.reactivex.Observable r0 = r0.timeout(r5, r3)
            java.lang.String r3 = "soaObservable.timeout(SO…IMEOUT, TimeUnit.SECONDS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x0083
        L_0x007e:
            java.lang.String r3 = "soaObservable"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x0083:
            com.avito.android.util.SchedulersFactory r3 = r14.z
            io.reactivex.Scheduler r3 = r3.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r3)
            com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel$n r3 = new com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel$n
            r3.<init>(r14, r2, r4, r1)
            com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel$o r1 = new com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel$o
            r1.<init>(r14)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r3, r1)
            r14.i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel.updateSoaImmediately():void");
    }
}
