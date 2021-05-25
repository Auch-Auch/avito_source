package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.SimpleAutoContextTranslator;
import org.kodein.di.bindings.SimpleContextTranslator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aB\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u00012\u0014\b\b\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a:\u0010\t\u001a\u00020\b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\u00020\u00072\u0014\b\b\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\b¢\u0006\u0004\b\t\u0010\n\u001a6\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00028\u00000\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u000e\b\b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\b¢\u0006\u0004\b\r\u0010\u000e\u001a,\u0010\u000f\u001a\u00020\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00072\u000e\b\b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"C", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Function1;", "t", "Lorg/kodein/di/bindings/ContextTranslator;", "contextTranslator", "(Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/bindings/ContextTranslator;", "Lorg/kodein/di/Kodein$Builder;", "", "registerContextTranslator", "(Lorg/kodein/di/Kodein$Builder;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "", "contextFinder", "(Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/bindings/ContextTranslator;", "registerContextFinder", "(Lorg/kodein/di/Kodein$Builder;Lkotlin/jvm/functions/Function0;)V", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GScopesKt {
    @NotNull
    public static final /* synthetic */ <S> ContextTranslator<Object, S> contextFinder(@NotNull Function0<? extends S> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "t");
        Intrinsics.needClassReification();
        return new SimpleAutoContextTranslator(TypesKt.TT(new TypeReference<S>() { // from class: org.kodein.di.generic.GScopesKt$contextFinder$$inlined$generic$1
        }), function0);
    }

    @NotNull
    public static final /* synthetic */ <C, S> ContextTranslator<C, S> contextTranslator(@NotNull Function1<? super C, ? extends S> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "t");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GScopesKt$contextTranslator$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new SimpleContextTranslator(TT, TypesKt.TT(new TypeReference<S>() { // from class: org.kodein.di.generic.GScopesKt$contextTranslator$$inlined$generic$2
        }), function1);
    }

    public static final /* synthetic */ <S> void registerContextFinder(@NotNull Kodein.Builder builder, @NotNull Function0<? extends S> function0) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$registerContextFinder");
        Intrinsics.checkParameterIsNotNull(function0, "t");
        Intrinsics.needClassReification();
        builder.RegisterContextTranslator(new SimpleAutoContextTranslator(TypesKt.TT(new TypeReference<S>() { // from class: org.kodein.di.generic.GScopesKt$registerContextFinder$$inlined$contextFinder$1
        }), function0));
    }

    public static final /* synthetic */ <C, S> void registerContextTranslator(@NotNull Kodein.Builder builder, @NotNull Function1<? super C, ? extends S> function1) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$registerContextTranslator");
        Intrinsics.checkParameterIsNotNull(function1, "t");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GScopesKt$registerContextTranslator$$inlined$contextTranslator$1
        });
        Intrinsics.needClassReification();
        builder.RegisterContextTranslator(new SimpleContextTranslator(TT, TypesKt.TT(new TypeReference<S>() { // from class: org.kodein.di.generic.GScopesKt$registerContextTranslator$$inlined$contextTranslator$2
        }), function1));
    }
}
