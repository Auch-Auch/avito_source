package net.gotev.uploadservice.persistence;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/persistence/Persistable;", "", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toPersistableData", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "Creator", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface Persistable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "T", "", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "createFromPersistableData", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Ljava/lang/Object;", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public interface Creator<T> {
        T createFromPersistableData(@NotNull PersistableData persistableData);
    }

    @NotNull
    PersistableData toPersistableData();
}
