package com.avito.android.search.filter;

import a2.g.r.g;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeItem;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\bG\u0010\u0010RD\u0010\b\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\u000eR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000eR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u000eRD\u0010!\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u001f0\u001f \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0007R(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\"\u0010\f\u0012\u0004\b$\u0010\u0010\u001a\u0004\b#\u0010\u000eR(\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b'\u0010\f\u0012\u0004\b)\u0010\u0010\u001a\u0004\b(\u0010\u000eR(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b+\u0010\f\u0012\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010\u000eR\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103RD\u00106\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u001f0\u001f \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0007R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f0/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00103R(\u0010>\u001a\b\u0012\u0004\u0012\u00020:0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b;\u0010\f\u0012\u0004\b=\u0010\u0010\u001a\u0004\b<\u0010\u000eR(\u0010C\u001a\b\u0012\u0004\u0012\u00020?0\t8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b@\u0010\f\u0012\u0004\bB\u0010\u0010\u001a\u0004\bA\u0010\u000eR\"\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u00101\u001a\u0004\bE\u00103¨\u0006H"}, d2 = {"Lcom/avito/android/search/filter/FiltersChangeProviderImpl;", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/conveyor_item/Item;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "changeRelay", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "e", "Lio/reactivex/rxjava3/functions/Consumer;", "getSelectClearConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "getSelectClearConsumer$annotations", "()V", "selectClearConsumer", "j", "getSelectChangeConsumer", "getSelectChangeConsumer$annotations", "selectChangeConsumer", g.a, "getSelectClickConsumer", "getSelectClickConsumer$annotations", "selectClickConsumer", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "f", "getMultiselectClearConsumer", "getMultiselectClearConsumer$annotations", "multiselectClearConsumer", "Lcom/avito/android/category_parameters/ParameterElement;", "c", "clickRelay", "h", "getMultiselectClickConsumer", "getMultiselectClickConsumer$annotations", "multiselectClickConsumer", "Lcom/avito/android/items/CheckBoxItem;", "d", "getCheckBoxConsumer", "getCheckBoxConsumer$annotations", "checkBoxConsumer", "k", "getMultiselectChangeConsumer", "getMultiselectChangeConsumer$annotations", "multiselectChangeConsumer", "Lio/reactivex/rxjava3/core/Observable;", "n", "Lio/reactivex/rxjava3/core/Observable;", "getClearObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clearObservable", AuthSource.BOOKING_ORDER, "clearRelay", "o", "getClickObservable", "clickObservable", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "i", "getInputItemConsumer", "getInputItemConsumer$annotations", "inputItemConsumer", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeItem;", "l", "getDisplayTypeChangeConsumer", "getDisplayTypeChangeConsumer$annotations", "displayTypeChangeConsumer", AuthSource.OPEN_CHANNEL_LIST, "getChangeObservable", "changeObservable", "<init>", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersChangeProviderImpl implements FiltersChangeProvider {
    public final PublishRelay<Item> a;
    public final PublishRelay<ParameterElement> b;
    public final PublishRelay<ParameterElement> c;
    @NotNull
    public final Consumer<CheckBoxItem> d;
    @NotNull
    public final Consumer<ParameterElement.Select> e;
    @NotNull
    public final Consumer<ParameterElement.Multiselect> f;
    @NotNull
    public final Consumer<ParameterElement.Select> g;
    @NotNull
    public final Consumer<ParameterElement.Multiselect> h;
    @NotNull
    public final Consumer<ParameterElement.Input> i;
    @NotNull
    public final Consumer<ParameterElement.Select> j;
    @NotNull
    public final Consumer<ParameterElement.Multiselect> k;
    @NotNull
    public final Consumer<ChangeDisplayTypeItem> l;
    @NotNull
    public final Observable<Item> m;
    @NotNull
    public final Observable<ParameterElement> n;
    @NotNull
    public final Observable<ParameterElement> o;

    @Inject
    public FiltersChangeProviderImpl() {
        PublishRelay<Item> create = PublishRelay.create();
        this.a = create;
        PublishRelay<ParameterElement> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<ParameterElement> create3 = PublishRelay.create();
        this.c = create3;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.items.CheckBoxItem>");
        this.d = create;
        Objects.requireNonNull(create2, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Select>");
        this.e = create2;
        Objects.requireNonNull(create2, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Multiselect>");
        this.f = create2;
        Objects.requireNonNull(create3, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Select>");
        this.g = create3;
        Objects.requireNonNull(create3, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Multiselect>");
        this.h = create3;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Input>");
        this.i = create;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Select>");
        this.j = create;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.category_parameters.ParameterElement.Multiselect>");
        this.k = create;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.search.filter.adapter.ChangeDisplayTypeItem>");
        this.l = create;
        Observable<Item> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "changeRelay.hide()");
        this.m = hide;
        Observable<ParameterElement> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "clearRelay.hide()");
        this.n = hide2;
        Observable<ParameterElement> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "clickRelay.hide()");
        this.o = hide3;
    }

    public static /* synthetic */ void getCheckBoxConsumer$annotations() {
    }

    public static /* synthetic */ void getDisplayTypeChangeConsumer$annotations() {
    }

    public static /* synthetic */ void getInputItemConsumer$annotations() {
    }

    public static /* synthetic */ void getMultiselectChangeConsumer$annotations() {
    }

    public static /* synthetic */ void getMultiselectClearConsumer$annotations() {
    }

    public static /* synthetic */ void getMultiselectClickConsumer$annotations() {
    }

    public static /* synthetic */ void getSelectChangeConsumer$annotations() {
    }

    public static /* synthetic */ void getSelectClearConsumer$annotations() {
    }

    public static /* synthetic */ void getSelectClickConsumer$annotations() {
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Observable<Item> getChangeObservable() {
        return this.m;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<CheckBoxItem> getCheckBoxConsumer() {
        return this.d;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Observable<ParameterElement> getClearObservable() {
        return this.n;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Observable<ParameterElement> getClickObservable() {
        return this.o;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ChangeDisplayTypeItem> getDisplayTypeChangeConsumer() {
        return this.l;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Input> getInputItemConsumer() {
        return this.i;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Multiselect> getMultiselectChangeConsumer() {
        return this.k;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Multiselect> getMultiselectClearConsumer() {
        return this.f;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Multiselect> getMultiselectClickConsumer() {
        return this.h;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Select> getSelectChangeConsumer() {
        return this.j;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Select> getSelectClearConsumer() {
        return this.e;
    }

    @Override // com.avito.android.search.filter.FiltersChangeProvider
    @NotNull
    public Consumer<ParameterElement.Select> getSelectClickConsumer() {
        return this.g;
    }
}
