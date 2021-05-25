package org.kodein.di.bindings;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\"J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u001e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u001e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0016\u0010\u001f\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0016\u0010!\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lorg/kodein/di/bindings/KodeinBinding;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/Binding;", "", "factoryName", "()Ljava/lang/String;", "factoryFullName", "Lorg/kodein/di/TypeToken;", "getArgType", "()Lorg/kodein/di/TypeToken;", "argType", "", "getSupportSubTypes", "()Z", "supportSubTypes", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "getCreatedType", "createdType", "getContextType", "contextType", "getFullDescription", "fullDescription", "getDescription", "description", "Copier", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface KodeinBinding<C, A, T> extends Binding<C, A, T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\b\b\u0005\u0010\u0004*\u00020\u00032\u00020\u0003:\u0001\nJ)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/bindings/KodeinBinding$Copier;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/KodeinContainer$Builder;", "builder", "Lorg/kodein/di/bindings/KodeinBinding;", "copy", "(Lorg/kodein/di/KodeinContainer$Builder;)Lorg/kodein/di/bindings/KodeinBinding;", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public interface Copier<C, A, T> {
        public static final Companion Companion = Companion.a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ^\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\t\"\u0004\b\u0006\u0010\u0002\"\u0004\b\u0007\u0010\u0003\"\b\b\b\u0010\u0004*\u00020\u00012$\u0010\b\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00070\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/bindings/KodeinBinding$Copier$Companion;", "", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lkotlin/Function1;", "Lorg/kodein/di/KodeinContainer$Builder;", "Lorg/kodein/di/bindings/KodeinBinding;", "f", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/bindings/KodeinBinding$Copier;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public static final /* synthetic */ Companion a = new Companion();

            @NotNull
            public final <C, A, T> Copier<C, A, T> invoke(@NotNull Function1<? super KodeinContainer.Builder, ? extends KodeinBinding<C, A, T>> function1) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                return new KodeinBinding$Copier$Companion$invoke$1(function1);
            }
        }

        @NotNull
        KodeinBinding<C, A, T> copy(@NotNull KodeinContainer.Builder builder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static <C, A, T> String factoryFullName(KodeinBinding<C, A, T> kodeinBinding) {
            return kodeinBinding.factoryName();
        }

        @Nullable
        public static <C, A, T> Copier<C, A, T> getCopier(KodeinBinding<C, A, T> kodeinBinding) {
            return null;
        }

        @NotNull
        public static <C, A, T> String getDescription(KodeinBinding<C, A, T> kodeinBinding) {
            String str;
            String str2 = "";
            if (!Intrinsics.areEqual(kodeinBinding.getArgType(), TypeTokenKt.getUnitToken())) {
                str = kodeinBinding.getArgType().simpleDispString() + " -> ";
            } else {
                str = str2;
            }
            Scope<C> scope = kodeinBinding.getScope() instanceof NoScope ? null : kodeinBinding.getScope();
            if (scope != null) {
                StringBuilder L = a.L("scoped(");
                L.append(TypesKt.TTOf(scope).simpleDispString());
                L.append(").");
                String sb = L.toString();
                if (sb != null) {
                    str2 = sb;
                    StringBuilder L2 = a.L(str2);
                    L2.append(kodeinBinding.factoryName());
                    L2.append(" { ");
                    L2.append(str);
                    L2.append(kodeinBinding.getCreatedType().simpleDispString());
                    L2.append(" }");
                    return L2.toString();
                }
            }
            if (!Intrinsics.areEqual(kodeinBinding.getContextType(), TypeTokenKt.getAnyToken())) {
                StringBuilder L3 = a.L("contexted<");
                L3.append(kodeinBinding.getContextType().simpleDispString());
                L3.append(">().");
                str2 = L3.toString();
            }
            StringBuilder L2 = a.L(str2);
            L2.append(kodeinBinding.factoryName());
            L2.append(" { ");
            L2.append(str);
            L2.append(kodeinBinding.getCreatedType().simpleDispString());
            L2.append(" }");
            return L2.toString();
        }

        @NotNull
        public static <C, A, T> String getFullDescription(KodeinBinding<C, A, T> kodeinBinding) {
            String str;
            String str2 = "";
            if (!Intrinsics.areEqual(kodeinBinding.getArgType(), TypeTokenKt.getUnitToken())) {
                str = kodeinBinding.getArgType().fullDispString() + " -> ";
            } else {
                str = str2;
            }
            Scope<C> scope = kodeinBinding.getScope() instanceof NoScope ? null : kodeinBinding.getScope();
            if (scope != null) {
                StringBuilder L = a.L("scoped(");
                L.append(TypesKt.TTOf(scope).fullDispString());
                L.append(").");
                String sb = L.toString();
                if (sb != null) {
                    str2 = sb;
                    StringBuilder L2 = a.L(str2);
                    L2.append(kodeinBinding.factoryFullName());
                    L2.append(" { ");
                    L2.append(str);
                    L2.append(kodeinBinding.getCreatedType().fullDispString());
                    L2.append(" }");
                    return L2.toString();
                }
            }
            if (!Intrinsics.areEqual(kodeinBinding.getContextType(), TypeTokenKt.getAnyToken())) {
                StringBuilder L3 = a.L("contexted<");
                L3.append(kodeinBinding.getContextType().fullDispString());
                L3.append(">().");
                str2 = L3.toString();
            }
            StringBuilder L2 = a.L(str2);
            L2.append(kodeinBinding.factoryFullName());
            L2.append(" { ");
            L2.append(str);
            L2.append(kodeinBinding.getCreatedType().fullDispString());
            L2.append(" }");
            return L2.toString();
        }

        @Nullable
        public static <C, A, T> Scope<C> getScope(KodeinBinding<C, A, T> kodeinBinding) {
            return null;
        }

        public static <C, A, T> boolean getSupportSubTypes(KodeinBinding<C, A, T> kodeinBinding) {
            return false;
        }
    }

    @NotNull
    String factoryFullName();

    @NotNull
    String factoryName();

    @NotNull
    TypeToken<? super A> getArgType();

    @NotNull
    TypeToken<? super C> getContextType();

    @Nullable
    Copier<C, A, T> getCopier();

    @NotNull
    TypeToken<? extends T> getCreatedType();

    @NotNull
    String getDescription();

    @NotNull
    String getFullDescription();

    @Nullable
    Scope<C> getScope();

    boolean getSupportSubTypes();
}
