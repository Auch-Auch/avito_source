package com.avito.android.photo_wizard;

import android.app.Application;
import android.content.Intent;
import com.avito.android.PhotoWizardIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStep;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardIntentFactoryImpl;", "Lcom/avito/android/PhotoWizardIntentFactory;", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lcom/avito/android/remote/model/VerificationStep;", "steps", "Landroid/content/Intent;", "photoWizardIntent", "(Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardIntentFactoryImpl implements PhotoWizardIntentFactory {
    public final Application a;

    @Inject
    public PhotoWizardIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.PhotoWizardIntentFactory
    @NotNull
    public Intent photoWizardIntent(@NotNull String str, @NotNull List<VerificationStep> list) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "steps");
        return PhotoWizardActivityKt.createPhotoWizardIntent(this.a, str, list);
    }
}
