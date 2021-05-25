package org.kodein.di.generic;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.GeoContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.DKodeinAware;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.Typed;
import org.kodein.di.TypesKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a@\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aB\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\t\u0010\n\u001aF\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u000b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\f\u0010\r\u001a2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001aB\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\u000f\u0010\u0012\u001aF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u000f\u0010\u0014\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\b¢\u0006\u0004\b\u000f\u0010\u0016\u001a4\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0017\u0010\u0010\u001aD\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0012\u001aH\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u0017\u0010\u0014\u001aL\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a8\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u000b\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001aH\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\u000b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0018\u0010\u001a\u001aL\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\u000b\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u0018\u0010\u001b\u001aP\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\u000b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u000e\b\b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\b¢\u0006\u0004\b\u0018\u0010\u001c\u001a,\u0010\u001d\u001a\u00028\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a<\u0010\u001d\u001a\u00028\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\u001d\u0010\u001f\u001a@\u0010\u001d\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u001d\u0010 \u001a.\u0010!\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b!\u0010\u001e\u001a>\u0010!\u001a\u0004\u0018\u00018\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b!\u0010\u001f\u001aB\u0010!\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b!\u0010 \u001a2\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\"\u0010\u0019\u001aB\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\"\u0010\u001a\u001aF\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\"\u0010\u001b\u001a$\u0010%\u001a\u00020\u0003\"\u0006\b\u0000\u0010#\u0018\u0001*\u00020\b2\u0006\u0010$\u001a\u00028\u0000H\b¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/DKodein;", "tag", "Lkotlin/Function1;", "factory", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lorg/kodein/di/DKodeinAware;", "factoryOrNull", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "allFactories", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/Function0;", GeoContract.PROVIDER, "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "arg", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "Lorg/kodein/di/Typed;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Lorg/kodein/di/Typed;)Lkotlin/jvm/functions/Function0;", "fArg", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "providerOrNull", "allProviders", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;)Ljava/util/List;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Lorg/kodein/di/Typed;)Ljava/util/List;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "instance", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;Lorg/kodein/di/Typed;)Ljava/lang/Object;", "instanceOrNull", "allInstances", "C", "context", DebugKt.DEBUG_PROPERTY_VALUE_ON, "(Lorg/kodein/di/DKodeinAware;Ljava/lang/Object;)Lorg/kodein/di/DKodein;", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GDKodeinKt {
    @NotNull
    public static final /* synthetic */ <A, T> List<Function1<A, T>> allFactories(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$allFactories");
        Intrinsics.needClassReification();
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allFactories$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return dKodein.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allFactories$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ List allFactories$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$allFactories");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allFactories$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return dKodein.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allFactories$$inlined$generic$4
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> List<T> allInstances(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        List<Function1<A, T>> AllFactories = dkodein.AllFactories(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$7
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        Iterator<T> it = AllFactories.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().invoke(typed.getValue()));
        }
        return arrayList;
    }

    public static /* synthetic */ List allInstances$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$allInstances").AllInstances(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> List<Function0<T>> allProviders(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        List<Function1<A, T>> AllFactories = dkodein.AllFactories(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$7
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        Iterator<T> it = AllFactories.iterator();
        while (it.hasNext()) {
            arrayList.add(new Function0<T>(it.next(), typed) { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$map$lambda$3
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Typed b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.getValue());
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ List allProviders$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$allProviders").AllProviders(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> Function1<A, T> factory(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory");
        Intrinsics.needClassReification();
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$factory$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$factory$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ Function1 factory$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$factory$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$factory$$inlined$generic$4
        }), obj);
    }

    @Nullable
    public static final /* synthetic */ <A, T> Function1<A, T> factoryOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj) {
        DKodein w0 = a.w0(dKodeinAware, "$this$factoryOrNull");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$factoryOrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$factoryOrNull$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ Function1 factoryOrNull$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$factoryOrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$factoryOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$factoryOrNull$$inlined$generic$4
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <A, T> T instance(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return dkodein.Factory(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$7
        }), obj).invoke(typed.getValue());
    }

    public static /* synthetic */ Object instance$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$instance").Instance(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$2
        }), obj);
    }

    @Nullable
    public static final /* synthetic */ <A, T> T instanceOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        Function1<A, T> FactoryOrNull = dkodein.FactoryOrNull(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$7
        }), obj);
        if (FactoryOrNull != null) {
            return FactoryOrNull.invoke(typed.getValue());
        }
        return null;
    }

    public static /* synthetic */ Object instanceOrNull$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$instanceOrNull").InstanceOrNull(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$2
        }), obj);
    }

    @NotNull
    public static final /* synthetic */ <C> DKodein on(@NotNull DKodeinAware dKodeinAware, C c) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$on");
        DKodein dkodein = dKodeinAware.getDkodein();
        KodeinContext.Companion companion = KodeinContext.Companion;
        Intrinsics.needClassReification();
        return dkodein.On(companion.invoke(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GDKodeinKt$on$$inlined$kcontext$1
        }), (TypeToken<? super C>) c));
    }

    @NotNull
    public static final /* synthetic */ <A, T> Function0<T> provider(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return new Function0<T>(dkodein.Factory(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$7
        }), obj), typed) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$3
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Typed b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b.getValue());
            }
        };
    }

    public static /* synthetic */ Function0 provider$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$provider").Provider(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$2
        }), obj);
    }

    @Nullable
    public static final /* synthetic */ <A, T> Function0<T> providerOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        Function1<A, T> FactoryOrNull = dkodein.FactoryOrNull(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$7
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, typed) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$3
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Typed b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.getValue());
                }
            };
        }
        return null;
    }

    public static /* synthetic */ Function0 providerOrNull$default(DKodeinAware dKodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a.w0(dKodeinAware, "$this$providerOrNull").ProviderOrNull(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$2
        }), obj);
    }

    public static /* synthetic */ List allInstances$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$allInstances");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        List<Function1> AllFactories = w0.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$6
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        for (Function1 function1 : AllFactories) {
            arrayList.add(function1.invoke(obj2));
        }
        return arrayList;
    }

    public static /* synthetic */ List allProviders$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$allProviders");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        List<Function1> AllFactories = w0.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$6
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        for (Function1 function1 : AllFactories) {
            arrayList.add(new Function0<T>(function1, obj2) { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$map$lambda$2
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Object b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b);
                }
            });
        }
        return arrayList;
    }

    @NotNull
    public static final /* synthetic */ <T> T instance(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj) {
        return (T) a.w0(dKodeinAware, "$this$instance").Instance(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ Object instance$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$instance");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return w0.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$6
        }), obj).invoke(obj2);
    }

    @Nullable
    public static final /* synthetic */ <T> T instanceOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj) {
        return (T) a.w0(dKodeinAware, "$this$instanceOrNull").InstanceOrNull(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$1
        }), obj);
    }

    public static /* synthetic */ Object instanceOrNull$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$instanceOrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return FactoryOrNull.invoke(obj2);
        }
        return null;
    }

    public static /* synthetic */ Function0 provider$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$provider");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new Function0<T>(w0.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$6
        }), obj), obj2) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$2
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Object b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b);
            }
        };
    }

    public static /* synthetic */ Function0 providerOrNull$default(DKodeinAware dKodeinAware, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = null;
        }
        DKodein w0 = a.w0(dKodeinAware, "$this$providerOrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, obj2) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$2
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Object b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b);
                }
            };
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A, T> Function0<T> provider(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return new Function0<T>(dkodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$10
        }), obj), function0) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$5
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b.invoke());
            }
        };
    }

    @Nullable
    public static final /* synthetic */ <A, T> Function0<T> providerOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        Function1<A, T> FactoryOrNull = dkodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$10
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, function0) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$5
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Function0 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.invoke());
                }
            };
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A, T> T instance(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$instance");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return w0.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$4
        }), obj).invoke(a);
    }

    @Nullable
    public static final /* synthetic */ <A, T> T instanceOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$instanceOrNull");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        Function1<A, T> FactoryOrNull = w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$4
        }), obj);
        if (FactoryOrNull != null) {
            return FactoryOrNull.invoke(a);
        }
        return null;
    }

    public static /* synthetic */ Object instance$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return dkodein.Factory(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instance$$inlined$generic$8
        }), obj).invoke(typed.getValue());
    }

    public static /* synthetic */ Object instanceOrNull$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dkodein.FactoryOrNull(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$instanceOrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return FactoryOrNull.invoke(typed.getValue());
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A, T> List<Function0<T>> allProviders(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        List<Function1<A, T>> AllFactories = dkodein.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$10
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        Iterator<T> it = AllFactories.iterator();
        while (it.hasNext()) {
            arrayList.add(new Function0<T>(it.next(), function0) { // from class: org.kodein.di.generic.GDKodeinKt$$special$$inlined$toProvider$5
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Function0 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.invoke());
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ Function0 provider$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        return new Function0<T>(dkodein.Factory(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$8
        }), obj), typed) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$4
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Typed b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b.getValue());
            }
        };
    }

    public static /* synthetic */ Function0 providerOrNull$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dkodein.FactoryOrNull(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, typed) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$4
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Typed b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.getValue());
                }
            };
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A, T> List<T> allInstances(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$allInstances");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        List<Function1<A, T>> AllFactories = w0.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$4
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        Iterator<T> it = AllFactories.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().invoke(a));
        }
        return arrayList;
    }

    public static /* synthetic */ List allInstances$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allInstances");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        List<Function1> AllFactories = dkodein.AllFactories(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allInstances$$inlined$generic$8
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        for (Function1 function1 : AllFactories) {
            arrayList.add(function1.invoke(typed.getValue()));
        }
        return arrayList;
    }

    @NotNull
    public static final /* synthetic */ <A, T> Function0<T> provider(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$provider");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new Function0<T>(w0.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$4
        }), obj), a) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$1
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Object b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b);
            }
        };
    }

    @Nullable
    public static final /* synthetic */ <A, T> Function0<T> providerOrNull(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$providerOrNull");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        Function1<A, T> FactoryOrNull = w0.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$4
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, a) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$1
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Object b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b);
                }
            };
        }
        return null;
    }

    public static /* synthetic */ List allProviders$default(DKodeinAware dKodeinAware, Object obj, Typed typed, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        DKodein dkodein = dKodeinAware.getDkodein();
        TypeToken type = typed.getType();
        Intrinsics.needClassReification();
        List<Function1> AllFactories = dkodein.AllFactories(type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$8
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        for (Function1 function1 : AllFactories) {
            arrayList.add(new Function0<T>(function1, typed) { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$map$lambda$4
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Typed b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.getValue());
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ Function0 provider$default(DKodeinAware dKodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return new Function0<T>(dkodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$generic$12
        }), obj), function0) { // from class: org.kodein.di.generic.GDKodeinKt$provider$$inlined$toProvider$6
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final T invoke() {
                return (T) this.a.invoke(this.b.invoke());
            }
        };
    }

    public static /* synthetic */ Function0 providerOrNull$default(DKodeinAware dKodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dkodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$generic$12
        }), obj);
        if (FactoryOrNull != null) {
            return new Function0<T>(FactoryOrNull, function0) { // from class: org.kodein.di.generic.GDKodeinKt$providerOrNull$$inlined$toProvider$6
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Function0 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.invoke());
                }
            };
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A, T> List<Function0<T>> allProviders(@NotNull DKodeinAware dKodeinAware, @Nullable Object obj, A a) {
        DKodein w0 = a.w0(dKodeinAware, "$this$allProviders");
        TypeToken<? super A> TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        List<Function1<A, T>> AllFactories = w0.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$4
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        Iterator<T> it = AllFactories.iterator();
        while (it.hasNext()) {
            arrayList.add(new Function0<T>(it.next(), a) { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$map$lambda$1
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Object b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b);
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ List allProviders$default(DKodeinAware dKodeinAware, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$allProviders");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        DKodein dkodein = dKodeinAware.getDkodein();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        List<Function1> AllFactories = dkodein.AllFactories(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GDKodeinKt$allProviders$$inlined$generic$12
        }), obj);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(AllFactories, 10));
        for (Function1 function1 : AllFactories) {
            arrayList.add(new Function0<T>(function1, function0) { // from class: org.kodein.di.generic.GDKodeinKt$$special$$inlined$toProvider$6
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ Function0 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final T invoke() {
                    return (T) this.a.invoke(this.b.invoke());
                }
            });
        }
        return arrayList;
    }
}
