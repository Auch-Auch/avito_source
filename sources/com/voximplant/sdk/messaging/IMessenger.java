package com.voximplant.sdk.messaging;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
public interface IMessenger {
    void addMessengerListener(IMessengerListener iMessengerListener);

    void createConversation(ConversationConfig conversationConfig, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void editUser(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler);

    void getConversation(String str, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void getConversations(List<String> list, @Nullable IMessengerCompletionHandler<List<IConversationEvent>> iMessengerCompletionHandler);

    String getMe();

    void getPublicConversations(@Nullable IMessengerCompletionHandler<IConversationListEvent> iMessengerCompletionHandler);

    void getSubscriptionList(@Nullable IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler);

    void getUser(long j, @Nullable IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler);

    void getUser(String str, @Nullable IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler);

    void getUsersByIMId(List<Long> list, @Nullable IMessengerCompletionHandler<List<IUserEvent>> iMessengerCompletionHandler);

    void getUsersByName(List<String> list, @Nullable IMessengerCompletionHandler<List<IUserEvent>> iMessengerCompletionHandler);

    void joinConversation(String str, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void leaveConversation(String str, @Nullable IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler);

    void managePushNotifications(List<MessengerNotification> list, @Nullable IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler);

    IConversation recreateConversation(ConversationConfig conversationConfig, String str, long j, long j2, long j3);

    IMessage recreateMessage(String str, String str2, String str3, List<Map<String, Object>> list, long j);

    void removeMessengerListener(IMessengerListener iMessengerListener);

    void setStatus(boolean z, @Nullable IMessengerCompletionHandler<IStatusEvent> iMessengerCompletionHandler);

    void subscribe(List<Long> list, @Nullable IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler);

    void unsubscribe(List<Long> list, @Nullable IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler);

    void unsubscribeFromAll(@Nullable IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler);
}
