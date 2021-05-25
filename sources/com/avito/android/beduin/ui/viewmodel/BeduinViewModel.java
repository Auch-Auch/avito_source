package com.avito.android.beduin.ui.viewmodel;

import a2.a.a.s.a.b.e;
import a2.a.a.s.a.b.f;
import a2.g.r.g;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.beduin.action.BeduinExecuteRequestAction;
import com.avito.android.beduin.common.BeduinInteractor;
import com.avito.android.beduin.common.actionhandler.BeduinActionHandlerWrapper;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.form.ComponentsFormTransform;
import com.avito.android.beduin.core.form.ComponentsFormUpdate;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import com.avito.android.beduin.model.BeduinComponentsResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002PQB=\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010J\u001a\u00020E\u0012\u0006\u00104\u001a\u00020/¢\u0006\u0004\bN\u0010OJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR:\u0010\u0017\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010\u0012\u0004\u0012\u00020\u00140\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R=\u0010#\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010\u0012\u0004\u0012\u00020\u00140\u000f0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010\"R\u0019\u00104\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R%\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000206050\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010 \u001a\u0004\b8\u0010\"R\"\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000206050:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R(\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0019\u0010J\u001a\u00020E8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006R"}, d2 = {"Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "Landroidx/lifecycle/ViewModel;", "", "fetchData", "()V", "onCleared", "Lcom/avito/android/util/LoadingState$Error;", "result", "c", "(Lcom/avito/android/util/LoadingState$Error;)V", "Lcom/avito/android/beduin/common/BeduinInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/beduin/common/BeduinInteractor;", "interactor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lkotlin/Pair;", "", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Landroid/view/View;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "formUpdatesLiveData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel$BeduinEvent;", "e", "actionLiveData", "Landroidx/lifecycle/LiveData;", "i", "Landroidx/lifecycle/LiveData;", "getFormUpdates", "()Landroidx/lifecycle/LiveData;", "formUpdates", "Lcom/avito/android/beduin/common/actionhandler/BeduinActionHandlerWrapper;", "j", "Lcom/avito/android/beduin/common/actionhandler/BeduinActionHandlerWrapper;", "actionHandlerWrapper", "", "n", "Ljava/lang/String;", "url", "h", "getEvents", "events", "Lcom/avito/android/beduin/core/ComponentsContext;", "p", "Lcom/avito/android/beduin/core/ComponentsContext;", "getComponentsContext", "()Lcom/avito/android/beduin/core/ComponentsContext;", "componentsContext", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel$BeduinScreen;", g.a, "getScreenStateChanges", "screenStateChanges", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "screenStateLiveData", "k", "Ljava/util/List;", "components", "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "l", "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "registry", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "o", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "getComponentsForm", "()Lcom/avito/android/beduin/core/form/ComponentsForm;", "componentsForm", "", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandlers", "<init>", "(Lcom/avito/android/beduin/core/registry/BeduinRegistry;Lcom/avito/android/beduin/common/BeduinInteractor;Ljava/util/Set;Ljava/lang/String;Lcom/avito/android/beduin/core/form/ComponentsForm;Lcom/avito/android/beduin/core/ComponentsContext;)V", "BeduinEvent", "BeduinScreen", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<LoadingState<BeduinScreen>> d;
    public final SingleLiveEvent<BeduinEvent> e;
    public final SingleLiveEvent<Pair<List<BeduinComponent<BeduinModel, View>>, ComponentsFormUpdate>> f;
    @NotNull
    public final LiveData<LoadingState<BeduinScreen>> g;
    @NotNull
    public final LiveData<BeduinEvent> h;
    @NotNull
    public final LiveData<Pair<List<BeduinComponent<BeduinModel, View>>, ComponentsFormUpdate>> i;
    public final BeduinActionHandlerWrapper j;
    public List<? extends BeduinComponent<BeduinModel, View>> k;
    public final BeduinRegistry l;
    public final BeduinInteractor m;
    public final String n;
    @NotNull
    public final ComponentsForm o;
    @NotNull
    public final ComponentsContext p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel$BeduinEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UpdateApp", "GeneralError", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public enum BeduinEvent {
        UpdateApp,
        GeneralError
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel$BeduinScreen;", "", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel$BeduinScreen;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class BeduinScreen {
        @Nullable
        public final String a;

        public BeduinScreen(@Nullable String str) {
            this.a = str;
        }

        public static /* synthetic */ BeduinScreen copy$default(BeduinScreen beduinScreen, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = beduinScreen.a;
            }
            return beduinScreen.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final BeduinScreen copy(@Nullable String str) {
            return new BeduinScreen(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof BeduinScreen) && Intrinsics.areEqual(this.a, ((BeduinScreen) obj).a);
            }
            return true;
        }

        @Nullable
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a2.b.a.a.a.t(a2.b.a.a.a.L("BeduinScreen(title="), this.a, ")");
        }
    }

    public static final class a extends Lambda implements Function1<BeduinAction, Unit> {
        public final /* synthetic */ BeduinViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BeduinViewModel beduinViewModel) {
            super(1);
            this.a = beduinViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BeduinAction beduinAction) {
            BeduinAction beduinAction2 = beduinAction;
            Intrinsics.checkNotNullParameter(beduinAction2, "it");
            BeduinViewModel.access$handleUnhandledAction(this.a, beduinAction2);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<TypedResult<BeduinComponentsResponse>, LoadingState<? super BeduinComponentsResponse>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BeduinComponentsResponse> apply(TypedResult<BeduinComponentsResponse> typedResult) {
            TypedResult<BeduinComponentsResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super BeduinComponentsResponse>> {
        public final /* synthetic */ BeduinViewModel a;

        public c(BeduinViewModel beduinViewModel) {
            this.a = beduinViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super BeduinComponentsResponse> loadingState) {
            LoadingState<? super BeduinComponentsResponse> loadingState2 = loadingState;
            BeduinViewModel beduinViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            BeduinViewModel.access$handleFetchDataResult(beduinViewModel, loadingState2);
        }
    }

    public BeduinViewModel(@NotNull BeduinRegistry beduinRegistry, @NotNull BeduinInteractor beduinInteractor, @NotNull Set<? extends BeduinActionHandler> set, @NotNull String str, @NotNull ComponentsForm componentsForm, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(beduinRegistry, "registry");
        Intrinsics.checkNotNullParameter(beduinInteractor, "interactor");
        Intrinsics.checkNotNullParameter(set, "actionHandlers");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(componentsForm, "componentsForm");
        Intrinsics.checkNotNullParameter(componentsContext, "componentsContext");
        this.l = beduinRegistry;
        this.m = beduinInteractor;
        this.n = str;
        this.o = componentsForm;
        this.p = componentsContext;
        MutableLiveData<LoadingState<BeduinScreen>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        SingleLiveEvent<BeduinEvent> singleLiveEvent = new SingleLiveEvent<>();
        this.e = singleLiveEvent;
        SingleLiveEvent<Pair<List<BeduinComponent<BeduinModel, View>>, ComponentsFormUpdate>> singleLiveEvent2 = new SingleLiveEvent<>();
        this.f = singleLiveEvent2;
        this.g = mutableLiveData;
        this.h = singleLiveEvent;
        this.i = singleLiveEvent2;
        this.j = new BeduinActionHandlerWrapper(set, new a(this));
        this.k = CollectionsKt__CollectionsKt.emptyList();
        componentsForm.setOnFormUpdate(new a2.a.a.s.a.b.g(this));
        fetchData();
    }

    public static final void access$handleFetchDataResult(BeduinViewModel beduinViewModel, LoadingState loadingState) {
        Objects.requireNonNull(beduinViewModel);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            beduinViewModel.d.setValue(new LoadingState.Loaded(new BeduinScreen(((BeduinComponentsResponse) loaded.getData()).getTitle())));
            beduinViewModel.o.apply(new ComponentsFormTransform.Set(((BeduinComponentsResponse) loaded.getData()).getComponents()));
            return;
        }
        LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
        if (Intrinsics.areEqual(loadingState, loading)) {
            beduinViewModel.d.setValue(loading);
        } else if (loadingState instanceof LoadingState.Error) {
            beduinViewModel.c((LoadingState.Error) loadingState);
            beduinViewModel.d.setValue(loadingState);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$handleUnhandledAction(BeduinViewModel beduinViewModel, BeduinAction beduinAction) {
        Objects.requireNonNull(beduinViewModel);
        if (beduinAction instanceof BeduinExecuteRequestAction) {
            BeduinExecuteRequestAction beduinExecuteRequestAction = (BeduinExecuteRequestAction) beduinAction;
            a2.a.a.s.a.b.a aVar = new a2.a.a.s.a.b.a(beduinViewModel);
            a2.a.a.s.a.b.b bVar = new a2.a.a.s.a.b.b(beduinViewModel);
            MutableLiveData<LoadingState<BeduinScreen>> mutableLiveData = beduinViewModel.d;
            LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
            mutableLiveData.setValue(loading);
            Disposable subscribe = beduinViewModel.m.executeRequest(beduinExecuteRequestAction.getPath(), beduinExecuteRequestAction.getMethod(), beduinExecuteRequestAction.getParameters()).map(a2.a.a.s.a.b.c.a).toObservable().startWithItem(loading).subscribe(new a2.a.a.s.a.b.d(beduinViewModel, bVar, aVar), new e(aVar));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.executeReques…          }\n            )");
            DisposableKt.addTo(subscribe, beduinViewModel.c);
            return;
        }
        beduinViewModel.e.setValue(BeduinEvent.UpdateApp);
    }

    public final void c(LoadingState.Error error) {
        if (error.getError() instanceof ErrorResult.UnknownError) {
            TypedError error2 = error.getError();
            Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult.UnknownError");
            Logs.error(((ErrorResult.UnknownError) error2).getDebugThrowable());
            return;
        }
        Logs.error$default(error.getError().toString(), null, 2, null);
    }

    public final void fetchData() {
        Disposable subscribe = this.m.fetchData(this.n).map(b.a).toObservable().startWithItem((R) LoadingState.Loading.INSTANCE).subscribe(new c(this), new f(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.beduin.ui.viewmodel.BeduinViewModel.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.fetchData(url…esult(it) }, Logs::error)");
        DisposableKt.addTo(subscribe, this.c);
    }

    @NotNull
    public final ComponentsContext getComponentsContext() {
        return this.p;
    }

    @NotNull
    public final ComponentsForm getComponentsForm() {
        return this.o;
    }

    @NotNull
    public final LiveData<BeduinEvent> getEvents() {
        return this.h;
    }

    @NotNull
    public final LiveData<Pair<List<BeduinComponent<BeduinModel, View>>, ComponentsFormUpdate>> getFormUpdates() {
        return this.i;
    }

    @NotNull
    public final LiveData<LoadingState<BeduinScreen>> getScreenStateChanges() {
        return this.g;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }
}
