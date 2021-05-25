package com.avito.android.remote.model.sts_recognition;

import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "", "<init>", "()V", "NotFound", "Ok", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult$Ok;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult$NotFound;", "api_release"}, k = 1, mv = {1, 4, 2})
public abstract class StsRecognitionResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult$NotFound;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFound extends StsRecognitionResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotFound(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult$Ok;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "publishParams", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getPublishParams", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "<init>", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends StsRecognitionResult {
        @SerializedName("result")
        @NotNull
        private final CategoryParameters publishParams;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull CategoryParameters categoryParameters) {
            super(null);
            Intrinsics.checkNotNullParameter(categoryParameters, "publishParams");
            this.publishParams = categoryParameters;
        }

        @NotNull
        public final CategoryParameters getPublishParams() {
            return this.publishParams;
        }
    }

    private StsRecognitionResult() {
    }

    public /* synthetic */ StsRecognitionResult(j jVar) {
        this();
    }
}
