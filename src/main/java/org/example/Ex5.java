package org.example;

public class Ex5 {
    public class HashTable<K,V> {

        private static final int INT_BASKET_COUNT = 16;
        private static final double LOAD_FACTOR = 0.75;
        private Basket[] baskets;

        public HashTable() {
            this(INT_BASKET_COUNT);
        }

        public HashTable(int initSize) {
            baskets = (Basket[]) new Object[initSize];
        }

        private int calculateBasketIndex(K key) {
            return key.hashCode() % baskets.length;
        }

        public V get(K key) {
            int index = calculateBasketIndex(key);
            Basket basket = baskets[index];
            if (basket != null) {
                return basket.get(key);
            }
            return null;
        }

        public boolean remove(K key) {
            int index = calculateBasketIndex(key);
            Basket basket = baskets[index];
            return basket.remove(key);
        }

        public boolean put(K key, V value) {
            int index = calculateBasketIndex(key);
            Basket basket = baskets[index];
            if (basket == null) {
                basket = new Basket();
                baskets[index] = basket;
            }
            Entity entity = new Entity();
            entity.key = key;
            entity.value = value;
            return basket.put(entity);
        }


        private class Entity {
            private K key;
            private V value;
        }

        private class Basket {
            private Node head;

            private class Node {
                private Node next;
                private Entity value;
            }

            public V get(K key) {
                Node node = head;
                while (node != null) {
                    Entity entity = node.value;
                    if (entity.key.equals(key)) {
                        return entity.value;
                    }
                    node = node.next;
                }
                return null;
            }

            public boolean remove(K key) {
                Node node = head;
                if (node != null) {
                    Entity entity = node.value;
                    if (entity.key.equals(key)) {
                        head = head.next;
                    } else {
                        while (node.next != null) {
                            entity = node.next.value;
                            if (entity.key.equals(key)) {
                                node.next = node.next.next;
                                return true;
                            }
                            node = node.next;
                        }
                    }
                }
                return false;
            }

            public boolean put(Entity entity) {
                Node node = new Node();
                node.value = entity;
                if (head != null) {
                    Node currentNode = head;
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                    return true;
                } else {
                    head = node;
                    return true;
                }
            }
        }
    }
}
