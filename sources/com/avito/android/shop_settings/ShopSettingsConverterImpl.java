package com.avito.android.shop_settings;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.MaskParameters;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettings;
import com.avito.android.remote.model.ShopSettingsAlert;
import com.avito.android.remote.model.ShopSettingsElement;
import com.avito.android.remote.model.ShopSettingsForm;
import com.avito.android.remote.model.ShopSettingsModerationError;
import com.avito.android.remote.model.ShopSettingsSection;
import com.avito.android.remote.model.ShopSettingsValidationError;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItem;
import com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItem;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItem;
import com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItem;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItem;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItem;
import com.avito.android.shop_settings.blueprints.section_title.ShopSettingsSectionTitleItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.blueprints.separator.ShopSettingsSeparatorItem;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItem;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsConverterImpl;", "Lcom/avito/android/shop_settings/ShopSettingsConverter;", "Lcom/avito/android/remote/model/ShopSettings;", "shopSettings", "Lcom/avito/android/shop_settings/ShopSettingsViewData;", "convert", "(Lcom/avito/android/remote/model/ShopSettings;)Lcom/avito/android/shop_settings/ShopSettingsViewData;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "Lcom/avito/android/lib/design/input/FormatterType;", "formatterType", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "d", "(Lcom/avito/android/remote/model/ShopSettingsElement$Input;Lcom/avito/android/lib/design/input/FormatterType;)Ljava/util/List;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/ShopSettingsElement$Input;)Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "c", "(Lcom/avito/android/remote/model/ShopSettingsElement$Input;)Ljava/lang/String;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasErrors;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/ShopSettingsElement$HasErrors;)Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsConverterImpl implements ShopSettingsConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ShopSettingsAlert.Style.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ShopSettingsAlert.Style style = ShopSettingsAlert.Style.Confirmation;
            iArr[2] = 1;
            ShopSettingsAlert.Style style2 = ShopSettingsAlert.Style.Alert;
            iArr[0] = 2;
            ShopSettingsAlert.Style style3 = ShopSettingsAlert.Style.Message;
            iArr[1] = 3;
        }
    }

    public static /* synthetic */ List e(ShopSettingsConverterImpl shopSettingsConverterImpl, ShopSettingsElement.Input input, FormatterType formatterType, int i) {
        FormatterType formatterType2;
        if ((i & 1) != 0) {
            String prefix = input.getPrefix();
            if (prefix == null) {
                prefix = "";
            }
            formatterType2 = new FormatterType(0, null, null, new MaskParameters(prefix, false, null, "", false, null, false, false, null, null, 0, 0, 4086, null), 6, null);
        } else {
            formatterType2 = null;
        }
        return shopSettingsConverterImpl.d(input, formatterType2);
    }

    public final ShopSettingsItem a(ShopSettingsElement.Input input) {
        ShopSettingsModerationError moderationError = input.getModerationError();
        if (moderationError != null) {
            return new ShopSettingsModerationErrorItem(a.c3(input.getId(), "_moderation_error"), moderationError.getTitle(), moderationError.getSubtitle());
        }
        return null;
    }

    public final ShopSettingsInputItem.State b(ShopSettingsElement.HasErrors hasErrors) {
        if (hasErrors.getValidationError() != null) {
            return ShopSettingsInputItem.State.Error;
        }
        if (hasErrors.getModerationError() != null) {
            return ShopSettingsInputItem.State.Warning;
        }
        return ShopSettingsInputItem.State.Normal;
    }

    public final String c(ShopSettingsElement.Input input) {
        String title;
        ShopSettingsValidationError validationError = input.getValidationError();
        return (validationError == null || (title = validationError.getTitle()) == null) ? input.getSuggestion() : title;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x01b5: APUT  
      (r13v9 com.avito.android.shop_settings.blueprints.ShopSettingsItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItem : 0x01b1: CONSTRUCTOR  (r14v13 com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItem) = 
      (r18v3 java.lang.String)
      (r19v3 java.lang.String)
      (r20v7 java.lang.String)
      (r21v3 java.lang.String)
      (r22v3 com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State)
      (r23v2 java.lang.String)
      (r24v2 boolean)
      (r25v2 boolean)
      (r26v2 boolean)
     call: com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State, java.lang.String, boolean, boolean, boolean):void type: CONSTRUCTOR)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0221: APUT  
      (r13v7 com.avito.android.shop_settings.blueprints.ShopSettingsItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem : 0x021d: CONSTRUCTOR  (r14v11 com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem) = 
      (r18v2 java.lang.String)
      (r19v2 java.lang.String)
      (r20v4 java.lang.String)
      (r21v2 java.lang.String)
      (r22v2 java.lang.String)
      (r15v10 java.util.List<java.lang.String>)
      (r24v1 java.lang.String)
      (r25v1 com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State)
      (r26v1 java.lang.String)
      (r27v3 boolean)
      (r28v0 boolean)
     call: com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State, java.lang.String, boolean, boolean):void type: CONSTRUCTOR)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0280: APUT  
      (r13v5 com.avito.android.shop_settings.blueprints.ShopSettingsItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem : 0x027c: CONSTRUCTOR  (r14v9 com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem) = 
      (r18v1 java.lang.String)
      (r19v1 java.lang.String)
      (r20v1 java.lang.String)
      (r21v1 java.lang.String)
      (r22v1 java.lang.String)
      (r23v0 java.lang.String)
      (r24v0 com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State)
      (r25v0 java.lang.String)
      (r26v0 boolean)
      (r27v0 boolean)
     call: com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State, java.lang.String, boolean, boolean):void type: CONSTRUCTOR)
     */
    @Override // com.avito.android.shop_settings.ShopSettingsConverter
    @NotNull
    public ShopSettingsViewData convert(@NotNull ShopSettings shopSettings) {
        String str;
        Iterator it;
        List<ShopSettingsItem> list;
        String str2;
        String str3;
        String str4;
        ShopSettingsAlertItem.Style style;
        ShopSettingsConverterImpl shopSettingsConverterImpl = this;
        Intrinsics.checkNotNullParameter(shopSettings, "shopSettings");
        ArrayList arrayList = new ArrayList();
        ShopSettingsAlert alert = shopSettings.getAlert();
        if (alert != null) {
            String title = alert.getTitle();
            String subtitle = alert.getSubtitle();
            int ordinal = alert.getStyle().ordinal();
            if (ordinal == 0) {
                style = ShopSettingsAlertItem.Style.Alert;
            } else if (ordinal == 1) {
                style = ShopSettingsAlertItem.Style.Message;
            } else if (ordinal == 2) {
                style = ShopSettingsAlertItem.Style.Confirmation;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(new ShopSettingsAlertItem("alert", title, subtitle, style));
        }
        String info = shopSettings.getInfo();
        if (info != null) {
            arrayList.add(new ShopSettingsSectionTitleItem("info", info));
        }
        Iterable withIndex = CollectionsKt___CollectionsKt.withIndex(shopSettings.getForm());
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = withIndex.iterator();
        while (it2.hasNext()) {
            IndexedValue indexedValue = (IndexedValue) it2.next();
            int component1 = indexedValue.component1();
            ShopSettingsForm shopSettingsForm = (ShopSettingsForm) indexedValue.component2();
            ArrayList arrayList3 = new ArrayList();
            String title2 = shopSettingsForm.getTitle();
            if (title2 != null) {
                arrayList3.add(new ShopSettingsFormTitleItem(a.M2("form_title_", component1), title2));
            }
            Iterable<IndexedValue> withIndex2 = CollectionsKt___CollectionsKt.withIndex(shopSettingsForm.getSections());
            ArrayList arrayList4 = new ArrayList();
            for (IndexedValue indexedValue2 : withIndex2) {
                int component12 = indexedValue2.component1();
                ShopSettingsSection shopSettingsSection = (ShopSettingsSection) indexedValue2.component2();
                ArrayList arrayList5 = new ArrayList();
                if (component12 > 0) {
                    StringBuilder sb = new StringBuilder();
                    it = it2;
                    sb.append("separator");
                    sb.append('_');
                    sb.append(component1);
                    sb.append('_');
                    sb.append(component12);
                    arrayList5.add(new ShopSettingsSeparatorItem(sb.toString()));
                } else {
                    it = it2;
                }
                String title3 = shopSettingsSection.getTitle();
                if (title3 != null) {
                    arrayList5.add(new ShopSettingsSectionTitleItem("section_title_" + component1 + '_' + component12, title3));
                }
                Iterable<IndexedValue> withIndex3 = CollectionsKt___CollectionsKt.withIndex(shopSettingsSection.getItems());
                ArrayList arrayList6 = new ArrayList();
                for (IndexedValue indexedValue3 : withIndex3) {
                    int component13 = indexedValue3.component1();
                    ShopSettingsElement shopSettingsElement = (ShopSettingsElement) indexedValue3.component2();
                    if (shopSettingsElement instanceof ShopSettingsElement.SingleLine) {
                        list = e(shopSettingsConverterImpl, (ShopSettingsElement.Input) shopSettingsElement, null, 1);
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Phone) {
                        list = shopSettingsConverterImpl.d((ShopSettingsElement.Input) shopSettingsElement, FormatterType.Companion.getMOBILE_PHONE());
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Domain) {
                        list = e(shopSettingsConverterImpl, (ShopSettingsElement.Input) shopSettingsElement, null, 1);
                    } else if (shopSettingsElement instanceof ShopSettingsElement.MultiLine) {
                        ShopSettingsElement.Input input = (ShopSettingsElement.Input) shopSettingsElement;
                        ShopSettingsItem[] shopSettingsItemArr = new ShopSettingsItem[2];
                        String id = input.getId();
                        String title4 = input.getTitle();
                        String text = input.getText();
                        if (text != null) {
                            str4 = text;
                        } else {
                            str4 = "";
                        }
                        shopSettingsItemArr[0] = new ShopSettingsMultiLineInputItem(id, title4, str4, shopSettingsConverterImpl.c(input), shopSettingsConverterImpl.b(input), input.getPlaceholder(), input.isConfirmed(), input.isModifiable(), (input.getModerationError() == null && input.getValidationError() == null) ? false : true);
                        shopSettingsItemArr[1] = shopSettingsConverterImpl.a(input);
                        list = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) shopSettingsItemArr);
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Select) {
                        ShopSettingsElement.Select select = (ShopSettingsElement.Select) shopSettingsElement;
                        ShopSettingsItem[] shopSettingsItemArr2 = new ShopSettingsItem[2];
                        String id2 = select.getId();
                        String title5 = select.getTitle();
                        String text2 = select.getText();
                        if (text2 != null) {
                            str3 = text2;
                        } else {
                            str3 = "";
                        }
                        String selectContext = select.getSelectContext();
                        String value = select.getValue();
                        List<String> parentValues = select.getParentValues();
                        if (parentValues == null) {
                            parentValues = CollectionsKt__CollectionsKt.emptyList();
                        }
                        shopSettingsItemArr2[0] = new ShopSettingsSelectItem(id2, title5, str3, selectContext, value, parentValues, shopSettingsConverterImpl.c(select), shopSettingsConverterImpl.b(select), select.getPlaceholder(), select.isModifiable(), (select.getModerationError() == null && select.getValidationError() == null) ? false : true);
                        shopSettingsItemArr2[1] = shopSettingsConverterImpl.a(select);
                        list = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) shopSettingsItemArr2);
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Address) {
                        ShopSettingsElement.Address address = (ShopSettingsElement.Address) shopSettingsElement;
                        ShopSettingsItem[] shopSettingsItemArr3 = new ShopSettingsItem[2];
                        String id3 = address.getId();
                        String title6 = address.getTitle();
                        String text3 = address.getText();
                        if (text3 != null) {
                            str2 = text3;
                        } else {
                            str2 = "";
                        }
                        shopSettingsItemArr3[0] = new ShopSettingsAddressItem(id3, title6, str2, address.getLatitude(), address.getLongitude(), shopSettingsConverterImpl.c(address), shopSettingsConverterImpl.b(address), address.getPlaceholder(), address.isModifiable(), (address.getModerationError() == null && address.getValidationError() == null) ? false : true);
                        shopSettingsItemArr3[1] = shopSettingsConverterImpl.a(address);
                        list = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) shopSettingsItemArr3);
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Switcher) {
                        ShopSettingsElement.Switcher switcher = (ShopSettingsElement.Switcher) shopSettingsElement;
                        list = d.listOf(new ShopSettingsSwitcherItem(switcher.getId(), switcher.getTitle(), switcher.getSubtitle(), switcher.isEnabled(), switcher.isModifiable()));
                    } else if (shopSettingsElement instanceof ShopSettingsElement.TitleSubtitle) {
                        ShopSettingsElement.TitleSubtitle titleSubtitle = (ShopSettingsElement.TitleSubtitle) shopSettingsElement;
                        list = d.listOf(new ShopSettingsTitleSubtitleItem("title_subtitle_" + component1 + '_' + component12 + '_' + component13, titleSubtitle.getTitle(), titleSubtitle.getSubtitle()));
                    } else if (shopSettingsElement instanceof ShopSettingsElement.Unknown) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    h.addAll(arrayList6, list);
                    shopSettingsConverterImpl = this;
                }
                arrayList5.addAll(arrayList6);
                h.addAll(arrayList4, arrayList5);
                shopSettingsConverterImpl = this;
                it2 = it;
            }
            arrayList3.addAll(arrayList4);
            h.addAll(arrayList2, arrayList3);
            shopSettingsConverterImpl = this;
        }
        arrayList.addAll(arrayList2);
        String title7 = shopSettings.getTitle();
        if (title7 != null) {
            str = title7;
        } else {
            str = "";
        }
        return new ShopSettingsViewData(str, arrayList, new ShopSettingsSaveButtonItem("save_button", shopSettings.getButton().getTitle(), false, false), new ShopSettingsSaveButtonData(true, false, shopSettings.getButton().getTitle()), shopSettings.getButton().isFloating());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0043: APUT  
      (r0v1 com.avito.android.shop_settings.blueprints.ShopSettingsItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItem : 0x0040: CONSTRUCTOR  (r12v0 com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItem) = 
      (r2v0 java.lang.String)
      (r3v0 java.lang.String)
      (r1v1 java.lang.String)
      (r5v0 java.lang.String)
      (r6v0 com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State)
      (r7v0 java.lang.String)
      (r8v0 boolean)
      (r9v0 boolean)
      (r10v0 boolean)
      (r17v0 com.avito.android.lib.design.input.FormatterType)
     call: com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem$State, java.lang.String, boolean, boolean, boolean, com.avito.android.lib.design.input.FormatterType):void type: CONSTRUCTOR)
     */
    public final List<ShopSettingsItem> d(ShopSettingsElement.Input input, FormatterType formatterType) {
        ShopSettingsItem[] shopSettingsItemArr = new ShopSettingsItem[2];
        String id = input.getId();
        String title = input.getTitle();
        String text = input.getText();
        if (text == null) {
            text = "";
        }
        shopSettingsItemArr[0] = new ShopSettingsSingleLineInputItem(id, title, text, c(input), b(input), input.getPlaceholder(), input.isConfirmed(), input.isModifiable(), (input.getModerationError() == null && input.getValidationError() == null) ? false : true, formatterType);
        shopSettingsItemArr[1] = a(input);
        return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) shopSettingsItemArr);
    }
}
