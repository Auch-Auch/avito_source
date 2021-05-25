package com.avito.android.profile.edit.refactoring.adapter;

import com.avito.konveyor.blueprint.ItemView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.EditTextSingleLine;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/EditTextSingleLineItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lru/avito/component/text_input/EditTextSingleLine;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditTextSingleLineItemView extends ItemView, EditTextSingleLine {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Observable<Integer> actionCallbacks(@NotNull EditTextSingleLineItemView editTextSingleLineItemView) {
            return EditTextSingleLine.DefaultImpls.actionCallbacks(editTextSingleLineItemView);
        }

        @NotNull
        public static Observable<Unit> doneCallbacks(@NotNull EditTextSingleLineItemView editTextSingleLineItemView) {
            return EditTextSingleLine.DefaultImpls.doneCallbacks(editTextSingleLineItemView);
        }

        public static void onUnbind(@NotNull EditTextSingleLineItemView editTextSingleLineItemView) {
            ItemView.DefaultImpls.onUnbind(editTextSingleLineItemView);
        }
    }
}
