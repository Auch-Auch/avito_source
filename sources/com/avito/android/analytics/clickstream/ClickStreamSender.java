package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "", "Lio/reactivex/Single;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "send", "()Lio/reactivex/Single;", "CommonParametersProvider", "UploadResult", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamSender {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "()Ljava/util/Map;", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public interface CommonParametersProvider {
        @NotNull
        Map<String, Object> parameters();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "", "<init>", "()V", "RecoverableError", "Success", "UnrecoverableError", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$Success;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$UnrecoverableError;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$RecoverableError;", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class UploadResult {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$RecoverableError;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
        public static final class RecoverableError extends UploadResult {
            @NotNull
            public final Throwable a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RecoverableError(@NotNull Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(th, "cause");
                this.a = th;
            }

            @NotNull
            public final Throwable getCause() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$Success;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getUploadedIds", "()Ljava/util/List;", "uploadedIds", "<init>", "(Ljava/util/List;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends UploadResult {
            @NotNull
            public final List<Integer> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull List<Integer> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "uploadedIds");
                this.a = list;
            }

            @NotNull
            public final List<Integer> getUploadedIds() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult$UnrecoverableError;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
        public static final class UnrecoverableError extends UploadResult {
            @NotNull
            public final Throwable a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UnrecoverableError(@NotNull Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(th, "cause");
                this.a = th;
            }

            @NotNull
            public final Throwable getCause() {
                return this.a;
            }
        }

        public UploadResult() {
        }

        public UploadResult(j jVar) {
        }
    }

    @NotNull
    Single<UploadResult> send();
}
