package com.avito.android.shop_settings;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings_select.ShopSettingsSelectResult;
import com.avito.android.util.Observables;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u00106\u001a\u00020\f\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040&\u0012\u0006\u0010>\u001a\u000207\u0012\u0006\u0010G\u001a\u00020\u0019\u0012\u0006\u0010@\u001a\u00020 ¢\u0006\u0004\bK\u0010LJ\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00028\u0006@\u0006¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u0006R\u001f\u0010#\u001a\u00020 8\u0006@\u0006¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u001e\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010.\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b+\u0010,\u0012\u0004\b-\u0010\u001eR\"\u00103\u001a\b\u0012\u0004\u0012\u00020\t0/8\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b0\u00101\u0012\u0004\b2\u0010\u001eR\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\"R%\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006@\u0006¢\u0006\u0012\n\u0004\bA\u0010\u001b\u0012\u0004\bC\u0010\u001e\u001a\u0004\bB\u0010\u0006R\u0016\u0010G\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020 0/8\u0002@\u0002X\u0004¢\u0006\f\n\u0004\bH\u00101\u0012\u0004\bI\u0010\u001e¨\u0006M"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsViewData;", "Landroid/os/Parcelable;", "Lio/reactivex/Observable;", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", PlatformActions.ItemsList.TYPE, "()Lio/reactivex/Observable;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;", "result", "", "handleSelectResult", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;)V", "", "id", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "handleLocationPickerResult", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/shop_settings/ShopSettingsSaveButtonData;", "e", "Lio/reactivex/Observable;", "getSaveButtonDataObservable", "getSaveButtonDataObservable$annotations", "()V", "saveButtonDataObservable", "", "f", "Z", "isSaving", "()Z", "isSaving$annotations", "", "h", "Ljava/util/List;", "topItems", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables$annotations", "disposables", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getItemsUpdateRelay$annotations", "itemsUpdateRelay", g.a, "Ljava/lang/String;", "title", "Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "i", "Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "getSaveButtonItem", "()Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "setSaveButtonItem", "(Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;)V", "saveButtonItem", "k", "isSaveButtonFloating", "d", "getTitleObservable", "getTitleObservable$annotations", "titleObservable", "j", "Lcom/avito/android/shop_settings/ShopSettingsSaveButtonData;", "saveButtonData", AuthSource.BOOKING_ORDER, "getEditableItemsDidChangeRelay$annotations", "editableItemsDidChangeRelay", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;Lcom/avito/android/shop_settings/ShopSettingsSaveButtonData;Z)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsViewData implements Parcelable {
    public static final Parcelable.Creator<ShopSettingsViewData> CREATOR = new Creator();
    public final CompositeDisposable a;
    public final BehaviorRelay<Boolean> b;
    public final BehaviorRelay<Unit> c;
    @NotNull
    public final Observable<String> d;
    @NotNull
    public final Observable<ShopSettingsSaveButtonData> e;
    public final boolean f;
    public final String g;
    public final List<ShopSettingsItem> h;
    @NotNull
    public ShopSettingsSaveButtonItem i;
    public final ShopSettingsSaveButtonData j;
    public final boolean k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsViewData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsViewData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ShopSettingsItem) parcel.readParcelable(ShopSettingsViewData.class.getClassLoader()));
                readInt--;
            }
            return new ShopSettingsViewData(readString, arrayList, ShopSettingsSaveButtonItem.CREATOR.createFromParcel(parcel), ShopSettingsSaveButtonData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsViewData[] newArray(int i) {
            return new ShopSettingsViewData[i];
        }
    }

    public static final class a extends Lambda implements Function1<List<? extends Boolean>, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(List<? extends Boolean> list) {
            List<? extends Boolean> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return Boolean.valueOf(list2.contains(Boolean.TRUE));
        }
    }

    public static final class b<T, R> implements Function<Pair<? extends Unit, ? extends List<? extends ShopSettingsSaveButtonItem>>, List<? extends ShopSettingsItem>> {
        public final /* synthetic */ ShopSettingsViewData a;

        public b(ShopSettingsViewData shopSettingsViewData) {
            this.a = shopSettingsViewData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends ShopSettingsItem> apply(Pair<? extends Unit, ? extends List<? extends ShopSettingsSaveButtonItem>> pair) {
            Pair<? extends Unit, ? extends List<? extends ShopSettingsSaveButtonItem>> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            List list = this.a.h;
            Object second = pair2.getSecond();
            Intrinsics.checkNotNullExpressionValue(second, "it.second");
            return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) second);
        }
    }

    public static final class c<T, R> implements Function<Boolean, List<? extends ShopSettingsSaveButtonItem>> {
        public final /* synthetic */ ShopSettingsViewData a;

        public c(ShopSettingsViewData shopSettingsViewData) {
            this.a = shopSettingsViewData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends ShopSettingsSaveButtonItem> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "didChange");
            return t6.n.d.listOf(ShopSettingsSaveButtonItem.copy$default(this.a.getSaveButtonItem(), null, null, false, bool2.booleanValue(), 7, null));
        }
    }

    public static final class d<T, R> implements Function<Boolean, ShopSettingsSaveButtonData> {
        public final /* synthetic */ ShopSettingsViewData a;

        public d(ShopSettingsViewData shopSettingsViewData) {
            this.a = shopSettingsViewData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShopSettingsSaveButtonData apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "didChange");
            this.a.j.setVisible(bool2.booleanValue() && this.a.k);
            return this.a.j;
        }
    }

    public ShopSettingsViewData(@NotNull String str, @NotNull List<ShopSettingsItem> list, @NotNull ShopSettingsSaveButtonItem shopSettingsSaveButtonItem, @NotNull ShopSettingsSaveButtonData shopSettingsSaveButtonData, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "topItems");
        Intrinsics.checkNotNullParameter(shopSettingsSaveButtonItem, "saveButtonItem");
        Intrinsics.checkNotNullParameter(shopSettingsSaveButtonData, "saveButtonData");
        this.g = str;
        this.h = list;
        this.i = shopSettingsSaveButtonItem;
        this.j = shopSettingsSaveButtonData;
        this.k = z;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.b = createDefault;
        BehaviorRelay<Unit> createDefault2 = BehaviorRelay.createDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(createDefault2, "BehaviorRelay.createDefault(Unit)");
        this.c = createDefault2;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDidChange());
        }
        Disposable subscribe = Observables.combineLatest(arrayList, a.a).distinctUntilChanged().subscribe(this.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "topItems\n            .ma…tableItemsDidChangeRelay)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Observable<String> just = Observable.just(this.g);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        this.d = just;
        Observable<R> map = this.b.map(new d(this));
        Intrinsics.checkNotNullExpressionValue(map, "editableItemsDidChangeRe… saveButtonData\n        }");
        this.e = map;
        this.f = this.j.isLoading() || this.i.isLoading();
    }

    public static /* synthetic */ void getSaveButtonDataObservable$annotations() {
    }

    public static /* synthetic */ void getTitleObservable$annotations() {
    }

    public static /* synthetic */ void isSaving$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Observable<ShopSettingsSaveButtonData> getSaveButtonDataObservable() {
        return this.e;
    }

    @NotNull
    public final ShopSettingsSaveButtonItem getSaveButtonItem() {
        return this.i;
    }

    @NotNull
    public final Observable<String> getTitleObservable() {
        return this.d;
    }

    public final void handleLocationPickerResult(@NotNull String str, @NotNull AddressParameter.Value value) {
        ShopSettingsAddressItem shopSettingsAddressItem;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(value, "result");
        Iterator it = CollectionsKt___CollectionsKt.withIndex(this.h).iterator();
        while (true) {
            shopSettingsAddressItem = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(str, ((ShopSettingsItem) ((IndexedValue) obj).getValue()).getStringId())) {
                break;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null) {
            Object value2 = indexedValue.getValue();
            if (value2 instanceof ShopSettingsAddressItem) {
                shopSettingsAddressItem = value2;
            }
            ShopSettingsAddressItem shopSettingsAddressItem2 = shopSettingsAddressItem;
            if (shopSettingsAddressItem2 != null) {
                ShopSettingsAddressItem copy$default = ShopSettingsAddressItem.copy$default(shopSettingsAddressItem2, null, null, null, null, value.getFormattedLat(), value.getFormattedLng(), null, null, null, false, false, false, null, 8143, null);
                String text = value.getText();
                if (text == null) {
                    text = "";
                }
                copy$default.setCurrentText(text);
                this.h.set(indexedValue.getIndex(), copy$default);
                this.c.accept(Unit.INSTANCE);
                CompositeDisposable compositeDisposable = this.a;
                Disposable subscribe = copy$default.getDidChange().subscribe(this.b);
                Intrinsics.checkNotNullExpressionValue(subscribe, "newItem.didChange.subscr…tableItemsDidChangeRelay)");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public final void handleSelectResult(@NotNull ShopSettingsSelectResult shopSettingsSelectResult) {
        ShopSettingsSelectItem shopSettingsSelectItem;
        Object obj;
        Intrinsics.checkNotNullParameter(shopSettingsSelectResult, "result");
        Iterator it = CollectionsKt___CollectionsKt.withIndex(this.h).iterator();
        while (true) {
            shopSettingsSelectItem = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(shopSettingsSelectResult.getInputId(), ((ShopSettingsItem) ((IndexedValue) obj).getValue()).getStringId())) {
                break;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null) {
            Object value = indexedValue.getValue();
            if (value instanceof ShopSettingsSelectItem) {
                shopSettingsSelectItem = value;
            }
            ShopSettingsSelectItem shopSettingsSelectItem2 = shopSettingsSelectItem;
            if (shopSettingsSelectItem2 != null) {
                ShopSettingsSelectItem copy$default = ShopSettingsSelectItem.copy$default(shopSettingsSelectItem2, null, null, null, null, null, shopSettingsSelectResult.getSelectedId(), shopSettingsSelectResult.getSelectedParentIds(), null, null, null, false, false, false, null, 16287, null);
                copy$default.setCurrentText(shopSettingsSelectResult.getSelectedText());
                this.h.set(indexedValue.getIndex(), copy$default);
                this.c.accept(Unit.INSTANCE);
                CompositeDisposable compositeDisposable = this.a;
                Disposable subscribe = copy$default.getDidChange().subscribe(this.b);
                Intrinsics.checkNotNullExpressionValue(subscribe, "newItem.didChange.subscr…tableItemsDidChangeRelay)");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public final boolean isSaving() {
        return this.f;
    }

    @NotNull
    public final Observable<List<ShopSettingsItem>> itemsList() {
        Observable<R> observable;
        boolean z = this.k;
        if (z) {
            observable = Observable.just(CollectionsKt__CollectionsKt.emptyList());
        } else if (!z) {
            observable = this.b.map(new c(this));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        BehaviorRelay<Unit> behaviorRelay = this.c;
        Intrinsics.checkNotNullExpressionValue(observable, "saveButtonItemSource");
        Observable combineLatest = Observable.combineLatest(behaviorRelay, observable, new BiFunction<T1, T2, R>() { // from class: com.avito.android.shop_settings.ShopSettingsViewData$itemsList$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) TuplesKt.to(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Observable<List<ShopSettingsItem>> map = combineLatest.map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "itemsUpdateRelay\n       … { topItems + it.second }");
        return map;
    }

    public final void setSaveButtonItem(@NotNull ShopSettingsSaveButtonItem shopSettingsSaveButtonItem) {
        Intrinsics.checkNotNullParameter(shopSettingsSaveButtonItem, "<set-?>");
        this.i = shopSettingsSaveButtonItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.g);
        Iterator n0 = a2.b.a.a.a.n0(this.h, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ShopSettingsItem) n0.next(), i2);
        }
        this.i.writeToParcel(parcel, 0);
        this.j.writeToParcel(parcel, 0);
        parcel.writeInt(this.k ? 1 : 0);
    }
}
