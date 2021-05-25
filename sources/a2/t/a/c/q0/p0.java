package a2.t.a.c.q0;

import a2.b.a.a.a;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.messaging.Conversation;
import com.voximplant.sdk.internal.messaging.Message;
import com.voximplant.sdk.internal.messaging.User;
import com.voximplant.sdk.internal.proto.M_loginSuccessful;
import com.voximplant.sdk.internal.proto.WSMessage;
import com.voximplant.sdk.internal.proto.WSMessageChat;
import com.voximplant.sdk.internal.proto.WSMessageChatIncoming;
import com.voximplant.sdk.internal.signaling.IMessageListener;
import com.voximplant.sdk.internal.signaling.ISignalingListener;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxExecutor;
import com.voximplant.sdk.messaging.IConversation;
import com.voximplant.sdk.messaging.IConversationEvent;
import com.voximplant.sdk.messaging.IErrorEvent;
import com.voximplant.sdk.messaging.IMessage;
import com.voximplant.sdk.messaging.IMessengerCompletionHandler;
import com.voximplant.sdk.messaging.IMessengerEvent;
import com.voximplant.sdk.messaging.IMessengerListener;
import com.voximplant.sdk.messaging.IUser;
import com.voximplant.sdk.messaging.IUserEvent;
import com.voximplant.sdk.messaging.MessengerAction;
import com.voximplant.sdk.messaging.MessengerEventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class p0 implements IMessageListener, ISignalingListener {
    public static p0 p;
    public Signaling a = Signaling.getInstance();
    public Gson b = new GsonBuilder().create();
    public ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    public CopyOnWriteArrayList<IMessengerListener> d = new CopyOnWriteArrayList<>();
    public LinkedList<WSMessageChat> e = new LinkedList<>();
    public ScheduledFuture f;
    public ConcurrentHashMap<String, IMessengerCompletionHandler<? extends IMessengerEvent>> g = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, IMessengerCompletionHandler<List<IUserEvent>>> h = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, IMessengerCompletionHandler<List<IConversationEvent>>> i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, List<? extends IMessengerEvent>> j = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Integer> k = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ScheduledFuture> l = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, MessengerAction> m = new ConcurrentHashMap<>();
    public boolean n = false;
    public Runnable o = new Runnable() { // from class: a2.t.a.c.q0.v
        @Override // java.lang.Runnable
        public final void run() {
            p0 p0Var = p0.this;
            WSMessageChat poll = p0Var.e.poll();
            if (poll != null) {
                p0Var.a.sendMessage(poll);
            }
        }
    };

    public p0() {
        this.a.addMessageListener(this);
        this.a.addSignalingListener(this);
        if (SharedData.getUser() != null) {
            this.n = true;
            if (this.f == null) {
                this.f = this.c.scheduleAtFixedRate(this.o, 0, 220, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static synchronized p0 h() {
        p0 p0Var;
        synchronized (p0.class) {
            if (p == null) {
                p = new p0();
            }
            p0Var = p;
        }
        return p0Var;
    }

    public final void a(Runnable runnable) {
        SharedData.getCallbackExecutor().execute(runnable);
    }

    public final void b(String str) {
        if (str != null && !str.isEmpty()) {
            ScheduledFuture remove = this.l.remove(str);
            if (remove != null) {
                Logger.i("MessengerManager: cancelAndRemoveTimeoutFuture: canceled for: " + str);
                remove.cancel(true);
            }
            this.m.remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(java.util.List<com.voximplant.sdk.messaging.ConversationParticipant> r6) {
        /*
            r5 = this;
            java.util.Iterator r6 = r6.iterator()
        L_0x0004:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r6.next()
            com.voximplant.sdk.messaging.ConversationParticipant r0 = (com.voximplant.sdk.messaging.ConversationParticipant) r0
            if (r0 == 0) goto L_0x001c
            long r0 = r0.getIMUserId()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0004
        L_0x001c:
            java.lang.String r6 = "MessengerManager: checkInvalidParticipants: participant is null or has invalid IM user id"
            com.voximplant.sdk.internal.Logger.w(r6)
            r6 = 1
            return r6
        L_0x0023:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.q0.p0.c(java.util.List):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(java.util.List<java.lang.String> r3) {
        /*
            r2 = this;
            r0 = 1
            if (r3 == 0) goto L_0x002a
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x002a
        L_0x000a:
            java.util.Iterator r3 = r3.iterator()
        L_0x000e:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0028
            java.lang.Object r1 = r3.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0022
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x000e
        L_0x0022:
            java.lang.String r3 = "MessengerManagerL checkInvalidStringList: item in the list is null or empty"
            com.voximplant.sdk.internal.Logger.w(r3)
            return r0
        L_0x0028:
            r3 = 0
            return r3
        L_0x002a:
            java.lang.String r3 = "MessengerManager: checkInvalidStringList: list is empty or null"
            com.voximplant.sdk.internal.Logger.w(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.q0.p0.d(java.util.List):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(java.util.List<java.lang.Long> r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x002e
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x002e
        L_0x000a:
            java.util.Iterator r7 = r7.iterator()
        L_0x000e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r7.next()
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L_0x0026
            long r1 = r1.longValue()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x000e
        L_0x0026:
            java.lang.String r7 = "MessengerManager: checkInvalidUserIds: im users id is null or <= 0"
            com.voximplant.sdk.internal.Logger.w(r7)
            return r0
        L_0x002c:
            r7 = 0
            return r7
        L_0x002e:
            java.lang.String r7 = "MessengerManager: checkInvalidUserIds: im users ids list is empty or null"
            com.voximplant.sdk.internal.Logger.w(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.q0.p0.e(java.util.List):boolean");
    }

    public boolean f(MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler) {
        boolean z;
        synchronized (this) {
            z = this.n;
        }
        if (z) {
            return false;
        }
        i(new m0(messengerAction, MessengerEventType.ON_ERROR, 10003, "Client is not logged in."), iMessengerCompletionHandler);
        return true;
    }

    public final void g(String str, MessengerAction messengerAction) {
        this.l.put(str, VoxExecutor.getInstance().smRunDelayed(new Runnable(str, messengerAction) { // from class: a2.t.a.c.q0.m
            public final /* synthetic */ String b;
            public final /* synthetic */ MessengerAction c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p0 p0Var = p0.this;
                String str2 = this.b;
                MessengerAction messengerAction2 = this.c;
                p0Var.l.remove(str2);
                p0Var.i(new m0(messengerAction2, MessengerEventType.ON_ERROR, 10002, "Response timeout."), p0Var.g.remove(str2));
            }
        }, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND));
    }

    public void i(IErrorEvent iErrorEvent, IMessengerCompletionHandler iMessengerCompletionHandler) {
        h().a(new Runnable(iMessengerCompletionHandler, iErrorEvent) { // from class: a2.t.a.c.q0.a0
            public final /* synthetic */ IMessengerCompletionHandler b;
            public final /* synthetic */ IErrorEvent c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p0 p0Var = p0.this;
                IMessengerCompletionHandler iMessengerCompletionHandler2 = this.b;
                IErrorEvent iErrorEvent2 = this.c;
                Objects.requireNonNull(p0Var);
                if (iMessengerCompletionHandler2 != null) {
                    StringBuilder L = a.L("Invoke completion handler onError with code: ");
                    L.append(iErrorEvent2.getErrorCode());
                    L.append(" for action: ");
                    L.append(iErrorEvent2.getMessengerAction());
                    Logger.w(L.toString());
                    iMessengerCompletionHandler2.onError(iErrorEvent2);
                    return;
                }
                Iterator<IMessengerListener> it = p0Var.d.iterator();
                while (it.hasNext()) {
                    IMessengerListener next = it.next();
                    if (next != null) {
                        StringBuilder L2 = a.L("Invoke onError with code: ");
                        L2.append(iErrorEvent2.getErrorCode());
                        L2.append(" for action: ");
                        L2.append(iErrorEvent2.getMessengerAction());
                        Logger.w(L2.toString());
                        next.onError(iErrorEvent2);
                    }
                }
            }
        });
    }

    public final void j(MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler) {
        Logger.w("MessengerManager: invoke failed to process response event");
        i(new m0(messengerAction, MessengerEventType.ON_ERROR, 10004, "Failed to process response."), iMessengerCompletionHandler);
    }

    public void k(MessengerAction messengerAction, IMessengerCompletionHandler iMessengerCompletionHandler) {
        Logger.w("MessengerManager: invoke invalid argument event");
        i(new m0(messengerAction, MessengerEventType.ON_ERROR, 10001, "Invalid argument(s)."), iMessengerCompletionHandler);
    }

    public final IConversation l(WSMessageChatIncoming wSMessageChatIncoming, long j2) {
        try {
            Conversation conversation = (Conversation) this.b.fromJson(wSMessageChatIncoming.getPayload().object.toString(), (Class<Object>) Conversation.class);
            conversation.a = j2;
            return conversation;
        } catch (JsonParseException e2) {
            Logger.e("MessengerManager: onMessage " + wSMessageChatIncoming + ": failed to parse json: " + e2.getMessage());
            return null;
        }
    }

    public final IMessage m(WSMessageChatIncoming wSMessageChatIncoming, long j2) {
        try {
            Message message = (Message) this.b.fromJson(wSMessageChatIncoming.getPayload().object.toString(), (Class<Object>) Message.class);
            message.a = j2;
            return message;
        } catch (JsonParseException e2) {
            Logger.e("MessengerManager: onMessage " + wSMessageChatIncoming + ": failed to parse json: " + e2.getMessage());
            return null;
        }
    }

    public final List<Long> n(WSMessageChatIncoming wSMessageChatIncoming, String str) {
        JsonArray asJsonArray;
        ArrayList arrayList = new ArrayList();
        try {
            JsonObject asJsonObject = wSMessageChatIncoming.getPayload().object.getAsJsonObject();
            if (!(asJsonObject == null || !asJsonObject.has(str) || (asJsonArray = asJsonObject.get(str).getAsJsonArray()) == null)) {
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    arrayList.add(Long.valueOf(asJsonArray.get(i2).getAsLong()));
                }
            }
            return arrayList;
        } catch (JsonParseException e2) {
            Logger.e("MessengerManager: onMessage " + wSMessageChatIncoming + ": failed to parse json: " + e2.getMessage());
            return null;
        }
    }

    public final IUser o(WSMessageChatIncoming wSMessageChatIncoming) {
        try {
            return (User) this.b.fromJson(wSMessageChatIncoming.getPayload().object.toString(), (Class<Object>) User.class);
        } catch (JsonParseException e2) {
            Logger.e("MessengerManager: onMessage " + wSMessageChatIncoming + ": failed to parse json: " + e2.getMessage());
            return null;
        }
    }

    @Override // com.voximplant.sdk.internal.signaling.IMessageListener
    public void onMessage(WSMessage wSMessage) {
        if (wSMessage instanceof M_loginSuccessful) {
            synchronized (this) {
                Logger.i("MessengerManager: onMessage: client is logged in");
                this.n = true;
            }
        }
        if (wSMessage instanceof WSMessageChatIncoming) {
            this.c.execute(new Runnable(wSMessage) { // from class: a2.t.a.c.q0.n
                public final /* synthetic */ WSMessage b;

                {
                    this.b = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:232:0x057f A[Catch:{ JsonParseException -> 0x06b0 }] */
                /* JADX WARNING: Removed duplicated region for block: B:246:0x05de A[Catch:{ JsonParseException -> 0x06ae }] */
                /* JADX WARNING: Removed duplicated region for block: B:256:0x05f7 A[Catch:{ JsonParseException -> 0x06ae }] */
                /* JADX WARNING: Removed duplicated region for block: B:260:0x0649 A[Catch:{ JsonParseException -> 0x06ae }] */
                @Override // java.lang.Runnable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 2360
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.q0.n.run():void");
                }
            });
        }
    }

    @Override // com.voximplant.sdk.internal.signaling.ISignalingListener
    public void onWSClose(String str) {
        synchronized (this) {
            this.n = false;
        }
        this.c.execute(new Runnable() { // from class: a2.t.a.c.q0.y
            @Override // java.lang.Runnable
            public final void run() {
                p0 p0Var = p0.this;
                ScheduledFuture scheduledFuture = p0Var.f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    p0Var.f = null;
                }
                p0Var.e.clear();
                for (Map.Entry<String, IMessengerCompletionHandler<? extends IMessengerEvent>> entry : p0Var.g.entrySet()) {
                    m0 m0Var = new m0(p0Var.m.get(entry.getKey()), MessengerEventType.ON_ERROR, 10003, "Client is not logged in.");
                    p0Var.b(entry.getKey());
                    p0Var.i(m0Var, entry.getValue());
                }
                for (Map.Entry<String, IMessengerCompletionHandler<List<IUserEvent>>> entry2 : p0Var.h.entrySet()) {
                    p0Var.b(entry2.getKey());
                    p0Var.i(new m0(MessengerAction.GET_USERS, MessengerEventType.ON_ERROR, 10003, "Client is not logged in."), entry2.getValue());
                }
                for (Map.Entry<String, IMessengerCompletionHandler<List<IConversationEvent>>> entry3 : p0Var.i.entrySet()) {
                    p0Var.b(entry3.getKey());
                    p0Var.i(new m0(MessengerAction.GET_CONVERSATIONS, MessengerEventType.ON_ERROR, 10003, "Client is not logged in."), entry3.getValue());
                }
                for (Map.Entry<String, MessengerAction> entry4 : p0Var.m.entrySet()) {
                    p0Var.i(new m0(entry4.getValue(), MessengerEventType.ON_ERROR, 10003, "Client is not logged in."), null);
                    p0Var.b(entry4.getKey());
                }
                p0Var.g.clear();
                p0Var.j.clear();
                p0Var.k.clear();
                p0Var.i.clear();
                p0Var.h.clear();
                p0Var.m.clear();
            }
        });
    }

    @Override // com.voximplant.sdk.internal.signaling.ISignalingListener
    public void onWSOpen() {
        if (this.f == null) {
            this.f = this.c.scheduleAtFixedRate(this.o, 0, 220, TimeUnit.MILLISECONDS);
        }
    }
}
