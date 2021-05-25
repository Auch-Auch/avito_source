package com.voximplant.sdk.internal.messaging;

import a2.b.a.a.a;
import a2.t.a.c.q0.i0;
import a2.t.a.c.q0.j0;
import a2.t.a.c.q0.p0;
import a2.t.a.c.q0.t;
import a2.t.a.c.q0.x;
import a2.t.a.c.q0.z;
import com.avito.android.remote.model.ProfileTab;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.proto.MES_getConversations;
import com.voximplant.sdk.internal.proto.MES_getPublicConversations;
import com.voximplant.sdk.internal.proto.MES_setStatus;
import com.voximplant.sdk.internal.proto.M_manageNotification;
import com.voximplant.sdk.messaging.ConversationConfig;
import com.voximplant.sdk.messaging.IConversation;
import com.voximplant.sdk.messaging.IConversationEvent;
import com.voximplant.sdk.messaging.IConversationListEvent;
import com.voximplant.sdk.messaging.IMessage;
import com.voximplant.sdk.messaging.IMessenger;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.IMessengerListener;
import com.voximplant.sdk.messaging.IStatusEvent;
import com.voximplant.sdk.messaging.ISubscriptionEvent;
import com.voximplant.sdk.messaging.IUserEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
public class Messenger implements IMessenger {
    public p0 a = p0.h();

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void addMessengerListener(IMessengerListener iMessengerListener) {
        Logger.i("Messenger: addMessengerListener: " + iMessengerListener);
        p0 p0Var = this.a;
        Objects.requireNonNull(p0Var);
        if (iMessengerListener == null) {
            Logger.e("MessengerManager: addMessengerListener: listener is null");
        } else if (!p0Var.d.contains(iMessengerListener)) {
            p0Var.d.add(iMessengerListener);
        } else {
            Logger.w("MessengerManager: addMessengerListener: listener: " + iMessengerListener + " has been already added");
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void createConversation(ConversationConfig conversationConfig, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: createConversation");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.CREATE_CONVERSATION;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (conversationConfig == null || (conversationConfig.getParticipants() != null && this.a.c(conversationConfig.getParticipants()))) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            Conversation conversation = new Conversation(conversationConfig, "type/vox.store.IncomingNamespace.CreateConversation");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new t(p0Var2, messengerAction, iMessengerCompletionHandler, conversation));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void editUser(Map<String, Object> map, Map<String, Object> map2, IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: editUser");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.EDIT_USER;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (map == null && map2 == null) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            User user = new User(map, map2, "type/vox.store.IncomingNamespace.EditUser");
            p0 p0Var = this.a;
            p0Var.c.execute(new j0(p0Var, messengerAction, iMessengerCompletionHandler, user));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getConversation(String str, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: getConversation");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_CONVERSATION;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (str == null || str.isEmpty()) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("@type", "type/vox.store.IncomingNamespace.GetConversation");
            hashMap.put("uuid", str);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new x(p0Var2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getConversations(List<String> list, IMessengerCompletionHandler<List<IConversationEvent>> iMessengerCompletionHandler) {
        Logger.i("Messenger: getConversations");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_CONVERSATIONS;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (this.a.d(list)) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", list);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.GetConversations");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new Runnable(messengerAction, iMessengerCompletionHandler, list.size(), hashMap) { // from class: a2.t.a.c.q0.j
                public final /* synthetic */ MessengerAction b;
                public final /* synthetic */ IMessengerCompletionHandler c;
                public final /* synthetic */ int d;
                public final /* synthetic */ Map e;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                    this.e = r5;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p0 p0Var3 = p0.this;
                    MessengerAction messengerAction2 = this.b;
                    IMessengerCompletionHandler<List<IConversationEvent>> iMessengerCompletionHandler2 = this.c;
                    int i = this.d;
                    Map map = this.e;
                    Objects.requireNonNull(p0Var3);
                    String uuid = UUID.randomUUID().toString();
                    p0Var3.m.put(uuid, messengerAction2);
                    if (iMessengerCompletionHandler2 != null) {
                        p0Var3.i.put(uuid, iMessengerCompletionHandler2);
                        p0Var3.j.put(uuid, new ArrayList());
                        p0Var3.k.put(uuid, Integer.valueOf(i));
                    }
                    p0Var3.g(uuid, MessengerAction.GET_CONVERSATIONS);
                    p0Var3.e.add(new MES_getConversations(uuid, map));
                }
            });
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public String getMe() {
        return SharedData.getUser();
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getPublicConversations(IMessengerCompletionHandler<IConversationListEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: getPublicConversations");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_PUBLIC_CONVERSATIONS;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            HashMap k0 = a.k0("@type", "type/vox.store.IncomingNamespace.GetConversations");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new Runnable(messengerAction, iMessengerCompletionHandler, k0) { // from class: a2.t.a.c.q0.b0
                public final /* synthetic */ MessengerAction b;
                public final /* synthetic */ IMessengerCompletionHandler c;
                public final /* synthetic */ Map d;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p0 p0Var3 = p0.this;
                    MessengerAction messengerAction2 = this.b;
                    IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler2 = this.c;
                    Map map = this.d;
                    Objects.requireNonNull(p0Var3);
                    String uuid = UUID.randomUUID().toString();
                    p0Var3.m.put(uuid, messengerAction2);
                    if (iMessengerCompletionHandler2 != null) {
                        p0Var3.g.put(uuid, iMessengerCompletionHandler2);
                    }
                    p0Var3.g(uuid, messengerAction2);
                    p0Var3.e.add(new MES_getPublicConversations(uuid, map));
                }
            });
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getSubscriptionList(IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: getSubscriptionList");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_SUBSCRIPTION_LIST;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            HashMap k0 = a.k0("@type", "type/vox.store.IncomingNamespace.GetSubscriptionList");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new i0(p0Var2, messengerAction, iMessengerCompletionHandler, k0));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getUser(String str, IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: getUser (by name)");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_USER;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (str == null || str.isEmpty()) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            User user = new User(str, "type/vox.store.IncomingNamespace.GetUser");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new j0(p0Var2, messengerAction, iMessengerCompletionHandler, user));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getUsersByIMId(List<Long> list, IMessengerCompletionHandler<List<IUserEvent>> iMessengerCompletionHandler) {
        Logger.i("Messenger: getUsersById");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_USERS;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (this.a.e(list)) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap k0 = a.k0("@type", "type/vox.store.IncomingNamespace.GetUsers");
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", l);
                arrayList.add(hashMap);
            }
            k0.put("users", arrayList);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new z(p0Var2, iMessengerCompletionHandler, list.size(), k0));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getUsersByName(List<String> list, IMessengerCompletionHandler<List<IUserEvent>> iMessengerCompletionHandler) {
        Logger.i("Messenger: getUsersByName");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_USERS;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (this.a.d(list)) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap k0 = a.k0("@type", "type/vox.store.IncomingNamespace.GetUsers");
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("user_name", str);
                arrayList.add(hashMap);
            }
            k0.put("users", arrayList);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new z(p0Var2, iMessengerCompletionHandler, list.size(), k0));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void joinConversation(String str, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: joinConversation");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.JOIN_CONVERSATION;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (str == null || str.isEmpty()) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", str);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.JoinConversation");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new x(p0Var2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void leaveConversation(String str, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: leaveConversation");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.LEAVE_CONVERSATION;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (str == null || str.isEmpty()) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", str);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.LeaveConversation");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new x(p0Var2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void managePushNotifications(List<MessengerNotification> list, IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler) {
        ArrayList arrayList;
        Logger.i("Messenger: managePushNotifications");
        if (!this.a.f(MessengerAction.MANAGE_NOTIFICATIONS, iMessengerCompletionHandler)) {
            HashMap k0 = a.k0("@type", "type/vox.store.IncomingNamespace.ManageNotifications");
            if (list == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (MessengerNotification messengerNotification : list) {
                    int ordinal = messengerNotification.ordinal();
                    if (ordinal == 0) {
                        arrayList2.add("onEditMessage");
                    } else if (ordinal == 1) {
                        arrayList2.add("onSendMessage");
                    }
                }
                arrayList = arrayList2;
            }
            k0.put("notifications", arrayList);
            p0 p0Var = this.a;
            p0Var.c.execute(new Runnable(MessengerAction.MANAGE_NOTIFICATIONS, iMessengerCompletionHandler, k0) { // from class: a2.t.a.c.q0.l
                public final /* synthetic */ MessengerAction b;
                public final /* synthetic */ IMessengerCompletionHandler c;
                public final /* synthetic */ Map d;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p0 p0Var2 = p0.this;
                    MessengerAction messengerAction = this.b;
                    IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler2 = this.c;
                    Map map = this.d;
                    Objects.requireNonNull(p0Var2);
                    String uuid = UUID.randomUUID().toString();
                    p0Var2.m.put(uuid, messengerAction);
                    p0Var2.g(uuid, messengerAction);
                    if (iMessengerCompletionHandler2 != null) {
                        p0Var2.g.put(uuid, iMessengerCompletionHandler2);
                    }
                    if (messengerAction == MessengerAction.MANAGE_NOTIFICATIONS) {
                        p0Var2.e.add(new M_manageNotification(uuid, map));
                        return;
                    }
                    Logger.e("MessengerManager: processUserCommand:  Unknown action type");
                }
            });
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public IConversation recreateConversation(ConversationConfig conversationConfig, String str, long j, long j2, long j3) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new Conversation(conversationConfig, str, j, j2, j3);
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public IMessage recreateMessage(String str, String str2, String str3, List<Map<String, Object>> list, long j) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return null;
        }
        return new Message(str, str2, str3, list, j);
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void removeMessengerListener(IMessengerListener iMessengerListener) {
        Logger.i("Messenger: removeMessengerListener: " + iMessengerListener);
        p0 p0Var = this.a;
        Objects.requireNonNull(p0Var);
        if (iMessengerListener != null) {
            p0Var.d.remove(iMessengerListener);
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void setStatus(boolean z, IMessengerCompletionHandler<IStatusEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: setStatus");
        if (!this.a.f(MessengerAction.SET_STATUS, iMessengerCompletionHandler)) {
            HashMap k0 = a.k0("@type", "type/vox.store.CommonNamespace.PresenceMessage");
            k0.put("online", Boolean.valueOf(z));
            p0 p0Var = this.a;
            p0Var.c.execute(new Runnable(iMessengerCompletionHandler, k0) { // from class: a2.t.a.c.q0.p
                public final /* synthetic */ IMessengerCompletionHandler b;
                public final /* synthetic */ Map c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p0 p0Var2 = p0.this;
                    IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler2 = this.b;
                    Map map = this.c;
                    Objects.requireNonNull(p0Var2);
                    String uuid = UUID.randomUUID().toString();
                    ConcurrentHashMap<String, MessengerAction> concurrentHashMap = p0Var2.m;
                    MessengerAction messengerAction = MessengerAction.SET_STATUS;
                    concurrentHashMap.put(uuid, messengerAction);
                    if (iMessengerCompletionHandler2 != null) {
                        p0Var2.g.put(uuid, iMessengerCompletionHandler2);
                    }
                    p0Var2.g(uuid, messengerAction);
                    p0Var2.e.add(new MES_setStatus(uuid, map));
                }
            });
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void subscribe(List<Long> list, IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: subscribe");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.SUBSCRIBE;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (this.a.e(list)) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("@type", "type/vox.store.CommonNamespace.ManageSubscribes");
            hashMap.put("user_id", list);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new i0(p0Var2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void unsubscribe(List<Long> list, IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: unsubscribe");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.UNSUBSCRIBE;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (this.a.e(list)) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("@type", "type/vox.store.CommonNamespace.ManageSubscribes");
            hashMap.put("user_id", list);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new i0(p0Var2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void unsubscribeFromAll(IMessengerCompletionHandler<ISubscriptionEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: unsubscribeFromAll");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.UNSUBSCRIBE;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            HashMap k0 = a.k0("@type", "type/vox.store.CommonNamespace.ManageSubscribes");
            k0.put(ProfileTab.ALL, Boolean.TRUE);
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new i0(p0Var2, messengerAction, iMessengerCompletionHandler, k0));
        }
    }

    @Override // com.voximplant.sdk.messaging.IMessenger
    public void getUser(long j, IMessengerCompletionHandler<IUserEvent> iMessengerCompletionHandler) {
        Logger.i("Messenger: getUser (by id)");
        p0 p0Var = this.a;
        MessengerAction messengerAction = MessengerAction.GET_USER;
        if (!p0Var.f(messengerAction, iMessengerCompletionHandler)) {
            if (j <= 0) {
                this.a.k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            User user = new User(j, "type/vox.store.IncomingNamespace.GetUser");
            p0 p0Var2 = this.a;
            p0Var2.c.execute(new j0(p0Var2, messengerAction, iMessengerCompletionHandler, user));
        }
    }
}
