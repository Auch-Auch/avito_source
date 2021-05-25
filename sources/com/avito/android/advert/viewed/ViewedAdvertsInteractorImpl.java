package com.avito.android.advert.viewed;

import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "", "id", "Lio/reactivex/rxjava3/core/Single;", "", "markAsViewed", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "isViewed", "(Ljava/lang/String;)Z", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "dao", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "c", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEvents", "<init>", "(Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;)V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsInteractorImpl implements ViewedAdvertsInteractor {
    public final ViewedAdvertsDao a;
    public final SchedulersFactory3 b;
    public final ViewedAdvertsEventInteractor c;

    public static final class a<V> implements Callable<Unit> {
        public final /* synthetic */ ViewedAdvertsInteractorImpl a;
        public final /* synthetic */ String b;

        public a(ViewedAdvertsInteractorImpl viewedAdvertsInteractorImpl, String str) {
            this.a = viewedAdvertsInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Unit call() {
            if (this.a.a.getCount() >= 1000) {
                this.a.a.removeLessPopularViewedAdverts(100);
            }
            this.a.a.save(this.b);
            this.a.c.advertViewed(this.b);
            return Unit.INSTANCE;
        }
    }

    public ViewedAdvertsInteractorImpl(@NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor) {
        Intrinsics.checkNotNullParameter(viewedAdvertsDao, "dao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEvents");
        this.a = viewedAdvertsDao;
        this.b = schedulersFactory3;
        this.c = viewedAdvertsEventInteractor;
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsInteractor
    public boolean isViewed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.a.isViewed(str);
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsInteractor
    @NotNull
    public Single<Unit> markAsViewed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return a2.b.a.a.a.e2(this.b, Single.fromCallable(new a(this, str)), "Single.fromCallable {\n  …scribeOn(schedulers.io())");
    }
}
