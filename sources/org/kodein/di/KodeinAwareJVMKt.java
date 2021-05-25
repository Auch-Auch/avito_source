package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ae\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000b\u0010\f\u001aI\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\t0\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001am\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\t0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000e\u0010\u0011\u001aC\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u000f\u001ae\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/KodeinAware;", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "Lorg/kodein/di/KodeinProperty;", "", "Lkotlin/Function1;", "AllFactories", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "Lkotlin/Function0;", "AllProviders", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "arg", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinProperty;", "AllInstances", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class KodeinAwareJVMKt {

    public static final class a extends Lambda implements Function2<KodeinContext<?>, String, List<? extends Function1<? super A, ? extends T>>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.allFactories$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class b extends Lambda implements Function2<KodeinContext<?>, String, List<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                List<Function0> allProviders$default = KodeinContainer.DefaultImpls.allProviders$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null);
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(allProviders$default, 10));
                for (Function0 function0 : allProviders$default) {
                    arrayList.add(function0.invoke());
                }
                return arrayList;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class c extends Lambda implements Function2<KodeinContext<?>, String, List<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = obj;
            this.e = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                List<Function1> allFactories$default = KodeinContainer.DefaultImpls.allFactories$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(allFactories$default, 10));
                for (Function1 function1 : allFactories$default) {
                    arrayList.add(function1.invoke(this.e.invoke()));
                }
                return arrayList;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class d extends Lambda implements Function2<KodeinContext<?>, String, List<? extends Function0<? extends T>>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.allProviders$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class e extends Lambda implements Function2<KodeinContext<?>, String, List<? extends Function0<? extends T>>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = obj;
            this.e = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                List<Function1> allFactories$default = KodeinContainer.DefaultImpls.allFactories$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(allFactories$default, 10));
                for (Function1 function1 : allFactories$default) {
                    arrayList.add(new CurryKt$toProvider$1(function1, this.e));
                }
                return arrayList;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    @NotNull
    public static final <A, T> KodeinProperty<List<Function1<A, T>>> AllFactories(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$AllFactories");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new a(kodeinAware, typeToken, typeToken2, obj));
    }

    public static /* synthetic */ KodeinProperty AllFactories$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return AllFactories(kodeinAware, typeToken, typeToken2, obj);
    }

    @NotNull
    public static final <T> KodeinProperty<List<T>> AllInstances(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$AllInstances");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new b(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty AllInstances$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return AllInstances(kodeinAware, typeToken, obj);
    }

    @NotNull
    public static final <T> KodeinProperty<List<Function0<T>>> AllProviders(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$AllProviders");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new d(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty AllProviders$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return AllProviders(kodeinAware, typeToken, obj);
    }

    @NotNull
    public static final <A, T> KodeinProperty<List<T>> AllInstances(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$AllInstances");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new c(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty AllInstances$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return AllInstances(kodeinAware, typeToken, typeToken2, obj, function0);
    }

    @NotNull
    public static final <A, T> KodeinProperty<List<Function0<T>>> AllProviders(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$AllProviders");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new e(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty AllProviders$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return AllProviders(kodeinAware, typeToken, typeToken2, obj, function0);
    }
}
