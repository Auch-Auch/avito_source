package com.avito.android.rating.publish.select_advert;

import android.net.Uri;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/publish/SearchUserAdvertsResult;", "loadItems", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface SelectAdvertInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadItems$default(SelectAdvertInteractor selectAdvertInteractor, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return selectAdvertInteractor.loadItems(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadItems");
        }
    }

    @NotNull
    Observable<SearchUserAdvertsResult> loadItems(@NotNull Uri uri);

    @NotNull
    Observable<SearchUserAdvertsResult> loadItems(@Nullable String str);
}
