package com.avito.android.search.map.provider;

import com.avito.android.floating_views.BaseFloatingViewsPresenterImpl;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "Lcom/avito/android/floating_views/BaseFloatingViewsPresenterImpl;", "Lio/reactivex/rxjava3/core/Observable;", "", "visibilityChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "show", "()V", "hide", "Lcom/jakewharton/rxrelay3/Relay;", "d", "Lcom/jakewharton/rxrelay3/Relay;", "relay", "<init>", "map_release"}, k = 1, mv = {1, 4, 2})
public final class PublishFloatingViewsProvider extends BaseFloatingViewsPresenterImpl {
    public final Relay<Boolean> d;

    public PublishFloatingViewsProvider() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.d = create;
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void hide() {
        this.d.accept(Boolean.FALSE);
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void show() {
        this.d.accept(Boolean.TRUE);
    }

    @NotNull
    public final Observable<Boolean> visibilityChanges() {
        return this.d;
    }
}
