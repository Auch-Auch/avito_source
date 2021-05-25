package a2.a.a.q0;

import androidx.lifecycle.Observer;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import com.avito.android.extended_profile.ExtendedProfileViewSingleLiveEvent;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
public final class h<T> implements Observer<ExtendedProfileViewSingleLiveEvent> {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public h(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ExtendedProfileViewSingleLiveEvent extendedProfileViewSingleLiveEvent) {
        ExtendedProfileViewSingleLiveEvent extendedProfileViewSingleLiveEvent2 = extendedProfileViewSingleLiveEvent;
        if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.AdvertDetailsOpenEvent) {
            this.a.w.openAdvertDetails((ExtendedProfileViewSingleLiveEvent.AdvertDetailsOpenEvent) extendedProfileViewSingleLiveEvent2);
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.GalleryOpenEvent) {
            ExtendedProfileViewSingleLiveEvent.GalleryOpenEvent galleryOpenEvent = (ExtendedProfileViewSingleLiveEvent.GalleryOpenEvent) extendedProfileViewSingleLiveEvent2;
            this.a.w.openFullScreenGallery(galleryOpenEvent.getImages(), galleryOpenEvent.getPosition());
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.DeepLinkEvent) {
            this.a.w.followDeepLink(((ExtendedProfileViewSingleLiveEvent.DeepLinkEvent) extendedProfileViewSingleLiveEvent2).getDeepLink());
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.ShowSnackbarEvent) {
            CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.a.y, ((ExtendedProfileViewSingleLiveEvent.ShowSnackbarEvent) extendedProfileViewSingleLiveEvent2).getMessage(), 0, null, 0, null, 0, null, null, 254, null);
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.BackClickedEvent) {
            this.a.w.leaveScreen();
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.ShareClickEvent) {
            ExtendedProfileViewSingleLiveEvent.ShareClickEvent shareClickEvent = (ExtendedProfileViewSingleLiveEvent.ShareClickEvent) extendedProfileViewSingleLiveEvent2;
            this.a.w.openShareDialog(shareClickEvent.getTitle(), shareClickEvent.getText());
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.CallEvent) {
            this.a.w.call(((ExtendedProfileViewSingleLiveEvent.CallEvent) extendedProfileViewSingleLiveEvent2).getDeepLink());
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.AuthEvent) {
            ExtendedProfileViewSingleLiveEvent.AuthEvent authEvent = (ExtendedProfileViewSingleLiveEvent.AuthEvent) extendedProfileViewSingleLiveEvent2;
            this.a.w.openAuthScreen(authEvent.getSource(), authEvent.getSuccessAuthData());
        } else if (extendedProfileViewSingleLiveEvent2 instanceof ExtendedProfileViewSingleLiveEvent.ShareMenuVisibleEvent) {
            this.a.a().setVisible(((ExtendedProfileViewSingleLiveEvent.ShareMenuVisibleEvent) extendedProfileViewSingleLiveEvent2).isVisible());
        }
    }
}
