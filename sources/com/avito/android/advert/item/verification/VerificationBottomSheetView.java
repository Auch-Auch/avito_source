package com.avito.android.advert.item.verification;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00042\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/verification/VerificationBottomSheetView;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "setButtonTitle", "(I)V", "attrStyle", "setButtonStyle", "Lkotlin/Function0;", "onClick", "setOnButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "imageRes", "setImageRes", "(Ljava/lang/Integer;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationBottomSheetView {
    void setButtonStyle(@AttrRes int i);

    void setButtonTitle(@StringRes int i);

    void setDescription(@NotNull String str);

    void setImageRes(@DrawableRes @Nullable Integer num);

    void setOnButtonClickListener(@NotNull Function0<Unit> function0);

    void setTitle(@NotNull String str);
}
