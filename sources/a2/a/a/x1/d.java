package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerActivity;
import java.util.List;
public final class d implements Runnable {
    public final /* synthetic */ PhotoPickerActivity a;
    public final /* synthetic */ List b;

    public d(PhotoPickerActivity photoPickerActivity, List list) {
        this.a = photoPickerActivity;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getPresenter().onNewPhotos(this.b);
    }
}
