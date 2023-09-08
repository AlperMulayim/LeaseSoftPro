package com.alper.leasesoftprov2.leasesoft.mappers;

import jakarta.transaction.NotSupportedException;

public interface IEntityMapper <E,D>{
    D toDTO(E e) throws NotSupportedException;
    E toEntity(D d) throws NotSupportedException;
}
