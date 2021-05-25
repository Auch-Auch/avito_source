package com.avito.android.validation;

import com.avito.android.remote.auth.AuthSource;
import com.google.common.net.HttpHeaders;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/validation/ValidationResult;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Failure", "Info", "Success", "Lcom/avito/android/validation/ValidationResult$Success;", "Lcom/avito/android/validation/ValidationResult$Info;", "Lcom/avito/android/validation/ValidationResult$Failure;", "validation_release"}, k = 1, mv = {1, 4, 2})
public abstract class ValidationResult {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Failure;", "Lcom/avito/android/validation/ValidationResult;", "", "d", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "", "e", "Ljava/util/Map;", "getTextForInternalField", "()Ljava/util/Map;", "textForInternalField", "c", "getText", "text", AuthSource.BOOKING_ORDER, "getTitle", "title", "Error", HttpHeaders.WARNING, "WarningOnFlowFinish", "Lcom/avito/android/validation/ValidationResult$Failure$Error;", "Lcom/avito/android/validation/ValidationResult$Failure$WarningOnFlowFinish;", "Lcom/avito/android/validation/ValidationResult$Failure$Warning;", "validation_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Failure extends ValidationResult {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        @NotNull
        public final Map<String, String> e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Failure$Error;", "Lcom/avito/android/validation/ValidationResult$Failure;", "", "id", "title", "text", "tag", "", "textForInternalField", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Failure {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Error(String str, String str2, String str3, String str4, Map map, int i, j jVar) {
                this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? r.emptyMap() : map);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Map<String, String> map) {
                super(str, str2, str3, str4, map, null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(str3, "text");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Failure$Warning;", "Lcom/avito/android/validation/ValidationResult$Failure;", "", "id", "title", "text", "tag", "", "textForInternalField", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
        public static final class Warning extends Failure {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Warning(String str, String str2, String str3, String str4, Map map, int i, j jVar) {
                this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? r.emptyMap() : map);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Warning(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Map<String, String> map) {
                super(str, str2, str3, str4, map, null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(str3, "text");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Failure$WarningOnFlowFinish;", "Lcom/avito/android/validation/ValidationResult$Failure;", "", "id", "title", "text", "tag", "", "textForInternalField", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
        public static final class WarningOnFlowFinish extends Failure {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WarningOnFlowFinish(String str, String str2, String str3, String str4, Map map, int i, j jVar) {
                this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? r.emptyMap() : map);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public WarningOnFlowFinish(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Map<String, String> map) {
                super(str, str2, str3, str4, map, null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(str3, "text");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
            }
        }

        public Failure(String str, String str2, String str3, String str4, Map map, j jVar) {
            super(str, null);
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = map;
        }

        @Nullable
        public final String getTag() {
            return this.d;
        }

        @NotNull
        public final String getText() {
            return this.c;
        }

        @NotNull
        public final Map<String, String> getTextForInternalField() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Info;", "Lcom/avito/android/validation/ValidationResult;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info extends ValidationResult {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Info(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.b = str2;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/validation/ValidationResult$Success;", "Lcom/avito/android/validation/ValidationResult;", "", "id", "<init>", "(Ljava/lang/String;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends ValidationResult {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    public ValidationResult(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }
}
