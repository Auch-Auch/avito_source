package com.avito.android.select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.google.android.gms.common.internal.ImagesContract;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/select/SelectDialogLocalWithDelayInteractorImpl;", "Lcom/avito/android/select/SelectDialogInteractor;", "", "query", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "filter", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/select/SelectDialogInteractor;", ImagesContract.LOCAL, AuthSource.BOOKING_ORDER, "remote", "<init>", "(Lcom/avito/android/select/SelectDialogInteractor;Lcom/avito/android/select/SelectDialogInteractor;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogLocalWithDelayInteractorImpl implements SelectDialogInteractor {
    public final SelectDialogInteractor a;
    public final SelectDialogInteractor b;

    public static final class a<T1, T2, R> implements BiFunction<List<? extends ParcelableEntity<String>>, List<? extends ParcelableEntity<String>>, List<? extends ParcelableEntity<String>>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public List<? extends ParcelableEntity<String>> apply(List<? extends ParcelableEntity<String>> list, List<? extends ParcelableEntity<String>> list2) {
            return list2;
        }
    }

    public SelectDialogLocalWithDelayInteractorImpl(@NotNull SelectDialogInteractor selectDialogInteractor, @NotNull SelectDialogInteractor selectDialogInteractor2) {
        Intrinsics.checkNotNullParameter(selectDialogInteractor, ImagesContract.LOCAL);
        Intrinsics.checkNotNullParameter(selectDialogInteractor2, "remote");
        this.a = selectDialogInteractor;
        this.b = selectDialogInteractor2;
    }

    @Override // com.avito.android.select.SelectDialogInteractor
    @NotNull
    public Observable<List<ParcelableEntity<String>>> filter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Observable<List<ParcelableEntity<String>>> zip = Observable.zip(this.b.filter(str), this.a.filter(str), a.a);
        Intrinsics.checkNotNullExpressionValue(zip, "Observable.zip(\n        …lResult -> localResult })");
        return zip;
    }
}
