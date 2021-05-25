package com.avito.android.messenger.channels.mvi.interactor;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "Landroidx/lifecycle/ViewModel;", "", "loggedOut", "()V", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/avito/android/account/AccountStateProvider;", "e", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/jakewharton/rxrelay2/Relay;", "d", "Lcom/jakewharton/rxrelay2/Relay;", "getLoggedOutStream", "()Lcom/jakewharton/rxrelay2/Relay;", "loggedOutStream", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsErrorInteractorImpl extends ViewModel implements ChannelsErrorInteractor {
    public final CompositeDisposable c = new CompositeDisposable();
    @NotNull
    public final Relay<Unit> d = a.J1("PublishRelay.create<T>().toSerialized()");
    public final AccountStateProvider e;
    public final SchedulersFactory f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorKt$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelsErrorInteractorImpl(@org.jetbrains.annotations.NotNull com.avito.android.account.AccountStateProvider r3, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r4) {
        /*
            r2 = this;
            java.lang.String r0 = "accountStateProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "schedulers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>()
            r2.e = r3
            r2.f = r4
            io.reactivex.disposables.CompositeDisposable r3 = new io.reactivex.disposables.CompositeDisposable
            r3.<init>()
            r2.c = r3
            java.lang.String r3 = "PublishRelay.create<T>().toSerialized()"
            com.jakewharton.rxrelay2.Relay r3 = a2.b.a.a.a.J1(r3)
            r2.d = r3
            com.avito.android.account.AccountStateProvider r3 = access$getAccountStateProvider$p(r2)
            io.reactivex.rxjava3.core.Observable r3 = r3.userId()
            io.reactivex.Observable r3 = com.avito.android.util.rx3.InteropKt.toV2(r3)
            com.avito.android.util.SchedulersFactory r4 = access$getSchedulers$p(r2)
            io.reactivex.Scheduler r4 = r4.io()
            io.reactivex.Observable r3 = r3.observeOn(r4)
            r0 = 1
            io.reactivex.Observable r3 = r3.skip(r0)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$1 r4 = com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$1.INSTANCE
            if (r4 == 0) goto L_0x0048
            com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorKt$sam$i$io_reactivex_functions_Predicate$0 r0 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorKt$sam$i$io_reactivex_functions_Predicate$0
            r0.<init>()
            r4 = r0
        L_0x0048:
            io.reactivex.functions.Predicate r4 = (io.reactivex.functions.Predicate) r4
            io.reactivex.Observable r3 = r3.filter(r4)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$2 r4 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$2
            r4.<init>()
            com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$3 r0 = com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl$subscribeToLogouts$3.INSTANCE
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r4, r0)
            java.lang.String r4 = "accountStateProvider.use…          }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            io.reactivex.disposables.CompositeDisposable r4 = access$getAllSubscriptions$p(r2)
            io.reactivex.rxkotlin.DisposableKt.addTo(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractorImpl.<init>(com.avito.android.account.AccountStateProvider, com.avito.android.util.SchedulersFactory):void");
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor
    public void loggedOut() {
        getLoggedOutStream().accept(Unit.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor
    @NotNull
    public Relay<Unit> getLoggedOutStream() {
        return this.d;
    }
}
