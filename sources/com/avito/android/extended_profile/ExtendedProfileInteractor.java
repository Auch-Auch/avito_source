package com.avito.android.extended_profile;

import com.avito.android.extended_profile.data.CategoryData;
import com.avito.android.extended_profile.data.ExtendedProfileDataItem;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.util.LoadingState;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ3\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\tJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "loadPublicUserProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/extended_profile/data/ExtendedProfileDataItem;", "loadExtendedProfile", ShareConstants.MEDIA_URI, "Lcom/avito/android/extended_profile/data/CategoryData;", "category", "loadNextPage", "(Ljava/lang/String;Lcom/avito/android/extended_profile/data/CategoryData;)Lio/reactivex/rxjava3/core/Observable;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileInteractor {
    @NotNull
    Observable<LoadingState<List<? extends ExtendedProfileDataItem>>> loadExtendedProfile(@NotNull String str, @Nullable String str2);

    @NotNull
    Observable<LoadingState<CategoryData>> loadNextPage(@NotNull String str, @NotNull CategoryData categoryData);

    @NotNull
    Observable<LoadingState<PublicUserProfile>> loadPublicUserProfile(@NotNull String str, @Nullable String str2);
}
