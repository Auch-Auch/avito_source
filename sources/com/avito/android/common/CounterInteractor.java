package com.avito.android.common;

import com.avito.android.account.plugin.AuthorizationPlugin;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/common/CounterInteractor;", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Lio/reactivex/rxjava3/core/Observable;", "", "changes", "()Lio/reactivex/rxjava3/core/Observable;", "", "force", "", "requestUpdate", "(Z)V", "Lio/reactivex/rxjava3/core/Completable;", "executeUpdate", "()Lio/reactivex/rxjava3/core/Completable;", "reset", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface CounterInteractor extends AuthorizationPlugin {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onLogin(@NotNull CounterInteractor counterInteractor) {
            AuthorizationPlugin.DefaultImpls.onLogin(counterInteractor);
        }

        public static void onLogout(@NotNull CounterInteractor counterInteractor) {
            AuthorizationPlugin.DefaultImpls.onLogout(counterInteractor);
        }

        public static void onStateChanged(@NotNull CounterInteractor counterInteractor) {
            AuthorizationPlugin.DefaultImpls.onStateChanged(counterInteractor);
        }

        public static /* synthetic */ void requestUpdate$default(CounterInteractor counterInteractor, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                counterInteractor.requestUpdate(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestUpdate");
        }
    }

    @NotNull
    Observable<Integer> changes();

    @NotNull
    Completable executeUpdate();

    void requestUpdate(boolean z);

    void reset();
}
