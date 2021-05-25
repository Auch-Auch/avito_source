package com.voximplant.sdk.internal.messaging;

import a2.b.a.a.a;
import a2.t.a.c.q0.m0;
import a2.t.a.c.q0.o;
import a2.t.a.c.q0.p0;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.proto.MES_removeMessage;
import com.voximplant.sdk.messaging.IMessage;
import com.voximplant.sdk.messaging.IMessageEvent;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
public class Message implements IMessage {
    public transient long a;
    @SerializedName("conversation")
    @Expose
    private String mConversation;
    @SerializedName("payload")
    @Expose
    private List<Map<String, Object>> mPayload;
    @SerializedName("text")
    @Expose
    private String mText;
    @SerializedName("@type")
    @Expose
    private String mType;
    @SerializedName("uuid")
    @Expose
    private String mUUID;

    public Message(String str, String str2, List<Map<String, Object>> list) {
        this.mConversation = str;
        this.mText = str2;
        this.mPayload = list;
    }

    public void a(String str) {
        this.mType = str;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public String getConversation() {
        return this.mConversation;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public List<Map<String, Object>> getPayload() {
        return this.mPayload;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public long getSequence() {
        return this.a;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public String getText() {
        return this.mText;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public String getUUID() {
        return this.mUUID;
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public void remove(IMessengerCompletionHandler<IMessageEvent> iMessengerCompletionHandler) {
        Logger.i("Message: remove");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.REMOVE_MESSAGE;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", this.mUUID);
            hashMap.put("conversation", this.mConversation);
            hashMap.put("@type", "type/vox.store.IncomingNamespace.RemoveMessage");
            p0 h2 = p0.h();
            h2.c.execute(new Runnable(messengerAction, iMessengerCompletionHandler, hashMap) { // from class: a2.t.a.c.q0.a
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
                    p0 p0Var = p0.this;
                    MessengerAction messengerAction2 = this.b;
                    IMessengerCompletionHandler<? extends IMessengerEvent> iMessengerCompletionHandler2 = this.c;
                    Map map = this.d;
                    Objects.requireNonNull(p0Var);
                    String uuid = UUID.randomUUID().toString();
                    p0Var.m.put(uuid, messengerAction2);
                    if (iMessengerCompletionHandler2 != null) {
                        p0Var.g.put(uuid, iMessengerCompletionHandler2);
                    }
                    p0Var.g(uuid, messengerAction2);
                    p0Var.e.add(new MES_removeMessage(uuid, map));
                }
            });
        }
    }

    public String toString() {
        StringBuilder L = a.L("Message [UUID = ");
        L.append(this.mUUID);
        L.append(", conversation = ");
        L.append(this.mConversation);
        L.append(", text = ");
        L.append(this.mText);
        L.append(", sequence = ");
        return a.l(L, this.a, "]");
    }

    @Override // com.voximplant.sdk.messaging.IMessage
    public void update(String str, List<Map<String, Object>> list, IMessengerCompletionHandler<IMessageEvent> iMessengerCompletionHandler) {
        Logger.i("Message: update");
        p0 h = p0.h();
        MessengerAction messengerAction = MessengerAction.EDIT_MESSAGE;
        if (!h.f(messengerAction, iMessengerCompletionHandler)) {
            if (str != null) {
                if (str.length() > 5000) {
                    p0 h2 = p0.h();
                    Objects.requireNonNull(h2);
                    Logger.w("MessengerManager: invoke invalid argument event, message text is too long");
                    h2.i(new m0(messengerAction, MessengerEventType.ON_ERROR, 10001, "Message text exceeds the length limit."), iMessengerCompletionHandler);
                    return;
                }
                this.mText = str;
            }
            if (list != null) {
                this.mPayload = list;
            }
            this.mType = "type/vox.store.IncomingNamespace.EditMessage";
            p0 h3 = p0.h();
            h3.c.execute(new o(h3, messengerAction, iMessengerCompletionHandler, this));
        }
    }

    public Message(String str, String str2, String str3, List<Map<String, Object>> list, long j) {
        this.mUUID = str;
        this.mConversation = str2;
        this.mText = str3;
        this.mPayload = list;
        this.a = j;
    }
}
