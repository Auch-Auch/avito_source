package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.CurryKt$toProvider$1;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017¢\u0006\u0004\b\u0019\u0010\u001aJY\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\n\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0005*\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ=\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010Ja\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\n\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0005*\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0012J7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0010JU\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0005*\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lorg/kodein/di/internal/DKodeinImpl;", "Lorg/kodein/di/internal/DKodeinBaseImpl;", "Lorg/kodein/di/DKodein;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "", "Lkotlin/Function1;", "AllFactories", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/Function0;", "AllProviders", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "AllInstances", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "Lorg/kodein/di/KodeinContainer;", "container", "Lorg/kodein/di/KodeinContext;", "context", "<init>", "(Lorg/kodein/di/KodeinContainer;Lorg/kodein/di/KodeinContext;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class DKodeinImpl extends DKodeinBaseImpl implements DKodein {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DKodeinImpl(@NotNull KodeinContainer kodeinContainer, @NotNull KodeinContext<?> kodeinContext) {
        super(kodeinContainer, kodeinContext);
        Intrinsics.checkParameterIsNotNull(kodeinContainer, "container");
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function1<A, T>> AllFactories(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return KodeinContainer.DefaultImpls.allFactories$default(getContainer(), new Kodein.Key(DKodeinJVMImplKt.access$getAnyType$p(getContext()), typeToken, typeToken2, obj), getContext().getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<T> AllInstances(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        List<T> allProviders$default = KodeinContainer.DefaultImpls.allProviders$default(getContainer(), new Kodein.Key(DKodeinJVMImplKt.access$getAnyType$p(getContext()), TypeTokenKt.getUnitToken(), typeToken, obj), getContext().getValue(), 0, 4, null);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allProviders$default, 10));
        for (T t : allProviders$default) {
            arrayList.add(t.invoke());
        }
        return arrayList;
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<Function0<T>> AllProviders(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return KodeinContainer.DefaultImpls.allProviders$default(getContainer(), new Kodein.Key(DKodeinJVMImplKt.access$getAnyType$p(getContext()), TypeTokenKt.getUnitToken(), typeToken, obj), getContext().getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function0<T>> AllProviders(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        List<T> allFactories$default = KodeinContainer.DefaultImpls.allFactories$default(getContainer(), new Kodein.Key(DKodeinJVMImplKt.access$getAnyType$p(getContext()), typeToken, typeToken2, obj), getContext().getValue(), 0, 4, null);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allFactories$default, 10));
        for (T t : allFactories$default) {
            arrayList.add(new CurryKt$toProvider$1(t, function0));
        }
        return arrayList;
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<T> AllInstances(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        List<T> allFactories$default = KodeinContainer.DefaultImpls.allFactories$default(getContainer(), new Kodein.Key(DKodeinJVMImplKt.access$getAnyType$p(getContext()), typeToken, typeToken2, obj), getContext().getValue(), 0, 4, null);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allFactories$default, 10));
        for (T t : allFactories$default) {
            arrayList.add(t.invoke(a));
        }
        return arrayList;
    }
}
