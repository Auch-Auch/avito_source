package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.remote.error.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/TypedResult;", "T", "", "<init>", "()V", "OfError", "OfResult", "Lcom/avito/android/remote/model/TypedResult$OfError;", "Lcom/avito/android/remote/model/TypedResult$OfResult;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class TypedResult<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/TypedResult$OfError;", "T", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/error/ErrorResult;", "component1", "()Lcom/avito/android/remote/error/ErrorResult;", "error", "copy", "(Lcom/avito/android/remote/error/ErrorResult;)Lcom/avito/android/remote/model/TypedResult$OfError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/error/ErrorResult;", "getError", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class OfError<T> extends TypedResult<T> {
        @NotNull
        private final transient ErrorResult error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OfError(@NotNull ErrorResult errorResult) {
            super(null);
            Intrinsics.checkNotNullParameter(errorResult, "error");
            this.error = errorResult;
        }

        public static /* synthetic */ OfError copy$default(OfError ofError, ErrorResult errorResult, int i, Object obj) {
            if ((i & 1) != 0) {
                errorResult = ofError.error;
            }
            return ofError.copy(errorResult);
        }

        @NotNull
        public final ErrorResult component1() {
            return this.error;
        }

        @NotNull
        public final OfError<T> copy(@NotNull ErrorResult errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "error");
            return new OfError<>(errorResult);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof OfError) && Intrinsics.areEqual(this.error, ((OfError) obj).error);
            }
            return true;
        }

        @NotNull
        public final ErrorResult getError() {
            return this.error;
        }

        public int hashCode() {
            ErrorResult errorResult = this.error;
            if (errorResult != null) {
                return errorResult.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfError(error=");
            L.append(this.error);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/TypedResult$OfResult;", "T", "Lcom/avito/android/remote/model/TypedResult;", "component1", "()Ljava/lang/Object;", "result", "copy", "(Ljava/lang/Object;)Lcom/avito/android/remote/model/TypedResult$OfResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getResult", "<init>", "(Ljava/lang/Object;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class OfResult<T> extends TypedResult<T> {
        private final transient T result;

        public OfResult(T t) {
            super(null);
            this.result = t;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.TypedResult$OfResult */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OfResult copy$default(OfResult ofResult, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = ofResult.result;
            }
            return ofResult.copy(obj);
        }

        public final T component1() {
            return this.result;
        }

        @NotNull
        public final OfResult<T> copy(T t) {
            return new OfResult<>(t);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof OfResult) && Intrinsics.areEqual(this.result, ((OfResult) obj).result);
            }
            return true;
        }

        public final T getResult() {
            return this.result;
        }

        public int hashCode() {
            T t = this.result;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.r(a.L("OfResult(result="), this.result, ")");
        }
    }

    private TypedResult() {
    }

    public /* synthetic */ TypedResult(j jVar) {
        this();
    }
}
