package org.reindexer.examples;

import org.reindexer.connector.Reindexer;
import org.reindexer.connector.options.NamespaceOptions;
import org.reindexer.examples.model.Item;

import java.util.HashSet;
import java.util.Random;

public class Example {

    public static void main(String[] args) {

        // Init a database instance and choose the binding (builtin)
        //Reindex db = Reindex.newReindexer("builtin:///tmp/reindex/testdb");

        // OR - Init a database instance and choose the binding (connect to server)
        Reindexer db = Reindexer.newReindexer("cproto://127.0.0.1:6534/z");

        // OR - Init a database instance and choose the binding (connect to server by REST API)
        //Reindex db = Reindex.newReindexer("http://localhost:9088/api/v1/db/z");

        // OR - Init a database instance and choose the binding (builtin, with bundled server)
        //serverConfig := config.DefaultServerConfig()
        //Reindex db = Reindex.newReindexer("builtinserver://testdb");

        db.openNamespace("items", NamespaceOptions.defaultOptions(), Item.class);


        // Generate dataset
        for (int i = 0; i < 5; i++) {
            db.upsert("items", new Item(
                    i,
                    "Vasya"/*,
                    new HashSet<Integer>() {{
                        add(new Random().nextInt(100));
                        add(new Random().nextInt(100));
                    }},
                    2000 + new Random().nextInt(50)*/
            ));
            System.out.print("*");
        }
/*
        // Query a single document
        {
            Item item = db.Query("items").
                    Where("id", reindexer.EQ, 40).
                    Get();

            if (item != null) {
                System.out.println("Found document: " + item.toString());
            }
        }

        // Query multiple documents
        Query query = db.Query("items").Class(Item.class).
                Sort("year", false).                          // Sort results by 'year' field in ascending order
                WhereString("name", reindexer.EQ, "Vasya").   // 'name' must be 'Vasya'
                WhereInt("year", reindexer.GT, 2020).         // 'year' must be greater than 2020
                WhereInt("articles", reindexer.SET, 6, 1, 8). // 'articles' must contain one of [6,1,8]
                Limit(10).                                    // Return maximum 10 documents
                Offset(0).                                    // from 0 position
                ReqTotal();                                    // Calculate the total count of matching documents

        Iterator<Item> iterator;
        try {
            // Execute the query and return an iterator
            iterator = query.Exec();

            System.out.println(String.format("Found %d total documents, first %d documents: ",
                    iterator.TotalCount(), iterator.Count()));

            // Iterate over results
            while (iterator.Next()) {
                // Get the next document and cast it to a pointer
                Item item = (Item)iterator.Object();
                System.out.println(item.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
            // Check the error
        }
*/
    }
}