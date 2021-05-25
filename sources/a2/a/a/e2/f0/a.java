package a2.a.a.e2.f0;

import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.publish.sts_scanner.StsScannerFragment;
import java.util.List;
public final class a implements Runnable {
    public final /* synthetic */ StsScannerFragment a;
    public final /* synthetic */ List b;

    public a(StsScannerFragment stsScannerFragment, List list) {
        this.a = stsScannerFragment;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getPresenter().onNewPhotos(this.b, PhotoSource.GALLERY);
    }
}
