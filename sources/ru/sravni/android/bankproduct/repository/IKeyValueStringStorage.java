package ru.sravni.android.bankproduct.repository;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/repository/IKeyValueStringStorage;", "", "", "key", "getValue", "(Ljava/lang/String;)Ljava/lang/String;", "value", "", "saveValue", "(Ljava/lang/String;Ljava/lang/String;)V", "removeValue", "(Ljava/lang/String;)V", "clear", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IKeyValueStringStorage {
    void clear();

    @Nullable
    String getValue(@NotNull String str);

    void removeValue(@NotNull String str);

    void saveValue(@NotNull String str, @NotNull String str2);
}
