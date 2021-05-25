package com.avito.android.advert.item.dfpcreditinfo;

import a2.g.r.g;
import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020%\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b)\u0010*J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactoryImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/account/AccountStateProvider;", "f", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/remote/ProfileApi;", "e", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "c", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "dfpCreditBannerLoader", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", "h", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "sravniWebTestGroup", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "d", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", g.a, "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "creditStorage", "<init>", "(Landroid/app/Application;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DfpCreditViewModelFactoryImpl implements DfpCreditViewModelFactory {
    public final Application a;
    public final SchedulersFactory3 b;
    public final DfpCreditBannerLoader c;
    public final AdvertDetailsAnalyticsInteractor d;
    public final ProfileApi e;
    public final AccountStateProvider f;
    public final AdvertDetailsCreditStorage g;
    public final SingleManuallyExposedAbTestGroup<SravniWebTestGroup> h;

    @Inject
    public DfpCreditViewModelFactoryImpl(@NotNull Application application, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull DfpCreditBannerLoader dfpCreditBannerLoader, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull ProfileApi profileApi, @NotNull AccountStateProvider accountStateProvider, @NotNull AdvertDetailsCreditStorage advertDetailsCreditStorage, @NotNull SingleManuallyExposedAbTestGroup<SravniWebTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(dfpCreditBannerLoader, "dfpCreditBannerLoader");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(advertDetailsCreditStorage, "creditStorage");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "sravniWebTestGroup");
        this.a = application;
        this.b = schedulersFactory3;
        this.c = dfpCreditBannerLoader;
        this.d = advertDetailsAnalyticsInteractor;
        this.e = profileApi;
        this.f = accountStateProvider;
        this.g = advertDetailsCreditStorage;
        this.h = singleManuallyExposedAbTestGroup;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DfpCreditViewModel.class)) {
            return new DfpCreditViewModel(this.a, this.c, this.b, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
