package com.avito.android.delivery.suggest;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyItem;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.ViewCompatIdGenerator;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eRD\u0010%\u001a0\u0012\f\u0012\n !*\u0004\u0018\u00010\u00160\u0016 !*\u0017\u0012\f\u0012\n !*\u0004\u0018\u00010\u00160\u0016\u0018\u00010 ¢\u0006\u0002\b\"0 ¢\u0006\u0002\b\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010.R$\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010.R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "", "query", "", "searchSuggestions", "(Ljava/lang/String;)V", "onCleared", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "c", "()Lcom/avito/konveyor/data_source/DataSource;", "Landroidx/lifecycle/MutableLiveData;", "", g.a, "Landroidx/lifecycle/MutableLiveData;", "getErrorChanges", "()Landroidx/lifecycle/MutableLiveData;", "errorChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/remote/model/Coordinates;", "h", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCoordinatesChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "coordinatesChanges", "Lcom/avito/android/avito_map/AvitoMapBounds;", "l", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "coordinatesRelay", "f", "getDataChanges", "dataChanges", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "searchDisposable", "Lio/reactivex/rxjava3/functions/Consumer;", "i", "Lio/reactivex/rxjava3/functions/Consumer;", "getCoordinatesConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "coordinatesConsumer", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "d", "coordinatesDisposable", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "j", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "interactor", "<init>", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestViewModelImpl extends ViewModel implements DeliveryLocationSuggestViewModel {
    public Disposable c;
    public Disposable d;
    public final PublishRelay<Coordinates> e;
    @NotNull
    public final MutableLiveData<DataSource<Item>> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> g = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<Coordinates> h = new SingleLiveEvent<>();
    @NotNull
    public final Consumer<Coordinates> i;
    public final DeliveryLocationSuggestInteractor j;
    public final SchedulersFactory3 k;
    public final AvitoMapBounds l;
    public final BaseScreenPerformanceTracker m;

    public static final class a<T> implements Consumer<Coordinates> {
        public final /* synthetic */ DeliveryLocationSuggestViewModelImpl a;

        public a(DeliveryLocationSuggestViewModelImpl deliveryLocationSuggestViewModelImpl) {
            this.a = deliveryLocationSuggestViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Coordinates coordinates) {
            Coordinates coordinates2 = coordinates;
            if (coordinates2 != null) {
                this.a.getCoordinatesChanges().setValue(coordinates2);
            }
        }
    }

    public static final class c<T> implements Consumer<AddressSuggestionResult> {
        public final /* synthetic */ DeliveryLocationSuggestViewModelImpl a;

        public c(DeliveryLocationSuggestViewModelImpl deliveryLocationSuggestViewModelImpl) {
            this.a = deliveryLocationSuggestViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddressSuggestionResult addressSuggestionResult) {
            AddressSuggestionResult addressSuggestionResult2 = addressSuggestionResult;
            if (addressSuggestionResult2 instanceof AddressSuggestionResult.Ok) {
                this.a.m.trackLoaded();
                this.a.m.startPreparing();
                DataSource<Item> access$convert = DeliveryLocationSuggestViewModelImpl.access$convert(this.a, (AddressSuggestionResult.Ok) addressSuggestionResult2);
                this.a.m.trackPrepared();
                this.a.m.startDrawing();
                this.a.getDataChanges().setValue(access$convert);
                this.a.m.trackDrawn();
            } else if (addressSuggestionResult2 instanceof AddressSuggestionResult.Error) {
                DeliveryLocationSuggestViewModelImpl.access$onSearchSuggestionsError(this.a);
            } else if (addressSuggestionResult2 instanceof AddressSuggestionResult.NetworkError) {
                DeliveryLocationSuggestViewModelImpl.access$onSearchSuggestionsError(this.a);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryLocationSuggestViewModelImpl a;

        public d(DeliveryLocationSuggestViewModelImpl deliveryLocationSuggestViewModelImpl) {
            this.a = deliveryLocationSuggestViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorChanges().setValue(Boolean.FALSE);
        }
    }

    public DeliveryLocationSuggestViewModelImpl(@NotNull DeliveryLocationSuggestInteractor deliveryLocationSuggestInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AvitoMapBounds avitoMapBounds, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(avitoMapBounds, "visibleRegion");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.j = deliveryLocationSuggestInteractor;
        this.k = schedulersFactory3;
        this.l = avitoMapBounds;
        this.m = baseScreenPerformanceTracker;
        PublishRelay<Coordinates> create = PublishRelay.create();
        this.e = create;
        Intrinsics.checkNotNullExpressionValue(create, "coordinatesRelay");
        this.i = create;
        this.d = create.observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), new a2.a.a.k0.d.g(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModelImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
    }

    public static final DataSource access$convert(DeliveryLocationSuggestViewModelImpl deliveryLocationSuggestViewModelImpl, AddressSuggestionResult.Ok ok) {
        Objects.requireNonNull(deliveryLocationSuggestViewModelImpl);
        if (ok.getAddressSuggestions().isEmpty()) {
            return deliveryLocationSuggestViewModelImpl.c();
        }
        List<AddressSuggestion> addressSuggestions = ok.getAddressSuggestions();
        ArrayList arrayList = new ArrayList();
        for (T t : addressSuggestions) {
            SuggestItem suggestItem = t.getCoordinates() != null ? new SuggestItem(String.valueOf(t.getCoordinates()), t.getTitle(), t.getSubtitle(), t.getCoordinates()) : null;
            if (suggestItem != null) {
                arrayList.add(suggestItem);
            }
        }
        return new ListDataSource(arrayList);
    }

    public static final void access$onSearchSuggestionsError(DeliveryLocationSuggestViewModelImpl deliveryLocationSuggestViewModelImpl) {
        deliveryLocationSuggestViewModelImpl.m.trackLoadingError();
        deliveryLocationSuggestViewModelImpl.m.startDrawing();
        deliveryLocationSuggestViewModelImpl.getErrorChanges().setValue(Boolean.TRUE);
        deliveryLocationSuggestViewModelImpl.m.trackDrawnError();
    }

    public final DataSource<Item> c() {
        return new ListDataSource(t6.n.d.listOf(new EmptyItem(String.valueOf(ViewCompatIdGenerator.INSTANCE.generate()), null, 2, null)));
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel
    @NotNull
    public Consumer<Coordinates> getCoordinatesConsumer() {
        return this.i;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel
    public void searchSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        if (str.length() == 0) {
            getDataChanges().setValue(c());
            return;
        }
        this.m.startLoading();
        this.c = this.j.searchSuggestions(str, this.l).observeOn(this.k.mainThread()).subscribe(new c(this), new d(this));
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel
    @NotNull
    public SingleLiveEvent<Coordinates> getCoordinatesChanges() {
        return this.h;
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel
    @NotNull
    public MutableLiveData<DataSource<Item>> getDataChanges() {
        return this.f;
    }

    @Override // com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel
    @NotNull
    public MutableLiveData<Boolean> getErrorChanges() {
        return this.g;
    }
}
