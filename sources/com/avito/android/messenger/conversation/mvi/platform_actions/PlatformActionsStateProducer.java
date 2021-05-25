package com.avito.android.messenger.conversation.mvi.platform_actions;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "channelData", "", "produce", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)V", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "channelDataId", "reset", "(J)V", "Factory", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformActionsStateProducer<S extends PlatformActionsState> extends MviEntity<S> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003J!\u0010\b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJI\u0010\r\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", ExifInterface.LATITUDE_SOUTH, "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "channelData", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateKey;", "getCompatibleKeys", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)Ljava/util/Set;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "cachedProducers", "createCompatibleProducers", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;Ljava/util/Map;)Ljava/util/Map;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Factory<S extends PlatformActionsState> {
        @NotNull
        Map<Object, PlatformActionsStateProducer<S>> createCompatibleProducers(@NotNull ChannelData channelData, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map);

        @NotNull
        Set<Object> getCompatibleKeys(@NotNull ChannelData channelData);
    }

    void produce(@NotNull ChannelData channelData);

    void reset(long j);
}
