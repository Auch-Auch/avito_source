package com.avito.android.blueprints.publish;

import android.content.Context;
import android.text.TextWatcher;
import androidx.annotation.ColorRes;
import com.avito.android.remote.model.Color;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001cH&¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010!J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H&¢\u0006\u0004\b(\u0010!J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020\u0004H&¢\u0006\u0004\b*\u0010!J\u000f\u0010+\u001a\u00020\u0004H&¢\u0006\u0004\b+\u0010!J\u000f\u0010,\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010!J\u001d\u0010.\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040-H&¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0018H&¢\u0006\u0004\b1\u0010\u001bR\u0016\u00105\u001a\u0002028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "number", "setNumber", "region", "setRegion", "", "colorRes", "setBackgroundColor", "(I)V", "Lcom/avito/android/remote/model/Color;", "color", "(Lcom/avito/android/remote/model/Color;)V", "", "isEmpty", "setIsEmpty", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnNumberChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "removeOnNumberChangedListener", "()V", "setOnRegionChangedListener", "removeOnRegionChangedListener", "Landroid/text/TextWatcher;", "textWatcher", "setNumberTextWatcher", "(Landroid/text/TextWatcher;)V", "removeNumberTextWatcher", "setRegionTextWatcher", "removeRegionTextWatcher", "showKeyboardForNumber", "showKeyboardForRegion", "Lkotlin/Function0;", "setOnUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "enabled", "setEnabled", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface VehicleRegNumberInputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull VehicleRegNumberInputItemView vehicleRegNumberInputItemView) {
            ItemView.DefaultImpls.onUnbind(vehicleRegNumberInputItemView);
        }
    }

    @NotNull
    Context getContext();

    void removeNumberTextWatcher();

    void removeOnNumberChangedListener();

    void removeOnRegionChangedListener();

    void removeRegionTextWatcher();

    void setBackgroundColor(@ColorRes int i);

    void setBackgroundColor(@NotNull Color color);

    void setEnabled(boolean z);

    void setErrorState(@NotNull CharSequence charSequence);

    void setIsEmpty(boolean z);

    void setNormalState(@Nullable CharSequence charSequence);

    void setNumber(@Nullable String str);

    void setNumberTextWatcher(@NotNull TextWatcher textWatcher);

    void setOnNumberChangedListener(@NotNull Function1<? super String, Unit> function1);

    void setOnRegionChangedListener(@NotNull Function1<? super String, Unit> function1);

    void setOnUnbindListener(@NotNull Function0<Unit> function0);

    void setRegion(@Nullable String str);

    void setRegionTextWatcher(@NotNull TextWatcher textWatcher);

    void setTitle(@NotNull String str);

    void setWarningState(@NotNull CharSequence charSequence);

    void showKeyboardForNumber();

    void showKeyboardForRegion();
}
