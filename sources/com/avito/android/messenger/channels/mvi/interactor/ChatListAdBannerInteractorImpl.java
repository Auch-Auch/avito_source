package com.avito.android.messenger.channels.mvi.interactor;

import a2.a.a.o1.b.b.b.g;
import a2.a.a.o1.b.b.b.i;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.di.MessengerAdsPreferences;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\tPQORSTUVWB\u0001\u0012\u0006\u0010C\u001a\u00020B\u0012\u0011\u0010.\u001a\r\u0012\t\u0012\u00070*¢\u0006\u0002\b+0)\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020201\u0012\u0006\u0010E\u001a\u00020D\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050F\u0012\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010H\u0012\u0006\u0010J\u001a\u00020\u0002\u0012\u0006\u0010K\u001a\u00020\u0003¢\u0006\u0004\bL\u0010MBl\b\u0017\u0012\u0006\u0010C\u001a\u00020B\u0012\u0011\u0010.\u001a\r\u0012\t\u0012\u00070*¢\u0006\u0002\b+0)\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020201\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bL\u0010NJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0016\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001d\u001a\u00020\u001c2\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R!\u0010.\u001a\r\u0012\t\u0012\u00070*¢\u0006\u0002\b+0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006X"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$ShouldUpdateBannerChecker;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$CommercialBannerFactory;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "", "tryToUpdateBanner", "()V", "hideBanner", "onCleared", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "sendBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "shouldUpdateBanner", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/server_time/TimeSource;)Z", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItems", "samplingEnabled", "Lcom/avito/android/remote/model/CommercialBanner;", "createCommercialBanner", "(Ljava/util/List;Z)Lcom/avito/android/remote/model/CommercialBanner;", "w", "Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "u", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialBannersAnalyticsInteractor", "Lcom/avito/android/util/BuildInfo;", "r", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", VKApiConst.Q, "Lru/avito/messenger/MessengerClient;", "client", VKApiConst.VERSION, "Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", "x", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "adCascadesInChannelsTestGroup", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "onInitSubscriptions", "Lcom/avito/android/location/SavedLocationInteractor;", "s", "Lcom/avito/android/location/SavedLocationInteractor;", "savedLocationInteractor", "Lcom/avito/android/serp/CommercialBannersInteractor;", "t", "Lcom/avito/android/serp/CommercialBannersInteractor;", "bannerInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "Lio/reactivex/Observable;", "stateObservableForTesting", "shouldUpdateBannerChecker", "commercialBannerFactory", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/Features;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;Lio/reactivex/Observable;Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$ShouldUpdateBannerChecker;Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$CommercialBannerFactory;)V", "(Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/Features;)V", "Companion", "BannerCascadeInfo", AuthSource.SEND_ABUSE, "HideBannerMutator", AuthSource.BOOKING_ORDER, "SendBannerOpenedAction", "c", "TryToUpdateBannerAction", "UpdateBannerMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatListAdBannerInteractorImpl extends BaseMviEntityWithReducerQueue<ChatListAdBannerInteractor.State> implements ChatListAdBannerInteractor, ChatListAdBannerInteractor.ShouldUpdateBannerChecker, ChatListAdBannerInteractor.CommercialBannerFactory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final CompositeDisposable p;
    public final MessengerClient<AvitoMessengerApi> q;
    public final BuildInfo r;
    public final SavedLocationInteractor s;
    public final CommercialBannersInteractor t;
    public final CommercialBannersAnalyticsInteractor u;
    public final Preferences v;
    public final TimeSource w;
    public final SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> x;
    public final /* synthetic */ ChatListAdBannerInteractor.ShouldUpdateBannerChecker y;
    public final /* synthetic */ ChatListAdBannerInteractor.CommercialBannerFactory z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$BannerCascadeInfo;", "", "Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "c", "Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "getChatListBannerResponse", "()Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "chatListBannerResponse", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFilteredBanners", "()Ljava/util/List;", "filteredBanners", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLocationId", "()Ljava/lang/String;", "locationId", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class BannerCascadeInfo {
        @NotNull
        public final List<AdNetworkBannerItem<?>> a;
        @NotNull
        public final String b;
        @NotNull
        public final ChatListBannersResponse c;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.AdNetworkBannerItem<?>> */
        /* JADX WARN: Multi-variable type inference failed */
        public BannerCascadeInfo(@NotNull List<? extends AdNetworkBannerItem<?>> list, @NotNull String str, @NotNull ChatListBannersResponse chatListBannersResponse) {
            Intrinsics.checkNotNullParameter(list, "filteredBanners");
            Intrinsics.checkNotNullParameter(str, "locationId");
            Intrinsics.checkNotNullParameter(chatListBannersResponse, "chatListBannerResponse");
            this.a = list;
            this.b = str;
            this.c = chatListBannersResponse;
        }

        @NotNull
        public final ChatListBannersResponse getChatListBannerResponse() {
            return this.c;
        }

        @NotNull
        public final List<AdNetworkBannerItem<?>> getFilteredBanners() {
            return this.a;
        }

        @NotNull
        public final String getLocationId() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$Companion;", "", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItems", "", "samplingEnabled", "Lcom/avito/android/remote/model/CommercialBanner;", "createCommercialBanner", "(Ljava/util/List;Z)Lcom/avito/android/remote/model/CommercialBanner;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ CommercialBanner createCommercialBanner$default(Companion companion, List list, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createCommercialBanner(list, z);
        }

        @NotNull
        public final CommercialBanner createCommercialBanner(@NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "bannerItems");
            return new CommercialBanner(a2.b.a.a.a.I2("UUID.randomUUID().toString()"), list, z, 0, null, 24, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$HideBannerMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class HideBannerMutator extends Mutator<ChatListAdBannerInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public HideBannerMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public ChatListAdBannerInteractor.State invoke(@NotNull ChatListAdBannerInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            ChatListAdBannerInteractorImpl.this.v.putLong("banner_hidden_timestamp", ChatListAdBannerInteractorImpl.this.w.now());
            return state.getBanner() != null ? ChatListAdBannerInteractor.State.copy$default(state, null, null, 0, 0, 0, 30, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$SendBannerOpenedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;)V", "", "e", "I", VKApiConst.POSITION, "Lcom/avito/android/serp/ad/BannerInfo;", "d", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;Lcom/avito/android/serp/ad/BannerInfo;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class SendBannerOpenedAction extends Action<ChatListAdBannerInteractor.State> {
        public final BannerInfo d;
        public final int e;
        public final /* synthetic */ ChatListAdBannerInteractorImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendBannerOpenedAction(@NotNull ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl, BannerInfo bannerInfo, int i) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
            this.f = chatListAdBannerInteractorImpl;
            this.d = bannerInfo;
            this.e = i;
        }

        public void invoke(@NotNull ChatListAdBannerInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerOpened$default(this.f.u, this.d, this.e, null, state.getLocationId(), null, null, 48, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$TryToUpdateBannerAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;)V", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class TryToUpdateBannerAction extends Action<ChatListAdBannerInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public TryToUpdateBannerAction() {
            super(null, null, 3, null);
        }

        public void invoke(@NotNull ChatListAdBannerInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl = ChatListAdBannerInteractorImpl.this;
            if (chatListAdBannerInteractorImpl.shouldUpdateBanner(state, chatListAdBannerInteractorImpl.v, ChatListAdBannerInteractorImpl.this.w)) {
                ChatListAdBannerInteractorImpl.this.x.exposeIfNeeded();
                ChatListAdBannerInteractorImpl.this.getReducerQueue().plusAssign(new UpdateBannerMutator(!((AdCascadesInChannelsTestGroup) ChatListAdBannerInteractorImpl.this.x.getTestGroup()).isTest()));
                return;
            }
            Logs.verbose$default(ChatListAdBannerInteractorImpl.this.getTAG(), "TryToUpdateBannerAction: shouldUpdateBanner == false => Do nothing", null, 4, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl$UpdateBannerMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;)Lio/reactivex/Single;", "", "d", "Z", "loadOnlyYandexAd", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractorImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdateBannerMutator extends MutatorSingle<ChatListAdBannerInteractor.State> {
        public final boolean d;

        public static final class a<T, R> implements Function<BannerCascadeInfo, SingleSource<? extends ChatListAdBannerInteractor.State>> {
            public final /* synthetic */ UpdateBannerMutator a;
            public final /* synthetic */ ChatListAdBannerInteractor.State b;

            public a(UpdateBannerMutator updateBannerMutator, ChatListAdBannerInteractor.State state) {
                this.a = updateBannerMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends ChatListAdBannerInteractor.State> apply(BannerCascadeInfo bannerCascadeInfo) {
                BannerCascadeInfo bannerCascadeInfo2 = bannerCascadeInfo;
                Intrinsics.checkNotNullParameter(bannerCascadeInfo2, "cascadeInfo");
                List<AdNetworkBannerItem<?>> filteredBanners = bannerCascadeInfo2.getFilteredBanners();
                if (!(!filteredBanners.isEmpty())) {
                    return Singles.toSingle(this.b);
                }
                ChatListBannersResponse chatListBannerResponse = bannerCascadeInfo2.getChatListBannerResponse();
                ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl = ChatListAdBannerInteractorImpl.this;
                Boolean enableEventSampling = bannerCascadeInfo2.getChatListBannerResponse().getEnableEventSampling();
                Single<R> subscribeOn = InteropKt.toV2(ChatListAdBannerInteractorImpl.this.t.loadBanner(chatListAdBannerInteractorImpl.createCommercialBanner(filteredBanners, enableEventSampling != null ? enableEventSampling.booleanValue() : false), ChatListAdBannerInteractorImpl.this.t.getPageCdtm(), null, bannerCascadeInfo2.getLocationId())).observeOn(ChatListAdBannerInteractorImpl.this.getSchedulerForReducibles()).firstOrError().map(new g(this, bannerCascadeInfo2, chatListBannerResponse)).subscribeOn(ChatListAdBannerInteractorImpl.this.getSchedulerForReducibles());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "bannerInteractor.loadBan…n(schedulerForReducibles)");
                return subscribeOn;
            }
        }

        public static final class b<T, R> implements Function<Throwable, SingleSource<? extends ChatListAdBannerInteractor.State>> {
            public final /* synthetic */ UpdateBannerMutator a;
            public final /* synthetic */ ChatListAdBannerInteractor.State b;

            public b(UpdateBannerMutator updateBannerMutator, ChatListAdBannerInteractor.State state) {
                this.a = updateBannerMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends ChatListAdBannerInteractor.State> apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                Logs.error(ChatListAdBannerInteractorImpl.this.getTAG(), "UpdateBannerMutator error", th2);
                return Singles.toSingle(this.b);
            }
        }

        public UpdateBannerMutator(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public static final Single access$loadBannerConfig(UpdateBannerMutator updateBannerMutator, String str, int i) {
            Single flatMap = ChatListAdBannerInteractorImpl.this.q.withMessengerApi().flatMap(new ChatListAdBannerInteractorImpl$UpdateBannerMutator$loadBannerConfig$1(str, i));
            Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…tionId)\n                }");
            return flatMap;
        }

        @NotNull
        public Single<ChatListAdBannerInteractor.State> invoke(@NotNull ChatListAdBannerInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Single map = InteropKt.toV2(SavedLocationInteractor.DefaultImpls.savedLocation$default(ChatListAdBannerInteractorImpl.this.s, null, false, 3, null)).firstOrError().flatMap(new i(this)).map(new a2.a.a.o1.b.b.b.j(this));
            Intrinsics.checkNotNullExpressionValue(map, "savedLocationInteractor.…      )\n                }");
            Single<ChatListAdBannerInteractor.State> onErrorResumeNext = map.flatMap(new a(this, state)).onErrorResumeNext(new b(this, state));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "loadBannerCascadeInfo().….toSingle()\n            }");
            return onErrorResumeNext;
        }
    }

    public static final class a implements ShouldCancelChecker<ChatListAdBannerInteractor.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<ChatListAdBannerInteractor.State> reducible, @NotNull Reducible<ChatListAdBannerInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof TryToUpdateBannerAction) {
                if (reducible2 instanceof TryToUpdateBannerAction) {
                    return true;
                }
            } else if (reducible instanceof UpdateBannerMutator) {
                if (reducible2 instanceof UpdateBannerMutator) {
                    return true;
                }
            } else if ((reducible instanceof HideBannerMutator) && ((reducible2 instanceof HideBannerMutator) || (reducible2 instanceof UpdateBannerMutator))) {
                return true;
            }
            return false;
        }
    }

    public static final class b implements ReducerQueueWithTransformByKey.KeySelector<ChatListAdBannerInteractor.State, Unit> {
        @NotNull
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.channels.mvi.common.v4.Reducible] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey.KeySelector
        public Unit getKey(Reducible<ChatListAdBannerInteractor.State> reducible) {
            Intrinsics.checkNotNullParameter(reducible, "reducible");
            if (reducible instanceof UpdateBannerMutator) {
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    public static final class c implements ReducerQueueWithTransformByKey.Transformer<ChatListAdBannerInteractor.State, Unit> {
        public final Scheduler a;

        public c(@NotNull Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "schedulerForThrottling");
            this.a = scheduler;
        }

        /* Return type fixed from 'io.reactivex.Observable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, io.reactivex.Observable] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey.Transformer
        public Observable<Reducible<ChatListAdBannerInteractor.State>> transform(Unit unit, Observable<Reducible<ChatListAdBannerInteractor.State>> observable) {
            Unit unit2 = unit;
            Intrinsics.checkNotNullParameter(observable, "obs");
            if (unit2 == null) {
                return observable;
            }
            Observable<Reducible<ChatListAdBannerInteractor.State>> throttleLast = observable.throttleLast(50, TimeUnit.MILLISECONDS, this.a);
            Intrinsics.checkNotNullExpressionValue(throttleLast, "obs.throttleLast(\n      …ottling\n                )");
            return throttleLast;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull BuildInfo buildInfo, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @MessengerAdsPreferences @NotNull Preferences preferences, @NotNull TimeSource timeSource, @NotNull SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> singleManuallyExposedAbTestGroup, @NotNull Features features, @NotNull ReducerQueue<ChatListAdBannerInteractor.State> reducerQueue, @Nullable Observable<ChatListAdBannerInteractor.State> observable, @NotNull ChatListAdBannerInteractor.ShouldUpdateBannerChecker shouldUpdateBannerChecker, @NotNull ChatListAdBannerInteractor.CommercialBannerFactory commercialBannerFactory) {
        super("ChatListAdBannerInteractor", ChatListAdBannerInteractor.State.Companion.getDEFAULT(), schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "savedLocationInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "bannerInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialBannersAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "adCascadesInChannelsTestGroup");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        Intrinsics.checkNotNullParameter(shouldUpdateBannerChecker, "shouldUpdateBannerChecker");
        Intrinsics.checkNotNullParameter(commercialBannerFactory, "commercialBannerFactory");
        this.y = shouldUpdateBannerChecker;
        this.z = commercialBannerFactory;
        this.q = messengerClient;
        this.r = buildInfo;
        this.s = savedLocationInteractor;
        this.t = commercialBannersInteractor;
        this.u = commercialBannersAnalyticsInteractor;
        this.v = preferences;
        this.w = timeSource;
        this.x = singleManuallyExposedAbTestGroup;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        compositeDisposable.add(Disposables.fromAction(new io.reactivex.functions.Action() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Disposable subscribe = this.q.allReconnects().observeOn(sharedScheduler).filter(ChatListAdBannerInteractorImpl$subscribeToBannerUpdateTriggers$1.INSTANCE).map(ChatListAdBannerInteractorImpl$subscribeToBannerUpdateTriggers$2.INSTANCE).startWith((Observable<R>) ((R) Unit.INSTANCE)).subscribeOn(sharedScheduler).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl$subscribeToBannerUpdateTriggers$3
            public final void accept(Unit unit) {
                ChatListAdBannerInteractorImpl.this.getReducerQueue().plusAssign(new ChatListAdBannerInteractorImpl.TryToUpdateBannerAction());
            }
        }, new Consumer() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorKt$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n … triggers\")\n            )");
        DisposableKt.addTo(subscribe, this.p);
    }

    public static final Function1 access$logError(ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl, String str) {
        Objects.requireNonNull(chatListAdBannerInteractorImpl);
        return new ChatListAdBannerInteractorImpl$logError$1(chatListAdBannerInteractorImpl, str);
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor.CommercialBannerFactory
    @NotNull
    public CommercialBanner createCommercialBanner(@NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "bannerItems");
        return this.z.createCommercialBanner(list, z2);
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor
    public void hideBanner() {
        getReducerQueue().plusAssign(new HideBannerMutator());
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor
    public void sendBannerOpened(@NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        getReducerQueue().plusAssign(new SendBannerOpenedAction(this, bannerInfo, i));
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor.ShouldUpdateBannerChecker
    public boolean shouldUpdateBanner(@NotNull ChatListAdBannerInteractor.State state, @NotNull Preferences preferences, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(state, "$this$shouldUpdateBanner");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return this.y.shouldUpdateBanner(state, preferences, timeSource);
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor
    public void tryToUpdateBanner() {
        getReducerQueue().plusAssign(new TryToUpdateBannerAction());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChatListAdBannerInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull BuildInfo buildInfo, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @MessengerAdsPreferences @NotNull Preferences preferences, @NotNull TimeSource timeSource, @NotNull SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> singleManuallyExposedAbTestGroup, @NotNull Features features) {
        this(schedulersFactory, messengerClient, buildInfo, savedLocationInteractor, commercialBannersInteractor, commercialBannersAnalyticsInteractor, preferences, timeSource, singleManuallyExposedAbTestGroup, features, new ReducerQueueWithTransformByKey(schedulersFactory.io(), b.a, new c(schedulersFactory.computation())), null, new ChatListAdBannerInteractor.ShouldUpdateBannerChecker() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl.1
            @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor.ShouldUpdateBannerChecker
            public boolean shouldUpdateBanner(@NotNull ChatListAdBannerInteractor.State state, @NotNull Preferences preferences2, @NotNull TimeSource timeSource2) {
                Intrinsics.checkNotNullParameter(state, "$this$shouldUpdateBanner");
                Intrinsics.checkNotNullParameter(preferences2, "preferences");
                Intrinsics.checkNotNullParameter(timeSource2, "timeSource");
                return ChatListAdBannerInteractor.ShouldUpdateBannerChecker.DefaultImpls.shouldUpdateBanner(this, state, preferences2, timeSource2);
            }
        }, new ChatListAdBannerInteractor.CommercialBannerFactory() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl.2
            @Override // com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor.CommercialBannerFactory
            @NotNull
            public CommercialBanner createCommercialBanner(@NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z2) {
                Intrinsics.checkNotNullParameter(list, "bannerItems");
                return ChatListAdBannerInteractor.CommercialBannerFactory.DefaultImpls.createCommercialBanner(this, list, z2);
            }
        });
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "savedLocationInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "bannerInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialBannersAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "adCascadesInChannelsTestGroup");
        Intrinsics.checkNotNullParameter(features, "features");
    }
}
