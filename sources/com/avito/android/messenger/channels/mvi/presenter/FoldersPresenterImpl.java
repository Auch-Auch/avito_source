package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessengerFolderClickEvent;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002/0B7\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "processScreenOpened", "()V", "", VKApiConst.POSITION, "tabSelected", "(I)V", "onCleared", "Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;", "t", "Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;", "onboardingStatusStorage", "Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;", "s", "Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;", "foldersInteractor", "", VKApiConst.Q, "Lkotlin/Lazy;", "getMessengerFolderTabsEnabled", "()Z", "messengerFolderTabsEnabled", "Lcom/avito/android/analytics/Analytics;", "u", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "r", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getShowOnboardingStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "showOnboardingStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/analytics/Analytics;)V", "ChangeSelectedFolderMutator", "UpdateTabsMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersPresenterImpl extends BaseMviEntityWithReducerQueue<FoldersPresenter.State> implements FoldersPresenter {
    public final CompositeDisposable p;
    public final Lazy q;
    @NotNull
    public final SingleLiveEvent<Unit> r = new SingleLiveEvent<>();
    public final FoldersInteractor s;
    public final FolderOnboardingStatusStorage t;
    public final Analytics u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl$ChangeSelectedFolderMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "d", "I", VKApiConst.POSITION, "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChangeSelectedFolderMutator extends Mutator<FoldersPresenter.State> {
        public final int d;

        public ChangeSelectedFolderMutator(int i) {
            super(null, null, 3, null);
            this.d = i;
        }

        @NotNull
        public FoldersPresenter.State invoke(@NotNull FoldersPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (this.d > state.getTabs().size()) {
                return state;
            }
            FoldersPresenterImpl.this.u.track(new MessengerFolderClickEvent(state.getTabs().get(this.d).getFolderId()));
            return FoldersPresenter.State.copy$default(state, null, this.d, 1, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl$UpdateTabsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$FolderTab;", "d", "Ljava/util/List;", "tabs", "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenterImpl;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdateTabsMutator extends Mutator<FoldersPresenter.State> {
        public final List<FoldersPresenter.FolderTab> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateTabsMutator(@NotNull FoldersPresenterImpl foldersPresenterImpl, List<FoldersPresenter.FolderTab> list) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(list, "tabs");
            this.d = list;
        }

        @NotNull
        public FoldersPresenter.State invoke(@NotNull FoldersPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return FoldersPresenter.State.copy$default(state, this.d, 0, 2, null);
        }
    }

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ ManuallyExposedAbTestGroup a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ManuallyExposedAbTestGroup manuallyExposedAbTestGroup) {
            super(0);
            this.a = manuallyExposedAbTestGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(((MessengerFolderTabsTestGroup) this.a.getTestGroup()).isTest());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public FoldersPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull FoldersInteractor foldersInteractor, @NotNull FolderOnboardingStatusStorage folderOnboardingStatusStorage, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, @NotNull Analytics analytics) {
        super("FoldersPresenter", FoldersPresenter.State.Companion.getDEFAULT(), schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(foldersInteractor, "foldersInteractor");
        Intrinsics.checkNotNullParameter(folderOnboardingStatusStorage, "onboardingStatusStorage");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.s = foldersInteractor;
        this.t = folderOnboardingStatusStorage;
        this.u = analytics;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        this.q = c.lazy(new a(manuallyExposedAbTestGroup));
        Disposable subscribe = foldersInteractor.getFoldersCounterStream().observeOn(getSchedulers().computation()).distinctUntilChanged().subscribe(new a2.a.a.o1.b.b.c.a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "foldersInteractor.folder…tator(tabs)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter
    public void processScreenOpened() {
        this.s.refreshCounters();
        if (((Boolean) this.q.getValue()).booleanValue() && !this.t.getWasBannerShowed()) {
            getShowOnboardingStream().postValue(Unit.INSTANCE);
            this.t.setWasBannerShowed(true);
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter
    public void tabSelected(int i) {
        getReducerQueue().plusAssign(new ChangeSelectedFolderMutator(i));
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter
    @NotNull
    public SingleLiveEvent<Unit> getShowOnboardingStream() {
        return this.r;
    }
}
