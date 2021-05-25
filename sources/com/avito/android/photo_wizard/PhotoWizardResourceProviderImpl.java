package com.avito.android.photo_wizard;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.photo_picker.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u001a\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001d\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardResourceProviderImpl;", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "", "stepNumber", "stepsCount", "", "getStepTitle", "(II)Ljava/lang/String;", "d", "I", "getFlashIconOnResId", "()I", "flashIconOnResId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getActionDone", "()Ljava/lang/String;", "actionDone", "e", "getFlashIconAutoResId", "flashIconAutoResId", "f", "getAllowButtonText", "allowButtonText", g.a, "getSettingsButtonText", "settingsButtonText", AuthSource.SEND_ABUSE, "getActionNext", "actionNext", "c", "getFlashIconOffResId", "flashIconOffResId", "Landroid/content/res/Resources;", "h", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardResourceProviderImpl implements PhotoWizardResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c = R.drawable.ic_light_off;
    public final int d = R.drawable.ic_light_on;
    public final int e = R.drawable.ic_light_auto;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    public final Resources h;

    @Inject
    public PhotoWizardResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.h = resources;
        String string = resources.getString(R.string.action_next);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.action_next)");
        this.a = string;
        String string2 = resources.getString(R.string.action_send);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.action_send)");
        this.b = string2;
        String string3 = resources.getString(R.string.allow_access);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.allow_access)");
        this.f = string3;
        String string4 = resources.getString(R.string.to_settings);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.to_settings)");
        this.g = string4;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    @NotNull
    public String getActionDone() {
        return this.b;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    @NotNull
    public String getActionNext() {
        return this.a;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    @NotNull
    public String getAllowButtonText() {
        return this.f;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    public int getFlashIconAutoResId() {
        return this.e;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    public int getFlashIconOffResId() {
        return this.c;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    public int getFlashIconOnResId() {
        return this.d;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    @NotNull
    public String getSettingsButtonText() {
        return this.g;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardResourceProvider
    @NotNull
    public String getStepTitle(int i, int i2) {
        String string = this.h.getString(R.string.step_number_of, Integer.valueOf(i), Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…, stepNumber, stepsCount)");
        return string;
    }
}
