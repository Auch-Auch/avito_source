package com.avito.android.progress_overlay;

import com.avito.android.design.widget.NetworkProblemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/avito/android/progress_overlay/ProgressOverlay$onRetryListener$1", "Lcom/avito/android/design/widget/NetworkProblemView$OnRetryListener;", "", "onRetry", "()V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressOverlay$onRetryListener$1 implements NetworkProblemView.OnRetryListener {
    public final /* synthetic */ ProgressOverlay a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ProgressOverlay$onRetryListener$1(ProgressOverlay progressOverlay) {
        this.a = progressOverlay;
    }

    @Override // com.avito.android.design.widget.NetworkProblemView.OnRetryListener
    public void onRetry() {
        Function0 function0 = this.a.e;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
