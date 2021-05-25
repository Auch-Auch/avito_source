package com.voximplant.sdk.messaging;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
public interface IUser {
    @Nullable
    List<String> getConversationList();

    Map<String, Object> getCustomData();

    String getDisplayName();

    long getIMId();

    @Nullable
    List<String> getLeaveConversationList();

    String getName();

    @Nullable
    List<MessengerNotification> getNotifications();

    @Nullable
    Map<String, Object> getPrivateCustomData();

    boolean isDeleted();
}
