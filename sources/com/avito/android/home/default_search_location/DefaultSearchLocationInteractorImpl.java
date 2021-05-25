package com.avito.android.home.default_search_location;

import android.app.Activity;
import android.location.Location;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractorImpl;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "defaultLocation", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "c", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "findDetectLocationPresenter", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroid/app/Activity;", AuthSource.BOOKING_ORDER, "Landroid/app/Activity;", "activity", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Landroid/app/Activity;Lcom/avito/android/location/find/FindDetectLocationPresenter;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultSearchLocationInteractorImpl implements DefaultSearchLocationInteractor {
    public final SchedulersFactory3 a;
    public final Activity b;
    public final FindDetectLocationPresenter c;

    public DefaultSearchLocationInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull Activity activity, @NotNull FindDetectLocationPresenter findDetectLocationPresenter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(findDetectLocationPresenter, "findDetectLocationPresenter");
        this.a = schedulersFactory3;
        this.b = activity;
        this.c = findDetectLocationPresenter;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationInteractor
    @NotNull
    public Single<Location> defaultLocation() {
        Single<Location> singleOrError = FindLocationPresenter.DefaultImpls.findLocation$default(this.c, this.b, false, 2, null).observeOn(this.a.io()).singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError, "findDetectLocationPresen…         .singleOrError()");
        return singleOrError;
    }
}
