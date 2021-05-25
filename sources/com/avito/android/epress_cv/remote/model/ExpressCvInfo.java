package com.avito.android.epress_cv.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", "", "Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "existedCv", "Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "getExistedCv", "()Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "Lcom/avito/android/epress_cv/remote/model/PublishCv;", "publishCv", "Lcom/avito/android/epress_cv/remote/model/PublishCv;", "getPublishCv", "()Lcom/avito/android/epress_cv/remote/model/PublishCv;", "<init>", "(Lcom/avito/android/epress_cv/remote/model/PublishCv;Lcom/avito/android/epress_cv/remote/model/ExistedCv;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvInfo {
    @SerializedName("existedCV")
    @Nullable
    private final ExistedCv existedCv;
    @SerializedName("publishCV")
    @NotNull
    private final PublishCv publishCv;

    public ExpressCvInfo(@NotNull PublishCv publishCv2, @Nullable ExistedCv existedCv2) {
        Intrinsics.checkNotNullParameter(publishCv2, "publishCv");
        this.publishCv = publishCv2;
        this.existedCv = existedCv2;
    }

    @Nullable
    public final ExistedCv getExistedCv() {
        return this.existedCv;
    }

    @NotNull
    public final PublishCv getPublishCv() {
        return this.publishCv;
    }
}
