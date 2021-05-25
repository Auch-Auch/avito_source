package com.avito.android.items;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.category_parameters.TitleHidingElement;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0018\u0010%\u001a\u0004\u0018\u00010\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u0018\u0010)\u001a\u0004\u0018\u00010&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0019R\u0016\u0010/\u001a\u00020,8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u00102\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\fR\u0018\u00104\u001a\u0004\u0018\u00010\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0019¨\u00065"}, d2 = {"Lcom/avito/android/items/InputItem;", "Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithMotivation;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "Lcom/avito/android/items/ItemWithHtmlSupport;", "Lcom/avito/android/items/ItemWithAdditionalButton;", "", "error", "", "applyError", "(Ljava/lang/String;)V", "clearErrors", "()V", "", "getLabelMode", "()Ljava/lang/Integer;", "getLabelMode$annotations", "labelMode", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "getAdditionalButton", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "additionalButton", "getPrefix", "()Ljava/lang/String;", "prefix", "getLines", "()I", "lines", "Lcom/avito/android/lib/design/input/FormatterType;", "getInputType", "()Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "getAndroidSdkInputType", "androidSdkInputType", "getPlaceholder", InternalConstsKt.PLACEHOLDER, "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "displayingOptions", "getTitle", "title", "", "getHasCardTopBackground", "()Z", "hasCardTopBackground", "getValue", "setValue", "value", "getPostfix", "postfix", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface InputItem extends BasicInputItem, ItemWithErrors, ItemWithState, ItemWithMotivation, TitleHidingElement, ItemWithHtmlSupport, ItemWithAdditionalButton {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void applyError(@NotNull InputItem inputItem, @Nullable String str) {
            inputItem.setError(str);
            inputItem.setBubbleError(str);
            String value = inputItem.getValue();
            boolean z = false;
            if (!(value == null || value.length() == 0)) {
                if (!(str == null || str.length() == 0)) {
                    inputItem.setError(inputItem.getValue());
                    return;
                }
            }
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z) {
                inputItem.setError(inputItem.getTitle());
            }
        }

        public static void clearErrors(@NotNull InputItem inputItem) {
            ItemWithErrors.DefaultImpls.clearErrors(inputItem);
            inputItem.setState(new ItemWithState.State.Normal(null, 1, null));
        }

        public static long getId(@NotNull InputItem inputItem) {
            return BasicInputItem.DefaultImpls.getId(inputItem);
        }

        public static /* synthetic */ void getLabelMode$annotations() {
        }
    }

    void applyError(@Nullable String str);

    @Override // com.avito.android.items.ItemWithErrors
    void clearErrors();

    @Override // com.avito.android.items.ItemWithAdditionalButton
    @Nullable
    ItemWithAdditionalButton.AdditionalButton getAdditionalButton();

    int getAndroidSdkInputType();

    @Nullable
    DisplayingOptions getDisplayingOptions();

    boolean getHasCardTopBackground();

    @NotNull
    FormatterType getInputType();

    @Nullable
    Integer getLabelMode();

    int getLines();

    @Nullable
    String getPlaceholder();

    @Nullable
    String getPostfix();

    @Nullable
    String getPrefix();

    @NotNull
    String getTitle();

    @Override // com.avito.android.items.BasicInputItem
    @Nullable
    String getValue();

    @Override // com.avito.android.items.BasicInputItem
    void setValue(@Nullable String str);
}
