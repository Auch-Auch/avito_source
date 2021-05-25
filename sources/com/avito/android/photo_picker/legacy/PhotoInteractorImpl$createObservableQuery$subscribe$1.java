package com.avito.android.photo_picker.legacy;

import android.net.Uri;
import com.avito.android.db.SqlQuery;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class PhotoInteractorImpl$createObservableQuery$subscribe$1<T> implements FlowableOnSubscribe<SqlQuery> {
    public final /* synthetic */ PhotoInteractorImpl a;
    public final /* synthetic */ SqlQuery b;
    public final /* synthetic */ Uri c;

    public static final class a implements Action {
        public final /* synthetic */ PhotoInteractorImpl$createObservableQuery$subscribe$1 a;
        public final /* synthetic */ PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1 b;

        public a(PhotoInteractorImpl$createObservableQuery$subscribe$1 photoInteractorImpl$createObservableQuery$subscribe$1, PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1 photoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1) {
            this.a = photoInteractorImpl$createObservableQuery$subscribe$1;
            this.b = photoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.a.d.unregisterContentObserver(this.b);
        }
    }

    public PhotoInteractorImpl$createObservableQuery$subscribe$1(PhotoInteractorImpl photoInteractorImpl, SqlQuery sqlQuery, Uri uri) {
        this.a = photoInteractorImpl;
        this.b = sqlQuery;
        this.c = uri;
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(@NotNull FlowableEmitter<SqlQuery> flowableEmitter) {
        Intrinsics.checkNotNullParameter(flowableEmitter, "emitter");
        PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1 photoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1 = new PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1(this, flowableEmitter, this.a.a);
        this.a.d.registerContentObserver(this.c, true, photoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1);
        ((FlowableCreate.a) flowableEmitter).b.update(Disposables.fromAction(new a(this, photoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1)));
        flowableEmitter.onNext(this.b);
    }
}
