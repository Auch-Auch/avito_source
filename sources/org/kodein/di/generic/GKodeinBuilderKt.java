package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.SearchDSL;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\u0007\u001a\u00020\t*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0004\b\u0007\u0010\n\u001a(\u0010\u000e\u001a\u00020\r\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a,\u0010\u0012\u001a\u00020\u0011\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0015\u001a\u00020\u0014\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0010H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\u00020\u0014\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0010H\b¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"", "T", "Lorg/kodein/di/Kodein$Builder;", "tag", "", "overrides", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "bind", "(Lorg/kodein/di/Kodein$Builder;Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Lorg/kodein/di/Kodein$Builder$DirectBinder;", "(Lorg/kodein/di/Kodein$Builder;Ljava/lang/Object;Ljava/lang/Boolean;)Lorg/kodein/di/Kodein$Builder$DirectBinder;", "Lorg/kodein/di/Kodein$Builder$ConstantBinder;", "value", "", "with", "(Lorg/kodein/di/Kodein$Builder$ConstantBinder;Ljava/lang/Object;)V", "Lorg/kodein/di/SearchDSL;", "Lorg/kodein/di/SearchDSL$Binding;", "binding", "(Lorg/kodein/di/SearchDSL;Ljava/lang/Object;)Lorg/kodein/di/SearchDSL$Binding;", "Lorg/kodein/di/SearchDSL$Spec;", "context", "(Lorg/kodein/di/SearchDSL;)Lorg/kodein/di/SearchDSL$Spec;", "argument", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GKodeinBuilderKt {
    @NotNull
    public static final /* synthetic */ <T> SearchDSL.Spec argument(@NotNull SearchDSL searchDSL) {
        Intrinsics.checkParameterIsNotNull(searchDSL, "$this$argument");
        Intrinsics.needClassReification();
        return searchDSL.Argument(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinBuilderKt$argument$$inlined$generic$1
        }));
    }

    @NotNull
    public static final Kodein.Builder.DirectBinder bind(@NotNull Kodein.Builder builder, @Nullable Object obj, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$bind");
        return builder.Bind(obj, bool);
    }

    @NotNull
    public static final /* synthetic */ <T> SearchDSL.Binding binding(@NotNull SearchDSL searchDSL, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(searchDSL, "$this$binding");
        Intrinsics.needClassReification();
        return new SearchDSL.Binding(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinBuilderKt$binding$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ SearchDSL.Binding binding$default(SearchDSL searchDSL, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(searchDSL, "$this$binding");
        Intrinsics.needClassReification();
        return new SearchDSL.Binding(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinBuilderKt$binding$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <T> SearchDSL.Spec context(@NotNull SearchDSL searchDSL) {
        Intrinsics.checkParameterIsNotNull(searchDSL, "$this$context");
        Intrinsics.needClassReification();
        return searchDSL.Context(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinBuilderKt$context$$inlined$generic$1
        }));
    }

    public static final /* synthetic */ <T> void with(@NotNull Kodein.Builder.ConstantBinder constantBinder, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(constantBinder, "$this$with");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Intrinsics.needClassReification();
        constantBinder.With(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinBuilderKt$with$$inlined$generic$1
        }), t);
    }
}
