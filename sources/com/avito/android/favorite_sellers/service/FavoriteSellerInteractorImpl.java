package com.avito.android.favorite_sellers.service;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractorImpl;", "Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractor;", "", "userKey", "", "muteSync", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/FavoriteSellersApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/FavoriteSellersApi;", "api", "Lcom/avito/android/FavoriteSellersRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/FavoriteSellersRepository;", "repository", "<init>", "(Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/FavoriteSellersRepository;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellerInteractorImpl implements FavoriteSellerInteractor {
    public final FavoriteSellersApi a;
    public final FavoriteSellersRepository b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ FavoriteSellerInteractorImpl a;
        public final /* synthetic */ String b;

        public a(FavoriteSellerInteractorImpl favoriteSellerInteractorImpl, String str) {
            this.a = favoriteSellerInteractorImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            FavoriteSellersRepository.DefaultImpls.updateSeller$default(this.a.b, this.b, null, Boolean.FALSE, 2, null).subscribe(a2.a.a.s0.i0.a.a, a2.a.a.s0.i0.b.a);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("FavoriteSellerInteractor", "Failed to unsubscribe from your favorite seller", th);
        }
    }

    @Inject
    public FavoriteSellerInteractorImpl(@NotNull FavoriteSellersApi favoriteSellersApi, @NotNull FavoriteSellersRepository favoriteSellersRepository) {
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "repository");
        this.a = favoriteSellersApi;
        this.b = favoriteSellersRepository;
    }

    @Override // com.avito.android.favorite_sellers.service.FavoriteSellerInteractor
    public void muteSync(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        TypedObservablesKt.toTyped(this.a.changeNotifications("push", str, false)).blockingSubscribe(new a(this, str), b.a);
    }
}
