package com.avito.android.select;

import a2.a.a.m2.h;
import a2.a.a.m2.i;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/select/SelectedDialogLocalInteractorImpl;", "Lcom/avito/android/select/SelectDialogInteractor;", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "filter", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "onQueryIsNotBlank", AuthSource.SEND_ABUSE, "Ljava/util/List;", "allVariants", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectedDialogLocalInteractorImpl implements SelectDialogInteractor {
    public final List<ParcelableEntity<String>> a;
    public final Function0<Unit> b;

    public static final class a<V> implements Callable<List<? extends ParcelableEntity<String>>> {
        public final /* synthetic */ SelectedDialogLocalInteractorImpl a;
        public final /* synthetic */ String b;

        public a(SelectedDialogLocalInteractorImpl selectedDialogLocalInteractorImpl, String str) {
            this.a = selectedDialogLocalInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends ParcelableEntity<String>> call() {
            if (m.isBlank(this.b)) {
                return this.a.a;
            }
            Function0 function0 = this.a.b;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.distinct(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filterNot(CollectionsKt___CollectionsKt.asSequence(this.a.a), h.a), new i(SelectDialogInteractorKt.a(this.b)))));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectedDialogLocalInteractorImpl(@NotNull List<? extends ParcelableEntity<String>> list, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "allVariants");
        this.a = list;
        this.b = function0;
    }

    @Override // com.avito.android.select.SelectDialogInteractor
    @NotNull
    public Observable<List<ParcelableEntity<String>>> filter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Observable<List<ParcelableEntity<String>>> fromCallable = Observable.fromCallable(new a(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable ….toList()\n        }\n    }");
        return fromCallable;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectedDialogLocalInteractorImpl(List list, Function0 function0, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : function0);
    }
}
