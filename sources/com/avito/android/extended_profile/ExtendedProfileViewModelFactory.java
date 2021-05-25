package com.avito.android.extended_profile;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.extended_profile.di.ContextId;
import com.avito.android.extended_profile.di.UserKey;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\b\b\u0001\u0010%\u001a\u00020\u001c\u0012\u0006\u0010A\u001a\u00020>\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\bB\u0010CJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/FavoriteSellersRepository;", g.a, "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "f", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoritesInteractor", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "h", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "", "c", "Ljava/lang/String;", "contextId", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "d", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "interactor", AuthSource.SEND_ABUSE, "userKey", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "e", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "contactsInteractor", "Lcom/avito/android/account/AccountStateProvider;", "i", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/error_helper/ErrorHelper;", "l", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "advertActionIconFactory", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "j", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "n", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "performanceTracker", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "profile", "<init>", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Lcom/avito/android/extended_profile/ExtendedProfileInteractor;Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;Lcom/avito/android/analytics/Analytics;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final ExtendedPublicUserProfile b;
    public final String c;
    public final ExtendedProfileInteractor d;
    public final ExtendedProfileContactsInteractor e;
    public final FavoriteAdvertsInteractor f;
    public final FavoriteSellersRepository g;
    public final ViewedAdvertsEventInteractor h;
    public final AccountStateProvider i;
    public final ExtendedProfileResourceProvider j;
    public final SchedulersFactory3 k;
    public final ErrorHelper l;
    public final AdvertActionIconFactory m;
    public final ExtendedProfileTracker n;
    public final Analytics o;

    @Inject
    public ExtendedProfileViewModelFactory(@UserKey @NotNull String str, @NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @ContextId @Nullable String str2, @NotNull ExtendedProfileInteractor extendedProfileInteractor, @NotNull ExtendedProfileContactsInteractor extendedProfileContactsInteractor, @NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull ExtendedProfileResourceProvider extendedProfileResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @NotNull AdvertActionIconFactory advertActionIconFactory, @NotNull ExtendedProfileTracker extendedProfileTracker, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(extendedPublicUserProfile, "profile");
        Intrinsics.checkNotNullParameter(extendedProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(extendedProfileContactsInteractor, "contactsInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoritesInteractor");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEventInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(extendedProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(advertActionIconFactory, "advertActionIconFactory");
        Intrinsics.checkNotNullParameter(extendedProfileTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = extendedPublicUserProfile;
        this.c = str2;
        this.d = extendedProfileInteractor;
        this.e = extendedProfileContactsInteractor;
        this.f = favoriteAdvertsInteractor;
        this.g = favoriteSellersRepository;
        this.h = viewedAdvertsEventInteractor;
        this.i = accountStateProvider;
        this.j = extendedProfileResourceProvider;
        this.k = schedulersFactory3;
        this.l = errorHelper;
        this.m = advertActionIconFactory;
        this.n = extendedProfileTracker;
        this.o = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ExtendedProfileViewModelImpl.class)) {
            return new ExtendedProfileViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
