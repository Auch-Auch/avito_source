package com.google.mlkit.common.model;

import a2.j.h.a.b.b;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
public class LocalModel {
    public final String a;
    public final String b;
    public final Uri c;

    public static class Builder {
        public String a = null;
        public String b = null;
        public Uri c = null;

        @NonNull
        public LocalModel build() {
            String str = this.a;
            Preconditions.checkArgument((str != null && this.b == null && this.c == null) || (str == null && this.b != null && this.c == null) || (str == null && this.b == null && this.c != null), "Set one of filePath, assetFilePath and URI.");
            return new LocalModel(this.a, this.b, this.c, null);
        }

        @NonNull
        public Builder setAbsoluteFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.b == null && this.c == null, "A local model source is from local file, asset or URI, you can only set one of them.");
            this.a = str;
            return this;
        }

        @NonNull
        public Builder setAssetFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.a == null && this.c == null, "A local model source is from local file, asset or URI, you can only set one of them.");
            this.b = str;
            return this;
        }

        @NonNull
        public Builder setUri(@NonNull Uri uri) {
            Preconditions.checkArgument(this.a == null && this.b == null, "A local model source is from local file, asset or URI, you can only set one of them.");
            this.c = uri;
            return this;
        }
    }

    public LocalModel(String str, String str2, Uri uri, b bVar) {
        this.a = str;
        this.b = str2;
        this.c = uri;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        return Objects.equal(this.a, localModel.a) && Objects.equal(this.b, localModel.b) && Objects.equal(this.c, localModel.c);
    }

    @Nullable
    @KeepForSdk
    public String getAbsoluteFilePath() {
        return this.a;
    }

    @Nullable
    @KeepForSdk
    public String getAssetFilePath() {
        return this.b;
    }

    @Nullable
    @KeepForSdk
    public Uri getUri() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c);
    }
}
