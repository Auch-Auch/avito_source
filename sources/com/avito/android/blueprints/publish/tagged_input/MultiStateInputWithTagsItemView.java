package com.avito.android.blueprints.publish.tagged_input;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.ui.widget.tagged_input.TagsConsumerView;
import com.avito.android.ui.widget.tagged_input.TagsListView;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u001e\u001a\u00020\u0011H&¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH&¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0011H&¢\u0006\u0004\b'\u0010\u0014J\u001d\u0010(\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!H&¢\u0006\u0004\b(\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView;", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/ui/widget/tagged_input/TagsListView;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "", "minLines", "setMultiLine", "(I)V", "setSingleLine", "()V", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "icon", "colorAttr", "setRightIcon", "(II)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRightIconClickListener", "(Lkotlin/jvm/functions/Function0;)V", "showKeyboard", "limit", "setMaxLength", "setOnUnbindListener", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateInputWithTagsItemView extends TagsConsumerView, TagsConsumerView.TextInserter, ItemView, TagsListView, HtmlEditorItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiStateInputWithTagsItemView multiStateInputWithTagsItemView) {
            ItemView.DefaultImpls.onUnbind(multiStateInputWithTagsItemView);
        }
    }

    void setErrorState(@NotNull CharSequence charSequence);

    void setInputType(@NotNull FormatterType formatterType);

    void setMaxLength(int i);

    void setMultiLine(int i);

    void setNormalState(@Nullable CharSequence charSequence);

    void setOnUnbindListener(@NotNull Function0<Unit> function0);

    void setPlaceholder(@Nullable String str);

    void setRightIcon(@DrawableRes int i, @AttrRes int i2);

    void setRightIconClickListener(@NotNull Function0<Unit> function0);

    void setSingleLine();

    void setTitle(@Nullable String str);

    void setWarningState(@NotNull CharSequence charSequence);

    void showKeyboard();
}
