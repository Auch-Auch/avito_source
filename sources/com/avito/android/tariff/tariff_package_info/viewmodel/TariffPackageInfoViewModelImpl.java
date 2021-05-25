package com.avito.android.tariff.tariff_package_info.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.TariffPackageInfoResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b8\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005R \u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\nR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R(\u00100\u001a\u0014 -*\t\u0018\u00010+¢\u0006\u0002\b,0+¢\u0006\u0002\b,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R&\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b2\u00103R(\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b6\u00103¨\u0006:"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModelImpl;", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onRetryButtonClick", "()V", "loadData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "e", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "", "Lcom/avito/conveyor_item/Item;", "d", "listChangesLiveData", "", "j", "Ljava/lang/String;", "packageId", "k", "contractId", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/text/AttributedText;", "i", "Landroidx/lifecycle/LiveData;", "getTitleChanges", "()Landroidx/lifecycle/LiveData;", "titleChanges", "f", "titleChangesLiveData", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", "repository", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "l", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/annotations/NonNull;", "kotlin.jvm.PlatformType", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingSubscription", "h", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", a2.g.r.g.a, "getListChanges", "listChanges", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;Lcom/avito/android/util/SchedulersFactory3;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageInfoViewModelImpl extends ViewModel implements TariffPackageInfoViewModel {
    public Disposable c = s6.a.e.c.b.a();
    public final MutableLiveData<List<Item>> d;
    public final MutableLiveData<LoadingState<?>> e;
    public final MutableLiveData<AttributedText> f;
    @NotNull
    public final MutableLiveData<List<Item>> g;
    @NotNull
    public final MutableLiveData<LoadingState<?>> h;
    @NotNull
    public final LiveData<AttributedText> i;
    public final String j;
    public final String k;
    public final TariffPackageInfoConverter l;
    public final TariffPackageInfoRepository m;
    public final SchedulersFactory3 n;

    public static final class a<T> implements Consumer<LoadingState<? super TariffPackageInfoResult>> {
        public final /* synthetic */ TariffPackageInfoViewModelImpl a;

        public a(TariffPackageInfoViewModelImpl tariffPackageInfoViewModelImpl) {
            this.a = tariffPackageInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super TariffPackageInfoResult> loadingState) {
            this.a.e.postValue(loadingState);
        }
    }

    public static final class b<T> implements Predicate<LoadingState<? super TariffPackageInfoResult>> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(LoadingState<? super TariffPackageInfoResult> loadingState) {
            return loadingState instanceof LoadingState.Loaded;
        }
    }

    public static final class c<T, R> implements Function<LoadingState<? super TariffPackageInfoResult>, LoadingState.Loaded<TariffPackageInfoResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState.Loaded<TariffPackageInfoResult> apply(LoadingState<? super TariffPackageInfoResult> loadingState) {
            LoadingState<? super TariffPackageInfoResult> loadingState2 = loadingState;
            Objects.requireNonNull(loadingState2, "null cannot be cast to non-null type com.avito.android.util.LoadingState.Loaded<com.avito.android.remote.model.TariffPackageInfoResult>");
            return (LoadingState.Loaded) loadingState2;
        }
    }

    public static final class d<T> implements Consumer<LoadingState.Loaded<TariffPackageInfoResult>> {
        public final /* synthetic */ TariffPackageInfoViewModelImpl a;

        public d(TariffPackageInfoViewModelImpl tariffPackageInfoViewModelImpl) {
            this.a = tariffPackageInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState.Loaded<TariffPackageInfoResult> loaded) {
            this.a.f.postValue(loaded.getData().getTitle());
        }
    }

    public static final class e<T, R> implements Function<LoadingState.Loaded<TariffPackageInfoResult>, List<? extends Item>> {
        public final /* synthetic */ TariffPackageInfoViewModelImpl a;

        public e(TariffPackageInfoViewModelImpl tariffPackageInfoViewModelImpl) {
            this.a = tariffPackageInfoViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends Item> apply(LoadingState.Loaded<TariffPackageInfoResult> loaded) {
            return this.a.l.convert(loaded.getData());
        }
    }

    public static final class f<T> implements Consumer<List<? extends Item>> {
        public final /* synthetic */ TariffPackageInfoViewModelImpl a;

        public f(TariffPackageInfoViewModelImpl tariffPackageInfoViewModelImpl) {
            this.a = tariffPackageInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends Item> list) {
            this.a.d.postValue(list);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffPackageInfoViewModelImpl a;

        public g(TariffPackageInfoViewModelImpl tariffPackageInfoViewModelImpl) {
            this.a = tariffPackageInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            this.a.e.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown("", th2)));
        }
    }

    public TariffPackageInfoViewModelImpl(@NotNull String str, @NotNull String str2, @NotNull TariffPackageInfoConverter tariffPackageInfoConverter, @NotNull TariffPackageInfoRepository tariffPackageInfoRepository, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "packageId");
        Intrinsics.checkNotNullParameter(str2, "contractId");
        Intrinsics.checkNotNullParameter(tariffPackageInfoConverter, "converter");
        Intrinsics.checkNotNullParameter(tariffPackageInfoRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.j = str;
        this.k = str2;
        this.l = tariffPackageInfoConverter;
        this.m = tariffPackageInfoRepository;
        this.n = schedulersFactory3;
        MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<LoadingState<?>> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<AttributedText> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        this.g = mutableLiveData;
        this.h = mutableLiveData2;
        this.i = mutableLiveData3;
        loadData();
    }

    @Override // com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel
    @NotNull
    public LiveData<AttributedText> getTitleChanges() {
        return this.i;
    }

    public final void loadData() {
        this.c.dispose();
        this.c = this.m.getTariffPackageInfo(this.k, this.j).startWithItem(LoadingState.Loading.INSTANCE).doOnNext(new a(this)).filter(b.a).map(c.a).doOnNext(new d(this)).map(new e(this)).observeOn(this.n.mainThread()).subscribe(new f(this), new g(this));
    }

    @Override // com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel
    public void onRetryButtonClick() {
        loadData();
    }

    @Override // com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel
    @NotNull
    public MutableLiveData<List<Item>> getListChanges() {
        return this.g;
    }

    @Override // com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.h;
    }
}
