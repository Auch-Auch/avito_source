package com.avito.android.abuse.details;

import com.avito.android.abuse.details.adapter.AbuseField;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "", "", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "fields", "Lio/reactivex/rxjava3/core/Observable;", "sendAbuse", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", "verifyAbuse", "getFields", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/Single;", "", "isAuthorized", "()Lio/reactivex/Single;", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseDetailsInteractor {
    @NotNull
    Observable<List<AbuseField>> getFields();

    @NotNull
    Single<Boolean> isAuthorized();

    @NotNull
    Observable<List<AbuseField>> sendAbuse(@NotNull List<? extends AbuseField> list);

    @NotNull
    Observable<Unit> verifyAbuse(@NotNull List<? extends AbuseField> list);
}
