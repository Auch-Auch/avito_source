package a2.a.a.y1;

import android.view.View;
import com.avito.android.design.widget.PhotoImageView;
import com.avito.android.photo_view.ImageData;
import com.avito.android.photo_view.LegacyImageViewHolder;
public final class d implements View.OnClickListener {
    public final /* synthetic */ LegacyImageViewHolder a;
    public final /* synthetic */ PhotoImageView b;
    public final /* synthetic */ ImageData c;

    public d(LegacyImageViewHolder legacyImageViewHolder, PhotoImageView photoImageView, ImageData imageData) {
        this.a = legacyImageViewHolder;
        this.b = photoImageView;
        this.c = imageData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageData.State state = this.c.getState();
        if (state instanceof ImageData.State.Error) {
            ImageData.State state2 = this.c.getState();
            if (!(state2 instanceof ImageData.State.Error)) {
                state2 = null;
            }
            ImageData.State.Error error = (ImageData.State.Error) state2;
            if (error != null) {
                this.b.showErrorActionsOverlay(error.isRestorable());
            }
        } else if (state instanceof ImageData.State.Loading) {
            this.b.showRemoveOverlay();
        } else {
            this.a.getPresenter().showPhotoPicker(this.c.getId());
        }
    }
}
