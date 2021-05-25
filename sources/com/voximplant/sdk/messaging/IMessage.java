package com.voximplant.sdk.messaging;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
public interface IMessage {
    String getConversation();

    List<Map<String, Object>> getPayload();

    long getSequence();

    String getText();

    String getUUID();

    void remove(@Nullable IMessengerCompletionHandler<IMessageEvent> iMessengerCompletionHandler);

    void update(@Nullable String str, @Nullable List<Map<String, Object>> list, @Nullable IMessengerCompletionHandler<IMessageEvent> iMessengerCompletionHandler);
}
