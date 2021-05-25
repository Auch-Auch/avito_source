package com.avito.android.social;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/social/SocialTypeToStringMapper;", "", "", "socialType", "Lcom/avito/android/social/SocialType;", "mapToSocialType", "(Ljava/lang/String;)Lcom/avito/android/social/SocialType;", "type", "mapToString", "(Lcom/avito/android/social/SocialType;)Ljava/lang/String;", "mapToStringOrNull", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SocialTypeToStringMapper {
    @Nullable
    SocialType mapToSocialType(@Nullable String str);

    @NotNull
    String mapToString(@Nullable SocialType socialType);

    @Nullable
    String mapToStringOrNull(@Nullable SocialType socialType);
}
