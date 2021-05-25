package com.avito.android.extended_profile.adapter.header;

import com.avito.android.public_profile.remote.model.UserProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/public_profile/remote/model/UserProfile;", "", "userKey", "contextId", "Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "toHeaderItem", "(Lcom/avito/android/public_profile/remote/model/UserProfile;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "extended-profile_release"}, k = 2, mv = {1, 4, 2})
public final class HeaderItemKt {
    @NotNull
    public static final HeaderItem toHeaderItem(@NotNull UserProfile userProfile, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(userProfile, "$this$toHeaderItem");
        Intrinsics.checkNotNullParameter(str, "userKey");
        return new HeaderItem(null, null, str, userProfile.getName(), userProfile.getDescription(), userProfile.getAvatar(), userProfile.getRating(), userProfile.getSubscribeInfo(), userProfile.getReplySpeed(), str2, 3, null);
    }
}
