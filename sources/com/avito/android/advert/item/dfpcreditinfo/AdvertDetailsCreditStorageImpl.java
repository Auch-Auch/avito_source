package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorageImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "", ChannelContext.Item.USER_ID, "", "hasSravniUserId", "(Ljava/lang/String;)Z", "", "setSravniUserId", "(Ljava/lang/String;)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsCreditStorageImpl implements AdvertDetailsCreditStorage {
    public final Preferences a;

    @Inject
    public AdvertDetailsCreditStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorage
    public boolean hasSravniUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return Intrinsics.areEqual(this.a.getString(AdvertDetailsCreditStorageKt.KEY_SRAVNI_USER_ID, null), str);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorage
    public void setSravniUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.a.putString(AdvertDetailsCreditStorageKt.KEY_SRAVNI_USER_ID, str);
    }
}
