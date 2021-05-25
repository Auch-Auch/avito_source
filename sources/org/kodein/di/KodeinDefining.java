package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u00020\u0003B+\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR+\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lorg/kodein/di/KodeinDefining;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFromModule", "()Ljava/lang/String;", "fromModule", "Lorg/kodein/di/bindings/KodeinBinding;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/KodeinBinding;", "getBinding", "()Lorg/kodein/di/bindings/KodeinBinding;", "binding", "<init>", "(Lorg/kodein/di/bindings/KodeinBinding;Ljava/lang/String;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class KodeinDefining<C, A, T> {
    @NotNull
    public final KodeinBinding<C, A, T> a;
    @Nullable
    public final String b;

    public KodeinDefining(@NotNull KodeinBinding<C, A, T> kodeinBinding, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
        this.a = kodeinBinding;
        this.b = str;
    }

    @NotNull
    public final KodeinBinding<C, A, T> getBinding() {
        return this.a;
    }

    @Nullable
    public final String getFromModule() {
        return this.b;
    }
}
