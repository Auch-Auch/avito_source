package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ResetPasswordResult;", "", "<init>", "()V", "ViaCode", "ViaLink", "Lcom/avito/android/remote/model/ResetPasswordResult$ViaCode;", "Lcom/avito/android/remote/model/ResetPasswordResult$ViaLink;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ResetPasswordResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/ResetPasswordResult$ViaCode;", "Lcom/avito/android/remote/model/ResetPasswordResult;", "", "codeTimeout", "J", "getCodeTimeout", "()J", "", "codeLength", "I", "getCodeLength", "()I", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;JI)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViaCode extends ResetPasswordResult {
        @SerializedName("codeLength")
        private final int codeLength;
        @SerializedName("codeTimeout")
        private final long codeTimeout;
        @SerializedName("text")
        @NotNull
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViaCode(@NotNull String str, long j, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            this.codeTimeout = j;
            this.codeLength = i;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        public final long getCodeTimeout() {
            return this.codeTimeout;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/ResetPasswordResult$ViaLink;", "Lcom/avito/android/remote/model/ResetPasswordResult;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViaLink extends ResetPasswordResult {
        @SerializedName("text")
        @NotNull
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViaLink(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }
    }

    private ResetPasswordResult() {
    }

    public /* synthetic */ ResetPasswordResult(j jVar) {
        this();
    }
}
