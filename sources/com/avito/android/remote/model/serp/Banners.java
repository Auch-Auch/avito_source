package com.avito.android.remote.model.serp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/serp/Banners;", "", "", "Lcom/avito/android/remote/model/serp/Banner;", "top", "Ljava/util/List;", "getTop", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Banners {
    @SerializedName("top")
    @Nullable
    private final List<Banner> top;

    public Banners(@Nullable List<Banner> list) {
        this.top = list;
    }

    @Nullable
    public final List<Banner> getTop() {
        return this.top;
    }
}
