package com.voximplant.sdk.internal;

import a2.b.a.a.a;
import a2.t.a.c.j0;
import a2.t.a.c.k0;
import a2.t.a.c.m0;
import a2.t.a.c.w;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import com.avito.android.social.AppleSignInManagerKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import com.voximplant.sdk.BuildConfig;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.client.AuthParams;
import com.voximplant.sdk.client.ClientConfig;
import com.voximplant.sdk.client.ClientState;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.IClientIncomingCallListener;
import com.voximplant.sdk.client.IClientLoginListener;
import com.voximplant.sdk.client.IClientSessionListener;
import com.voximplant.sdk.client.IPushTokenCompletionHandler;
import com.voximplant.sdk.client.PushTokenError;
import com.voximplant.sdk.internal.CallManager;
import com.voximplant.sdk.internal.Client;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.call.PCFactoryWrapper;
import com.voximplant.sdk.internal.callbacks.LoginCallbackController;
import com.voximplant.sdk.internal.callbacks.OnConnectionEstablished;
import com.voximplant.sdk.internal.callbacks.OnConnectionFailed;
import com.voximplant.sdk.internal.callbacks.OnLoginFailed;
import com.voximplant.sdk.internal.callbacks.OnLoginSuccessful;
import com.voximplant.sdk.internal.callbacks.OnOneTimeKeyGenerated;
import com.voximplant.sdk.internal.callbacks.SessionCallbackController;
import com.voximplant.sdk.internal.proto.M_loginFailed;
import com.voximplant.sdk.internal.proto.M_loginGenerateOneTimeKey;
import com.voximplant.sdk.internal.proto.M_loginSuccessful;
import com.voximplant.sdk.internal.proto.M_pushFeedback;
import com.voximplant.sdk.internal.proto.M_refreshOauthToken;
import com.voximplant.sdk.internal.proto.M_registerPushToken;
import com.voximplant.sdk.internal.proto.M_registerPushTokenResult;
import com.voximplant.sdk.internal.proto.M_unregisterPushToken;
import com.voximplant.sdk.internal.proto.M_unregisterPushTokenResult;
import com.voximplant.sdk.internal.proto.WSMessage;
import com.voximplant.sdk.internal.proto.WSMessagePush;
import com.voximplant.sdk.internal.signaling.IMessageListener;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxExecutor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import org.webrtc.PeerConnection;
public class Client implements IClient, IMessageListener, m0 {
    public SessionCallbackController a;
    public LoginCallbackController b;
    public final PCFactoryWrapper c;
    public VoxExecutor d = VoxExecutor.getInstance();
    public Signaling e = Signaling.getInstance();
    public j0 f;
    public Context g;
    public String h = null;
    public ClientConfig i;
    public String j;
    public ConcurrentLinkedQueue<WSMessagePush> k = new ConcurrentLinkedQueue<>();
    public ConcurrentHashMap<String, IPushTokenCompletionHandler> l = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ScheduledFuture> m = new ConcurrentHashMap<>();
    public CallManager n;
    public boolean o = false;
    public boolean p = false;
    public Gson q = new Gson();

    public Client(Executor executor, Context context, ClientConfig clientConfig) {
        PCFactoryWrapper pCFactoryWrapper = new PCFactoryWrapper();
        this.c = pCFactoryWrapper;
        Logger.a = clientConfig == null || clientConfig.enableLogcatLogging;
        SharedData.b = executor;
        this.a = new SessionCallbackController();
        this.b = new LoginCallbackController();
        this.g = context;
        this.i = clientConfig == null ? new ClientConfig() : clientConfig;
        this.e.addMessageListener(this);
        ClientConfig clientConfig2 = this.i;
        pCFactoryWrapper.createPeerConnectionFactory(context, new PCFactoryWrapper.PeerConnectionFactoryParameters(clientConfig2.enableDebugLogging, clientConfig2.enableLogcatLogging, clientConfig2.enableVideo, clientConfig2.eglBase));
        j0 j0Var = new j0(pCFactoryWrapper);
        this.f = j0Var;
        j0Var.c = this;
        this.n = new CallManager(this.g, pCFactoryWrapper);
        if (this.h == null) {
            SharedPreferences sharedPreferences = this.g.getSharedPreferences("com.voximplant.sdk.Client.SharedPreferences", 0);
            this.h = sharedPreferences.getString("com.voximplant.sdk.client.Client.DeviceToken", null);
            Logger.i(c() + "device id = " + this.h);
            if (this.h == null) {
                this.h = UUID.randomUUID().toString();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("com.voximplant.sdk.client.Client.DeviceToken", this.h);
                edit.apply();
                Logger.i(c() + "new device id = " + this.h);
            }
        }
        Logger.i(c() + "Voximplant SDK version: " + BuildConfig.VERSION_NAME);
    }

    public final void a(WSMessagePush wSMessagePush) {
        if (this.k.size() == 16) {
            Logger.e("Client: addPushMessageToQueue: already contains max number of requests, cancelling the first in the list");
            WSMessagePush poll = this.k.poll();
            String requestUUID = poll != null ? poll.getRequestUUID() : null;
            if (requestUUID != null) {
                b(requestUUID);
                IPushTokenCompletionHandler remove = this.l.remove(requestUUID);
                if (remove != null) {
                    SharedData.getCallbackExecutor().execute(new Runnable(requestUUID, remove) { // from class: a2.t.a.c.c0
                        public final /* synthetic */ String a;
                        public final /* synthetic */ IPushTokenCompletionHandler b;

                        {
                            this.a = r1;
                            this.b = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            String str = this.a;
                            IPushTokenCompletionHandler iPushTokenCompletionHandler = this.b;
                            Logger.w("Client: cancel push token request for uuid: " + str);
                            iPushTokenCompletionHandler.onFailure(PushTokenError.CANCELLED);
                        }
                    });
                }
            }
        }
        this.k.add(wSMessagePush);
        this.d.smRun(new w(this, this));
    }

    public final void b(String str) {
        ScheduledFuture remove;
        if (str != null && !str.isEmpty() && (remove = this.m.remove(str)) != null) {
            Logger.i("Client: cancelAndRemoveTimeoutFuture: canceled for: " + str);
            remove.cancel(true);
        }
    }

    public final String c() {
        StringBuilder L = a.L("Client [");
        L.append(this.f.b);
        L.append("] ");
        return L.toString();
    }

    @Override // com.voximplant.sdk.client.IClient
    public ICall call(@NonNull String str, @NonNull CallSettings callSettings) {
        if (this.f.b == k0.LOGGED_IN) {
            return this.n.a(str, callSettings, false);
        }
        Logger.e(c() + "call: failed to create call, invalid state (not logged in)");
        return null;
    }

    @Override // com.voximplant.sdk.client.IClient
    public ICall callConference(@NonNull String str, @NonNull CallSettings callSettings) {
        if (this.f.b == k0.LOGGED_IN) {
            return this.n.a(str, callSettings, true);
        }
        Logger.e(c() + "callConference: failed to create call, invalid state (not logged in)");
        return null;
    }

    public void close() {
        this.c.closePeerConnectionFactory();
    }

    @Override // com.voximplant.sdk.client.IClient
    public void connect() throws IllegalStateException {
        Logger.i(c() + "connect");
        connect(false, null);
    }

    public final void d(String str) {
        if (str != null && !str.isEmpty()) {
            this.m.put(str, VoxExecutor.getInstance().smRunDelayed(new Runnable(str) { // from class: a2.t.a.c.f0
                public final /* synthetic */ String b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Client client = Client.this;
                    String str2 = this.b;
                    client.m.remove(str2);
                    SharedData.getCallbackExecutor().execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                          (wrap: java.util.concurrent.Executor : 0x0009: INVOKE  (r2v1 java.util.concurrent.Executor) =  type: STATIC call: com.voximplant.sdk.internal.SharedData.getCallbackExecutor():java.util.concurrent.Executor)
                          (wrap: a2.t.a.c.t : 0x000f: CONSTRUCTOR  (r3v0 a2.t.a.c.t) = (r0v0 'client' com.voximplant.sdk.internal.Client), (r1v0 'str2' java.lang.String) call: a2.t.a.c.t.<init>(com.voximplant.sdk.internal.Client, java.lang.String):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.f0.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: CONSTRUCTOR  (r3v0 a2.t.a.c.t) = (r0v0 'client' com.voximplant.sdk.internal.Client), (r1v0 'str2' java.lang.String) call: a2.t.a.c.t.<init>(com.voximplant.sdk.internal.Client, java.lang.String):void type: CONSTRUCTOR in method: a2.t.a.c.f0.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.t, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 21 more
                        */
                    /*
                        this = this;
                        com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                        java.lang.String r1 = r4.b
                        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ScheduledFuture> r2 = r0.m
                        r2.remove(r1)
                        java.util.concurrent.Executor r2 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                        a2.t.a.c.t r3 = new a2.t.a.c.t
                        r3.<init>(r0, r1)
                        r2.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.f0.run():void");
                }
            }, 10000));
        }
    }

    @Override // com.voximplant.sdk.client.IClient
    public void disconnect() {
        Logger.i(c() + "disconnect");
        this.o = false;
        this.d.smRun(new Runnable() { // from class: a2.t.a.c.l
            @Override // java.lang.Runnable
            public final void run() {
                j0 j0Var = Client.this.f;
                Logger.i(j0Var.a() + "disconnect");
                j0Var.m = true;
                ScheduledFuture scheduledFuture = j0Var.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    j0Var.e = null;
                }
                ScheduledFuture scheduledFuture2 = j0Var.f;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    j0Var.f = null;
                }
                j0Var.a.closeConnection(true);
            }
        });
    }

    @Override // com.voximplant.sdk.client.IClient
    public ClientState getClientState() {
        k0 k0Var = this.f.b;
        Logger.i(c() + "getClientState: connectWasCalled: " + this.o + ", loginWasCalled: " + this.p);
        switch (k0Var.ordinal()) {
            case 0:
                if (this.o) {
                    return ClientState.CONNECTING;
                }
                return ClientState.DISCONNECTED;
            case 1:
            case 2:
            case 3:
            case 4:
                return ClientState.CONNECTING;
            case 5:
                if (this.p) {
                    return ClientState.LOGGING_IN;
                }
                return ClientState.CONNECTED;
            case 6:
                return ClientState.LOGGING_IN;
            case 7:
                return ClientState.LOGGED_IN;
            default:
                return ClientState.DISCONNECTED;
        }
    }

    @Override // com.voximplant.sdk.client.IClient
    public List<String> getSupportedVideoCodecs() {
        return this.c.getSupportedVideoCodecs();
    }

    @Override // com.voximplant.sdk.client.IClient
    public void handlePushNotification(@NonNull Map<String, String> map) {
        Logger.i(c() + "handlePushNotification: message = " + map);
        if (map == null) {
            Logger.e(c() + "handlePushNotification: invalid message (null)");
            return;
        }
        this.d.smRun(new Runnable(map) { // from class: a2.t.a.c.s
            public final /* synthetic */ Map b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Client client = Client.this;
                Map map2 = this.b;
                Objects.requireNonNull(client);
                String str = (String) map2.get("voximplant");
                if (str != null) {
                    client.a(new M_pushFeedback((Map) client.q.fromJson(str, new l0(client).getType())));
                    return;
                }
                Logger.e(client.c() + "handlePushNotification: invalid message (not voximplant)");
            }
        });
    }

    @Override // com.voximplant.sdk.client.IClient
    public void login(@NonNull String str, @NonNull String str2) {
        Logger.i(c() + "login: user = " + str);
        this.p = true;
        this.d.smRun(new Runnable(str, str2) { // from class: a2.t.a.c.k
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i2;
                Client client = Client.this;
                String str3 = this.b;
                String str4 = this.c;
                Objects.requireNonNull(client);
                HashMap hashMap = new HashMap();
                hashMap.put("deviceToken", client.h);
                j0 j0Var = client.f;
                if (j0Var.b == k0.CONNECTED) {
                    if (str3 == null) {
                        i2 = -1;
                    } else {
                        try {
                            i2 = str3.indexOf("@");
                        } catch (NoSuchAlgorithmException unused) {
                            Logger.i(j0Var.a() + "loginWithPassword: basic credential type");
                        }
                    }
                    if (i2 == -1) {
                        j0Var.c.onLoginFailed(null, 404);
                    } else {
                        if (str4 != null) {
                            if (!str4.isEmpty()) {
                                MessageDigest instance = MessageDigest.getInstance(Constants.MD5);
                                byte[] digest = instance.digest((str3.substring(0, i2) + ":voximplant.com:" + str4).getBytes());
                                StringBuilder sb = new StringBuilder();
                                int length = digest.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    sb.append(String.format("%02X", Byte.valueOf(digest[i3])));
                                }
                                str4 = sb.toString().toLowerCase();
                                j0Var.b = k0.TRY_LOGIN;
                                j0Var.f = j0Var.d.smRunDelayed(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bf: IPUT  
                                      (wrap: java.util.concurrent.ScheduledFuture : 0x00bb: INVOKE  (r5v5 java.util.concurrent.ScheduledFuture) = 
                                      (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x00b1: IGET  (r5v4 com.voximplant.sdk.internal.utils.VoxExecutor) = (r4v1 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                      (wrap: a2.t.a.c.d : 0x00b5: CONSTRUCTOR  (r6v1 a2.t.a.c.d) = (r4v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.d.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                      (60000 int)
                                     type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture)
                                      (r4v1 'j0Var' a2.t.a.c.j0)
                                     a2.t.a.c.j0.f java.util.concurrent.ScheduledFuture in method: a2.t.a.c.k.run():void, file: classes8.dex
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
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:150)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bb: INVOKE  (r5v5 java.util.concurrent.ScheduledFuture) = 
                                      (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x00b1: IGET  (r5v4 com.voximplant.sdk.internal.utils.VoxExecutor) = (r4v1 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                      (wrap: a2.t.a.c.d : 0x00b5: CONSTRUCTOR  (r6v1 a2.t.a.c.d) = (r4v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.d.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                      (60000 int)
                                     type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture in method: a2.t.a.c.k.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:455)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                    	... 39 more
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b5: CONSTRUCTOR  (r6v1 a2.t.a.c.d) = (r4v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.d.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR in method: a2.t.a.c.k.run():void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                    	... 43 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.d, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                    	... 49 more
                                    */
                                /*
                                    this = this;
                                    com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                                    java.lang.String r1 = r13.b
                                    java.lang.String r2 = r13.c
                                    java.util.Objects.requireNonNull(r0)
                                    java.util.HashMap r3 = new java.util.HashMap
                                    r3.<init>()
                                    java.lang.String r4 = r0.h
                                    java.lang.String r5 = "deviceToken"
                                    r3.put(r5, r4)
                                    a2.t.a.c.j0 r4 = r0.f
                                    a2.t.a.c.k0 r5 = r4.b
                                    a2.t.a.c.k0 r6 = a2.t.a.c.k0.CONNECTED
                                    r7 = 0
                                    if (r5 != r6) goto L_0x00cc
                                    r5 = -1
                                    if (r1 != 0) goto L_0x0023
                                    r6 = -1
                                    goto L_0x0029
                                L_0x0023:
                                    java.lang.String r6 = "@"
                                    int r6 = r1.indexOf(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                L_0x0029:
                                    if (r6 != r5) goto L_0x0034
                                    a2.t.a.c.m0 r5 = r4.c     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r6 = 404(0x194, float:5.66E-43)
                                    r5.onLoginFailed(r7, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    goto L_0x00dd
                                L_0x0034:
                                    if (r2 == 0) goto L_0x008d
                                    boolean r5 = r2.isEmpty()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    if (r5 == 0) goto L_0x003d
                                    goto L_0x008d
                                L_0x003d:
                                    java.lang.String r5 = "MD5"
                                    java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r7.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r8 = 0
                                    java.lang.String r6 = r1.substring(r8, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r7.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.String r6 = ":voximplant.com:"
                                    r7.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r7.append(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.String r6 = r7.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    byte[] r6 = r6.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    byte[] r5 = r5.digest(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r6.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    int r7 = r5.length     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r9 = 0
                                L_0x006b:
                                    if (r9 >= r7) goto L_0x0084
                                    byte r10 = r5[r9]     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.String r11 = "%02X"
                                    r12 = 1
                                    java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.Byte r10 = java.lang.Byte.valueOf(r10)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r12[r8] = r10     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.String r10 = java.lang.String.format(r11, r12)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r6.append(r10)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    int r9 = r9 + 1
                                    goto L_0x006b
                                L_0x0084:
                                    java.lang.String r5 = r6.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    java.lang.String r2 = r5.toLowerCase()     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    goto L_0x00ad
                                L_0x008d:
                                    a2.t.a.c.m0 r5 = r4.c     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    r6 = 401(0x191, float:5.62E-43)
                                    r5.onLoginFailed(r7, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0095 }
                                    goto L_0x00dd
                                L_0x0095:
                                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                    r5.<init>()
                                    java.lang.String r6 = r4.a()
                                    r5.append(r6)
                                    java.lang.String r6 = "loginWithPassword: basic credential type"
                                    r5.append(r6)
                                    java.lang.String r5 = r5.toString()
                                    com.voximplant.sdk.internal.Logger.i(r5)
                                L_0x00ad:
                                    a2.t.a.c.k0 r5 = a2.t.a.c.k0.TRY_LOGIN
                                    r4.b = r5
                                    com.voximplant.sdk.internal.utils.VoxExecutor r5 = r4.d
                                    a2.t.a.c.d r6 = new a2.t.a.c.d
                                    r6.<init>(r4)
                                    r7 = 60000(0xea60, float:8.4078E-41)
                                    java.util.concurrent.ScheduledFuture r5 = r5.smRunDelayed(r6, r7)
                                    r4.f = r5
                                    com.voximplant.sdk.internal.signaling.Signaling r4 = r4.a
                                    com.voximplant.sdk.internal.proto.M_login r5 = new com.voximplant.sdk.internal.proto.M_login
                                    r5.<init>(r1, r2, r3)
                                    r4.sendMessage(r5)
                                    goto L_0x00dd
                                L_0x00cc:
                                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                    r2.<init>()
                                    java.lang.String r3 = "loginWithPassword: failed due to invalid state"
                                    a2.b.a.a.a.N0(r4, r2, r3)
                                    a2.t.a.c.m0 r2 = r4.c
                                    r3 = 491(0x1eb, float:6.88E-43)
                                    r2.onLoginFailed(r7, r3)
                                L_0x00dd:
                                    java.lang.String r2 = ".voximplant.com"
                                    java.lang.String r3 = ""
                                    java.lang.String r1 = r1.replace(r2, r3)
                                    r0.j = r1
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.k.run():void");
                            }
                        });
                    }

                    @Override // com.voximplant.sdk.client.IClient
                    public void loginWithAccessToken(@NonNull String str, @NonNull String str2) {
                        if (str2 == null || str2.length() <= 5) {
                            Logger.i(c() + "loginWithAccessToken: user = " + str + ", accessToken = " + str2);
                        } else {
                            Logger.i(c() + "loginWithAccessToken: user = " + str + ", accessToken = " + str2.substring(0, 5) + "...");
                        }
                        this.p = true;
                        this.d.smRun(new Runnable(str2, str) { // from class: a2.t.a.c.y
                            public final /* synthetic */ String b;
                            public final /* synthetic */ String c;

                            {
                                this.b = r2;
                                this.c = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Client client = Client.this;
                                String str3 = this.b;
                                String str4 = this.c;
                                Objects.requireNonNull(client);
                                HashMap hashMap = new HashMap();
                                hashMap.put(SDKConstants.PARAM_ACCESS_TOKEN, str3);
                                hashMap.put("deviceToken", client.h);
                                j0 j0Var = client.f;
                                if (j0Var.b == k0.CONNECTED) {
                                    j0Var.f = j0Var.d.smRunDelayed(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: IPUT  
                                          (wrap: java.util.concurrent.ScheduledFuture : 0x002e: INVOKE  (r4v6 java.util.concurrent.ScheduledFuture) = 
                                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0024: IGET  (r4v5 com.voximplant.sdk.internal.utils.VoxExecutor) = (r1v2 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                          (wrap: a2.t.a.c.e : 0x0028: CONSTRUCTOR  (r5v1 a2.t.a.c.e) = (r1v2 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.e.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                          (60000 int)
                                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture)
                                          (r1v2 'j0Var' a2.t.a.c.j0)
                                         a2.t.a.c.j0.f java.util.concurrent.ScheduledFuture in method: a2.t.a.c.y.run():void, file: classes8.dex
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
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE  (r4v6 java.util.concurrent.ScheduledFuture) = 
                                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0024: IGET  (r4v5 com.voximplant.sdk.internal.utils.VoxExecutor) = (r1v2 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                          (wrap: a2.t.a.c.e : 0x0028: CONSTRUCTOR  (r5v1 a2.t.a.c.e) = (r1v2 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.e.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                          (60000 int)
                                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture in method: a2.t.a.c.y.run():void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:455)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                        	... 21 more
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: CONSTRUCTOR  (r5v1 a2.t.a.c.e) = (r1v2 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.e.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR in method: a2.t.a.c.y.run():void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                        	... 25 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.e, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                        	... 31 more
                                        */
                                    /*
                                        this = this;
                                        com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                                        java.lang.String r1 = r8.b
                                        java.lang.String r2 = r8.c
                                        java.util.Objects.requireNonNull(r0)
                                        java.util.HashMap r3 = new java.util.HashMap
                                        r3.<init>()
                                        java.lang.String r4 = "accessToken"
                                        r3.put(r4, r1)
                                        java.lang.String r1 = r0.h
                                        java.lang.String r4 = "deviceToken"
                                        r3.put(r4, r1)
                                        a2.t.a.c.j0 r1 = r0.f
                                        a2.t.a.c.k0 r4 = r1.b
                                        a2.t.a.c.k0 r5 = a2.t.a.c.k0.CONNECTED
                                        java.lang.String r6 = ""
                                        if (r4 != r5) goto L_0x0043
                                        com.voximplant.sdk.internal.utils.VoxExecutor r4 = r1.d
                                        a2.t.a.c.e r5 = new a2.t.a.c.e
                                        r5.<init>(r1)
                                        r7 = 60000(0xea60, float:8.4078E-41)
                                        java.util.concurrent.ScheduledFuture r4 = r4.smRunDelayed(r5, r7)
                                        r1.f = r4
                                        a2.t.a.c.k0 r4 = a2.t.a.c.k0.TRY_LOGIN
                                        r1.b = r4
                                        com.voximplant.sdk.internal.signaling.Signaling r1 = r1.a
                                        com.voximplant.sdk.internal.proto.M_login r4 = new com.voximplant.sdk.internal.proto.M_login
                                        r4.<init>(r2, r6, r3)
                                        r1.sendMessage(r4)
                                        goto L_0x0055
                                    L_0x0043:
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        r3.<init>()
                                        java.lang.String r4 = "loginWithToken: failed due to invalid state"
                                        a2.b.a.a.a.N0(r1, r3, r4)
                                        a2.t.a.c.m0 r1 = r1.c
                                        r3 = 0
                                        r4 = 491(0x1eb, float:6.88E-43)
                                        r1.onLoginFailed(r3, r4)
                                    L_0x0055:
                                        java.lang.String r1 = ".voximplant.com"
                                        java.lang.String r1 = r2.replace(r1, r6)
                                        r0.j = r1
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.y.run():void");
                                }
                            });
                        }

                        @Override // com.voximplant.sdk.client.IClient
                        public void loginWithOneTimeKey(@NonNull String str, @NonNull String str2) {
                            Logger.i(c() + "loginWithOneTimeKey(user = " + str + ", hash = " + str2 + " )");
                            this.p = true;
                            HashMap hashMap = new HashMap();
                            hashMap.put("deviceToken", this.h);
                            this.d.smRun(new Runnable(str, str2, hashMap) { // from class: a2.t.a.c.a0
                                public final /* synthetic */ String b;
                                public final /* synthetic */ String c;
                                public final /* synthetic */ Map d;

                                {
                                    this.b = r2;
                                    this.c = r3;
                                    this.d = r4;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Client client = Client.this;
                                    String str3 = this.b;
                                    String str4 = this.c;
                                    Map map = this.d;
                                    j0 j0Var = client.f;
                                    if (j0Var.b == k0.CONNECTED) {
                                        j0Var.f = j0Var.d.smRunDelayed(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: IPUT  
                                              (wrap: java.util.concurrent.ScheduledFuture : 0x001a: INVOKE  (r5v2 java.util.concurrent.ScheduledFuture) = 
                                              (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0010: IGET  (r5v1 com.voximplant.sdk.internal.utils.VoxExecutor) = (r4v0 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                              (wrap: a2.t.a.c.h : 0x0014: CONSTRUCTOR  (r6v1 a2.t.a.c.h) = (r4v0 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.h.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                              (60000 int)
                                             type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture)
                                              (r4v0 'j0Var' a2.t.a.c.j0)
                                             a2.t.a.c.j0.f java.util.concurrent.ScheduledFuture in method: a2.t.a.c.a0.run():void, file: classes8.dex
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
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  (r5v2 java.util.concurrent.ScheduledFuture) = 
                                              (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0010: IGET  (r5v1 com.voximplant.sdk.internal.utils.VoxExecutor) = (r4v0 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                              (wrap: a2.t.a.c.h : 0x0014: CONSTRUCTOR  (r6v1 a2.t.a.c.h) = (r4v0 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.h.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                              (60000 int)
                                             type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture in method: a2.t.a.c.a0.run():void, file: classes8.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:455)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                            	... 21 more
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: CONSTRUCTOR  (r6v1 a2.t.a.c.h) = (r4v0 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.h.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR in method: a2.t.a.c.a0.run():void, file: classes8.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                            	... 25 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.h, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                            	... 31 more
                                            */
                                        /*
                                            this = this;
                                            com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                                            java.lang.String r1 = r8.b
                                            java.lang.String r2 = r8.c
                                            java.util.Map r3 = r8.d
                                            a2.t.a.c.j0 r4 = r0.f
                                            a2.t.a.c.k0 r5 = r4.b
                                            a2.t.a.c.k0 r6 = a2.t.a.c.k0.CONNECTED
                                            if (r5 != r6) goto L_0x002f
                                            com.voximplant.sdk.internal.utils.VoxExecutor r5 = r4.d
                                            a2.t.a.c.h r6 = new a2.t.a.c.h
                                            r6.<init>(r4)
                                            r7 = 60000(0xea60, float:8.4078E-41)
                                            java.util.concurrent.ScheduledFuture r5 = r5.smRunDelayed(r6, r7)
                                            r4.f = r5
                                            a2.t.a.c.k0 r5 = a2.t.a.c.k0.TRY_LOGIN
                                            r4.b = r5
                                            com.voximplant.sdk.internal.signaling.Signaling r4 = r4.a
                                            com.voximplant.sdk.internal.proto.M_loginUsingOneTimeKey r5 = new com.voximplant.sdk.internal.proto.M_loginUsingOneTimeKey
                                            r5.<init>(r1, r2, r3)
                                            r4.sendMessage(r5)
                                            goto L_0x0041
                                        L_0x002f:
                                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                            r2.<init>()
                                            java.lang.String r3 = "loginWithOneTimeKey: failed due to invalid state"
                                            a2.b.a.a.a.N0(r4, r2, r3)
                                            a2.t.a.c.m0 r2 = r4.c
                                            r3 = 0
                                            r4 = 491(0x1eb, float:6.88E-43)
                                            r2.onLoginFailed(r3, r4)
                                        L_0x0041:
                                            java.lang.String r2 = ".voximplant.com"
                                            java.lang.String r3 = ""
                                            java.lang.String r1 = r1.replace(r2, r3)
                                            r0.j = r1
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.a0.run():void");
                                    }
                                });
                            }

                            @Override // a2.t.a.c.m0
                            public void onConnected() {
                                Logger.i(c() + "onConnected");
                                this.o = false;
                                this.n.b.startHeadsetMonitoring();
                                this.a.addSessionCallbackToQueue(new OnConnectionEstablished());
                            }

                            @Override // a2.t.a.c.m0
                            public void onConnectionFail(String str) {
                                Logger.i(c() + "onConnectionFailed");
                                this.j = null;
                                SharedData.a = null;
                                this.o = false;
                                this.p = false;
                                this.n.b(new CallManager.a(str) { // from class: a2.t.a.c.d0
                                    public final /* synthetic */ String b;

                                    {
                                        this.b = r2;
                                    }

                                    @Override // com.voximplant.sdk.internal.CallManager.a
                                    public final void onComplete() {
                                        Client.this.a.addSessionCallbackToQueue(new OnConnectionFailed(this.b));
                                    }
                                });
                            }

                            @Override // a2.t.a.c.m0
                            public void onDisconnected() {
                                Logger.i(c() + "onDisconnected");
                                this.d.smRun(new Runnable() { // from class: a2.t.a.c.n
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Client client = Client.this;
                                        client.j = null;
                                        SharedData.a = null;
                                        client.o = false;
                                        client.p = false;
                                        if (client.l.size() > 0) {
                                            for (Map.Entry<String, IPushTokenCompletionHandler> entry : client.l.entrySet()) {
                                                client.b(entry.getKey());
                                                SharedData.getCallbackExecutor().execute(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: INVOKE  
                                                      (wrap: java.util.concurrent.Executor : 0x0033: INVOKE  (r3v2 java.util.concurrent.Executor) =  type: STATIC call: com.voximplant.sdk.internal.SharedData.getCallbackExecutor():java.util.concurrent.Executor)
                                                      (wrap: a2.t.a.c.q : 0x0039: CONSTRUCTOR  (r4v0 a2.t.a.c.q) = (r2v3 'entry' java.util.Map$Entry<java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler>) call: a2.t.a.c.q.<init>(java.util.Map$Entry):void type: CONSTRUCTOR)
                                                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.n.run():void, file: classes8.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: CONSTRUCTOR  (r4v0 a2.t.a.c.q) = (r2v3 'entry' java.util.Map$Entry<java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler>) call: a2.t.a.c.q.<init>(java.util.Map$Entry):void type: CONSTRUCTOR in method: a2.t.a.c.n.run():void, file: classes8.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                                    	... 27 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.q, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                    	... 33 more
                                                    */
                                                /*
                                                    this = this;
                                                    com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                                                    r1 = 0
                                                    r0.j = r1
                                                    com.voximplant.sdk.internal.SharedData.a = r1
                                                    r1 = 0
                                                    r0.o = r1
                                                    r0.p = r1
                                                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler> r1 = r0.l
                                                    int r1 = r1.size()
                                                    if (r1 <= 0) goto L_0x0045
                                                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler> r1 = r0.l
                                                    java.util.Set r1 = r1.entrySet()
                                                    java.util.Iterator r1 = r1.iterator()
                                                L_0x001e:
                                                    boolean r2 = r1.hasNext()
                                                    if (r2 == 0) goto L_0x0040
                                                    java.lang.Object r2 = r1.next()
                                                    java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                                                    java.lang.Object r3 = r2.getKey()
                                                    java.lang.String r3 = (java.lang.String) r3
                                                    r0.b(r3)
                                                    java.util.concurrent.Executor r3 = com.voximplant.sdk.internal.SharedData.getCallbackExecutor()
                                                    a2.t.a.c.q r4 = new a2.t.a.c.q
                                                    r4.<init>(r2)
                                                    r3.execute(r4)
                                                    goto L_0x001e
                                                L_0x0040:
                                                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler> r1 = r0.l
                                                    r1.clear()
                                                L_0x0045:
                                                    com.voximplant.sdk.internal.CallManager r1 = r0.n
                                                    a2.t.a.c.x r2 = new a2.t.a.c.x
                                                    r2.<init>(r0)
                                                    r1.b(r2)
                                                    com.voximplant.sdk.internal.CallManager r0 = r0.n
                                                    com.voximplant.sdk.internal.hardware.VoxAudioManager r0 = r0.b
                                                    r0.stopHeadsetMonitoring()
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n.run():void");
                                            }
                                        });
                                    }

                                    @Override // a2.t.a.c.m0
                                    public void onLoginFailed(WSMessage wSMessage, int i2) {
                                        Logger.i(c() + "onLoginFailed: error: " + i2);
                                        this.p = false;
                                        if (!(wSMessage instanceof M_loginFailed) || i2 != -1) {
                                            this.b.addLoginCallbackToQueue(new OnLoginFailed(i2));
                                        } else if (this.f.b != k0.CONNECTED) {
                                            Logger.w(c() + "Not able to process loginFailed message due to invalid state");
                                        } else {
                                            M_loginFailed m_loginFailed = (M_loginFailed) wSMessage;
                                            int errorCode = m_loginFailed.getErrorCode();
                                            if (errorCode == 302) {
                                                this.b.addLoginCallbackToQueue(new OnOneTimeKeyGenerated(m_loginFailed.getOneTimeKey()));
                                                return;
                                            }
                                            this.p = false;
                                            this.b.addLoginCallbackToQueue(new OnLoginFailed(errorCode));
                                        }
                                    }

                                    @Override // a2.t.a.c.m0
                                    public void onLoginSuccess(WSMessage wSMessage) {
                                        if (!(wSMessage instanceof M_loginSuccessful)) {
                                            return;
                                        }
                                        if (this.f.b != k0.LOGGED_IN) {
                                            Logger.w(c() + "Not able to process loginSuccessFul message due to invalid state");
                                            return;
                                        }
                                        this.p = false;
                                        SharedData.a = this.j;
                                        M_loginSuccessful m_loginSuccessful = (M_loginSuccessful) wSMessage;
                                        this.d.smRun(new w(this, this));
                                        this.b.addLoginCallbackToQueue(new OnLoginSuccessful(m_loginSuccessful.getDisplayName(), new AuthParams(m_loginSuccessful.getAccessExpire(), m_loginSuccessful.getAccessToken(), m_loginSuccessful.getRefreshExpire(), m_loginSuccessful.getRefreshToken())));
                                        CallManager callManager = this.n;
                                        List<PeerConnection.IceServer> stunServers = m_loginSuccessful.getStunServers();
                                        List<PeerConnection.IceServer> iceServers = m_loginSuccessful.getIceServers();
                                        ClientConfig clientConfig = this.i;
                                        callManager.g = stunServers;
                                        callManager.h = iceServers;
                                        callManager.i = clientConfig.preferredVideoCodec;
                                        callManager.j = clientConfig.enableVideo;
                                        callManager.k = clientConfig.enableCameraMirroring;
                                        callManager.l = clientConfig.requestAudioFocusMode;
                                        int i2 = clientConfig.statsCollectionInterval;
                                        if (i2 < 0) {
                                            Logger.w("CallManager: initialize: statsCollectionInterval is less 0, setting to 0");
                                            callManager.m = 0;
                                        } else if (i2 <= 0 || i2 >= 500) {
                                            int i3 = i2 % 500;
                                            if (i3 != 0) {
                                                callManager.m = i3 * 500;
                                                StringBuilder L = a.L("CallManager: initialize: statsCollectionInterval is not a multiple of 500ms, setting to: ");
                                                L.append(callManager.m);
                                                Logger.w(L.toString());
                                                return;
                                            }
                                            callManager.m = i2;
                                        } else {
                                            callManager.m = 500;
                                            Logger.w("CallManager: initialize: statsCollectionInterval is less 500ms, setting to 500ms");
                                        }
                                    }

                                    @Override // com.voximplant.sdk.internal.signaling.IMessageListener
                                    public void onMessage(WSMessage wSMessage) {
                                        this.d.smRun(new Runnable(wSMessage) { // from class: a2.t.a.c.m
                                            public final /* synthetic */ WSMessage b;

                                            {
                                                this.b = r2;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                Client client = Client.this;
                                                WSMessage wSMessage2 = this.b;
                                                Objects.requireNonNull(client);
                                                if ((wSMessage2 instanceof WSMessagePush) && ((wSMessage2 instanceof M_registerPushTokenResult) || (wSMessage2 instanceof M_unregisterPushTokenResult))) {
                                                    String requestUUID = ((WSMessagePush) wSMessage2).getRequestUUID();
                                                    if (requestUUID != null) {
                                                        client.b(requestUUID);
                                                        IPushTokenCompletionHandler remove = client.l.remove(requestUUID);
                                                        if (remove != null) {
                                                            SharedData.getCallbackExecutor().execute(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: INVOKE  
                                                                  (wrap: java.util.concurrent.Executor : 0x002d: INVOKE  (r4v10 java.util.concurrent.Executor) =  type: STATIC call: com.voximplant.sdk.internal.SharedData.getCallbackExecutor():java.util.concurrent.Executor)
                                                                  (wrap: a2.t.a.c.u : 0x0033: CONSTRUCTOR  (r5v5 a2.t.a.c.u) = 
                                                                  (r1v0 'wSMessage2' com.voximplant.sdk.internal.proto.WSMessage)
                                                                  (r2v17 'requestUUID' java.lang.String)
                                                                  (r3v29 'remove' com.voximplant.sdk.client.IPushTokenCompletionHandler)
                                                                 call: a2.t.a.c.u.<init>(com.voximplant.sdk.internal.proto.WSMessage, java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler):void type: CONSTRUCTOR)
                                                                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: a2.t.a.c.m.run():void, file: classes8.dex
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
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: CONSTRUCTOR  (r5v5 a2.t.a.c.u) = 
                                                                  (r1v0 'wSMessage2' com.voximplant.sdk.internal.proto.WSMessage)
                                                                  (r2v17 'requestUUID' java.lang.String)
                                                                  (r3v29 'remove' com.voximplant.sdk.client.IPushTokenCompletionHandler)
                                                                 call: a2.t.a.c.u.<init>(com.voximplant.sdk.internal.proto.WSMessage, java.lang.String, com.voximplant.sdk.client.IPushTokenCompletionHandler):void type: CONSTRUCTOR in method: a2.t.a.c.m.run():void, file: classes8.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                                                	... 33 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.u, state: NOT_LOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                                	... 39 more
                                                                */
                                                            /*
                                                            // Method dump skipped, instructions count: 556
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.m.run():void");
                                                        }
                                                    });
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void refreshToken(@NonNull String str, @NonNull String str2) {
                                                    if (str2 == null || str2.length() <= 5) {
                                                        Logger.i(c() + "refreshToken: user = " + str + ", token = " + str2);
                                                    } else {
                                                        Logger.i(c() + "refreshToken: user = " + str + ", token = " + str2.substring(0, 5) + "...");
                                                    }
                                                    this.d.smRun(new Runnable(str2, str) { // from class: a2.t.a.c.v
                                                        public final /* synthetic */ String b;
                                                        public final /* synthetic */ String c;

                                                        {
                                                            this.b = r2;
                                                            this.c = r3;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Client client = Client.this;
                                                            String str3 = this.b;
                                                            String str4 = this.c;
                                                            k0 k0Var = client.f.b;
                                                            if (k0Var == k0.CONNECTED || k0Var == k0.TRY_LOGIN || k0Var == k0.LOGGED_IN) {
                                                                HashMap k0 = a.k0("refreshToken", str3);
                                                                k0.put("deviceToken", client.h);
                                                                client.e.sendMessage(new M_refreshOauthToken(str4, k0));
                                                                return;
                                                            }
                                                            Logger.w(client.c() + "refreshToken: user = " + str4 + ", token = " + str3.substring(0, 5) + "... Failed in invalid state");
                                                        }
                                                    });
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void registerForPushNotifications(String str, IPushTokenCompletionHandler iPushTokenCompletionHandler) {
                                                    Logger.i(c() + "registerForPushNotifications");
                                                    if (str == null || str.isEmpty()) {
                                                        Logger.e(c() + "registerForPushNotifications: invalid registration token (null)");
                                                        SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.r
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                IPushTokenCompletionHandler iPushTokenCompletionHandler2 = IPushTokenCompletionHandler.this;
                                                                if (iPushTokenCompletionHandler2 != null) {
                                                                    iPushTokenCompletionHandler2.onFailure(PushTokenError.INVALID_TOKEN);
                                                                }
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    this.d.smRun(new Runnable(str, iPushTokenCompletionHandler) { // from class: a2.t.a.c.z
                                                        public final /* synthetic */ String b;
                                                        public final /* synthetic */ IPushTokenCompletionHandler c;

                                                        {
                                                            this.b = r2;
                                                            this.c = r3;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Client client = Client.this;
                                                            String str2 = this.b;
                                                            IPushTokenCompletionHandler iPushTokenCompletionHandler2 = this.c;
                                                            String str3 = client.i.packageName;
                                                            if (str3 != null && !str3.isEmpty()) {
                                                                HashMap k0 = a.k0(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, str2);
                                                                k0.put("bundle", client.i.packageName);
                                                                str2 = client.q.toJson(k0);
                                                            }
                                                            String uuid = UUID.randomUUID().toString();
                                                            if (iPushTokenCompletionHandler2 != null) {
                                                                client.l.put(uuid, iPushTokenCompletionHandler2);
                                                            }
                                                            if (client.f.b == k0.LOGGED_IN) {
                                                                client.d(uuid);
                                                                client.e.sendMessage(new M_registerPushToken(str2, uuid));
                                                                return;
                                                            }
                                                            client.a(new M_registerPushToken(str2, uuid));
                                                        }
                                                    });
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void requestOneTimeKey(@NonNull String str) {
                                                    Logger.i(c() + "requestOneTimeKey(user = " + str + " )");
                                                    this.d.smRun(new Runnable(str) { // from class: a2.t.a.c.b0
                                                        public final /* synthetic */ String b;

                                                        {
                                                            this.b = r2;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Client client = Client.this;
                                                            String str2 = this.b;
                                                            j0 j0Var = client.f;
                                                            if (j0Var.b == k0.CONNECTED) {
                                                                j0Var.b = k0.TRY_LOGIN;
                                                                j0Var.a.sendMessage(new M_loginGenerateOneTimeKey(str2));
                                                                return;
                                                            }
                                                            a.N0(j0Var, new StringBuilder(), "requestOneTimeKey: failed due to invalid state");
                                                            j0Var.c.onLoginFailed(null, 491);
                                                        }
                                                    });
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void setClientIncomingCallListener(IClientIncomingCallListener iClientIncomingCallListener) {
                                                    Logger.i(c() + "setClientIncomingCallListener: " + iClientIncomingCallListener);
                                                    this.n.e.setIncomingCallListener(iClientIncomingCallListener);
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void setClientLoginListener(IClientLoginListener iClientLoginListener) {
                                                    Logger.i(c() + "setClientLoginListener: " + iClientLoginListener);
                                                    this.b.setLoginListener(iClientLoginListener);
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void setClientSessionListener(IClientSessionListener iClientSessionListener) {
                                                    Logger.i(c() + "setClientSessionListener: " + iClientSessionListener);
                                                    this.a.setSessionListener(iClientSessionListener);
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void unregisterFromPushNotifications(String str, IPushTokenCompletionHandler iPushTokenCompletionHandler) {
                                                    Logger.i(c() + "unregisterFromPushNotifications");
                                                    if (str == null || str.isEmpty()) {
                                                        Logger.e(c() + "unregisterFromPushNotifications: invalid registration token (null)");
                                                        SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.o
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                IPushTokenCompletionHandler iPushTokenCompletionHandler2 = IPushTokenCompletionHandler.this;
                                                                if (iPushTokenCompletionHandler2 != null) {
                                                                    iPushTokenCompletionHandler2.onFailure(PushTokenError.INVALID_TOKEN);
                                                                }
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    this.d.smRun(new Runnable(str, iPushTokenCompletionHandler) { // from class: a2.t.a.c.p
                                                        public final /* synthetic */ String b;
                                                        public final /* synthetic */ IPushTokenCompletionHandler c;

                                                        {
                                                            this.b = r2;
                                                            this.c = r3;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Client client = Client.this;
                                                            String str2 = this.b;
                                                            IPushTokenCompletionHandler iPushTokenCompletionHandler2 = this.c;
                                                            String str3 = client.i.packageName;
                                                            if (str3 != null && !str3.isEmpty()) {
                                                                HashMap k0 = a.k0(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, str2);
                                                                k0.put("bundle", client.i.packageName);
                                                                str2 = client.q.toJson(k0);
                                                            }
                                                            String uuid = UUID.randomUUID().toString();
                                                            if (iPushTokenCompletionHandler2 != null) {
                                                                client.l.put(uuid, iPushTokenCompletionHandler2);
                                                            }
                                                            if (client.f.b == k0.LOGGED_IN) {
                                                                client.d(uuid);
                                                                client.e.sendMessage(new M_unregisterPushToken(str2, uuid));
                                                                return;
                                                            }
                                                            client.a(new M_unregisterPushToken(str2, uuid));
                                                        }
                                                    });
                                                }

                                                @Override // com.voximplant.sdk.client.IClient
                                                public void connect(boolean z, List<String> list) throws IllegalStateException {
                                                    Logger.i(c() + "connect: connectivity check: " + z);
                                                    if (this.f.b != k0.DISCONNECTED || this.o) {
                                                        Logger.e(c() + "connect: failed due to invalid state");
                                                        throw new IllegalStateException("Failed to connect due to invalid state");
                                                    }
                                                    this.o = true;
                                                    this.d.smRun(new Runnable(z, list) { // from class: a2.t.a.c.e0
                                                        public final /* synthetic */ boolean b;
                                                        public final /* synthetic */ List c;

                                                        {
                                                            this.b = r2;
                                                            this.c = r3;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Client client = Client.this;
                                                            boolean z2 = this.b;
                                                            List<String> list2 = this.c;
                                                            j0 j0Var = client.f;
                                                            if (j0Var.b != k0.DISCONNECTED) {
                                                                a.N0(j0Var, new StringBuilder(), "connect: failed due to invalid state");
                                                                return;
                                                            }
                                                            j0Var.h = z2;
                                                            if (list2 == null || list2.isEmpty()) {
                                                                j0Var.b = k0.REQUEST_TO_BALANCER;
                                                                Logger.i(j0Var.a());
                                                                try {
                                                                    j0Var.e = j0Var.d.smRunDelayed(
                                                                    /*  JADX ERROR: Method code generation error
                                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0042: IPUT  
                                                                          (wrap: java.util.concurrent.ScheduledFuture : 0x003e: INVOKE  (r1v7 java.util.concurrent.ScheduledFuture) = 
                                                                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0035: IGET  (r1v6 com.voximplant.sdk.internal.utils.VoxExecutor) = (r0v1 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                                                          (wrap: a2.t.a.c.f : 0x0039: CONSTRUCTOR  (r2v2 a2.t.a.c.f) = (r0v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.f.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                                                          (wrap: int : ?: SGET   com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT int)
                                                                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture)
                                                                          (r0v1 'j0Var' a2.t.a.c.j0)
                                                                         a2.t.a.c.j0.e java.util.concurrent.ScheduledFuture in method: a2.t.a.c.e0.run():void, file: classes8.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:316)
                                                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
                                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003e: INVOKE  (r1v7 java.util.concurrent.ScheduledFuture) = 
                                                                          (wrap: com.voximplant.sdk.internal.utils.VoxExecutor : 0x0035: IGET  (r1v6 com.voximplant.sdk.internal.utils.VoxExecutor) = (r0v1 'j0Var' a2.t.a.c.j0) a2.t.a.c.j0.d com.voximplant.sdk.internal.utils.VoxExecutor)
                                                                          (wrap: a2.t.a.c.f : 0x0039: CONSTRUCTOR  (r2v2 a2.t.a.c.f) = (r0v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.f.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR)
                                                                          (wrap: int : ?: SGET   com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT int)
                                                                         type: VIRTUAL call: com.voximplant.sdk.internal.utils.VoxExecutor.smRunDelayed(java.lang.Runnable, int):java.util.concurrent.ScheduledFuture in method: a2.t.a.c.e0.run():void, file: classes8.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:455)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                                                        	... 31 more
                                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: CONSTRUCTOR  (r2v2 a2.t.a.c.f) = (r0v1 'j0Var' a2.t.a.c.j0) call: a2.t.a.c.f.<init>(a2.t.a.c.j0):void type: CONSTRUCTOR in method: a2.t.a.c.e0.run():void, file: classes8.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                                        	... 35 more
                                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.f, state: NOT_LOADED
                                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                                                        	... 41 more
                                                                        */
                                                                    /*
                                                                        this = this;
                                                                        com.voximplant.sdk.internal.Client r0 = com.voximplant.sdk.internal.Client.this
                                                                        boolean r1 = r5.b
                                                                        java.util.List r2 = r5.c
                                                                        a2.t.a.c.j0 r0 = r0.f
                                                                        a2.t.a.c.k0 r3 = r0.b
                                                                        a2.t.a.c.k0 r4 = a2.t.a.c.k0.DISCONNECTED
                                                                        if (r3 == r4) goto L_0x0019
                                                                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                                                        r1.<init>()
                                                                        java.lang.String r2 = "connect: failed due to invalid state"
                                                                        a2.b.a.a.a.N0(r0, r1, r2)
                                                                        goto L_0x007f
                                                                    L_0x0019:
                                                                        r0.h = r1
                                                                        if (r2 == 0) goto L_0x002a
                                                                        boolean r1 = r2.isEmpty()
                                                                        if (r1 == 0) goto L_0x0024
                                                                        goto L_0x002a
                                                                    L_0x0024:
                                                                        r0.l = r2
                                                                        r0.c()
                                                                        goto L_0x007f
                                                                    L_0x002a:
                                                                        a2.t.a.c.k0 r1 = a2.t.a.c.k0.REQUEST_TO_BALANCER
                                                                        r0.b = r1
                                                                        java.lang.String r1 = r0.a()
                                                                        com.voximplant.sdk.internal.Logger.i(r1)
                                                                        com.voximplant.sdk.internal.utils.VoxExecutor r1 = r0.d     // Catch:{ Exception -> 0x005e }
                                                                        a2.t.a.c.f r2 = new a2.t.a.c.f     // Catch:{ Exception -> 0x005e }
                                                                        r2.<init>(r0)     // Catch:{ Exception -> 0x005e }
                                                                        r3 = 30000(0x7530, float:4.2039E-41)
                                                                        java.util.concurrent.ScheduledFuture r1 = r1.smRunDelayed(r2, r3)     // Catch:{ Exception -> 0x005e }
                                                                        r0.e = r1     // Catch:{ Exception -> 0x005e }
                                                                        okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x005e }
                                                                        r1.<init>()     // Catch:{ Exception -> 0x005e }
                                                                        java.lang.String r2 = "https://balancer.voximplant.com/getNearestHost"
                                                                        okhttp3.Request$Builder r1 = r1.url(r2)     // Catch:{ Exception -> 0x005e }
                                                                        okhttp3.Request r1 = r1.build()     // Catch:{ Exception -> 0x005e }
                                                                        com.voximplant.sdk.internal.signaling.Signaling r2 = r0.a     // Catch:{ Exception -> 0x005e }
                                                                        a2.t.a.c.h0 r3 = new a2.t.a.c.h0     // Catch:{ Exception -> 0x005e }
                                                                        r3.<init>(r0)     // Catch:{ Exception -> 0x005e }
                                                                        r2.makeHttpRequest(r1, r3)     // Catch:{ Exception -> 0x005e }
                                                                        goto L_0x007f
                                                                    L_0x005e:
                                                                        r1 = move-exception
                                                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                                                        r2.<init>()
                                                                        java.lang.String r3 = r0.a()
                                                                        r2.append(r3)
                                                                        java.lang.String r3 = "requestToBalancer: exception:"
                                                                        r2.append(r3)
                                                                        r2.append(r1)
                                                                        java.lang.String r1 = r2.toString()
                                                                        com.voximplant.sdk.internal.Logger.e(r1)
                                                                        java.lang.String r1 = "request to balancer is failed"
                                                                        r0.b(r1)
                                                                    L_0x007f:
                                                                        return
                                                                    */
                                                                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.e0.run():void");
                                                                }
                                                            });
                                                        }
                                                    }
