package org.example;

public class Ex5 {
    public class HashTable<K,V> {

        private static final int INT_BASKET_COUNT = 16;
        private static final double LOAD_FACTOR = 0.75;
        private int size = 0;
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

        public void recalculate() {
            Basket[] old = baskets;
            baskets = (Basket[]) new Object[old.length * 2];
            for (int i = 0; i < old.length; i++) {
                Basket basket = old[i];
                Basket.Node node = basket.head;
                while (node != null) {
                    put(node.value.key, node.value.value);
                    node = node.next;
                }
                old[i] = null;
            }
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
            boolean flag = basket.remove(key);
            if (flag) size--;
            return flag;
        }

        public boolean put(K key, V value) {
            if (size >= LOAD_FACTOR * baskets.length) {
                recalculate();
            }
            int index = calculateBasketIndex(key);
            Basket basket = baskets[index];
            if (basket == null) {
                basket = new Basket();
                baskets[index] = basket;
            }
            Entity entity = new Entity();
            entity.key = key;
            entity.value = value;
            boolean flag = basket.put(entity);
            if (flag) size++;
            return flag;
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
