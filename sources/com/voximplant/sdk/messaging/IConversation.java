package com.voximplant.sdk.messaging;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
public interface IConversation {
    void addParticipants(List<ConversationParticipant> list, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void editParticipants(List<ConversationParticipant> list, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    long getCreatedTime();

    Map<String, Object> getCustomData();

    long getLastSequence();

    long getLastUpdateTime();

    List<ConversationParticipant> getParticipants();

    String getTitle();

    String getUUID();

    boolean isDirect();

    boolean isPublicJoin();

    boolean isUber();

    void markAsRead(long j, @Nullable IMessengerCompletionHandler<IConversationServiceEvent> iMessengerCompletionHandler);

    void removeParticipants(List<ConversationParticipant> list, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void retransmitEvents(long j, long j2, @Nullable IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler);

    void retransmitEventsFrom(long j, int i, @Nullable IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler);

    void retransmitEventsTo(long j, int i, @Nullable IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler);

    void sendMessage(String str, @Nullable List<Map<String, Object>> list, @Nullable IMessengerCompletionHandler<IMessageEvent> iMessengerCompletionHandler);

    void setCustomData(Map<String, Object> map);

    void setPublicJoin(boolean z);

    void setTitle(String str);

    void typing(@Nullable IMessengerCompletionHandler<IConversationServiceEvent> iMessengerCompletionHandler);

    void update(@Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);
}
