package com.avito.android.remote.model.review_reply;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/review_reply/ReviewReplyResultStatus;", "", "<init>", "()V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public @interface ReviewReplyResultStatus {
    @NotNull
    public static final String ACTIVE = "active";
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    @NotNull
    public static final String DECLINED = "declined";
    @NotNull
    public static final String MODERATION = "moderation";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/review_reply/ReviewReplyResultStatus$Companion;", "", "", "MODERATION", "Ljava/lang/String;", "DECLINED", "ACTIVE", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        public static final String ACTIVE = "active";
        @NotNull
        public static final String DECLINED = "declined";
        @NotNull
        public static final String MODERATION = "moderation";

        private Companion() {
        }
    }
}
