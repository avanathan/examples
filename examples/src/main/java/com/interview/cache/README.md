# LRU Cache Java Example
Here we have a simple example for implementing LRU Cache using Java.

## Algorithm
1. We use a HashMap as cache
1. We use a LinkedList to maintain the order of recently used key
1. Initialize the map with `s` elments, where `s` is the max size of the cache
1. For each put, we add `<k,v>` to map and every `k` as first element to the LinkedList
1. For each get, we get from map and adjust the order of `k` in the list to the first element. This way, the least used is always the last element of the list
1. If the size of the cache `>= s`, we remove last element from the LinkedList & map (using the key)

