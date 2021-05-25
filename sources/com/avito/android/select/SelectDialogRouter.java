package com.avito.android.select;

import com.avito.android.remote.model.ParcelableEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/select/SelectDialogRouter;", "", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "selectedVariants", "sectionTitle", "", "onSelected", "(Ljava/util/List;Ljava/lang/String;)V", "onCancel", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectDialogRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onSelected$default(SelectDialogRouter selectDialogRouter, List list, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                selectDialogRouter.onSelected(list, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSelected");
        }
    }

    void onCancel();

    void onSelected(@NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str);
}
