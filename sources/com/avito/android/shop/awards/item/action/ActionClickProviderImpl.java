package com.avito.android.shop.awards.item.action;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rRD\u0010\u0014\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00030\u0003 \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u000f¢\u0006\u0002\b\u00110\u000f¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop/awards/item/action/ActionClickProviderImpl;", "Lcom/avito/android/shop/awards/item/action/ActionClickProvider;", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/functions/Consumer;", "getClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "Lio/reactivex/rxjava3/core/Observable;", "c", "Lio/reactivex/rxjava3/core/Observable;", "getClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clickObservable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "clickRelay", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ActionClickProviderImpl implements ActionClickProvider {
    public final PublishRelay<DeepLink> a;
    @NotNull
    public final Consumer<DeepLink> b;
    @NotNull
    public final Observable<DeepLink> c;

    @Inject
    public ActionClickProviderImpl() {
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Objects.requireNonNull(create, "null cannot be cast to non-null type io.reactivex.rxjava3.functions.Consumer<com.avito.android.deep_linking.links.DeepLink>");
        this.b = create;
        Observable<DeepLink> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "clickRelay.hide()");
        this.c = hide;
    }

    @Override // com.avito.android.shop.awards.item.action.ActionClickProvider
    @NotNull
    public Consumer<DeepLink> getClickConsumer() {
        return this.b;
    }

    @Override // com.avito.android.shop.awards.item.action.ActionClickProvider
    @NotNull
    public Observable<DeepLink> getClickObservable() {
        return this.c;
    }
}
