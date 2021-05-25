package com.avito.android.social.button;

import com.avito.android.social.IsSocialNetwork;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/social/button/SocialInfoProvider;", "", "Lcom/avito/android/social/IsSocialNetwork;", "socialManager", "", "isRoundButton", "Lcom/avito/android/social/button/SocialInfo;", "provide", "(Lcom/avito/android/social/IsSocialNetwork;Z)Lcom/avito/android/social/button/SocialInfo;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SocialInfoProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ SocialInfo provide$default(SocialInfoProvider socialInfoProvider, IsSocialNetwork isSocialNetwork, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return socialInfoProvider.provide(isSocialNetwork, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provide");
        }
    }

    @NotNull
    SocialInfo provide(@NotNull IsSocialNetwork isSocialNetwork, boolean z);
}
