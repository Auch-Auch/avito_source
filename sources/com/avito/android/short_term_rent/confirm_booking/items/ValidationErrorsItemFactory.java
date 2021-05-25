package com.avito.android.short_term_rent.confirm_booking.items;

import com.avito.android.category_parameters.CategoryParametersItemFactory;
import com.avito.android.conveyor_shared_item.notification.NotificationItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.conveyor_item.Item;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/items/ValidationErrorsItemFactory;", "Lcom/avito/android/category_parameters/CategoryParametersItemFactory;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "parameter", "", "needCreate", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Z", "Lcom/avito/conveyor_item/Item;", "createItem", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/conveyor_item/Item;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "errors", "<init>", "(Ljava/util/Map;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class ValidationErrorsItemFactory extends CategoryParametersItemFactory {
    public final Map<String, String> a;

    public ValidationErrorsItemFactory(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        this.a = map;
    }

    @Override // com.avito.android.category_parameters.CategoryParametersItemFactory
    @NotNull
    public Item createItem(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "parameter");
        String str = this.a.get(categoryParameter.getId());
        if (str != null) {
            return new NotificationItem(categoryParameter.getId() + "_error", str, "error");
        }
        throw new IllegalStateException("Parameter error not found. Look at needCreate() method");
    }

    @Override // com.avito.android.category_parameters.CategoryParametersItemFactory
    public boolean needCreate(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "parameter");
        String str = this.a.get(categoryParameter.getId());
        if (str != null) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
