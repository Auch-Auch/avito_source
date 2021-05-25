package com.avito.android.photo_wizard;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_wizard.converter.WizardStepsConverter;
import com.avito.android.photo_wizard.di.qualifier.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.SchedulersFactory3;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", "", "Lcom/avito/android/remote/model/VerificationStep;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "verificationSteps", "Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;", "c", "Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;", "stepsConverter", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "f", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "resourceProvider", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "d", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "uploadPicturesInteractor", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;Lcom/avito/android/photo_wizard/UploadPicturesInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final List<VerificationStep> b;
    public final WizardStepsConverter c;
    public final UploadPicturesInteractor d;
    public final SchedulersFactory3 e;
    public final PhotoWizardResourceProvider f;
    public final Analytics g;

    @Inject
    public PhotoWizardViewModelFactory(@AdvertId @NotNull String str, @NotNull List<VerificationStep> list, @NotNull WizardStepsConverter wizardStepsConverter, @NotNull UploadPicturesInteractor uploadPicturesInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PhotoWizardResourceProvider photoWizardResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "verificationSteps");
        Intrinsics.checkNotNullParameter(wizardStepsConverter, "stepsConverter");
        Intrinsics.checkNotNullParameter(uploadPicturesInteractor, "uploadPicturesInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers3");
        Intrinsics.checkNotNullParameter(photoWizardResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = list;
        this.c = wizardStepsConverter;
        this.d = uploadPicturesInteractor;
        this.e = schedulersFactory3;
        this.f = photoWizardResourceProvider;
        this.g = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PhotoWizardViewModelImpl.class)) {
            return cls.cast(new PhotoWizardViewModelImpl(this.a, this.c, this.d, this.b, this.e, this.f, this.g));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
