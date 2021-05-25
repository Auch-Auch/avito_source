package com.avito.android.app_rater;

import a2.a.a.k.b;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AppRaterSession;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app_rater/AppRaterInteractorImpl;", "Lcom/avito/android/app_rater/AppRaterInteractor;", "", "timestamp", "Lio/reactivex/Single;", "", "shouldShowAppRaterOnSoa", "(J)Lio/reactivex/Single;", "saveAppRaterSession", "Lcom/avito/android/app_rater/AppRaterSessionStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app_rater/AppRaterSessionStorage;", "storage", "<init>", "(Lcom/avito/android/app_rater/AppRaterSessionStorage;)V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class AppRaterInteractorImpl implements AppRaterInteractor {
    public final AppRaterSessionStorage a;

    public static final class a<V> implements Callable<Boolean> {
        public final /* synthetic */ AppRaterInteractorImpl a;
        public final /* synthetic */ long b;

        public a(AppRaterInteractorImpl appRaterInteractorImpl, long j) {
            this.a = appRaterInteractorImpl;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            this.a.a.saveAppRaterSession(new AppRaterSession(this.b));
            return Boolean.TRUE;
        }
    }

    @Inject
    public AppRaterInteractorImpl(@NotNull AppRaterSessionStorage appRaterSessionStorage) {
        Intrinsics.checkNotNullParameter(appRaterSessionStorage, "storage");
        this.a = appRaterSessionStorage;
    }

    @Override // com.avito.android.app_rater.AppRaterInteractor
    @NotNull
    public Single<Boolean> saveAppRaterSession(long j) {
        Single<Boolean> fromCallable = Single.fromCallable(new a(this, j));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …           true\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.app_rater.AppRaterInteractor
    @NotNull
    public Single<Boolean> shouldShowAppRaterOnSoa(long j) {
        Single<Boolean> map = Single.fromCallable(new a2.a.a.k.a(this)).map(new b(j));
        Intrinsics.checkNotNullExpressionValue(map, "Single.fromCallable {\n  …R_IDLE_INTERVAL\n        }");
        return map;
    }
}
