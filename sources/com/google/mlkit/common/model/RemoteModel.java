package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;
public class RemoteModel {
    public static final Map<BaseModel, String> e = new EnumMap(BaseModel.class);
    @VisibleForTesting
    public static final Map<BaseModel, String> f = new EnumMap(BaseModel.class);
    @Nullable
    public final String a;
    @Nullable
    public final BaseModel b;
    @Nullable
    public final ModelType c;
    public String d;

    @KeepForSdk
    public RemoteModel(@Nullable String str, @Nullable BaseModel baseModel, ModelType modelType) {
        Preconditions.checkArgument(TextUtils.isEmpty(str) != (baseModel != null) ? false : true, "One of cloud model name and base model cannot be empty");
        this.a = str;
        this.b = baseModel;
        this.c = modelType;
    }

    @KeepForSdk
    public boolean baseModelHashMatches(@NonNull String str) {
        BaseModel baseModel = this.b;
        if (baseModel == null) {
            return false;
        }
        return str.equals(e.get(baseModel));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RemoteModel remoteModel = (RemoteModel) obj;
            if (Objects.equal(this.a, remoteModel.a) && Objects.equal(this.b, remoteModel.b)) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public String getModelHash() {
        return this.d;
    }

    @Nullable
    @KeepForSdk
    public String getModelName() {
        return this.a;
    }

    @KeepForSdk
    public String getModelNameForBackend() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        return f.get(this.b);
    }

    @KeepForSdk
    public ModelType getModelType() {
        return this.c;
    }

    @KeepForSdk
    public String getUniqueModelNameForPersist() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        String valueOf = String.valueOf(f.get(this.b));
        return valueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(valueOf) : new String("COM.GOOGLE.BASE_");
    }

    public int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    @KeepForSdk
    public boolean isBaseModel() {
        return this.b != null;
    }

    @KeepForSdk
    public void setModelHash(@NonNull String str) {
        this.d = str;
    }
}
