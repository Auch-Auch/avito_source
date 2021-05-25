package com.avito.android.hints.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.hints.remote.model.HintsResult;
import com.avito.android.hints.repository.HintsConverter;
import com.avito.android.hints.repository.HintsRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.bottom_sheet.BottomSheet;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b5\u00106J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR(\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u000fR\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR&\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010&¨\u00067"}, d2 = {"Lcom/avito/android/hints/viewmodel/HintViewModelImpl;", "Lcom/avito/android/hints/viewmodel/HintViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "Lio/reactivex/Observable;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "visibilityObservable", "observeVisibilityChanges", "(Lio/reactivex/Observable;)V", "onRetryClicked", "c", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "closeEventsLiveData", "Lcom/avito/android/util/LoadingState;", "e", "progressChangesLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/conveyor_item/Item;", "h", "Landroidx/lifecycle/LiveData;", "getDataChanges", "()Landroidx/lifecycle/LiveData;", "dataChanges", "Lcom/avito/android/hints/repository/HintsConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/hints/repository/HintsConverter;", "converter", "", "k", "Ljava/lang/String;", "hintType", "Lio/reactivex/disposables/Disposable;", g.a, "Lio/reactivex/disposables/Disposable;", "uiSubscription", "d", "dataChangesLiveData", "j", "getCloseEvents", "closeEvents", "i", "getProgressChanges", "progressChanges", "Lcom/avito/android/hints/repository/HintsRepository;", "l", "Lcom/avito/android/hints/repository/HintsRepository;", "repository", "subscription", "<init>", "(Ljava/lang/String;Lcom/avito/android/hints/repository/HintsRepository;Lcom/avito/android/hints/repository/HintsConverter;)V", "hints_release"}, k = 1, mv = {1, 4, 2})
public final class HintViewModelImpl extends ViewModel implements HintViewModel {
    public Disposable c;
    public final MutableLiveData<List<Item>> d;
    public final MutableLiveData<LoadingState<?>> e;
    public final MutableLiveData<Unit> f;
    public Disposable g;
    @NotNull
    public final LiveData<List<Item>> h;
    @NotNull
    public final LiveData<LoadingState<?>> i;
    @NotNull
    public final LiveData<Unit> j;
    public final String k;
    public final HintsRepository l;
    public final HintsConverter m;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<LoadingState<? super HintsResult>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(LoadingState<? super HintsResult> loadingState) {
            int i = this.a;
            if (i == 0) {
                ((HintViewModelImpl) this.b).e.postValue(loadingState);
            } else if (i == 1) {
                LoadingState<? super HintsResult> loadingState2 = loadingState;
                if (loadingState2 instanceof LoadingState.Loaded) {
                    ((HintViewModelImpl) this.b).d.postValue(((HintViewModelImpl) this.b).m.convert((HintsResult) ((LoadingState.Loaded) loadingState2).getData()));
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class c<T> implements Predicate<BottomSheet.Visibility> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(BottomSheet.Visibility visibility) {
            BottomSheet.Visibility visibility2 = visibility;
            Intrinsics.checkNotNullParameter(visibility2, "it");
            return visibility2 instanceof BottomSheet.Visibility.Closed;
        }
    }

    public static final class d<T> implements Consumer<BottomSheet.Visibility> {
        public final /* synthetic */ HintViewModelImpl a;

        public d(HintViewModelImpl hintViewModelImpl) {
            this.a = hintViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(BottomSheet.Visibility visibility) {
            this.a.f.postValue(Unit.INSTANCE);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public HintViewModelImpl(@NotNull String str, @NotNull HintsRepository hintsRepository, @NotNull HintsConverter hintsConverter) {
        Intrinsics.checkNotNullParameter(str, "hintType");
        Intrinsics.checkNotNullParameter(hintsRepository, "repository");
        Intrinsics.checkNotNullParameter(hintsConverter, "converter");
        this.k = str;
        this.l = hintsRepository;
        this.m = hintsConverter;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<LoadingState<?>> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<Unit> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.g = empty2;
        c();
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        this.j = mutableLiveData3;
    }

    public final void c() {
        this.c.dispose();
        Disposable subscribe = this.l.getHints(this.k).doOnNext(new a(0, this)).subscribe(new a(1, this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getHints(hint…     }, { Timber.e(it) })");
        this.c = subscribe;
    }

    @Override // com.avito.android.hints.viewmodel.HintViewModel
    @NotNull
    public LiveData<Unit> getCloseEvents() {
        return this.j;
    }

    @Override // com.avito.android.hints.viewmodel.HintViewModel
    @NotNull
    public LiveData<List<Item>> getDataChanges() {
        return this.h;
    }

    @Override // com.avito.android.hints.viewmodel.HintViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.i;
    }

    @Override // com.avito.android.hints.viewmodel.HintViewModel
    public void observeVisibilityChanges(@NotNull Observable<BottomSheet.Visibility> observable) {
        Intrinsics.checkNotNullParameter(observable, "visibilityObservable");
        this.g.dispose();
        Disposable subscribe = observable.filter(c.a).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "visibilityObservable\n   …     }, { Timber.e(it) })");
        this.g = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.dispose();
        this.g.dispose();
    }

    @Override // com.avito.android.hints.viewmodel.HintViewModel
    public void onRetryClicked() {
        c();
    }
}
