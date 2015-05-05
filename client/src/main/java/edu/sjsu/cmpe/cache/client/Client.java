package edu.sjsu.cmpe.cache.client;

public class Client {

    public static void main(String[] args) throws Exception {


        static char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache = new DistributedCacheService(
                "http://localhost:3000");

        cache.put(1, "foo");
        System.out.println("put(1 => foo)");

        String value = cache.get(1);
        System.out.println("get(1) => " + value);

        System.out.println("Existing Cache Client...");
    }

}
