package com.avito.android.rating.publish.deal_proofs;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\fJ!\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;)V", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isLoading", "handleLoading", "(Z)V", "updateButton", "", "selectedPhotoId", "", "currentPhotoCount", "processPhotoPickerStep", "(Ljava/lang/String;I)V", "Router", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface DealProofsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter$Router;", "", "", "showHelpDialog", "()V", "onBackPressed", "", "selectedPhotoId", "showPhotoPickerForFiles", "(Ljava/lang/String;)V", "showPhotoPickerForImages", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onBackPressed();

        void showHelpDialog();

        void showPhotoPickerForFiles(@Nullable String str);

        void showPhotoPickerForImages(@Nullable String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull DealProofsView dealProofsView);

    void detachRouter();

    void detachView();

    void handleLoading(boolean z);

    @NotNull
    Kundle onSaveState();

    void processPhotoPickerStep(@Nullable String str, int i);

    void updateButton();
}
