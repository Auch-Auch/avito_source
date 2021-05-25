package com.avito.android.job.cv_packages;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerActivity
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/job/cv_packages/CvPackagesNavigator;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "open", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "exit", "()V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Landroidx/appcompat/app/AppCompatActivity;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatActivity;", "activity", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class CvPackagesNavigator {
    public final AppCompatActivity a;
    public final DeepLinkIntentFactory b;

    @Inject
    public CvPackagesNavigator(@NotNull AppCompatActivity appCompatActivity, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "intentFactory");
        this.a = appCompatActivity;
        this.b = deepLinkIntentFactory;
    }

    public final void exit() {
        this.a.finish();
    }

    public final void open(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.b.getIntent(deepLink);
        if (intent != null) {
            this.a.startActivityForResult(intent, 1);
        }
    }
}
