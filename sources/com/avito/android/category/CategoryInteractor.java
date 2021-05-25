package com.avito.android.category;

import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.MainSearchResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/category/CategoryInteractor;", "", "Lcom/avito/android/remote/model/Location;", "location", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/MainSearchResult;", "loadMainSearch", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "", "categoryId", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/DeepLinkResponse;", "loadSerpDeeplink", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/category/CategoryInteractorState;", "getState", "()Lcom/avito/android/category/CategoryInteractorState;", "category_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryInteractor {
    @Nullable
    Location getLocation();

    @NotNull
    CategoryInteractorState getState();

    @NotNull
    Observable<MainSearchResult> loadMainSearch(@Nullable Location location);

    @NotNull
    Observable<TypedResult<DeepLinkResponse>> loadSerpDeeplink(@NotNull Location location, @Nullable String str);
}
