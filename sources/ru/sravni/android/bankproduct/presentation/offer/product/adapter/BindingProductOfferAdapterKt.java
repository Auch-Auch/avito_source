package ru.sravni.android.bankproduct.presentation.offer.product.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.CardTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/widget/ImageView;", "view", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "offerStatus", "", "bindStatusToImageView", "(Landroid/widget/ImageView;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;)V", "imageView", "Lru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;", "typeCard", "", "colorImage", "bindTypeCardToImageView", "(Landroid/widget/ImageView;Lru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;I)V", "Landroid/widget/FrameLayout;", TextureMediaEncoder.FRAME_EVENT, "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "logoInfo", "bindSvgUriToLogoFrameLayout", "(Landroid/widget/FrameLayout;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "Lantonkozyriatskyi/circularprogressindicator/CircularProgressIndicator;", "progress", "bindProgressToCircularProgressIndicator", "(Lantonkozyriatskyi/circularprogressindicator/CircularProgressIndicator;I)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProductOfferAdapterKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ProductStatusEnum.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            ProductStatusEnum productStatusEnum = ProductStatusEnum.SENDED;
            iArr[5] = 1;
            ProductStatusEnum productStatusEnum2 = ProductStatusEnum.DECLINED;
            iArr[3] = 2;
            ProductStatusEnum productStatusEnum3 = ProductStatusEnum.ACCEPTED;
            iArr[2] = 3;
            ProductStatusEnum productStatusEnum4 = ProductStatusEnum.WAITING;
            iArr[0] = 4;
            CardTypeEnum.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            CardTypeEnum cardTypeEnum = CardTypeEnum.MASTER_CARD;
            iArr2[0] = 1;
            CardTypeEnum cardTypeEnum2 = CardTypeEnum.VISA;
            iArr2[1] = 2;
            CardTypeEnum cardTypeEnum3 = CardTypeEnum.MIR;
            iArr2[2] = 3;
        }
    }

    @BindingAdapter({"progress"})
    public static final void bindProgressToCircularProgressIndicator(@NotNull CircularProgressIndicator circularProgressIndicator, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(circularProgressIndicator, "view");
        if (i >= 90) {
            double d = (double) i;
            circularProgressIndicator.setProgress(d, d);
        } else {
            circularProgressIndicator.setProgress((double) i, 100.0d);
        }
        Context context = circularProgressIndicator.getContext();
        Integer valueOf = Integer.valueOf(i);
        boolean z = false;
        if (valueOf != null && new IntRange(0, 29).contains(valueOf.intValue())) {
            i2 = R.color.error;
        } else {
            IntRange intRange = new IntRange(30, 65);
            if (valueOf != null && intRange.contains(valueOf.intValue())) {
                z = true;
            }
            if (z) {
                i2 = R.color.on_secondary;
            } else {
                i2 = R.color.secondary;
            }
        }
        int color = ContextCompat.getColor(context, i2);
        circularProgressIndicator.setProgressColor(color);
        circularProgressIndicator.setDotColor(color);
    }

    @BindingAdapter({"offerStatus"})
    public static final void bindStatusToImageView(@NotNull ImageView imageView, @Nullable ProductStatusEnum productStatusEnum) {
        int i;
        Intrinsics.checkParameterIsNotNull(imageView, "view");
        if (productStatusEnum != null) {
            int ordinal = productStatusEnum.ordinal();
            if (ordinal == 0) {
                i = R.drawable.ic_status_loading_sravni;
            } else if (ordinal == 5) {
                i = R.drawable.ic_status_sent_sravni;
            } else if (ordinal == 2) {
                i = R.drawable.ic_status_check_sravni;
            } else if (ordinal != 3) {
                i = 0;
            } else {
                i = R.drawable.ic_status_x_sravni;
            }
            imageView.setImageResource(i);
        }
    }

    @BindingAdapter({"logoInfo"})
    public static final void bindSvgUriToLogoFrameLayout(@NotNull FrameLayout frameLayout, @Nullable LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(frameLayout, TextureMediaEncoder.FRAME_EVENT);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.imgCreditIcon);
        ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.imgCreditSvgIcon);
        TextView textView = (TextView) frameLayout.findViewById(R.id.tvCreditIcon);
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        if (imageView2 != null) {
            if ((logoInfo != null ? logoInfo.getLogoUrl() : null) != null) {
                Glide.with(frameLayout.getContext()).load(logoInfo.getLogoUrl()).listener(new RequestListener<Drawable>(logoInfo, textView, imageView, imageView2) { // from class: ru.sravni.android.bankproduct.presentation.offer.product.adapter.BindingProductOfferAdapterKt$bindSvgUriToLogoFrameLayout$1
                    public final /* synthetic */ LogoInfo a;
                    public final /* synthetic */ TextView b;
                    public final /* synthetic */ ImageView c;
                    public final /* synthetic */ ImageView d;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<Drawable> target, boolean z) {
                        this.a.getLogoLoadCallback().onError(glideException, this.a.getLogoUrl());
                        return false;
                    }

                    public boolean onResourceReady(@Nullable Drawable drawable, @Nullable Object obj, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean z) {
                        TextView textView2 = this.b;
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                        ImageView imageView3 = this.c;
                        if (imageView3 != null) {
                            imageView3.setVisibility(8);
                        }
                        this.d.setVisibility(0);
                        this.a.getLogoLoadCallback().onSuccess();
                        return false;
                    }
                }).into(imageView2);
            }
        }
    }

    @BindingAdapter({"typeCard", "colorImage"})
    public static final void bindTypeCardToImageView(@NotNull ImageView imageView, @Nullable CardTypeEnum cardTypeEnum, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        if (cardTypeEnum != null) {
            int ordinal = cardTypeEnum.ordinal();
            if (ordinal == 0) {
                i2 = R.drawable.ic_mastercard_sravni;
            } else if (ordinal == 1) {
                i2 = R.drawable.ic_visa_sravni;
            } else if (ordinal != 2) {
                i2 = 0;
            } else {
                i2 = R.drawable.ic_mir_sravni;
            }
            imageView.setImageResource(i2);
            imageView.setColorFilter(i);
        }
    }
}
