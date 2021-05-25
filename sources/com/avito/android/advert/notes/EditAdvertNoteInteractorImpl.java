package com.avito.android.advert.notes;

import a2.a.a.f.y.a;
import a2.a.a.f.y.b;
import a2.a.a.f.y.c;
import a2.a.a.f.y.d;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/notes/EditAdvertNoteInteractorImpl;", "Lcom/avito/android/advert/notes/EditAdvertNoteInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, VKAttachments.TYPE_NOTE, "", "isNew", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/advert/notes/UpdateAdvertNoteResult;", "updateNote", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertNoteInteractorImpl implements EditAdvertNoteInteractor {
    public final AdvertDetailsApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;

    @Inject
    public EditAdvertNoteInteractorImpl(@NotNull AdvertDetailsApi advertDetailsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = advertDetailsApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.advert.notes.EditAdvertNoteInteractor
    @NotNull
    public Observable<LoadingState<UpdateAdvertNoteResult>> updateNote(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, VKAttachments.TYPE_NOTE);
        if (z) {
            Observable<LoadingState<UpdateAdvertNoteResult>> startWith = TypedObservablesKt.toTyped(this.a.createNote(str, str2)).map(a.a).onErrorReturn(new b(this)).subscribeOn(this.b.io()).startWith(Observable.just(LoadingState.Loading.INSTANCE));
            Intrinsics.checkNotNullExpressionValue(startWith, "api.createNote(advertId,…st(LoadingState.Loading))");
            return startWith;
        }
        Observable<LoadingState<UpdateAdvertNoteResult>> startWith2 = TypedObservablesKt.toTyped(this.a.updateNote(str, str2)).map(c.a).onErrorReturn(new d(this)).subscribeOn(this.b.io()).startWith(Observable.just(LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith2, "api.updateNote(advertId,…st(LoadingState.Loading))");
        return startWith2;
    }
}
