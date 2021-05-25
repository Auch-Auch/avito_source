package com.avito.android.shop.awards.item.action;

import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/shop/awards/item/action/ActionClickProvider;", "", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "Lio/reactivex/rxjava3/core/Observable;", "getClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clickObservable", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ActionClickProvider {
    @NotNull
    Consumer<DeepLink> getClickConsumer();

    @NotNull
    Observable<DeepLink> getClickObservable();
}
