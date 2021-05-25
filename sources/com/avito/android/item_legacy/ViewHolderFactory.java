package com.avito.android.item_legacy;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0019J5\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJW\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\b\b\u0001\u0010\f\u001a\u00020\u000526\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/item_legacy/ViewHolderFactory;", "T", "", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lkotlin/Function1;", "Landroid/view/View;", "inflateFunc", "buildViewHolder", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "layoutId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "creator", "Lcom/avito/android/item_legacy/ViewHolderFactory$ViewHolderProvider;", GeoContract.PROVIDER, "(ILkotlin/jvm/functions/Function2;)Lcom/avito/android/item_legacy/ViewHolderFactory$ViewHolderProvider;", "", "getProviders", "()Ljava/util/Map;", "providers", "ViewHolderProvider", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "User ElementMetaDataProvider instead")
public interface ViewHolderFactory<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <T> T buildViewHolder(@org.jetbrains.annotations.NotNull com.avito.android.item_legacy.ViewHolderFactory<T> r1, @org.jetbrains.annotations.NotNull android.view.ViewGroup r2, int r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends android.view.View> r4) {
            /*
                java.lang.String r0 = "parent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "inflateFunc"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.util.Map r1 = r1.getProviders()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.Object r1 = r1.get(r3)
                com.avito.android.item_legacy.ViewHolderFactory$ViewHolderProvider r1 = (com.avito.android.item_legacy.ViewHolderFactory.ViewHolderProvider) r1
                if (r1 == 0) goto L_0x002f
                kotlin.jvm.functions.Function2 r3 = r1.getCreator()
                int r1 = r1.getLayoutId()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.Object r1 = r4.invoke(r1)
                java.lang.Object r1 = r3.invoke(r2, r1)
                return r1
            L_0x002f:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.item_legacy.ViewHolderFactory.DefaultImpls.buildViewHolder(com.avito.android.item_legacy.ViewHolderFactory, android.view.ViewGroup, int, kotlin.jvm.functions.Function1):java.lang.Object");
        }

        @NotNull
        public static <T> ViewHolderProvider<T> provider(@NotNull ViewHolderFactory<T> viewHolderFactory, @LayoutRes int i, @NotNull Function2<? super ViewGroup, ? super View, ? extends T> function2) {
            Intrinsics.checkNotNullParameter(function2, "creator");
            return new ViewHolderProvider<>(i, function2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002BI\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007RI\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/item_legacy/ViewHolderFactory$ViewHolderProvider;", "T", "", "", AuthSource.SEND_ABUSE, "I", "getLayoutId", "()I", "layoutId", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "getCreator", "()Lkotlin/jvm/functions/Function2;", "creator", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolderProvider<T> {
        public final int a;
        @NotNull
        public final Function2<ViewGroup, View, T> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super android.view.ViewGroup, ? super android.view.View, ? extends T> */
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

    @NotNull
    Map<Integer, ViewHolderProvider<T>> getProviders();

    @NotNull
    ViewHolderProvider<T> provider(@LayoutRes int i, @NotNull Function2<? super ViewGroup, ? super View, ? extends T> function2);
}
