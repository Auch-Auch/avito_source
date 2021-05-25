package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import java.io.File;
public final class MissingNativeComponent implements CrashlyticsNativeComponent {
    public static final NativeSessionFileProvider a = new b(null);

    public static final class b implements NativeSessionFileProvider {
        public b(a aVar) {
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getAppFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getBinaryImagesFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getDeviceFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMetadataFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMinidumpFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getOsFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getSessionFile() {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean finalizeSession(@NonNull String str) {
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    @NonNull
    public NativeSessionFileProvider getSessionFileProvider(@NonNull String str) {
        return a;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForSession(@NonNull String str) {
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean openSession(@NonNull String str) {
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeBeginSession(@NonNull String str, @NonNull String str2, long j) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionApp(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionDevice(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z, int i3, @NonNull String str3, @NonNull String str4) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionOs(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
    }
}
