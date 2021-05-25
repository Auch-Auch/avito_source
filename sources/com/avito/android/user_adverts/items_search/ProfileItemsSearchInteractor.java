package com.avito.android.user_adverts.items_search;

import android.net.Uri;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.UserAdvertsResult;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\n0\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "", "", "query", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/UserAdvertsResult;", "search", "(Ljava/lang/String;)Lio/reactivex/Single;", "Landroid/net/Uri;", "nextPage", "Lkotlin/Pair;", "", "Lcom/avito/android/remote/model/SerpElement;", "loadMoreItems", "(Landroid/net/Uri;)Lio/reactivex/Single;", "loadSuggests", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileItemsSearchInteractor {
    @NotNull
    Single<Pair<List<SerpElement>, Uri>> loadMoreItems(@NotNull Uri uri);

    @NotNull
    Single<List<String>> loadSuggests(@NotNull String str);

    @NotNull
    Single<UserAdvertsResult> search(@NotNull String str);
}
