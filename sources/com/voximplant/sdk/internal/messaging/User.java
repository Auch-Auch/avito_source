package com.voximplant.sdk.internal.messaging;

import a2.b.a.a.a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.messaging.IUser;
import com.voximplant.sdk.messaging.MessengerNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class User implements IUser {
    @SerializedName("conversations_list")
    @Expose
    private List<String> mConversationList;
    @SerializedName("custom_data")
    @Expose
    private Map<String, Object> mCustomData;
    @SerializedName("deleted")
    private Boolean mDeleted;
    @SerializedName("display_name")
    private String mDisplayName;
    @SerializedName("leave_conversations")
    private List<String> mLeaveConversationList;
    @SerializedName("notification_events")
    private List<String> mMessengerNotifications;
    @SerializedName("private_custom_data")
    @Expose
    private Map<String, Object> mPrivateCustomData;
    @SerializedName("@type")
    @Expose
    private String mType;
    @SerializedName("user_id")
    @Expose
    private Long mUserId;
    @SerializedName("user_name")
    @Expose
    private String mUserName = null;

    public User(String str, String str2) {
        this.mUserName = str;
        this.mType = str2;
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public List<String> getConversationList() {
        if (this.mConversationList != null || !SharedData.getUser().equals(this.mUserName)) {
            return this.mConversationList;
        }
        return new ArrayList();
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public Map<String, Object> getCustomData() {
        return this.mCustomData;
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public String getDisplayName() {
        return this.mDisplayName;
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public long getIMId() {
        Long l = this.mUserId;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public List<String> getLeaveConversationList() {
        if (this.mLeaveConversationList != null || !SharedData.getUser().equals(this.mUserName)) {
            return this.mLeaveConversationList;
        }
        return new ArrayList();
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public String getName() {
        return this.mUserName;
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public List<MessengerNotification> getNotifications() {
        if (this.mMessengerNotifications == null && SharedData.getUser().equals(this.mUserName)) {
            return new ArrayList();
        }
        List<String> list = this.mMessengerNotifications;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.hashCode();
            if (str.equals("onEditMessage")) {
                arrayList.add(MessengerNotification.ON_EDIT_MESSAGE);
            } else if (str.equals("onSendMessage")) {
                arrayList.add(MessengerNotification.ON_SEND_MESSAGE);
            }
        }
        return arrayList;
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public Map<String, Object> getPrivateCustomData() {
        if (this.mPrivateCustomData != null || !SharedData.getUser().equals(this.mUserName)) {
            return this.mPrivateCustomData;
        }
        return new HashMap();
    }

    @Override // com.voximplant.sdk.messaging.IUser
    public boolean isDeleted() {
        Boolean bool = this.mDeleted;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public String toString() {
        StringBuilder L = a.L("User [userId = ");
        L.append(this.mUserName);
        L.append(", custom data = ");
        L.append(this.mCustomData);
        L.append(", private custom data = ");
        L.append(this.mPrivateCustomData);
        L.append(", conversation list = ");
        return a.w(L, this.mConversationList, "]");
    }

    public User(long j, String str) {
        this.mUserId = Long.valueOf(j);
        this.mType = str;
    }

    public User(Map<String, Object> map, Map<String, Object> map2, String str) {
        this.mCustomData = map;
        this.mPrivateCustomData = map2;
        this.mType = str;
    }
}
