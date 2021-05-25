package com.avito.android.stories;

import com.avito.android.Features;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/stories/LocalStartupBannerInteractor;", "Lcom/avito/android/stories/StartupBannerInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/stories/StartupStoryBanner;", "startupBanner", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/stories/StartupBannerLocker;", "lockStartupBanner", "()Lcom/avito/android/stories/StartupBannerLocker;", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "d", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "antifraudStartupBannerTestGroup", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "c", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "startupBannerBlockers", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocalStartupBannerInteractor implements StartupBannerInteractor {
    public final List<Observable<StartupStoryBanner>> a = new ArrayList();
    public final Preferences b;
    public final ConnectivityProvider c;
    public final AntifraudStartupBannerTestGroup d;
    public final Features e;

    public static final class a<T> implements Predicate<StartupStoryBanner> {
        public final /* synthetic */ LocalStartupBannerInteractor a;

        public a(LocalStartupBannerInteractor localStartupBannerInteractor) {
            this.a = localStartupBannerInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(StartupStoryBanner startupStoryBanner) {
            return this.a.c.isConnectionAvailable();
        }
    }

    public static final class b<T> implements Consumer<StartupStoryBanner> {
        public final /* synthetic */ LocalStartupBannerInteractor a;

        public b(LocalStartupBannerInteractor localStartupBannerInteractor) {
            this.a = localStartupBannerInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(StartupStoryBanner startupStoryBanner) {
            this.a.b.putString("last_viewed_startup_banner_id", "40");
        }
    }

    @Inject
    public LocalStartupBannerInteractor(@NotNull Preferences preferences, @NotNull ConnectivityProvider connectivityProvider, @NotNull AntifraudStartupBannerTestGroup antifraudStartupBannerTestGroup, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(antifraudStartupBannerTestGroup, "antifraudStartupBannerTestGroup");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = preferences;
        this.c = connectivityProvider;
        this.d = antifraudStartupBannerTestGroup;
        this.e = features;
    }

    @Override // com.avito.android.stories.StartupBannerInteractor
    @NotNull
    public StartupBannerLocker lockStartupBanner() {
        BehaviorSubject create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.a.add(create);
        return new StartupBannerLocker(this, create) { // from class: com.avito.android.stories.LocalStartupBannerInteractor$lockStartupBanner$1
            public final /* synthetic */ LocalStartupBannerInteractor a;
            public final /* synthetic */ Subject b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.stories.StartupBannerLocker
            public void unlock() {
                this.a.a.remove(this.b);
                this.b.onComplete();
            }
        };
    }

    @Override // com.avito.android.stories.StartupBannerInteractor
    @NotNull
    public Observable<StartupStoryBanner> startupBanner() {
        if (!this.e.getAntifraudStartupBanner().invoke().booleanValue() || this.d.isReverseTest() || Intrinsics.areEqual(this.b.getString("last_viewed_startup_banner_id"), "40")) {
            Observable<StartupStoryBanner> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
            return empty;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        Observable just = Observable.just(new StartupStoryBanner("https://www.avito.ru/stories", "40"));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(StartupS…_URL, STARTUP_BANNER_ID))");
        arrayList.add(just);
        Observable<StartupStoryBanner> doOnNext = Observable.concat(arrayList).takeWhile(new a(this)).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "Observable.concat(observ…NER_ID)\n                }");
        return doOnNext;
    }
}
