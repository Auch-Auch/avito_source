package ru.sravni.android.bankproduct.repository;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/sravni/android/bankproduct/repository/EmptyCardListException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class EmptyCardListException extends Exception {
    public EmptyCardListException() {
        super("Try call next on empty cards list");
    }
}
