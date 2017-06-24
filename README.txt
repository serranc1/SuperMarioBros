Author:
Christian Agbayani Serrano

How to set up Super Mario Bros:
1. Get the java files and put them into an empty Android Studio project.
2. Add the icons to the game by using the "New -> Image Asset" option on the drawable folder in project view. Name each icon with the name
   it comes with (Ex: If you're adding mariostillleft.png as the image asset, name the image asset "mariostillleft" and make sure it's a 
   launcher icon).
3. Change the name of the package on each java file to match your own package name.
4. Run the app to start the game.

How to play Super Mario Bros:
-The directional pad has buttons to move left and right, crouch/pipe warp, and jump diagonally in either direction.
-The jump button (A) makes Mario jump purely vertically.
-The fireball button (B) makes Mario shoot fireballs.
-Small Mario can become Super Mario either by picking up a Super Mushroom or a Fire Flower.
-Super Mario can become Fire Mario by picking up a Fire Flower.
-Super Mario and Fire Mario can break blocks by jumping and hitting them from beneath.
-Getting hit while in Super Mario or Fire Mario form reverts Mario back into Small Mario form.
-Getting hit while in Small Mario form or falling out of the map makes Mario die and lose a life.
-If Mario dies and has lives to spare, he will respawn at the start of the level in which he died.
-The game ends when Mario clears all 3 levels, you run out of time, or when Mario runs ot of lives and dies.

Disclaimers:
-Piranha plants will come out and retreat instantly instead of slowly, and they will stay out for a shorter duration.
-Enemies can't move through each other.
-There's no flag to get score from. There will only pipes to the next level.
-The Android display is bugged, but the array that the display is based on seems to be correct.
-This isn't a true multi threaded program since the methods for manipulating the arrays weren't implemented in the run() or start() methods.
