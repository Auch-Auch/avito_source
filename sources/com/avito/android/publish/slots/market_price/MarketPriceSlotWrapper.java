package com.avito.android.publish.slots.market_price;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.items.MarketPriceItem;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.ReactiveSlot;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish.slots.market_price.analytics.ItemAddImvShieldShowEvent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.MarketPriceImageName;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceSlot;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceSlotConfig;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BW\u0012\u0006\u0010K\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010c\u001a\u00020`¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u0004\u0018\u00010\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010)R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010)R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010F\u001a\b\u0012\u0004\u0012\u00020A0@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010K\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR:\u0010[\u001a&\u0012\f\u0012\n Y*\u0004\u0018\u00010A0A Y*\u0012\u0012\f\u0012\n Y*\u0004\u0018\u00010A0A\u0018\u00010X0X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/avito/android/publish/slots/market_price/MarketPriceSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceSlot;", "Lcom/avito/android/publish/slots/ReactiveSlot;", "", "f", "()V", "", "formattedMarketPrice", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "priceRange", "formattedMessage", "", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "(Ljava/lang/CharSequence;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;Ljava/lang/CharSequence;)Ljava/util/List;", "priceRanges", "", "userPriceValue", "d", "(Ljava/util/List;J)Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "Lcom/avito/android/remote/model/category_parameters/PriceParameter;", "priceParam", "e", "(Lcom/avito/android/remote/model/category_parameters/PriceParameter;)Ljava/lang/Long;", "c", "()Lcom/avito/android/remote/model/category_parameters/PriceParameter;", "", "getId", "()Ljava/lang/String;", "getElements", "()Ljava/util/List;", "clear", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse;", "marketPriceData", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", VKApiConst.Q, "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "Ljava/util/List;", "emptyDealTypeData", "relatedParamsValues", "Lcom/avito/android/remote/PublishApi;", "j", "Lcom/avito/android/remote/PublishApi;", "publishApi", "relatedFields", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "n", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "com/avito/android/publish/slots/market_price/MarketPriceSlotWrapper$infoPageOpenListener$1", "h", "Lcom/avito/android/publish/slots/market_price/MarketPriceSlotWrapper$infoPageOpenListener$1;", "infoPageOpenListener", "Lcom/avito/android/util/text/AttributedTextFormatter;", "l", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lio/reactivex/Observable;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", g.a, "Lio/reactivex/Observable;", "getDataChangesObservable", "()Lio/reactivex/Observable;", "dataChangesObservable", "i", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceSlot;", "slot", "Lcom/avito/android/publish/PublishViewModel;", "k", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "p", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "slotDataChanges", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/Features;", "r", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceSlot;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;Lcom/avito/android/Features;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceSlotWrapper implements SlotWrapper<MarketPriceSlot>, ReactiveSlot {
    public final List<String> a;
    public MarketPriceResponse b;
    public List<String> c;
    public List<String> d;
    public final CompositeDisposable e;
    public final PublishRelay<ConsumeValueChangeResult> f;
    @NotNull
    public final Observable<ConsumeValueChangeResult> g;
    public final MarketPriceSlotWrapper$infoPageOpenListener$1 h;
    @NotNull
    public final MarketPriceSlot i;
    public final PublishApi j;
    public final PublishViewModel k;
    public final AttributedTextFormatter l;
    public final CategoryParametersConverter m;
    public final PublishAnalyticsDataProvider n;
    public final Analytics o;
    public final SchedulersFactory3 p;
    public final PublishDetailsTracker q;
    public final Features r;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MarketPriceImageName.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            MarketPriceImageName marketPriceImageName = MarketPriceImageName.LOWEST;
            iArr[0] = 1;
            MarketPriceImageName marketPriceImageName2 = MarketPriceImageName.LOW;
            iArr[1] = 2;
            MarketPriceImageName marketPriceImageName3 = MarketPriceImageName.NORMAL;
            iArr[2] = 3;
            MarketPriceImageName marketPriceImageName4 = MarketPriceImageName.HIGH;
            iArr[3] = 4;
            MarketPriceImageName marketPriceImageName5 = MarketPriceImageName.HIGHEST;
            iArr[4] = 5;
            MarketPriceImageName marketPriceImageName6 = MarketPriceImageName.UNSUPPORTED;
            iArr[5] = 6;
        }
    }

    public static final class a<T> implements Consumer<TypedResult<MarketPriceResponse>> {
        public final /* synthetic */ MarketPriceSlotWrapper a;

        public a(MarketPriceSlotWrapper marketPriceSlotWrapper) {
            this.a = marketPriceSlotWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<MarketPriceResponse> typedResult) {
            TypedResult<MarketPriceResponse> typedResult2 = typedResult;
            this.a.q.trackMarketPriceSlotLoaded();
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                this.a.b = (MarketPriceResponse) ofResult.getResult();
                MarketPriceSlotWrapper marketPriceSlotWrapper = this.a;
                marketPriceSlotWrapper.c = MarketPriceSlotWrapper.access$getEmptyDealTypeData(marketPriceSlotWrapper, (MarketPriceResponse) ofResult.getResult());
                return;
            }
            MarketPriceSlotWrapper.access$clearData(this.a);
        }
    }

    public static final class b<T, R> implements Function<Throwable, TypedResult<MarketPriceResponse>> {
        public final /* synthetic */ MarketPriceSlotWrapper a;

        public b(MarketPriceSlotWrapper marketPriceSlotWrapper) {
            this.a = marketPriceSlotWrapper;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public TypedResult<MarketPriceResponse> apply(Throwable th) {
            this.a.q.trackMarketPriceSlotLoadError();
            return new TypedResult.OfError(new ErrorResult.UnknownError("", null, null, 6, null));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<MarketPriceResponse>, LoadingState.Loaded<Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState.Loaded<Unit> apply(TypedResult<MarketPriceResponse> typedResult) {
            return new LoadingState.Loaded<>(Unit.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<LoadingState.Loaded<Unit>> {
        public final /* synthetic */ MarketPriceSlotWrapper a;

        public d(MarketPriceSlotWrapper marketPriceSlotWrapper) {
            this.a = marketPriceSlotWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v9, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState.Loaded<Unit> loaded) {
            if (this.a.r.getMarketPricePublishAutoInput().invoke().booleanValue()) {
                MarketPriceSlotWrapper.access$inputPriceToPriceParameterIfNeeded(this.a);
            }
            this.a.f.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.MARKET_PRICE));
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to getMarketPrice", th);
        }
    }

    public MarketPriceSlotWrapper(@NotNull MarketPriceSlot marketPriceSlot, @NotNull PublishApi publishApi, @NotNull PublishViewModel publishViewModel, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishDetailsTracker publishDetailsTracker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(marketPriceSlot, "slot");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        this.i = marketPriceSlot;
        this.j = publishApi;
        this.k = publishViewModel;
        this.l = attributedTextFormatter;
        this.m = categoryParametersConverter;
        this.n = publishAnalyticsDataProvider;
        this.o = analytics;
        this.p = schedulersFactory3;
        this.q = publishDetailsTracker;
        this.r = features;
        List<String> relatedFields = ((MarketPriceSlotConfig) getSlot().getWidget().getConfig()).getRelatedFields();
        this.a = relatedFields == null ? CollectionsKt__CollectionsKt.emptyList() : relatedFields;
        this.d = CollectionsKt__CollectionsKt.emptyList();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.e = compositeDisposable;
        PublishRelay<ConsumeValueChangeResult> create = PublishRelay.create();
        this.f = create;
        f();
        a2.a.a.e2.d0.f.a aVar = new a2.a.a.e2.d0.f.a(this);
        Disposable subscribe = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(q0.b).debounce(800, TimeUnit.MILLISECONDS, schedulersFactory3.computation()).observeOn(schedulersFactory3.mainThread()).subscribe(new a2.a.a.e2.d0.f.b(aVar), m0.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel.paramet…ter\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(q0.c).subscribe(new a2.a.a.e2.d0.f.b(aVar), m0.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "publishViewModel.paramet…ter\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Intrinsics.checkNotNullExpressionValue(create, "slotDataChanges");
        this.g = create;
        this.h = new MarketPriceSlotWrapper$infoPageOpenListener$1(this);
    }

    public static final void access$clearData(MarketPriceSlotWrapper marketPriceSlotWrapper) {
        marketPriceSlotWrapper.b = null;
        marketPriceSlotWrapper.c = null;
    }

    public static final List access$getEmptyDealTypeData(MarketPriceSlotWrapper marketPriceSlotWrapper, MarketPriceResponse marketPriceResponse) {
        Objects.requireNonNull(marketPriceSlotWrapper);
        List<MarketPriceResponse.PriceRange> priceRanges = marketPriceResponse.getPriceRanges();
        if (priceRanges == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = priceRanges.iterator();
        while (it.hasNext()) {
            PriceBadge priceBadge = it.next().getPriceBadge();
            String title = priceBadge != null ? priceBadge.getTitle() : null;
            if (title != null) {
                arrayList.add(title);
            }
        }
        return arrayList;
    }

    public static final void access$inputPriceToPriceParameterIfNeeded(MarketPriceSlotWrapper marketPriceSlotWrapper) {
        MarketPriceResponse.PriceDescription priceDescription;
        PriceParameter c2;
        MarketPriceResponse marketPriceResponse = marketPriceSlotWrapper.b;
        if (marketPriceResponse != null && (priceDescription = marketPriceResponse.getPriceDescription()) != null && (c2 = marketPriceSlotWrapper.c()) != null && marketPriceSlotWrapper.e(c2) == null) {
            c2.setValue(String.valueOf(priceDescription.getPriceHigh()));
        }
    }

    public static final void access$trackSlotData(MarketPriceSlotWrapper marketPriceSlotWrapper) {
        MarketPriceResponse.MarketPrice marketPrice;
        List<MarketPriceResponse.PriceRange> priceRanges;
        Long e2;
        long longValue;
        MarketPriceResponse.PriceRange d2;
        MarketPriceResponse marketPriceResponse = marketPriceSlotWrapper.b;
        if (marketPriceResponse != null && (marketPrice = marketPriceResponse.getMarketPrice()) != null) {
            long price = marketPrice.getPrice();
            MarketPriceResponse marketPriceResponse2 = marketPriceSlotWrapper.b;
            if (marketPriceResponse2 != null && (priceRanges = marketPriceResponse2.getPriceRanges()) != null && (e2 = marketPriceSlotWrapper.e(marketPriceSlotWrapper.c())) != null && (d2 = marketPriceSlotWrapper.d(priceRanges, (longValue = e2.longValue()))) != null) {
                marketPriceSlotWrapper.o.track(new ItemAddImvShieldShowEvent(marketPriceSlotWrapper.n, longValue, price, d2));
            }
        }
    }

    public static /* synthetic */ List b(MarketPriceSlotWrapper marketPriceSlotWrapper, CharSequence charSequence, MarketPriceResponse.PriceRange priceRange, CharSequence charSequence2, int i2) {
        int i3 = i2 & 2;
        int i4 = i2 & 4;
        return marketPriceSlotWrapper.a(charSequence, null, null);
    }

    public final List<Item> a(CharSequence charSequence, MarketPriceResponse.PriceRange priceRange, CharSequence charSequence2) {
        MarketPriceItem.DealTypeBlock dealTypeBlock;
        List<String> list;
        List<String> list2;
        MarketPriceItem.DealTypeImageName dealTypeImageName;
        String id = getId();
        PriceBadge priceBadge = priceRange != null ? priceRange.getPriceBadge() : null;
        if (priceBadge == null) {
            dealTypeBlock = null;
        } else {
            MarketPriceImageName image = priceBadge.getImage();
            if (image != null) {
                int ordinal = image.ordinal();
                if (ordinal == 0) {
                    dealTypeImageName = MarketPriceItem.DealTypeImageName.PERFECT;
                } else if (ordinal == 1) {
                    dealTypeImageName = MarketPriceItem.DealTypeImageName.VERY_GOOD;
                } else if (ordinal == 2) {
                    dealTypeImageName = MarketPriceItem.DealTypeImageName.GOOD;
                } else if (ordinal == 3) {
                    dealTypeImageName = MarketPriceItem.DealTypeImageName.BAD;
                } else if (ordinal == 4) {
                    dealTypeImageName = MarketPriceItem.DealTypeImageName.VERY_BAD;
                } else if (ordinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                dealTypeBlock = new MarketPriceItem.DealTypeBlock(priceBadge.getTitle(), priceBadge.getTitleColor().getValue(), priceBadge.getSubtitle(), dealTypeImageName);
            }
            dealTypeImageName = null;
            dealTypeBlock = new MarketPriceItem.DealTypeBlock(priceBadge.getTitle(), priceBadge.getTitleColor().getValue(), priceBadge.getSubtitle(), dealTypeImageName);
        }
        if (priceRange != null || (list2 = this.c) == null) {
            list = null;
        } else {
            Intrinsics.checkNotNull(list2);
            list = list2;
        }
        return t6.n.d.listOf(new MarketPriceItem(id, charSequence, dealTypeBlock, charSequence2, list));
    }

    public final PriceParameter c() {
        CategoryParameters categoryParameters = this.k.getCategoryParameters();
        PriceParameter priceParameter = null;
        ParameterSlot findParameter = categoryParameters != null ? categoryParameters.findParameter(((MarketPriceSlotConfig) getSlot().getWidget().getConfig()).getPriceId()) : null;
        if (findParameter instanceof PriceParameter) {
            priceParameter = findParameter;
        }
        return priceParameter;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    public void clear() {
        this.e.clear();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    public final MarketPriceResponse.PriceRange d(List<MarketPriceResponse.PriceRange> list, long j2) {
        T t;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            if (j2 < t2.getMin() || j2 > t2.getMax()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t;
    }

    public final Long e(PriceParameter priceParameter) {
        String str;
        if (!(priceParameter == null || (str = (String) priceParameter.getValue()) == null)) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            if (sb2 != null) {
                return l.toLongOrNull(sb2);
            }
        }
        return null;
    }

    public final void f() {
        List<ParameterSlot> parameters;
        Object obj;
        CategoryParameters categoryParameters = this.k.getCategoryParameters();
        if (!(categoryParameters == null || (parameters = categoryParameters.getParameters()) == null)) {
            ArrayList arrayList = new ArrayList();
            for (T t : parameters) {
                if (this.a.contains(t.getId())) {
                    arrayList.add(t);
                }
            }
            String str = null;
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (obj2 instanceof EditableParameter) {
                        arrayList2.add(obj2);
                    }
                }
                if (arrayList2.size() == this.a.size()) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (!((EditableParameter) obj).hasValue()) {
                            break;
                        }
                    }
                    if (obj != null) {
                        this.b = null;
                        this.c = null;
                        this.f.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.MARKET_PRICE));
                        return;
                    }
                }
                ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(String.valueOf(((EditableParameter) it2.next()).getValue()));
                }
                if (!Intrinsics.areEqual(arrayList3, this.d)) {
                    this.d = arrayList3;
                } else {
                    return;
                }
            }
            this.q.startMarketPriceSlotLoading();
            CompositeDisposable compositeDisposable = this.e;
            PublishApi publishApi = this.j;
            Map<String, String> convertToFieldMap = this.m.convertToFieldMap(this.k.getNavigation());
            Map<String, String> convertToFieldMap2 = this.m.convertToFieldMap(parameters);
            ItemBrief item = this.k.getItem();
            if (item != null) {
                str = item.getId();
            }
            Disposable subscribe = publishApi.getMarketPrice(convertToFieldMap, convertToFieldMap2, str, this.n.getSessionId()).subscribeOn(this.p.io()).observeOn(this.p.mainThread()).doOnNext(new a(this)).onErrorReturn(new b(this)).map(c.a).subscribe(new d(this), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "publishApi.getMarketPric…rice\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    @NotNull
    public Observable<ConsumeValueChangeResult> getDataChangesObservable() {
        return this.g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r7 != null) goto L_0x008e;
     */
    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.conveyor_item.Item> getElements() {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.slots.market_price.MarketPriceSlotWrapper.getElements():java.util.List");
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
    public MarketPriceSlot getSlot() {
        return this.i;
    }
}
