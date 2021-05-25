package com.avito.android.public_profile.ui;

import com.avito.android.public_profile.remote.model.SubscribeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "", "onSubscribeInfoChanged", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface SubscriptionStateListener {
    void onSubscribeInfoChanged(@Nullable SubscribeInfo subscribeInfo);
}
