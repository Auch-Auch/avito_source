package com.avito.android.user_adverts.items_search;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.UserAdvertsResult;
import com.avito.android.remote.model.UserSearchSuggests;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\n0\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractorImpl;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "", "query", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/UserAdvertsResult;", "search", "(Ljava/lang/String;)Lio/reactivex/Single;", "Landroid/net/Uri;", "nextPage", "Lkotlin/Pair;", "", "Lcom/avito/android/remote/model/SerpElement;", "loadMoreItems", "(Landroid/net/Uri;)Lio/reactivex/Single;", "loadSuggests", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/user_adverts/remote/UserAdvertsApi;Lcom/avito/android/util/SchedulersFactory;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchInteractorImpl implements ProfileItemsSearchInteractor {
    public final UserAdvertsApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<UserAdvertsResult, Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends List<? extends SerpElement>, ? extends Uri> apply(UserAdvertsResult userAdvertsResult) {
            UserAdvertsResult userAdvertsResult2 = userAdvertsResult;
            Intrinsics.checkNotNullParameter(userAdvertsResult2, "it");
            return TuplesKt.to(userAdvertsResult2.getList(), userAdvertsResult2.getNextPage());
        }
    }

    public static final class b<T, R> implements Function<UserSearchSuggests, List<? extends String>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends String> apply(UserSearchSuggests userSearchSuggests) {
            UserSearchSuggests userSearchSuggests2 = userSearchSuggests;
            Intrinsics.checkNotNullParameter(userSearchSuggests2, "it");
            return userSearchSuggests2.getSuggests();
        }
    }

    @Inject
    public ProfileItemsSearchInteractorImpl(@NotNull UserAdvertsApi userAdvertsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(userAdvertsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = userAdvertsApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractor
    @NotNull
    public Single<Pair<List<SerpElement>, Uri>> loadMoreItems(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        String uri2 = uri.buildUpon().appendQueryParameter("isRedesign", "1").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.buildUpon()\n   …)\n            .toString()");
        return a2.b.a.a.a.V1(this.b, TypedSingleKt.toTyped(InteropKt.toV2(this.a.getNextUserAdverts(uri2))).map(a.a), "api.getNextUserAdverts(n…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractor
    @NotNull
    public Single<List<String>> loadSuggests(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return a2.b.a.a.a.V1(this.b, TypedSingleKt.toTyped(InteropKt.toV2(this.a.getSearchSuggest(str))).map(b.a), "api.getSearchSuggest(que…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractor
    @NotNull
    public Single<UserAdvertsResult> search(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return a2.b.a.a.a.V1(this.b, TypedSingleKt.toTyped(InteropKt.toV2(this.a.searchUserAdverts(str))), "api.searchUserAdverts(qu…scribeOn(schedulers.io())");
    }
}
