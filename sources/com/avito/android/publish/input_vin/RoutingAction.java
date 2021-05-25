package com.avito.android.publish.input_vin;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/input_vin/RoutingAction;", "", "<init>", "()V", "OpenLink", "SaveAndExitPublishing", "ScanVin", "ShowOnboarding", "Lcom/avito/android/publish/input_vin/RoutingAction$SaveAndExitPublishing;", "Lcom/avito/android/publish/input_vin/RoutingAction$ScanVin;", "Lcom/avito/android/publish/input_vin/RoutingAction$OpenLink;", "Lcom/avito/android/publish/input_vin/RoutingAction$ShowOnboarding;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoutingAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/input_vin/RoutingAction$OpenLink;", "Lcom/avito/android/publish/input_vin/RoutingAction;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "url", "<init>", "(Landroid/net/Uri;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class OpenLink extends RoutingAction {
        @NotNull
        public final Uri a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenLink(@NotNull Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "url");
            this.a = uri;
        }

        @NotNull
        public final Uri getUrl() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/input_vin/RoutingAction$SaveAndExitPublishing;", "Lcom/avito/android/publish/input_vin/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class SaveAndExitPublishing extends RoutingAction {
        @NotNull
        public static final SaveAndExitPublishing INSTANCE = new SaveAndExitPublishing();

        public SaveAndExitPublishing() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/input_vin/RoutingAction$ScanVin;", "Lcom/avito/android/publish/input_vin/RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ScanVin extends RoutingAction {
        @NotNull
        public static final ScanVin INSTANCE = new ScanVin();

        public ScanVin() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/input_vin/RoutingAction$ShowOnboarding;", "Lcom/avito/android/publish/input_vin/RoutingAction;", "Lru/avito/component/toolbar/OnboardingData;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/OnboardingData;", "getOnboardingData", "()Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "<init>", "(Lru/avito/component/toolbar/OnboardingData;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowOnboarding extends RoutingAction {
        @NotNull
        public final OnboardingData a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowOnboarding(@NotNull OnboardingData onboardingData) {
            super(null);
            Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
            this.a = onboardingData;
        }

        @NotNull
        public final OnboardingData getOnboardingData() {
            return this.a;
        }
    }

    public RoutingAction() {
    }

    public RoutingAction(j jVar) {
    }
}
