package com.avito.konveyor.data_source;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/konveyor/data_source/DataSource;", "T", "", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Ljava/lang/Object;", "getCount", "()I", "count", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface DataSource<T> {
    int getCount();

    T getItem(int i);

    boolean isEmpty();
}
