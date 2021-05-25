package com.avito.android.advert.actions;

import com.avito.android.remote.model.TypedResult;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005JO\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "advertHiddenEvents", "()Lio/reactivex/rxjava3/core/Observable;", "id", "type", "categoryId", "", "locationId", "feedId", VKApiConst.POSITION, "Lcom/avito/android/remote/model/TypedResult;", "", "markAsHidden", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "", "isHidden", "(Ljava/lang/String;)Z", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface HiddenAdvertsInteractor {
    @NotNull
    Observable<String> advertHiddenEvents();

    boolean isHidden(@NotNull String str);

    @NotNull
    Observable<TypedResult<Unit>> markAsHidden(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i);
}
