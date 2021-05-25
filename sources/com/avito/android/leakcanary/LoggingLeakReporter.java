package com.avito.android.leakcanary;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import leakcanary.DefaultOnHeapAnalyzedListener;
import leakcanary.OnHeapAnalyzedListener;
import org.jetbrains.annotations.NotNull;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.Leak;
import t6.c;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\n\u001a\u00020\u00018B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/leakcanary/LoggingLeakReporter;", "Lleakcanary/OnHeapAnalyzedListener;", "Lshark/HeapAnalysis;", "heapAnalysis", "", "onHeapAnalyzed", "(Lshark/HeapAnalysis;)V", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "()Lleakcanary/OnHeapAnalyzedListener;", "defaultListener", "<init>", "()V", "leakcanary_release"}, k = 1, mv = {1, 4, 2})
public final class LoggingLeakReporter implements OnHeapAnalyzedListener {
    public final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<OnHeapAnalyzedListener> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final OnHeapAnalyzedListener invoke() {
            return DefaultOnHeapAnalyzedListener.Companion.create();
        }
    }

    public final OnHeapAnalyzedListener a() {
        return (OnHeapAnalyzedListener) this.a.getValue();
    }

    public void onHeapAnalyzed(@NotNull HeapAnalysis heapAnalysis) {
        Intrinsics.checkNotNullParameter(heapAnalysis, "heapAnalysis");
        if (heapAnalysis instanceof HeapAnalysisFailure) {
            StringBuilder L = a2.b.a.a.a.L("\n                        A potential leak detected but heap analysis failed: ");
            L.append(((HeapAnalysisFailure) heapAnalysis).getException().getMessage());
            L.append("\n                        Heap dump initiated at ");
            L.append(heapAnalysis.getCreatedAtTimeMillis());
            L.append(", analysis took ");
            L.append(heapAnalysis.getAnalysisDurationMillis());
            L.append(" ms.\n                        Dump file location: ");
            L.append(heapAnalysis.getHeapDumpFile().getAbsolutePath());
            L.append("\n                    ");
            Logs.error$default("LeakCanary", f.trimIndent(L.toString()), null, 4, null);
        } else if (heapAnalysis instanceof HeapAnalysisSuccess) {
            StringBuilder L2 = a2.b.a.a.a.L("\n                        Detected ");
            L2.append(((HeapAnalysisSuccess) heapAnalysis).getAllLeaks().size());
            L2.append(" leaks.\n                        Heap dump initiated at ");
            L2.append(heapAnalysis.getCreatedAtTimeMillis());
            L2.append(", analysis took ");
            L2.append(heapAnalysis.getAnalysisDurationMillis());
            L2.append(" ms.\n                        Dump file location: ");
            L2.append(heapAnalysis.getHeapDumpFile().getAbsolutePath());
            L2.append("\n                    ");
            Logs.debug$default("LeakCanary", f.trimIndent(L2.toString()), null, 4, null);
            HeapAnalysisSuccess heapAnalysisSuccess = (HeapAnalysisSuccess) heapAnalysis;
            if (!heapAnalysisSuccess.getAllLeaks().isEmpty()) {
                for (Leak leak : heapAnalysisSuccess.getAllLeaks()) {
                    StringBuilder L3 = a2.b.a.a.a.L("\n                        ");
                    L3.append(leak.getGroupHash());
                    L3.append(": ");
                    L3.append(leak.getClassName());
                    L3.append(" leaked, retained ");
                    L3.append(leak.getRetainedHeapByteSize());
                    L3.append(" bytes.\n                        ");
                    L3.append(leak.getLeakTrace());
                    L3.append("\n                    ");
                    Logs.debug$default("LeakCanary", f.trimIndent(L3.toString()), null, 4, null);
                }
            }
        }
        a().onHeapAnalyzed(heapAnalysis);
    }
}
