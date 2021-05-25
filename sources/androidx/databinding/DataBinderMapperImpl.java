package androidx.databinding;
public class DataBinderMapperImpl extends MergedDataBinderMapper {
    public DataBinderMapperImpl() {
        addMapper(new com.avito.android.DataBinderMapperImpl());
    }
}
