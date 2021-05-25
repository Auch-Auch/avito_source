package com.avito.android.tariff.change.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.change.TariffChangeResult;
import com.avito.android.tariff.change.page.TariffTab;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00108\u001a\u00020\u000b¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J!\u0010\u0011\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001cR\"\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0'8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R&\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R$\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010-R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModelImpl;", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "onRetryButtonClick", "", VKApiConst.POSITION, "onPageSelected", "(I)V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "loadData", "", "Lcom/avito/android/tariff/change/page/TariffTab;", "c", "(Ljava/util/List;I)V", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "d", "I", "selectedPageIndex", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "f", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;", "j", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;", "repository", g.a, "tabsListChangesLiveData", "Lcom/avito/android/remote/model/Action;", "e", "buttonChangesLiveData", "Landroidx/lifecycle/LiveData;", "getTabsListChanges", "()Landroidx/lifecycle/LiveData;", "tabsListChanges", "h", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "i", "getButtonChanges", "buttonChanges", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;", "k", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;", "converter", "<init>", "(Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeViewModelImpl extends ViewModel implements TariffChangeViewModel {
    public Disposable c;
    public int d = -1;
    public final MutableLiveData<Action> e;
    public final MutableLiveData<LoadingState<?>> f;
    public final MutableLiveData<List<TariffTab>> g;
    @NotNull
    public final MutableLiveData<LoadingState<?>> h;
    @NotNull
    public final MutableLiveData<Action> i;
    public final TariffChangeRepository j;
    public final TariffChangeConverter k;
    public final SchedulersFactory l;
    public final Kundle m;

    public static final class a<T> implements Consumer<LoadingState<? super TariffChangeResult>> {
        public final /* synthetic */ TariffChangeViewModelImpl a;

        public a(TariffChangeViewModelImpl tariffChangeViewModelImpl) {
            this.a = tariffChangeViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffChangeResult> loadingState) {
            LoadingState<? super TariffChangeResult> loadingState2 = loadingState;
            this.a.f.setValue(loadingState2);
            if (loadingState2 instanceof LoadingState.Loaded) {
                TariffChangeViewModelImpl.access$handleLoadedState(this.a, (LoadingState.Loaded) loadingState2);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffChangeViewModelImpl a;

        public b(TariffChangeViewModelImpl tariffChangeViewModelImpl) {
            this.a = tariffChangeViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(th2);
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            this.a.f.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown("", th2)));
        }
    }

    public TariffChangeViewModelImpl(@NotNull TariffChangeRepository tariffChangeRepository, @NotNull TariffChangeConverter tariffChangeConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(tariffChangeRepository, "repository");
        Intrinsics.checkNotNullParameter(tariffChangeConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.j = tariffChangeRepository;
        this.k = tariffChangeConverter;
        this.l = schedulersFactory;
        this.m = kundle;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<Action> mutableLiveData = new MutableLiveData<>();
        this.e = mutableLiveData;
        MutableLiveData<LoadingState<?>> mutableLiveData2 = new MutableLiveData<>();
        this.f = mutableLiveData2;
        this.g = new MutableLiveData<>();
        loadData();
        this.h = mutableLiveData2;
        this.i = mutableLiveData;
    }

    public static final void access$handleLoadedState(TariffChangeViewModelImpl tariffChangeViewModelImpl, LoadingState.Loaded loaded) {
        List<TariffTab> convert = tariffChangeViewModelImpl.k.convert((TariffChangeResult) loaded.getData());
        int i2 = -1;
        tariffChangeViewModelImpl.c(convert, tariffChangeViewModelImpl.m.getInt("selected_tab_index", -1));
        Iterator<TariffTab> it = convert.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().isSelected()) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        tariffChangeViewModelImpl.d = i2;
        tariffChangeViewModelImpl.g.setValue(convert);
        tariffChangeViewModelImpl.e.setValue(convert.get(tariffChangeViewModelImpl.d).getAction());
    }

    public final void c(List<TariffTab> list, int i2) {
        if (i2 >= 0) {
            int i3 = 0;
            for (T t : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                t.setSelected(i3 == i2);
                i3 = i4;
            }
        }
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    @NotNull
    public LiveData<List<TariffTab>> getTabsListChanges() {
        List<TariffTab> value = this.g.getValue();
        if (!(value == null || this.d == -1)) {
            Intrinsics.checkNotNullExpressionValue(value, "tabs");
            c(value, this.d);
            this.g.setValue(value);
        }
        return this.g;
    }

    public final void loadData() {
        this.c.dispose();
        Disposable subscribe = this.j.getTariffChangeInfo().observeOn(this.l.mainThread()).startWith((Observable<LoadingState<TariffChangeResult>>) LoadingState.Loading.INSTANCE).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getTariffChan…ror(error)\n            })");
        this.c = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    public void onPageSelected(int i2) {
        TariffTab tariffTab;
        this.d = i2;
        List<TariffTab> value = this.g.getValue();
        if (value != null && (tariffTab = value.get(i2)) != null) {
            this.e.setValue(tariffTab.getAction());
        }
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    public void onRetryButtonClick() {
        loadData();
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    @NotNull
    public Kundle saveState() {
        return new Kundle().putInt("selected_tab_index", Integer.valueOf(this.d));
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    @NotNull
    public MutableLiveData<Action> getButtonChanges() {
        return this.i;
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.h;
    }
}
