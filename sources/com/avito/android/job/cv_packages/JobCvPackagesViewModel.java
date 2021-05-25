package com.avito.android.job.cv_packages;

import a2.a.a.j1.a.e;
import a2.a.a.j1.a.f;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.job.cv_packages.Action;
import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import com.avito.android.job.cv_packages.State;
import com.avito.android.job.cv_packages.di.ResumeIdQualifier;
import com.avito.android.job.cv_packages.item.PackageItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fRG\u0010\u0019\u001a0\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012 \u0013*\u0017\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u0011¢\u0006\u0002\b\u00140\u0011¢\u0006\u0002\b\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "c", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/job/cv_packages/State;", "e", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "state", "Lcom/avito/android/job/cv_packages/CvPackagesNavigator;", "i", "Lcom/avito/android/job/cv_packages/CvPackagesNavigator;", "navigator", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/job/cv_packages/Action;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getActions", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "actions", "", "j", "Ljava/lang/String;", "resumeId", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/job/cv_packages/CvPackagesInteractor;", "h", "Lcom/avito/android/job/cv_packages/CvPackagesInteractor;", "cvPackagesInteractor", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "_state", "Factory", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class JobCvPackagesViewModel extends ViewModel {
    public final CompositeDisposable c;
    public final MutableLiveData<State> d;
    @NotNull
    public final LiveData<State> e;
    public final PublishRelay<Action> f;
    public final SchedulersFactory3 g;
    public final CvPackagesInteractor h;
    public final CvPackagesNavigator i;
    public final String j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/job/cv_packages/CvPackagesInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/cv_packages/CvPackagesInteractor;", "cvPackagesInteractor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "", "d", "Ljava/lang/String;", "resumeId", "Lcom/avito/android/job/cv_packages/CvPackagesNavigator;", "c", "Lcom/avito/android/job/cv_packages/CvPackagesNavigator;", "navigator", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/job/cv_packages/CvPackagesInteractor;Lcom/avito/android/job/cv_packages/CvPackagesNavigator;Ljava/lang/String;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory implements ViewModelProvider.Factory {
        public final SchedulersFactory3 a;
        public final CvPackagesInteractor b;
        public final CvPackagesNavigator c;
        public final String d;

        @Inject
        public Factory(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull CvPackagesInteractor cvPackagesInteractor, @NotNull CvPackagesNavigator cvPackagesNavigator, @ResumeIdQualifier @NotNull String str) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
            Intrinsics.checkNotNullParameter(cvPackagesInteractor, "cvPackagesInteractor");
            Intrinsics.checkNotNullParameter(cvPackagesNavigator, "navigator");
            Intrinsics.checkNotNullParameter(str, "resumeId");
            this.a = schedulersFactory3;
            this.b = cvPackagesInteractor;
            this.c = cvPackagesNavigator;
            this.d = str;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            if (cls.isAssignableFrom(JobCvPackagesViewModel.class)) {
                return new JobCvPackagesViewModel(this.a, this.b, this.c, this.d, null);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ JobCvPackagesViewModel a;

        public b(JobCvPackagesViewModel jobCvPackagesViewModel) {
            this.a = jobCvPackagesViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d.postValue(State.Loading.INSTANCE);
        }
    }

    public JobCvPackagesViewModel(SchedulersFactory3 schedulersFactory3, CvPackagesInteractor cvPackagesInteractor, CvPackagesNavigator cvPackagesNavigator, String str, j jVar) {
        this.g = schedulersFactory3;
        this.h = cvPackagesInteractor;
        this.i = cvPackagesNavigator;
        this.j = str;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        this.e = mutableLiveData;
        PublishRelay<Action> create = PublishRelay.create();
        this.f = create;
        c();
        Disposable subscribe = create.subscribe(new e(new Function1<Action, Unit>(this) { // from class: a2.a.a.j1.a.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Action action) {
                Action action2 = action;
                Intrinsics.checkNotNullParameter(action2, "p1");
                JobCvPackagesViewModel.access$handleAction((JobCvPackagesViewModel) this.receiver, action2);
                return Unit.INSTANCE;
            }
        }), new e(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.j1.a.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "actions\n            .sub…andleAction, Logs::error)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleAction(JobCvPackagesViewModel jobCvPackagesViewModel, Action action) {
        Objects.requireNonNull(jobCvPackagesViewModel);
        if (Intrinsics.areEqual(action, Action.Refresh.INSTANCE)) {
            jobCvPackagesViewModel.c();
        } else if (Intrinsics.areEqual(action, Action.Exit.INSTANCE)) {
            jobCvPackagesViewModel.i.exit();
        } else if (action instanceof Action.PackageClicked) {
            jobCvPackagesViewModel.i.open(((Action.PackageClicked) action).getLink());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final State access$responseToState(JobCvPackagesViewModel jobCvPackagesViewModel, TypedResult typedResult) {
        Objects.requireNonNull(jobCvPackagesViewModel);
        if (typedResult instanceof TypedResult.OfResult) {
            TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult;
            String title = ((CvPackagesResponse) ofResult.getResult()).getTitle();
            String subtitle = ((CvPackagesResponse) ofResult.getResult()).getSubtitle();
            List<Package> packages = ((CvPackagesResponse) ofResult.getResult()).getPackages();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(packages, 10));
            for (T t : packages) {
                arrayList.add(new PackageItem(t.getDeeplink().getPath(), t));
            }
            return new State.Content(title, subtitle, arrayList);
        } else if (typedResult instanceof TypedResult.OfError) {
            return State.Error.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.h.requestPackagesInfo(this.j).subscribeOn(this.g.io()).map(new f(new Function1<TypedResult<CvPackagesResponse>, State>(this) { // from class: com.avito.android.job.cv_packages.JobCvPackagesViewModel.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public State invoke(TypedResult<CvPackagesResponse> typedResult) {
                TypedResult<CvPackagesResponse> typedResult2 = typedResult;
                Intrinsics.checkNotNullParameter(typedResult2, "p1");
                return JobCvPackagesViewModel.access$responseToState((JobCvPackagesViewModel) this.receiver, typedResult2);
            }
        })).observeOn(this.g.mainThread()).doOnSubscribe(new b(this)).subscribe(new e(new Function1<State, Unit>(this.d) { // from class: com.avito.android.job.cv_packages.JobCvPackagesViewModel.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(State state) {
                ((MutableLiveData) this.receiver).postValue(state);
                return Unit.INSTANCE;
            }
        }), new e(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.job.cv_packages.JobCvPackagesViewModel.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "cvPackagesInteractor.req…::postValue, Logs::error)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final PublishRelay<Action> getActions() {
        return this.f;
    }

    @NotNull
    public final LiveData<State> getState() {
        return this.e;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }
}
