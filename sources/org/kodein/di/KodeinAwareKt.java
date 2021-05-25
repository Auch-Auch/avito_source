package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.VKScope;
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
import org.kodein.di.internal.DKodeinImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a_\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aa\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\u000b\u001aC\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001ag\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000e\u0010\u0011\u001aE\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r0\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u000f\u001ai\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r0\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0011\u001a=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0013\u0010\u000f\u001a_\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0013\u0010\u0011\u001a?\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0014\u0010\u000f\u001ac\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0014\u0010\u0011\u001a+\u0010\u001a\u001a\u00020\u0019*\u00020\u00032\f\b\u0002\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001b\u001a6\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u001d¢\u0006\u0004\b\u001f\u0010 \"\u0017\u0010#\u001a\u00020\u001c*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"\"/\u0010(\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00158À\u0002@\u0000X\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\"\u001b\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/KodeinAware;", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "Lorg/kodein/di/KodeinProperty;", "Lkotlin/Function1;", "Factory", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "FactoryOrNull", "Lkotlin/Function0;", "Provider", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "arg", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinProperty;", "ProviderOrNull", "Instance", "InstanceOrNull", "Lorg/kodein/di/KodeinContext;", "context", "Lorg/kodein/di/KodeinTrigger;", "trigger", "Lorg/kodein/di/Kodein;", "On", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/KodeinContext;Lorg/kodein/di/KodeinTrigger;)Lorg/kodein/di/Kodein;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "creator", "newInstance", "(Lorg/kodein/di/KodeinAware;Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/KodeinProperty;", "getDirect", "(Lorg/kodein/di/KodeinAware;)Lorg/kodein/di/DKodein;", VKScope.DIRECT, "getAnyType", "(Lorg/kodein/di/KodeinContext;)Lorg/kodein/di/TypeToken;", "anyType$annotations", "(Lorg/kodein/di/KodeinContext;)V", "anyType", "getAnyKodeinContext", "()Lorg/kodein/di/KodeinContext;", "AnyKodeinContext", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class KodeinAwareKt {

    public static final class a extends Lambda implements Function2<KodeinContext<?>, String, Function1<? super A, ? extends T>> {
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
                return KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class b extends Lambda implements Function2<KodeinContext<?>, String, Function1<? super A, ? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj) {
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
                return KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class c extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
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
                return KodeinContainer.DefaultImpls.provider$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null).invoke();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class d extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
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
                return KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null).invoke(this.e.invoke());
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class e extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
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
                Function0 providerOrNull$default = KodeinContainer.DefaultImpls.providerOrNull$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null);
                if (providerOrNull$default != null) {
                    return providerOrNull$default.invoke();
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class f extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
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
                Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
                if (factoryOrNull$default != null) {
                    return factoryOrNull$default.invoke(this.e.invoke());
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class g extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
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
                return KodeinContainer.DefaultImpls.provider$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class h extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
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
                return new CurryKt$toProvider$1(KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null), this.e);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class i extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(KodeinAware kodeinAware, TypeToken typeToken, Object obj) {
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
                return KodeinContainer.DefaultImpls.providerOrNull$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, this.c), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class j extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0) {
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
                Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, this.d), kodeinContext2.getValue(), 0, 4, null);
                if (factoryOrNull$default != null) {
                    return new CurryKt$toProvider$1(factoryOrNull$default, this.e);
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class k extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(KodeinAware kodeinAware, Function1 function1) {
            super(2);
            this.a = kodeinAware;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 1>");
            return this.b.invoke(KodeinAwareKt.getDirect(this.a.getKodein()).On(kodeinContext2));
        }
    }

    @NotNull
    public static final <A, T> KodeinProperty<Function1<A, T>> Factory(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Factory");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new a(kodeinAware, typeToken, typeToken2, obj));
    }

    public static /* synthetic */ KodeinProperty Factory$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return Factory(kodeinAware, typeToken, typeToken2, obj);
    }

    @NotNull
    public static final <A, T> KodeinProperty<Function1<A, T>> FactoryOrNull(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$FactoryOrNull");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new b(kodeinAware, typeToken, typeToken2, obj));
    }

    public static /* synthetic */ KodeinProperty FactoryOrNull$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return FactoryOrNull(kodeinAware, typeToken, typeToken2, obj);
    }

    @NotNull
    public static final <T> KodeinProperty<T> Instance(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Instance");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new c(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty Instance$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return Instance(kodeinAware, typeToken, obj);
    }

    @NotNull
    public static final <T> KodeinProperty<T> InstanceOrNull(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$InstanceOrNull");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new e(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty InstanceOrNull$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return InstanceOrNull(kodeinAware, typeToken, obj);
    }

    @NotNull
    public static final Kodein On(@NotNull KodeinAware kodeinAware, @NotNull KodeinContext<?> kodeinContext, @Nullable KodeinTrigger kodeinTrigger) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$On");
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
        return new x6.d.a.g(kodeinAware, kodeinContext, kodeinTrigger);
    }

    public static /* synthetic */ Kodein On$default(KodeinAware kodeinAware, KodeinContext kodeinContext, KodeinTrigger kodeinTrigger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kodeinContext = kodeinAware.getKodeinContext();
        }
        if ((i2 & 2) != 0) {
            kodeinTrigger = kodeinAware.getKodeinTrigger();
        }
        return On(kodeinAware, kodeinContext, kodeinTrigger);
    }

    @NotNull
    public static final <T> KodeinProperty<Function0<T>> Provider(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Provider");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new g(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty Provider$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return Provider(kodeinAware, typeToken, obj);
    }

    @NotNull
    public static final <T> KodeinProperty<Function0<T>> ProviderOrNull(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$ProviderOrNull");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new i(kodeinAware, typeToken, obj));
    }

    public static /* synthetic */ KodeinProperty ProviderOrNull$default(KodeinAware kodeinAware, TypeToken typeToken, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return ProviderOrNull(kodeinAware, typeToken, obj);
    }

    public static /* synthetic */ void anyType$annotations(KodeinContext kodeinContext) {
    }

    @NotNull
    public static final KodeinContext<Object> getAnyKodeinContext() {
        x6.d.a.e eVar = x6.d.a.e.b;
        return x6.d.a.e.a;
    }

    @NotNull
    public static final TypeToken<? super Object> getAnyType(@NotNull KodeinContext<?> kodeinContext) {
        Intrinsics.checkParameterIsNotNull(kodeinContext, "$this$anyType");
        TypeToken<? super Object> type = kodeinContext.getType();
        if (type != null) {
            return type;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
    }

    @NotNull
    public static final DKodein getDirect(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$direct");
        return new DKodeinImpl(kodeinAware.getKodein().getContainer(), kodeinAware.getKodeinContext());
    }

    @NotNull
    public static final <T> KodeinProperty<T> newInstance(@NotNull KodeinAware kodeinAware, @NotNull Function1<? super DKodein, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$newInstance");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new k(kodeinAware, function1));
    }

    @NotNull
    public static final <A, T> KodeinProperty<T> Instance(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Instance");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new d(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty Instance$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return Instance(kodeinAware, typeToken, typeToken2, obj, function0);
    }

    @NotNull
    public static final <A, T> KodeinProperty<T> InstanceOrNull(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$InstanceOrNull");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new f(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty InstanceOrNull$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return InstanceOrNull(kodeinAware, typeToken, typeToken2, obj, function0);
    }

    @NotNull
    public static final <A, T> KodeinProperty<Function0<T>> Provider(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Provider");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new h(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty Provider$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return Provider(kodeinAware, typeToken, typeToken2, obj, function0);
    }

    @NotNull
    public static final <A, T> KodeinProperty<Function0<T>> ProviderOrNull(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$ProviderOrNull");
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new j(kodeinAware, typeToken, typeToken2, obj, function0));
    }

    public static /* synthetic */ KodeinProperty ProviderOrNull$default(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return ProviderOrNull(kodeinAware, typeToken, typeToken2, obj, function0);
    }
}
