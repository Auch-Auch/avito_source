package com.avito.android.express_cv;

import androidx.lifecycle.LiveData;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/express_cv/ExistedCvDataProvider;", "", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/conveyor_item/Item;", "getExistedCvItems", "()Landroidx/lifecycle/LiveData;", "existedCvItems", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExistedCvDataProvider {
    @NotNull
    LiveData<List<Item>> getExistedCvItems();
}
