package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerActivity;
import com.avito.android.photo_picker.legacy.PhotoSource;
import java.util.List;
public final class a implements Runnable {
    public final /* synthetic */ PhotoPickerActivity a;
    public final /* synthetic */ List b;

    public a(PhotoPickerActivity photoPickerActivity, List list) {
        this.a = photoPickerActivity;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getPresenter().onNewPhotos(this.b, PhotoSource.GALLERY);
    }
}
