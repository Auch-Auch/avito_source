package com.avito.android.select.new_metro.adapter.checkbox_listitem;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.list_item.CheckboxListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewProvider;", "", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxListItemViewProvider {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CheckBoxListItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.select_metro_check_box, a.a);

    public static final class a extends Lambda implements Function2<ViewGroup, View, CheckBoxListItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CheckBoxListItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            View findViewById = view2.findViewById(R.id.check_box);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.CheckboxListItem");
            return new CheckBoxListItemViewImpl((CheckboxListItem) findViewById);
        }
    }

    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CheckBoxListItemViewImpl> getViewHolderProvider() {
        return this.a;
    }
}
