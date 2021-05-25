package ru.avito.component.floating_add_advert;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.add_advert.AddAdvertView;
import com.avito.android.design.widget.lifecycle_view.AttachListener;
import com.avito.android.design.widget.lifecycle_view.LifecycleView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.android.util.loading_state.SimpleMessageError;
import com.avito.android.util.loading_state.TypedError;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.floating_add_advert.FloatingAddAdvert;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\bD\u0010EJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010B¨\u0006F"}, d2 = {"Lru/avito/component/floating_add_advert/FloatingAddAdvertImpl;", "Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;)V", "onAttach", "onDetach", "Lio/reactivex/rxjava3/core/Observable;", "", "addAdvertOpenCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "aboutToBeExpandedCallbacks", "Lcom/avito/android/deep_linking/links/DeepLink;", "addAdvertClicks", "Lcom/avito/android/design/widget/add_advert/AddAdvertView$FinishReason;", "addAdvertFinishCallbacks", "expandCallback", "resizeButton", "setResizeButton", "(Z)V", "expandAddAdvertWithDraftCheck", "continueExpandAddAdvert", "showAddAdvert", "hideAddAdvert", "show", "animate", "animateFloatingAddAdvert", "(ZZ)V", "handleBack", "()Z", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "Lcom/jakewharton/rxrelay3/PublishRelay;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "buttonLayout", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "d", "Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;", "f", "Z", "lockPosition", "Lru/avito/component/floating_add_advert/AccountLoginStateProvider;", "h", "Lru/avito/component/floating_add_advert/AccountLoginStateProvider;", "accountState", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "i", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "interactor", "Lcom/avito/android/design/widget/add_advert/AddAdvertView;", "Lcom/avito/android/design/widget/add_advert/AddAdvertView;", "addAdvertView", "<init>", "(Landroid/view/View;Lru/avito/component/floating_add_advert/AccountLoginStateProvider;Lru/avito/component/floating_add_advert/AddAdvertInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingAddAdvertImpl implements FloatingAddAdvert, AttachListener {
    public final AddAdvertView a;
    public final View b;
    public final CompositeDisposable c = new CompositeDisposable();
    public FloatingAddAdvert.EventListener d;
    public final PublishRelay<Boolean> e;
    public boolean f;
    public final View g;
    public final AccountLoginStateProvider h;
    public final AddAdvertInteractor i;
    public final SchedulersFactory3 j;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX DEBUG: Multi-variable search result rejected for r4v13, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                FloatingAddAdvertImpl.access$onAddAdvertButtonClicked((FloatingAddAdvertImpl) this.b);
                ((FloatingAddAdvertImpl) this.b).e.accept(Boolean.TRUE);
                ((FloatingAddAdvertImpl) this.b).animateFloatingAddAdvert(true, false);
            } else if (i == 1) {
                ((FloatingAddAdvertImpl) this.b).e.accept(Boolean.FALSE);
                ((FloatingAddAdvertImpl) this.b).f = false;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ FloatingAddAdvertImpl a;

        public c(FloatingAddAdvertImpl floatingAddAdvertImpl) {
            this.a = floatingAddAdvertImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                FloatingAddAdvertImpl.access$load(this.a);
                return;
            }
            this.a.a.openLink(new AuthenticateLink(AuthSource.CREATE_ADVERT, null, 2, null));
            FloatingAddAdvert.EventListener eventListener = this.a.d;
            if (eventListener != null) {
                eventListener.onUserAuntificationRequested();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Auth status getting for button expanding is failure", th);
        }
    }

    public static final class e<T> implements Consumer<AdvertShortcut> {
        public final /* synthetic */ FloatingAddAdvertImpl a;

        public e(FloatingAddAdvertImpl floatingAddAdvertImpl) {
            this.a = floatingAddAdvertImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertShortcut advertShortcut) {
            AdvertShortcut advertShortcut2 = advertShortcut;
            FloatingAddAdvert.EventListener eventListener = this.a.d;
            if (eventListener != null) {
                Intrinsics.checkNotNullExpressionValue(advertShortcut2, "advertShortCut");
                eventListener.onPublishVerticalChosen(advertShortcut2);
            }
        }
    }

    public FloatingAddAdvertImpl(@NotNull View view, @NotNull AccountLoginStateProvider accountLoginStateProvider, @NotNull AddAdvertInteractor addAdvertInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(accountLoginStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.g = view;
        this.h = accountLoginStateProvider;
        this.i = addAdvertInteractor;
        this.j = schedulersFactory3;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.add_advert.AddAdvertView");
        this.a = (AddAdvertView) view;
        View findViewById = view.findViewById(R.id.layout_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        PublishRelay<Boolean> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        View findViewById2 = view.findViewById(R.id.lifecycle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.design.widget.lifecycle_view.LifecycleView");
        LifecycleView lifecycleView = (LifecycleView) findViewById2;
        lifecycleView.setAttachListener(this);
        if (ViewCompat.isAttachedToWindow(lifecycleView)) {
            b();
        }
    }

    public static final String access$getErrorMessage(FloatingAddAdvertImpl floatingAddAdvertImpl, TypedError typedError) {
        Objects.requireNonNull(floatingAddAdvertImpl);
        if (typedError instanceof SimpleMessageError) {
            return ((SimpleMessageError) typedError).getMessage();
        }
        return null;
    }

    public static final void access$load(FloatingAddAdvertImpl floatingAddAdvertImpl) {
        floatingAddAdvertImpl.c.clear();
        floatingAddAdvertImpl.b();
        CompositeDisposable compositeDisposable = floatingAddAdvertImpl.c;
        Disposable subscribe = floatingAddAdvertImpl.i.getAdvertShortcutsLoadingProgress().observeOn(floatingAddAdvertImpl.j.mainThread()).subscribe(new a7.a.a.c.c(floatingAddAdvertImpl), a7.a.a.c.d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onAddAdvertButtonClicked(FloatingAddAdvertImpl floatingAddAdvertImpl) {
        floatingAddAdvertImpl.a();
    }

    public static final void access$resubscribeToView(FloatingAddAdvertImpl floatingAddAdvertImpl) {
        floatingAddAdvertImpl.c.clear();
        floatingAddAdvertImpl.b();
    }

    public final void a() {
        FloatingAddAdvert.EventListener eventListener = this.d;
        if (eventListener != null) {
            eventListener.onButtonsShowed();
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.h.isAuthorized().observeOn(this.j.mainThread()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountState.isAuthorize…nding is failure\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    @NotNull
    public Observable<Unit> aboutToBeExpandedCallbacks() {
        return this.a.aboutToBeOpenedCallbacks();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    @NotNull
    public Observable<DeepLink> addAdvertClicks() {
        return this.a.advertClicks();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    @NotNull
    public Observable<AddAdvertView.FinishReason> addAdvertFinishCallbacks() {
        return this.a.finishCallbacks();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    @NotNull
    public Observable<Boolean> addAdvertOpenCallbacks() {
        return this.a.openCallbacks();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void animateFloatingAddAdvert(boolean z, boolean z2) {
        int i2;
        if (z || !this.f) {
            if (z) {
                i2 = 0;
            } else {
                Context context = this.g.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                i2 = Contexts.getDisplayHeight(context) - this.b.getTop();
            }
            this.b.animate().translationY((float) i2).setDuration(z2 ? 300 : 0).start();
        }
    }

    public final void b() {
        if (this.c.size() <= 0) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.a.addClicks().subscribe(new a(0, this), b.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "addAdvertView.addClicks(…   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.c;
            Disposable subscribe2 = this.a.collapseClicks().subscribe(new a(1, this), b.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "addAdvertView.collapseCl…   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.c;
            Disposable subscribe3 = this.a.publishVerticalCallbacks().subscribe(new e(this), b.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "addAdvertView\n          …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        }
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void continueExpandAddAdvert() {
        this.a.openButton();
        FloatingAddAdvert.EventListener eventListener = this.d;
        if (eventListener != null) {
            eventListener.onNewAdvertIntent();
        }
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void expandAddAdvertWithDraftCheck() {
        a();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    @NotNull
    public Observable<Boolean> expandCallback() {
        return this.e;
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public boolean handleBack() {
        return this.a.handleBack();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void hideAddAdvert() {
        Views.conceal(this.g);
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onAttach() {
        b();
        FloatingAddAdvert.EventListener eventListener = this.d;
        if (eventListener != null) {
            eventListener.onAttach();
        }
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onDetach() {
        this.c.clear();
        FloatingAddAdvert.EventListener eventListener = this.d;
        if (eventListener != null) {
            eventListener.onDetach();
        }
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void setListener(@Nullable FloatingAddAdvert.EventListener eventListener) {
        this.d = eventListener;
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void setResizeButton(boolean z) {
        this.a.setResizeButton(z);
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert
    public void showAddAdvert() {
        Views.show(this.g);
    }
}
