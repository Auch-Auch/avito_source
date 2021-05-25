package com.avito.android.publish.premoderation;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.util.Logs;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/publish/premoderation/PremoderationRequestViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/MultiStateLoading;", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "routingActions", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;)V", "onRetryClicked", "()V", "goNext", "goPrevious", "onCleared", "c", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "d", "Lcom/avito/android/publish/PublishViewModel;", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", g.a, "Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", "interactor", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PremoderationRequestViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public PublishViewModel d;
    public final MutableLiveData<MultiStateLoading<AdvertDuplicateResult>> e = new MutableLiveData<>();
    public final SingleLiveEvent<AdvertProactiveModerationResult> f = new SingleLiveEvent<>();
    public final AdvertProactiveModerationInteractor g;
    public final SchedulersFactory h;

    public static final class a<T> implements Consumer<AdvertProactiveModerationResult> {
        public final /* synthetic */ PremoderationRequestViewModel a;

        public a(PremoderationRequestViewModel premoderationRequestViewModel) {
            this.a = premoderationRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertProactiveModerationResult advertProactiveModerationResult) {
            AdvertProactiveModerationResult advertProactiveModerationResult2 = advertProactiveModerationResult;
            if (advertProactiveModerationResult2 instanceof AdvertProactiveModerationResult.Ok) {
                PublishViewModel.goToNextStep$default(PremoderationRequestViewModel.access$getPublishViewModel$p(this.a), null, 1, null);
            } else if (advertProactiveModerationResult2 instanceof AdvertProactiveModerationResult.Duplicate) {
                this.a.f.setValue(advertProactiveModerationResult2);
            } else if (advertProactiveModerationResult2 instanceof AdvertProactiveModerationResult.WrongCategory) {
                PremoderationRequestViewModel.access$onWrongCategoryResult(this.a, (AdvertProactiveModerationResult.WrongCategory) advertProactiveModerationResult2);
            }
            this.a.e.setValue(MultiStateLoading.LoadingComplete.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PremoderationRequestViewModel a;

        public b(PremoderationRequestViewModel premoderationRequestViewModel) {
            this.a = premoderationRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                TypedResultException typedResultException = (TypedResultException) th2;
                if (typedResultException.getErrorResult() instanceof ErrorResult.NetworkIOError) {
                    MutableLiveData mutableLiveData = this.a.e;
                    TypedError errorResult = typedResultException.getErrorResult();
                    Objects.requireNonNull(errorResult, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult.NetworkIOError");
                    mutableLiveData.setValue(new MultiStateLoading.InitError((ErrorResult.NetworkIOError) errorResult));
                    return;
                }
            }
            String access$getTAG$p = PremoderationRequestViewModelKt.access$getTAG$p();
            Logs.warning$default(access$getTAG$p, "Unable to checkAdvertProactiveModeration, skip with cause " + th2, null, 4, null);
            PublishViewModel.goToNextStep$default(PremoderationRequestViewModel.access$getPublishViewModel$p(this.a), null, 1, null);
        }
    }

    public PremoderationRequestViewModel(@NotNull AdvertProactiveModerationInteractor advertProactiveModerationInteractor, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(advertProactiveModerationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.g = advertProactiveModerationInteractor;
        this.h = schedulersFactory;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(PremoderationRequestViewModel premoderationRequestViewModel) {
        PublishViewModel publishViewModel = premoderationRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$onWrongCategoryResult(PremoderationRequestViewModel premoderationRequestViewModel, AdvertProactiveModerationResult.WrongCategory wrongCategory) {
        premoderationRequestViewModel.f.setValue(wrongCategory);
    }

    public final void c() {
        this.e.setValue(MultiStateLoading.InitLoading.INSTANCE);
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        if (categoryParameters == null) {
            PublishViewModel publishViewModel2 = this.d;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel2.handleErrorOrFail("Cannot perform premoderation checks. categoryParameters field has null value");
            return;
        }
        PublishViewModel publishViewModel3 = this.d;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Navigation navigation = publishViewModel3.getNavigation();
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.g.checkAdvertProactiveModeration(categoryParameters, navigation).observeOn(this.h.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.checkAdvertPr…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void goNext() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishViewModel.goToNextStep$default(publishViewModel, null, 1, null);
    }

    public final void goPrevious() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
        if (this.e.getValue() == null) {
            c();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
        super.onCleared();
    }

    public final void onRetryClicked() {
        c();
    }

    @NotNull
    public final LiveData<AdvertProactiveModerationResult> routingActions() {
        return this.f;
    }

    @NotNull
    public final LiveData<MultiStateLoading<AdvertDuplicateResult>> screenState() {
        return this.e;
    }
}
