package com.avito.android.messenger.channels.mvi.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a$\u0010\u0004\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "", "jsonBody", "deserialize", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;Ljava/lang/String;)Ljava/lang/Object;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelPropertySerializerKt {
    public static final /* synthetic */ <T> T deserialize(ChannelPropertySerializer channelPropertySerializer, String str) {
        Intrinsics.checkNotNullParameter(channelPropertySerializer, "$this$deserialize");
        Intrinsics.checkNotNullParameter(str, "jsonBody");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) channelPropertySerializer.deserialize(Object.class, str);
    }
}
