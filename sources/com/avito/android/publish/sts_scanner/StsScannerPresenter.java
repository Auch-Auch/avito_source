package com.avito.android.publish.sts_scanner;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.sts_recognition.StsRecognitionResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b8\u00109J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0016\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\rR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;", "Lcom/avito/android/publish/sts_scanner/StsScannerView;", "view", "", "attachView", "(Lcom/avito/android/publish/sts_scanner/StsScannerView;)V", "Lcom/avito/android/publish/sts_scanner/StsScannerRouter;", "router", "attachRouter", "(Lcom/avito/android/publish/sts_scanner/StsScannerRouter;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "uris", "onNewPhotos", "(Ljava/util/List;)V", "Landroid/net/Uri;", "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "source", "(Ljava/util/List;Lcom/avito/android/photo_picker/legacy/PhotoSource;)V", "retryStsScan", "cancelScanning", "Lcom/avito/android/publish/PublishParametersInteractor;", "e", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/sts_scanner/StsScannerView;", "d", "Lcom/avito/android/publish/PublishViewModel;", "c", "Lcom/avito/android/publish/sts_scanner/StsScannerRouter;", "Lcom/avito/android/util/SchedulersFactory;", a2.g.r.g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "f", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "", "h", "I", "stepIndex", "<init>", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/util/SchedulersFactory;I)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StsScannerPresenter implements CameraItemPresenter.Listener, StsRecognitionErrorDialogListener {
    public final CompositeDisposable a = new CompositeDisposable();
    public StsScannerView b;
    public StsScannerRouter c;
    public PublishViewModel d;
    public final PublishParametersInteractor e;
    public final PublishEventTracker f;
    public final SchedulersFactory g;
    public final int h;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<LoadingState.Loaded<StsRecognitionResult>> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(LoadingState.Loaded<StsRecognitionResult> loaded) {
            int i = this.a;
            if (i == 0) {
                LoadingState.Loaded<StsRecognitionResult> loaded2 = loaded;
                Intrinsics.checkNotNullParameter(loaded2, "it");
                return loaded2.getData() instanceof StsRecognitionResult.NotFound;
            } else if (i == 1) {
                LoadingState.Loaded<StsRecognitionResult> loaded3 = loaded;
                Intrinsics.checkNotNullParameter(loaded3, "it");
                return loaded3.getData() instanceof StsRecognitionResult.Ok;
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
                Logs.error("Failed on observe stsRecognitionData", th);
            } else if (i == 1) {
                Logs.error("Failed on observe stsRecognize", th);
            } else if (i == 2) {
                Logs.error("Failed on observe stsRecognize", th);
            } else if (i == 3) {
                Logs.error("Failed on observe stsRecognitionData", th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Predicate<LoadingState<? super StsRecognitionResult>> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public static final c d = new c(2);
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(LoadingState<? super StsRecognitionResult> loadingState) {
            int i = this.a;
            if (i == 0) {
                LoadingState<? super StsRecognitionResult> loadingState2 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState2, "it");
                return loadingState2 instanceof LoadingState.Error;
            } else if (i == 1) {
                LoadingState<? super StsRecognitionResult> loadingState3 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState3, "it");
                return loadingState3 instanceof LoadingState.Loading;
            } else if (i == 2) {
                LoadingState<? super StsRecognitionResult> loadingState4 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState4, "it");
                return loadingState4 instanceof LoadingState.Loaded;
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ StsScannerPresenter a;

        public d(StsScannerPresenter stsScannerPresenter) {
            this.a = stsScannerPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            StsScannerRouter stsScannerRouter = this.a.c;
            if (stsScannerRouter != null) {
                stsScannerRouter.backFromStsScanner();
            }
        }
    }

    public static final class e<T, R> implements Function<LoadingState<? super StsRecognitionResult>, LoadingState.Error> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState.Error apply(LoadingState<? super StsRecognitionResult> loadingState) {
            LoadingState<? super StsRecognitionResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return (LoadingState.Error) loadingState2;
        }
    }

    public static final class f<T> implements Consumer<LoadingState.Error> {
        public final /* synthetic */ StsScannerPresenter a;

        public f(StsScannerPresenter stsScannerPresenter) {
            this.a = stsScannerPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState.Error error) {
            StsScannerPresenter.access$handleErrors(this.a, error.getError());
        }
    }

    public static final class g<T> implements Consumer<LoadingState<? super StsRecognitionResult>> {
        public final /* synthetic */ StsScannerPresenter a;

        public g(StsScannerPresenter stsScannerPresenter) {
            this.a = stsScannerPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super StsRecognitionResult> loadingState) {
            StsScannerView stsScannerView = this.a.b;
            if (stsScannerView != null) {
                stsScannerView.showLoadingProgress();
            }
        }
    }

    public static final class h<T> implements Consumer<LoadingState.Loaded<StsRecognitionResult>> {
        public final /* synthetic */ StsScannerPresenter a;

        public h(StsScannerPresenter stsScannerPresenter) {
            this.a = stsScannerPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState.Loaded<StsRecognitionResult> loaded) {
            StsScannerRouter stsScannerRouter = this.a.c;
            if (stsScannerRouter != null) {
                stsScannerRouter.showStsRecognitionErrorDialog();
            }
        }
    }

    public static final class i<T, R> implements Function<LoadingState.Loaded<StsRecognitionResult>, CategoryParameters> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CategoryParameters apply(LoadingState.Loaded<StsRecognitionResult> loaded) {
            LoadingState.Loaded<StsRecognitionResult> loaded2 = loaded;
            Intrinsics.checkNotNullParameter(loaded2, "it");
            StsRecognitionResult data = loaded2.getData();
            Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.sts_recognition.StsRecognitionResult.Ok");
            return ((StsRecognitionResult.Ok) data).getPublishParams();
        }
    }

    public static final class j<T> implements Consumer<CategoryParameters> {
        public final /* synthetic */ StsScannerPresenter a;

        public j(StsScannerPresenter stsScannerPresenter) {
            this.a = stsScannerPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CategoryParameters categoryParameters) {
            CategoryParameters cloneWithNewParameters;
            CategoryParameters categoryParameters2 = categoryParameters;
            this.a.f.trackStsScanResultReceived();
            CategoryParameters categoryParameters3 = StsScannerPresenter.access$getPublishViewModel$p(this.a).getCategoryParameters();
            if (!(categoryParameters3 == null || (cloneWithNewParameters = categoryParameters3.cloneWithNewParameters(categoryParameters2.getParameters(), categoryParameters2.getChangedIds())) == null)) {
                StsScannerPresenter.access$getPublishViewModel$p(this.a).setCategoryParametersAndInitSteps(cloneWithNewParameters);
            }
            StsScannerPresenter.access$setRecognizedVin(this.a);
            StsScannerRouter stsScannerRouter = this.a.c;
            if (stsScannerRouter != null) {
                stsScannerRouter.popStsScannerFromBackstack();
            }
            PublishViewModel.goToNextStep$default(StsScannerPresenter.access$getPublishViewModel$p(this.a), null, 1, null);
        }
    }

    public static final class k<T, R> implements Function<LoadingState<? super StsRecognitionResult>, LoadingState.Loaded<StsRecognitionResult>> {
        public static final k a = new k();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState.Loaded<StsRecognitionResult> apply(LoadingState<? super StsRecognitionResult> loadingState) {
            LoadingState<? super StsRecognitionResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return (LoadingState.Loaded) loadingState2;
        }
    }

    public StsScannerPresenter(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull PublishEventTracker publishEventTracker, @NotNull SchedulersFactory schedulersFactory, int i2) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.e = publishParametersInteractor;
        this.f = publishEventTracker;
        this.g = schedulersFactory;
        this.h = i2;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(StsScannerPresenter stsScannerPresenter) {
        PublishViewModel publishViewModel = stsScannerPresenter.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$handleErrors(StsScannerPresenter stsScannerPresenter, TypedError typedError) {
        StsScannerView stsScannerView;
        StsScannerView stsScannerView2 = stsScannerPresenter.b;
        if (stsScannerView2 != null) {
            stsScannerView2.showContent();
        }
        if ((typedError instanceof ErrorResult) && (stsScannerView = stsScannerPresenter.b) != null) {
            stsScannerView.showMessage(((ErrorResult) typedError).getMessage());
        }
    }

    public static final void access$setRecognizedVin(StsScannerPresenter stsScannerPresenter) {
        PublishState.StepState stepState;
        PublishViewModel publishViewModel = stsScannerPresenter.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(publishViewModel.getParamsForStep(stsScannerPresenter.h));
        if (!(firstOrNull instanceof CharParameter)) {
            firstOrNull = null;
        }
        CharParameter charParameter = (CharParameter) firstOrNull;
        if (charParameter != null) {
            PublishViewModel publishViewModel2 = stsScannerPresenter.d;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            PublishState state = publishViewModel2.getState();
            int i2 = stsScannerPresenter.h;
            Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(i2));
            if (!(parcelable instanceof PublishState.StepState.Vin)) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                    stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                    stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                    stepState = new PublishState.StepState.Vin(null, 1, null);
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                    L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class));
                    L.append('\'');
                    throw new IllegalArgumentException(L.toString());
                }
                state.getStepStates().put(Integer.valueOf(i2), stepState);
                parcelable = (PublishState.StepState.Vin) stepState;
            }
            ((PublishState.StepState.Vin) parcelable).setRecognizedVin((String) charParameter.getValue());
        }
    }

    public final void attachRouter(@NotNull StsScannerRouter stsScannerRouter) {
        Intrinsics.checkNotNullParameter(stsScannerRouter, "router");
        this.c = stsScannerRouter;
    }

    public final void attachView(@NotNull StsScannerView stsScannerView) {
        Intrinsics.checkNotNullParameter(stsScannerView, "view");
        this.b = stsScannerView;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = stsScannerView.getCloseClicks().observeOn(this.g.mainThread()).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.closeClicks\n       …tsScanner()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish.sts_scanner.StsRecognitionErrorDialogListener
    public void cancelScanning() {
        StsScannerView stsScannerView = this.b;
        if (stsScannerView != null) {
            stsScannerView.showContent();
        }
        StsScannerRouter stsScannerRouter = this.c;
        if (stsScannerRouter != null) {
            stsScannerRouter.backFromStsScanner();
        }
    }

    public final void detachRouter() {
        this.c = null;
    }

    public final void detachView() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Listener
    public void onNewPhotos(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "uris");
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Listener
    public void onNewPhotos(@NotNull List<? extends Uri> list, @NotNull PhotoSource photoSource) {
        Intrinsics.checkNotNullParameter(list, "uris");
        Intrinsics.checkNotNullParameter(photoSource, "source");
        Uri uri = (Uri) CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        PublishParametersInteractor publishParametersInteractor = this.e;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Navigation navigation = publishViewModel.getNavigation();
        PublishViewModel publishViewModel2 = this.d;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel2.getCategoryParameters();
        Intrinsics.checkNotNull(categoryParameters);
        ConnectableObservable<LoadingState<StsRecognitionResult>> publish = publishParametersInteractor.loadAutoParamsByStsImage(uri, navigation, categoryParameters).subscribeOn(this.g.io()).publish();
        Observable<R> map = publish.filter(c.d).map(k.a);
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = publish.filter(c.c).observeOn(this.g.mainThread()).subscribe(new g(this), b.d);
        Intrinsics.checkNotNullExpressionValue(subscribe, "stsRecognize.filter { it…ize\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = map.filter(a.b).observeOn(this.g.mainThread()).subscribe(new h(this), b.e);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "stsRecognitionData\n     …ata\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe3 = map.filter(a.c).map(i.a).observeOn(this.g.mainThread()).subscribe(new j(this), b.b);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "stsRecognitionData\n     …ata\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe4 = publish.filter(c.b).map(e.a).observeOn(this.g.mainThread()).subscribe(new f(this), b.c);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "stsRecognize.filter { it…ize\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "stsRecognize.connect()");
        DisposableKt.plusAssign(compositeDisposable5, connect);
    }

    @Override // com.avito.android.publish.sts_scanner.StsRecognitionErrorDialogListener
    public void retryStsScan() {
        StsScannerView stsScannerView = this.b;
        if (stsScannerView != null) {
            stsScannerView.showContent();
        }
    }

    public final void setPublishViewModel(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
    }
}
