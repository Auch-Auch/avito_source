package com.avito.android.brandspace.presenter;

import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001ak\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000j\u0002`\u0005*\"\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000j\u0002`\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n\u001ae\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000j\u0002`\u0005*\"\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000j\u0002`\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\n*B\u0010\f\"\u001e\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00002\u001e\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000¨\u0006\r"}, d2 = {"Lkotlin/Triple;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItems;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "Lcom/avito/android/brandspace/presenter/ExtraLoadingListItemsResult;", "Lkotlin/Function1;", "", "block", "onSuccess", "(Lkotlin/Triple;Lkotlin/jvm/functions/Function1;)Lkotlin/Triple;", "onError", "ExtraLoadingListItemsResult", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class ExtraLoadingListItemsResultKt {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.Triple<? extends com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems, ? extends java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem>, ? extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Triple<ExtraLoadingListItems, List<BrandspaceItem>, Throwable> onError(@NotNull Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable> triple, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(triple, "$this$onError");
        Intrinsics.checkNotNullParameter(function1, "block");
        Throwable th = (Throwable) triple.getThird();
        if (th != null) {
            function1.invoke(th);
        }
        return triple;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.Triple<? extends com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems, ? extends java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem>, ? extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Triple<ExtraLoadingListItems, List<BrandspaceItem>, Throwable> onSuccess(@NotNull Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable> triple, @NotNull Function1<? super List<? extends BrandspaceItem>, Unit> function1) {
        Intrinsics.checkNotNullParameter(triple, "$this$onSuccess");
        Intrinsics.checkNotNullParameter(function1, "block");
        List list = (List) triple.getSecond();
        if (list != null) {
            function1.invoke(list);
        }
        return triple;
    }
}
