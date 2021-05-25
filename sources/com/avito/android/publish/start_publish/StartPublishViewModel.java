package com.avito.android.publish.start_publish;

import a2.a.a.e2.e0.f;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.UnauthPublishAttemptEvent;
import com.avito.android.analytics.publish.FromPage;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001<BG\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u00109\u001a\u000206¢\u0006\u0004\b:\u0010;J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "state", "()Landroidx/lifecycle/LiveData;", "", "checkAuthorization", "()V", "onRestoreDraftRejected", "onCleared", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/account/AccountStateProvider;", "f", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "h", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "interactor", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "i", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "k", "Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "resourcesProvider", "", "c", "Z", "getShouldFinishOnResume", "()Z", "setShouldFinishOnResume", "(Z)V", "shouldFinishOnResume", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "j", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "sessionIdGenerator", "Lcom/avito/android/publish/analytics/PublishEventTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/start_publish/StartPublishInteractor;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "State", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishViewModel extends ViewModel {
    public boolean c;
    public final MutableLiveData<State> d = new MutableLiveData<>();
    public final CompositeDisposable e = new CompositeDisposable();
    public final AccountStateProvider f;
    public final SchedulersFactory3 g;
    public final StartPublishInteractor h;
    public final PublishAnalyticsDataProvider i;
    public final PublishSessionIdGenerator j;
    public final StartPublishResourceProvider k;
    public final Analytics l;
    public final PublishEventTracker m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "", "<init>", "()V", "DraftDialog", "Error", "LoadingSheet", "UnAuthorized", "WizardSheet", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$UnAuthorized;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$LoadingSheet;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$DraftDialog;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$WizardSheet;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$Error;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$DraftDialog;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "sessionId", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "getDialogInfo", "()Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "dialogInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class DraftDialog extends State {
            @NotNull
            public final String a;
            @NotNull
            public final DeepLinksDialogInfo b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DraftDialog(@NotNull String str, @NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "sessionId");
                Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
                this.a = str;
                this.b = deepLinksDialogInfo;
            }

            @NotNull
            public final DeepLinksDialogInfo getDialogInfo() {
                return this.b;
            }

            @NotNull
            public final String getSessionId() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$Error;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$LoadingSheet;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoadingSheet extends State {
            @NotNull
            public static final LoadingSheet INSTANCE = new LoadingSheet();

            public LoadingSheet() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$UnAuthorized;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class UnAuthorized extends State {
            @NotNull
            public static final UnAuthorized INSTANCE = new UnAuthorized();

            public UnAuthorized() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModel$State$WizardSheet;", "Lcom/avito/android/publish/start_publish/StartPublishViewModel$State;", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", "getData", "()Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", "data", "<init>", "(Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class WizardSheet extends State {
            @NotNull
            public final StartPublishSheet.SheetData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public WizardSheet(@NotNull StartPublishSheet.SheetData sheetData) {
                super(null);
                Intrinsics.checkNotNullParameter(sheetData, "data");
                this.a = sheetData;
            }

            @NotNull
            public final StartPublishSheet.SheetData getData() {
                return this.a;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ StartPublishViewModel a;

        public a(StartPublishViewModel startPublishViewModel) {
            this.a = startPublishViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                StartPublishViewModel.access$loadPageData(this.a);
                return;
            }
            this.a.l.track(new UnauthPublishAttemptEvent());
            StartPublishViewModel.access$authorize(this.a);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can not get auth status", th);
        }
    }

    public static final class c<T> implements Consumer<List<? extends StartPublishSheet.SheetData.CategoryShortcutItem>> {
        public final /* synthetic */ StartPublishViewModel a;

        public c(StartPublishViewModel startPublishViewModel) {
            this.a = startPublishViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends StartPublishSheet.SheetData.CategoryShortcutItem> list) {
            List<? extends StartPublishSheet.SheetData.CategoryShortcutItem> list2 = list;
            StartPublishViewModel startPublishViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            StartPublishViewModel.access$showPublishSheet(startPublishViewModel, list2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can not get category shortcuts", th);
        }
    }

    public StartPublishViewModel(@NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull StartPublishInteractor startPublishInteractor, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator, @NotNull StartPublishResourceProvider startPublishResourceProvider, @NotNull Analytics analytics, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(startPublishInteractor, "interactor");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "sessionIdGenerator");
        Intrinsics.checkNotNullParameter(startPublishResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishEventTracker, "eventTracker");
        this.f = accountStateProvider;
        this.g = schedulersFactory3;
        this.h = startPublishInteractor;
        this.i = publishAnalyticsDataProvider;
        this.j = publishSessionIdGenerator;
        this.k = startPublishResourceProvider;
        this.l = analytics;
        this.m = publishEventTracker;
    }

    public static final void access$authorize(StartPublishViewModel startPublishViewModel) {
        startPublishViewModel.d.setValue(State.UnAuthorized.INSTANCE);
    }

    public static final void access$loadPageData(StartPublishViewModel startPublishViewModel) {
        startPublishViewModel.d.setValue(State.LoadingSheet.INSTANCE);
        CompositeDisposable compositeDisposable = startPublishViewModel.e;
        Disposable subscribe = startPublishViewModel.h.loadStartupSheetData().subscribe(new f(startPublishViewModel), new a2.a.a.e2.e0.g(startPublishViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…Message())\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$showPublishSheet(StartPublishViewModel startPublishViewModel, List list) {
        startPublishViewModel.i.setSessionId(startPublishViewModel.j.reCreatePublishSessionId());
        startPublishViewModel.i.setFromPage(FromPage.ITEM_ADD);
        startPublishViewModel.i.setItemId(null);
        startPublishViewModel.i.setTrackedCategory(null);
        startPublishViewModel.m.trackNewAdvertShown();
        startPublishViewModel.d.setValue(new State.WizardSheet(new StartPublishSheet.SheetData(list)));
    }

    public final void checkAuthorization() {
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.f.currentAuthorized().observeOn(this.g.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountState\n           …atus\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final boolean getShouldFinishOnResume() {
        return this.c;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.e.clear();
        super.onCleared();
    }

    public final void onRestoreDraftRejected() {
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.h.deleteDraftWithPhotos().subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…\n            .subscribe()");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe2 = this.h.getCategoryShortcuts().subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.getCategorySh…cuts\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void setShouldFinishOnResume(boolean z) {
        this.c = z;
    }

    @NotNull
    public final LiveData<State> state() {
        return this.d;
    }
}
