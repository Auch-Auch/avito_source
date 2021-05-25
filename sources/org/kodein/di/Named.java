package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010)\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\b*\u0010+JO\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0004¢\u0006\u0004\b\t\u0010\nJQ\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0004¢\u0006\u0004\b\f\u0010\nJ3\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0013J5\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e0\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0014\u0010\u0010JY\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e0\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0016\u0010\u0010JO\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0016\u0010\u0013J/\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0018\u0010\u0010JS\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lorg/kodein/di/Named;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "Lorg/kodein/di/KodeinProperty;", "Lkotlin/Function1;", "Factory-impl", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/KodeinProperty;", "Factory", "FactoryOrNull-impl", "FactoryOrNull", "Lkotlin/Function0;", "Provider-impl", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/KodeinProperty;", "Provider", "arg", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinProperty;", "ProviderOrNull-impl", "ProviderOrNull", "Instance-impl", "Instance", "InstanceOrNull-impl", "InstanceOrNull", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lorg/kodein/di/KodeinAware;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/KodeinAware;", "getKodein", "()Lorg/kodein/di/KodeinAware;", "kodein", "constructor-impl", "(Lorg/kodein/di/KodeinAware;)Lorg/kodein/di/KodeinAware;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Named {
    @NotNull
    public final KodeinAware a;

    public static final class a extends Lambda implements Function2<KodeinContext<?>, String, Function1<? super A, ? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class b extends Lambda implements Function2<KodeinContext<?>, String, Function1<? super A, ? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class c extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KodeinAware kodeinAware, TypeToken typeToken) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.provider$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, str2), kodeinContext2.getValue(), 0, 4, null).invoke();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class d extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Function0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null).invoke(this.d.invoke());
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class e extends Lambda implements Function2<KodeinContext<?>, String, T> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KodeinAware kodeinAware, TypeToken typeToken) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                Function0 providerOrNull$default = KodeinContainer.DefaultImpls.providerOrNull$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, str2), kodeinContext2.getValue(), 0, 4, null);
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
        public final /* synthetic */ Function0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null);
                if (factoryOrNull$default != null) {
                    return factoryOrNull$default.invoke(this.d.invoke());
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class g extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(KodeinAware kodeinAware, TypeToken typeToken) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.provider$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, str2), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class h extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Function0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return new CurryKt$toProvider$1(KodeinContainer.DefaultImpls.factory$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null), this.d);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class i extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(KodeinAware kodeinAware, TypeToken typeToken) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                return KodeinContainer.DefaultImpls.providerOrNull$default(container, new Kodein.Key(type, TypeTokenKt.getUnitToken(), this.b, str2), kodeinContext2.getValue(), 0, 4, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public static final class j extends Lambda implements Function2<KodeinContext<?>, String, Function0<? extends T>> {
        public final /* synthetic */ KodeinAware a;
        public final /* synthetic */ TypeToken b;
        public final /* synthetic */ TypeToken c;
        public final /* synthetic */ Function0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(KodeinAware kodeinAware, TypeToken typeToken, TypeToken typeToken2, Function0 function0) {
            super(2);
            this.a = kodeinAware;
            this.b = typeToken;
            this.c = typeToken2;
            this.d = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(KodeinContext<?> kodeinContext, String str) {
            KodeinContext<?> kodeinContext2 = kodeinContext;
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(kodeinContext2, "ctx");
            Intrinsics.checkParameterIsNotNull(str2, "tag");
            KodeinContainer container = this.a.getKodein().getContainer();
            TypeToken<? super Object> type = kodeinContext2.getType();
            if (type != null) {
                Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(container, new Kodein.Key(type, this.b, this.c, str2), kodeinContext2.getValue(), 0, 4, null);
                if (factoryOrNull$default != null) {
                    return new CurryKt$toProvider$1(factoryOrNull$default, this.d);
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
        }
    }

    public /* synthetic */ Named(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "kodein");
        this.a = kodeinAware;
    }

    @NotNull
    /* renamed from: Factory-impl  reason: not valid java name */
    public static final KodeinProperty<Function1<A, T>> m697Factoryimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new a(kodeinAware, typeToken, typeToken2));
    }

    @NotNull
    /* renamed from: FactoryOrNull-impl  reason: not valid java name */
    public static final KodeinProperty<Function1<A, T>> m698FactoryOrNullimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new b(kodeinAware, typeToken, typeToken2));
    }

    @NotNull
    /* renamed from: Instance-impl  reason: not valid java name */
    public static final KodeinProperty<T> m699Instanceimpl(KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new c(kodeinAware, typeToken));
    }

    @NotNull
    /* renamed from: InstanceOrNull-impl  reason: not valid java name */
    public static final KodeinProperty<T> m701InstanceOrNullimpl(KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new e(kodeinAware, typeToken));
    }

    @NotNull
    /* renamed from: Provider-impl  reason: not valid java name */
    public static final KodeinProperty<Function0<T>> m703Providerimpl(KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new g(kodeinAware, typeToken));
    }

    @NotNull
    /* renamed from: ProviderOrNull-impl  reason: not valid java name */
    public static final KodeinProperty<Function0<T>> m705ProviderOrNullimpl(KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new i(kodeinAware, typeToken));
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static KodeinAware m708constructorimpl(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "kodein");
        return kodeinAware;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m709equalsimpl(KodeinAware kodeinAware, @Nullable Object obj) {
        return (obj instanceof Named) && Intrinsics.areEqual(kodeinAware, ((Named) obj).m713unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m710equalsimpl0(@NotNull KodeinAware kodeinAware, @NotNull KodeinAware kodeinAware2) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "p1");
        Intrinsics.checkParameterIsNotNull(kodeinAware2, "p2");
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m711hashCodeimpl(KodeinAware kodeinAware) {
        if (kodeinAware != null) {
            return kodeinAware.hashCode();
        }
        return 0;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m712toStringimpl(KodeinAware kodeinAware) {
        return "Named(kodein=" + kodeinAware + ")";
    }

    public boolean equals(Object obj) {
        return m709equalsimpl(this.a, obj);
    }

    @NotNull
    public final KodeinAware getKodein() {
        return this.a;
    }

    public int hashCode() {
        return m711hashCodeimpl(this.a);
    }

    public String toString() {
        return m712toStringimpl(this.a);
    }

    @NotNull
    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ KodeinAware m713unboximpl() {
        return this.a;
    }

    @NotNull
    /* renamed from: Instance-impl  reason: not valid java name */
    public static final KodeinProperty<T> m700Instanceimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new d(kodeinAware, typeToken, typeToken2, function0));
    }

    @NotNull
    /* renamed from: InstanceOrNull-impl  reason: not valid java name */
    public static final KodeinProperty<T> m702InstanceOrNullimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new f(kodeinAware, typeToken, typeToken2, function0));
    }

    @NotNull
    /* renamed from: Provider-impl  reason: not valid java name */
    public static final KodeinProperty<Function0<T>> m704Providerimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new h(kodeinAware, typeToken, typeToken2, function0));
    }

    @NotNull
    /* renamed from: ProviderOrNull-impl  reason: not valid java name */
    public static final KodeinProperty<Function0<T>> m706ProviderOrNullimpl(KodeinAware kodeinAware, @NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<? extends T> typeToken2, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new KodeinProperty<>(kodeinAware.getKodeinTrigger(), kodeinAware.getKodeinContext(), new j(kodeinAware, typeToken, typeToken2, function0));
    }
}
