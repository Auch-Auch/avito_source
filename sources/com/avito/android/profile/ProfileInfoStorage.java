package com.avito.android.profile;

import com.avito.android.remote.model.ProfileInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/ProfileInfoStorage;", "", "Lcom/avito/android/remote/model/ProfileInfo;", "getProfileInfo", "()Lcom/avito/android/remote/model/ProfileInfo;", "profileInfo", "profile-info_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileInfoStorage {
    @NotNull
    ProfileInfo getProfileInfo();
}
