package com.sumsub.sns.core.common;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0015¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/common/SNSDebugLogTree;", "Lcom/sumsub/sns/core/common/SNSLogTree;", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "tag", "message", "", "t", "", "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "<init>", "()V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSDebugLogTree extends SNSLogTree {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/common/SNSDebugLogTree$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Override // timber.log.Timber.Tree
    @SuppressLint({"LogNotTimber"})
    public void log(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str2, "message");
        if (i == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i, "SNS", str2);
        }
    }
}
