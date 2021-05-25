package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.concurrent.CountDownLatch;
public final class l implements OnSuccessListener, OnFailureListener {
    public final CountDownLatch a = new CountDownLatch(1);

    public /* synthetic */ l(byte[] bArr) {
    }

    @Override // com.google.android.play.core.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.a.countDown();
    }

    @Override // com.google.android.play.core.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
