package com.avito.android.photo_wizard;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "", "", "stepNumber", "stepsCount", "", "getStepTitle", "(II)Ljava/lang/String;", "getSettingsButtonText", "()Ljava/lang/String;", "settingsButtonText", "getAllowButtonText", "allowButtonText", "getFlashIconAutoResId", "()I", "flashIconAutoResId", "getFlashIconOffResId", "flashIconOffResId", "getActionNext", "actionNext", "getFlashIconOnResId", "flashIconOnResId", "getActionDone", "actionDone", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoWizardResourceProvider {
    @NotNull
    String getActionDone();

    @NotNull
    String getActionNext();

    @NotNull
    String getAllowButtonText();

    int getFlashIconAutoResId();

    int getFlashIconOffResId();

    int getFlashIconOnResId();

    @NotNull
    String getSettingsButtonText();

    @NotNull
    String getStepTitle(int i, int i2);
}
