package com.avito.android.rating.publish.deal_proofs;

import com.avito.android.photo_view.ImageListView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;", "Lcom/avito/android/photo_view/ImageListView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "isEmptyList", "setContentMode", "(Z)V", "addPhotoClicks", "infoClicks", "buttonClicks", "isEnabled", "setButtonEnabled", "showContinueButton", "()V", "showContinueNoPhotosButton", "showSendButton", "showSendNoPhotosButton", "setUploadImagesTexts", "setDealProofsTexts", "setAutoDealProofsTexts", "isLoading", "showLoadingState", "isVisible", "showInfoLinkVisible", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface DealProofsView extends ImageListView {
    @NotNull
    Observable<Unit> addPhotoClicks();

    @NotNull
    Observable<Unit> buttonClicks();

    @NotNull
    Observable<Unit> infoClicks();

    @NotNull
    Observable<Unit> navigationClicks();

    void setAutoDealProofsTexts();

    void setButtonEnabled(boolean z);

    void setContentMode(boolean z);

    void setDealProofsTexts();

    void setUploadImagesTexts();

    void showContinueButton();

    void showContinueNoPhotosButton();

    void showInfoLinkVisible(boolean z);

    void showLoadingState(boolean z);

    void showSendButton();

    void showSendNoPhotosButton();
}
