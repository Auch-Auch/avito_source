package com.avito.android.fees.refactor;

import com.avito.android.remote.model.OwnedPackage;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/fees/refactor/PackageItemConverter;", "", "", "message", "", "Lcom/avito/android/remote/model/OwnedPackage;", "ownedPackages", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface PackageItemConverter {
    @NotNull
    List<Item> convert(@NotNull String str, @NotNull List<OwnedPackage> list);
}
