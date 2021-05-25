package com.avito.android.photo_picker.legacy;

import androidx.annotation.DimenRes;
import com.avito.android.PublishIntentFactory;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002)*J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H&¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0014H&¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H&¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerView;", "", "", "onThumbnailsListChanged", "()V", "", VKApiConst.POSITION, "count", "onDetailsListRangeChanged", "(II)V", "onDetailsListItemChanged", "(I)V", "onDetailsListChanged", "itemPos", "ensureThumbnailIsVisible", "scrollDetailsListToPosition", "Lcom/avito/android/util/Rotation;", "rotation", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "", "isVisible", "setThumbnailsListVisibility", "(Z)V", "visible", "setContinueButtonVisibility", "enabled", "setContinueButtonEnabled", "progress", "setContinueButtonProgress", "", "error", "showWarning", "(Ljava/lang/String;)V", "showError", "Lio/reactivex/Observable;", "continueClicks", "()Lio/reactivex/Observable;", "showProgress", "hideProgress", "onDetach", "PhotoPickerLayoutConfig", "Presenter", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;", "", "", AuthSource.SEND_ABUSE, "I", "getThumbnailsListHeight", "()I", "thumbnailsListHeight", "<init>", "(Ljava/lang/String;II)V", "CONTINUE_BTN_APPBAR", "CONTINUE_BTN_FOOTER", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public enum PhotoPickerLayoutConfig {
        CONTINUE_BTN_APPBAR(R.dimen.thumnails_list_height),
        CONTINUE_BTN_FOOTER(R.dimen.thumbnail_list_with_controls_height);
        
        public final int a;

        /* access modifiers changed from: public */
        PhotoPickerLayoutConfig(@DimenRes int i) {
            this.a = i;
        }

        public final int getThumbnailsListHeight() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerView$Presenter;", "Lcom/avito/android/photo_picker/legacy/PhotoMover;", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "getMode", "()Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "", "onCancelClicked", "()V", "removeSelectedPhoto", "editSelectedPhoto", "", VKApiConst.POSITION, "onDetailsListScrolled", "(I)V", "onDetailsListScrollFinished", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter extends PhotoMover {
        void editSelectedPhoto();

        @NotNull
        PublishIntentFactory.PhotoPickerMode getMode();

        void onCancelClicked();

        void onDetailsListScrollFinished(int i);

        void onDetailsListScrolled(int i);

        void removeSelectedPhoto();
    }

    @NotNull
    Observable<Unit> continueClicks();

    void ensureThumbnailIsVisible(int i);

    void hideProgress();

    void onDetach();

    void onDetailsListChanged();

    void onDetailsListItemChanged(int i);

    void onDetailsListRangeChanged(int i, int i2);

    void onThumbnailsListChanged();

    void rotateUi(@NotNull Rotation rotation);

    void scrollDetailsListToPosition(int i);

    void setContinueButtonEnabled(boolean z);

    void setContinueButtonProgress(boolean z);

    void setContinueButtonVisibility(boolean z);

    void setThumbnailsListVisibility(boolean z);

    void showError(@NotNull String str);

    void showProgress();

    void showWarning(@NotNull String str);
}
