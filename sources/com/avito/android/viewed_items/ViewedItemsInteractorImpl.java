package com.avito.android.viewed_items;

import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.remote.ViewedItemsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.ViewedItemsResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.viewed_items.model.ViewedItemsModel;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsInteractorImpl;", "Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "", "nextPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/viewed_items/model/ViewedItemsModel;", "getViewedItems", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorites/remote/ViewedItemsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorites/remote/ViewedItemsApi;", "api", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "converter", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/favorites/remote/ViewedItemsApi;Lcom/avito/android/favorites/FavoriteAdvertItemConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsInteractorImpl implements ViewedItemsInteractor {
    public final ViewedItemsApi a;
    public final FavoriteAdvertItemConverter b;
    public final TypedErrorThrowableConverter c;
    public final SchedulersFactory3 d;

    public static final class a<T, R> implements Function<ViewedItemsResponse, LoadingState<? super ViewedItemsModel>> {
        public final /* synthetic */ ViewedItemsInteractorImpl a;

        public a(ViewedItemsInteractorImpl viewedItemsInteractorImpl) {
            this.a = viewedItemsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ViewedItemsModel> apply(ViewedItemsResponse viewedItemsResponse) {
            ViewedItemsResponse viewedItemsResponse2 = viewedItemsResponse;
            return new LoadingState.Loaded(new ViewedItemsModel(viewedItemsResponse2.getNextPage(), this.a.b.convert(viewedItemsResponse2.getFavorites(), null)));
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super ViewedItemsModel>> {
        public final /* synthetic */ ViewedItemsInteractorImpl a;

        public b(ViewedItemsInteractorImpl viewedItemsInteractorImpl) {
            this.a = viewedItemsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ViewedItemsModel> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public ViewedItemsInteractorImpl(@NotNull ViewedItemsApi viewedItemsApi, @NotNull FavoriteAdvertItemConverter favoriteAdvertItemConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedItemsApi, "api");
        Intrinsics.checkNotNullParameter(favoriteAdvertItemConverter, "converter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = viewedItemsApi;
        this.b = favoriteAdvertItemConverter;
        this.c = typedErrorThrowableConverter;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsInteractor
    @NotNull
    public Observable<LoadingState<ViewedItemsModel>> getViewedItems(@Nullable String str) {
        Observable observable;
        if (str != null) {
            observable = TypedObservablesKt.toTyped(this.a.getViewedItemsNextPage(str));
        } else {
            observable = TypedObservablesKt.toTyped(this.a.getViewedItems());
        }
        Observable<LoadingState<ViewedItemsModel>> startWith = observable.map(new a(this)).onErrorReturn(new b(this)).subscribeOn(this.d.io()).startWith(Observable.just(LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "if (nextPage != null) {\n…st(LoadingState.Loading))");
        return startWith;
    }
}
