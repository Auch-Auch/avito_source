package com.avito.android.select;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/select/SelectedDialogRemoteInteractorImpl;", "Lcom/avito/android/select/SelectDialogInteractor;", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "filter", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/SearchApi;", "c", "Lcom/avito/android/remote/SearchApi;", "searchApi", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "allVariants", AuthSource.SEND_ABUSE, "Lcom/avito/android/select/SelectDialogInteractor;", "localInteractor", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "onQueryIsNotBlank", "", "d", "I", "attributeId", "<init>", "(Lcom/avito/android/select/SelectDialogInteractor;Ljava/util/List;Lcom/avito/android/remote/SearchApi;ILkotlin/jvm/functions/Function0;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectedDialogRemoteInteractorImpl implements SelectDialogInteractor {
    public final SelectDialogInteractor a;
    public final List<ParcelableEntity<String>> b;
    public final SearchApi c;
    public final int d;
    public final Function0<Unit> e;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends List<? extends ParcelableEntity<String>>>> {
        public final /* synthetic */ SelectedDialogRemoteInteractorImpl a;
        public final /* synthetic */ String b;

        public a(SelectedDialogRemoteInteractorImpl selectedDialogRemoteInteractorImpl, String str) {
            this.a = selectedDialogRemoteInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends List<? extends ParcelableEntity<String>>> apply(Throwable th) {
            return this.a.a.filter(this.b);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectedDialogRemoteInteractorImpl(@NotNull SelectDialogInteractor selectDialogInteractor, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull SearchApi searchApi, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(selectDialogInteractor, "localInteractor");
        Intrinsics.checkNotNullParameter(list, "allVariants");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(function0, "onQueryIsNotBlank");
        this.a = selectDialogInteractor;
        this.b = list;
        this.c = searchApi;
        this.d = i;
        this.e = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [a2.a.a.m2.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [a2.a.a.m2.a] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.avito.android.select.SelectDialogInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<java.util.List<com.avito.android.remote.model.ParcelableEntity<java.lang.String>>> filter(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = t6.y.m.isBlank(r4)
            if (r0 == 0) goto L_0x0017
            java.util.List<com.avito.android.remote.model.ParcelableEntity<java.lang.String>> r4 = r3.b
            io.reactivex.rxjava3.core.Observable r4 = io.reactivex.rxjava3.core.Observable.just(r4)
            java.lang.String r0 = "Observable.just(allVariants)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        L_0x0017:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r3.e
            r0.invoke()
            com.avito.android.remote.SearchApi r0 = r3.c
            int r1 = r3.d
            java.lang.String r2 = "search-freq"
            io.reactivex.rxjava3.core.Observable r0 = r0.getAutoSearchSuggest(r4, r1, r2)
            kotlin.reflect.KProperty1 r1 = a2.a.a.m2.j.a
            if (r1 == 0) goto L_0x0030
            a2.a.a.m2.a r2 = new a2.a.a.m2.a
            r2.<init>(r1)
            r1 = r2
        L_0x0030:
            io.reactivex.rxjava3.functions.Function r1 = (io.reactivex.rxjava3.functions.Function) r1
            io.reactivex.rxjava3.core.Observable r0 = r0.map(r1)
            kotlin.reflect.KProperty1 r1 = a2.a.a.m2.k.a
            if (r1 == 0) goto L_0x0040
            a2.a.a.m2.a r2 = new a2.a.a.m2.a
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            io.reactivex.rxjava3.functions.Function r1 = (io.reactivex.rxjava3.functions.Function) r1
            io.reactivex.rxjava3.core.Observable r0 = r0.map(r1)
            java.lang.String r1 = "searchApi.getAutoSearchS…AutoSuggestResult::items)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.select.SelectedDialogRemoteInteractorImpl$a r1 = new com.avito.android.select.SelectedDialogRemoteInteractorImpl$a
            r1.<init>(r3, r4)
            io.reactivex.rxjava3.core.Observable r4 = r0.onErrorResumeNext(r1)
            java.lang.String r0 = "remote.onErrorResumeNext…nteractor.filter(query) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.select.SelectedDialogRemoteInteractorImpl.filter(java.lang.String):io.reactivex.rxjava3.core.Observable");
    }
}
