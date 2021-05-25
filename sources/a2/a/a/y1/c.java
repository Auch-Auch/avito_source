package a2.a.a.y1;

import android.view.View;
import com.avito.android.photo_view.ImageData;
import com.avito.android.photo_view.LegacyImageViewHolder;
public final class c implements View.OnClickListener {
    public final /* synthetic */ LegacyImageViewHolder a;
    public final /* synthetic */ ImageData b;

    public c(LegacyImageViewHolder legacyImageViewHolder, ImageData imageData) {
        this.a = legacyImageViewHolder;
        this.b = imageData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getPresenter().showPhotoPicker(this.b.getId());
    }
}
