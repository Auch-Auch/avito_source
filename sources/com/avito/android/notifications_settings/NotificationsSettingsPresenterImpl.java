package com.avito.android.notifications_settings;

import a2.g.r.g;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B]\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010=\u001a\u00020:\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040%\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*\u0012\b\u0010I\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010(¨\u0006L"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsPresenterImpl;", "Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "Lcom/avito/android/notifications_settings/NotificationsSettingsView;", "view", "", "attachView", "(Lcom/avito/android/notifications_settings/NotificationsSettingsView;)V", "Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;", "router", "attachRouter", "(Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;)V", "", "isEnabled", "checkNotificationsEnabled", "(Z)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/notifications_settings/NotificationsSettingsView;Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;)V", AuthSource.BOOKING_ORDER, "e", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "Lcom/avito/android/remote/error/ErrorResult;", "f", "Lcom/avito/android/remote/error/ErrorResult;", "error", g.a, "Z", "areNotificationsEnabled", "d", "Lcom/avito/android/notifications_settings/NotificationsSettingsView;", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleItem;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/Relay;", "toggleObservable", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "n", "Lio/reactivex/rxjava3/functions/Consumer;", "changeSettingsConsumer", "Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;", "i", "Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;", "converter", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;", "h", "Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;", "interactor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "c", "Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;", "l", "settingsObservable", "state", "<init>", "(Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/util/Kundle;)V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsPresenterImpl implements NotificationsSettingsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public Disposable b;
    public NotificationsSettingsRouter c;
    public NotificationsSettingsView d;
    public NotificationsSettings e;
    public ErrorResult f;
    public boolean g;
    public final NotificationsSettingsInteractor h;
    public final NotificationsSettingsConverter i;
    public final SchedulersFactory j;
    public final AdapterPresenter k;
    public final Relay<Unit> l;
    public final Relay<NotificationsSettingsToggleItem> m;
    public final Consumer<NotificationSettingsChangeEvent> n;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements io.reactivex.functions.Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                NotificationsSettingsRouter notificationsSettingsRouter = ((NotificationsSettingsPresenterImpl) this.b).c;
                if (notificationsSettingsRouter != null) {
                    notificationsSettingsRouter.closeScreen();
                }
            } else if (i == 1) {
                ((NotificationsSettingsPresenterImpl) this.b).b();
            } else if (i == 2) {
                NotificationsSettingsRouter notificationsSettingsRouter2 = ((NotificationsSettingsPresenterImpl) this.b).c;
                if (notificationsSettingsRouter2 != null) {
                    notificationsSettingsRouter2.openSettings();
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements io.reactivex.functions.Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                return;
            }
            if (i == 2) {
                return;
            }
            if (i != 3) {
                throw null;
            }
        }
    }

    public static final class c<T> implements io.reactivex.functions.Consumer<NotificationsSettingsToggleItem> {
        public final /* synthetic */ NotificationsSettingsPresenterImpl a;

        public c(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl) {
            this.a = notificationsSettingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(NotificationsSettingsToggleItem notificationsSettingsToggleItem) {
            NotificationsSettingsToggleItem notificationsSettingsToggleItem2 = notificationsSettingsToggleItem;
            NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(notificationsSettingsToggleItem2, "it");
            NotificationsSettingsPresenterImpl.access$toggle(notificationsSettingsPresenterImpl, notificationsSettingsToggleItem2);
        }
    }

    public static final class d<T> implements io.reactivex.functions.Consumer<LoadingState<? super NotificationsSettings>> {
        public final /* synthetic */ NotificationsSettingsPresenterImpl a;

        public d(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl) {
            this.a = notificationsSettingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super NotificationsSettings> loadingState) {
            LoadingState<? super NotificationsSettings> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                NotificationsSettingsView notificationsSettingsView = this.a.d;
                if (notificationsSettingsView != null) {
                    notificationsSettingsView.showLoadProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                NotificationsSettingsPresenterImpl.access$bindLoadLoaded(this.a, (NotificationsSettings) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Error) {
                NotificationsSettingsPresenterImpl.access$bindLoadError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class e<T> implements io.reactivex.functions.Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public NotificationsSettingsPresenterImpl(@NotNull NotificationsSettingsInteractor notificationsSettingsInteractor, @NotNull NotificationsSettingsConverter notificationsSettingsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull Relay<Unit> relay, @NotNull Relay<NotificationsSettingsToggleItem> relay2, @NotNull Consumer<NotificationSettingsChangeEvent> consumer, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(notificationsSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(notificationsSettingsConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(relay, "settingsObservable");
        Intrinsics.checkNotNullParameter(relay2, "toggleObservable");
        Intrinsics.checkNotNullParameter(consumer, "changeSettingsConsumer");
        this.h = notificationsSettingsInteractor;
        this.i = notificationsSettingsConverter;
        this.j = schedulersFactory;
        this.k = adapterPresenter;
        this.l = relay;
        this.m = relay2;
        this.n = consumer;
        ErrorResult errorResult = null;
        this.e = kundle != null ? (NotificationsSettings) kundle.getParcelable("key_data") : null;
        this.f = kundle != null ? (ErrorResult) kundle.getParcelable("key_error") : errorResult;
    }

    public static final void access$bindLoadError(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl, TypedError typedError) {
        notificationsSettingsPresenterImpl.b = null;
        if (typedError instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) typedError;
            notificationsSettingsPresenterImpl.f = errorResult;
            NotificationsSettingsView notificationsSettingsView = notificationsSettingsPresenterImpl.d;
            if (notificationsSettingsView != null) {
                notificationsSettingsView.showLoadError(errorResult.getMessage());
            }
        }
    }

    public static final void access$bindLoadLoaded(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl, NotificationsSettings notificationsSettings) {
        notificationsSettingsPresenterImpl.b = null;
        notificationsSettingsPresenterImpl.e = notificationsSettings;
        NotificationsSettingsView notificationsSettingsView = notificationsSettingsPresenterImpl.d;
        if (notificationsSettingsView != null) {
            notificationsSettingsPresenterImpl.a(notificationsSettingsView, notificationsSettings);
        }
    }

    public static final void access$bindSaveError(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl, TypedError typedError) {
        NotificationsSettingsView notificationsSettingsView = notificationsSettingsPresenterImpl.d;
        if (notificationsSettingsView != null && (typedError instanceof ErrorResult)) {
            notificationsSettingsView.showSaveError(((ErrorResult) typedError).getMessage());
        }
    }

    public static final void access$toggle(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl, NotificationsSettingsToggleItem notificationsSettingsToggleItem) {
        NotificationsSettings notificationsSettings;
        NotificationsSettings notificationsSettings2 = notificationsSettingsPresenterImpl.e;
        if (notificationsSettings2 != null) {
            for (T t : notificationsSettings2.getSections()) {
                if (Intrinsics.areEqual(t.getType(), notificationsSettingsToggleItem.getSection())) {
                    for (T t2 : t.getChannels()) {
                        if (Intrinsics.areEqual(t2.getType(), notificationsSettingsToggleItem.getChannel())) {
                            if (!(t2 instanceof NotificationsSettings.Section.Channel.Push) || notificationsSettingsPresenterImpl.g) {
                                t2.setValue(!notificationsSettingsToggleItem.isChecked());
                                String type = t.getType();
                                String type2 = t2.getType();
                                notificationsSettingsPresenterImpl.h.save(type, type2, t2.getValue()).observeOn(notificationsSettingsPresenterImpl.j.mainThread()).subscribe(new a2.a.a.q1.b(notificationsSettingsPresenterImpl, type, type2), a2.a.a.q1.c.a);
                            } else {
                                NotificationsSettingsRouter notificationsSettingsRouter = notificationsSettingsPresenterImpl.c;
                                if (notificationsSettingsRouter != null) {
                                    notificationsSettingsRouter.openDialog();
                                }
                            }
                            NotificationsSettingsView notificationsSettingsView = notificationsSettingsPresenterImpl.d;
                            if (!(notificationsSettingsView == null || (notificationsSettings = notificationsSettingsPresenterImpl.e) == null)) {
                                notificationsSettingsPresenterImpl.a(notificationsSettingsView, notificationsSettings);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(NotificationsSettingsView notificationsSettingsView, NotificationsSettings notificationsSettings) {
        this.k.onDataSourceChanged(new ListDataSource(this.i.convert(notificationsSettings, this.g)));
        notificationsSettingsView.notifyDataChanged();
        notificationsSettingsView.showLoadContent();
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    public void attachRouter(@NotNull NotificationsSettingsRouter notificationsSettingsRouter) {
        Intrinsics.checkNotNullParameter(notificationsSettingsRouter, "router");
        this.c = notificationsSettingsRouter;
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    public void attachView(@NotNull NotificationsSettingsView notificationsSettingsView) {
        Intrinsics.checkNotNullParameter(notificationsSettingsView, "view");
        this.d = notificationsSettingsView;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = notificationsSettingsView.getBackClicks().observeOn(this.j.mainThread()).subscribe(new a(0, this), b.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.getBackClicks()\n   …         {}\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = notificationsSettingsView.getRetryClicks().observeOn(this.j.mainThread()).subscribe(new a(1, this), b.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.getRetryClicks()\n  …         {}\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe3 = this.l.observeOn(this.j.mainThread()).subscribe(new a(2, this), b.d);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "settingsObservable.obser…         {}\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe4 = this.m.observeOn(this.j.mainThread()).subscribe(new c(this), b.e);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "toggleObservable.observe…         {}\n            )");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        NotificationsSettings notificationsSettings = this.e;
        ErrorResult errorResult = this.f;
        if (notificationsSettings != null) {
            a(notificationsSettingsView, notificationsSettings);
        } else if (errorResult != null) {
            notificationsSettingsView.showLoadError(errorResult.getMessage());
        } else {
            b();
        }
    }

    public final void b() {
        this.f = null;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.h.load().observeOn(this.j.mainThread()).subscribe(new d(this), e.a);
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    public void checkNotificationsEnabled(boolean z) {
        NotificationsSettings notificationsSettings;
        if (z != this.g) {
            this.g = z;
            NotificationsSettingsView notificationsSettingsView = this.d;
            if (notificationsSettingsView != null && (notificationsSettings = this.e) != null) {
                a(notificationsSettingsView, notificationsSettings);
            }
        }
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    public void detachView() {
        this.a.clear();
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
        this.d = null;
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.e).putParcelable("key_error", this.f);
    }
}
