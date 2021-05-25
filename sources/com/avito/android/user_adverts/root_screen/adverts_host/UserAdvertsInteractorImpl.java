package com.avito.android.user_adverts.root_screen.adverts_host;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UserAdvertsShortcuts;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractorImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/UserAdvertsShortcuts;", "loadShortcuts", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "api", "<init>", "(Lcom/avito/android/user_adverts/remote/UserAdvertsApi;Lcom/avito/android/util/SchedulersFactory;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsInteractorImpl implements UserAdvertsInteractor {
    public final UserAdvertsApi a;
    public final SchedulersFactory b;

    @Inject
    public UserAdvertsInteractorImpl(@NotNull UserAdvertsApi userAdvertsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(userAdvertsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = userAdvertsApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractor
    @NotNull
    public Observable<UserAdvertsShortcuts> loadShortcuts() {
        return a.S1(this.b, InteropKt.toV2(this.a.getUserAdvertsShortcuts()), "api.getUserAdvertsShortc…scribeOn(schedulers.io())");
    }
}
