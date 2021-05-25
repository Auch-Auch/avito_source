package com.avito.android.publish.slots.limits_info;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.item.LimitsInfoItem;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.limits_info.LimitsInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.limits_info.LimitsInfoSlotConfig;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0%\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b)\u0010*J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/publish/slots/limits_info/LimitsInfoSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlot;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "", "prepare", "()Lio/reactivex/Observable;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/LimitsInfo;", AuthSource.SEND_ABUSE, "Lkotlin/Pair;", "limitsData", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlot;", "slot", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "f", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "publishLimitsEventTracker", "Lcom/avito/android/remote/PublishLimitsApi;", "d", "Lcom/avito/android/remote/PublishLimitsApi;", "api", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "draftIdProvider", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlot;Lkotlin/jvm/functions/Function0;Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoSlotWrapper implements SlotWrapper<LimitsInfoSlot> {
    public Pair<String, LimitsInfo> a;
    @NotNull
    public final LimitsInfoSlot b;
    public final Function0<String> c;
    public final PublishLimitsApi d;
    public final SchedulersFactory3 e;
    public final PublishLimitsEventTracker f;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<LimitsInfo> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(LimitsInfo limitsInfo) {
            int i = this.a;
            if (i == 0) {
                ((LimitsInfoSlotWrapper) this.b).a = TuplesKt.to((String) this.c, limitsInfo);
            } else if (i == 1) {
                LimitsInfo limitsInfo2 = limitsInfo;
                PublishLimitsEventTracker publishLimitsEventTracker = ((LimitsInfoSlotWrapper) this.b).f;
                ItemId.Draft draft = new ItemId.Draft((String) this.c);
                Intrinsics.checkNotNullExpressionValue(limitsInfo2, "it");
                publishLimitsEventTracker.trackLimitsInfoShown(draft, limitsInfo2);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<LimitsInfo, LoadingState<? super Unit>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(LimitsInfo limitsInfo) {
            Intrinsics.checkNotNullParameter(limitsInfo, "it");
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public LimitsInfoSlotWrapper(@NotNull LimitsInfoSlot limitsInfoSlot, @NotNull Function0<String> function0, @NotNull PublishLimitsApi publishLimitsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(limitsInfoSlot, "slot");
        Intrinsics.checkNotNullParameter(function0, "draftIdProvider");
        Intrinsics.checkNotNullParameter(publishLimitsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "publishLimitsEventTracker");
        this.b = limitsInfoSlot;
        this.c = function0;
        this.d = publishLimitsApi;
        this.e = schedulersFactory3;
        this.f = publishLimitsEventTracker;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        Pair<String, LimitsInfo> pair = this.a;
        if (pair != null) {
            return d.listOf(new LimitsInfoItem(((LimitsInfoSlotConfig) getSlot().getWidget().getConfig()).getField().getId(), pair.getSecond(), new ItemId.Draft(pair.getFirst()), false, 8, null));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        this.a = null;
        String invoke = this.c.invoke();
        if (invoke != null) {
            Single<TypedResult<LimitsInfo>> observeOn = this.d.getLimitsForDraft(invoke).subscribeOn(this.e.io()).observeOn(this.e.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "api.getLimitsForDraft(dr…(schedulers.mainThread())");
            Single<R> flatMap = observeOn.flatMap(LimitsInfoSlotWrapper$prepare$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            io.reactivex.rxjava3.core.Observable<R> observable = flatMap.doOnSuccess(new a(0, this, invoke)).doOnSuccess(new a(1, this, invoke)).toObservable();
            Intrinsics.checkNotNullExpressionValue(observable, "api.getLimitsForDraft(dr…          .toObservable()");
            Observable<LoadingState<Unit>> onErrorReturn = InteropKt.toV2(observable).map(b.a).onErrorReturn(c.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getLimitsForDraft(dr…adingState.Loaded(Unit) }");
            return onErrorReturn;
        }
        Observable<LoadingState<Unit>> just = Observable.just(new LoadingState.Loaded(Unit.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(LoadingState.Loaded(Unit))");
        return just;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public LimitsInfoSlot getSlot() {
        return this.b;
    }
}
