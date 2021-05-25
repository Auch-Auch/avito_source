package ru.sravni.android.bankproduct.utils.avatar;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/utils/avatar/IAvatarProvider;", "", "", "changeAvatar", "()V", "", "getCurrentAvatarRes", "()Ljava/lang/Integer;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IAvatarProvider {
    void changeAvatar();

    @Nullable
    Integer getCurrentAvatarRes();
}
