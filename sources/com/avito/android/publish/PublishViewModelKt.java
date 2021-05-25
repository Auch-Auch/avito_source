package com.avito.android.publish;

import com.avito.android.publish.PublishSession;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "Lcom/avito/android/publish/PublishSession$StepType;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;)Lcom/avito/android/publish/PublishSession$StepType;", "stepType", "", "INVALID_STEP_INDEX", "I", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishViewModelKt {
    public static final int INVALID_STEP_INDEX = -1;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:0: B:1:0x0006->B:13:0x0033, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[EDGE_INSN: B:18:0x0037->B:15:0x0037 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.publish.PublishSession.StepType a(com.avito.android.remote.model.category_parameters.CategoryPublishStep r6) {
        /*
            com.avito.android.publish.PublishSession$StepType[] r0 = com.avito.android.publish.PublishSession.StepType.values()
            r1 = 0
            r2 = 0
        L_0x0006:
            r3 = 12
            if (r2 >= r3) goto L_0x0036
            r3 = r0[r2]
            java.lang.String r4 = r3.getType()
            java.lang.String r5 = r6.getType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x002f
            java.lang.String r4 = r3.getSubtype()
            java.lang.String r5 = r6.getSubtype()
            if (r5 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            java.lang.String r5 = ""
        L_0x0027:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            com.avito.android.publish.PublishSession$StepType r3 = com.avito.android.publish.PublishSession.StepType.UNKNOWN
        L_0x003c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.PublishViewModelKt.a(com.avito.android.remote.model.category_parameters.CategoryPublishStep):com.avito.android.publish.PublishSession$StepType");
    }

    public static final boolean access$sendToAnalytics(CategoryPublishStep categoryPublishStep) {
        PublishSession.StepType a;
        if (categoryPublishStep == null || (a = a(categoryPublishStep)) == null) {
            return false;
        }
        return a.getSendToAnalytics();
    }

    public static final Maybe access$toMaybe(boolean z) {
        if (z) {
            Maybe just = Maybe.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "Maybe.just(Unit)");
            return just;
        }
        Maybe empty = Maybe.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
        return empty;
    }
}
