package com.avito.android.messenger.folders;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorageImpl;", "Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorage;", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "preferences", "", "value", "getWasBannerShowed", "()Z", "setWasBannerShowed", "(Z)V", "wasBannerShowed", "<init>", "(Landroid/content/SharedPreferences;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FolderOnboardingStatusStorageImpl implements FolderOnboardingStatusStorage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final SharedPreferences a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/folders/FolderOnboardingStatusStorageImpl$Companion;", "", "", "FOLDER_ONBOARDING_KEY", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public FolderOnboardingStatusStorageImpl(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = sharedPreferences;
    }

    @Override // com.avito.android.messenger.folders.FolderOnboardingStatusStorage
    public boolean getWasBannerShowed() {
        return this.a.getBoolean("messenger_folder_onboarding_showed", false);
    }

    @Override // com.avito.android.messenger.folders.FolderOnboardingStatusStorage
    public void setWasBannerShowed(boolean z) {
        this.a.edit().putBoolean("messenger_folder_onboarding_showed", z).apply();
    }
}
