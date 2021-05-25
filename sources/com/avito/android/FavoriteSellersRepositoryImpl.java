package com.avito.android;

import com.avito.android.common.CounterInteractor;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx3.Singles;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\"8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/FavoriteSellersRepositoryImpl;", "Lcom/avito/android/FavoriteSellersRepository;", "Lio/reactivex/rxjava3/core/Observable;", "", "updates", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "", "userKey", "", "isSubscribed", "isNotificationsActivated", "Lio/reactivex/rxjava3/core/Completable;", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "clearSellers", "()V", "Lcom/avito/android/common/CounterInteractor;", "c", "Lcom/avito/android/common/CounterInteractor;", "counterInteractor", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "updatesRelay", "", "Lcom/avito/android/FavoriteSellersRepositoryImpl$Seller;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", SellersTrackerModule.NAME, "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "<init>", "(Lcom/avito/android/common/CounterInteractor;)V", "Seller", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersRepositoryImpl implements FavoriteSellersRepository {
    public final Map<String, Seller> a = new LinkedHashMap();
    public final PublishRelay<Unit> b;
    public final CounterInteractor c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\f\u0010\t¨\u0006 "}, d2 = {"Lcom/avito/android/FavoriteSellersRepositoryImpl$Seller;", "Lcom/avito/android/FavoriteSeller;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "()Ljava/lang/Boolean;", "userKey", "isSubscribed", "isNotificationsActivated", "copy", "(Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/avito/android/FavoriteSellersRepositoryImpl$Seller;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserKey", "c", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Seller implements FavoriteSeller {
        @NotNull
        public final String a;
        public final boolean b;
        @Nullable
        public final Boolean c;

        public Seller(@NotNull String str, boolean z, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "userKey");
            this.a = str;
            this.b = z;
            this.c = bool;
        }

        public static /* synthetic */ Seller copy$default(Seller seller, String str, boolean z, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = seller.getUserKey();
            }
            if ((i & 2) != 0) {
                z = seller.isSubscribed();
            }
            if ((i & 4) != 0) {
                bool = seller.isNotificationsActivated();
            }
            return seller.copy(str, z, bool);
        }

        @NotNull
        public final String component1() {
            return getUserKey();
        }

        public final boolean component2() {
            return isSubscribed();
        }

        @Nullable
        public final Boolean component3() {
            return isNotificationsActivated();
        }

        @NotNull
        public final Seller copy(@NotNull String str, boolean z, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "userKey");
            return new Seller(str, z, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Seller)) {
                return false;
            }
            Seller seller = (Seller) obj;
            return Intrinsics.areEqual(getUserKey(), seller.getUserKey()) && isSubscribed() == seller.isSubscribed() && Intrinsics.areEqual(isNotificationsActivated(), seller.isNotificationsActivated());
        }

        @Override // com.avito.android.FavoriteSeller
        @NotNull
        public String getUserKey() {
            return this.a;
        }

        public int hashCode() {
            String userKey = getUserKey();
            int i = 0;
            int hashCode = (userKey != null ? userKey.hashCode() : 0) * 31;
            boolean isSubscribed = isSubscribed();
            if (isSubscribed) {
                isSubscribed = true;
            }
            int i2 = isSubscribed ? 1 : 0;
            int i3 = isSubscribed ? 1 : 0;
            int i4 = isSubscribed ? 1 : 0;
            int i5 = (hashCode + i2) * 31;
            Boolean isNotificationsActivated = isNotificationsActivated();
            if (isNotificationsActivated != null) {
                i = isNotificationsActivated.hashCode();
            }
            return i5 + i;
        }

        @Override // com.avito.android.FavoriteSeller
        @Nullable
        public Boolean isNotificationsActivated() {
            return this.c;
        }

        @Override // com.avito.android.FavoriteSeller
        public boolean isSubscribed() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Seller(userKey=");
            L.append(getUserKey());
            L.append(", isSubscribed=");
            L.append(isSubscribed());
            L.append(", isNotificationsActivated=");
            L.append(isNotificationsActivated());
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Seller(String str, boolean z, Boolean bool, int i, j jVar) {
            this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : bool);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ FavoriteSellersRepositoryImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Boolean c;
        public final /* synthetic */ Boolean d;

        public a(FavoriteSellersRepositoryImpl favoriteSellersRepositoryImpl, String str, Boolean bool, Boolean bool2) {
            this.a = favoriteSellersRepositoryImpl;
            this.b = str;
            this.c = bool;
            this.d = bool2;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            Seller seller = (Seller) this.a.a.get(this.b);
            if (seller == null) {
                seller = new Seller(this.b, false, null, 6, null);
            }
            Boolean bool = this.c;
            boolean booleanValue = bool != null ? bool.booleanValue() : seller.isSubscribed();
            Boolean bool2 = this.d;
            if (bool2 == null) {
                bool2 = seller.isNotificationsActivated();
            }
            Seller copy$default = Seller.copy$default(seller, null, booleanValue, bool2, 1, null);
            if (!Intrinsics.areEqual(seller, copy$default)) {
                this.a.a.put(this.b, copy$default);
                this.a.b.accept(Unit.INSTANCE);
                CounterInteractor.DefaultImpls.requestUpdate$default(this.a.c, false, 1, null);
            }
        }
    }

    @Inject
    public FavoriteSellersRepositoryImpl(@FavoriteSellers @NotNull CounterInteractor counterInteractor) {
        Intrinsics.checkNotNullParameter(counterInteractor, "counterInteractor");
        this.c = counterInteractor;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
        this.a.clear();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return Singles.toSingle(CollectionsKt___CollectionsKt.toSet(this.a.values()));
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return this.a;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable fromAction = Completable.fromAction(new a(this, str, bool, bool2));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…tUpdate()\n        }\n    }");
        return fromAction;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        return this.b;
    }
}
