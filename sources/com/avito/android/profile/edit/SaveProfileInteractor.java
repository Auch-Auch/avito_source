package com.avito.android.profile.edit;

import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/edit/SaveProfileInteractor;", "", "", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "items", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "saveProfile", "(Ljava/util/Map;)Lio/reactivex/Observable;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SaveProfileInteractor {
    @NotNull
    Observable<ProfileSavingResult> saveProfile(@NotNull Map<Long, ? extends EditProfileItem> map);
}
