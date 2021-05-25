package ru.sravni.android.bankproduct.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.IKeyValueStringStorage;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/storage/SharedPrefStringStorage;", "Lru/sravni/android/bankproduct/repository/IKeyValueStringStorage;", "", "key", "getValue", "(Ljava/lang/String;)Ljava/lang/String;", "value", "", "saveValue", "(Ljava/lang/String;Ljava/lang/String;)V", "removeValue", "(Ljava/lang/String;)V", "clear", "()V", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/Context;", "context", "name", "", "mode", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SharedPrefStringStorage implements IKeyValueStringStorage {
    public final SharedPreferences a;

    public SharedPrefStringStorage(@NotNull Context context, @NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPreferences(name, mode)");
        this.a = sharedPreferences;
    }

    @Override // ru.sravni.android.bankproduct.repository.IKeyValueStringStorage
    public void clear() {
        this.a.edit().clear().apply();
    }

    @Override // ru.sravni.android.bankproduct.repository.IKeyValueStringStorage
    @Nullable
    public String getValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.a.getString(str, null);
    }

    @Override // ru.sravni.android.bankproduct.repository.IKeyValueStringStorage
    public void removeValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.a.edit().remove(str).apply();
    }

    @Override // ru.sravni.android.bankproduct.repository.IKeyValueStringStorage
    public void saveValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        this.a.edit().putString(str, str2).apply();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SharedPrefStringStorage(Context context, String str, int i, int i2, j jVar) {
        this(context, str, (i2 & 4) != 0 ? 0 : i);
    }
}
