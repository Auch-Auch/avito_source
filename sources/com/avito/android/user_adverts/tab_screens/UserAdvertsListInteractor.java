package com.avito.android.user_adverts.tab_screens;

import android.net.Uri;
import android.os.Bundle;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\t2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\t2\u0006\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "", "", "bannerId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "closeUserAdvertsBanner", "(Ljava/lang/String;)Lio/reactivex/Observable;", "shortcut", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/net/Uri;", "loadUserAdverts", "(Ljava/lang/String;)Lio/reactivex/Single;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Single;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsListInteractor {
    @NotNull
    Observable<SuccessResult> closeUserAdvertsBanner(@NotNull String str);

    @NotNull
    Single<Pair<List<SerpElement>, Uri>> loadUserAdverts(@NotNull Uri uri);

    @NotNull
    Single<Pair<List<SerpElement>, Uri>> loadUserAdverts(@NotNull String str);

    @NotNull
    Bundle onSaveState();
}
