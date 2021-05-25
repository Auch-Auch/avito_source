package com.voximplant.sdk.messaging;
public interface IMessengerListener {
    void isRead(IConversationServiceEvent iConversationServiceEvent);

    void onCreateConversation(IConversationEvent iConversationEvent);

    void onEditConversation(IConversationEvent iConversationEvent);

    void onEditMessage(IMessageEvent iMessageEvent);

    void onEditUser(IUserEvent iUserEvent);

    void onError(IErrorEvent iErrorEvent);

    void onGetConversation(IConversationEvent iConversationEvent);

    void onGetPublicConversations(IConversationListEvent iConversationListEvent);

    void onGetSubscriptionList(ISubscriptionEvent iSubscriptionEvent);

    void onGetUser(IUserEvent iUserEvent);

    void onRemoveConversation(IConversationEvent iConversationEvent);

    void onRemoveMessage(IMessageEvent iMessageEvent);

    void onRetransmitEvents(IRetransmitEvent iRetransmitEvent);

    void onSendMessage(IMessageEvent iMessageEvent);

    void onSetStatus(IStatusEvent iStatusEvent);

    void onSubscribe(ISubscriptionEvent iSubscriptionEvent);

    void onTyping(IConversationServiceEvent iConversationServiceEvent);

    void onUnsubscribe(ISubscriptionEvent iSubscriptionEvent);
}
