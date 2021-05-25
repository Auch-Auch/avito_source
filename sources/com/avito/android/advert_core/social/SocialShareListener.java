package com.avito.android.advert_core.social;

import com.avito.android.social.SharingManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert_core/social/SocialShareListener;", "", "Lcom/avito/android/social/SharingManager;", "socialManager", "", "isAuthorized", "", "onSocialShare", "(Lcom/avito/android/social/SharingManager;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface SocialShareListener {
    void onSocialShare(@NotNull SharingManager sharingManager, boolean z);
}
