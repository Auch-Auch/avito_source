package com.avito.android.messenger.channels.mvi.view;

import android.content.Context;
import android.content.Intent;
import com.avito.android.messenger.map.viewing.PlatformMapActivity;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.text.AttributedText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import t6.n.e;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelsFragmentKt {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005d: APUT  
      (r3v0 com.avito.android.remote.model.messenger.geo.GeoMarker[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.remote.model.messenger.geo.GeoMarker : 0x005a: CONSTRUCTOR  (r4v3 com.avito.android.remote.model.messenger.geo.GeoMarker) = 
      (55.7558d double)
      (37.6173d double)
      ("Адрес №1 с очень длинным заголовком, который не помещается в шторку!")
      (r5v1 java.util.ArrayList)
     call: com.avito.android.remote.model.messenger.geo.GeoMarker.<init>(double, double, java.lang.String, java.util.List):void type: CONSTRUCTOR)
     */
    public static final Intent access$createPlatformMapIntentForDebug(Context context) {
        PlatformMapActivity.Companion companion = PlatformMapActivity.Companion;
        GeoMarker[] geoMarkerArr = new GeoMarker[3];
        List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\n                                ").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(split$default, 10));
        for (String str : split$default) {
            arrayList.add(new AttributedText(str, CollectionsKt__CollectionsKt.emptyList()));
        }
        geoMarkerArr[0] = new GeoMarker(55.7558d, 37.6173d, "Адрес №1 с очень длинным заголовком, который не помещается в шторку!", arrayList);
        List<String> split$default2 = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж.\n").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(split$default2, 10));
        for (String str2 : split$default2) {
            arrayList2.add(new AttributedText(str2, CollectionsKt__CollectionsKt.emptyList()));
        }
        geoMarkerArr[1] = new GeoMarker(55.78d, 37.64d, "Адрес №2", arrayList2);
        List<String> split$default3 = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n                                ").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(split$default3, 10));
        for (String str3 : split$default3) {
            arrayList3.add(new AttributedText(str3, CollectionsKt__CollectionsKt.emptyList()));
        }
        geoMarkerArr[2] = new GeoMarker(55.765d, 37.625d, null, arrayList3);
        return PlatformMapActivity.Companion.createIntent$default(companion, context, "Platform Map Title", geoMarkerArr, null, false, 16, null);
    }
}
