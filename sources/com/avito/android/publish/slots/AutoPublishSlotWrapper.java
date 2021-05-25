package com.avito.android.publish.slots;

import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishResponse;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishSlot;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishSlotValue;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B?\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\bE\u0010FJ#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\b068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R:\u0010@\u001a&\u0012\f\u0012\n =*\u0004\u0018\u00010\b0\b =*\u0012\u0012\f\u0012\n =*\u0004\u0018\u00010\b0\b\u0018\u00010<0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/publish/slots/AutoPublishSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;", "Lcom/avito/android/publish/slots/ReactiveSlot;", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "", "getId", "()Ljava/lang/String;", "", "clear", "()V", AuthSource.SEND_ABUSE, "f", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;", "slot", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "j", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "l", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "Lcom/avito/android/publish/PublishViewModel;", "h", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "slotField", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/remote/PublishApi;", g.a, "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "i", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getDataChangesObservable", "()Lio/reactivex/Observable;", "dataChangesObservable", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "slotDataChanges", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "relatedFields", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishSlotWrapper implements SlotWrapper<AutoPublishSlot>, ReactiveSlot {
    public final BooleanParameter a;
    public final List<String> b;
    public final CompositeDisposable c;
    public final PublishRelay<ConsumeValueChangeResult> d;
    @NotNull
    public final Observable<ConsumeValueChangeResult> e;
    @NotNull
    public final AutoPublishSlot f;
    public final PublishApi g;
    public final PublishViewModel h;
    public final CategoryParametersConverter i;
    public final PublishAnalyticsDataProvider j;
    public final SchedulersFactory3 k;
    public final PublishDetailsTracker l;

    public static final class a<T> implements Consumer<TypedResult<AutoPublishResponse>> {
        public final /* synthetic */ AutoPublishSlotWrapper a;

        public a(AutoPublishSlotWrapper autoPublishSlotWrapper) {
            this.a = autoPublishSlotWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<AutoPublishResponse> typedResult) {
            this.a.l.trackAutoPublishSlotLoaded();
        }
    }

    public static final class b<T, R> implements Function<Throwable, TypedResult<AutoPublishResponse>> {
        public final /* synthetic */ AutoPublishSlotWrapper a;

        public b(AutoPublishSlotWrapper autoPublishSlotWrapper) {
            this.a = autoPublishSlotWrapper;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TypedResult<AutoPublishResponse> apply(Throwable th) {
            this.a.l.trackAutoPublishSlotLoadError();
            return new TypedResult.OfError(new ErrorResult.UnknownError("", null, null, 6, null));
        }
    }

    public static final class c<T> implements Consumer<TypedResult<AutoPublishResponse>> {
        public final /* synthetic */ AutoPublishSlotWrapper a;

        public c(AutoPublishSlotWrapper autoPublishSlotWrapper) {
            this.a = autoPublishSlotWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<AutoPublishResponse> typedResult) {
            TypedResult<AutoPublishResponse> typedResult2 = typedResult;
            if (!(typedResult2 instanceof TypedResult.OfResult) || !((AutoPublishResponse) ((TypedResult.OfResult) typedResult2).getResult()).getAvailable()) {
                this.a.getSlot().setParameters(CollectionsKt__CollectionsKt.emptyList());
            } else {
                this.a.getSlot().setParameters(t6.n.d.listOf(this.a.a));
            }
            this.a.d.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.AUTO_PUBLISH));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on checkAutoPublish", th);
        }
    }

    public AutoPublishSlotWrapper(@NotNull AutoPublishSlot autoPublishSlot, @NotNull PublishApi publishApi, @NotNull PublishViewModel publishViewModel, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(autoPublishSlot, "slot");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        this.f = autoPublishSlot;
        this.g = publishApi;
        this.h = publishViewModel;
        this.i = categoryParametersConverter;
        this.j = publishAnalyticsDataProvider;
        this.k = schedulersFactory3;
        this.l = publishDetailsTracker;
        BooleanParameter field = ((AutoPublishSlotConfig) getSlot().getWidget().getConfig()).getField();
        this.a = field;
        List<String> relatedFields = ((AutoPublishSlotConfig) getSlot().getWidget().getConfig()).getRelatedFields();
        this.b = relatedFields == null ? CollectionsKt__CollectionsKt.emptyList() : relatedFields;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        PublishRelay<ConsumeValueChangeResult> create = PublishRelay.create();
        this.d = create;
        AutoPublishSlotValue value = getSlot().getValue();
        Boolean autoPublish = value != null ? value.getAutoPublish() : null;
        if (autoPublish != null) {
            field.setValue(autoPublish);
        } else {
            getSlot().setValue(new AutoPublishSlotValue(null));
            Boolean bool = (Boolean) field.getValue();
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                AutoPublishSlotValue value2 = getSlot().getValue();
                if (value2 != null) {
                    value2.setAutoPublish(Boolean.valueOf(booleanValue));
                }
            }
        }
        if (Intrinsics.areEqual(((AutoPublishSlotConfig) getSlot().getWidget().getConfig()).getReadyToDisplay(), Boolean.TRUE)) {
            getSlot().setParameters(t6.n.d.listOf(field));
        } else {
            a();
        }
        a2.a.a.e2.d0.a aVar = new a2.a.a.e2.d0.a(this);
        Disposable subscribe = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(s1.b).debounce(500, TimeUnit.MILLISECONDS, schedulersFactory3.computation()).subscribe(new a2.a.a.e2.d0.b(aVar), q1.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel.paramet…ter\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(s1.c).subscribe(new a2.a.a.e2.d0.b(aVar), q1.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "publishViewModel.paramet…ter\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe2);
        Observable<ConsumeValueChangeResult> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "slotDataChanges.hide()");
        this.e = hide;
    }

    public final void a() {
        List<ParameterSlot> parameters;
        CategoryParameters categoryParameters = this.h.getCategoryParameters();
        if (categoryParameters != null && (parameters = categoryParameters.getParameters()) != null) {
            this.l.startAutoPublishSlotLoading();
            CompositeDisposable compositeDisposable = this.c;
            PublishApi publishApi = this.g;
            Map<String, String> convertToFieldMap = this.i.convertToFieldMap(this.h.getNavigation());
            Map<String, String> convertToFieldMap2 = this.i.convertToFieldMap(parameters);
            ItemBrief item = this.h.getItem();
            Disposable subscribe = publishApi.checkAutoPublish(convertToFieldMap, convertToFieldMap2, item != null ? item.getId() : null, this.j.getSessionId()).doOnNext(new a(this)).onErrorReturn(new b(this)).subscribeOn(this.k.io()).observeOn(this.k.mainThread()).subscribe(new c(this), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "publishApi.checkAutoPubl…ish\", it) }\n            )");
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
        this.c.clear();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        if ((item instanceof CheckBoxItem) && Intrinsics.areEqual(this.a.getId(), item.getStringId())) {
            CheckBoxItem checkBoxItem = (CheckBoxItem) item;
            this.a.setValue(Boolean.valueOf(checkBoxItem.isChecked()));
            AutoPublishSlotValue value = getSlot().getValue();
            if (value != null) {
                value.setAutoPublish(Boolean.valueOf(checkBoxItem.isChecked()));
            }
        }
        return ConsumeValueChangeResult.NoChange.INSTANCE;
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    @NotNull
    public Observable<ConsumeValueChangeResult> getDataChangesObservable() {
        return this.e;
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
    public AutoPublishSlot getSlot() {
        return this.f;
    }
}
