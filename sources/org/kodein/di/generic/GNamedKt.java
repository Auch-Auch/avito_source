package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.GeoContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinProperty;
import org.kodein.di.Named;
import org.kodein.di.NamedKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.Typed;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a?\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a/\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0004\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0007\u001a?\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aC\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aG\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u000e\b\b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\u0004\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0007\u001aA\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010\u001aE\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u0004\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0013\u001aI\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u000e\b\b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0016\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0007\u001a9\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0010\u001a=\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0013\u001aA\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u000e\b\b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\bø\u0001\u0000¢\u0006\u0004\b \u0010\u0016\u001a+\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u0007\u001a;\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u0010\u001a?\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0013\u001aC\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020\u00032\u000e\b\b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u0016\u001a&\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0001*\u00020&H\b¢\u0006\u0004\b'\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/Named;", "Lorg/kodein/di/KodeinProperty;", "Lkotlin/Function1;", "factory-Ecll6q0", "(Lorg/kodein/di/KodeinAware;)Lorg/kodein/di/KodeinProperty;", "factory", "factoryOrNull-Ecll6q0", "factoryOrNull", "Lkotlin/Function0;", "provider-Ecll6q0", GeoContract.PROVIDER, "arg", "provider-iE_nun4", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;)Lorg/kodein/di/KodeinProperty;", "Lorg/kodein/di/Typed;", "provider-NaS0UTs", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/Typed;)Lorg/kodein/di/KodeinProperty;", "fArg", "provider-sLx_guQ", "(Lorg/kodein/di/KodeinAware;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinProperty;", "providerOrNull-Ecll6q0", "providerOrNull", "providerOrNull-iE_nun4", "providerOrNull-NaS0UTs", "providerOrNull-sLx_guQ", "instance-Ecll6q0", "instance", "instance-iE_nun4", "instance-NaS0UTs", "instance-sLx_guQ", "instanceOrNull-Ecll6q0", "instanceOrNull", "instanceOrNull-iE_nun4", "instanceOrNull-NaS0UTs", "instanceOrNull-sLx_guQ", "Lorg/kodein/di/KodeinAware;", "constant", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GNamedKt {
    @NotNull
    public static final /* synthetic */ <T> KodeinProperty<T> constant(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$constant");
        Intrinsics.needClassReification();
        return NamedKt.Constant(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$constant$$inlined$generic$1
        }));
    }

    @NotNull
    /* renamed from: factory-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function1<A, T>> m714factoryEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$factory$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return Named.m697Factoryimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$factory$$inlined$generic$2
        }));
    }

    @NotNull
    /* renamed from: factoryOrNull-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function1<A, T>> m715factoryOrNullEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factoryOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$factoryOrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return Named.m698FactoryOrNullimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$factoryOrNull$$inlined$generic$2
        }));
    }

    @NotNull
    /* renamed from: instance-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <T> KodeinProperty<T> m716instanceEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        return Named.m699Instanceimpl(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$1
        }));
    }

    @NotNull
    /* renamed from: instance-NaS0UTs  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m717instanceNaS0UTs(@NotNull KodeinAware kodeinAware, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return Named.m700Instanceimpl(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$4
        }), new Function0<A>(typed) { // from class: org.kodein.di.generic.GNamedKt$instance$2
            public final /* synthetic */ Typed a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a.getValue();
            }
        });
    }

    @NotNull
    /* renamed from: instance-iE_nun4  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m718instanceiE_nun4(@NotNull KodeinAware kodeinAware, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$2
        });
        Intrinsics.needClassReification();
        return Named.m700Instanceimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$3
        }), new Function0<A>(a) { // from class: org.kodein.di.generic.GNamedKt$instance$1
            public final /* synthetic */ Object a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a;
            }
        });
    }

    @NotNull
    /* renamed from: instance-sLx_guQ  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m719instancesLx_guQ(@NotNull KodeinAware kodeinAware, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instance");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return Named.m700Instanceimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instance$$inlined$generic$6
        }), function0);
    }

    @NotNull
    /* renamed from: instanceOrNull-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <T> KodeinProperty<T> m720instanceOrNullEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        return Named.m701InstanceOrNullimpl(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$1
        }));
    }

    @NotNull
    /* renamed from: instanceOrNull-NaS0UTs  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m721instanceOrNullNaS0UTs(@NotNull KodeinAware kodeinAware, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return Named.m702InstanceOrNullimpl(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$4
        }), new Function0<A>(typed) { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$2
            public final /* synthetic */ Typed a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a.getValue();
            }
        });
    }

    @NotNull
    /* renamed from: instanceOrNull-iE_nun4  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m722instanceOrNulliE_nun4(@NotNull KodeinAware kodeinAware, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$2
        });
        Intrinsics.needClassReification();
        return Named.m702InstanceOrNullimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$3
        }), new Function0<A>(a) { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$1
            public final /* synthetic */ Object a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a;
            }
        });
    }

    @NotNull
    /* renamed from: instanceOrNull-sLx_guQ  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<T> m723instanceOrNullsLx_guQ(@NotNull KodeinAware kodeinAware, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$instanceOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return Named.m702InstanceOrNullimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$instanceOrNull$$inlined$generic$6
        }), function0);
    }

    @NotNull
    /* renamed from: provider-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <T> KodeinProperty<Function0<T>> m724providerEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        return Named.m703Providerimpl(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$1
        }));
    }

    @NotNull
    /* renamed from: provider-NaS0UTs  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m725providerNaS0UTs(@NotNull KodeinAware kodeinAware, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return Named.m704Providerimpl(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$4
        }), new Function0<A>(typed) { // from class: org.kodein.di.generic.GNamedKt$provider$2
            public final /* synthetic */ Typed a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a.getValue();
            }
        });
    }

    @NotNull
    /* renamed from: provider-iE_nun4  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m726provideriE_nun4(@NotNull KodeinAware kodeinAware, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$2
        });
        Intrinsics.needClassReification();
        return Named.m704Providerimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$3
        }), new Function0<A>(a) { // from class: org.kodein.di.generic.GNamedKt$provider$1
            public final /* synthetic */ Object a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a;
            }
        });
    }

    @NotNull
    /* renamed from: provider-sLx_guQ  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m727providersLx_guQ(@NotNull KodeinAware kodeinAware, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return Named.m704Providerimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$provider$$inlined$generic$6
        }), function0);
    }

    @NotNull
    /* renamed from: providerOrNull-Ecll6q0  reason: not valid java name */
    public static final /* synthetic */ <T> KodeinProperty<Function0<T>> m728providerOrNullEcll6q0(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        return Named.m705ProviderOrNullimpl(kodeinAware, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$1
        }));
    }

    @NotNull
    /* renamed from: providerOrNull-NaS0UTs  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m729providerOrNullNaS0UTs(@NotNull KodeinAware kodeinAware, @NotNull Typed<A> typed) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(typed, "arg");
        TypeToken<A> type = typed.getType();
        Intrinsics.needClassReification();
        return Named.m706ProviderOrNullimpl(kodeinAware, type, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$4
        }), new Function0<A>(typed) { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$2
            public final /* synthetic */ Typed a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a.getValue();
            }
        });
    }

    @NotNull
    /* renamed from: providerOrNull-iE_nun4  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m730providerOrNulliE_nun4(@NotNull KodeinAware kodeinAware, A a) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$2
        });
        Intrinsics.needClassReification();
        return Named.m706ProviderOrNullimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$3
        }), new Function0<A>(a) { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$1
            public final /* synthetic */ Object a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a;
            }
        });
    }

    @NotNull
    /* renamed from: providerOrNull-sLx_guQ  reason: not valid java name */
    public static final /* synthetic */ <A, T> KodeinProperty<Function0<T>> m731providerOrNullsLx_guQ(@NotNull KodeinAware kodeinAware, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$providerOrNull");
        Intrinsics.checkParameterIsNotNull(function0, "fArg");
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return Named.m706ProviderOrNullimpl(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GNamedKt$providerOrNull$$inlined$generic$6
        }), function0);
    }
}
