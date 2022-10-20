package com.allog.dallog.global.config.replication;

import static com.allog.dallog.global.config.replication.DataSourceKey.SOURCE;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    private final CircularReplicaKeys circularReplicaKeys = new CircularReplicaKeys();

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        if (isReadOnly) {
            return circularReplicaKeys.next();
        }

        return SOURCE;
    }
}
