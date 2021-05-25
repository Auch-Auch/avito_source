package com.avito.android.user_advert.advert;

import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "", "", "draftId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "loadDraftAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/LoadingState;", "deleteDraft", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyDraftAdvertDetailsInteractor {
    @NotNull
    Single<LoadingState<Object>> deleteDraft(@NotNull String str);

    @NotNull
    Observable<MyAdvertDetails> loadDraftAdvert(@NotNull String str);
}
