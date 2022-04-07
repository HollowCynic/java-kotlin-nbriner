Nathan Briner - Thread Homework Assignment
4/7/2022

This threaded application has bakers grabbing dough (shared resource) from the bakery's inventory. Next the bakers work the dough. When the dough has been worked enough they will bake the dough and add it to the baked dough collection in the inventory. When the baked dough inventory is equal to the starting unbaked dough inventory the bakers will close their thread. There is a stream function that in the inventory class that will return the least folded piece of dough, so one could change the behavior of the bakers to prioritized unworked dough.

Sample output:

![thread_o1](https://user-images.githubusercontent.com/68364120/162288039-2462eaf8-6137-466b-81e3-418e56bafec7.PNG)

![thread_o2](https://user-images.githubusercontent.com/68364120/162288049-21460417-ed94-440f-9e3a-aadb7b8d340a.PNG)

Test cases pass:

![thread_t1](https://user-images.githubusercontent.com/68364120/162288063-629b679f-7db6-4dd2-ad10-ec9a24f8b47b.PNG)

Stream function test that returns the least worked dough:

![thread_t2](https://user-images.githubusercontent.com/68364120/162288072-21273720-b9d6-449f-a85e-120603512338.PNG)
