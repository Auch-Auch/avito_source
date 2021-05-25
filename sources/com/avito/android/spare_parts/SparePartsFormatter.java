package com.avito.android.spare_parts;

import android.content.Context;
import com.avito.android.remote.models.SparePartsResponse;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JI\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/spare_parts/SparePartsFormatter;", "", "Landroid/content/Context;", "context", "", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "groups", "Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "specifications", "Lcom/avito/android/spare_parts/SparePartsItemClickListener;", "itemClickListener", "", "format", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/avito/android/spare_parts/SparePartsItemClickListener;)Ljava/util/List;", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public interface SparePartsFormatter {
    @Nullable
    List<CharSequence> format(@NotNull Context context, @Nullable List<SparePartsResponse.SparePartsGroup> list, @Nullable List<SparePartsResponse.Specification> list2, @Nullable SparePartsItemClickListener sparePartsItemClickListener);
}
