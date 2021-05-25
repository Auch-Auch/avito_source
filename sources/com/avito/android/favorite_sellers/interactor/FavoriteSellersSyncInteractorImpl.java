package com.avito.android.favorite_sellers.interactor;

import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u00168\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractorImpl;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractor;", "Lcom/avito/android/FavoriteSellersRepository;", "", "clearSellers", "()V", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "", "userKey", "", "isSubscribed", "isNotificationsActivated", "Lio/reactivex/rxjava3/core/Completable;", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "updates", "()Lio/reactivex/rxjava3/core/Observable;", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "favoriteSellersRepository", "<init>", "(Lcom/avito/android/FavoriteSellersRepository;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersSyncInteractorImpl implements FavoriteSellersSyncInteractor, FavoriteSellersRepository {
    public final /* synthetic */ FavoriteSellersRepository a;

    public FavoriteSellersSyncInteractorImpl(@NotNull FavoriteSellersRepository favoriteSellersRepository) {
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        this.a = favoriteSellersRepository;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
        this.a.clearSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return this.a.getSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return this.a.getSellersAsMap();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.a.updateSeller(str, bool, bool2);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        return this.a.updates();
    }
}
