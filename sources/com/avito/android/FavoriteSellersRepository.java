package com.avito.android;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/avito/android/FavoriteSellersRepository;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "updates", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "", "userKey", "", "isSubscribed", "isNotificationsActivated", "Lio/reactivex/rxjava3/core/Completable;", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "clearSellers", "()V", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersRepository {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable updateSeller$default(FavoriteSellersRepository favoriteSellersRepository, String str, Boolean bool, Boolean bool2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bool = null;
                }
                if ((i & 4) != 0) {
                    bool2 = null;
                }
                return favoriteSellersRepository.updateSeller(str, bool, bool2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSeller");
        }
    }

    void clearSellers();

    @NotNull
    Single<Set<FavoriteSeller>> getSellers();

    @NotNull
    Map<String, FavoriteSeller> getSellersAsMap();

    @NotNull
    Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2);

    @NotNull
    Observable<Unit> updates();
}
