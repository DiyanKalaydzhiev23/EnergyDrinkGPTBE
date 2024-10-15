package com.energydrinkgpt.config;

import org.hibernate.Session;

@FunctionalInterface
public interface TransactionalOperation<T> {
    T execute(Session session);
}
