package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B3\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lorg/kodein/di/KodeinDefinition;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/KodeinDefining;", "Lorg/kodein/di/KodeinTree;", "c", "Lorg/kodein/di/KodeinTree;", "getTree", "()Lorg/kodein/di/KodeinTree;", "tree", "Lorg/kodein/di/bindings/KodeinBinding;", "binding", "", "fromModule", "<init>", "(Lorg/kodein/di/bindings/KodeinBinding;Ljava/lang/String;Lorg/kodein/di/KodeinTree;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinDefinition<C, A, T> extends KodeinDefining<C, A, T> {
    @NotNull
    public final KodeinTree c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KodeinDefinition(@NotNull KodeinBinding<C, A, T> kodeinBinding, @Nullable String str, @NotNull KodeinTree kodeinTree) {
        super(kodeinBinding, str);
        Intrinsics.checkParameterIsNotNull(kodeinBinding, "binding");
        Intrinsics.checkParameterIsNotNull(kodeinTree, "tree");
        this.c = kodeinTree;
    }

    @NotNull
    public final KodeinTree getTree() {
        return this.c;
    }
}
