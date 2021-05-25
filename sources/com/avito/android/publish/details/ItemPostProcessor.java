package com.avito.android.publish.details;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/publish/details/ItemPostProcessor;", "Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/conveyor_item/Item;", "item", "transform", "(Lcom/avito/conveyor_item/Item;)Lcom/avito/conveyor_item/Item;", "", "update", "(Lcom/avito/conveyor_item/Item;)V", "clear", "()V", "T", AuthSource.SEND_ABUSE, "(Lcom/avito/conveyor_item/Item;)Lcom/avito/android/publish/details/ItemWrapper;", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;", "e", "Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;", "itemWrapperFactory", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getDataChanged", "()Lio/reactivex/Observable;", "dataChanged", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "itemWrapperMap", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "dataChangedRelay", "<init>", "(Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemPostProcessor implements ItemWrapper<Item> {
    public final PublishRelay<Unit> a;
    public Map<String, ItemWrapper<?>> b = new LinkedHashMap();
    public final CompositeDisposable c = new CompositeDisposable();
    @NotNull
    public final Observable<Unit> d;
    public final ItemWrapperFactory e;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ItemPostProcessor a;

        public a(ItemPostProcessor itemPostProcessor) {
            this.a = itemPostProcessor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(Unit.INSTANCE);
        }
    }

    @Inject
    public ItemPostProcessor(@NotNull ItemWrapperFactory itemWrapperFactory) {
        Intrinsics.checkNotNullParameter(itemWrapperFactory, "itemWrapperFactory");
        this.e = itemWrapperFactory;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.d = create;
    }

    public final <T extends Item> ItemWrapper<?> a(T t) {
        ItemWrapper<?> createItemWrapper = this.e.createItemWrapper(t);
        if (createItemWrapper != null) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = createItemWrapper.getDataChanged().subscribe(new a(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "it.dataChanged.subscribe…ccept(Unit)\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        return createItemWrapper;
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    public void clear() {
        Iterator<T> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.c.clear();
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    @NotNull
    public Observable<Unit> getDataChanged() {
        return this.d;
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    @NotNull
    public Item transform(@NotNull Item item) {
        ParameterElement.Video video;
        ItemWrapper<?> a3;
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.b.get(item.getStringId()) == null && (a3 = a(item)) != null) {
            this.b.put(item.getStringId(), a3);
        }
        if (!(item instanceof ParameterElement.Video)) {
            return item;
        }
        ItemWrapper<?> itemWrapper = this.b.get(item.getStringId());
        if (itemWrapper == null) {
            return (ParameterElement.Video) item;
        }
        if (!(itemWrapper instanceof VideoItemWrapper)) {
            itemWrapper = null;
        }
        VideoItemWrapper videoItemWrapper = (VideoItemWrapper) itemWrapper;
        if (videoItemWrapper == null || (video = videoItemWrapper.transform((ParameterElement.Video) item)) == null) {
            video = (ParameterElement.Video) item;
        }
        return video;
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    public void update(@NotNull Item item) {
        ItemWrapper<?> itemWrapper;
        ItemWrapper<?> a3;
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.b.get(item.getStringId()) == null && (a3 = a(item)) != null) {
            this.b.put(item.getStringId(), a3);
        }
        if ((item instanceof ParameterElement.Video) && (itemWrapper = this.b.get(item.getStringId())) != null) {
            if (!(itemWrapper instanceof VideoItemWrapper)) {
                itemWrapper = null;
            }
            VideoItemWrapper videoItemWrapper = (VideoItemWrapper) itemWrapper;
            if (videoItemWrapper != null) {
                videoItemWrapper.update((ParameterElement.Video) item);
            }
        }
    }
}
