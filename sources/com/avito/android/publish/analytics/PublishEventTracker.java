package com.avito.android.publish.analytics;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaButtonAction;
import com.avito.android.validation.ValidationResult;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0014\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b!\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0004J\u0019\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H&¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H&¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010\u0004¨\u0006/"}, d2 = {"Lcom/avito/android/publish/analytics/PublishEventTracker;", "", "", "trackStsScanResultReceived", "()V", "", "fieldName", "fieldValue", "Lcom/avito/android/remote/model/Navigation;", "navigation", "trackParamValueChangedEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)V", "", "categoryId", "trackAddAdvert", "(Ljava/lang/Integer;)V", "rootCategoryId", "trackAddAdvertWithVertical", "(I)V", "trackNewAdvertShown", "trackSelectCategory", "", "Lcom/avito/android/validation/ValidationResult$Failure;", "validationResult", "trackPublishInputError", "(Ljava/util/List;Lcom/avito/android/remote/model/Navigation;)V", "trackPublishVerticalChosen", "(Lcom/avito/android/remote/model/Navigation;)V", "trackContactsScreenOpened", "url", "trackInfoLinkClickEvent", "(Ljava/lang/String;)V", "screenId", "trackItemAddCloseEvent", "trackItemAddScreenOpen", "trackItemAddAutoStsPhotoOpen", "trackPhotoPickerOpen", "trackOtherCategoryClick", "trackVideoInfoClicked", "trackVideoUploadingClicked", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;", "action", "trackCpaSlotShowed", "(Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;)V", "trackCpaSlotButtonClicked", "trackCpaRequestSend", "trackCpaRequestSuccess", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishEventTracker {
    void trackAddAdvert(@Nullable Integer num);

    void trackAddAdvertWithVertical(int i);

    void trackContactsScreenOpened();

    void trackCpaRequestSend();

    void trackCpaRequestSuccess();

    void trackCpaSlotButtonClicked(@Nullable CpaButtonAction cpaButtonAction);

    void trackCpaSlotShowed(@Nullable CpaButtonAction cpaButtonAction);

    void trackInfoLinkClickEvent(@NotNull String str);

    void trackItemAddAutoStsPhotoOpen();

    void trackItemAddCloseEvent(@Nullable String str);

    void trackItemAddScreenOpen(@Nullable String str);

    void trackNewAdvertShown();

    void trackOtherCategoryClick();

    void trackParamValueChangedEvent(@NotNull String str, @Nullable String str2, @NotNull Navigation navigation);

    void trackPhotoPickerOpen();

    void trackPublishInputError(@Nullable List<? extends ValidationResult.Failure> list, @NotNull Navigation navigation);

    void trackPublishVerticalChosen(@NotNull Navigation navigation);

    void trackSelectCategory(@Nullable Integer num);

    void trackStsScanResultReceived();

    void trackVideoInfoClicked();

    void trackVideoUploadingClicked();
}
