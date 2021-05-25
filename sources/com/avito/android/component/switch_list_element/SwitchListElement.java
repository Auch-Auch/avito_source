package com.avito.android.component.switch_list_element;

import android.text.method.MovementMethod;
import androidx.annotation.DrawableRes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H&¢\u0006\u0004\b\u001c\u0010\u001bJ%\u0010\u001f\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0013H&¢\u0006\u0004\b$\u0010\u0015J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0013H&¢\u0006\u0004\b&\u0010\u001b¨\u0006'"}, d2 = {"Lcom/avito/android/component/switch_list_element/SwitchListElement;", "", "", "resId", "", "setIcon", "(I)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "Landroid/text/method/MovementMethod;", "movementMethod", "setSubtitle", "(Ljava/lang/CharSequence;Landroid/text/method/MovementMethod;)V", "showToggle", "()V", "hideToggle", "", "isChecked", "()Z", "withAnimation", "setChecked", "(ZZ)V", "isEnabled", "setEnabled", "(Z)V", "setSwitchEnabled", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isSaveEnabled", "enabled", "setSaveEnabled", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SwitchListElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setChecked$default(SwitchListElement switchListElement, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = true;
                }
                switchListElement.setChecked(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChecked");
        }

        public static /* synthetic */ void setSubtitle$default(SwitchListElement switchListElement, CharSequence charSequence, MovementMethod movementMethod, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    movementMethod = null;
                }
                switchListElement.setSubtitle(charSequence, movementMethod);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSubtitle");
        }
    }

    void hideToggle();

    boolean isChecked();

    boolean isSaveEnabled();

    void setChecked(boolean z, boolean z2);

    void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setEnabled(boolean z);

    void setIcon(@DrawableRes int i);

    void setSaveEnabled(boolean z);

    void setSubtitle(@Nullable CharSequence charSequence, @Nullable MovementMethod movementMethod);

    void setSwitchEnabled(boolean z);

    void setTitle(@NotNull CharSequence charSequence);

    void showToggle();
}
