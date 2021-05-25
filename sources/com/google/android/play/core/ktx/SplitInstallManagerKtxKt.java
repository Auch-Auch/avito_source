package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\u001a7\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0012\u001a\u00020\u000f*\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u001f\u0010\u0014\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001a%\u0010\u0018\u001a\u00020\u000f*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0011\u001a%\u0010\u0019\u001a\u00020\u000f*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011\u001aû\u0001\u0010'\u001a\u00020&2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0004\b'\u0010(\u001a)\u0010.\u001a\u00020-*\u00020\u00002\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/\"\u0018\u00102\u001a\u00020\u0005*\u00020\t8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0018\u0010\u0013\u001a\u00020\u0005*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b3\u00101\"\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0018\u00107\u001a\u00020\u0005*\u00020\t8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b6\u00101\"\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b8\u00105\"\u0018\u0010<\u001a\u000209*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010;\"\u0018\u0010>\u001a\u000209*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010;\"\u0018\u0010A\u001a\u00020-*\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "", "", "modules", "languages", "", "requestInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "requestProgressFlow", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;)Lkotlinx/coroutines/flow/Flow;", "requestSessionStates", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moduleNames", "", "requestDeferredInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredUninstall", "sessionId", "requestSessionState", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCancelInstall", "Ljava/util/Locale;", "requestDeferredLanguageInstall", "requestDeferredLanguageUninstall", "Lkotlin/Function1;", "onRequiresConfirmation", "onInstalled", "onFailed", "onPending", "onDownloaded", "onDownloading", "onInstalling", "onCanceling", "onCanceled", "onNonTerminalStatus", "onTerminalStatus", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "SplitInstallStateUpdatedListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "sessionState", "Landroidx/fragment/app/Fragment;", "fragment", "requestCode", "", "startConfirmationDialogForResult", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;Landroidx/fragment/app/Fragment;I)Z", "getStatus", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)I", "status", "getSessionId", "getLanguages", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Ljava/util/List;", "getErrorCode", CommonKt.TAG_ERROR_CODE, "getModuleNames", "", "getTotalBytesToDownload", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)J", "totalBytesToDownload", "getBytesDownloaded", "bytesDownloaded", "getHasTerminalStatus", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Z", "hasTerminalStatus", "tmp.9f4bIqL_release"}, k = 2, mv = {1, 4, 0})
public final class SplitInstallManagerKtxKt {

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<SplitInstallSessionState, Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public static final a h = new a(6);
        public static final a i = new a(7);
        public static final a j = new a(8);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.a = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(SplitInstallSessionState splitInstallSessionState) {
            switch (this.a) {
                case 0:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 1:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 2:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 3:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 4:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 5:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 6:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 7:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                case 8:
                    Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "it");
                    return Unit.INSTANCE;
                default:
                    throw null;
            }
        }
    }

    public static final class b implements SplitInstallStateUpdatedListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ Function1 f;
        public final /* synthetic */ Function1 g;
        public final /* synthetic */ Function1 h;
        public final /* synthetic */ Function1 i;
        public final /* synthetic */ Function1 j;
        public final /* synthetic */ Function1 k;

        public b(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111) {
            this.a = function1;
            this.b = function12;
            this.c = function13;
            this.d = function14;
            this.e = function15;
            this.f = function16;
            this.g = function17;
            this.h = function18;
            this.i = function19;
            this.j = function110;
            this.k = function111;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.play.core.listener.StateUpdatedListener
        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState2 = splitInstallSessionState;
            Intrinsics.checkExpressionValueIsNotNull(splitInstallSessionState2, "state");
            switch (splitInstallSessionState2.status()) {
                case 0:
                case 6:
                    this.a.invoke(splitInstallSessionState2);
                    break;
                case 1:
                    this.b.invoke(splitInstallSessionState2);
                    break;
                case 2:
                    this.d.invoke(splitInstallSessionState2);
                    break;
                case 3:
                    this.e.invoke(splitInstallSessionState2);
                    break;
                case 4:
                    this.f.invoke(splitInstallSessionState2);
                    break;
                case 5:
                    this.g.invoke(splitInstallSessionState2);
                    break;
                case 7:
                    this.i.invoke(splitInstallSessionState2);
                    break;
                case 8:
                    this.c.invoke(splitInstallSessionState2);
                    break;
                case 9:
                    this.h.invoke(splitInstallSessionState2);
                    break;
            }
            if (splitInstallSessionState2.hasTerminalStatus()) {
                this.j.invoke(splitInstallSessionState2);
            } else {
                this.k.invoke(splitInstallSessionState2);
            }
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {122}, m = "requestCancelInstall", n = {"$this$requestCancelInstall", "sessionId"}, s = {"L$0", "I$0"})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public int d;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestCancelInstall(null, 0, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {96}, m = "requestDeferredInstall", n = {"$this$requestDeferredInstall", "moduleNames"}, s = {"L$0", "L$1"})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestDeferredInstall(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {131}, m = "requestDeferredLanguageInstall", n = {"$this$requestDeferredLanguageInstall", "languages"}, s = {"L$0", "L$1"})
    public static final class e extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public e(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestDeferredLanguageInstall(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {140}, m = "requestDeferredLanguageUninstall", n = {"$this$requestDeferredLanguageUninstall", "languages"}, s = {"L$0", "L$1"})
    public static final class f extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public f(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestDeferredLanguageUninstall(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {105}, m = "requestDeferredUninstall", n = {"$this$requestDeferredUninstall", "moduleNames"}, s = {"L$0", "L$1"})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public g(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestDeferredUninstall(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0, 0}, l = {41}, m = "requestInstall", n = {"$this$requestInstall", "modules", "languages"}, s = {"L$0", "L$1", "L$2"})
    public static final class h extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;
        public Object e;

        public h(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestInstall(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1", f = "SplitInstallManagerKtx.kt", i = {0, 0, 0}, l = {77}, m = "invokeSuspend", n = {"$this$callbackFlow", "sessionsAlreadyOffered", "globalSessionListener"}, s = {"L$0", "L$1", "L$2"})
    public static final class i extends SuspendLambda implements Function2<ProducerScope<? super SplitInstallSessionState>, Continuation<? super Unit>, Object> {
        public ProducerScope b;
        public Object c;
        public Object d;
        public Object e;
        public int f;
        public final /* synthetic */ SplitInstallManager g;

        public static final class a<ResultT> implements OnSuccessListener<List<SplitInstallSessionState>> {
            public final /* synthetic */ ProducerScope a;
            public final /* synthetic */ Set b;

            public a(ProducerScope producerScope, Set set) {
                this.a = producerScope;
                this.b = set;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public void onSuccess(List<SplitInstallSessionState> list) {
                List<SplitInstallSessionState> list2 = list;
                Intrinsics.checkParameterIsNotNull(list2, "sessionList");
                ArrayList arrayList = new ArrayList();
                for (T t : list2) {
                    if (!this.b.contains(Integer.valueOf(t.sessionId()))) {
                        arrayList.add(t);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.a.offer((SplitInstallSessionState) it.next());
                }
            }
        }

        public static final class b implements OnFailureListener {
            public final /* synthetic */ ProducerScope a;

            public b(ProducerScope producerScope) {
                this.a = producerScope;
            }

            @Override // com.google.android.play.core.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.a.close(exc);
            }
        }

        public static final class c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ i a;
            public final /* synthetic */ SplitInstallStateUpdatedListener b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(i iVar, SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
                super(0);
                this.a = iVar;
                this.b = splitInstallStateUpdatedListener;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.g.unregisterListener(this.b);
                return Unit.INSTANCE;
            }
        }

        public static final class d implements SplitInstallStateUpdatedListener {
            public final /* synthetic */ ProducerScope a;
            public final /* synthetic */ Set b;

            public d(ProducerScope producerScope, Set set) {
                this.a = producerScope;
                this.b = set;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
                SplitInstallSessionState splitInstallSessionState2 = splitInstallSessionState;
                Set set = this.b;
                Intrinsics.checkExpressionValueIsNotNull(splitInstallSessionState2, "state");
                set.add(Integer.valueOf(splitInstallSessionState2.sessionId()));
                this.a.offer(splitInstallSessionState2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(SplitInstallManager splitInstallManager, Continuation continuation) {
            super(2, continuation);
            this.g = splitInstallManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            i iVar = new i(this.g, continuation);
            iVar.b = (ProducerScope) obj;
            return iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super SplitInstallSessionState> producerScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkParameterIsNotNull(continuation2, "completion");
            i iVar = new i(this.g, continuation2);
            iVar.b = producerScope;
            return iVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = this.b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                d dVar = new d(producerScope, linkedHashSet);
                this.g.registerListener(dVar);
                this.g.getSessionStates().addOnSuccessListener(new a(producerScope, linkedHashSet)).addOnFailureListener(new b(producerScope));
                c cVar = new c(this, dVar);
                this.c = producerScope;
                this.d = linkedHashSet;
                this.e = dVar;
                this.f = 1;
                if (ProduceKt.awaitClose(producerScope, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                SplitInstallStateUpdatedListener splitInstallStateUpdatedListener = (SplitInstallStateUpdatedListener) this.e;
                Set set = (Set) this.d;
                ProducerScope producerScope2 = (ProducerScope) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0, 0}, l = {114}, m = "requestSessionState", n = {"$this$requestSessionState", "sessionId"}, s = {"L$0", "I$0"})
    public static final class j extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public int d;

        public j(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestSessionState(null, 0, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {0}, l = {88}, m = "requestSessionStates", n = {"$this$requestSessionStates"}, s = {"L$0"})
    public static final class k extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;

        public k(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestSessionStates(null, this);
        }
    }

    @NotNull
    public static final SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener(@NotNull Function1<? super SplitInstallSessionState, Unit> function1, @NotNull Function1<? super SplitInstallSessionState, Unit> function12, @NotNull Function1<? super SplitInstallSessionState, Unit> function13, @NotNull Function1<? super SplitInstallSessionState, Unit> function14, @NotNull Function1<? super SplitInstallSessionState, Unit> function15, @NotNull Function1<? super SplitInstallSessionState, Unit> function16, @NotNull Function1<? super SplitInstallSessionState, Unit> function17, @NotNull Function1<? super SplitInstallSessionState, Unit> function18, @NotNull Function1<? super SplitInstallSessionState, Unit> function19, @NotNull Function1<? super SplitInstallSessionState, Unit> function110, @NotNull Function1<? super SplitInstallSessionState, Unit> function111) {
        Intrinsics.checkParameterIsNotNull(function1, "onRequiresConfirmation");
        Intrinsics.checkParameterIsNotNull(function12, "onInstalled");
        Intrinsics.checkParameterIsNotNull(function13, "onFailed");
        Intrinsics.checkParameterIsNotNull(function14, "onPending");
        Intrinsics.checkParameterIsNotNull(function15, "onDownloaded");
        Intrinsics.checkParameterIsNotNull(function16, "onDownloading");
        Intrinsics.checkParameterIsNotNull(function17, "onInstalling");
        Intrinsics.checkParameterIsNotNull(function18, "onCanceling");
        Intrinsics.checkParameterIsNotNull(function19, "onCanceled");
        Intrinsics.checkParameterIsNotNull(function110, "onNonTerminalStatus");
        Intrinsics.checkParameterIsNotNull(function111, "onTerminalStatus");
        return new b(function13, function14, function1, function16, function15, function17, function12, function18, function19, function111, function110);
    }

    public static /* synthetic */ SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener$default(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, int i2, Object obj) {
        return SplitInstallStateUpdatedListener(function1, function12, (i2 & 4) != 0 ? a.b : function13, (i2 & 8) != 0 ? a.c : function14, (i2 & 16) != 0 ? a.d : function15, (i2 & 32) != 0 ? a.e : function16, (i2 & 64) != 0 ? a.f : function17, (i2 & 128) != 0 ? a.g : function18, (i2 & 256) != 0 ? a.h : function19, (i2 & 512) != 0 ? a.i : function110, (i2 & 1024) != 0 ? a.j : function111);
    }

    public static final long getBytesDownloaded(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$bytesDownloaded");
        return splitInstallSessionState.bytesDownloaded();
    }

    @SplitInstallErrorCode
    public static final int getErrorCode(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$errorCode");
        return splitInstallSessionState.errorCode();
    }

    public static final boolean getHasTerminalStatus(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$hasTerminalStatus");
        return splitInstallSessionState.hasTerminalStatus();
    }

    @NotNull
    public static final List<String> getLanguages(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$languages");
        List<String> languages = splitInstallSessionState.languages();
        Intrinsics.checkExpressionValueIsNotNull(languages, "languages()");
        return languages;
    }

    @NotNull
    public static final List<String> getModuleNames(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$moduleNames");
        List<String> moduleNames = splitInstallSessionState.moduleNames();
        Intrinsics.checkExpressionValueIsNotNull(moduleNames, "moduleNames()");
        return moduleNames;
    }

    public static final int getSessionId(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$sessionId");
        return splitInstallSessionState.sessionId();
    }

    @SplitInstallSessionStatus
    public static final int getStatus(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$status");
        return splitInstallSessionState.status();
    }

    public static final long getTotalBytesToDownload(@NotNull SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$totalBytesToDownload");
        return splitInstallSessionState.totalBytesToDownload();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCancelInstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$c r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.c) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$c r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$c
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.cancelInstall(r5)
            java.lang.String r2 = "cancelInstall(sessionId)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x0050
            return r1
        L_0x0050:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestCancelInstall(com.google.android.play.core.splitinstall.SplitInstallManager, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestDeferredInstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$d r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$d r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$d
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.deferredInstall(r5)
            java.lang.String r2 = "deferredInstall(moduleNames)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestDeferredInstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestDeferredLanguageInstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.util.Locale> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.e
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$e r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.e) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$e r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$e
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.deferredLanguageInstall(r5)
            java.lang.String r2 = "deferredLanguageInstall(languages)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestDeferredLanguageInstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestDeferredLanguageUninstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.util.Locale> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.f
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$f r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.f) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$f r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$f
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.deferredLanguageUninstall(r5)
            java.lang.String r2 = "deferredLanguageUninstall(languages)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestDeferredLanguageUninstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestDeferredUninstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.g
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$g r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.g) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$g r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$g
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.deferredInstall(r5)
            java.lang.String r2 = "deferredInstall(moduleNames)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestDeferredUninstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestInstall(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r6, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r7, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            boolean r0 = r9 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.h
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$h r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.h) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$h r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$h
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r6 = r0.e
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.d
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r6 = (com.google.android.play.core.splitinstall.SplitInstallManager) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0093
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.google.android.play.core.splitinstall.SplitInstallRequest$Builder r9 = com.google.android.play.core.splitinstall.SplitInstallRequest.newBuilder()
            java.util.Iterator r2 = r7.iterator()
        L_0x0048:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            r9.addModule(r4)
            goto L_0x0048
        L_0x0058:
            java.util.Iterator r2 = r8.iterator()
        L_0x005c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0075
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.core.os.LocaleListCompat r4 = androidx.core.os.LocaleListCompat.forLanguageTags(r4)
            r5 = 0
            java.util.Locale r4 = r4.get(r5)
            r9.addLanguage(r4)
            goto L_0x005c
        L_0x0075:
            com.google.android.play.core.splitinstall.SplitInstallRequest r9 = r9.build()
            com.google.android.play.core.tasks.Task r9 = r6.startInstall(r9)
            java.lang.String r2 = "startInstall(buildSplitI…uest(modules, languages))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r2)
            r2 = 2
            r0.c = r6
            r0.d = r7
            r0.e = r8
            r0.b = r3
            r6 = 0
            java.lang.Object r9 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r9, r6, r0, r2, r6)
            if (r9 != r1) goto L_0x0093
            return r1
        L_0x0093:
            java.lang.String r6 = "runTask(startInstall(bui…est(modules, languages)))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestInstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object requestInstall$default(SplitInstallManager splitInstallManager, List list, List list2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i2 & 2) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return requestInstall(splitInstallManager, list, list2, continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final Flow<SplitInstallSessionState> requestProgressFlow(@NotNull SplitInstallManager splitInstallManager) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$requestProgressFlow");
        return FlowKt.buffer$default(FlowKt.channelFlow(new i(splitInstallManager, null)), Integer.MAX_VALUE, null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestSessionState(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.google.android.play.core.splitinstall.SplitInstallSessionState> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.j
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$j r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.j) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$j r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$j
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.getSessionState(r5)
            java.lang.String r2 = "getSessionState(sessionId)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.lang.String r4 = "runTask(getSessionState(sessionId))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionState(com.google.android.play.core.splitinstall.SplitInstallManager, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestSessionStates(@org.jetbrains.annotations.NotNull com.google.android.play.core.splitinstall.SplitInstallManager r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.google.android.play.core.splitinstall.SplitInstallSessionState>> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.k
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$k r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.k) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$k r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$k
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            com.google.android.play.core.splitinstall.SplitInstallManager r4 = (com.google.android.play.core.splitinstall.SplitInstallManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.play.core.tasks.Task r5 = r4.getSessionStates()
            java.lang.String r2 = "sessionStates"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            r2 = 2
            r0.c = r4
            r0.b = r3
            r4 = 0
            java.lang.Object r5 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r5, r4, r0, r2, r4)
            if (r5 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.String r4 = "runTask(sessionStates)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionStates(com.google.android.play.core.splitinstall.SplitInstallManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean startConfirmationDialogForResult(@NotNull SplitInstallManager splitInstallManager, @NotNull SplitInstallSessionState splitInstallSessionState, @NotNull Fragment fragment, int i2) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$startConfirmationDialogForResult");
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "sessionState");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        return splitInstallManager.startConfirmationDialogForResult(splitInstallSessionState, new a2.j.b.e.a.e.c(new Function7<IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle, Unit>(fragment) { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.l
            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "startIntentSenderForResult";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(Fragment.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function7
            public Unit invoke(IntentSender intentSender, Integer num, Intent intent, Integer num2, Integer num3, Integer num4, Bundle bundle) {
                ((Fragment) this.receiver).startIntentSenderForResult(intentSender, num.intValue(), intent, num2.intValue(), num3.intValue(), num4.intValue(), bundle);
                return Unit.INSTANCE;
            }
        }), i2);
    }
}
