package com.avito.android.lib.design.chips;

import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/lib/design/chips/Chipable;", "", "", "getImageRes", "()Ljava/lang/Integer;", "getLeftImageRes", "getRightImageRes", "other", "", "equalsAsChipable", "(Ljava/lang/Object;)Z", "", "getChipTitle", "()Ljava/lang/String;", "chipTitle", "components_release"}, k = 1, mv = {1, 4, 2})
public interface Chipable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @DrawableRes
        @Nullable
        public static Integer getImageRes(@NotNull Chipable chipable) {
            return null;
        }

        @DrawableRes
        @Nullable
        public static Integer getLeftImageRes(@NotNull Chipable chipable) {
            return null;
        }

        @DrawableRes
        @Nullable
        public static Integer getRightImageRes(@NotNull Chipable chipable) {
            return null;
        }
    }

    boolean equalsAsChipable(@NotNull Object obj);

    @NotNull
    String getChipTitle();

    @DrawableRes
    @Nullable
    Integer getImageRes();

    @DrawableRes
    @Nullable
    Integer getLeftImageRes();

    @DrawableRes
    @Nullable
    Integer getRightImageRes();
}
