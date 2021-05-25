package com.avito.android.publish.slots.anonymous_number;

import a2.a.a.e2.d0.d.a;
import a2.a.a.e2.d0.d.b;
import a2.a.a.e2.d0.d.c;
import a2.a.a.e2.d0.d.e;
import a2.a.a.e2.d0.d.f;
import a2.a.a.e2.d0.d.h;
import a2.a.a.e2.d0.d.i;
import a2.a.a.e2.d0.d.j;
import a2.a.a.e2.d0.d.k;
import a2.a.a.e2.d0.d.l;
import a2.a.a.e2.d0.d.m;
import a2.a.a.e2.d0.d.n;
import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.DeepLinkClicksStreamHolder;
import com.avito.android.publish.slots.ReactiveSlot;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PublishAnonymousNumber;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlot;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlotValue;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004BG\u0012\u0006\u0010A\u001a\u00020\u0002\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\b^\u0010_J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\b\u0012\u0004\u0012\u00020+0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020+098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010A\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R:\u0010D\u001a&\u0012\f\u0012\n B*\u0004\u0018\u00010\t0\t B*\u0012\u0012\f\u0012\n B*\u0004\u0018\u00010\t0\t\u0018\u000109098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010;R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010-\u001a\u0004\bN\u0010/R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006`"}, d2 = {"Lcom/avito/android/publish/slots/anonymous_number/AnonymousNumberSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;", "Lcom/avito/android/publish/slots/DeepLinkClicksStreamHolder;", "Lcom/avito/android/publish/slots/ReactiveSlot;", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "", "clear", "()V", "", "getId", "()Ljava/lang/String;", "", "getElements", "()Ljava/util/List;", "phoneDefault", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/PublishAnonymousNumber;", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "initDisposable", "", "c", "Ljava/util/List;", "relatedFields", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", g.a, "Lio/reactivex/Observable;", "getDeepLinkClicks", "()Lio/reactivex/Observable;", "deepLinkClicks", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "com/avito/android/publish/slots/anonymous_number/AnonymousNumberSlotWrapper$deepLinkClickListener$1", "e", "Lcom/avito/android/publish/slots/anonymous_number/AnonymousNumberSlotWrapper$deepLinkClickListener$1;", "deepLinkClickListener", "Lcom/jakewharton/rxrelay2/PublishRelay;", "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "deepLinksRelay", "j", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;", "slot", "kotlin.jvm.PlatformType", "h", "slotDataChanges", "", "d", "Z", "isAnonymousNumberEnabled", "Lcom/avito/android/remote/PublishApi;", "l", "Lcom/avito/android/remote/PublishApi;", "publishApi", "i", "getDataChangesObservable", "dataChangesObservable", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "p", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "Lcom/avito/android/publish/PublishViewModel;", "k", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "o", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/publish/ContactsDataSource;", "contactsDataSource", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;Lcom/avito/android/publish/ContactsDataSource;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AnonymousNumberSlotWrapper implements SlotWrapper<AnonymousNumberSlot>, DeepLinkClicksStreamHolder, ReactiveSlot {
    public final CompositeDisposable a;
    public Disposable b;
    public final List<String> c;
    public boolean d;
    public AnonymousNumberSlotWrapper$deepLinkClickListener$1 e;
    public final PublishRelay<DeepLink> f;
    @NotNull
    public final Observable<DeepLink> g;
    public final PublishRelay<ConsumeValueChangeResult> h;
    @NotNull
    public final Observable<ConsumeValueChangeResult> i;
    @NotNull
    public final AnonymousNumberSlot j;
    public final PublishViewModel k;
    public final PublishApi l;
    public final CategoryParametersConverter m;
    public final SchedulersFactory3 n;
    public final PublishAnalyticsDataProvider o;
    public final PublishDetailsTracker p;

    public AnonymousNumberSlotWrapper(@NotNull AnonymousNumberSlot anonymousNumberSlot, @NotNull PublishViewModel publishViewModel, @NotNull PublishApi publishApi, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishDetailsTracker publishDetailsTracker, @NotNull ContactsDataSource contactsDataSource) {
        Intrinsics.checkNotNullParameter(anonymousNumberSlot, "slot");
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(contactsDataSource, "contactsDataSource");
        this.j = anonymousNumberSlot;
        this.k = publishViewModel;
        this.l = publishApi;
        this.m = categoryParametersConverter;
        this.n = schedulersFactory3;
        this.o = publishAnalyticsDataProvider;
        this.p = publishDetailsTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        List<String> relatedFields = ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getRelatedFields();
        this.c = relatedFields == null ? d.listOf("phone") : relatedFields;
        this.d = ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getValue() != null;
        this.e = new AnonymousNumberSlotWrapper$deepLinkClickListener$1(this);
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        Observable<DeepLink> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "deepLinksRelay.hide()");
        this.g = hide;
        PublishRelay<ConsumeValueChangeResult> create2 = PublishRelay.create();
        this.h = create2;
        Observable<ConsumeValueChangeResult> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "slotDataChanges.hide()");
        this.i = hide2;
        publishDetailsTracker.startAnonymousNumberSlotLoading();
        Disposable subscribe = InteropKt.toV3(contactsDataSource.prepareContactsData(null)).concatMap(new c(this, contactsDataSource)).subscribeOn(schedulersFactory3.io()).observeOn(schedulersFactory3.mainThread()).subscribe(new a2.a.a.e2.d0.d.d(this), new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "contactsDataSource.prepa…          }\n            )");
        this.b = subscribe;
        Disposable subscribe2 = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(new a2.a.a.e2.d0.d.g(this)).map(h.a).distinctUntilChanged(i.a).subscribe(new j(this), t2.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "publishViewModel.paramet…ter\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = InteropKt.toV3(publishViewModel.getParametersValueChanges()).filter(k.a).map(l.a).distinctUntilChanged(m.a).subscribe(new n(this), t2.b);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "publishViewModel.paramet…nges\", it)\n            })");
        Disposables.plusAssign(compositeDisposable, subscribe3);
    }

    public static void a(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper, String str, int i2) {
        int i3 = i2 & 1;
        CompositeDisposable compositeDisposable = anonymousNumberSlotWrapper.a;
        Disposable subscribe = anonymousNumberSlotWrapper.b(null).observeOn(anonymousNumberSlotWrapper.n.mainThread()).subscribe(new a(anonymousNumberSlotWrapper), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "serviceCheckObservable(p…ber\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$updateAnonymousNumberServiceAvailability(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper, TypedResult typedResult) {
        Objects.requireNonNull(anonymousNumberSlotWrapper);
        boolean z = false;
        if (typedResult instanceof TypedResult.OfResult) {
            PublishAnonymousNumber publishAnonymousNumber = (PublishAnonymousNumber) ((TypedResult.OfResult) typedResult).getResult();
            if (((AnonymousNumberSlotConfig) anonymousNumberSlotWrapper.getSlot().getWidget().getConfig()).getField().getValue() == null) {
                ((AnonymousNumberSlotConfig) anonymousNumberSlotWrapper.getSlot().getWidget().getConfig()).getField().setValue(publishAnonymousNumber instanceof PublishAnonymousNumber.Enabled ? Boolean.valueOf(((PublishAnonymousNumber.Enabled) publishAnonymousNumber).getValue()) : null);
            }
            AnonymousNumberSlotValue value = anonymousNumberSlotWrapper.getSlot().getValue();
            if (value != null) {
                z = value.getRequired();
            }
            boolean z2 = publishAnonymousNumber instanceof PublishAnonymousNumber.Required;
            if (z != z2) {
                anonymousNumberSlotWrapper.getSlot().setValue(new AnonymousNumberSlotValue(z2));
                anonymousNumberSlotWrapper.h.accept(new ConsumeValueChangeResult.NeedValueExpose(SlotType.ANONYMOUS_NUMBER, anonymousNumberSlotWrapper.getSlot()));
            }
            anonymousNumberSlotWrapper.d = publishAnonymousNumber instanceof PublishAnonymousNumber.Enabled;
            return;
        }
        anonymousNumberSlotWrapper.d = false;
    }

    public final io.reactivex.rxjava3.core.Observable<TypedResult<PublishAnonymousNumber>> b(String str) {
        List<ParameterSlot> parametersExceptOwnedBySlots;
        io.reactivex.rxjava3.core.Observable<TypedResult<PublishAnonymousNumber>> observable;
        PhoneParameter phoneParameter;
        CategoryParameters categoryParameters = this.k.getCategoryParameters();
        String str2 = (categoryParameters == null || (phoneParameter = (PhoneParameter) categoryParameters.getFirstParameterOfType(PhoneParameter.class)) == null) ? null : (String) phoneParameter.getValue();
        String str3 = str2 != null ? str2 : str;
        if (str3 != null) {
            CategoryParameters categoryParameters2 = this.k.getCategoryParameters();
            if (categoryParameters2 == null || (parametersExceptOwnedBySlots = categoryParameters2.getParametersExceptOwnedBySlots()) == null) {
                io.reactivex.rxjava3.core.Observable<TypedResult<PublishAnonymousNumber>> empty = io.reactivex.rxjava3.core.Observable.empty();
                Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
                return empty;
            }
            ItemBrief item = this.k.getItem();
            Navigation navigation = this.k.getNavigation();
            Map<String, String> convertToFieldMap = this.m.convertToFieldMap(parametersExceptOwnedBySlots);
            if (item == null) {
                observable = this.l.checkAnonymousNumberPublishV3(str3, this.m.convertToFieldMap(navigation), convertToFieldMap, this.o.getSessionId());
            } else {
                PublishApi publishApi = this.l;
                String id = item.getId();
                String categoryId = item.getCategoryId();
                if (categoryId == null) {
                    categoryId = "";
                }
                observable = publishApi.checkAnonymousNumberEditV3(id, categoryId, this.m.convertToFieldMap(navigation), str3, item.getVersion(), true, convertToFieldMap);
            }
            return a2.b.a.a.a.a2(this.n, observable, "performServiceCheck(\n   …scribeOn(schedulers.io())");
        }
        io.reactivex.rxjava3.core.Observable<TypedResult<PublishAnonymousNumber>> empty2 = io.reactivex.rxjava3.core.Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Observable.empty()");
        return empty2;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    public void clear() {
        this.a.clear();
        this.b.dispose();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        if (!(item instanceof CheckBoxItem) || !Intrinsics.areEqual(((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getId(), item.getStringId())) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        }
        ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().setValue(Boolean.valueOf(((CheckBoxItem) item).isChecked()));
        return new ConsumeValueChangeResult.NeedViewUpdate(SlotType.ANONYMOUS_NUMBER);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    @NotNull
    public Observable<ConsumeValueChangeResult> getDataChangesObservable() {
        return this.i;
    }

    @Override // com.avito.android.publish.slots.DeepLinkClicksStreamHolder
    @NotNull
    public Observable<DeepLink> getDeepLinkClicks() {
        return this.g;
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        ArrayList arrayList = new ArrayList();
        if (this.d && this.b.isDisposed()) {
            AttributedText subtitle = ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getSubtitle();
            if (subtitle != null) {
                subtitle.setOnDeepLinkClickListener(this.e);
            }
            String id = ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getId();
            String title = ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getTitle();
            Boolean bool = (Boolean) ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getValue();
            arrayList.add(new CheckBoxItem(id, title, bool != null ? bool.booleanValue() : false, ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getSubtitle(), null, null, ((AnonymousNumberSlotConfig) getSlot().getWidget().getConfig()).getField().getHeader(), false, 176, null));
        }
        return arrayList;
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
    public AnonymousNumberSlot getSlot() {
        return this.j;
    }
}
