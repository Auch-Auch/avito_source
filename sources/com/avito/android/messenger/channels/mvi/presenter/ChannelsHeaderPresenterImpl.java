package com.avito.android.messenger.channels.mvi.presenter;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.BehaviorRelay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerState;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B4\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\u0011\u0010*\u001a\r\u0012\t\u0012\u00070&¢\u0006\u0002\b'0%\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R!\u0010*\u001a\r\u0012\t\u0012\u00070&¢\u0006\u0002\b'0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "h", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "channelsErrorInteractor", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getStateObservable", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "stateObservable", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "getStateBlocking", "()Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "stateBlocking", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "i", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getShowLoginScreenStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "showLoginScreenStream", "e", "getUserBlockedStream", "userBlockedStream", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", g.a, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsHeaderPresenterImpl extends ViewModel implements ChannelsHeaderPresenter {
    @NotNull
    public final BehaviorRelay<ChannelsHeaderPresenter.State> c;
    @NotNull
    public final SingleLiveEvent<Unit> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> e = new SingleLiveEvent<>();
    public final CompositeDisposable f;
    public final MessengerClient<AvitoMessengerApi> g;
    public final ChannelsErrorInteractor h;
    public final BlockUserInteractor i;

    @Inject
    public ChannelsHeaderPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull ChannelsErrorInteractor channelsErrorInteractor, @NotNull BlockUserInteractor blockUserInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(channelsErrorInteractor, "channelsErrorInteractor");
        Intrinsics.checkNotNullParameter(blockUserInteractor, "blockUserInteractor");
        this.g = messengerClient;
        this.h = channelsErrorInteractor;
        this.i = blockUserInteractor;
        BehaviorRelay<ChannelsHeaderPresenter.State> createDefault = BehaviorRelay.createDefault(ChannelsHeaderPresenter.State.Companion.getDEFAULT());
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(State.DEFAULT)");
        this.c = createDefault;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Disposable subscribe = this.g.state().observeOn(sharedScheduler).distinctUntilChanged().subscribeOn(sharedScheduler).subscribe(new Consumer<MessengerState>() { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl$subscribeToConnectionStateChanges$1
            /* JADX WARN: Type inference failed for: r0v6, types: [com.jakewharton.rxrelay2.BehaviorRelay, com.jakewharton.rxrelay2.Relay] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void accept(ru.avito.messenger.MessengerState r7) {
                /*
                    r6 = this;
                    boolean r7 = r7 instanceof ru.avito.messenger.MessengerState.Connecting
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "newIsConnecting = "
                    r0.append(r1)
                    r0.append(r7)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "ChannelsHeaderPresenter"
                    r2 = 0
                    r3 = 4
                    com.avito.android.util.Logs.debug$default(r1, r0, r2, r3, r2)
                    com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl r0 = com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl.this
                    com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State r0 = r0.getStateBlocking()
                    boolean r0 = r0.isConnecting()
                    if (r7 == r0) goto L_0x0048
                    com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl r0 = com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl.this
                    com.jakewharton.rxrelay2.BehaviorRelay r0 = r0.getStateObservable()
                    com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State r4 = new com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State
                    r4.<init>(r7)
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r5 = "New State = "
                    r7.append(r5)
                    r7.append(r4)
                    java.lang.String r7 = r7.toString()
                    com.avito.android.util.Logs.info$default(r1, r7, r2, r3, r2)
                    r0.accept(r4)
                L_0x0048:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl$subscribeToConnectionStateChanges$1.accept(ru.avito.messenger.MessengerState):void");
            }
        }, ChannelsHeaderPresenterImpl$subscribeToConnectionStateChanges$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.state()\n         …          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
        Disposable subscribe2 = this.h.getLoggedOutStream().observeOn(sharedScheduler).throttleLatest(2000L, TimeUnit.MILLISECONDS, true).subscribeOn(sharedScheduler).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl$subscribeToLogouts$1
            public final void accept(Unit unit) {
                ChannelsHeaderPresenterImpl.this.getShowLoginScreenStream().postValue(Unit.INSTANCE);
            }
        }, ChannelsHeaderPresenterImpl$subscribeToLogouts$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "channelsErrorInteractor.…          }\n            )");
        DisposableKt.addTo(subscribe2, this.f);
        Observable<BlockUserInteractor.Result> observeOn = this.i.getResultStream().observeOn(sharedScheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn, "blockUserInteractor.resu…    .observeOn(scheduler)");
        Observable<U> ofType = observeOn.ofType(BlockUserInteractor.Result.Success.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Disposable subscribe3 = ofType.filter(ChannelsHeaderPresenterImpl$subscribeToUserBlocks$1.INSTANCE).subscribeOn(sharedScheduler).subscribe(new Consumer<BlockUserInteractor.Result.Success>() { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl$subscribeToUserBlocks$2
            public final void accept(BlockUserInteractor.Result.Success success) {
                ChannelsHeaderPresenterImpl.this.getUserBlockedStream().postValue(Unit.INSTANCE);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "blockUserInteractor.resu…dStream.postValue(Unit) }");
        DisposableKt.addTo(subscribe3, this.f);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter
    @NotNull
    public SingleLiveEvent<Unit> getShowLoginScreenStream() {
        return this.d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.jakewharton.rxrelay2.BehaviorRelay] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter.State getStateBlocking() {
        /*
            r2 = this;
            com.jakewharton.rxrelay2.BehaviorRelay r0 = r2.getStateObservable()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "stateObservable.value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State r0 = (com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter.State) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenterImpl.getStateBlocking():com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State");
    }

    /* Return type fixed from 'com.jakewharton.rxrelay2.BehaviorRelay<com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter$State>' to match base method */
    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public Observable<ChannelsHeaderPresenter.State> getStateObservable() {
        return this.c;
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter
    @NotNull
    public SingleLiveEvent<Unit> getUserBlockedStream() {
        return this.e;
    }
}
