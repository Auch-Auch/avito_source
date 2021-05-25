package com.avito.android.publish.residential_complex_search;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ResidentialComplexResponse;
import com.avito.android.remote.model.ResidentialComplexSuggest;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001.BE\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b,\u0010-J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "Landroidx/lifecycle/ViewModel;", "", "initialSuggest", "()V", "", "searchValue", "searchValueChanged", "(Ljava/lang/String;)V", "onCleared", "c", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "j", "Ljava/util/List;", ResidentialComplexModuleKt.VALUES, "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", g.a, "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "converter", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "subscription", "", "i", "Ljava/lang/Double;", "lng", "h", "lat", "Lcom/avito/android/remote/PublishApi;", "f", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState;", "d", "Landroidx/lifecycle/MutableLiveData;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "state", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "ViewState", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexViewModel extends ViewModel {
    public Disposable c;
    @NotNull
    public final MutableLiveData<ViewState> d = new MutableLiveData<>();
    public final SchedulersFactory e;
    public final PublishApi f;
    public final ResidentialComplexConverter g;
    public final Double h;
    public final Double i;
    public final List<SelectParameter.Value> j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState;", "", "<init>", "()V", "Error", "Loaded", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState$Loaded;", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState$Error;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState$Error;", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState;", "Lcom/avito/android/remote/error/TypedError;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedError;", "getError", "()Lcom/avito/android/remote/error/TypedError;", "error", "<init>", "(Lcom/avito/android/remote/error/TypedError;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final TypedError a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull TypedError typedError) {
                super(null);
                Intrinsics.checkNotNullParameter(typedError, "error");
                this.a = typedError;
            }

            @NotNull
            public final TypedError getError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState$Loaded;", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel$ViewState;", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/konveyor/blueprint/Item;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/ListDataSource;", "getItems", "()Lcom/avito/konveyor/data_source/ListDataSource;", "items", "<init>", "(Lcom/avito/konveyor/data_source/ListDataSource;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ViewState {
            @NotNull
            public final ListDataSource<Item> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull ListDataSource<Item> listDataSource) {
                super(null);
                Intrinsics.checkNotNullParameter(listDataSource, "items");
                this.a = listDataSource;
            }

            @NotNull
            public final ListDataSource<Item> getItems() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<TypedResult<ResidentialComplexResponse>, ResidentialComplexResponse> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ResidentialComplexResponse apply(TypedResult<ResidentialComplexResponse> typedResult) {
            ErrorResult error;
            TypedResult<ResidentialComplexResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (ResidentialComplexResponse) ((TypedResult.OfResult) typedResult2).getResult();
            }
            String str = null;
            if (!(typedResult2 instanceof TypedResult.OfError)) {
                typedResult2 = null;
            }
            TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
            if (!(ofError == null || (error = ofError.getError()) == null)) {
                str = error.getMessage();
            }
            throw new Throwable(str);
        }
    }

    public static final class b<T> implements Consumer<ResidentialComplexResponse> {
        public final /* synthetic */ ResidentialComplexViewModel a;
        public final /* synthetic */ String b;

        public b(ResidentialComplexViewModel residentialComplexViewModel, String str) {
            this.a = residentialComplexViewModel;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ResidentialComplexResponse residentialComplexResponse) {
            MutableLiveData<ViewState> state = this.a.getState();
            ResidentialComplexConverter residentialComplexConverter = this.a.g;
            List<ResidentialComplexSuggest> list = residentialComplexResponse.getList();
            if (list == null) {
                list = new ArrayList<>();
            }
            state.setValue(new ViewState.Loaded(residentialComplexConverter.convert(list, this.b)));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can't get residential complex suggest", th);
        }
    }

    @Inject
    public ResidentialComplexViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull PublishApi publishApi, @NotNull ResidentialComplexConverter residentialComplexConverter, @Nullable Double d2, @Nullable Double d3, @Nullable List<SelectParameter.Value> list) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(residentialComplexConverter, "converter");
        this.e = schedulersFactory;
        this.f = publishApi;
        this.g = residentialComplexConverter;
        this.h = d2;
        this.i = d3;
        this.j = list;
    }

    public final void c(String str) {
        this.c = InteropKt.toV2(this.f.getResidentialComplexSuggest(str, this.h, this.i)).subscribeOn(this.e.io()).observeOn(this.e.mainThread()).map(a.a).subscribe(new b(this, str), c.a);
    }

    @NotNull
    public final MutableLiveData<ViewState> getState() {
        return this.d;
    }

    public final void initialSuggest() {
        c("");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        super.onCleared();
    }

    public final void searchValueChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchValue");
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        if (str.length() > 1) {
            c(str);
        }
    }
}
