package com.avito.android.account;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/account/LastUserStorage;", "", "", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface LastUserStorage {
    @Nullable
    String getUserId();
}
