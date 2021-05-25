package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", ExifInterface.LONGITUDE_EAST, "", "element", "plus-UZ7vuAc", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "Lkotlin/Function1;", "", "action", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachReversed", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class InlineList<E> {
    public final Object a;

    public /* synthetic */ InlineList(@Nullable Object obj) {
        this.a = obj;
    }

    @NotNull
    /* renamed from: box-impl */
    public static final /* synthetic */ InlineList m519boximpl(@Nullable Object obj) {
        return new InlineList(obj);
    }

    @NotNull
    /* renamed from: constructor-impl */
    public static Object m520constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ Object m521constructorimpl$default(Object obj, int i, j jVar) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m520constructorimpl(obj);
    }

    /* renamed from: equals-impl */
    public static boolean m522equalsimpl(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).m528unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m523equalsimpl0(@Nullable Object obj, @Nullable Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: forEachReversed-impl */
    public static final void m524forEachReversedimpl(Object obj, @NotNull Function1<? super E, Unit> function1) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                function1.invoke(obj);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                function1.invoke((Object) arrayList.get(size));
            }
        }
    }

    /* renamed from: hashCode-impl */
    public static int m525hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NotNull
    /* renamed from: plus-UZ7vuAc */
    public static final Object m526plusUZ7vuAc(Object obj, E e) {
        if (obj == null) {
            return m520constructorimpl(e);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return m520constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return m520constructorimpl(arrayList);
    }

    @NotNull
    /* renamed from: toString-impl */
    public static String m527toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m522equalsimpl(this.a, obj);
    }

    public int hashCode() {
        return m525hashCodeimpl(this.a);
    }

    public String toString() {
        return m527toStringimpl(this.a);
    }

    @Nullable
    /* renamed from: unbox-impl */
    public final /* synthetic */ Object m528unboximpl() {
        return this.a;
    }
}
