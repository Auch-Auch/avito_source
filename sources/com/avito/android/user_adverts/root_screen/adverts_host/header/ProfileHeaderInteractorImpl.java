package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.IncomeResultV2;
import com.avito.android.remote.model.OrdersInfo;
import com.avito.android.remote.model.ProfileItemsConfig;
import com.avito.android.remote.model.SmbStatsInfo;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.server_time.TimeSource;
import com.avito.android.user_adverts.ProfileConfig;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.SoaData;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.util.Formatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0-\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b1\u00102J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractorImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/SoaData$Value;", "getSoaInfo", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/OrdersInfo;", "getOrdersInfo", "", "getSoaOnboarding", "()Ljava/lang/String;", "getSmbStatsOnboarding", "Lio/reactivex/Single;", "Lcom/avito/android/user_adverts/ProfileConfig;", "loadProfileItemsConfig", "()Lio/reactivex/Single;", "", "setSoaOnboardingShown", "()V", "setSmbOnboardingClosed", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;", "d", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;", "soaSessionStorage", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "api", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "f", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "smbStatsTooltipSessionStorage", "Lcom/avito/android/server_time/TimeSource;", g.a, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "e", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "resourcesProvider", "Lcom/avito/android/util/Formatter;", "c", "Lcom/avito/android/util/Formatter;", "priceFormatter", "<init>", "(Lcom/avito/android/user_adverts/remote/UserAdvertsApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Formatter;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;Lcom/avito/android/server_time/TimeSource;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderInteractorImpl implements ProfileHeaderInteractor {
    public final UserAdvertsApi a;
    public final SchedulersFactory b;
    public final Formatter<String> c;
    public final SoaPopupSessionStorage d;
    public final ProfileHeaderResourceProvider e;
    public final SmbStatsTooltipSessionStorage f;
    public final TimeSource g;

    public static final class a<T, R> implements Function<TypedResult<OrdersInfo>, LoadingState<? super OrdersInfo>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super OrdersInfo> apply(TypedResult<OrdersInfo> typedResult) {
            TypedResult<OrdersInfo> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<IncomeResultV2, SoaData.Value> {
        public final /* synthetic */ ProfileHeaderInteractorImpl a;

        public b(ProfileHeaderInteractorImpl profileHeaderInteractorImpl) {
            this.a = profileHeaderInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public SoaData.Value apply(IncomeResultV2 incomeResultV2) {
            IncomeResultV2 incomeResultV22 = incomeResultV2;
            Intrinsics.checkNotNullParameter(incomeResultV22, "it");
            IncomeResultV2.Income income = incomeResultV22.getIncome();
            if (income == null) {
                return new SoaData.Value(null, null, 3, null);
            }
            String format = this.a.c.format(income.getAmount().getValue());
            String title = income.getTitle();
            return new SoaData.Value(title, format + ' ' + income.getAmount().getCurrency());
        }
    }

    public static final class c<T, R> implements Function<ProfileItemsConfig, ProfileConfig> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ProfileConfig apply(ProfileItemsConfig profileItemsConfig) {
            ProfileItemsConfig profileItemsConfig2 = profileItemsConfig;
            Intrinsics.checkNotNullParameter(profileItemsConfig2, "it");
            boolean isSearchAvailable = profileItemsConfig2.isSearchAvailable();
            SmbStatsInfo smbStats = profileItemsConfig2.getSmbStats();
            return new ProfileConfig(isSearchAvailable, smbStats != null ? new CardData(Integer.valueOf(R.drawable.ic_smb_stats_24), smbStats.getTitle(), smbStats.getSubtitle(), new ProfileHeaderView.ClickTarget.SmbStats(smbStats.getDeeplink()), null, 16, null) : null);
        }
    }

    @Inject
    public ProfileHeaderInteractorImpl(@NotNull UserAdvertsApi userAdvertsApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Formatter<String> formatter, @NotNull SoaPopupSessionStorage soaPopupSessionStorage, @NotNull ProfileHeaderResourceProvider profileHeaderResourceProvider, @NotNull SmbStatsTooltipSessionStorage smbStatsTooltipSessionStorage, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(userAdvertsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(soaPopupSessionStorage, "soaSessionStorage");
        Intrinsics.checkNotNullParameter(profileHeaderResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(smbStatsTooltipSessionStorage, "smbStatsTooltipSessionStorage");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.a = userAdvertsApi;
        this.b = schedulersFactory;
        this.c = formatter;
        this.d = soaPopupSessionStorage;
        this.e = profileHeaderResourceProvider;
        this.f = smbStatsTooltipSessionStorage;
        this.g = timeSource;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    @NotNull
    public Observable<LoadingState<OrdersInfo>> getOrdersInfo() {
        Observable<LoadingState<OrdersInfo>> startWith = InteropKt.toV2(this.a.getOrdersInfo()).toObservable().subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getOrdersInfo().toV2…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    @Nullable
    public String getSmbStatsOnboarding() {
        String smbOnboardingText = this.e.getSmbOnboardingText();
        boolean smbStatsVisited = this.f.getSmbStatsVisited();
        boolean z = false;
        boolean z2 = this.g.now() - this.f.getSmbStatsLastTimeShown() > 86400000;
        boolean z3 = this.f.getSmbStatsShownCount() < 3;
        if (!smbStatsVisited && z2 && z3) {
            z = true;
        }
        if (z) {
            return smbOnboardingText;
        }
        return null;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    @NotNull
    public Observable<SoaData.Value> getSoaInfo() {
        return a2.b.a.a.a.S1(this.b, TypedObservablesKt.toTyped(InteropKt.toV2(this.a.getItemsIncomeV2())).map(new b(this)), "api.getItemsIncomeV2().t…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    @Nullable
    public String getSoaOnboarding() {
        String soaOnboardingText = this.e.getSoaOnboardingText();
        if (!this.d.getSoaPopupWasShown()) {
            return soaOnboardingText;
        }
        return null;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    @NotNull
    public Single<ProfileConfig> loadProfileItemsConfig() {
        Single subscribeOn = InteropKt.toV2(this.a.getProfileSearchConfig()).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getProfileSearchConf…scribeOn(schedulers.io())");
        Single<ProfileConfig> map = TypedSingleKt.toTyped(subscribeOn).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getProfileSearchConf…          )\n            }");
        return map;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    public void setSmbOnboardingClosed() {
        this.f.setSmbStatsTooltipWasClosed(this.g.now());
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor
    public void setSoaOnboardingShown() {
        this.d.setSoaPopupWasShown();
    }
}
