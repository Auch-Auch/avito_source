package kotlinx.coroutines.selects;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000f\u001a\u00020\u0005*\u00020\u000b2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\b0\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00010\u00122\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0014J[\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0011*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0018J8\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\b0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R5\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$`%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "e", "", "handleBuilderException", "(Ljava/lang/Throwable;)V", "", "initSelectResult", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "getInstance", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;", "instance", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", AuthSource.BOOKING_ORDER, "Ljava/util/ArrayList;", "getClauses", "()Ljava/util/ArrayList;", "clauses", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public final class UnbiasedSelectBuilderImpl<R> implements SelectBuilder<R> {
    @NotNull
    public final SelectBuilderImpl<R> a;
    @NotNull
    public final ArrayList<Function0<Unit>> b = new ArrayList<>();

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnbiasedSelectBuilderImpl a;
        public final /* synthetic */ SelectClause0 b;
        public final /* synthetic */ Function1 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, SelectClause0 selectClause0, Function1 function1) {
            super(0);
            this.a = unbiasedSelectBuilderImpl;
            this.b = selectClause0;
            this.c = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.registerSelectClause0(this.a.getInstance(), this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnbiasedSelectBuilderImpl a;
        public final /* synthetic */ SelectClause1 b;
        public final /* synthetic */ Function2 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, SelectClause1 selectClause1, Function2 function2) {
            super(0);
            this.a = unbiasedSelectBuilderImpl;
            this.b = selectClause1;
            this.c = function2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.registerSelectClause1(this.a.getInstance(), this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnbiasedSelectBuilderImpl a;
        public final /* synthetic */ SelectClause2 b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Function2 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, SelectClause2 selectClause2, Object obj, Function2 function2) {
            super(0);
            this.a = unbiasedSelectBuilderImpl;
            this.b = selectClause2;
            this.c = obj;
            this.d = function2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.registerSelectClause2(this.a.getInstance(), this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnbiasedSelectBuilderImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function1 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, long j, Function1 function1) {
            super(0);
            this.a = unbiasedSelectBuilderImpl;
            this.b = j;
            this.c = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getInstance().onTimeout(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public UnbiasedSelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        this.a = new SelectBuilderImpl<>(continuation);
    }

    @NotNull
    public final ArrayList<Function0<Unit>> getClauses() {
        return this.b;
    }

    @NotNull
    public final SelectBuilderImpl<R> getInstance() {
        return this.a;
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable th) {
        this.a.handleBuilderException(th);
    }

    @PublishedApi
    @Nullable
    public final Object initSelectResult() {
        if (!this.a.isSelected()) {
            try {
                Collections.shuffle(this.b);
                Iterator<T> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().invoke();
                }
            } catch (Throwable th) {
                this.a.handleBuilderException(th);
            }
        }
        return this.a.getResult();
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.b.add(new d(this, j, function1));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.b.add(new a(this, selectClause0, function1));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.b.add(new b(this, selectClause1, function2));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.b.add(new c(this, selectClause2, p, function2));
    }
}
