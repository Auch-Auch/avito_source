package com.avito.android.publish.edit_advert_request.data;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.EditAdvertResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JO\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", "", "", "itemId", "categoryId", "Lcom/avito/android/remote/model/Navigation;", "navigation", "version", "postAction", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "editAdvert", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface EditAdvertRepository {
    @NotNull
    Observable<TypedResult<EditAdvertResult>> editAdvert(@NotNull String str, @NotNull String str2, @NotNull Navigation navigation, @Nullable String str3, @Nullable String str4, @NotNull CategoryParameters categoryParameters);
}
