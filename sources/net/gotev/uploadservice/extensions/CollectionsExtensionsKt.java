package net.gotev.uploadservice.extensions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.NameValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u0006*\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\f\u001a\u00020\u0006*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "Lkotlin/collections/ArrayList;", "", "name", "value", "", "addHeader", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "key", "setOrRemove", "(Ljava/util/LinkedHashMap;Ljava/lang/String;Ljava/lang/String;)V", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class CollectionsExtensionsKt {
    public static final void addHeader(@NotNull ArrayList<NameValue> arrayList, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(arrayList, "$this$addHeader");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        arrayList.add(new NameValue(str, str2).validateAsHeader());
    }

    public static final void setOrRemove(@NotNull LinkedHashMap<String, String> linkedHashMap, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "$this$setOrRemove");
        Intrinsics.checkNotNullParameter(str, "key");
        if (str2 == null) {
            linkedHashMap.remove(str);
        } else {
            linkedHashMap.put(str, str2);
        }
    }
}
