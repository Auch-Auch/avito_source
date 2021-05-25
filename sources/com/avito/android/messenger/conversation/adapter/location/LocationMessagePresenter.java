package com.avito.android.messenger.conversation.adapter.location;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/LocationMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "c", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "googleApiKey", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "d", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "yandexApiKey", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocationMessagePresenter implements ItemPresenter<LocationMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final GoogleApiKey c;
    public final YandexApiKey d;
    public final Features e;

    public LocationMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull GoogleApiKey googleApiKey, @NotNull YandexApiKey yandexApiKey, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = googleApiKey;
        this.d = yandexApiKey;
        this.e = features;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x036e, code lost:
        if (r2 != null) goto L_0x0491;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.adapter.location.LocationMessageView r32, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.ChannelItem.Message r33, int r34) {
        /*
        // Method dump skipped, instructions count: 1236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.adapter.location.LocationMessagePresenter.bindView(com.avito.android.messenger.conversation.adapter.location.LocationMessageView, com.avito.android.messenger.conversation.ChannelItem$Message, int):void");
    }
}
