package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.model.RemoteModel;
import java.io.File;
@KeepForSdk
public interface ModelValidator {

    @KeepForSdk
    public static class ValidationResult {
        @KeepForSdk
        public static final ValidationResult VALID = new ValidationResult(ErrorCode.OK, null);
        public final ErrorCode a;
        public final String b;

        @KeepForSdk
        public enum ErrorCode {
            OK,
            TFLITE_VERSION_INCOMPATIBLE,
            MODEL_FORMAT_INVALID
        }

        @KeepForSdk
        public ValidationResult(ErrorCode errorCode, @Nullable String str) {
            this.a = errorCode;
            this.b = str;
        }

        @KeepForSdk
        public ErrorCode getErrorCode() {
            return this.a;
        }

        @Nullable
        @KeepForSdk
        public String getErrorMessage() {
            return this.b;
        }

        @KeepForSdk
        public boolean isValid() {
            return this.a == ErrorCode.OK;
        }
    }

    @KeepForSdk
    ValidationResult validateModel(File file, RemoteModel remoteModel);
}
