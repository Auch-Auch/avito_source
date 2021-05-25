package com.avito.android.fees.refactor;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.FeesLoadingState;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010)\u001a\u00020(\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u000b\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u000e¨\u0006."}, d2 = {"Lcom/avito/android/fees/refactor/PackageFeeViewModelImpl;", "Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "Landroidx/lifecycle/ViewModel;", "", "packageId", "", "onPackageClick", "(J)V", "onCleared", "()V", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/avito/konveyor/blueprint/Item;", "d", "Landroidx/lifecycle/MutableLiveData;", "dataChangeEvents", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "i", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "interactor", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/FeesLoadingState;", g.a, "Landroidx/lifecycle/LiveData;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "subscription", "f", "getDataChanges", "dataChanges", "Lcom/avito/android/remote/model/OwnedPackage;", "h", "Ljava/util/List;", "packages", "e", "progressLiveData", "", "message", "Lcom/avito/android/fees/refactor/PackageItemConverter;", "converter", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/fees/refactor/PackageItemConverter;Lcom/avito/android/fees/refactor/PackageApplyInteractor;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageFeeViewModelImpl extends ViewModel implements PackageFeeViewModel {
    public Disposable c;
    public final MutableLiveData<List<Item>> d;
    public final MutableLiveData<FeesLoadingState> e;
    @NotNull
    public final LiveData<List<Item>> f;
    @NotNull
    public final LiveData<FeesLoadingState> g;
    public final List<OwnedPackage> h;
    public final PackageApplyInteractor i;

    public static final class a<T> implements Consumer<FeesLoadingState> {
        public final /* synthetic */ PackageFeeViewModelImpl a;

        public a(PackageFeeViewModelImpl packageFeeViewModelImpl) {
            this.a = packageFeeViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(FeesLoadingState feesLoadingState) {
            this.a.e.postValue(feesLoadingState);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public PackageFeeViewModelImpl(@NotNull String str, @NotNull List<OwnedPackage> list, @NotNull PackageItemConverter packageItemConverter, @NotNull PackageApplyInteractor packageApplyInteractor) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "packages");
        Intrinsics.checkNotNullParameter(packageItemConverter, "converter");
        Intrinsics.checkNotNullParameter(packageApplyInteractor, "interactor");
        this.h = list;
        this.i = packageApplyInteractor;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<FeesLoadingState> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        mutableLiveData.postValue(packageItemConverter.convert(str, list));
        this.f = mutableLiveData;
        this.g = mutableLiveData2;
    }

    @Override // com.avito.android.fees.refactor.PackageFeeViewModel
    @NotNull
    public LiveData<List<Item>> getDataChanges() {
        return this.f;
    }

    @Override // com.avito.android.fees.refactor.PackageFeeViewModel
    @NotNull
    public LiveData<FeesLoadingState> getProgressChanges() {
        return this.g;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.fees.refactor.PackageClickListener
    public void onPackageClick(long j) {
        T t;
        boolean z;
        Iterator<T> it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getId() == j) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            Disposable subscribe = this.i.applyPackage(t2).subscribe(new a(this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.applyPackage(…  { e -> Logs.error(e) })");
            this.c = subscribe;
        }
    }
}
