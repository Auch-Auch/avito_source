package com.avito.android.app_rater.fragment;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.app_rater.events.AppRaterBeenRatedEvent;
import com.avito.android.app_rater.events.AppRaterClosedEvent;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.events.AppRaterRemindLaterClickedEvent;
import com.avito.android.app_rater.events.AppRaterShownEvent;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00011B1\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b/\u00100J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020%0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "", "init", "()V", "", "score", "goToGooglePlayStore", "(I)V", "goToFeedback", "close", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/server_time/TimeSource;", g.a, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/app_rater/AppRaterInteractor;", "f", "Lcom/avito/android/app_rater/AppRaterInteractor;", "interactor", "Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;", "j", "Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;", "sourcePage", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State;", "e", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "state", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "stateLiveData", "<init>", "(Lcom/avito/android/app_rater/AppRaterInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;)V", "State", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class AppRaterDialogFragmentViewModel extends ViewModel {
    public final SingleLiveEvent<State> c;
    public final CompositeDisposable d = new CompositeDisposable();
    @NotNull
    public final LiveData<State> e;
    public final AppRaterInteractor f;
    public final TimeSource g;
    public final SchedulersFactory h;
    public final Analytics i;
    public final AppRaterEventSourcePage j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State;", "", "<init>", "()V", "Close", "RedirectToFeedback", "RedirectToGooglePlay", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$RedirectToGooglePlay;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$RedirectToFeedback;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$Close;", "app-rater_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$Close;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State;", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
        public static final class Close extends State {
            @NotNull
            public static final Close INSTANCE = new Close();

            public Close() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$RedirectToFeedback;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State;", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
        public static final class RedirectToFeedback extends State {
            @NotNull
            public static final RedirectToFeedback INSTANCE = new RedirectToFeedback();

            public RedirectToFeedback() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State$RedirectToGooglePlay;", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel$State;", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
        public static final class RedirectToGooglePlay extends State {
            @NotNull
            public static final RedirectToGooglePlay INSTANCE = new RedirectToGooglePlay();

            public RedirectToGooglePlay() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Boolean> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can't save last app rater session", th);
        }
    }

    public AppRaterDialogFragmentViewModel(@NotNull AppRaterInteractor appRaterInteractor, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @Nullable AppRaterEventSourcePage appRaterEventSourcePage) {
        String value;
        Intrinsics.checkNotNullParameter(appRaterInteractor, "interactor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = appRaterInteractor;
        this.g = timeSource;
        this.h = schedulersFactory;
        this.i = analytics;
        this.j = appRaterEventSourcePage;
        SingleLiveEvent<State> singleLiveEvent = new SingleLiveEvent<>();
        this.c = singleLiveEvent;
        if (!(appRaterEventSourcePage == null || (value = appRaterEventSourcePage.getValue()) == null)) {
            analytics.track(new AppRaterShownEvent(value));
        }
        this.e = singleLiveEvent;
    }

    public final void close() {
        String value;
        AppRaterEventSourcePage appRaterEventSourcePage = this.j;
        if (!(appRaterEventSourcePage == null || (value = appRaterEventSourcePage.getValue()) == null)) {
            this.i.track(new AppRaterRemindLaterClickedEvent(value));
        }
        this.c.setValue(State.Close.INSTANCE);
    }

    @NotNull
    public final LiveData<State> getState() {
        return this.e;
    }

    public final void goToFeedback(int i2) {
        String value;
        AppRaterEventSourcePage appRaterEventSourcePage = this.j;
        if (!(appRaterEventSourcePage == null || (value = appRaterEventSourcePage.getValue()) == null)) {
            this.i.track(new AppRaterBeenRatedEvent(value, i2));
        }
        this.c.setValue(State.RedirectToFeedback.INSTANCE);
    }

    public final void goToGooglePlayStore(int i2) {
        String value;
        AppRaterEventSourcePage appRaterEventSourcePage = this.j;
        if (!(appRaterEventSourcePage == null || (value = appRaterEventSourcePage.getValue()) == null)) {
            this.i.track(new AppRaterBeenRatedEvent(value, i2));
        }
        this.c.setValue(State.RedirectToGooglePlay.INSTANCE);
    }

    public final void init() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.f.saveAppRaterSession(this.g.now()).subscribeOn(this.h.io()).observeOn(this.h.mainThread()).subscribe(a.a, b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…pp rater session\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        String value;
        AppRaterEventSourcePage appRaterEventSourcePage = this.j;
        if (!(appRaterEventSourcePage == null || (value = appRaterEventSourcePage.getValue()) == null)) {
            this.i.track(new AppRaterClosedEvent(value));
        }
        this.d.clear();
        super.onCleared();
    }
}
