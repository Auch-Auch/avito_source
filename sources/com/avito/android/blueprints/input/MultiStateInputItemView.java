package com.avito.android.blueprints.input;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.FormattableInputView;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001d\u0010\bJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00112\b\b\u0001\u0010#\u001a\u00020\u0011H&¢\u0006\u0004\b$\u0010\u0015J\u001d\u0010'\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H&¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00112\b\b\u0001\u0010#\u001a\u00020\u0011H&¢\u0006\u0004\b)\u0010\u0015J\u001d\u0010*\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H&¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020\u0006H&¢\u0006\u0004\b+\u0010\u0017J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0011H&¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/util/FormattableInputView;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "value", "setValueIfDistinct", "", "minLines", "maxLines", "setMultiLine", "(II)V", "setSingleLine", "()V", "prefix", "setPrefix", "postfix", "setPostfix", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "icon", "colorAttr", "setRightIcon", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRightIconClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLeftIcon", "setLeftIconClickListener", "showKeyboard", "limit", "setMaxLength", "(I)V", "", "selectionToEnd", "setSelectionToEndOnFocus", "(Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateInputItemView extends ItemView, FormattableInputView, HtmlEditorItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiStateInputItemView multiStateInputItemView) {
            ItemView.DefaultImpls.onUnbind(multiStateInputItemView);
        }

        public static /* synthetic */ void setMultiLine$default(MultiStateInputItemView multiStateInputItemView, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = Integer.MAX_VALUE;
                }
                multiStateInputItemView.setMultiLine(i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMultiLine");
        }
    }

    void setErrorState(@NotNull CharSequence charSequence);

    void setInputType(@NotNull FormatterType formatterType);

    void setLeftIcon(@DrawableRes int i, @AttrRes int i2);

    void setLeftIconClickListener(@NotNull Function0<Unit> function0);

    void setMaxLength(int i);

    void setMultiLine(int i, int i2);

    void setNormalState(@Nullable CharSequence charSequence);

    void setPlaceholder(@Nullable String str);

    void setPostfix(@Nullable String str);

    void setPrefix(@Nullable String str);

    void setRightIcon(@DrawableRes int i, @AttrRes int i2);

    void setRightIconClickListener(@NotNull Function0<Unit> function0);

    void setSelectionToEndOnFocus(boolean z);

    void setSingleLine();

    void setTitle(@NotNull String str);

    void setValueIfDistinct(@Nullable String str);

    void setWarningState(@NotNull CharSequence charSequence);

    void showKeyboard();
}
