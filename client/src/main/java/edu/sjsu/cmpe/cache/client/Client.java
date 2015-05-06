package edu.sjsu.cmpe.cache.client;

import java.util.ArrayList;

/**
 * Created by ashish on 5/5/2015.
 * Consistent Hashing Client
 */


public class Client {

    public static void main(String[] args) throws Exception {

        System.out.println("                                            ");
        System.out.println(" ---- Starting Consistent Cache Client --- ");
        System.out.println("                                            ");

        ArrayList cacheServer = new ArrayList();

        cacheServer.add("http://localhost:3000");
        cacheServer.add("http://localhost:3001");
        cacheServer.add("http://localhost:3002");

        ConsistentHashSimple cHash = new ConsistentHashSimple(cacheServer);

        printStatus(" ---- Adding to cache servers ---- ");


        for(int i = 1; i<=10; i++){
            addToCache(i, String.valueOf((char) (i + 96)), cHash);
        }

        printStatus(" --- Cache Retrieved from servers ---- ");

        for(int i =1; i<=10; i++){
            String value = (String)getFromCache(i,cHash);
            System.out.println("Cache Collected : "+ value);
        }

        printStatus(" --- Exiting Consistent Cache Client --- ");


        /*printStatus("----------------------------------------------");
        printStatus("--- Starting Rendezvous/ HRW cache client --- ");

        HRWHash<String> hrwHash = new HRWHash(cacheServer);

        printStatus("--- adding to cache servers ---");

        for(int i = 1; i<=10; i++){
            addToHRWCache(i, String.valueOf((char) (i + 96)), hrwHash);
        }

        printStatus(" --- Cache Retrieved from servers ---- ");

        for(int i =1; i<=10; i++){
            String value = (String)getFromHRWCache(i, hrwHash);
            System.out.println("Cache Collected : " + value);
        }*/

    }

    public static void addToCache(int toAddKey, String toAddValue, ConsistentHashSimple cHash){
        String cacheUrl = (String) cHash.getCache(toAddKey);
        CacheServiceInterface cache = new DistributedCacheService(cacheUrl);
        cache.put(toAddKey,toAddValue);
        System.out.println("put( "+ toAddKey +" => " + toAddValue + ")");
    }

    public static Object getFromCache(int key, ConsistentHashSimple cHash){
        String cacheUrl = (String) cHash.getCache(key);
        CacheServiceInterface cache = new DistributedCacheService(cacheUrl);
        String value = cache.get(key);
        System.out.println("get( "+ key+ " ) => "+ value);
        return value;
    }




   /* public static void addToHRWCache(int toAddKey, String toAddValue, HRWHash hrwHash){
        String cacheUrl = (String) hrwHash.getCache(toAddKey);
        CacheServiceInterface cache = new DistributedCacheService(cacheUrl);
        cache.put(toAddKey,toAddValue);
        System.out.println("put( " + toAddKey + " => " + toAddValue + ")");

    }
    public static Object getFromHRWCache(int key, HRWHash hrwHash){
        String cacheUrl = (String) hrwHash.getCache(key);
        CacheServiceInterface cache = new DistributedCacheService(cacheUrl);
        String value = cache.get(key);
        System.out.println("get( "+ key+ " ) => "+ value);
        return value;
    }*/
    public static void printStatus(String status){
        System.out.println("                                            ");
        System.out.println(status);
        System.out.println("                                            ");
    }

}
