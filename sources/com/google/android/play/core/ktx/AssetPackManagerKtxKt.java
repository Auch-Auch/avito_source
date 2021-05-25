package com.google.android.play.core.ktx;

import com.google.android.play.core.assetpacks.AssetLocation;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0006\u001a\u001f\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\" \u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00020\u0002*\u00020\u00158Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u001d\u001a\u00020\u001a*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010!\u001a\u00020\u001a*\u00020\u001e8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0018\u0010$\u001a\u00020\u0002*\u00020\u001e8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010'\u001a\u00020\u001a*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0018\u0010*\u001a\u00020\u0012*\u00020\b8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0018\u0010-\u001a\u00020\u0002*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0018\u0010/\u001a\u00020\u001a*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010\u001c\"\u0018\u00102\u001a\u00020\u0012*\u00020\u00158Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0018\u00104\u001a\u00020\u0012*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010)\"\u0018\u00106\u001a\u00020\u001a*\u00020\u001e8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b5\u0010 \"\u0018\u00108\u001a\u00020\u0012*\u00020\b8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b7\u0010)\"X\u0010=\u001aB\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\b0\b \u0016* \u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\b0\b\u0018\u00010:09*\u00020\u00048Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010<\" \u0010$\u001a\n \u0016*\u0004\u0018\u00010\u00020\u0002*\u00020\u00158Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lcom/google/android/play/core/assetpacks/AssetPackManager;", "", "", "packs", "Lcom/google/android/play/core/assetpacks/AssetPackStates;", "requestFetch", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/assetpacks/AssetPackState;", "requestProgressFlow", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "requestPackStates", "packName", "", "requestRemovePack", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", "activity", "", "requestCellularDataConfirmation", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/play/core/assetpacks/AssetPackLocation;", "kotlin.jvm.PlatformType", "getAssetsPath", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)Ljava/lang/String;", "assetsPath", "", "getBytesDownloaded", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)J", "bytesDownloaded", "Lcom/google/android/play/core/assetpacks/AssetLocation;", "getOffset", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)J", "offset", "getPath", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "getTotalBytes", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)J", "totalBytes", "getStatus", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)I", "status", "getName", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)Ljava/lang/String;", "name", "getTotalBytesToDownload", "totalBytesToDownload", "getPackStorageMethod", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)I", "packStorageMethod", "getTransferProgressPercentage", "transferProgressPercentage", "getSize", "size", "getErrorCode", CommonKt.TAG_ERROR_CODE, "", "", "getPackStates", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)Ljava/util/Map;", "packStates", "tmp.9f4bIqL_release"}, k = 2, mv = {1, 4, 0})
public final class AssetPackManagerKtxKt {

    @DebugMetadata(c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", f = "AssetPackManagerKtx.kt", i = {0, 0}, l = {96}, m = "requestCellularDataConfirmation", n = {"$this$requestCellularDataConfirmation", "activity"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AssetPackManagerKtxKt.requestCellularDataConfirmation(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", f = "AssetPackManagerKtx.kt", i = {0, 0}, l = {32}, m = "requestFetch", n = {"$this$requestFetch", "packs"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AssetPackManagerKtxKt.requestFetch(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", f = "AssetPackManagerKtx.kt", i = {0, 0, 0}, l = {78}, m = "requestPackStates", n = {"$this$requestPackStates", "packs", "task"}, s = {"L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;
        public Object e;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AssetPackManagerKtxKt.requestPackStates(null, null, this);
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt$requestProgressFlow$1", f = "AssetPackManagerKtx.kt", i = {0, 0, 0}, l = {66}, m = "invokeSuspend", n = {"$this$callbackFlow", "packStatesAlreadyOffered", "globalSessionListener"}, s = {"L$0", "L$1", "L$2"})
    public static final class d extends SuspendLambda implements Function2<ProducerScope<? super AssetPackState>, Continuation<? super Unit>, Object> {
        public ProducerScope b;
        public Object c;
        public Object d;
        public Object e;
        public int f;
        public final /* synthetic */ AssetPackManager g;
        public final /* synthetic */ List h;

        public static final class a<ResultT> implements OnSuccessListener<AssetPackStates> {
            public final /* synthetic */ d a;
            public final /* synthetic */ ProducerScope b;
            public final /* synthetic */ Set c;

            public a(d dVar, ProducerScope producerScope, Set set) {
                this.a = dVar;
                this.b = producerScope;
                this.c = set;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public void onSuccess(AssetPackStates assetPackStates) {
                AssetPackStates assetPackStates2 = assetPackStates;
                Intrinsics.checkParameterIsNotNull(assetPackStates2, "states");
                List list = this.a.h;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!this.c.contains((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ProducerScope producerScope = this.b;
                    AssetPackState assetPackState = assetPackStates2.packStates().get((String) it.next());
                    if (assetPackState == null) {
                        Intrinsics.throwNpe();
                    }
                    producerScope.offer(assetPackState);
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
            public final /* synthetic */ d a;
            public final /* synthetic */ AssetPackStateUpdateListener b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(d dVar, AssetPackStateUpdateListener assetPackStateUpdateListener) {
                super(0);
                this.a = dVar;
                this.b = assetPackStateUpdateListener;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.g.unregisterListener(this.b);
                return Unit.INSTANCE;
            }
        }

        /* renamed from: com.google.android.play.core.ktx.AssetPackManagerKtxKt$d$d  reason: collision with other inner class name */
        public static final class C0274d implements AssetPackStateUpdateListener {
            public final /* synthetic */ ProducerScope a;
            public final /* synthetic */ Set b;

            public C0274d(ProducerScope producerScope, Set set) {
                this.a = producerScope;
                this.b = set;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public void onStateUpdate(AssetPackState assetPackState) {
                AssetPackState assetPackState2 = assetPackState;
                Set set = this.b;
                Intrinsics.checkExpressionValueIsNotNull(assetPackState2, "state");
                String name = assetPackState2.name();
                Intrinsics.checkExpressionValueIsNotNull(name, "name()");
                set.add(name);
                this.a.offer(assetPackState2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AssetPackManager assetPackManager, List list, Continuation continuation) {
            super(2, continuation);
            this.g = assetPackManager;
            this.h = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            d dVar = new d(this.g, this.h, continuation);
            dVar.b = (ProducerScope) obj;
            return dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super AssetPackState> producerScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkParameterIsNotNull(continuation2, "completion");
            d dVar = new d(this.g, this.h, continuation2);
            dVar.b = producerScope;
            return dVar.invokeSuspend(Unit.INSTANCE);
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
                C0274d dVar = new C0274d(producerScope, linkedHashSet);
                this.g.registerListener(dVar);
                this.g.getPackStates(this.h).addOnSuccessListener(new a(this, producerScope, linkedHashSet)).addOnFailureListener(new b(producerScope));
                c cVar = new c(this, dVar);
                this.c = producerScope;
                this.d = linkedHashSet;
                this.e = dVar;
                this.f = 1;
                if (ProduceKt.awaitClose(producerScope, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                AssetPackStateUpdateListener assetPackStateUpdateListener = (AssetPackStateUpdateListener) this.e;
                Set set = (Set) this.d;
                ProducerScope producerScope2 = (ProducerScope) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.google.android.play.core.ktx.AssetPackManagerKtxKt", f = "AssetPackManagerKtx.kt", i = {0, 0}, l = {87}, m = "requestRemovePack", n = {"$this$requestRemovePack", "packName"}, s = {"L$0", "L$1"})
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
            return AssetPackManagerKtxKt.requestRemovePack(null, null, this);
        }
    }

    public static final String getAssetsPath(@NotNull AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$assetsPath");
        return assetPackLocation.assetsPath();
    }

    public static final long getBytesDownloaded(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$bytesDownloaded");
        return assetPackState.bytesDownloaded();
    }

    @AssetPackErrorCode
    public static final int getErrorCode(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$errorCode");
        return assetPackState.errorCode();
    }

    @NotNull
    public static final String getName(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$name");
        String name = assetPackState.name();
        Intrinsics.checkExpressionValueIsNotNull(name, "name()");
        return name;
    }

    public static final long getOffset(@NotNull AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$offset");
        return assetLocation.offset();
    }

    public static final Map<String, AssetPackState> getPackStates(@NotNull AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$packStates");
        return assetPackStates.packStates();
    }

    public static final int getPackStorageMethod(@NotNull AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$packStorageMethod");
        return assetPackLocation.packStorageMethod();
    }

    public static final String getPath(@NotNull AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$path");
        return assetPackLocation.path();
    }

    public static final long getSize(@NotNull AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$size");
        return assetLocation.size();
    }

    @AssetPackStatus
    public static final int getStatus(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$status");
        return assetPackState.status();
    }

    public static final long getTotalBytes(@NotNull AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$totalBytes");
        return assetPackStates.totalBytes();
    }

    public static final long getTotalBytesToDownload(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$totalBytesToDownload");
        return assetPackState.totalBytesToDownload();
    }

    public static final int getTransferProgressPercentage(@NotNull AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$transferProgressPercentage");
        return assetPackState.transferProgressPercentage();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestCellularDataConfirmation(@org.jetbrains.annotations.NotNull com.google.android.play.core.assetpacks.AssetPackManager r4, @org.jetbrains.annotations.NotNull android.app.Activity r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$a r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$a r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            android.app.Activity r4 = (android.app.Activity) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.showCellularDataConfirmation(r5)
            java.lang.String r2 = "showCellularDataConfirmation(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            java.lang.String r4 = "runTask(showCellularDataConfirmation(activity))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestCellularDataConfirmation(com.google.android.play.core.assetpacks.AssetPackManager, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestFetch(@org.jetbrains.annotations.NotNull com.google.android.play.core.assetpacks.AssetPackManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.google.android.play.core.assetpacks.AssetPackStates> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$b r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$b r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$b
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
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.fetch(r5)
            java.lang.String r2 = "fetch(packs)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.b = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            java.lang.String r4 = "runTask(fetch(packs))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestFetch(com.google.android.play.core.assetpacks.AssetPackManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestPackStates(@org.jetbrains.annotations.NotNull com.google.android.play.core.assetpacks.AssetPackManager r4, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.google.android.play.core.assetpacks.AssetPackStates> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$c r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt.c) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$c r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$c
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r4 = r0.e
            com.google.android.play.core.tasks.Task r4 = (com.google.android.play.core.tasks.Task) r4
            java.lang.Object r4 = r0.d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005a
        L_0x0035:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.getPackStates(r5)
            java.lang.String r2 = "task"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            r2 = 2
            r0.c = r4
            r0.d = r5
            r0.e = r6
            r0.b = r3
            r4 = 0
            java.lang.Object r6 = com.google.android.play.core.ktx.TaskUtilsKt.runTask$default(r6, r4, r0, r2, r4)
            if (r6 != r1) goto L_0x005a
            return r1
        L_0x005a:
            java.lang.String r4 = "runTask(task)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestPackStates(com.google.android.play.core.assetpacks.AssetPackManager, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final Flow<AssetPackState> requestProgressFlow(@NotNull AssetPackManager assetPackManager, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(assetPackManager, "$this$requestProgressFlow");
        Intrinsics.checkParameterIsNotNull(list, "packs");
        return FlowKt.buffer$default(FlowKt.channelFlow(new d(assetPackManager, list, null)), Integer.MAX_VALUE, null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestRemovePack(@org.jetbrains.annotations.NotNull com.google.android.play.core.assetpacks.AssetPackManager r4, @org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AssetPackManagerKtxKt.e
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$e r0 = (com.google.android.play.core.ktx.AssetPackManagerKtxKt.e) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.AssetPackManagerKtxKt$e r0 = new com.google.android.play.core.ktx.AssetPackManagerKtxKt$e
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.c
            com.google.android.play.core.assetpacks.AssetPackManager r4 = (com.google.android.play.core.assetpacks.AssetPackManager) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.play.core.tasks.Task r6 = r4.removePack(r5)
            java.lang.String r2 = "removePack(packName)"
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AssetPackManagerKtxKt.requestRemovePack(com.google.android.play.core.assetpacks.AssetPackManager, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public static final String getPath(@NotNull AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$path");
        String path = assetLocation.path();
        Intrinsics.checkExpressionValueIsNotNull(path, "path()");
        return path;
    }
}
