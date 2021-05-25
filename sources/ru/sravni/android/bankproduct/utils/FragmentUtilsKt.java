package ru.sravni.android.bankproduct.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a'\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a&\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Landroidx/fragment/app/Fragment;", "", "key", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", "putJsonArg", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/Object;)V", "getJsonArg", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)Ljava/lang/Object;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class FragmentUtilsKt {
    @Nullable
    public static final /* synthetic */ <T> T getJsonArg(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$getJsonArg");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Gson gson = new Gson();
        Bundle arguments = fragment.getArguments();
        String string = arguments != null ? arguments.getString(str) : null;
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) gson.fromJson(string, (Class<Object>) Object.class);
    }

    public static final <T> void putJsonArg(@NotNull Fragment fragment, @NotNull String str, T t) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$putJsonArg");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Bundle bundle = new Bundle();
        bundle.putString(str, new Gson().toJson((Object) t));
        fragment.setArguments(bundle);
    }
}
