package com.avito.android.remote.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/ErrorType;", "", "", "code", "I", "getCode", "()I", "<init>", "(I)V", "NoError", "NonRestorableError", "RestorableError", "Lcom/avito/android/remote/model/ErrorType$NoError;", "Lcom/avito/android/remote/model/ErrorType$RestorableError;", "Lcom/avito/android/remote/model/ErrorType$NonRestorableError;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ErrorType {
    private final int code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ErrorType$NoError;", "Lcom/avito/android/remote/model/ErrorType;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NoError extends ErrorType {
        @NotNull
        public static final NoError INSTANCE = new NoError();

        private NoError() {
            super(ErrorTypeKt.access$getNO_ERROR_CODE$p(), null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ErrorType$NonRestorableError;", "Lcom/avito/android/remote/model/ErrorType;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NonRestorableError extends ErrorType {
        @NotNull
        public static final NonRestorableError INSTANCE = new NonRestorableError();

        private NonRestorableError() {
            super(ErrorTypeKt.access$getNON_RESTORABLE_ERROR_CODE$p(), null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ErrorType$RestorableError;", "Lcom/avito/android/remote/model/ErrorType;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class RestorableError extends ErrorType {
        @NotNull
        public static final RestorableError INSTANCE = new RestorableError();

        private RestorableError() {
            super(ErrorTypeKt.access$getRESTORABLE_ERROR_CODE$p(), null);
        }
    }

    private ErrorType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public /* synthetic */ ErrorType(int i, j jVar) {
        this(i);
    }
}
