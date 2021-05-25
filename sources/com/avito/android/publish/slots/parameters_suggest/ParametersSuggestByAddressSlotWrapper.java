package com.avito.android.publish.slots.parameters_suggest;

import a2.a.a.e2.d0.g.a;
import a2.a.a.e2.d0.g.b;
import a2.a.a.e2.d0.g.c;
import a2.a.a.e2.d0.g.d;
import a2.a.a.e2.d0.g.e;
import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.ReactiveSlot;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.parameters_suggest.ParametersSuggestByAddressSlot;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B7\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b3\u00104J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R:\u0010\u0017\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010.\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/publish/slots/parameters_suggest/ParametersSuggestByAddressSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/parameters_suggest/ParametersSuggestByAddressSlot;", "Lcom/avito/android/publish/slots/ReactiveSlot;", "", "getId", "()Ljava/lang/String;", "", "clear", "()V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "h", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "slotDataChanges", "Lcom/avito/android/publish/PublishViewModel;", "f", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/PublishApi;", "e", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lio/reactivex/Observable;", "c", "Lio/reactivex/Observable;", "getDataChangesObservable", "()Lio/reactivex/Observable;", "dataChangesObservable", "d", "Lcom/avito/android/remote/model/category_parameters/slot/parameters_suggest/ParametersSuggestByAddressSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/parameters_suggest/ParametersSuggestByAddressSlot;", "slot", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "i", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/parameters_suggest/ParametersSuggestByAddressSlot;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersSuggestByAddressSlotWrapper implements SlotWrapper<ParametersSuggestByAddressSlot>, ReactiveSlot {
    public final CompositeDisposable a;
    public final PublishRelay<ConsumeValueChangeResult> b;
    @NotNull
    public final Observable<ConsumeValueChangeResult> c;
    @NotNull
    public final ParametersSuggestByAddressSlot d;
    public final PublishApi e;
    public final PublishViewModel f;
    public final SchedulersFactory3 g;
    public final CategoryParametersConverter h;
    public final PublishAnalyticsDataProvider i;

    public ParametersSuggestByAddressSlotWrapper(@NotNull ParametersSuggestByAddressSlot parametersSuggestByAddressSlot, @NotNull PublishApi publishApi, @NotNull PublishViewModel publishViewModel, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(parametersSuggestByAddressSlot, "slot");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        this.d = parametersSuggestByAddressSlot;
        this.e = publishApi;
        this.f = publishViewModel;
        this.g = schedulersFactory3;
        this.h = categoryParametersConverter;
        this.i = publishAnalyticsDataProvider;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        PublishRelay<ConsumeValueChangeResult> create = PublishRelay.create();
        this.b = create;
        Disposable subscribe = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(a.a).observeOn(schedulersFactory3.mainThread()).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel.paramet…ter\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
        Intrinsics.checkNotNullExpressionValue(create, "slotDataChanges");
        this.c = create;
    }

    public static final void access$performSuggestRequest(ParametersSuggestByAddressSlotWrapper parametersSuggestByAddressSlotWrapper) {
        List<ParameterSlot> parameters;
        CategoryParameters categoryParameters = parametersSuggestByAddressSlotWrapper.f.getCategoryParameters();
        if (categoryParameters != null && (parameters = categoryParameters.getParameters()) != null) {
            CompositeDisposable compositeDisposable = parametersSuggestByAddressSlotWrapper.a;
            Disposable subscribe = parametersSuggestByAddressSlotWrapper.e.getPublishParametersByGeo(parametersSuggestByAddressSlotWrapper.i.getSessionId(), parametersSuggestByAddressSlotWrapper.h.convertToFieldMap(parametersSuggestByAddressSlotWrapper.f.getNavigation()), parametersSuggestByAddressSlotWrapper.h.convertToFieldMap(parameters)).subscribeOn(parametersSuggestByAddressSlotWrapper.g.io()).observeOn(parametersSuggestByAddressSlotWrapper.g.mainThread()).subscribe(new d(parametersSuggestByAddressSlotWrapper), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "publishApi.getPublishPar…\", it)\n                })");
            Disposables.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    public void clear() {
        this.a.clear();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    @NotNull
    public Observable<ConsumeValueChangeResult> getDataChangesObservable() {
        return this.c;
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        return SlotWrapper.DefaultImpls.getElements(this);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        return SlotWrapper.DefaultImpls.prepare(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ParametersSuggestByAddressSlot getSlot() {
        return this.d;
    }
}
