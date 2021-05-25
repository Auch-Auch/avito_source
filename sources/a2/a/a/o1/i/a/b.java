package a2.a.a.o1.i.a;

import android.os.Handler;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b<T> {
    public int a;
    public final Handler b = new Handler();
    public final Runnable c = new a(this);
    public final List<T> d;
    public final Function1<T, Unit> e;
    public final long f;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = this.a;
            List<T> list = bVar.d;
            bVar.e.invoke(list.get(bVar.a % list.size()));
            b bVar2 = this.a;
            bVar2.a++;
            bVar2.b.postDelayed(bVar2.c, bVar2.f);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1, long j) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function1, "setValue");
        this.d = list;
        this.e = function1;
        this.f = j;
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("No values to animate".toString());
        }
    }
}
