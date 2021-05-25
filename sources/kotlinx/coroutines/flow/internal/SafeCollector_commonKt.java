package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0010¢\u0006\u0004\b\b\u0010\t\u001aP\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\n2/\b\u0005\u0010\u0010\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "", "checkContext", "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/Job;", "collectJob", "transitiveCoroutineParent", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/Flow;", "unsafeFlow", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class SafeCollector_commonKt {

    public static final class a extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
        public final /* synthetic */ SafeCollector a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SafeCollector safeCollector) {
            super(2);
            this.a = safeCollector;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
            if (r1 == null) goto L_0x002c;
         */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer invoke(java.lang.Integer r4, kotlin.coroutines.CoroutineContext.Element r5) {
            /*
                r3 = this;
                java.lang.Number r4 = (java.lang.Number) r4
                int r4 = r4.intValue()
                kotlin.coroutines.CoroutineContext$Element r5 = (kotlin.coroutines.CoroutineContext.Element) r5
                kotlin.coroutines.CoroutineContext$Key r0 = r5.getKey()
                kotlinx.coroutines.flow.internal.SafeCollector r1 = r3.a
                kotlin.coroutines.CoroutineContext r1 = r1.collectContext
                kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r0)
                kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key
                if (r0 == r2) goto L_0x001d
                if (r5 == r1) goto L_0x002a
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x002c
            L_0x001d:
                kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                kotlinx.coroutines.Job r5 = kotlinx.coroutines.flow.internal.SafeCollector_commonKt.transitiveCoroutineParent(r5, r1)
                if (r5 != r1) goto L_0x0031
                if (r1 != 0) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                int r4 = r4 + 1
            L_0x002c:
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                return r4
            L_0x0031:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r0 = "Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n"
                r4.append(r0)
                java.lang.String r0 = "\t\tChild of "
                r4.append(r0)
                r4.append(r5)
                java.lang.String r5 = ", expected child of "
                r4.append(r5)
                r4.append(r1)
                java.lang.String r5 = ".\n"
                java.lang.String r0 = "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n"
                java.lang.String r1 = "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'"
                java.lang.String r4 = a2.b.a.a.a.u(r4, r5, r0, r1)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r4 = r4.toString()
                r5.<init>(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.SafeCollector_commonKt.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @JvmName(name = "checkContext")
    public static final void checkContext(@NotNull SafeCollector<?> safeCollector, @NotNull CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new a(safeCollector))).intValue() != safeCollector.collectContextSize) {
            StringBuilder Q = a2.b.a.a.a.Q("Flow invariant is violated:\n", "\t\tFlow was collected in ");
            Q.append(safeCollector.collectContext);
            Q.append(",\n");
            Q.append("\t\tbut emission happened in ");
            Q.append(coroutineContext);
            throw new IllegalStateException(a2.b.a.a.a.t(Q, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    @Nullable
    public static final Job transitiveCoroutineParent(@Nullable Job job, @Nullable Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).getParent$kotlinx_coroutines_core();
        }
        return null;
    }

    @PublishedApi
    @NotNull
    public static final <T> Flow<T> unsafeFlow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SafeCollector_commonKt$unsafeFlow$1(function2);
    }
}
