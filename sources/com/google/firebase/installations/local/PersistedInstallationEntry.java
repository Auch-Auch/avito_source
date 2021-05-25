package com.google.firebase.installations.local;

import a2.j.e.j.l.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.PersistedInstallation;
@AutoValue
public abstract class PersistedInstallationEntry {
    @NonNull
    public static PersistedInstallationEntry INSTANCE = builder().build();

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry build();

        @NonNull
        public abstract Builder setAuthToken(@Nullable String str);

        @NonNull
        public abstract Builder setExpiresInSecs(long j);

        @NonNull
        public abstract Builder setFirebaseInstallationId(@NonNull String str);

        @NonNull
        public abstract Builder setFisError(@Nullable String str);

        @NonNull
        public abstract Builder setRefreshToken(@Nullable String str);

        @NonNull
        public abstract Builder setRegistrationStatus(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder setTokenCreationEpochInSecs(long j);
    }

    @NonNull
    public static Builder builder() {
        a.b bVar = new a.b();
        bVar.setTokenCreationEpochInSecs(0);
        bVar.setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION);
        bVar.setExpiresInSecs(0);
        return bVar;
    }

    @Nullable
    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    @Nullable
    public abstract String getFirebaseInstallationId();

    @Nullable
    public abstract String getFisError();

    @Nullable
    public abstract String getRefreshToken();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isNotGenerated() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean isRegistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean isUnregistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean shouldAttemptMigration() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public PersistedInstallationEntry withAuthToken(@NonNull String str, long j, long j2) {
        return toBuilder().setAuthToken(str).setExpiresInSecs(j).setTokenCreationEpochInSecs(j2).build();
    }

    @NonNull
    public PersistedInstallationEntry withClearedAuthToken() {
        return toBuilder().setAuthToken(null).build();
    }

    @NonNull
    public PersistedInstallationEntry withFisError(@NonNull String str) {
        return toBuilder().setFisError(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    @NonNull
    public PersistedInstallationEntry withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    @NonNull
    public PersistedInstallationEntry withRegisteredFid(@NonNull String str, @NonNull String str2, long j, @Nullable String str3, long j2) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(str3).setRefreshToken(str2).setExpiresInSecs(j2).setTokenCreationEpochInSecs(j).build();
    }

    @NonNull
    public PersistedInstallationEntry withUnregisteredFid(@NonNull String str) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }
}
