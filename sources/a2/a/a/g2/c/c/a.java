package a2.a.a.g2.c.c;

import com.avito.android.rating.review_details.upload.ReplyUploadPresenterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyState;
import com.avito.android.ratings.ReviewData;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ ReplyUploadPresenterImpl a;
    public final /* synthetic */ ReviewData b;

    public a(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewData reviewData) {
        this.a = replyUploadPresenterImpl;
        this.b = reviewData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        ReplyUploadPresenterImpl.access$sendState(this.a, new ReviewReplyState.Loading(this.b));
    }
}
