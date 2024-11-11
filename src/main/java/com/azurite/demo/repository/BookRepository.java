package com.azurite.demo.repository;

import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.models.TableEntity;
import com.azurite.demo.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final TableClient tableClient;

    public BookRepository(TableClientBuilder tableClientBuilder) {
        this.tableClient = tableClientBuilder.tableName("BooksTable").buildClient();
    }

    public void save(BookEntity bookEntity) {
        TableEntity entity = new TableEntity(bookEntity.getPartitionKey(), bookEntity.getRowKey());
        bookEntity.getProperties().forEach(entity::addProperty);
        tableClient.createEntity(entity);
    }

    public BookEntity findById(String partitionKey, String rowKey) {
        TableEntity entity = tableClient.getEntity(partitionKey, rowKey);
        BookEntity bookEntity = new BookEntity(partitionKey, rowKey);
        bookEntity.setProperties(entity.getProperties());
        return bookEntity;
    }

    public void update(BookEntity bookEntity) {
        TableEntity entity = new TableEntity(bookEntity.getPartitionKey(), bookEntity.getRowKey());
        entity.setProperties(bookEntity.getProperties());
        tableClient.updateEntity(entity);
    }

    public void delete(String partitionKey, String rowKey) {
        tableClient.deleteEntity(partitionKey, rowKey);
    }

    public List<BookEntity> findAll() {
        return tableClient.listEntities().stream().map(entity -> {
            BookEntity bookEntity = new BookEntity(entity.getPartitionKey(), entity.getRowKey());
            bookEntity.setProperties(entity.getProperties());
            return bookEntity;
        }).collect(Collectors.toList());
    }
}
