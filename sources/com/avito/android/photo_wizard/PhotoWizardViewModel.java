package com.avito.android.photo_wizard;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "", "Lcom/avito/android/photo_wizard/DocumentType;", "type", "", "onTypeClicked", "(Lcom/avito/android/photo_wizard/DocumentType;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "onPictureTaken", "(Landroid/net/Uri;)V", "onNextClicked", "()V", "onDoneClicked", "onCloseClicked", "onRetakeShotClicked", "Landroidx/lifecycle/LiveData;", "", "getTitleData", "()Landroidx/lifecycle/LiveData;", "titleData", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "getViewStateData", "viewStateData", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoWizardViewModel {
    @NotNull
    LiveData<String> getTitleData();

    @NotNull
    LiveData<PhotoWizardViewState> getViewStateData();

    void onCloseClicked();

    void onDoneClicked();

    void onNextClicked();

    void onPictureTaken(@NotNull Uri uri);

    void onRetakeShotClicked();

    void onTypeClicked(@NotNull DocumentType documentType);
}
