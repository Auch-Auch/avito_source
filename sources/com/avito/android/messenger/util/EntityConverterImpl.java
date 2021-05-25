package com.avito.android.messenger.util;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.messenger.util.EntityConverter;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ChannelUser;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/util/EntityConverterImpl;", "Lcom/avito/android/messenger/util/EntityConverter;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class EntityConverterImpl implements EntityConverter {
    @Override // com.avito.android.messenger.util.EntityConverter
    @Nullable
    public Image toRemoteImage(@NotNull ru.avito.messenger.api.entity.Image image) {
        Intrinsics.checkNotNullParameter(image, "$this$toRemoteImage");
        return EntityConverter.DefaultImpls.toRemoteImage(this, image);
    }

    @Override // com.avito.android.messenger.util.EntityConverter
    @NotNull
    public User toRemoteUser(@NotNull ChannelUser channelUser, @NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(channelUser, "$this$toRemoteUser");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        return EntityConverter.DefaultImpls.toRemoteUser(this, channelUser, deepLinkFactory);
    }
}
