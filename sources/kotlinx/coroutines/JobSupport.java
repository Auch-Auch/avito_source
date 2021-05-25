package kotlinx.coroutines;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.vk.sdk.api.model.VKApiUserFull;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import u6.a.m;
import u6.a.q;
import u6.a.r;
import u6.a.v;
import u6.a.w;
import u6.a.y;
import u6.a.z;
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0001{uB\u0012\u0012\u0007\u0010±\u0001\u001a\u00020\n¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00060\u0010j\u0002`\u0011*\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010 \u001a\u00020\u001f2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0019j\u0002`\u001d¢\u0006\u0004\b \u0010!JF\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0019j\u0002`\u001d¢\u0006\u0004\b \u0010$J\u0013\u0010%\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b%\u0010&JB\u0010-\u001a\u00020\u0006\"\u0004\b\u0000\u0010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u001c\u0010,\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*\u0012\u0006\u0012\u0004\u0018\u00010+0\u0019ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001b\u00103\u001a\u00020\u00062\n\u00100\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0015H\u0014¢\u0006\u0004\b6\u00107J\u0019\u00104\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b4\u00108J\u0017\u00109\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b>\u00108J\u0017\u0010?\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b?\u00108J\u0019\u0010B\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b@\u0010AJ(\u0010F\u001a\u00020C2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\b¢\u0006\u0004\bD\u0010EJ\u0013\u0010G\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\bG\u0010\u0013J\u0019\u0010J\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\bI\u0010AJ\u001b\u0010M\u001a\u0004\u0018\u00010+2\b\u0010H\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\bK\u0010LJ\u0015\u0010P\u001a\u00020O2\u0006\u0010N\u001a\u00020\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010T\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0014H\u0010¢\u0006\u0004\bS\u0010:J\u0019\u0010\"\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\"\u0010:J\u0017\u0010U\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0014H\u0014¢\u0006\u0004\bU\u00108J\u0019\u0010W\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\bY\u0010XJ\u000f\u0010Z\u001a\u00020\u0015H\u0016¢\u0006\u0004\bZ\u00107J\u000f\u0010[\u001a\u00020\u0015H\u0007¢\u0006\u0004\b[\u00107J\u000f\u0010]\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\\\u00107J\u000f\u0010^\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b^\u0010_J\u0011\u0010b\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b`\u0010aJ\u0015\u0010d\u001a\u0004\u0018\u00010+H@ø\u0001\u0000¢\u0006\u0004\bc\u0010&JP\u0010i\u001a\u00020\u0006\"\u0004\b\u0000\u0010e\"\u0004\b\u0001\u0010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010(2\"\u0010,\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010*\u0012\u0006\u0012\u0004\u0018\u00010+0fH\u0000ø\u0001\u0000¢\u0006\u0004\bg\u0010hJP\u0010k\u001a\u00020\u0006\"\u0004\b\u0000\u0010e\"\u0004\b\u0001\u0010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010(2\"\u0010,\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010*\u0012\u0006\u0012\u0004\u0018\u00010+0fH\u0000ø\u0001\u0000¢\u0006\u0004\bj\u0010hJ#\u0010m\u001a\u0004\u0018\u00010+2\u0006\u0010V\u001a\u00020l2\b\u0010H\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bm\u0010nJ'\u0010q\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020l2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140oH\u0002¢\u0006\u0004\bq\u0010rJ!\u0010u\u001a\u00020\u00062\u0006\u0010V\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bu\u0010vJ\u001f\u0010y\u001a\u00020\u00062\u0006\u0010x\u001a\u00020w2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b{\u00108J\u0019\u0010}\u001a\u00020|2\b\u0010V\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b}\u0010~JE\u0010\u001a\u0006\u0012\u0002\b\u00030/2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0019j\u0002`\u001d2\u0006\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0010\u0001J/\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020+2\u0006\u0010x\u001a\u00020w2\n\u00100\u001a\u0006\u0012\u0002\b\u00030/H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u0004\u0018\u00010w2\u0006\u0010V\u001a\u00020sH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J(\u0010\u0001\u001a\u0004\u0018\u00010+2\b\u0010V\u001a\u0004\u0018\u00010+2\b\u0010H\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J.\u0010\u0001\u001a\u00020\n2\u0006\u0010V\u001a\u00020l2\u0007\u0010N\u001a\u00030\u00012\b\u0010H\u001a\u0004\u0018\u00010+H\u0010¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u0001*\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00152\b\u0010V\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00020\n8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR\u0018\u0010\u0001\u001a\u00020\n8D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR\u0015\u0010\u0001\u001a\u00020\n8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR\u0018\u0010\u0001\u001a\u00020\n8T@\u0014X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR\u0015\u0010\u0001\u001a\u00020\n8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR\u0016\u0010\u0001\u001a\u00020\u00048F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u00018F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010 \u0001\u001a\u00020\n8P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\fR.\u0010¦\u0001\u001a\u0004\u0018\u00010O2\t\u0010¡\u0001\u001a\u0004\u0018\u00010O8@@@X\u000e¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010¨\u0001\u001a\u00020\n8P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010\fR\u001b\u0010¬\u0001\u001a\u0007\u0012\u0002\b\u00030©\u00018F@\u0006¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0019\u0010V\u001a\u0004\u0018\u00010+8@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\b­\u0001\u0010aR\u0018\u0010®\u0001\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\fR\u001a\u0010°\u0001\u001a\u0004\u0018\u00010\u00148D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010_\u0002\u0004\n\u0002\b\u0019¨\u0006´\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "parent", "", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "", Tracker.Events.CREATIVE_START, "()Z", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "", "message", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/JobNode;", "node", "removeNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/JobNode;)V", "removeNode", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "()Ljava/lang/String;", "(Ljava/lang/Throwable;)Z", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "getChildJobCancellationCause", "proposedUpdate", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "makeCompletingOnce", VKApiUserFull.RelativeType.CHILD, "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", OkListener.KEY_EXCEPTION, "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "handleJobException", "state", "onCompletionInternal", "(Ljava/lang/Object;)V", "afterCompletion", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal$kotlinx_coroutines_core", "awaitInternal", "T", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "Lkotlinx/coroutines/JobSupport$c;", "e", "(Lkotlinx/coroutines/JobSupport$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "exceptions", "f", "(Lkotlinx/coroutines/JobSupport$c;Ljava/util/List;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/Incomplete;", "update", "c", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "j", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", AuthSource.BOOKING_ORDER, "", "k", "(Ljava/lang/Object;)I", "h", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", AuthSource.SEND_ABUSE, "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", g.a, "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", AuthSource.OPEN_CHANNEL_LIST, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "n", "(Lkotlinx/coroutines/JobSupport$c;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "i", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "l", "(Ljava/lang/Object;)Ljava/lang/String;", "isCompletedExceptionally", "getCompletionCauseHandled", "completionCauseHandled", "isCancelled", "isScopedCoroutine", "isCompleted", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getHandlesException$kotlinx_coroutines_core", "handlesException", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getState$kotlinx_coroutines_core", "isActive", "getCompletionCause", "completionCause", "active", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    public volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a<T> extends CancellableContinuationImpl<T> {
        public final JobSupport e;

        public a(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.e = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job) {
            Throwable th;
            Object state$kotlinx_coroutines_core = this.e.getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof c) && (th = (Throwable) ((c) state$kotlinx_coroutines_core)._rootCause) != null) {
                return th;
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return job.getCancellationException();
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    public static final class b extends JobNode<Job> {
        public final JobSupport d;
        public final c e;
        public final ChildHandleNode f;
        public final Object g;

        public b(@NotNull JobSupport jobSupport, @NotNull c cVar, @NotNull ChildHandleNode childHandleNode, @Nullable Object obj) {
            super(childHandleNode.childJob);
            this.d = jobSupport;
            this.e = cVar;
            this.f = childHandleNode;
            this.g = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ChildCompletion[");
            L.append(this.f);
            L.append(", ");
            return a2.b.a.a.a.q(L, this.g, ']');
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(@Nullable Throwable th) {
            JobSupport.access$continueCompleting(this.d, this.e, this.f, this.g);
        }
    }

    public static final class c implements Incomplete {
        public volatile Object _exceptionsHolder = null;
        public volatile int _isCompleting;
        public volatile Object _rootCause;
        @NotNull
        public final NodeList a;

        public c(@NotNull NodeList nodeList, boolean z, @Nullable Throwable th) {
            this.a = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(@org.jetbrains.annotations.NotNull java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.Object r0 = r2._rootCause
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 != 0) goto L_0x0009
                r2._rootCause = r3
                return
            L_0x0009:
                if (r3 != r0) goto L_0x000c
                return
            L_0x000c:
                java.lang.Object r0 = r2._exceptionsHolder
                if (r0 != 0) goto L_0x0013
                r2._exceptionsHolder = r3
                goto L_0x0030
            L_0x0013:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x0027
                if (r3 != r0) goto L_0x001a
                return
            L_0x001a:
                java.util.ArrayList r1 = r2.b()
                r1.add(r0)
                r1.add(r3)
                r2._exceptionsHolder = r1
                goto L_0x0030
            L_0x0027:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0031
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                r0.add(r3)
            L_0x0030:
                return
            L_0x0031:
                java.lang.String r3 = "State is "
                java.lang.String r3 = a2.b.a.a.a.b3(r3, r0)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r3 = r3.toString()
                r0.<init>(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.c.a(java.lang.Throwable):void");
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        public final boolean c() {
            return ((Throwable) this._rootCause) != null;
        }

        public final boolean d() {
            return this._exceptionsHolder == JobSupportKt.access$getSEALED$p();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<java.lang.Throwable> e(@org.jetbrains.annotations.Nullable java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3._exceptionsHolder
                if (r0 != 0) goto L_0x0009
                java.util.ArrayList r0 = r3.b()
                goto L_0x001c
            L_0x0009:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x0016
                java.util.ArrayList r1 = r3.b()
                r1.add(r0)
                r0 = r1
                goto L_0x001c
            L_0x0016:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x003a
                java.util.ArrayList r0 = (java.util.ArrayList) r0
            L_0x001c:
                java.lang.Object r1 = r3._rootCause
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0026
                r2 = 0
                r0.add(r2, r1)
            L_0x0026:
                if (r4 == 0) goto L_0x0033
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0033
                r0.add(r4)
            L_0x0033:
                kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.access$getSEALED$p()
                r3._exceptionsHolder = r4
                return r0
            L_0x003a:
                java.lang.String r4 = "State is "
                java.lang.String r4 = a2.b.a.a.a.b3(r4, r0)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.c.e(java.lang.Throwable):java.util.List");
        }

        @Override // kotlinx.coroutines.Incomplete
        @NotNull
        public NodeList getList() {
            return this.a;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.StringBuilder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r2 = this;
                java.lang.String r0 = "Finishing[cancelling="
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                boolean r1 = r2.c()
                r0.append(r1)
                java.lang.String r1 = ", completing="
                r0.append(r1)
                int r1 = r2._isCompleting
                r0.append(r1)
                java.lang.String r1 = ", rootCause="
                r0.append(r1)
                java.lang.Object r1 = r2._rootCause
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                r0.append(r1)
                java.lang.String r1 = ", exceptions="
                r0.append(r1)
                java.lang.Object r1 = r2._exceptionsHolder
                r0.append(r1)
                java.lang.String r1 = ", list="
                r0.append(r1)
                kotlinx.coroutines.NodeList r1 = r2.a
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.c.toString():java.lang.String");
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class d extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
        public SequenceScope b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public final /* synthetic */ JobSupport j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JobSupport jobSupport, Continuation continuation) {
            super(2, continuation);
            this.j = jobSupport;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            d dVar = new d(this.j, continuation);
            dVar.b = (SequenceScope) obj;
            return dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super ChildJob> sequenceScope, Continuation<? super Unit> continuation) {
            d dVar = new d(this.j, continuation);
            dVar.b = sequenceScope;
            return dVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r10.i
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x003a
                if (r1 == r3) goto L_0x0032
                if (r1 != r2) goto L_0x002a
                java.lang.Object r1 = r10.h
                kotlinx.coroutines.ChildHandleNode r1 = (kotlinx.coroutines.ChildHandleNode) r1
                java.lang.Object r1 = r10.g
                kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
                java.lang.Object r4 = r10.f
                kotlinx.coroutines.internal.LockFreeLinkedListHead r4 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r4
                java.lang.Object r5 = r10.e
                kotlinx.coroutines.NodeList r5 = (kotlinx.coroutines.NodeList) r5
                java.lang.Object r6 = r10.d
                java.lang.Object r7 = r10.c
                kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
                kotlin.ResultKt.throwOnFailure(r11)
                r11 = r10
                goto L_0x009d
            L_0x002a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0032:
                java.lang.Object r0 = r10.c
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x00a2
            L_0x003a:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlin.sequences.SequenceScope r11 = r10.b
                kotlinx.coroutines.JobSupport r1 = r10.j
                java.lang.Object r1 = r1.getState$kotlinx_coroutines_core()
                boolean r4 = r1 instanceof kotlinx.coroutines.ChildHandleNode
                if (r4 == 0) goto L_0x005b
                r2 = r1
                kotlinx.coroutines.ChildHandleNode r2 = (kotlinx.coroutines.ChildHandleNode) r2
                kotlinx.coroutines.ChildJob r2 = r2.childJob
                r10.c = r11
                r10.d = r1
                r10.i = r3
                java.lang.Object r11 = r11.yield(r2, r10)
                if (r11 != r0) goto L_0x00a2
                return r0
            L_0x005b:
                boolean r4 = r1 instanceof kotlinx.coroutines.Incomplete
                if (r4 == 0) goto L_0x00a2
                r4 = r1
                kotlinx.coroutines.Incomplete r4 = (kotlinx.coroutines.Incomplete) r4
                kotlinx.coroutines.NodeList r4 = r4.getList()
                if (r4 == 0) goto L_0x00a2
                java.lang.Object r5 = r4.getNext()
            */
            //  java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                java.util.Objects.requireNonNull(r5, r6)
                kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r5
                r7 = r11
                r6 = r1
                r1 = r5
                r11 = r10
                r5 = r4
            L_0x0078:
                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
                r8 = r8 ^ r3
                if (r8 == 0) goto L_0x00a2
                boolean r8 = r1 instanceof kotlinx.coroutines.ChildHandleNode
                if (r8 == 0) goto L_0x009d
                r8 = r1
                kotlinx.coroutines.ChildHandleNode r8 = (kotlinx.coroutines.ChildHandleNode) r8
                kotlinx.coroutines.ChildJob r9 = r8.childJob
                r11.c = r7
                r11.d = r6
                r11.e = r5
                r11.f = r4
                r11.g = r1
                r11.h = r8
                r11.i = r2
                java.lang.Object r8 = r7.yield(r9, r11)
                if (r8 != r0) goto L_0x009d
                return r0
            L_0x009d:
                kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.getNextNode()
                goto L_0x0078
            L_0x00a2:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
        this._parentHandle = null;
    }

    public static final void access$continueCompleting(JobSupport jobSupport, c cVar, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode i = jobSupport.i(childHandleNode);
        if (i == null || !jobSupport.n(cVar, i, obj)) {
            jobSupport.afterCompletion(jobSupport.e(cVar, obj));
        }
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.cancellationExceptionMessage();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final boolean a(Object obj, NodeList nodeList, JobNode<?> jobNode) {
        int tryCondAddNext;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new LockFreeLinkedListNode.CondAddOp(jobNode, jobNode, this, obj) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            public final /* synthetic */ JobSupport b;
            public final /* synthetic */ Object c;

            {
                this.b = r3;
                this.c = r4;
            }

            @Nullable
            public Object prepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
                if (this.b.getState$kotlinx_coroutines_core() == this.c) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        do {
            tryCondAddNext = nodeList.getPrevNode().tryCondAddNext(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public void afterCompletion(@Nullable Object obj) {
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob) {
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(this, childJob), 2, null);
        Objects.requireNonNull(invokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) invokeOnCompletion$default;
    }

    @Nullable
    public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (k(state$kotlinx_coroutines_core) < 0);
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        CancellableContinuationKt.disposeOnCancellation(aVar, invokeOnCompletion(new v(this, aVar)));
        Object result = aVar.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final boolean b(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) {
            return z;
        }
        if (parentHandle$kotlinx_coroutines_core.childCancelled(th) || z) {
            return true;
        }
        return false;
    }

    public final void c(Incomplete incomplete, Object obj) {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletionHandlerException completionHandlerException = null;
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                Object next = list.getNext();
                Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                    if (lockFreeLinkedListNode instanceof JobNode) {
                        JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                        try {
                            jobNode.invoke(th);
                        } catch (Throwable th3) {
                            if (completionHandlerException != null) {
                                t6.b.addSuppressed(completionHandlerException, th3);
                            } else {
                                completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                            }
                        }
                    }
                }
                if (completionHandlerException != null) {
                    handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final boolean cancelCoroutine(@Nullable Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0046 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancelImpl$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.cancelImpl$kotlinx_coroutines_core(java.lang.Object):boolean");
    }

    public void cancelInternal(@NotNull Throwable th) {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    @NotNull
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!cancelImpl$kotlinx_coroutines_core(th) || !getHandlesException$kotlinx_coroutines_core()) {
            return false;
        }
        return true;
    }

    public final Throwable d(Object obj) {
        if (!(obj != null ? obj instanceof Throwable : true)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            return ((ParentJob) obj).getChildJobCancellationCause();
        } else if (obj != null) {
            return (Throwable) obj;
        } else {
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, this);
    }

    public final Object e(c cVar, Object obj) {
        boolean c2;
        Throwable f;
        boolean z;
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (cVar) {
            c2 = cVar.c();
            List<Throwable> e = cVar.e(th);
            f = f(cVar, e);
            z = true;
            if (f != null) {
                if (e.size() > 1) {
                    Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(e.size()));
                    for (Throwable th2 : e) {
                        if (th2 != f && th2 != f && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                            t6.b.addSuppressed(f, th2);
                        }
                    }
                }
            }
        }
        if (!(f == null || f == th)) {
            obj = new CompletedExceptionally(f, false, 2, null);
        }
        if (f != null) {
            if (!b(f) && !handleJobException(f)) {
                z = false;
            }
            if (z) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally) obj).makeHandled();
            }
        }
        if (!c2) {
            onCancelling(f);
        }
        onCompletionInternal(obj);
        a.compareAndSet(this, cVar, JobSupportKt.boxIncomplete(obj));
        c(cVar, obj);
        return obj;
    }

    public final Throwable f(c cVar, List<? extends Throwable> list) {
        T t;
        boolean z;
        T t2 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!(t instanceof CancellationException)) {
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                return t3;
            }
            Throwable th = (Throwable) list.get(0);
            if (th instanceof TimeoutCancellationException) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    T t4 = next;
                    if (t4 == th || !(t4 instanceof TimeoutCancellationException)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t2 = next;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 != null) {
                    return t5;
                }
            }
            return th;
        } else if (cVar.c()) {
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        } else {
            return null;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    public final NodeList g(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof m) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            JobNode jobNode = (JobNode) incomplete;
            jobNode.addOneIfEmpty(new NodeList());
            a.compareAndSet(this, jobNode, jobNode.getNextNode());
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof c) {
            Throwable th = (Throwable) ((c) state$kotlinx_coroutines_core)._rootCause;
            if (th != null) {
                CancellationException cancellationException = toCancellationException(th, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null);
        } else {
            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
    }

    @Override // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof c) {
            th = (Throwable) ((c) state$kotlinx_coroutines_core)._rootCause;
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(a2.b.a.a.a.b3("Cannot be cancelling child in this state: ", state$kotlinx_coroutines_core).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        StringBuilder L = a2.b.a.a.a.L("Parent job is ");
        L.append(l(state$kotlinx_coroutines_core));
        return new JobCancellationException(L.toString(), th, this);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt__SequenceBuilderKt.sequence(new d(this, null));
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
        } else {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
    }

    @Nullable
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof c) {
            Throwable th = (Throwable) ((c) state$kotlinx_coroutines_core)._rootCause;
            if (th != null) {
                return th;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            return null;
        }
    }

    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) && ((CompletedExceptionally) state$kotlinx_coroutines_core).getHandled();
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                state$kotlinx_coroutines_core = null;
            }
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
            if (completedExceptionally != null) {
                return completedExceptionally.cause;
            }
            return null;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final JobNode<?> h(Function1<? super Throwable, Unit> function1, boolean z) {
        JobCancellingNode jobCancellingNode = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobCancellingNode = function1;
            }
            JobCancellingNode jobCancellingNode2 = jobCancellingNode;
            if (jobCancellingNode2 != null) {
                return jobCancellingNode2;
            }
            return new q(this, function1);
        }
        if (function1 instanceof JobNode) {
            jobCancellingNode = function1;
        }
        JobNode<?> jobNode = jobCancellingNode;
        return jobNode != null ? jobNode : new r(this, function1);
    }

    public boolean handleJobException(@NotNull Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        throw th;
    }

    public final ChildHandleNode i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(@Nullable Job job) {
        if (job == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof c) && ((c) state$kotlinx_coroutines_core).c());
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    public final void j(NodeList nodeList, Throwable th) {
        onCancelling(th);
        Object next = nodeList.getNext();
        Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        t6.b.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        b(th);
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        boolean z;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                if (k(state$kotlinx_coroutines_core) >= 0) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            YieldKt.checkCompletion(continuation.getContext());
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new w(this, cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == t6.p.a.a.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public final int k(Object obj) {
        if (obj instanceof m) {
            if (((m) obj).a) {
                return 0;
            }
            if (!a.compareAndSet(this, obj, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!a.compareAndSet(this, obj, ((InactiveNodeList) obj).getList())) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        }
    }

    public final String l(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.c()) {
                return "Cancelling";
            }
            if (cVar._isCompleting != 0) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof CompletedExceptionally ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        } else {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
    }

    public final Object m(Object obj, Object obj2) {
        Throwable th;
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        boolean z = true;
        ChildHandleNode childHandleNode = null;
        if (((obj instanceof m) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            if (!a.compareAndSet(this, incomplete, JobSupportKt.boxIncomplete(obj2))) {
                z = false;
            } else {
                onCancelling(null);
                onCompletionInternal(obj2);
                c(incomplete, obj2);
            }
            if (z) {
                return obj2;
            }
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList g = g(incomplete2);
        if (g == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        c cVar = (c) (!(incomplete2 instanceof c) ? null : incomplete2);
        if (cVar == null) {
            cVar = new c(g, false, null);
        }
        synchronized (cVar) {
            if (cVar._isCompleting != 0) {
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            cVar._isCompleting = 1;
            if (cVar == incomplete2 || a.compareAndSet(this, incomplete2, cVar)) {
                boolean c2 = cVar.c();
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj2 instanceof CompletedExceptionally) ? null : obj2);
                if (completedExceptionally != null) {
                    cVar.a(completedExceptionally.cause);
                }
                th = (Throwable) cVar._rootCause;
                if (!(true ^ c2)) {
                    th = null;
                }
            } else {
                return JobSupportKt.access$getCOMPLETING_RETRY$p();
            }
        }
        if (th != null) {
            j(g, th);
        }
        ChildHandleNode childHandleNode2 = (ChildHandleNode) (!(incomplete2 instanceof ChildHandleNode) ? null : incomplete2);
        if (childHandleNode2 != null) {
            childHandleNode = childHandleNode2;
        } else {
            NodeList list = incomplete2.getList();
            if (list != null) {
                childHandleNode = i(list);
            }
        }
        if (childHandleNode == null || !n(cVar, childHandleNode, obj2)) {
            return e(cVar, obj2);
        }
        return JobSupportKt.COMPLETING_WAITING_CHILDREN;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object obj) {
        Object m;
        do {
            m = m(getState$kotlinx_coroutines_core(), obj);
            if (m == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if (m == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (m == JobSupportKt.access$getCOMPLETING_RETRY$p());
        afterCompletion(m);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object obj) {
        Object m;
        do {
            m = m(getState$kotlinx_coroutines_core(), obj);
            if (m == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (!(obj instanceof CompletedExceptionally)) {
                    obj = null;
                }
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                throw new IllegalStateException(str, th);
            }
        } while (m == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return m;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    public final boolean n(c cVar, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, false, new b(this, cVar, childHandleNode, obj), 1, null) == NonDisposableHandle.INSTANCE) {
            childHandleNode = i(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    public void onCancelling(@Nullable Throwable th) {
    }

    public void onCompletionInternal(@Nullable Object obj) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect()) {
                        UndispatchedKt.startCoroutineUnintercepted(function1, selectInstance.getCompletion());
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        } while (k(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new z(this, selectInstance, function1)));
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (!selectInstance.trySelect()) {
                        return;
                    }
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        selectInstance.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        UndispatchedKt.startCoroutineUnintercepted(function2, JobSupportKt.unboxState(state$kotlinx_coroutines_core), selectInstance.getCompletion());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (k(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new y(this, selectInstance, function2)));
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode<?> jobNode) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core != jobNode) {
                    return;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                jobNode.remove();
                return;
            } else {
                return;
            }
        } while (!a.compareAndSet(this, state$kotlinx_coroutines_core, JobSupportKt.access$getEMPTY_ACTIVE$p()));
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            selectInstance.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            CancellableKt.startCoroutineCancellable$default(function2, JobSupportKt.unboxState(state$kotlinx_coroutines_core), selectInstance.getCompletion(), null, 4, null);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int k;
        do {
            k = k(getState$kotlinx_coroutines_core());
            if (k == 0) {
                return false;
            }
        } while (k != 1);
        return true;
    }

    @NotNull
    public final CancellationException toCancellationException(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + l(getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(@Nullable Throwable th) {
        Throwable th2;
        if (th == null || (th2 = toCancellationException$default(this, th, null, 1, null)) == null) {
            th2 = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(th2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean r8, boolean r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r7.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof u6.a.m
            if (r3 == 0) goto L_0x0037
            r3 = r2
            u6.a.m r3 = (u6.a.m) r3
            boolean r4 = r3.a
            if (r4 == 0) goto L_0x0021
            if (r1 == 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            kotlinx.coroutines.JobNode r1 = r7.h(r10, r8)
        L_0x0018:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = kotlinx.coroutines.JobSupport.a
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L_0x0002
            return r1
        L_0x0021:
            kotlinx.coroutines.NodeList r2 = new kotlinx.coroutines.NodeList
            r2.<init>()
            boolean r4 = r3.a
            if (r4 == 0) goto L_0x002b
            goto L_0x0031
        L_0x002b:
            kotlinx.coroutines.InactiveNodeList r4 = new kotlinx.coroutines.InactiveNodeList
            r4.<init>(r2)
            r2 = r4
        L_0x0031:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.JobSupport.a
            r4.compareAndSet(r7, r3, r2)
            goto L_0x0002
        L_0x0037:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00ab
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            kotlinx.coroutines.NodeList r3 = r3.getList()
            if (r3 != 0) goto L_0x005d
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>"
            java.util.Objects.requireNonNull(r2, r3)
            kotlinx.coroutines.JobNode r2 = (kotlinx.coroutines.JobNode) r2
            kotlinx.coroutines.NodeList r3 = new kotlinx.coroutines.NodeList
            r3.<init>()
            r2.addOneIfEmpty(r3)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = r2.getNextNode()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.JobSupport.a
            r4.compareAndSet(r7, r2, r3)
            goto L_0x0002
        L_0x005d:
            kotlinx.coroutines.NonDisposableHandle r4 = kotlinx.coroutines.NonDisposableHandle.INSTANCE
            if (r8 == 0) goto L_0x0094
            boolean r5 = r2 instanceof kotlinx.coroutines.JobSupport.c
            if (r5 == 0) goto L_0x0094
            monitor-enter(r2)
            r5 = r2
            kotlinx.coroutines.JobSupport$c r5 = (kotlinx.coroutines.JobSupport.c) r5     // Catch:{ all -> 0x0091 }
            java.lang.Object r5 = r5._rootCause     // Catch:{ all -> 0x0091 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0091 }
            if (r5 == 0) goto L_0x007a
            boolean r6 = r10 instanceof kotlinx.coroutines.ChildHandleNode     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x008f
            r6 = r2
            kotlinx.coroutines.JobSupport$c r6 = (kotlinx.coroutines.JobSupport.c) r6     // Catch:{ all -> 0x0091 }
            int r6 = r6._isCompleting     // Catch:{ all -> 0x0091 }
            if (r6 != 0) goto L_0x008f
        L_0x007a:
            if (r1 == 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            kotlinx.coroutines.JobNode r1 = r7.h(r10, r8)     // Catch:{ all -> 0x0091 }
        L_0x0081:
            boolean r4 = r7.a(r2, r3, r1)     // Catch:{ all -> 0x0091 }
            if (r4 != 0) goto L_0x008a
            monitor-exit(r2)
            goto L_0x0002
        L_0x008a:
            if (r5 != 0) goto L_0x008e
            monitor-exit(r2)
            return r1
        L_0x008e:
            r4 = r1
        L_0x008f:
            monitor-exit(r2)
            goto L_0x0095
        L_0x0091:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 == 0) goto L_0x009d
            if (r9 == 0) goto L_0x009c
            r10.invoke(r5)
        L_0x009c:
            return r4
        L_0x009d:
            if (r1 == 0) goto L_0x00a0
            goto L_0x00a4
        L_0x00a0:
            kotlinx.coroutines.JobNode r1 = r7.h(r10, r8)
        L_0x00a4:
            boolean r2 = r7.a(r2, r3, r1)
            if (r2 == 0) goto L_0x0002
            return r1
        L_0x00ab:
            if (r9 == 0) goto L_0x00bb
            boolean r8 = r2 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r8 != 0) goto L_0x00b2
            r2 = r0
        L_0x00b2:
            kotlinx.coroutines.CompletedExceptionally r2 = (kotlinx.coroutines.CompletedExceptionally) r2
            if (r2 == 0) goto L_0x00b8
            java.lang.Throwable r0 = r2.cause
        L_0x00b8:
            r10.invoke(r0)
        L_0x00bb:
            kotlinx.coroutines.NonDisposableHandle r8 = kotlinx.coroutines.NonDisposableHandle.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.invokeOnCompletion(boolean, boolean, kotlin.jvm.functions.Function1):kotlinx.coroutines.DisposableHandle");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
