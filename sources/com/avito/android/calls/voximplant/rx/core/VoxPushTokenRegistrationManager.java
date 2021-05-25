package com.avito.android.calls.voximplant.rx.core;

import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.IPushTokenCompletionHandler;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\f\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/VoxPushTokenRegistrationManager;", "", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lio/reactivex/rxjava3/core/Completable;", "register", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "unregister", "Lkotlin/Function1;", "Lcom/voximplant/sdk/client/IPushTokenCompletionHandler;", "", "clientCall", AuthSource.SEND_ABUSE, "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/voximplant/sdk/client/IClient;", "Lcom/voximplant/sdk/client/IClient;", "client", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/voximplant/sdk/client/IClient;Lcom/avito/android/util/SchedulersFactory3;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxPushTokenRegistrationManager {
    public final IClient a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<Throwable, CompletableSource> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof CallClientException.CantUpdatePushTokenException) {
                return Completable.error(th2);
            }
            return Completable.error(new CallClientException.CantUpdatePushTokenException(th2));
        }
    }

    public static final class b extends Lambda implements Function1<IPushTokenCompletionHandler, Unit> {
        public final /* synthetic */ VoxPushTokenRegistrationManager a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VoxPushTokenRegistrationManager voxPushTokenRegistrationManager, String str) {
            super(1);
            this.a = voxPushTokenRegistrationManager;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(IPushTokenCompletionHandler iPushTokenCompletionHandler) {
            IPushTokenCompletionHandler iPushTokenCompletionHandler2 = iPushTokenCompletionHandler;
            Intrinsics.checkNotNullParameter(iPushTokenCompletionHandler2, "callback");
            StringBuilder sb = new StringBuilder();
            sb.append("Push token: register token=[");
            Logs.debug$default(LogTagsKt.TAG_IAC, a2.b.a.a.a.s(sb, this.b, ']'), null, 4, null);
            this.a.a.registerForPushNotifications(this.b, iPushTokenCompletionHandler2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<IPushTokenCompletionHandler, Unit> {
        public final /* synthetic */ VoxPushTokenRegistrationManager a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(VoxPushTokenRegistrationManager voxPushTokenRegistrationManager, String str) {
            super(1);
            this.a = voxPushTokenRegistrationManager;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(IPushTokenCompletionHandler iPushTokenCompletionHandler) {
            IPushTokenCompletionHandler iPushTokenCompletionHandler2 = iPushTokenCompletionHandler;
            Intrinsics.checkNotNullParameter(iPushTokenCompletionHandler2, "callback");
            StringBuilder sb = new StringBuilder();
            sb.append("Push token: unregister token=[");
            Logs.debug$default(LogTagsKt.TAG_IAC, a2.b.a.a.a.s(sb, this.b, ']'), null, 4, null);
            this.a.a.unregisterFromPushNotifications(this.b, iPushTokenCompletionHandler2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VoxPushTokenRegistrationManager(@NotNull IClient iClient, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(iClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = iClient;
        this.b = schedulersFactory3;
    }

    public final Completable a(Function1<? super IPushTokenCompletionHandler, Unit> function1) {
        Completable retryWhen = Completable.create(new CompletableOnSubscribe(function1) { // from class: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                this.a.invoke(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  
                      (wrap: kotlin.jvm.functions.Function1 : 0x0005: IGET  (r2v1 kotlin.jvm.functions.Function1) = 
                      (r1v0 'this' com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1 A[IMMUTABLE_TYPE, THIS])
                     com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1.a kotlin.jvm.functions.Function1)
                      (wrap: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1 : 0x0002: CONSTRUCTOR  (r0v0 com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1) = (r2v0 'completableEmitter' io.reactivex.rxjava3.core.CompletableEmitter) call: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1.<init>(io.reactivex.rxjava3.core.CompletableEmitter):void type: CONSTRUCTOR)
                     type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object in method: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1.subscribe(io.reactivex.rxjava3.core.CompletableEmitter):void, file: classes2.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONSTRUCTOR  (r0v0 com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1) = (r2v0 'completableEmitter' io.reactivex.rxjava3.core.CompletableEmitter) call: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1.<init>(io.reactivex.rxjava3.core.CompletableEmitter):void type: CONSTRUCTOR in method: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1.subscribe(io.reactivex.rxjava3.core.CompletableEmitter):void, file: classes2.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1 r0 = new com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1$callback$1
                    r0.<init>(r2)
                    kotlin.jvm.functions.Function1 r2 = r1.a
                    r2.invoke(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager$preparePushTokenUpdateRequest$1.subscribe(io.reactivex.rxjava3.core.CompletableEmitter):void");
            }
        }).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(a.a).retryWhen(CallClientUtilsKt.exponentialRetryCallRequest$default(this.b.computation(), null, 2, null));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "Completable.create { emi…          )\n            )");
        return retryWhen;
    }

    @NotNull
    public final Completable register(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        return a(new b(this, str));
    }

    @NotNull
    public final Completable unregister(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        return a(new c(this, str));
    }
}
