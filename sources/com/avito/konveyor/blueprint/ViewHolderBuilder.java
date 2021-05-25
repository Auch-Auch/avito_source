package com.avito.konveyor.blueprint;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003:\u0001\rJ5\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "T", "", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lkotlin/Function1;", "Landroid/view/View;", "inflateFunc", "buildViewHolder", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)Lcom/avito/konveyor/adapter/BaseViewHolder;", "ViewHolderProvider", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface ViewHolderBuilder<T extends BaseViewHolder> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003BI\u0012\b\b\u0001\u0010\t\u001a\u00020\u0004\u00126\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bRI\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "T", "", "", AuthSource.SEND_ABUSE, "I", "getLayoutId", "()I", "layoutId", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "getCreator", "()Lkotlin/jvm/functions/Function2;", "creator", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolderProvider<T extends BaseViewHolder> {
        public final int a;
        @NotNull
        public final Function2<ViewGroup, View, T> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super android.view.ViewGroup, ? super android.view.View, ? extends T extends com.avito.konveyor.adapter.BaseViewHolder> */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolderProvider(@LayoutRes int i, @NotNull Function2<? super ViewGroup, ? super View, ? extends T> function2) {
            Intrinsics.checkNotNullParameter(function2, "creator");
            this.a = i;
            this.b = function2;
        }

        @NotNull
        public final Function2<ViewGroup, View, T> getCreator() {
            return this.b;
        }

        public final int getLayoutId() {
            return this.a;
        }
    }

    @Nullable
    T buildViewHolder(@NotNull ViewGroup viewGroup, int i, @NotNull Function1<? super Integer, ? extends View> function1);
}
