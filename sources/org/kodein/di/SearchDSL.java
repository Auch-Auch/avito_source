package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00032\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/SearchDSL;", "", "Lorg/kodein/di/SearchSpecs;", "Lorg/kodein/di/SearchDSL$Spec;", "spec", "with", "(Lorg/kodein/di/SearchSpecs;Lorg/kodein/di/SearchDSL$Spec;)Lorg/kodein/di/SearchSpecs;", "and", "Lorg/kodein/di/TypeToken;", "contextType", "Context", "(Lorg/kodein/di/TypeToken;)Lorg/kodein/di/SearchDSL$Spec;", "argumentType", "Argument", "tag", "(Ljava/lang/Object;)Lorg/kodein/di/SearchDSL$Spec;", "<init>", "()V", "Binding", "Spec", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class SearchDSL {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lorg/kodein/di/SearchDSL$Binding;", "Lorg/kodein/di/SearchDSL$Spec;", "Lorg/kodein/di/SearchSpecs;", "specs", "", "apply", "(Lorg/kodein/di/SearchSpecs;)V", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getType", "()Lorg/kodein/di/TypeToken;", "type", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "tag", "<init>", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Binding implements Spec {
        @NotNull
        public final TypeToken<?> a;
        @Nullable
        public final Object b;

        public Binding(@NotNull TypeToken<?> typeToken, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            this.a = typeToken;
            this.b = obj;
        }

        @Override // org.kodein.di.SearchDSL.Spec
        public void apply(@NotNull SearchSpecs searchSpecs) {
            Intrinsics.checkParameterIsNotNull(searchSpecs, "specs");
            searchSpecs.setType(this.a);
            Object obj = this.b;
            if (obj != null) {
                searchSpecs.setTag(obj);
            }
        }

        @Nullable
        public final Object getTag() {
            return this.b;
        }

        @NotNull
        public final TypeToken<?> getType() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Binding(TypeToken typeToken, Object obj, int i, j jVar) {
            this(typeToken, (i & 2) != 0 ? null : obj);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lorg/kodein/di/SearchDSL$Spec;", "", "Lorg/kodein/di/SearchSpecs;", "specs", "", "apply", "(Lorg/kodein/di/SearchSpecs;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public interface Spec {
        public static final Companion Companion = Companion.a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\n\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lorg/kodein/di/SearchDSL$Spec$Companion;", "", "Lkotlin/Function1;", "Lorg/kodein/di/SearchSpecs;", "", "Lkotlin/ExtensionFunctionType;", "f", "Lorg/kodein/di/SearchDSL$Spec;", "invoke$kodein_di_core", "(Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/SearchDSL$Spec;", "invoke", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public static final /* synthetic */ Companion a = new Companion();

            @NotNull
            public final Spec invoke$kodein_di_core(@NotNull Function1<? super SearchSpecs, Unit> function1) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                return new SearchDSL$Spec$Companion$invoke$1(function1);
            }
        }

        void apply(@NotNull SearchSpecs searchSpecs);
    }

    public static final class a extends Lambda implements Function1<SearchSpecs, Unit> {
        public final /* synthetic */ TypeToken a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TypeToken typeToken) {
            super(1);
            this.a = typeToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SearchSpecs searchSpecs) {
            SearchSpecs searchSpecs2 = searchSpecs;
            Intrinsics.checkParameterIsNotNull(searchSpecs2, "$receiver");
            searchSpecs2.setArgType(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<SearchSpecs, Unit> {
        public final /* synthetic */ TypeToken a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TypeToken typeToken) {
            super(1);
            this.a = typeToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SearchSpecs searchSpecs) {
            SearchSpecs searchSpecs2 = searchSpecs;
            Intrinsics.checkParameterIsNotNull(searchSpecs2, "$receiver");
            searchSpecs2.setContextType(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<SearchSpecs, Unit> {
        public final /* synthetic */ Object a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Object obj) {
            super(1);
            this.a = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SearchSpecs searchSpecs) {
            SearchSpecs searchSpecs2 = searchSpecs;
            Intrinsics.checkParameterIsNotNull(searchSpecs2, "$receiver");
            searchSpecs2.setTag(this.a);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final Spec Argument(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argumentType");
        return Spec.Companion.invoke$kodein_di_core(new a(typeToken));
    }

    @NotNull
    public final Spec Context(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        return Spec.Companion.invoke$kodein_di_core(new b(typeToken));
    }

    @NotNull
    public final SearchSpecs and(@NotNull SearchSpecs searchSpecs, @NotNull Spec spec) {
        Intrinsics.checkParameterIsNotNull(searchSpecs, "$this$and");
        Intrinsics.checkParameterIsNotNull(spec, "spec");
        spec.apply(searchSpecs);
        return searchSpecs;
    }

    @NotNull
    public final Spec tag(@Nullable Object obj) {
        return Spec.Companion.invoke$kodein_di_core(new c(obj));
    }

    @NotNull
    public final SearchSpecs with(@NotNull SearchSpecs searchSpecs, @NotNull Spec spec) {
        Intrinsics.checkParameterIsNotNull(searchSpecs, "$this$with");
        Intrinsics.checkParameterIsNotNull(spec, "spec");
        spec.apply(searchSpecs);
        return searchSpecs;
    }
}
