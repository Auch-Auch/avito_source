package a2.a.a.w1;

import android.view.View;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity;
public final class a implements View.OnClickListener {
    public final /* synthetic */ LegacyPhotoGalleryActivity a;

    public a(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        this.a = legacyPhotoGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
