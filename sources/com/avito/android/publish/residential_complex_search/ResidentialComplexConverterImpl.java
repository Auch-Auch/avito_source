package com.avito.android.publish.residential_complex_search;

import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonItem;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ResidentialComplexSuggest;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverterImpl;", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "", "Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "suggests", "", "searchValue", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "convertValues", "", AuthSource.SEND_ABUSE, "()J", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", AuthSource.BOOKING_ORDER, "Ljava/util/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "list", "J", "getId", "setId", "(J)V", "id", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexConverterImpl implements ResidentialComplexConverter {
    public long a;
    @NotNull
    public ArrayList<Item> b = new ArrayList<>();

    public final long a() {
        long j = this.a;
        this.a = 1 + j;
        return j;
    }

    @Override // com.avito.android.publish.residential_complex_search.ResidentialComplexConverter
    @NotNull
    public ListDataSource<Item> convert(@NotNull List<ResidentialComplexSuggest> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        this.b.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.b.add(new ResidentialComplexSuggestItem(a(), it.next()));
        }
        this.b.add(new ResidentialComplexButtonItem(a()));
        return new ListDataSource<>(this.b);
    }

    @Override // com.avito.android.publish.residential_complex_search.ResidentialComplexConverter
    @NotNull
    public ListDataSource<Item> convertValues(@NotNull List<SelectParameter.Value> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        this.b.clear();
        boolean z = false;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                String title = t.getTitle();
                Intrinsics.checkNotNull(str);
                if (StringsKt__StringsKt.contains((CharSequence) title, (CharSequence) str, true)) {
                    arrayList.add(t);
                }
            }
            list = arrayList;
        }
        for (T t2 : list) {
            this.b.add(new ResidentialComplexSuggestItem(a(), new ResidentialComplexSuggest(Integer.parseInt(t2.getId()), t2.getTitle(), "", "")));
        }
        this.b.add(new ResidentialComplexButtonItem(a()));
        return new ListDataSource<>(this.b);
    }

    public final long getId() {
        return this.a;
    }

    @NotNull
    public final ArrayList<Item> getList() {
        return this.b;
    }

    public final void setId(long j) {
        this.a = j;
    }

    public final void setList(@NotNull ArrayList<Item> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.b = arrayList;
    }
}
