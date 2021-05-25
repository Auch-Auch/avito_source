package ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J!\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u0018J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001e\u0010\u0006J\u001f\u0010!\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000bH&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b'\u0010\n¨\u0006("}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "name", "", "setName", "(Ljava/lang/String;)V", "", "lineCount", "setNameMaxLines", "(I)V", "", "rating", "setRating", "(Ljava/lang/Float;)V", "reviewCount", "setReviewCount", "Lcom/avito/android/image_loader/Picture;", "image", "", "isShop", "setLogo", "(Lcom/avito/android/image_loader/Picture;Z)V", "hideLogo", "()V", "verification", "setExternalVerification", "setInternalVerification", "hideExternalVerification", "sellerTypeName", "setSellerTypeName", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "widthRatio", "setWidthRatio", "(F)V", "sidePadding", "setPadding", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface CarouselSellerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CarouselSellerItemView carouselSellerItemView) {
            ItemView.DefaultImpls.onUnbind(carouselSellerItemView);
        }
    }

    void hideExternalVerification();

    void hideLogo();

    void setExternalVerification(@Nullable String str);

    void setInternalVerification(@Nullable String str);

    void setLogo(@Nullable Picture picture, boolean z);

    void setName(@NotNull String str);

    void setNameMaxLines(int i);

    void setOnClickListener(@Nullable Function0<Unit> function0);

    void setPadding(int i);

    void setRating(@Nullable Float f);

    void setReviewCount(@Nullable String str);

    void setSellerTypeName(@Nullable String str);

    void setWidthRatio(float f);
}
