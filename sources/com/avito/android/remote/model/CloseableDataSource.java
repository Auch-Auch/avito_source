package com.avito.android.remote.model;

import com.avito.konveyor.data_source.DataSource;
import java.io.Closeable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/CloseableDataSource;", "T", "Lcom/avito/konveyor/data_source/DataSource;", "Ljava/io/Closeable;", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface CloseableDataSource<T> extends DataSource<T>, Closeable {
}
