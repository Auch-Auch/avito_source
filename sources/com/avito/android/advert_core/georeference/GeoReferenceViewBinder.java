package com.avito.android.advert_core.georeference;

import com.avito.android.remote.model.GeoReference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinder;", "", "", "", "colors", "content", "after", "", "bindData", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/GeoReference;", "geoReference", "(Lcom/avito/android/remote/model/GeoReference;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface GeoReferenceViewBinder {
    void bindData(@NotNull GeoReference geoReference);

    void bindData(@NotNull List<String> list, @Nullable String str, @Nullable String str2);
}
