package com.avito.android.user_advert.advert.verification;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ'\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_advert/advert/verification/VerificationBlockView;", "", "", "isVisible", "", "setVisible", "(Z)V", "", "titleId", "showTitle", "(I)V", "descriptionId", "showDescription", "title", "Lkotlin/Function0;", "onClick", "showButton", "(ILkotlin/jvm/functions/Function0;)V", "hideButton", "()V", "showSupportButton", "(Lkotlin/jvm/functions/Function0;)V", "hideSupportButton", "setAdditionalDescriptionVisible", "setBadgeVisible", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationBlockView {
    void hideButton();

    void hideSupportButton();

    void setAdditionalDescriptionVisible(boolean z);

    void setBadgeVisible(boolean z);

    void setVisible(boolean z);

    void showButton(@StringRes int i, @NotNull Function0<Unit> function0);

    void showDescription(@StringRes int i);

    void showSupportButton(@NotNull Function0<Unit> function0);

    void showTitle(@StringRes int i);
}
