package com.avito.android.ui.widget.tagged_input;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007J!\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0007J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "itemId", "Landroidx/lifecycle/LiveData;", "", "tagsVisibility", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/avito/android/ui/widget/tagged_input/TagItem;", "tagSelected", "", "tagItems", "tags", "", "applyTagsList", "(Ljava/lang/String;Ljava/util/List;)V", "tagItem", "shouldKeepTags", "onTagClicked", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagItem;Z)V", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel$a;", "c", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel$a;", "storage", "<init>", "()V", AuthSource.SEND_ABUSE, "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public class TagsViewModel extends ViewModel {
    public final a c = new a();

    public static final class a {
        public final Map<String, MutableLiveData<Boolean>> a = new LinkedHashMap();
        public final Map<String, SingleLiveEvent<TagItem>> b = new LinkedHashMap();
        public final Map<String, MutableLiveData<List<TagItem>>> c = new LinkedHashMap();

        @NotNull
        public final MutableLiveData<List<TagItem>> a(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, MutableLiveData<List<TagItem>>> map = this.c;
            MutableLiveData<List<TagItem>> mutableLiveData = map.get(str);
            if (mutableLiveData == null) {
                mutableLiveData = new MutableLiveData<>();
                map.put(str, mutableLiveData);
            }
            return mutableLiveData;
        }

        @NotNull
        public final SingleLiveEvent<TagItem> b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, SingleLiveEvent<TagItem>> map = this.b;
            SingleLiveEvent<TagItem> singleLiveEvent = map.get(str);
            if (singleLiveEvent == null) {
                singleLiveEvent = new SingleLiveEvent<>();
                map.put(str, singleLiveEvent);
            }
            return singleLiveEvent;
        }

        @NotNull
        public final MutableLiveData<Boolean> c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, MutableLiveData<Boolean>> map = this.a;
            MutableLiveData<Boolean> mutableLiveData = map.get(str);
            if (mutableLiveData == null) {
                mutableLiveData = new MutableLiveData<>();
                map.put(str, mutableLiveData);
            }
            return mutableLiveData;
        }
    }

    public final void applyTagsList(@NotNull String str, @Nullable List<TagItem> list) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        if (list == null || list.isEmpty()) {
            this.c.a(str).setValue(null);
            this.c.c(str).setValue(Boolean.FALSE);
            return;
        }
        this.c.a(str).setValue(new ArrayList(list));
        this.c.c(str).setValue(Boolean.valueOf(!list.isEmpty()));
    }

    public final void onTagClicked(@NotNull String str, @NotNull TagItem tagItem, boolean z) {
        List<TagItem> value;
        List<TagItem> mutableList;
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(tagItem, "tagItem");
        this.c.b(str).setValue(tagItem);
        if (!z && (value = this.c.a(str).getValue()) != null && (mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value)) != null) {
            if (mutableList.remove(tagItem)) {
                if (mutableList.isEmpty()) {
                    this.c.c(str).setValue(Boolean.FALSE);
                }
                this.c.a(str).setValue(mutableList);
                return;
            }
            Logs.error$default("Failed to remove tag " + tagItem, null, 2, null);
        }
    }

    @NotNull
    public final LiveData<List<TagItem>> tagItems(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.a(str);
    }

    @NotNull
    public final LiveData<TagItem> tagSelected(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.b(str);
    }

    @NotNull
    public final LiveData<Boolean> tagsVisibility(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.c(str);
    }
}
