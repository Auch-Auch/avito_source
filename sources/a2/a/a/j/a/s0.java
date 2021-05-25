package a2.a.a.j.a;

import arrow.core.Option;
import com.avito.android.app.task.PublishDraftsSyncTask;
import com.avito.android.photo_picker.UploadingState;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class s0<T, R> implements Function<Option<? extends String>, ObservableSource<? extends UploadingState>> {
    public final /* synthetic */ PublishDraftsSyncTask a;

    public s0(PublishDraftsSyncTask publishDraftsSyncTask) {
        this.a = publishDraftsSyncTask;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends UploadingState> apply(Option<? extends String> option) {
        Option<? extends String> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "optionalDraft");
        String str = (String) option2.orNull();
        if (str != null) {
            return ((UploadingProgressInteractor) this.a.uploadingProgressProvider.invoke(str)).getUploadProgressObservable().filter(r0.a);
        }
        return Observable.empty();
    }
}
