package code;

//Java program for array
//implementation of queue

//A class to represent a queue
class Queue {
 int front, rear, size;
 int capacity;
 NodeUpdated[] array;

 public Queue(int capacity)
 {
     this.capacity = capacity;
     front = this.size = 0;
     rear = capacity - 1;
     array = new NodeUpdated[this.capacity];
 }

 // Queue is full when size becomes
 // equal to the capacity
 boolean isFull(Queue queue)
 {
     return (queue.size == queue.capacity);
 }

 // Queue is empty when size is 0
 boolean isEmpty(Queue queue)
 {
     return (queue.size == 0);
 }

 // Method to add an item to the queue.
 // It changes rear and size
 void enqueue(NodeUpdated item)
 {
     if (isFull(this))
         return;
     this.rear = (this.rear + 1) % this.capacity;
     this.array[this.rear] = item;
     this.size = this.size + 1;
    // System.out.println(item + " enqueued to queue");
 }

 // Method to remove an item from queue.
 // It changes front and size
 NodeUpdated dequeue()
 {
     
     NodeUpdated item = this.array[this.front];
     this.front = (this.front + 1) % this.capacity;
     this.size = this.size - 1;
     return item;
 }

 // Method to get front of queue
 NodeUpdated front()
 {
     
     return this.array[this.front];
 }

 // Method to get rear of queue
NodeUpdated rear()
 {
 

     return this.array[this.rear];
 }









//Driver class

 public static void main(String[] args)
 {
     Queue queue = new Queue(1000);

     
    

//     System.out.println(queue.dequeue()
//                        + " dequeued from queue");
//
//     System.out.println("Front item is "
//                        + queue.front());
//
//     System.out.println("Rear item is " + queue.rear());
 }
}
