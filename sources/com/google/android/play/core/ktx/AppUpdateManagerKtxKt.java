package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.ktx.AppUpdateResult;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a3\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0016\u001a\u00020\u0013*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0016\u001a\u00020\u0013*\u00020\u00178Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0018\" \u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019*\u00020\u00178Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010 \u001a\u00020\u000b*\u00020\u00178Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u0010 \u001a\u00020\u000b*\u00020\u00058Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010!\"\u0018\u0010#\u001a\u00020\u0013*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015\"\u0018\u0010#\u001a\u00020\u0013*\u00020\u00178Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018\"\u0018\u0010%\u001a\u00020\u000b*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010!\"\u0018\u0010&\u001a\u00020\u0010*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0018\u0010)\u001a\u00020\u000b*\u00020\u00178Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u001f\"\u0018\u0010,\u001a\u00020\u0010*\u00020\u00178Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u001a\u0010/\u001a\u0004\u0018\u00010\u000b*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0018\u00100\u001a\u00020\u0010*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010'\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/google/android/play/core/appupdate/AppUpdateManager;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "requestUpdateFlow", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "requestAppUpdateInfo", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "requestCompleteUpdate", "appUpdateInfo", "", "appUpdateType", "Landroidx/fragment/app/Fragment;", "fragment", "requestCode", "", "startUpdateFlowForResult", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;ILandroidx/fragment/app/Fragment;I)Z", "", "getTotalBytesToDownload", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)J", "totalBytesToDownload", "Lcom/google/android/play/core/install/InstallState;", "(Lcom/google/android/play/core/install/InstallState;)J", "", "kotlin.jvm.PlatformType", "getPackageName", "(Lcom/google/android/play/core/install/InstallState;)Ljava/lang/String;", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getInstallStatus", "(Lcom/google/android/play/core/install/InstallState;)I", "installStatus", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)I", "getBytesDownloaded", "bytesDownloaded", "getUpdatePriority", "updatePriority", "isFlexibleUpdateAllowed", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Z", "getInstallErrorCode", "installErrorCode", "getHasTerminalStatus", "(Lcom/google/android/play/core/install/InstallState;)Z", "hasTerminalStatus", "getClientVersionStalenessDays", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Ljava/lang/Integer;", "clientVersionStalenessDays", "isImmediateUpdateAllowed", "tmp.9f4bIqL_release"}, k = 2, mv = {1, 4, 0})
public final class AppUpdateManagerKtxKt {

    @DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", f = "AppUpdateManagerKtx.kt", i = {0}, l = {199}, m = "requestAppUpdateInfo", n = {"$this$requestAppUpdateInfo"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AppUpdateManagerKtxKt.requestAppUpdateInfo(null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", f = "AppUpdateManagerKtx.kt", i = {0}, l = {207}, m = "requestCompleteUpdate", n = {"$this$requestCompleteUpdate"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AppUpdateManagerKtxKt.requestCompleteUpdate(null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1", f = "AppUpdateManagerKtx.kt", i = {0, 0}, l = {75}, m = "invokeSuspend", n = {"$this$callbackFlow", "globalUpdateListener"}, s = {"L$0", "L$1"})
    public static final class c extends SuspendLambda implements Function2<ProducerScope<? super AppUpdateResult>, Continuation<? super Unit>, Object> {
        public ProducerScope b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ AppUpdateManager f;

        public static final class a<ResultT> implements OnSuccessListener<AppUpdateInfo> {
            public final /* synthetic */ c a;
            public final /* synthetic */ ProducerScope b;
            public final /* synthetic */ a2.j.b.e.a.e.b c;

            public a(c cVar, ProducerScope producerScope, a2.j.b.e.a.e.b bVar) {
                this.a = cVar;
                this.b = producerScope;
                this.c = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public void onSuccess(AppUpdateInfo appUpdateInfo) {
                AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
                int updateAvailability = appUpdateInfo2.updateAvailability();
                if (updateAvailability == 0) {
                    this.b.close(new InstallException(-2));
                } else if (updateAvailability == 1) {
                    this.b.offer(AppUpdateResult.NotAvailable.INSTANCE);
                    SendChannel.DefaultImpls.close$default(this.b, null, 1, null);
                } else if (updateAvailability == 2 || updateAvailability == 3) {
                    Intrinsics.checkExpressionValueIsNotNull(appUpdateInfo2, "updateInfo");
                    if (appUpdateInfo2.installStatus() == 11) {
                        this.b.offer(new AppUpdateResult.Downloaded(this.a.f));
                        SendChannel.DefaultImpls.close$default(this.b, null, 1, null);
                        return;
                    }
                    this.a.f.registerListener(this.c);
                    this.b.offer(new AppUpdateResult.Available(this.a.f, appUpdateInfo2));
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

        /* renamed from: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$c$c  reason: collision with other inner class name */
        public static final class C0273c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ c a;
            public final /* synthetic */ a2.j.b.e.a.e.b b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0273c(c cVar, a2.j.b.e.a.e.b bVar) {
                super(0);
                this.a = cVar;
                this.b = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.f.unregisterListener(this.b);
                return Unit.INSTANCE;
            }
        }

        public static final class d implements InstallStateUpdatedListener {
            public final /* synthetic */ c a;
            public final /* synthetic */ ProducerScope b;

            public d(c cVar, ProducerScope producerScope) {
                this.a = cVar;
                this.b = producerScope;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public void onStateUpdate(InstallState installState) {
                InstallState installState2 = installState;
                Intrinsics.checkExpressionValueIsNotNull(installState2, "installState");
                if (installState2.installStatus() == 11) {
                    this.b.offer(new AppUpdateResult.Downloaded(this.a.f));
                } else {
                    this.b.offer(new AppUpdateResult.InProgress(installState2));
                }
            }
        }

        public static final class e extends Lambda implements Function1<a2.j.b.e.a.e.b, Unit> {
            public final /* synthetic */ ProducerScope a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(ProducerScope producerScope) {
                super(1);
                this.a = producerScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(a2.j.b.e.a.e.b bVar) {
                Intrinsics.checkParameterIsNotNull(bVar, "$receiver");
                SendChannel.DefaultImpls.close$default(this.a, null, 1, null);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AppUpdateManager appUpdateManager, Continuation continuation) {
            super(2, continuation);
            this.f = appUpdateManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            c cVar = new c(this.f, continuation);
            cVar.b = (ProducerScope) obj;
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super AppUpdateResult> producerScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkParameterIsNotNull(continuation2, "completion");
            c cVar = new c(this.f, continuation2);
            cVar.b = producerScope;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = this.b;
                a2.j.b.e.a.e.b bVar = new a2.j.b.e.a.e.b(new d(this, producerScope), new e(producerScope));
                this.f.getAppUpdateInfo().addOnSuccessListener(new a(this, producerScope, bVar)).addOnFailureListener(new b(producerScope));
                C0273c cVar = new C0273c(this, bVar);
                this.c = producerScope;
                this.d = bVar;
                this.e = 1;
                if (ProduceKt.awaitClose(producerScope, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                a2.j.b.e.a.e.b bVar2 = (a2.j.b.e.a.e.b) this.d;
                ProducerScope producerScope2 = (ProducerScope) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final long getBytesDownloaded(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$bytesDownloaded");
        return installState.bytesDownloaded();
    }

    @Nullable
    public static final Integer getClientVersionStalenessDays(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$clientVersionStalenessDays");
        return appUpdateInfo.clientVersionStalenessDays();
    }

    public static final boolean getHasTerminalStatus(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$hasTerminalStatus");
        int installStatus = installState.installStatus();
        return installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6;
    }

    @InstallErrorCode
    public static final int getInstallErrorCode(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installErrorCode");
        return installState.installErrorCode();
    }

    @InstallStatus
    public static final int getInstallStatus(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installStatus");
        return installState.installStatus();
    }

    public static final String getPackageName(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$packageName");
        return installState.packageName();
    }

    public static final long getTotalBytesToDownload(@NotNull InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$totalBytesToDownload");
        return installState.totalBytesToDownload();
    }

    public static final int getUpdatePriority(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$updatePriority");
        return appUpdateInfo.updatePriority();
    }

    public static final boolean isFlexibleUpdateAllowed(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isFlexibleUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(0);
    }

    public static final boolean isImmediateUpdateAllowed(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isImmediateUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestAppUpdateInfo(@org.jetbrains.annotations.NotNull com.google.android.play.core.appupdate.AppUpdateManager r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.google.android.play.core.appupdate.AppUpdateInfo> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$a r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$a r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$a
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            com.google.android.play.core.appupdate.AppUpdateManager r4 = (com.google.android.play.core.appupdate.AppUpdateManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.play.core.tasks.Task r5 = r4.getAppUpdateInfo()
            java.lang.String r2 = "appUpdateInfo"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            r2 = 2
            r0.c = r4
            r0.b = r3
            r4 = 0
            java.lang.Object r5 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r5, r4, r0, r2, r4)
            if (r5 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.String r4 = "runTask(appUpdateInfo)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCompleteUpdate(@org.jetbrains.annotations.NotNull com.google.android.play.core.appupdate.AppUpdateManager r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt.b
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$b r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$b r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$b
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            com.google.android.play.core.appupdate.AppUpdateManager r4 = (com.google.android.play.core.appupdate.AppUpdateManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.play.core.tasks.Task r5 = r4.completeUpdate()
            java.lang.String r2 = "completeUpdate()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            r2 = 2
            r0.c = r4
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r5, r4, r0, r2, r4)
            if (r4 != r1) goto L_0x004e
            return r1
        L_0x004e:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.requestCompleteUpdate(com.google.android.play.core.appupdate.AppUpdateManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final Flow<AppUpdateResult> requestUpdateFlow(@NotNull AppUpdateManager appUpdateManager) throws InstallException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$requestUpdateFlow");
        return FlowKt.conflate(FlowKt.channelFlow(new c(appUpdateManager, null)));
    }

    public static final boolean startUpdateFlowForResult(@NotNull AppUpdateManager appUpdateManager, @NotNull AppUpdateInfo appUpdateInfo, @AppUpdateType int i, @NotNull Fragment fragment, int i2) throws IntentSender.SendIntentException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$startUpdateFlowForResult");
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "appUpdateInfo");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        return appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, new a2.j.b.e.a.e.a(new Function7<IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle, Unit>(fragment) { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.d
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

    public static final long getBytesDownloaded(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$bytesDownloaded");
        return appUpdateInfo.bytesDownloaded();
    }

    @InstallStatus
    public static final int getInstallStatus(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$installStatus");
        return appUpdateInfo.installStatus();
    }

    public static final long getTotalBytesToDownload(@NotNull AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$totalBytesToDownload");
        return appUpdateInfo.totalBytesToDownload();
    }
}
