package com.avito.android.publish.slots.auto_sort_photos;

import com.avito.android.items.CheckBoxItem;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotValue;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/slots/auto_sort_photos/AutoSortPhotosSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "", "getId", "()Ljava/lang/String;", "", "getElements", "()Ljava/util/List;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;", "slot", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "photoParam", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AutoSortPhotosSlotWrapper implements SlotWrapper<AutoSortPhotosSlot> {
    public final PhotoParameter a;
    @NotNull
    public final AutoSortPhotosSlot b;

    public AutoSortPhotosSlotWrapper(@NotNull AutoSortPhotosSlot autoSortPhotosSlot, @Nullable CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(autoSortPhotosSlot, "slot");
        this.b = autoSortPhotosSlot;
        this.a = categoryParameters != null ? (PhotoParameter) ((CategoryParameter) categoryParameters.getFirstParameterOfType(PhotoParameter.class)) : null;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        if (!(item instanceof CheckBoxItem)) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        }
        if (!Intrinsics.areEqual(getSlot().getId(), item.getStringId())) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        }
        CheckBoxItem checkBoxItem = (CheckBoxItem) item;
        ((AutoSortPhotosSlotConfig) getSlot().getWidget().getConfig()).getField().setValue(Boolean.valueOf(checkBoxItem.isChecked()));
        AutoSortPhotosSlotValue value = getSlot().getValue();
        if (value != null) {
            value.setAutoSortImages(Boolean.valueOf(checkBoxItem.isChecked()));
        }
        return new ConsumeValueChangeResult.NeedViewUpdate(SlotType.AUTO_SORT_PHOTOS);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0086: APUT  
      (r4v0 com.avito.conveyor_item.Item[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.items.CheckBoxItem : 0x0083: CONSTRUCTOR  (r16v0 com.avito.android.items.CheckBoxItem) = 
      (r6v0 java.lang.String)
      (r7v0 java.lang.String)
      (r8v0 boolean)
      (wrap: com.avito.android.remote.model.text.AttributedText : 0x0061: INVOKE  (r9v0 com.avito.android.remote.model.text.AttributedText) = (r1v6 com.avito.android.remote.model.category_parameters.BooleanParameter) type: VIRTUAL call: com.avito.android.remote.model.category_parameters.BooleanParameter.getSubtitle():com.avito.android.remote.model.text.AttributedText)
      (null com.avito.android.items.ItemWithState$State)
      (null com.avito.android.remote.model.text.AttributedText)
      (wrap: java.lang.String : 0x0079: INVOKE  (r12v0 java.lang.String) = 
      (wrap: com.avito.android.remote.model.category_parameters.BooleanParameter : 0x0075: INVOKE  (r1v11 com.avito.android.remote.model.category_parameters.BooleanParameter) = 
      (wrap: com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig : 0x0073: CHECK_CAST (r1v10 com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig) = (com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig) (wrap: com.avito.android.remote.model.category_parameters.slot.SlotConfig : 0x006f: INVOKE  (r1v9 com.avito.android.remote.model.category_parameters.slot.SlotConfig) = 
      (wrap: com.avito.android.remote.model.category_parameters.slot.SlotWidget : 0x006b: INVOKE  (r1v8 com.avito.android.remote.model.category_parameters.slot.SlotWidget) = 
      (wrap: com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot : 0x0067: INVOKE  (r1v7 com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot) = (r17v0 'this' com.avito.android.publish.slots.auto_sort_photos.AutoSortPhotosSlotWrapper A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.avito.android.publish.slots.auto_sort_photos.AutoSortPhotosSlotWrapper.getSlot():com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot)
     type: VIRTUAL call: com.avito.android.remote.model.category_parameters.slot.Slot.getWidget():com.avito.android.remote.model.category_parameters.slot.SlotWidget)
     type: VIRTUAL call: com.avito.android.remote.model.category_parameters.slot.SlotWidget.getConfig():com.avito.android.remote.model.category_parameters.slot.SlotConfig))
     type: VIRTUAL call: com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig.getField():com.avito.android.remote.model.category_parameters.BooleanParameter)
     type: VIRTUAL call: com.avito.android.remote.model.category_parameters.BooleanParameter.getHeader():java.lang.String)
      false
      (176 int)
      (null t6.r.a.j)
     call: com.avito.android.items.CheckBoxItem.<init>(java.lang.String, java.lang.String, boolean, com.avito.android.remote.model.text.AttributedText, com.avito.android.items.ItemWithState$State, com.avito.android.remote.model.text.AttributedText, java.lang.String, boolean, int, t6.r.a.j):void type: CONSTRUCTOR)
     */
    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        Boolean bool;
        PhotoParameter.ImageUploadListWrapper imageUploadListWrapper;
        PhotoParameter photoParameter = this.a;
        if (((photoParameter == null || (imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) photoParameter.getValue()) == null) ? 0 : imageUploadListWrapper.size()) < 2) {
            return new ArrayList();
        }
        BooleanParameter field = ((AutoSortPhotosSlotConfig) getSlot().getWidget().getConfig()).getField();
        Item[] itemArr = new Item[1];
        String id = getSlot().getId();
        String title = field.getTitle();
        AutoSortPhotosSlotValue value = getSlot().getValue();
        if (value == null || (bool = value.getAutoSortImages()) == null) {
            bool = (Boolean) field.getValue();
        }
        itemArr[0] = new CheckBoxItem(id, title, bool != null ? bool.booleanValue() : true, field.getSubtitle(), null, null, ((AutoSortPhotosSlotConfig) getSlot().getWidget().getConfig()).getField().getHeader(), false, 176, null);
        return CollectionsKt__CollectionsKt.mutableListOf(itemArr);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        return SlotWrapper.DefaultImpls.prepare(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public AutoSortPhotosSlot getSlot() {
        return this.b;
    }
}
