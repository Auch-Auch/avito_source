package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.GeoContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinAwareJVMKt;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinProperty;
import org.kodein.di.KodeinTrigger;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.Typed;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aF\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\t\u0010\b\u001aL\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\n0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u000b\u0010\b\u001a8\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\r\u0010\b\u001aH\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\r\u0010\u000f\u001aL\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\r\u0010\u0011\u001aP\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\r\u0010\u0013\u001a:\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0014\u0010\b\u001aJ\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0014\u0010\u000f\u001aN\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f0\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\u0014\u0010\u0011\u001aR\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u0014\u0010\u0013\u001a>\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\n0\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0015\u0010\b\u001aN\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\n0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0015\u0010\u000f\u001aR\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\n0\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\u0015\u0010\u0011\u001aV\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\n0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u0015\u0010\u0013\u001a2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0016\u0010\b\u001aB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0016\u0010\u000f\u001aF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\u0016\u0010\u0011\u001aJ\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u0016\u0010\u0013\u001a4\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0017\u0010\b\u001aD\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0017\u0010\u000f\u001aH\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\u0017\u0010\u0011\u001aL\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u0017\u0010\u0013\u001a8\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0005\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0018\u0010\b\u001aH\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0018\u0010\u000f\u001aL\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0005\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0004\b\u0018\u0010\u0011\u001aP\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u0018\u0010\u0013\u001a&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\u0006\b\u0000\u0010\u0019\u0018\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\u0006\b\u0000\u0010\u0019\u0018\u00012\u000e\b\u0004\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b\u001c\u0010\u001f\u001a0\u0010#\u001a\u00020\"\"\u0006\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\b¢\u0006\u0004\b#\u0010$\u001a8\u0010#\u001a\u00020\"\"\u0006\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\u000e\b\u0004\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\b¢\u0006\u0004\b#\u0010%\u001a\u001b\u0010#\u001a\u00020\"*\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b#\u0010&¨\u0006'"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/KodeinAware;", "tag", "Lorg/kodein/di/KodeinProperty;", "Lkotlin/Function1;", "factory", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "factoryOrNull", "", "allFactories", "Lkotlin/Function0;", GeoContract.PROVIDER, "arg", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "Lorg/kodein/di/Typed;", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;Lorg/kodein/di/Typed;)Lorg/kodein/di/KodeinProperty;", "fArg", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinProperty;", "providerOrNull", "allProviders", "instance", "instanceOrNull", "allInstances", "C", "context", "Lorg/kodein/di/KodeinContext;", "kcontext", "(Ljava/lang/Object;)Lorg/kodein/di/KodeinContext;", "getContext", "(Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinContext;", "Lorg/kodein/di/KodeinTrigger;", "trigger", "Lorg/kodein/di/Kodein;", DebugKt.DEBUG_PROPERTY_VALUE_ON, "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;Lorg/kodein/di/KodeinTrigger;)Lorg/kodein/di/Kodein;", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/KodeinTrigger;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/Kodein;", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/KodeinTrigger;)Lorg/kodein/di/Kodein;", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GKodeinAwareKt {
    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<Function1<A, T>>> allFactories(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allFactories");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allFactories$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllFactories(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allFactories$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ KodeinProperty allFactories$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allFactories");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allFactories$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllFactories(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allFactories$$inlined$generic$4
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<T>> allInstances(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$7
        }), obj, new GKodeinAwareKt$allInstances$2(typed));
    }

    public static /* synthetic */ KodeinProperty allInstances$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<Function0<T>>> allProviders(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$7
        }), obj, new GKodeinAwareKt$allProviders$2(typed));
    }

    public static /* synthetic */ KodeinProperty allProviders$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function1<A, T>> factory(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factory$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factory$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ KodeinProperty factory$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factory$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factory$$inlined$generic$4
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function1<A, T>> factoryOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factoryOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factoryOrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factoryOrNull$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ KodeinProperty factoryOrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factoryOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factoryOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$factoryOrNull$$inlined$generic$4
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instance(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$7
        }), obj, new GKodeinAwareKt$instance$2(typed));
    }

    public static /* synthetic */ KodeinProperty instance$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instanceOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$7
        }), obj, new GKodeinAwareKt$instanceOrNull$2(typed));
    }

    public static /* synthetic */ KodeinProperty instanceOrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <C> KodeinContext<C> kcontext(C c) {
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return companion.invoke(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$kcontext$$inlined$generic$1
        }), (TypeToken<? super C>) c);
    }

    @NotNull
    public static final Kodein on(@NotNull KodeinAware kodeinAware, @Nullable KodeinTrigger kodeinTrigger) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$on");
        return KodeinAwareKt.On(kodeinAware, kodeinAware.getKodeinContext(), kodeinTrigger);
    }

    public static /* synthetic */ Kodein on$default(KodeinAware kodeinAware, Object obj, KodeinTrigger kodeinTrigger, int i, Object obj2) {
        if ((i & 2) != 0) {
            kodeinTrigger = kodeinAware.getKodeinTrigger();
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$on");
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return KodeinAwareKt.On(kodeinAware, companion.invoke((TypeToken<? super TypeToken>) TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$on$$inlined$kcontext$2
        }), (TypeToken) obj), kodeinTrigger);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> provider(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$7
        }), obj, new GKodeinAwareKt$provider$2(typed));
    }

    public static /* synthetic */ KodeinProperty provider$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> providerOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$7
        }), obj, new GKodeinAwareKt$providerOrNull$2(typed));
    }

    public static /* synthetic */ KodeinProperty providerOrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <C> Kodein on(@NotNull KodeinAware kodeinAware, C c, @Nullable KodeinTrigger kodeinTrigger) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$on");
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return KodeinAwareKt.On(kodeinAware, companion.invoke(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$on$$inlined$kcontext$1
        }), (TypeToken<? super C>) c), kodeinTrigger);
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<List<T>> allInstances(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty allInstances$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$6
        }), obj, new GKodeinAwareKt$allInstances$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<List<Function0<T>>> allProviders(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty allProviders$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$6
        }), obj, new GKodeinAwareKt$allProviders$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<T> instance(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty instance$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$6
        }), obj, new GKodeinAwareKt$instance$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<T> instanceOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty instanceOrNull$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$6
        }), obj, new GKodeinAwareKt$instanceOrNull$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <C> KodeinContext<C> kcontext(@NotNull Function0<? extends C> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "getContext");
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return companion.invoke((TypeToken) TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$kcontext$$inlined$generic$2
        }), (Function0) new GKodeinAwareKt$kcontext$1(function0));
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<Function0<T>> provider(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty provider$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$6
        }), obj, new GKodeinAwareKt$provider$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<Function0<T>> providerOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ KodeinProperty providerOrNull$default(KodeinAware kodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$6
        }), obj, new GKodeinAwareKt$providerOrNull$1(obj2));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<T>> allInstances(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$4
        }), obj, new GKodeinAwareKt$allInstances$1(a));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<Function0<T>>> allProviders(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$4
        }), obj, new GKodeinAwareKt$allProviders$1(a));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instance(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$4
        }), obj, new GKodeinAwareKt$instance$1(a));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instanceOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$4
        }), obj, new GKodeinAwareKt$instanceOrNull$1(a));
    }

    @NotNull
    public static final /* synthetic */ <C> Kodein on(@NotNull KodeinAware kodeinAware, @Nullable KodeinTrigger kodeinTrigger, @NotNull Function0<? extends C> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$on");
        Intrinsics.checkParameterIsNotNull(function0, "getContext");
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return KodeinAwareKt.On(kodeinAware, companion.invoke((TypeToken) TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$on$$inlined$kcontext$3
        }), (Function0) new GKodeinAwareKt$kcontext$1(function0)), kodeinTrigger);
    }

    public static /* synthetic */ Kodein on$default(KodeinAware kodeinAware, KodeinTrigger kodeinTrigger, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            kodeinTrigger = kodeinAware.getKodeinTrigger();
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$on");
        Intrinsics.checkParameterIsNotNull(function0, "getContext");
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return KodeinAwareKt.On(kodeinAware, companion.invoke(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GKodeinAwareKt$on$$inlined$kcontext$4
        }), (Function0) new GKodeinAwareKt$kcontext$1(function0)), kodeinTrigger);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> provider(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$4
        }), obj, new GKodeinAwareKt$provider$1(a));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> providerOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$4
        }), obj, new GKodeinAwareKt$providerOrNull$1(a));
    }

    public static /* synthetic */ KodeinProperty allInstances$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$8
        }), obj, new GKodeinAwareKt$allInstances$2(typed));
    }

    public static /* synthetic */ KodeinProperty allProviders$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$8
        }), obj, new GKodeinAwareKt$allProviders$2(typed));
    }

    public static /* synthetic */ KodeinProperty instance$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$8
        }), obj, new GKodeinAwareKt$instance$2(typed));
    }

    public static /* synthetic */ KodeinProperty instanceOrNull$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$8
        }), obj, new GKodeinAwareKt$instanceOrNull$2(typed));
    }

    public static /* synthetic */ KodeinProperty provider$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$8
        }), obj, new GKodeinAwareKt$provider$2(typed));
    }

    public static /* synthetic */ KodeinProperty providerOrNull$default(KodeinAware kodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$8
        }), obj, new GKodeinAwareKt$providerOrNull$2(typed));
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<T>> allInstances(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$10
        }), obj, function0);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<List<Function0<T>>> allProviders(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$10
        }), obj, function0);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instance(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$10
        }), obj, function0);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<T> instanceOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$10
        }), obj, function0);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> provider(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$10
        }), obj, function0);
    }

    @NotNull
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> providerOrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$10
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty allInstances$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllInstances(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allInstances$$inlined$generic$12
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty allProviders$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareJVMKt.AllProviders(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$allProviders$$inlined$generic$12
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty instance$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Instance(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instance$$inlined$generic$12
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty instanceOrNull$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.InstanceOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$instanceOrNull$$inlined$generic$12
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty provider$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.Provider(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$provider$$inlined$generic$12
        }), obj, function0);
    }

    public static /* synthetic */ KodeinProperty providerOrNull$default(KodeinAware kodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return KodeinAwareKt.ProviderOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GKodeinAwareKt$providerOrNull$$inlined$generic$12
        }), obj, function0);
    }
}
