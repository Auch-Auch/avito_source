package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentModule;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001'B\u0017\u0012\u0006\u0010$\u001a\u00020\u0001\u0012\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010#¨\u0006("}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$Element;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "R", SharingMapFragmentModule.INITIAL_STATE, "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "Lkotlin/coroutines/CoroutineContext$Element;", "element", "Lkotlin/coroutines/CoroutineContext;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext a;
    public final CoroutineContext.Element b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "", "Lkotlin/coroutines/CoroutineContext;", AuthSource.SEND_ABUSE, "[Lkotlin/coroutines/CoroutineContext;", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", MessengerShareContentUtility.ELEMENTS, "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        @NotNull
        public final CoroutineContext[] a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        static {
            new Companion(null);
        }

        public Serialized(@NotNull CoroutineContext[] coroutineContextArr) {
            Intrinsics.checkNotNullParameter(coroutineContextArr, MessengerShareContentUtility.ELEMENTS);
            this.a = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.a;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }
    }

    public static final class a extends Lambda implements Function2<String, CoroutineContext.Element, String> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public String invoke(String str, CoroutineContext.Element element) {
            String str2 = str;
            CoroutineContext.Element element2 = element;
            Intrinsics.checkNotNullParameter(str2, "acc");
            Intrinsics.checkNotNullParameter(element2, "element");
            if (str2.length() == 0) {
                return element2.toString();
            }
            return str2 + ", " + element2;
        }
    }

    public static final class b extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
        public final /* synthetic */ CoroutineContext[] a;
        public final /* synthetic */ Ref.IntRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
            super(2);
            this.a = coroutineContextArr;
            this.b = intRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Unit unit, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(element2, "element");
            CoroutineContext[] coroutineContextArr = this.a;
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            intRef.element = i + 1;
            coroutineContextArr[i] = element2;
            return Unit.INSTANCE;
        }
    }

    public CombinedContext(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(coroutineContext, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        Intrinsics.checkNotNullParameter(element, "element");
        this.a = coroutineContext;
        this.b = element;
    }

    private final Object writeReplace() {
        int a3 = a();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[a3];
        Ref.IntRef intRef = new Ref.IntRef();
        boolean z = false;
        intRef.element = 0;
        fold(Unit.INSTANCE, new b(coroutineContextArr, intRef));
        if (intRef.element == a3) {
            z = true;
        }
        if (z) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int a() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.a;
            if (!(coroutineContext instanceof CombinedContext)) {
                coroutineContext = null;
            }
            combinedContext = (CombinedContext) coroutineContext;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        boolean z;
        if (this != obj) {
            if (!(obj instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) obj;
            if (combinedContext.a() != a()) {
                return false;
            }
            Objects.requireNonNull(combinedContext);
            CombinedContext combinedContext2 = this;
            while (true) {
                CoroutineContext.Element element = combinedContext2.b;
                if (Intrinsics.areEqual(combinedContext.get(element.getKey()), element)) {
                    CoroutineContext coroutineContext = combinedContext2.a;
                    if (!(coroutineContext instanceof CombinedContext)) {
                        Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                        z = Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2);
                        break;
                    }
                    combinedContext2 = (CombinedContext) coroutineContext;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) function2.invoke((Object) this.a.fold(r, function2), this.b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.b.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.a;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.b.get(key) != null) {
            return this.a;
        }
        CoroutineContext minusKey = this.a.minusKey(key);
        if (minusKey == this.a) {
            return this;
        }
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return this.b;
        }
        return new CombinedContext(minusKey, this.b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a2.b.a.a.a.t(a2.b.a.a.a.L("["), (String) fold("", a.a), "]");
    }
}
