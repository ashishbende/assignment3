package edu.sjsu.cmpe.cache.client;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.ArrayList;

/**
 * Created by ashish on 5/5/2015.
 *
 * This is code is inspired from the  tom whites blog post.
 *   http://www.tom-e-white.com/2007/11/consistent-hashing.html
 *
 */

public class ConsistentHashSimple<T> {

    private final HashFunction hashFunction;
    private ArrayList<T> nodeList;



    public ConsistentHashSimple(ArrayList<T> nodes){
        this.hashFunction = Hashing.md5();
        nodeList  = new ArrayList<T>();
        nodeList.addAll(nodes);
        System.out.println(" Current Cache-Node list : " + nodeList);
    }

    public void add(T node){
        nodeList.add(node);
    }

    public void remove(T node){
        nodeList.remove(node);
    }

    public T getCache(Object key){
        int bucket = Hashing.consistentHash(hashFunction.newHasher().putString(key.toString()).hash(), nodeList.size());
        System.out.println("Node: localhost:300"+bucket);
        return nodeList.get(bucket);
    }
}
