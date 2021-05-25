package com.avito.android.photo_picker.legacy;

import android.database.ContentObserver;
import android.os.Handler;
import io.reactivex.FlowableEmitter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/photo_picker/legacy/PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1", "Landroid/database/ContentObserver;", "", "selfChange", "", "onChange", "(Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1 extends ContentObserver {
    public final /* synthetic */ PhotoInteractorImpl$createObservableQuery$subscribe$1 a;
    public final /* synthetic */ FlowableEmitter b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoInteractorImpl$createObservableQuery$subscribe$1$contentObserver$1(PhotoInteractorImpl$createObservableQuery$subscribe$1 photoInteractorImpl$createObservableQuery$subscribe$1, FlowableEmitter flowableEmitter, Handler handler) {
        super(handler);
        this.a = photoInteractorImpl$createObservableQuery$subscribe$1;
        this.b = flowableEmitter;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.b.onNext(this.a.b);
    }
}
