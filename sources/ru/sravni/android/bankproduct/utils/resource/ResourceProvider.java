package ru.sravni.android.bankproduct.utils.resource;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/resource/ResourceProvider;", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "", "colorId", "getColor", "(I)I", "stringId", "", "getString", "(I)Ljava/lang/String;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ResourceProvider implements IResourceProvider {
    public final Context a;

    public ResourceProvider(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.a = context;
    }

    @Override // ru.sravni.android.bankproduct.utils.resource.IResourceProvider
    public int getColor(int i) {
        return ContextCompat.getColor(this.a, i);
    }

    @Override // ru.sravni.android.bankproduct.utils.resource.IResourceProvider
    @NotNull
    public String getString(int i) {
        String string = this.a.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(stringId)");
        return string;
    }
}
