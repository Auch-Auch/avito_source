package com.avito.android.delivery.summary.change_contacts;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.delivery.summary.ChangeAction;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\tR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010&R.\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)0(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020%0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001eR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>0(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010-\u001a\u0004\b@\u0010/R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "onCleared", "()V", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "loadFields", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;)V", "d", "e", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "n", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "converter", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;", "o", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;", "resourceProvider", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lio/reactivex/rxjava3/functions/Consumer;", g.a, "Lio/reactivex/rxjava3/functions/Consumer;", "getSubmitButtonClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "submitButtonClickConsumer", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "l", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "contactsFieldsInteractor", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "Lcom/jakewharton/rxrelay3/Relay;", "changeRelay", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lkotlin/Pair;", "", "", "i", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSnackBarErrorChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackBarErrorChanges", "f", "getChangeConsumer", "changeConsumer", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "submitButtonClickRelay", "", "Lcom/avito/conveyor_item/Item;", "j", "Ljava/util/List;", "listItems", "Lcom/avito/android/delivery/summary/ChangeAction$EditContacts;", "h", "getSaveChanges", "saveChanges", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsResourceProvider;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsEditContactsViewModelImpl extends ViewModel implements DeliveryRdsEditContactsViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final Relay<ParameterElement.Input> d;
    public final Relay<Unit> e;
    @NotNull
    public final Consumer<ParameterElement.Input> f;
    @NotNull
    public final Consumer<Unit> g;
    @NotNull
    public final SingleLiveEvent<ChangeAction.EditContacts> h;
    @NotNull
    public final SingleLiveEvent<Pair<String, Boolean>> i;
    public List<? extends Item> j;
    public AdapterPresenter k;
    public final DeliveryRdsContactsFieldsInteractor l;
    public final SchedulersFactory3 m;
    public final DeliveryRdsSummaryItemsConverter n;
    public final DeliveryRdsEditContactsResourceProvider o;

    public static final class a<T> implements Consumer<ParameterElement.Input> {
        public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

        public a(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
            this.a = deliveryRdsEditContactsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ParameterElement.Input input) {
            ParameterElement.Input input2 = input;
            String value = input2.getValue();
            if (value != null) {
                DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(input2, "element");
                DeliveryRdsEditContactsViewModelImpl.access$onElementValueChanged(deliveryRdsEditContactsViewModelImpl, input2, value);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

        public b(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
            this.a = deliveryRdsEditContactsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("DeliveryContacts", th);
            DeliveryRdsEditContactsViewModelImpl.access$showUnknownError(this.a);
            this.a.d();
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

        public c(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
            this.a = deliveryRdsEditContactsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ParametersTree parametersTree = this.a.n.getParametersTree();
            if (parametersTree != null) {
                DeliveryRdsEditContactsViewModelImpl.access$validateFields(this.a, parametersTree);
            } else {
                DeliveryRdsEditContactsViewModelImpl.access$showUnknownError(this.a);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

        public d(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
            this.a = deliveryRdsEditContactsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("DeliveryContacts", th);
            DeliveryRdsEditContactsViewModelImpl.access$showUnknownError(this.a);
            this.a.e();
        }
    }

    public DeliveryRdsEditContactsViewModelImpl(@NotNull DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, @NotNull DeliveryRdsEditContactsResourceProvider deliveryRdsEditContactsResourceProvider) {
        Intrinsics.checkNotNullParameter(deliveryRdsContactsFieldsInteractor, "contactsFieldsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryRdsEditContactsResourceProvider, "resourceProvider");
        this.l = deliveryRdsContactsFieldsInteractor;
        this.m = schedulersFactory3;
        this.n = deliveryRdsSummaryItemsConverter;
        this.o = deliveryRdsEditContactsResourceProvider;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.d = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        this.f = create;
        this.g = create2;
        this.h = new SingleLiveEvent<>();
        this.i = new SingleLiveEvent<>();
        this.j = CollectionsKt__CollectionsKt.emptyList();
        d();
        e();
    }

    public static final void access$onElementValueChanged(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl, Item item, String str) {
        deliveryRdsEditContactsViewModelImpl.n.onParameterValueChanged(item.getStringId(), str);
    }

    public static final void access$onValidationResultLoaded(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl, Map map) {
        Objects.requireNonNull(deliveryRdsEditContactsViewModelImpl);
        if (map.isEmpty()) {
            deliveryRdsEditContactsViewModelImpl.getSaveChanges().setValue(new ChangeAction.EditContacts(deliveryRdsEditContactsViewModelImpl.n.getFieldsMap()));
        }
        List<Item> applyErrors = deliveryRdsEditContactsViewModelImpl.n.applyErrors(map, deliveryRdsEditContactsViewModelImpl.j);
        AdapterPresenter adapterPresenter = deliveryRdsEditContactsViewModelImpl.k;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(applyErrors, adapterPresenter);
        }
        deliveryRdsEditContactsViewModelImpl.j = applyErrors;
    }

    public static final void access$showError(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl, TypedError typedError) {
        Objects.requireNonNull(deliveryRdsEditContactsViewModelImpl);
        if (typedError instanceof ErrorWithMessage) {
            c(deliveryRdsEditContactsViewModelImpl, ((ErrorWithMessage) typedError).getMessage(), false, 2);
        } else {
            c(deliveryRdsEditContactsViewModelImpl, deliveryRdsEditContactsViewModelImpl.o.getErrorOccurred(), false, 2);
        }
    }

    public static final void access$showUnknownError(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
        c(deliveryRdsEditContactsViewModelImpl, deliveryRdsEditContactsViewModelImpl.o.getErrorOccurred(), false, 2);
    }

    public static final void access$validateFields(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl, ParametersTree parametersTree) {
        Disposable subscribe = deliveryRdsEditContactsViewModelImpl.l.validateFields(parametersTree).observeOn(deliveryRdsEditContactsViewModelImpl.m.mainThread()).subscribe(new a2.a.a.k0.e.h0.c(deliveryRdsEditContactsViewModelImpl), new a2.a.a.k0.e.h0.d(deliveryRdsEditContactsViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "contactsFieldsInteractor…          }\n            )");
        DisposableKt.addTo(subscribe, deliveryRdsEditContactsViewModelImpl.c);
    }

    public static void c(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl, String str, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        deliveryRdsEditContactsViewModelImpl.getSnackBarErrorChanges().postValue(TuplesKt.to(str, Boolean.valueOf(z)));
    }

    public final void d() {
        Disposable subscribe = this.d.subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "changeRelay\n            …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void e() {
        Disposable subscribe = this.e.observeOn(this.m.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "submitButtonClickRelay\n …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    @NotNull
    public Consumer<ParameterElement.Input> getChangeConsumer() {
        return this.f;
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    @NotNull
    public Consumer<Unit> getSubmitButtonClickConsumer() {
        return this.g;
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    public void loadFields(@NotNull DeliverySummaryRds.ContactsGroup contactsGroup) {
        Intrinsics.checkNotNullParameter(contactsGroup, "contactsGroup");
        List<Item> convert = this.n.convert(contactsGroup);
        AdapterPresenter adapterPresenter = this.k;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(convert, adapterPresenter);
        }
        this.j = convert;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.k = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.j));
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    @NotNull
    public SingleLiveEvent<ChangeAction.EditContacts> getSaveChanges() {
        return this.h;
    }

    @Override // com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel
    @NotNull
    public SingleLiveEvent<Pair<String, Boolean>> getSnackBarErrorChanges() {
        return this.i;
    }
}
