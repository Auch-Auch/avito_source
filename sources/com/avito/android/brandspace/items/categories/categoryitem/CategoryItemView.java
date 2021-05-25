package com.avito.android.brandspace.items.categories.categoryitem;

import a2.b.a.a.a;
import android.view.View;
import com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010JI\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", MessengerShareContentUtility.SUBTITLE, "description", "", "precalculatedTextHeight", "Landroid/view/View$OnClickListener;", "clickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Layout", "Measurer", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CategoryItemView categoryItemView) {
            ItemView.DefaultImpls.onUnbind(categoryItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Layout;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "Lcom/avito/android/remote/model/Size;", "component1", "()Lcom/avito/android/remote/model/Size;", "component2", "component3", "titleSize", "subtitleSize", "descriptionSize", "copy", "(Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;)Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Layout;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Size;", "getTitleSize", "getSize", "size", AuthSource.BOOKING_ORDER, "getSubtitleSize", "c", "getDescriptionSize", "<init>", "(Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class Layout implements TextMeasuredLayout {
        @NotNull
        public final Size a;
        @NotNull
        public final Size b;
        @NotNull
        public final Size c;

        public Layout(@NotNull Size size, @NotNull Size size2, @NotNull Size size3) {
            Intrinsics.checkNotNullParameter(size, "titleSize");
            Intrinsics.checkNotNullParameter(size2, "subtitleSize");
            Intrinsics.checkNotNullParameter(size3, "descriptionSize");
            this.a = size;
            this.b = size2;
            this.c = size3;
        }

        public static /* synthetic */ Layout copy$default(Layout layout, Size size, Size size2, Size size3, int i, Object obj) {
            if ((i & 1) != 0) {
                size = layout.a;
            }
            if ((i & 2) != 0) {
                size2 = layout.b;
            }
            if ((i & 4) != 0) {
                size3 = layout.c;
            }
            return layout.copy(size, size2, size3);
        }

        @NotNull
        public final Size component1() {
            return this.a;
        }

        @NotNull
        public final Size component2() {
            return this.b;
        }

        @NotNull
        public final Size component3() {
            return this.c;
        }

        @NotNull
        public final Layout copy(@NotNull Size size, @NotNull Size size2, @NotNull Size size3) {
            Intrinsics.checkNotNullParameter(size, "titleSize");
            Intrinsics.checkNotNullParameter(size2, "subtitleSize");
            Intrinsics.checkNotNullParameter(size3, "descriptionSize");
            return new Layout(size, size2, size3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Layout)) {
                return false;
            }
            Layout layout = (Layout) obj;
            return Intrinsics.areEqual(this.a, layout.a) && Intrinsics.areEqual(this.b, layout.b) && Intrinsics.areEqual(this.c, layout.c);
        }

        @NotNull
        public final Size getDescriptionSize() {
            return this.c;
        }

        @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout
        @NotNull
        public Size getSize() {
            return new Size(Math.max(this.a.getWidth(), Math.max(this.b.getWidth(), this.c.getWidth())), this.c.getHeight() + this.b.getHeight() + this.a.getHeight());
        }

        @NotNull
        public final Size getSubtitleSize() {
            return this.b;
        }

        @NotNull
        public final Size getTitleSize() {
            return this.a;
        }

        public int hashCode() {
            Size size = this.a;
            int i = 0;
            int hashCode = (size != null ? size.hashCode() : 0) * 31;
            Size size2 = this.b;
            int hashCode2 = (hashCode + (size2 != null ? size2.hashCode() : 0)) * 31;
            Size size3 = this.c;
            if (size3 != null) {
                i = size3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Layout(titleSize=");
            L.append(this.a);
            L.append(", subtitleSize=");
            L.append(this.b);
            L.append(", descriptionSize=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Measurer;", "", "", "title", MessengerShareContentUtility.SUBTITLE, "description", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Layout;", "measure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Layout;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public interface Measurer {
        @NotNull
        Layout measure(@Nullable String str, @Nullable String str2, @Nullable String str3);
    }

    void bind(@Nullable Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, int i, @Nullable View.OnClickListener onClickListener);
}
