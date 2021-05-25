package com.avito.android.tariff.info.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.TariffInfoResult;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b1\u00102J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR(\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u000bR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R.\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r¨\u00063"}, d2 = {"Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModelImpl;", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "onRetryButtonClick", "loadData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/remote/model/Action;", g.a, "Landroidx/lifecycle/MutableLiveData;", "getButtonActionChanges", "()Landroidx/lifecycle/MutableLiveData;", "buttonActionChanges", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepository;", "i", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepository;", "repository", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;", "j", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "e", "buttonActionChangesLiveData", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/conveyor_item/Item;", "d", "progressChangesLiveData", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "", "h", "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/tariff/StringProvider;", "k", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "f", "getProgressChanges", "progressChanges", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepository;Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoViewModelImpl extends ViewModel implements TariffInfoViewModel {
    public Disposable c;
    public final MutableLiveData<LoadingState<List<? extends Item>>> d;
    public final MutableLiveData<Action> e;
    @NotNull
    public final MutableLiveData<LoadingState<List<? extends Item>>> f;
    @NotNull
    public final MutableLiveData<Action> g;
    public final String h;
    public final TariffInfoRepository i;
    public final TariffInfoConverter j;
    public final StringProvider k;
    public final SchedulersFactory l;

    public static final class a<T> implements Consumer<LoadingState<? super TariffInfoResult>> {
        public final /* synthetic */ TariffInfoViewModelImpl a;

        public a(TariffInfoViewModelImpl tariffInfoViewModelImpl) {
            this.a = tariffInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffInfoResult> loadingState) {
            LoadingState<? super TariffInfoResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.d.setValue(new LoadingState.Loaded(this.a.j.convert((TariffInfoResult) loaded.getData())));
                this.a.e.setValue(((TariffInfoResult) loaded.getData()).getAction());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.d.setValue(loadingState2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.d.setValue(loadingState2);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffInfoViewModelImpl a;

        public b(TariffInfoViewModelImpl tariffInfoViewModelImpl) {
            this.a = tariffInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(this.a.k.getUnknownError())));
            Timber.e(th);
        }
    }

    public TariffInfoViewModelImpl(@NotNull String str, @NotNull TariffInfoRepository tariffInfoRepository, @NotNull TariffInfoConverter tariffInfoConverter, @NotNull StringProvider stringProvider, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(tariffInfoRepository, "repository");
        Intrinsics.checkNotNullParameter(tariffInfoConverter, "converter");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.h = str;
        this.i = tariffInfoRepository;
        this.j = tariffInfoConverter;
        this.k = stringProvider;
        this.l = schedulersFactory;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<LoadingState<List<? extends Item>>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Action> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        loadData();
        this.f = mutableLiveData;
        this.g = mutableLiveData2;
    }

    public final void loadData() {
        this.c.dispose();
        Disposable subscribe = this.i.getTariffInfo(this.h).observeOn(this.l.mainThread()).startWith((Observable<LoadingState<TariffInfoResult>>) LoadingState.Loading.INSTANCE).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getTariffInfo…mber.e(it)\n            })");
        this.c = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
    }

    @Override // com.avito.android.tariff.info.viewmodel.TariffInfoViewModel
    public void onRetryButtonClick() {
        loadData();
    }

    @Override // com.avito.android.tariff.info.viewmodel.TariffInfoViewModel
    @NotNull
    public MutableLiveData<Action> getButtonActionChanges() {
        return this.g;
    }

    @Override // com.avito.android.tariff.info.viewmodel.TariffInfoViewModel
    @NotNull
    public MutableLiveData<LoadingState<List<? extends Item>>> getProgressChanges() {
        return this.f;
    }
}
