package com.voximplant.sdk.internal.signaling;

import a2.b.a.a.a;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.proto.MES_editMessage;
import com.voximplant.sdk.internal.proto.MES_sendMessage;
import com.voximplant.sdk.internal.proto.M___ping;
import com.voximplant.sdk.internal.proto.M_login;
import com.voximplant.sdk.internal.proto.M_loginSuccessful;
import com.voximplant.sdk.internal.proto.M_refreshOauthToken;
import com.voximplant.sdk.internal.proto.M_refreshOauthTokenSuccessful;
import com.voximplant.sdk.internal.proto.Utils;
import com.voximplant.sdk.internal.proto.WSMessage;
import com.voximplant.sdk.internal.proto.WSMessageAuth;
import com.voximplant.sdk.internal.proto.WSMessageCall;
import com.voximplant.sdk.internal.proto.WSMessageChat;
import com.voximplant.sdk.internal.proto.WSMessageChatIncoming;
import com.voximplant.sdk.internal.proto.WSMessagePush;
import com.voximplant.sdk.internal.signaling.ISignalingListener;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.signaling.SignalingState;
import com.voximplant.sdk.internal.utils.VoxExecutor;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
public class Signaling extends WebSocketListener {
    public static Signaling k;
    public OkHttpClient a;
    public WebSocket b;
    public Gson c = new GsonBuilder().enableComplexMapKeySerialization().registerTypeAdapterFactory(Utils.messageAuthTypeFactory).registerTypeAdapterFactory(Utils.messageCallTypeFactory).registerTypeAdapterFactory(Utils.messageChatTypeFactory).registerTypeAdapterFactory(Utils.messagePushTypeFactory).create();
    public SignalingState d;
    public ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
    public ScheduledFuture f;
    public CopyOnWriteArrayList<WebSocket> g = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<ISignalingListener> h = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<IMessageListener> i = new CopyOnWriteArrayList<>();
    public Runnable j = new Runnable() { // from class: a2.t.a.c.r0.d
        @Override // java.lang.Runnable
        public final void run() {
            Signaling signaling = Signaling.this;
            Objects.requireNonNull(signaling);
            signaling.a(new M___ping());
        }
    };

    public class a implements Callback {
        public a(Signaling signaling) {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            response.close();
        }
    }

    public Signaling() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = builder.readTimeout(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, timeUnit).writeTimeout(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, timeUnit).build();
        this.d = SignalingState.DISCONNECTED;
        makeHttpRequest(new Request.Builder().url("https://balancer.voximplant.com/getNearestHost").build(), new a(this));
    }

    public static synchronized Signaling getInstance() {
        Signaling signaling;
        synchronized (Signaling.class) {
            if (k == null) {
                k = new Signaling();
            }
            signaling = k;
        }
        return signaling;
    }

    public final void a(WSMessage wSMessage) {
        String str;
        if (wSMessage instanceof WSMessageAuth) {
            try {
                str = this.c.toJson(wSMessage, WSMessageAuth.class);
            } catch (JsonParseException unused) {
                Logger.e("Signaling: SEND: failed to convert to JSON");
                return;
            }
        } else if (wSMessage instanceof WSMessageCall) {
            try {
                str = this.c.toJson(wSMessage, WSMessageCall.class);
            } catch (JsonParseException unused2) {
                Logger.e("Signaling: SEND: failed to convert to JSON");
                return;
            }
        } else if (wSMessage instanceof WSMessageChat) {
            try {
                str = this.c.toJson(wSMessage, WSMessageChat.class);
            } catch (JsonParseException unused3) {
                Logger.e("Signaling: SEND: failed to convert to JSON");
                return;
            }
        } else {
            try {
                str = this.c.toJson(wSMessage, WSMessagePush.class);
            } catch (JsonParseException unused4) {
                Logger.e("Signaling: SEND: failed to convert to JSON");
                return;
            }
        }
        WebSocket webSocket = this.b;
        if (webSocket != null) {
            webSocket.send(str);
            if (wSMessage instanceof M_login) {
                StringBuilder L = a2.b.a.a.a.L("Signaling: SEND: login ");
                L.append(((M_login) wSMessage).user());
                Logger.i(L.toString());
            } else if (wSMessage instanceof M_refreshOauthToken) {
                Logger.i("Signaling: SEND: refreshOauthToken");
            } else if ((wSMessage instanceof MES_sendMessage) || (wSMessage instanceof MES_editMessage)) {
                StringBuilder L2 = a2.b.a.a.a.L("Signaling: SEND: ");
                L2.append(str.replaceAll("\"text\":\"[^\"]*\"", "\"text\":\"*****\""));
                Logger.i(L2.toString());
            } else {
                VoxImplantUtils.logLargeString("Signaling: SEND: " + str);
            }
        } else {
            Logger.e("Signaling: failed to send message, web socket is disconnected");
        }
    }

    public void addMessageListener(IMessageListener iMessageListener) {
        if (iMessageListener != null) {
            this.i.add(iMessageListener);
        }
    }

    public void addSignalingListener(ISignalingListener iSignalingListener) {
        if (iSignalingListener != null) {
            this.h.add(iSignalingListener);
        }
    }

    public void closeConnection(boolean z) {
        this.e.execute(new Runnable(z) { // from class: a2.t.a.c.r0.h
            public final /* synthetic */ boolean b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Signaling signaling = Signaling.this;
                boolean z2 = this.b;
                WebSocket webSocket = signaling.b;
                if (webSocket != null) {
                    webSocket.cancel();
                    signaling.b = null;
                    if (z2) {
                        signaling.d = SignalingState.DISCONNECTED;
                        Iterator<ISignalingListener> it = signaling.h.iterator();
                        while (it.hasNext()) {
                            it.next().onWSClose(null);
                        }
                    }
                } else if (signaling.g.size() > 0) {
                    Iterator<WebSocket> it2 = signaling.g.iterator();
                    while (it2.hasNext()) {
                        it2.next().cancel();
                    }
                    signaling.d = SignalingState.DISCONNECTED;
                    Iterator<ISignalingListener> it3 = signaling.h.iterator();
                    while (it3.hasNext()) {
                        it3.next().onWSClose(null);
                    }
                } else {
                    signaling.d = SignalingState.DISCONNECTED;
                    Iterator<ISignalingListener> it4 = signaling.h.iterator();
                    while (it4.hasNext()) {
                        it4.next().onWSClose(null);
                    }
                }
            }
        });
    }

    public void makeHttpRequest(Request request, Callback callback) {
        this.e.execute(new Runnable(request, callback) { // from class: a2.t.a.c.r0.a
            public final /* synthetic */ Request b;
            public final /* synthetic */ Callback c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Signaling signaling = Signaling.this;
                Request request2 = this.b;
                Callback callback2 = this.c;
                OkHttpClient okHttpClient = signaling.a;
                if (okHttpClient != null) {
                    okHttpClient.newCall(request2).enqueue(callback2);
                } else {
                    Logger.e("Signaling: makeHttpRequest: not able to make request");
                }
            }
        });
    }

    public void makeRequest(Map<String, Request> map) {
        this.e.execute(new Runnable(map) { // from class: a2.t.a.c.r0.o
            public final /* synthetic */ Map b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Signaling signaling = Signaling.this;
                Map map2 = this.b;
                if (signaling.a == null || map2 == null || map2.isEmpty()) {
                    Logger.e("Signaling: makeRequest: not able to make request");
                    return;
                }
                signaling.d = SignalingState.CONNECTING;
                for (Map.Entry entry : map2.entrySet()) {
                    WebSocket newWebSocket = signaling.a.newWebSocket((Request) entry.getValue(), signaling);
                    signaling.g.add(newWebSocket);
                    Logger.i("Signaling: created web socket: " + newWebSocket + ", for: " + ((String) entry.getKey()));
                }
            }
        });
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        this.e.execute(new Runnable(webSocket, str) { // from class: a2.t.a.c.r0.g
            public final /* synthetic */ WebSocket b;
            public final /* synthetic */ String c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Signaling signaling = Signaling.this;
                WebSocket webSocket2 = this.b;
                String str2 = this.c;
                signaling.g.remove(webSocket2);
                WebSocket webSocket3 = signaling.b;
                if (webSocket3 != null && webSocket3 != webSocket2) {
                    Logger.i("Signaling: onClosed: socket closed: " + webSocket2 + ", current socket: " + signaling.b);
                } else if (signaling.g.size() >= 1) {
                    Logger.i("Signaling: onClosed: Remove " + webSocket2 + " from web socket candidates");
                } else {
                    Logger.e("Signaling: onClosed: web socket (" + webSocket2 + ") close reason = " + str2);
                    ScheduledFuture scheduledFuture = signaling.f;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        signaling.f = null;
                    }
                    signaling.b = null;
                    VoxExecutor.getInstance().smRun(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0084: INVOKE  
                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x007b: INVOKE  (r1v4 com.voximplant.sdk.internal.utils.VoxExecutor) =  type: STATIC call: com.voximplant.sdk.internal.utils.VoxExecutor.getInstance():com.voximplant.sdk.internal.utils.VoxExecutor)
                          (wrap: a2.t.a.c.r0.e : 0x0081: CONSTRUCTOR  (r3v6 a2.t.a.c.r0.e) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'str2' java.lang.String) call: a2.t.a.c.r0.e.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.String):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRun(java.lang.Runnable):void in method: a2.t.a.c.r0.g.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:169)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:146)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: CONSTRUCTOR  (r3v6 a2.t.a.c.r0.e) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'str2' java.lang.String) call: a2.t.a.c.r0.e.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.String):void type: CONSTRUCTOR in method: a2.t.a.c.r0.g.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.r0.e, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        */
                    /*
                        this = this;
                        com.voximplant.sdk.internal.signaling.Signaling r0 = com.voximplant.sdk.internal.signaling.Signaling.this
                        okhttp3.WebSocket r1 = r6.b
                        java.lang.String r2 = r6.c
                        java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                        r3.remove(r1)
                        okhttp3.WebSocket r3 = r0.b
                        if (r3 == 0) goto L_0x0030
                        if (r3 == r1) goto L_0x0030
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Signaling: onClosed: socket closed: "
                        r2.append(r3)
                        r2.append(r1)
                        java.lang.String r1 = ", current socket: "
                        r2.append(r1)
                        okhttp3.WebSocket r0 = r0.b
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        com.voximplant.sdk.internal.Logger.i(r0)
                        goto L_0x008b
                    L_0x0030:
                        java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                        int r3 = r3.size()
                        r4 = 1
                        if (r3 < r4) goto L_0x0053
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r2 = "Signaling: onClosed: Remove "
                        r0.append(r2)
                        r0.append(r1)
                        java.lang.String r1 = " from web socket candidates"
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        com.voximplant.sdk.internal.Logger.i(r0)
                        goto L_0x008b
                    L_0x0053:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r5 = "Signaling: onClosed: web socket ("
                        r3.append(r5)
                        r3.append(r1)
                        java.lang.String r1 = ") close reason = "
                        r3.append(r1)
                        r3.append(r2)
                        java.lang.String r1 = r3.toString()
                        com.voximplant.sdk.internal.Logger.e(r1)
                        java.util.concurrent.ScheduledFuture r1 = r0.f
                        r3 = 0
                        if (r1 == 0) goto L_0x0079
                        r1.cancel(r4)
                        r0.f = r3
                    L_0x0079:
                        r0.b = r3
                        com.voximplant.sdk.internal.utils.VoxExecutor r1 = com.voximplant.sdk.internal.utils.VoxExecutor.getInstance()
                        a2.t.a.c.r0.e r3 = new a2.t.a.c.r0.e
                        r3.<init>(r0, r2)
                        r1.smRun(r3)
                        com.voximplant.sdk.internal.signaling.SignalingState r1 = com.voximplant.sdk.internal.signaling.SignalingState.DISCONNECTED
                        r0.d = r1
                    L_0x008b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.r0.g.run():void");
                }
            });
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i2, String str) {
            this.e.execute(new Runnable(webSocket, str) { // from class: a2.t.a.c.r0.j
                public final /* synthetic */ WebSocket b;
                public final /* synthetic */ String c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Signaling signaling = Signaling.this;
                    WebSocket webSocket2 = this.b;
                    String str2 = this.c;
                    signaling.g.remove(webSocket2);
                    WebSocket webSocket3 = signaling.b;
                    if (webSocket3 != null && webSocket3 != webSocket2) {
                        Logger.i("Signaling: onClosing: socket closing: " + webSocket2 + ", current socket: " + signaling.b);
                    } else if (signaling.g.size() >= 1) {
                        Logger.i("Signaling: onClosing: Remove " + webSocket2 + " from web socket candidates");
                    } else {
                        Logger.e("Signaling: onClosing: web socket (" + webSocket2 + ") close reason = " + str2);
                        signaling.b = null;
                        SignalingState signalingState = signaling.d;
                        SignalingState signalingState2 = SignalingState.DISCONNECTED;
                        if (signalingState != signalingState2) {
                            VoxExecutor.getInstance().smRun(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: INVOKE  
                                  (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0078: INVOKE  (r1v5 com.voximplant.sdk.internal.utils.VoxExecutor) =  type: STATIC call: com.voximplant.sdk.internal.utils.VoxExecutor.getInstance():com.voximplant.sdk.internal.utils.VoxExecutor)
                                  (wrap: a2.t.a.c.r0.b : 0x007e: CONSTRUCTOR  (r4v2 a2.t.a.c.r0.b) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'str2' java.lang.String) call: a2.t.a.c.r0.b.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.String):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRun(java.lang.Runnable):void in method: a2.t.a.c.r0.j.run():void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:169)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:146)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007e: CONSTRUCTOR  (r4v2 a2.t.a.c.r0.b) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'str2' java.lang.String) call: a2.t.a.c.r0.b.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.String):void type: CONSTRUCTOR in method: a2.t.a.c.r0.j.run():void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                	... 29 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.r0.b, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 35 more
                                */
                            /*
                                this = this;
                                com.voximplant.sdk.internal.signaling.Signaling r0 = com.voximplant.sdk.internal.signaling.Signaling.this
                                okhttp3.WebSocket r1 = r5.b
                                java.lang.String r2 = r5.c
                                java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                                r3.remove(r1)
                                okhttp3.WebSocket r3 = r0.b
                                if (r3 == 0) goto L_0x0030
                                if (r3 == r1) goto L_0x0030
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r3 = "Signaling: onClosing: socket closing: "
                                r2.append(r3)
                                r2.append(r1)
                                java.lang.String r1 = ", current socket: "
                                r2.append(r1)
                                okhttp3.WebSocket r0 = r0.b
                                r2.append(r0)
                                java.lang.String r0 = r2.toString()
                                com.voximplant.sdk.internal.Logger.i(r0)
                                goto L_0x0086
                            L_0x0030:
                                java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                                int r3 = r3.size()
                                r4 = 1
                                if (r3 < r4) goto L_0x0053
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r2 = "Signaling: onClosing: Remove "
                                r0.append(r2)
                                r0.append(r1)
                                java.lang.String r1 = " from web socket candidates"
                                r0.append(r1)
                                java.lang.String r0 = r0.toString()
                                com.voximplant.sdk.internal.Logger.i(r0)
                                goto L_0x0086
                            L_0x0053:
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                r3.<init>()
                                java.lang.String r4 = "Signaling: onClosing: web socket ("
                                r3.append(r4)
                                r3.append(r1)
                                java.lang.String r1 = ") close reason = "
                                r3.append(r1)
                                r3.append(r2)
                                java.lang.String r1 = r3.toString()
                                com.voximplant.sdk.internal.Logger.e(r1)
                                r1 = 0
                                r0.b = r1
                                com.voximplant.sdk.internal.signaling.SignalingState r1 = r0.d
                                com.voximplant.sdk.internal.signaling.SignalingState r3 = com.voximplant.sdk.internal.signaling.SignalingState.DISCONNECTED
                                if (r1 == r3) goto L_0x0084
                                com.voximplant.sdk.internal.utils.VoxExecutor r1 = com.voximplant.sdk.internal.utils.VoxExecutor.getInstance()
                                a2.t.a.c.r0.b r4 = new a2.t.a.c.r0.b
                                r4.<init>(r0, r2)
                                r1.smRun(r4)
                            L_0x0084:
                                r0.d = r3
                            L_0x0086:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.r0.j.run():void");
                        }
                    });
                }

                @Override // okhttp3.WebSocketListener
                public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                    this.e.execute(new Runnable(webSocket, th) { // from class: a2.t.a.c.r0.m
                        public final /* synthetic */ WebSocket b;
                        public final /* synthetic */ Throwable c;

                        {
                            this.b = r2;
                            this.c = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Signaling signaling = Signaling.this;
                            WebSocket webSocket2 = this.b;
                            Throwable th2 = this.c;
                            signaling.g.remove(webSocket2);
                            WebSocket webSocket3 = signaling.b;
                            if (webSocket3 != null && webSocket3 != webSocket2) {
                                Logger.i("Signaling: onFailure: failed socket: " + webSocket2 + ", current socket: " + signaling.b);
                            } else if (signaling.g.size() >= 1) {
                                Logger.i("Signaling: onFailure: Remove " + webSocket2 + " from web socket candidates");
                            } else {
                                Logger.e("Signaling: onFailure: web socket (" + webSocket2 + ") failure reason = " + th2.getMessage());
                                ScheduledFuture scheduledFuture = signaling.f;
                                if (scheduledFuture != null) {
                                    scheduledFuture.cancel(true);
                                    signaling.f = null;
                                }
                                signaling.b = null;
                                VoxExecutor.getInstance().smRun(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0088: INVOKE  
                                      (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x007f: INVOKE  (r1v5 com.voximplant.sdk.internal.utils.VoxExecutor) =  type: STATIC call: com.voximplant.sdk.internal.utils.VoxExecutor.getInstance():com.voximplant.sdk.internal.utils.VoxExecutor)
                                      (wrap: a2.t.a.c.r0.l : 0x0085: CONSTRUCTOR  (r3v6 a2.t.a.c.r0.l) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'th2' java.lang.Throwable) call: a2.t.a.c.r0.l.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.Throwable):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRun(java.lang.Runnable):void in method: a2.t.a.c.r0.m.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:169)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:146)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0085: CONSTRUCTOR  (r3v6 a2.t.a.c.r0.l) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling), (r2v0 'th2' java.lang.Throwable) call: a2.t.a.c.r0.l.<init>(com.voximplant.sdk.internal.signaling.Signaling, java.lang.Throwable):void type: CONSTRUCTOR in method: a2.t.a.c.r0.m.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                    	... 23 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.r0.l, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                    	... 29 more
                                    */
                                /*
                                    this = this;
                                    com.voximplant.sdk.internal.signaling.Signaling r0 = com.voximplant.sdk.internal.signaling.Signaling.this
                                    okhttp3.WebSocket r1 = r6.b
                                    java.lang.Throwable r2 = r6.c
                                    java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                                    r3.remove(r1)
                                    okhttp3.WebSocket r3 = r0.b
                                    if (r3 == 0) goto L_0x0030
                                    if (r3 == r1) goto L_0x0030
                                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                    r2.<init>()
                                    java.lang.String r3 = "Signaling: onFailure: failed socket: "
                                    r2.append(r3)
                                    r2.append(r1)
                                    java.lang.String r1 = ", current socket: "
                                    r2.append(r1)
                                    okhttp3.WebSocket r0 = r0.b
                                    r2.append(r0)
                                    java.lang.String r0 = r2.toString()
                                    com.voximplant.sdk.internal.Logger.i(r0)
                                    goto L_0x008f
                                L_0x0030:
                                    java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r3 = r0.g
                                    int r3 = r3.size()
                                    r4 = 1
                                    if (r3 < r4) goto L_0x0053
                                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                    r0.<init>()
                                    java.lang.String r2 = "Signaling: onFailure: Remove "
                                    r0.append(r2)
                                    r0.append(r1)
                                    java.lang.String r1 = " from web socket candidates"
                                    r0.append(r1)
                                    java.lang.String r0 = r0.toString()
                                    com.voximplant.sdk.internal.Logger.i(r0)
                                    goto L_0x008f
                                L_0x0053:
                                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                    r3.<init>()
                                    java.lang.String r5 = "Signaling: onFailure: web socket ("
                                    r3.append(r5)
                                    r3.append(r1)
                                    java.lang.String r1 = ") failure reason = "
                                    r3.append(r1)
                                    java.lang.String r1 = r2.getMessage()
                                    r3.append(r1)
                                    java.lang.String r1 = r3.toString()
                                    com.voximplant.sdk.internal.Logger.e(r1)
                                    java.util.concurrent.ScheduledFuture r1 = r0.f
                                    r3 = 0
                                    if (r1 == 0) goto L_0x007d
                                    r1.cancel(r4)
                                    r0.f = r3
                                L_0x007d:
                                    r0.b = r3
                                    com.voximplant.sdk.internal.utils.VoxExecutor r1 = com.voximplant.sdk.internal.utils.VoxExecutor.getInstance()
                                    a2.t.a.c.r0.l r3 = new a2.t.a.c.r0.l
                                    r3.<init>(r0, r2)
                                    r1.smRun(r3)
                                    com.voximplant.sdk.internal.signaling.SignalingState r1 = com.voximplant.sdk.internal.signaling.SignalingState.DISCONNECTED
                                    r0.d = r1
                                L_0x008f:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.r0.m.run():void");
                            }
                        });
                    }

                    @Override // okhttp3.WebSocketListener
                    public void onMessage(WebSocket webSocket, String str) {
                        this.e.execute(new Runnable(webSocket, str) { // from class: a2.t.a.c.r0.i
                            public final /* synthetic */ WebSocket b;
                            public final /* synthetic */ String c;

                            {
                                this.b = r2;
                                this.c = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                WSMessage wSMessage;
                                Signaling signaling = Signaling.this;
                                WebSocket webSocket2 = this.b;
                                String str2 = this.c;
                                if (signaling.b != webSocket2) {
                                    Logger.w("Unexpected message: " + str2 + " from: " + webSocket2);
                                    return;
                                }
                                try {
                                    wSMessage = (WSMessage) signaling.c.fromJson(str2, (Class<Object>) WSMessageCall.class);
                                } catch (JsonParseException unused) {
                                    try {
                                        wSMessage = (WSMessage) signaling.c.fromJson(str2, (Class<Object>) WSMessageAuth.class);
                                    } catch (JsonParseException unused2) {
                                        try {
                                            wSMessage = (WSMessage) signaling.c.fromJson(str2, (Class<Object>) WSMessagePush.class);
                                        } catch (JsonParseException e2) {
                                            try {
                                                wSMessage = (WSMessage) signaling.c.fromJson(str2, (Class<Object>) WSMessageChatIncoming.class);
                                            } catch (JsonParseException unused3) {
                                                StringBuilder Q = a.Q("Signaling: onMessage: failed to parse ", str2);
                                                Q.append(e2.getMessage());
                                                Logger.e(Q.toString());
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (wSMessage instanceof M_loginSuccessful) {
                                    Logger.i("Signaling: onMessage: loginSuccessful");
                                } else if (wSMessage instanceof M_refreshOauthTokenSuccessful) {
                                    Logger.i("Signaling: onMessage: refreshOauthTokenSuccessful");
                                } else {
                                    if (wSMessage instanceof WSMessageChatIncoming) {
                                        WSMessageChatIncoming wSMessageChatIncoming = (WSMessageChatIncoming) wSMessage;
                                        if (wSMessageChatIncoming.getEvent().equals("onSendMessage") || wSMessageChatIncoming.getEvent().equals("onEditMessage") || wSMessageChatIncoming.getEvent().equals("onRetransmitEvents")) {
                                            StringBuilder L = a.L("Signaling: onMessage: ");
                                            L.append(str2.replaceAll("\"text\" : \"[^\"]*\"", "\"text\" : \"*****\""));
                                            Logger.i(L.toString());
                                        }
                                    }
                                    VoxImplantUtils.logLargeString("Signaling: onMessage: " + str2);
                                }
                                VoxExecutor.getInstance().smRun(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c9: INVOKE  
                                      (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x00c0: INVOKE  (r2v1 com.voximplant.sdk.internal.utils.VoxExecutor) =  type: STATIC call: com.voximplant.sdk.internal.utils.VoxExecutor.getInstance():com.voximplant.sdk.internal.utils.VoxExecutor)
                                      (wrap: a2.t.a.c.r0.k : 0x00c6: CONSTRUCTOR  (r3v2 a2.t.a.c.r0.k) = 
                                      (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling)
                                      (r1v1 'wSMessage' com.voximplant.sdk.internal.proto.WSMessage)
                                     call: a2.t.a.c.r0.k.<init>(com.voximplant.sdk.internal.signaling.Signaling, com.voximplant.sdk.internal.proto.WSMessage):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRun(java.lang.Runnable):void in method: a2.t.a.c.r0.i.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c6: CONSTRUCTOR  (r3v2 a2.t.a.c.r0.k) = 
                                      (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling)
                                      (r1v1 'wSMessage' com.voximplant.sdk.internal.proto.WSMessage)
                                     call: a2.t.a.c.r0.k.<init>(com.voximplant.sdk.internal.signaling.Signaling, com.voximplant.sdk.internal.proto.WSMessage):void type: CONSTRUCTOR in method: a2.t.a.c.r0.i.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                    	... 19 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.r0.k, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                    	... 25 more
                                    */
                                /*
                                    this = this;
                                    com.voximplant.sdk.internal.signaling.Signaling r0 = com.voximplant.sdk.internal.signaling.Signaling.this
                                    okhttp3.WebSocket r1 = r7.b
                                    java.lang.String r2 = r7.c
                                    okhttp3.WebSocket r3 = r0.b
                                    if (r3 == r1) goto L_0x0028
                                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                    r0.<init>()
                                    java.lang.String r3 = "Unexpected message: "
                                    r0.append(r3)
                                    r0.append(r2)
                                    java.lang.String r2 = " from: "
                                    r0.append(r2)
                                    r0.append(r1)
                                    java.lang.String r0 = r0.toString()
                                    com.voximplant.sdk.internal.Logger.w(r0)
                                    goto L_0x00e1
                                L_0x0028:
                                    com.google.gson.Gson r1 = r0.c     // Catch:{ JsonParseException -> 0x0033 }
                                    java.lang.Class<com.voximplant.sdk.internal.proto.WSMessageCall> r3 = com.voximplant.sdk.internal.proto.WSMessageCall.class
                                    java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ JsonParseException -> 0x0033 }
                                    com.voximplant.sdk.internal.proto.WSMessage r1 = (com.voximplant.sdk.internal.proto.WSMessage) r1     // Catch:{ JsonParseException -> 0x0033 }
                                    goto L_0x0055
                                L_0x0033:
                                    com.google.gson.Gson r1 = r0.c     // Catch:{ JsonParseException -> 0x003e }
                                    java.lang.Class<com.voximplant.sdk.internal.proto.WSMessageAuth> r3 = com.voximplant.sdk.internal.proto.WSMessageAuth.class
                                    java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ JsonParseException -> 0x003e }
                                    com.voximplant.sdk.internal.proto.WSMessage r1 = (com.voximplant.sdk.internal.proto.WSMessage) r1     // Catch:{ JsonParseException -> 0x003e }
                                    goto L_0x0055
                                L_0x003e:
                                    com.google.gson.Gson r1 = r0.c     // Catch:{ JsonParseException -> 0x0049 }
                                    java.lang.Class<com.voximplant.sdk.internal.proto.WSMessagePush> r3 = com.voximplant.sdk.internal.proto.WSMessagePush.class
                                    java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ JsonParseException -> 0x0049 }
                                    com.voximplant.sdk.internal.proto.WSMessage r1 = (com.voximplant.sdk.internal.proto.WSMessage) r1     // Catch:{ JsonParseException -> 0x0049 }
                                    goto L_0x0055
                                L_0x0049:
                                    r1 = move-exception
                                    com.google.gson.Gson r3 = r0.c     // Catch:{ JsonParseException -> 0x00cd }
                                    java.lang.Class<com.voximplant.sdk.internal.proto.WSMessageChatIncoming> r4 = com.voximplant.sdk.internal.proto.WSMessageChatIncoming.class
                                    java.lang.Object r3 = r3.fromJson(r2, r4)     // Catch:{ JsonParseException -> 0x00cd }
                                    com.voximplant.sdk.internal.proto.WSMessage r3 = (com.voximplant.sdk.internal.proto.WSMessage) r3     // Catch:{ JsonParseException -> 0x00cd }
                                    r1 = r3
                                L_0x0055:
                                    boolean r3 = r1 instanceof com.voximplant.sdk.internal.proto.M_loginSuccessful
                                    if (r3 == 0) goto L_0x0060
                                    java.lang.String r2 = "Signaling: onMessage: loginSuccessful"
                                    com.voximplant.sdk.internal.Logger.i(r2)
                                    goto L_0x00c0
                                L_0x0060:
                                    boolean r3 = r1 instanceof com.voximplant.sdk.internal.proto.M_refreshOauthTokenSuccessful
                                    if (r3 == 0) goto L_0x006a
                                    java.lang.String r2 = "Signaling: onMessage: refreshOauthTokenSuccessful"
                                    com.voximplant.sdk.internal.Logger.i(r2)
                                    goto L_0x00c0
                                L_0x006a:
                                    boolean r3 = r1 instanceof com.voximplant.sdk.internal.proto.WSMessageChatIncoming
                                    java.lang.String r4 = "Signaling: onMessage: "
                                    if (r3 == 0) goto L_0x00ae
                                    r3 = r1
                                    com.voximplant.sdk.internal.proto.WSMessageChatIncoming r3 = (com.voximplant.sdk.internal.proto.WSMessageChatIncoming) r3
                                    java.lang.String r5 = r3.getEvent()
                                    java.lang.String r6 = "onSendMessage"
                                    boolean r5 = r5.equals(r6)
                                    if (r5 != 0) goto L_0x0097
                                    java.lang.String r5 = r3.getEvent()
                                    java.lang.String r6 = "onEditMessage"
                                    boolean r5 = r5.equals(r6)
                                    if (r5 != 0) goto L_0x0097
                                    java.lang.String r3 = r3.getEvent()
                                    java.lang.String r5 = "onRetransmitEvents"
                                    boolean r3 = r3.equals(r5)
                                    if (r3 == 0) goto L_0x00ae
                                L_0x0097:
                                    java.lang.StringBuilder r3 = a2.b.a.a.a.L(r4)
                                    java.lang.String r4 = "\"text\" : \"[^\"]*\""
                                    java.lang.String r5 = "\"text\" : \"*****\""
                                    java.lang.String r2 = r2.replaceAll(r4, r5)
                                    r3.append(r2)
                                    java.lang.String r2 = r3.toString()
                                    com.voximplant.sdk.internal.Logger.i(r2)
                                    goto L_0x00c0
                                L_0x00ae:
                                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                    r3.<init>()
                                    r3.append(r4)
                                    r3.append(r2)
                                    java.lang.String r2 = r3.toString()
                                    com.voximplant.sdk.internal.utils.VoxImplantUtils.logLargeString(r2)
                                L_0x00c0:
                                    com.voximplant.sdk.internal.utils.VoxExecutor r2 = com.voximplant.sdk.internal.utils.VoxExecutor.getInstance()
                                    a2.t.a.c.r0.k r3 = new a2.t.a.c.r0.k
                                    r3.<init>(r0, r1)
                                    r2.smRun(r3)
                                    goto L_0x00e1
                                L_0x00cd:
                                    java.lang.String r0 = "Signaling: onMessage: failed to parse "
                                    java.lang.StringBuilder r0 = a2.b.a.a.a.Q(r0, r2)
                                    java.lang.String r1 = r1.getMessage()
                                    r0.append(r1)
                                    java.lang.String r0 = r0.toString()
                                    com.voximplant.sdk.internal.Logger.e(r0)
                                L_0x00e1:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.r0.i.run():void");
                            }
                        });
                    }

                    @Override // okhttp3.WebSocketListener
                    public void onOpen(WebSocket webSocket, Response response) {
                        this.e.execute(new Runnable(webSocket) { // from class: a2.t.a.c.r0.c
                            public final /* synthetic */ WebSocket b;

                            {
                                this.b = r2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Signaling signaling = Signaling.this;
                                WebSocket webSocket2 = this.b;
                                Objects.requireNonNull(signaling);
                                Logger.i("Signaling: onOpen: " + webSocket2);
                                if (signaling.b == null) {
                                    signaling.d = SignalingState.CONNECTED;
                                    signaling.b = webSocket2;
                                    Iterator<WebSocket> it = signaling.g.iterator();
                                    while (it.hasNext()) {
                                        WebSocket next = it.next();
                                        if (next != webSocket2) {
                                            Logger.i("Signaling: onOpen: closing socket " + next);
                                            next.cancel();
                                        }
                                    }
                                    signaling.g.clear();
                                    signaling.startFutures();
                                    VoxExecutor.getInstance().smRun(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE  
                                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0059: INVOKE  (r1v4 com.voximplant.sdk.internal.utils.VoxExecutor) =  type: STATIC call: com.voximplant.sdk.internal.utils.VoxExecutor.getInstance():com.voximplant.sdk.internal.utils.VoxExecutor)
                                          (wrap: a2.t.a.c.r0.n : 0x005f: CONSTRUCTOR  (r2v6 a2.t.a.c.r0.n) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling) call: a2.t.a.c.r0.n.<init>(com.voximplant.sdk.internal.signaling.Signaling):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRun(java.lang.Runnable):void in method: a2.t.a.c.r0.c.run():void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r2v6 a2.t.a.c.r0.n) = (r0v0 'signaling' com.voximplant.sdk.internal.signaling.Signaling) call: a2.t.a.c.r0.n.<init>(com.voximplant.sdk.internal.signaling.Signaling):void type: CONSTRUCTOR in method: a2.t.a.c.r0.c.run():void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                        	... 23 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.r0.n, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                        	... 29 more
                                        */
                                    /*
                                        this = this;
                                        com.voximplant.sdk.internal.signaling.Signaling r0 = com.voximplant.sdk.internal.signaling.Signaling.this
                                        okhttp3.WebSocket r1 = r6.b
                                        java.util.Objects.requireNonNull(r0)
                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                        r2.<init>()
                                        java.lang.String r3 = "Signaling: onOpen: "
                                        r2.append(r3)
                                        r2.append(r1)
                                        java.lang.String r2 = r2.toString()
                                        com.voximplant.sdk.internal.Logger.i(r2)
                                        okhttp3.WebSocket r2 = r0.b
                                        if (r2 != 0) goto L_0x0066
                                        com.voximplant.sdk.internal.signaling.SignalingState r2 = com.voximplant.sdk.internal.signaling.SignalingState.CONNECTED
                                        r0.d = r2
                                        r0.b = r1
                                        java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r2 = r0.g
                                        java.util.Iterator r2 = r2.iterator()
                                    L_0x002b:
                                        boolean r3 = r2.hasNext()
                                        if (r3 == 0) goto L_0x0051
                                        java.lang.Object r3 = r2.next()
                                        okhttp3.WebSocket r3 = (okhttp3.WebSocket) r3
                                        if (r3 == r1) goto L_0x002b
                                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                        r4.<init>()
                                        java.lang.String r5 = "Signaling: onOpen: closing socket "
                                        r4.append(r5)
                                        r4.append(r3)
                                        java.lang.String r4 = r4.toString()
                                        com.voximplant.sdk.internal.Logger.i(r4)
                                        r3.cancel()
                                        goto L_0x002b
                                    L_0x0051:
                                        java.util.concurrent.CopyOnWriteArrayList<okhttp3.WebSocket> r1 = r0.g
                                        r1.clear()
                                        r0.startFutures()
                                        com.voximplant.sdk.internal.utils.VoxExecutor r1 = com.voximplant.sdk.internal.utils.VoxExecutor.getInstance()
                                        a2.t.a.c.r0.n r2 = new a2.t.a.c.r0.n
                                        r2.<init>(r0)
                                        r1.smRun(r2)
                                        goto L_0x0078
                                    L_0x0066:
                                        java.lang.String r1 = "Signaling: onOpen: socket is already opened: "
                                        java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
                                        okhttp3.WebSocket r0 = r0.b
                                        r1.append(r0)
                                        java.lang.String r0 = r1.toString()
                                        com.voximplant.sdk.internal.Logger.w(r0)
                                    L_0x0078:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.r0.c.run():void");
                                }
                            });
                        }

                        public void removeMessageListener(IMessageListener iMessageListener) {
                            if (iMessageListener != null) {
                                this.i.remove(iMessageListener);
                            }
                        }

                        public void removeSignalingListener(ISignalingListener iSignalingListener) {
                            if (iSignalingListener != null) {
                                this.h.remove(iSignalingListener);
                            }
                        }

                        public void sendMessage(WSMessage wSMessage) {
                            this.e.execute(new Runnable(wSMessage) { // from class: a2.t.a.c.r0.f
                                public final /* synthetic */ WSMessage b;

                                {
                                    this.b = r2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Signaling.this.a(this.b);
                                }
                            });
                        }

                        public void startFutures() {
                            this.f = this.e.schedule(this.j, 10000, TimeUnit.MILLISECONDS);
                        }
                    }
