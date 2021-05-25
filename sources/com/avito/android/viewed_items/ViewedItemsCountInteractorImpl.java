package com.avito.android.viewed_items;

import a2.a.a.t3.a;
import a2.a.a.t3.b;
import a2.a.a.t3.c;
import com.avito.android.favorites.remote.ViewedItemsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsCountInteractorImpl;", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "getViewedItemsCount", "()Lio/reactivex/rxjava3/core/Observable;", "", "resetCount", "()V", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "counterRelay", "Lcom/avito/android/favorites/remote/ViewedItemsApi;", "c", "Lcom/avito/android/favorites/remote/ViewedItemsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.BOOKING_ORDER, "Z", "countWasLoadedInCurrentSession", "<init>", "(Lcom/avito/android/favorites/remote/ViewedItemsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsCountInteractorImpl implements ViewedItemsCountInteractor {
    public final BehaviorRelay<Integer> a;
    public boolean b;
    public final ViewedItemsApi c;
    public final SchedulersFactory3 d;

    @Inject
    public ViewedItemsCountInteractorImpl(@NotNull ViewedItemsApi viewedItemsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedItemsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.c = viewedItemsApi;
        this.d = schedulersFactory3;
        BehaviorRelay<Integer> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsCountInteractor
    @NotNull
    public Observable<Integer> getViewedItemsCount() {
        if (!this.b) {
            this.b = true;
            TypedObservablesKt.toTyped(this.c.getViewedItemsCount()).map(a.a).onErrorResumeNext(b.a).subscribeOn(this.d.io()).doOnNext(new c(this)).subscribe();
        }
        return this.a;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsCountInteractor
    public void resetCount() {
        this.a.accept(0);
    }
}
