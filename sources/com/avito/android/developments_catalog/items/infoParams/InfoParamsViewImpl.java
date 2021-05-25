package com.avito.android.developments_catalog.items.infoParams;

import a2.a.a.n0.d.b.a;
import android.view.View;
import com.avito.android.developments_catalog.remote.model.KeyValue;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/developments_catalog/items/infoParams/InfoParamsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/infoParams/InfoParamsView;", "", "name", "", "Lcom/avito/android/developments_catalog/remote/model/KeyValue;", ResidentialComplexModuleKt.VALUES, "", "bindInfoParams", "(Ljava/lang/String;Ljava/util/List;)V", "La2/a/a/n0/d/b/a;", "s", "La2/a/a/n0/d/b/a;", "reusableInfoParamsView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class InfoParamsViewImpl extends BaseViewHolder implements InfoParamsView {
    public final a s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoParamsViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new a(view);
    }

    @Override // com.avito.android.developments_catalog.items.infoParams.InfoParamsView
    public void bindInfoParams(@NotNull String str, @NotNull List<KeyValue> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList.add(0, new KeyValue(null, str, null));
        a aVar = this.s;
        Objects.requireNonNull(aVar);
        Intrinsics.checkNotNullParameter(mutableList, "data");
        aVar.reuseChildrenView(aVar.a, mutableList);
    }
}
