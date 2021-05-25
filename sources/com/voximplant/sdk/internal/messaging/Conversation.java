package com.voximplant.sdk.internal.messaging;

import a2.t.a.c.q0.g0;
import a2.t.a.c.q0.h;
import a2.t.a.c.q0.m0;
import a2.t.a.c.q0.p0;
import a2.t.a.c.q0.t;
import a2.t.a.c.q0.x;
import android.support.v4.media.session.PlaybackStateCompat;
import com.avito.android.db.SearchSubscriptionsContract;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.VKScope;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.messaging.ConversationConfig;
import com.voximplant.sdk.messaging.ConversationParticipant;
import com.voximplant.sdk.messaging.IConversation;
import com.voximplant.sdk.messaging.IConversationEvent;
import com.voximplant.sdk.messaging.IConversationServiceEvent;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IRetransmitEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
public class Conversation implements IConversation {
    public transient long a;
    public transient Timer b = null;
    public transient boolean c;
    public transient TimerTask d;
    public transient List<ConversationParticipant> e;
    @SerializedName("created_at")
    @Expose
    private Long mCreatedAt;
    @SerializedName("custom_data")
    @Expose
    private Map<String, Object> mCustomData;
    @SerializedName(VKScope.DIRECT)
    @Expose
    private Boolean mIsDirect;
    @SerializedName("enable_public_join")
    @Expose
    private Boolean mIsPublicJoinEnabled;
    @SerializedName("uber_conversation")
    @Expose
    private boolean mIsUberConversation;
    @SerializedName(SearchSubscriptionsContract.Columns.LAST_UPDATE_TIME)
    @Expose
    private Long mLastUpdate;
    @SerializedName("participants")
    @Expose
    private List<Map<String, Long>> mParticipants;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("@type")
    @Expose
    private String mType;
    @SerializedName("uuid")
    @Expose
    private String mUUID;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Conversation conversation = Conversation.this;
            conversation.c = false;
            Timer timer = conversation.b;
            if (timer != null) {
                timer.cancel();
                Conversation conversation2 = Conversation.this;
                conversation2.b = null;
                conversation2.d = null;
            }
        }
    }

    public Conversation(String str) {
        this.mUUID = str;
    }

    public final List<Map<String, Long>> a(List<ConversationParticipant> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ConversationParticipant conversationParticipant : list) {
                long j = 0;
                if (conversationParticipant != null) {
                    if (conversationParticipant.canWrite()) {
                        j = 1;
                    }
                    if (conversationParticipant.canEditMessages()) {
                        j |= 2;
                    }
                    if (conversationParticipant.canRemoveMessages()) {
                        j |= 4;
                    }
                    if (conversationParticipant.canManageParticipants()) {
                        j |= 8;
                    }
                    if (conversationParticipant.canEditAllMessages()) {
                        j |= 16;
                    }
                    if (conversationParticipant.canRemoveAllMessages()) {
                        j |= 32;
                    }
                    if (conversationParticipant.isOwner()) {
                        j |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", Long.valueOf(conversationParticipant.getIMUserId()));
                hashMap.put("flags", Long.valueOf(j));
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void addParticipants(List<ConversationParticipant> list, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: addParticipants");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.ADD_PARTICIPANTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (list == null || list.isEmpty() || p0.h().c(list)) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            List<Map<String, Long>> a3 = a(list);
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", this.mUUID);
            hashMap.put("participants", a3);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.ManageParticipants");
            p0 h2 = p0.h();
            h2.c.execute(new x(h2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    public void b(String str) {
        this.mType = str;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void editParticipants(List<ConversationParticipant> list, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: editParticipants");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.EDIT_PARTICIPANTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (list == null || list.isEmpty() || p0.h().c(list)) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            List<Map<String, Long>> a3 = a(list);
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", this.mUUID);
            hashMap.put("participants", a3);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.ManageParticipants");
            p0 h2 = p0.h();
            h2.c.execute(new x(h2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public long getCreatedTime() {
        Long l = this.mCreatedAt;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public Map<String, Object> getCustomData() {
        return this.mCustomData;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public long getLastSequence() {
        return this.a;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public long getLastUpdateTime() {
        Long l = this.mLastUpdate;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public List<ConversationParticipant> getParticipants() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (this.mParticipants != null && this.e.isEmpty()) {
            for (Map<String, Long> map : this.mParticipants) {
                List<ConversationParticipant> list = this.e;
                long longValue = map.get("user_id").longValue();
                long longValue2 = map.get("last_read").longValue();
                long longValue3 = map.get("flags").longValue();
                boolean z = false;
                ConversationParticipant canRemoveAllMessages = new ConversationParticipant(longValue, longValue2).setCanWrite((1 & longValue3) != 0).setCanEditMessages((2 & longValue3) != 0).setCanRemoveMessages((4 & longValue3) != 0).setCanManageParticipants((8 & longValue3) != 0).setCanEditAllMessages((16 & longValue3) != 0).setCanRemoveAllMessages((32 & longValue3) != 0);
                if ((PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID & longValue3) != 0) {
                    z = true;
                }
                list.add(canRemoveAllMessages.setOwner(z));
            }
        }
        return this.e;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public String getUUID() {
        return this.mUUID;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public boolean isDirect() {
        Boolean bool = this.mIsDirect;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public boolean isPublicJoin() {
        Boolean bool = this.mIsPublicJoinEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public boolean isUber() {
        return this.mIsUberConversation;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void markAsRead(long j, IMessengerCompletionHandler<IConversationServiceEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: markAsRead");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.IS_READ;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            HashMap hashMap = new HashMap();
            hashMap.put("conversation", this.mUUID);
            hashMap.put("seq", Long.valueOf(j));
            hashMap.put("@type", "type/vox.store.CommonNamespace.StatusMessage");
            p0 h2 = p0.h();
            h2.c.execute(new g0(h2, messengerAction, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void removeParticipants(List<ConversationParticipant> list, IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: editParticipants");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.REMOVE_PARTICIPANTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (list == null || list.isEmpty() || p0.h().c(list)) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ConversationParticipant conversationParticipant : list) {
                arrayList.add(Long.valueOf(conversationParticipant.getIMUserId()));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", this.mUUID);
            hashMap.put("participants", arrayList);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.RemoveParticipants");
            p0 h2 = p0.h();
            h2.c.execute(new x(h2, MessengerAction.REMOVE_PARTICIPANTS, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void retransmitEvents(long j, long j2, IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: retransmitEvents (from, to)");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.RETRANSMIT_EVENTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (j < 0 || j2 < 0) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
            } else if (j > j2) {
                p0 h2 = p0.h();
                Objects.requireNonNull(h2);
                Logger.w("MessengerManager: invoke invalid argument event, from is greater than to");
                h2.i(new m0(messengerAction, MessengerEventType.ON_ERROR, 28, "The 'from' field value is greater than the 'to' field value."), iMessengerCompletionHandler);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("conversation", this.mUUID);
                hashMap.put("events_from", Long.valueOf(j));
                hashMap.put("events_to", Long.valueOf(j2));
                hashMap.put("@type", "type/vox.store.IncomingNamespace.RetransmitRequest");
                p0 h3 = p0.h();
                h3.c.execute(new h(h3, iMessengerCompletionHandler, hashMap));
            }
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void retransmitEventsFrom(long j, int i, IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: retransmitEvents (from, count)");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.RETRANSMIT_EVENTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (i < 0 || j < 0) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("conversation", this.mUUID);
            hashMap.put("events_from", Long.valueOf(j));
            hashMap.put("count", Integer.valueOf(i));
            hashMap.put("@type", "type/vox.store.IncomingNamespace.RetransmitRequest");
            p0 h2 = p0.h();
            h2.c.execute(new h(h2, iMessengerCompletionHandler, hashMap));
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void retransmitEventsTo(long j, int i, IMessengerCompletionHandler<IRetransmitEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: retransmitEvents (to, count)");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.RETRANSMIT_EVENTS;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (i < 0 || j < 0) {
                p0.h().k(messengerAction, iMessengerCompletionHandler);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("conversation", this.mUUID);
            hashMap.put("events_to", Long.valueOf(j));
            hashMap.put("count", Integer.valueOf(i));
            hashMap.put("@type", "type/vox.store.IncomingNamespace.RetransmitRequest");
            p0 h2 = p0.h();
            h2.c.execute(new h(h2, iMessengerCompletionHandler, hashMap));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r6.size() == r2) goto L_0x0044;
     */
    @Override // com.voximplant.sdk.messaging.IConversation
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendMessage(java.lang.String r5, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r6, com.voximplant.sdk.messaging.IMessengerCompletionHandler<com.voximplant.sdk.messaging.IMessageEvent> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "Conversation: sendMessage"
            com.voximplant.sdk.internal.Logger.i(r0)
            a2.t.a.c.q0.p0 r0 = a2.t.a.c.q0.p0.h()
            com.voximplant.sdk.messaging.MessengerAction r1 = com.voximplant.sdk.messaging.MessengerAction.SEND_MESSAGE
            boolean r0 = r0.f(r1, r7)
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            if (r5 == 0) goto L_0x001a
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0051
        L_0x001a:
            r0 = 0
            if (r6 == 0) goto L_0x0044
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x0024
            goto L_0x0044
        L_0x0024:
            java.util.Iterator r1 = r6.iterator()
            r2 = 0
        L_0x0029:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r1.next()
            java.util.Map r3 = (java.util.Map) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0029
            int r2 = r2 + 1
            goto L_0x0029
        L_0x003e:
            int r1 = r6.size()
            if (r1 != r2) goto L_0x0045
        L_0x0044:
            r0 = 1
        L_0x0045:
            if (r0 == 0) goto L_0x0051
            a2.t.a.c.q0.p0 r5 = a2.t.a.c.q0.p0.h()
            com.voximplant.sdk.messaging.MessengerAction r6 = com.voximplant.sdk.messaging.MessengerAction.SEND_MESSAGE
            r5.k(r6, r7)
            return
        L_0x0051:
            if (r5 == 0) goto L_0x0078
            int r0 = r5.length()
            r1 = 5000(0x1388, float:7.006E-42)
            if (r0 <= r1) goto L_0x0078
            a2.t.a.c.q0.p0 r5 = a2.t.a.c.q0.p0.h()
            com.voximplant.sdk.messaging.MessengerAction r6 = com.voximplant.sdk.messaging.MessengerAction.SEND_MESSAGE
            java.util.Objects.requireNonNull(r5)
            java.lang.String r0 = "MessengerManager: invoke invalid argument event, message text is too long"
            com.voximplant.sdk.internal.Logger.w(r0)
            a2.t.a.c.q0.m0 r0 = new a2.t.a.c.q0.m0
            com.voximplant.sdk.messaging.MessengerEventType r1 = com.voximplant.sdk.messaging.MessengerEventType.ON_ERROR
            r2 = 10001(0x2711, float:1.4014E-41)
            java.lang.String r3 = "Message text exceeds the length limit."
            r0.<init>(r6, r1, r2, r3)
            r5.i(r0, r7)
            return
        L_0x0078:
            com.voximplant.sdk.internal.messaging.Message r0 = new com.voximplant.sdk.internal.messaging.Message
            java.lang.String r1 = r4.mUUID
            if (r5 != 0) goto L_0x0080
            java.lang.String r5 = ""
        L_0x0080:
            r0.<init>(r1, r5, r6)
            java.lang.String r5 = "type/vox.store.IncomingNamespace.SendMessage"
            r0.a(r5)
            a2.t.a.c.q0.p0 r5 = a2.t.a.c.q0.p0.h()
            com.voximplant.sdk.messaging.MessengerAction r6 = com.voximplant.sdk.messaging.MessengerAction.SEND_MESSAGE
            java.util.concurrent.ScheduledExecutorService r1 = r5.c
            a2.t.a.c.q0.o r2 = new a2.t.a.c.q0.o
            r2.<init>(r5, r6, r7, r0)
            r1.execute(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.voximplant.sdk.internal.messaging.Conversation.sendMessage(java.lang.String, java.util.List, com.voximplant.sdk.messaging.IMessengerCompletionHandler):void");
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void setCustomData(Map<String, Object> map) {
        this.mCustomData = map;
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void setPublicJoin(boolean z) {
        this.mIsPublicJoinEnabled = Boolean.valueOf(z);
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Conversation [UUID = ");
        L.append(this.mUUID);
        L.append(", created at = ");
        L.append(this.mCreatedAt);
        L.append(", direct = ");
        L.append(this.mIsDirect);
        L.append(", enable public join = ");
        L.append(this.mIsPublicJoinEnabled);
        L.append(", title = ");
        L.append(this.mTitle);
        L.append(", last updated = ");
        L.append(this.mLastUpdate);
        L.append(", participants = ");
        L.append(this.mParticipants);
        L.append(", custom data = ");
        L.append(this.mCustomData);
        L.append(", last seq = ");
        return a2.b.a.a.a.l(L, this.a, "]");
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void typing(IMessengerCompletionHandler<IConversationServiceEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: typing");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.TYPING_MESSAGE;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (!this.c) {
                HashMap hashMap = new HashMap();
                hashMap.put("conversation", this.mUUID);
                hashMap.put("@type", "type/vox.store.CommonNamespace.TypingMessage");
                p0 h2 = p0.h();
                h2.c.execute(new g0(h2, messengerAction, iMessengerCompletionHandler, hashMap));
                this.c = true;
                this.b = new Timer();
                if (this.d == null) {
                    this.d = new a();
                }
                this.b.schedule(this.d, 10000);
                return;
            }
            p0.h().i(new m0(messengerAction, MessengerEventType.ON_ERROR, 10000, "Method calls within 10s interval from the last call are discarded."), iMessengerCompletionHandler);
        }
    }

    @Override // com.voximplant.sdk.messaging.IConversation
    public void update(IMessengerCompletionHandler<IConversationEvent> iMessengerCompletionHandler) {
        Logger.i("Conversation: update");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.EDIT_CONVERSATION;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            p0 h2 = p0.h();
            h2.c.execute(new t(h2, messengerAction, iMessengerCompletionHandler, this));
        }
    }

    public Conversation(ConversationConfig conversationConfig, String str) {
        this.mParticipants = a(conversationConfig.getParticipants());
        this.mTitle = conversationConfig.getTitle();
        this.mIsDirect = Boolean.valueOf(conversationConfig.isDirect());
        this.mIsPublicJoinEnabled = Boolean.valueOf(conversationConfig.isPublicJoin());
        this.mCustomData = conversationConfig.getCustomData();
        this.mIsUberConversation = conversationConfig.isUber();
        this.mType = str;
    }

    public Conversation(ConversationConfig conversationConfig, String str, long j, long j2, long j3) {
        if (conversationConfig != null) {
            this.mParticipants = a(conversationConfig.getParticipants());
            this.mTitle = conversationConfig.getTitle();
            this.mIsPublicJoinEnabled = Boolean.valueOf(conversationConfig.isPublicJoin());
            this.mIsDirect = Boolean.valueOf(conversationConfig.isDirect());
            this.mCustomData = conversationConfig.getCustomData();
            this.mIsUberConversation = conversationConfig.isUber();
        }
        this.mUUID = str;
        this.a = j;
        this.mLastUpdate = Long.valueOf(j2);
        this.mCreatedAt = Long.valueOf(j3);
    }
}
