package com.example.demo.migrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@ChangeLog
public class MongoChangelog {
    @ChangeSet(order = "001", id = "0001", author = "testAuthor")
    public void importantWorkToDo(MongoDatabase db){
        MongoCollection<Document> mycollection = db.getCollection("vehicle");
        Document doc = new Document("testName", "example").append("test", "1");
        mycollection.insertOne(doc);
    }
}