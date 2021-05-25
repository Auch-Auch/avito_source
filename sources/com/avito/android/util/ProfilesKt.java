package com.avito.android.util;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.ProfileInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/Profile;", "Lcom/avito/android/remote/model/ProfileInfo;", "toProfileInfo", "(Lcom/avito/android/remote/model/Profile;)Lcom/avito/android/remote/model/ProfileInfo;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class ProfilesKt {
    @NotNull
    public static final ProfileInfo toProfileInfo(@NotNull Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "$this$toProfileInfo");
        String userId = profile.getUserId();
        String name = profile.getName();
        String email = profile.getEmail();
        Image avatar = profile.getAvatar();
        return new ProfileInfo(userId, name, email, avatar != null ? Images.maxSize(avatar) : null);
    }
}
