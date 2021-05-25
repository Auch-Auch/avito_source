package com.avito.android.publish.wizard;

import a2.g.r.g;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.wizard.WizardPresenter;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTracker;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.ui_components.R;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Throwables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010l\u001a\u0004\u0018\u00010i\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010^\u001a\u00020[\u0012\b\b\u0002\u0010o\u001a\u00020\u0007\u0012\b\b\u0002\u0010f\u001a\u00020\u001d\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u000108\u0012\u0019\u0010u\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030q¢\u0006\u0002\br0p¢\u0006\u0004\bv\u0010wJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001dH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u0018\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R(\u0010c\u001a\u0004\u0018\u0001082\b\u0010_\u001a\u0004\u0018\u0001088B@BX\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\b=\u0010bR\u0016\u0010f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR)\u0010u\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030q¢\u0006\u0002\br0p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006x"}, d2 = {"Lcom/avito/android/publish/wizard/WizardPresenterImpl;", "Lcom/avito/android/publish/wizard/WizardPresenter;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/remote/model/WizardParameter;", "currentSection", "", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/WizardParameter;)Z", "c", "e", "Landroid/os/Bundle;", VKApiConst.OUT, "onSaveState", "(Landroid/os/Bundle;)V", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "Lcom/avito/android/publish/PublishViewModel;", "viewModel", "attachPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "Lcom/avito/android/publish/wizard/WizardRouter;", "router", "attachWizardRouter", "(Lcom/avito/android/publish/wizard/WizardRouter;)V", "Lcom/avito/android/publish/wizard/WizardView;", "view", "", "stepIndex", "attachView", "(Lcom/avito/android/publish/wizard/WizardView;I)V", "detachView", "detachRouter", "onBackPressed", "()Z", "detachWizardRouter", "Lcom/avito/android/publish/wizard/WizardPresenter$Router;", "attachRouter", "(Lcom/avito/android/publish/wizard/WizardPresenter$Router;)V", "requestCode", "resultCode", "onResult", "(II)Z", "onRetryClick", "onCloseClick", "Lcom/avito/android/publish/wizard/WizardView;", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/model/Navigation;", "s", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/publish/wizard/WizardPresenter$Router;", "d", "Lcom/avito/android/publish/wizard/WizardRouter;", "wizardRouter", "Lcom/avito/android/publish/wizard/WizardInteractor;", "j", "Lcom/avito/android/publish/wizard/WizardInteractor;", "interactor", g.a, "Ljava/lang/Integer;", "Landroid/content/res/Resources;", "n", "Landroid/content/res/Resources;", "resources", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadDisposable", "h", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/util/ErrorFormatter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "p", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "tracker", "value", "getCurrentNavigation", "()Lcom/avito/android/remote/model/Navigation;", "(Lcom/avito/android/remote/model/Navigation;)V", "currentNavigation", "r", "I", "wizardRootLevel", "f", "Lcom/avito/android/remote/model/WizardParameter;", "", "i", "Ljava/lang/String;", "itemId", VKApiConst.Q, "Z", "showAlwaysArrow", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "t", "Ljava/util/Set;", "itemPresenterSet", "<init>", "(Ljava/lang/String;Lcom/avito/android/publish/wizard/WizardInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;Landroid/content/res/Resources;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;ZILcom/avito/android/remote/model/Navigation;Ljava/util/Set;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardPresenterImpl implements WizardPresenter {
    public Disposable a;
    public final CompositeDisposable b;
    public WizardView c;
    public WizardRouter d;
    public WizardPresenter.Router e;
    public WizardParameter f;
    public Integer g;
    public PublishViewModel h;
    public final String i;
    public final WizardInteractor j;
    public final AdapterPresenter k;
    public final SchedulersFactory l;
    public final ErrorFormatter m;
    public final Resources n;
    public final Analytics o;
    public final CategoriesWizardTracker p;
    public final boolean q;
    public final int r;
    public final Navigation s;
    public final Set<ItemPresenter<?, ?>> t;

    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            Logs.error(th2);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<WizardParameter> {
        public final /* synthetic */ WizardPresenterImpl a;

        public c(WizardPresenterImpl wizardPresenterImpl) {
            this.a = wizardPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(WizardParameter wizardParameter) {
            WizardParameter wizardParameter2 = wizardParameter;
            this.a.p.trackWizardParamsLoad();
            this.a.p.startWizardParamsDraw();
            WizardPresenterImpl wizardPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(wizardParameter2, "it");
            WizardPresenterImpl.access$handleSuccessLoad(wizardPresenterImpl, wizardParameter2);
            this.a.p.trackWizardParamsDraw();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ WizardPresenterImpl a;

        public d(WizardPresenterImpl wizardPresenterImpl) {
            this.a = wizardPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.p.trackWizardParamsLoadError();
            WizardPresenterImpl wizardPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            WizardPresenterImpl.access$handleError(wizardPresenterImpl, th2);
        }
    }

    public static final class e<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ WizardPresenterImpl a;

        public e(WizardPresenterImpl wizardPresenterImpl) {
            this.a = wizardPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            OnboardingData onboardingData2 = onboardingData;
            WizardView wizardView = this.a.c;
            if (wizardView != null) {
                Intrinsics.checkNotNullExpressionValue(onboardingData2, "it");
                wizardView.showActionOnboarding(onboardingData2);
            }
        }
    }

    public WizardPresenterImpl(@Nullable String str, @NotNull WizardInteractor wizardInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter, @NotNull Resources resources, @NotNull Analytics analytics, @NotNull CategoriesWizardTracker categoriesWizardTracker, boolean z, int i2, @Nullable Navigation navigation, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(wizardInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(categoriesWizardTracker, "tracker");
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.i = str;
        this.j = wizardInteractor;
        this.k = adapterPresenter;
        this.l = schedulersFactory;
        this.m = errorFormatter;
        this.n = resources;
        this.o = analytics;
        this.p = categoriesWizardTracker;
        this.q = z;
        this.r = i2;
        this.s = navigation;
        this.t = set;
        this.b = new CompositeDisposable();
    }

    public static final void access$handleError(WizardPresenterImpl wizardPresenterImpl, Throwable th) {
        Objects.requireNonNull(wizardPresenterImpl);
        if (Throwables.isAuthProblem(th)) {
            WizardPresenter.Router router = wizardPresenterImpl.e;
            if (router != null) {
                router.navigateToAuth();
            }
        } else if (Throwables.isNetworkProblem(th)) {
            wizardPresenterImpl.p.startWizardParamsDraw();
            WizardView wizardView = wizardPresenterImpl.c;
            if (wizardView != null) {
                wizardView.showRetry();
            }
            wizardPresenterImpl.p.trackWizardParamsDrawError();
        } else {
            wizardPresenterImpl.p.startWizardParamsDraw();
            WizardView wizardView2 = wizardPresenterImpl.c;
            if (wizardView2 != null) {
                wizardView2.showError(wizardPresenterImpl.m.format(th));
            }
            wizardPresenterImpl.p.trackWizardParamsDrawError();
        }
    }

    public static final void access$handleSuccessLoad(WizardPresenterImpl wizardPresenterImpl, WizardParameter wizardParameter) {
        wizardPresenterImpl.f = wizardParameter;
        PublishViewModel publishViewModel = wizardPresenterImpl.h;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishState state = publishViewModel.getState();
        PublishViewModel publishViewModel2 = wizardPresenterImpl.h;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Navigation currentNavigationForStep = state.getCurrentNavigationForStep(publishViewModel2.getStepIndex());
        if (currentNavigationForStep != null) {
            WizardParameter wizardParameter2 = wizardPresenterImpl.f;
            WizardParameter findNodeByNavigation = wizardParameter2 != null ? wizardParameter2.findNodeByNavigation(currentNavigationForStep) : null;
            if (findNodeByNavigation != null) {
                wizardPresenterImpl.f = findNodeByNavigation;
            }
        }
        wizardPresenterImpl.e();
    }

    public static final void access$onItemClicked(WizardPresenterImpl wizardPresenterImpl, WizardItem wizardItem) {
        T t2;
        WizardParameter wizardParameter = wizardPresenterImpl.f;
        if (wizardParameter != null) {
            Iterator<T> it = wizardParameter.getChildren().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (Intrinsics.areEqual(t2.getNavigation(), wizardItem.getNavigation())) {
                    break;
                }
            }
            T t3 = t2;
            if (t3 != null) {
                wizardPresenterImpl.d(t3.getNavigation());
                if (!t3.getHasChildren()) {
                    WizardRouter wizardRouter = wizardPresenterImpl.d;
                    if (wizardRouter != null) {
                        wizardRouter.onParameterSelected(t3);
                        return;
                    }
                    return;
                }
                wizardPresenterImpl.f = t3;
                wizardPresenterImpl.e();
            }
        }
    }

    public final void a() {
        d(null);
        WizardRouter wizardRouter = this.d;
        if (wizardRouter != null) {
            wizardRouter.leaveWizard();
        }
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void attachPublishViewModel(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "viewModel");
        this.h = publishViewModel;
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void attachRouter(@NotNull WizardPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void attachView(@NotNull WizardView wizardView, int i2) {
        Intrinsics.checkNotNullParameter(wizardView, "view");
        this.c = wizardView;
        this.g = Integer.valueOf(i2);
        if (this.f == null) {
            c();
        } else {
            this.p.restartSession();
            e();
        }
        Sequence<WizardItemPresenter> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.t), WizardPresenterImpl$attachView$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        for (WizardItemPresenter wizardItemPresenter : filter) {
            DisposableKt.plusAssign(this.b, SubscribersKt.subscribeBy$default(wizardItemPresenter.getItemClickObservable(), b.a, (Function0) null, new Function1<WizardItem, Unit>(this) { // from class: com.avito.android.publish.wizard.WizardPresenterImpl.a
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(WizardItem wizardItem) {
                    WizardItem wizardItem2 = wizardItem;
                    Intrinsics.checkNotNullParameter(wizardItem2, "p1");
                    WizardPresenterImpl.access$onItemClicked((WizardPresenterImpl) this.receiver, wizardItem2);
                    return Unit.INSTANCE;
                }
            }, 2, (Object) null));
        }
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void attachWizardRouter(@Nullable WizardRouter wizardRouter) {
        this.d = wizardRouter;
    }

    public final boolean b(WizardParameter wizardParameter) {
        if (wizardParameter == null) {
            return true;
        }
        for (int i2 = this.r; i2 >= 0; i2--) {
            wizardParameter = wizardParameter.getParent();
            if (wizardParameter == null) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        this.p.restartSession();
        this.p.startWizardParamsLoading();
        WizardView wizardView = this.c;
        if (wizardView != null) {
            wizardView.showProgress();
        }
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = this.j.loadWizardParams().subscribeOn(this.l.io()).observeOn(this.l.mainThread()).subscribe(new c(this), new d(this));
    }

    public final void d(Navigation navigation) {
        PublishViewModel publishViewModel = this.h;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishState state = publishViewModel.getState();
        PublishViewModel publishViewModel2 = this.h;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        state.setCurrentNavigationForStep(publishViewModel2.getStepIndex(), navigation);
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void detachRouter() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
        this.e = null;
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void detachView() {
        this.b.clear();
        this.c = null;
        this.p.stop();
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public void detachWizardRouter() {
        this.d = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x003b */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.avito.android.remote.model.Navigation */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.avito.android.remote.model.Navigation */
    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: com.avito.android.remote.model.Navigation */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    public final void e() {
        WizardParameter wizardParameter;
        WizardParameter findNodeByNavigation;
        WizardParameter parent;
        WizardParameter wizardParameter2 = this.f;
        Navigation navigation = 0;
        if (wizardParameter2 != null) {
            PublishViewModel publishViewModel = this.h;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            PublishState.StepState stepState = publishViewModel.getState().getStepStates().get(Integer.valueOf(publishViewModel.getStepIndex()));
            if (!(stepState instanceof PublishState.StepState.Wizard)) {
                stepState = null;
            }
            PublishState.StepState.Wizard wizard = (PublishState.StepState.Wizard) stepState;
            if (wizard != null) {
                Navigation selectedNavigation = wizard.getSelectedNavigation();
                if (wizard.getCurrentNavigation() == null) {
                    navigation = selectedNavigation;
                }
            }
            if (navigation == 0) {
                navigation = this.s;
            }
            if (!(!(this.i == null || this.s == null) || navigation == 0 || Intrinsics.areEqual(navigation, wizardParameter2.getNavigation()) || (findNodeByNavigation = wizardParameter2.findNodeByNavigation(navigation)) == null || (parent = findNodeByNavigation.getParent()) == null)) {
                wizardParameter2 = parent;
            }
            this.f = wizardParameter2;
            d(wizardParameter2.getNavigation());
            navigation = wizardParameter2;
        }
        if (navigation != null) {
            List<WizardParameter> children = navigation.getChildren();
            if (navigation.getHasChildren()) {
                WizardView wizardView = this.c;
                if (wizardView != null) {
                    wizardView.showContent();
                }
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt__CollectionsKt.emptyList());
                for (T t2 : children) {
                    mutableList.add(new WizardItem(t2.getTitle(), t2.getDescription(), t2.getNavigation()));
                }
                this.k.onDataSourceChanged(new ListDataSource(mutableList));
                WizardView wizardView2 = this.c;
                if (wizardView2 != null) {
                    wizardView2.showParameters();
                }
                WizardView wizardView3 = this.c;
                if (wizardView3 != null) {
                    wizardView3.dataChanged();
                }
                WizardView wizardView4 = this.c;
                if (!(wizardView4 == null || (wizardParameter = this.f) == null)) {
                    wizardView4.setAppBarTitle(wizardParameter.getTitle());
                    int i2 = R.drawable.ic_back_24_black;
                    int i3 = R.drawable.ic_close_24_black;
                    if (!this.q && b(wizardParameter)) {
                        i2 = i3;
                    }
                    wizardView4.setUpIcon(i2);
                }
                Integer num = this.g;
                if (num != null) {
                    int intValue = num.intValue();
                    CompositeDisposable compositeDisposable = this.b;
                    PublishViewModel publishViewModel2 = this.h;
                    if (publishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                    }
                    Disposable subscribe = publishViewModel2.shouldShowDraftOnboardingForStep(intValue).subscribe(new e(this));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel\n       …howActionOnboarding(it) }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            } else if (navigation.getNavigation().isEmpty()) {
                this.o.track(new NonFatalError("Empty parameters response in wizard presenter", new RuntimeException(), null, 4, null));
                WizardView wizardView5 = this.c;
                if (wizardView5 != null) {
                    String string = this.n.getString(com.avito.android.publish.R.string.editing_is_unavailable);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.editing_is_unavailable)");
                    wizardView5.showError(string);
                }
                a();
            } else {
                WizardRouter wizardRouter = this.d;
                if (wizardRouter != null) {
                    wizardRouter.onParameterSelected(navigation);
                }
            }
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        WizardParameter parent;
        if (b(this.f)) {
            a();
            return true;
        }
        WizardParameter wizardParameter = this.f;
        if (wizardParameter == null || (parent = wizardParameter.getParent()) == null) {
            return true;
        }
        this.f = parent;
        d(parent.getNavigation());
        e();
        return true;
    }

    @Override // com.avito.android.publish.wizard.WizardView.Presenter
    public void onCloseClick() {
        WizardRouter wizardRouter = this.d;
        if (wizardRouter != null) {
            wizardRouter.leavePublish();
        }
    }

    @Override // com.avito.android.util.BundlePersistable
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f = (WizardParameter) bundle.getParcelable("key_current_section");
        }
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter
    public boolean onResult(int i2, int i3) {
        if (i2 != 0) {
            return false;
        }
        if (i3 != -1) {
            a();
        } else if (this.f == null) {
            c();
        } else {
            this.p.restartSession();
            e();
        }
        return true;
    }

    @Override // com.avito.android.publish.wizard.WizardView.Presenter
    public void onRetryClick() {
        c();
    }

    @Override // com.avito.android.util.BundlePersistable
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, VKApiConst.OUT);
        bundle.putParcelable("key_current_section", this.f);
    }

    @Override // com.avito.android.util.BundlePersistable
    @Nullable
    public Bundle onSaveState() {
        Bundle bundle = new Bundle(2);
        onSaveState(bundle);
        return bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardPresenterImpl(String str, WizardInteractor wizardInteractor, AdapterPresenter adapterPresenter, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter, Resources resources, Analytics analytics, CategoriesWizardTracker categoriesWizardTracker, boolean z, int i2, Navigation navigation, Set set, int i3, j jVar) {
        this(str, wizardInteractor, adapterPresenter, schedulersFactory, errorFormatter, resources, analytics, categoriesWizardTracker, (i3 & 256) != 0 ? false : z, (i3 & 512) != 0 ? 0 : i2, (i3 & 1024) != 0 ? null : navigation, set);
    }
}
