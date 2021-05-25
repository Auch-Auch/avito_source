package com.avito.android.select;

import com.avito.android.remote.model.ParcelableEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/select/SelectListener;", "", "", "requestId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "onCancel", "(Ljava/lang/String;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onCancel(@NotNull SelectListener selectListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
        }

        public static /* synthetic */ void onSelected$default(SelectListener selectListener, String str, List list, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                selectListener.onSelected(str, list, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSelected");
        }
    }

    void onCancel(@NotNull String str);

    void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2);
}
