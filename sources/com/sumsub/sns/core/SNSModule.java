package com.sumsub.sns.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/SNSModule;", "", "", "toString", "()Ljava/lang/String;", "name", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String SNSProoface = "com.sumsub.sns.prooface.SNSProoface";
    @NotNull
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/SNSModule$Companion;", "", "", "SNSProoface", "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public SNSModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public String toString() {
        return this.name;
    }
}
