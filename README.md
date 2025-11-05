Digital Systems Design Final Project

Project Description:
The goal of this project is to build a game using Verilog that will run on an FPGA board. 

Chosen Game: Frogger
Frogger introduces a good bit of challenge as we have to deal with a lot of generating objects that are moving in respective lanes. This means we will need a collision detection system to make sure our frog isn't colliding with a Car (Object).

We will also need some level of player input that allows up, down, left and right movement from an input source such as the keyboard. The player will then need to avoid cars and other obstacles to get to the end of the level.

Optional: If time allows it maybe a look into procedural generation.


Project Design Formula:

Since debugging game logic in verilog would be pretty difficult, we'd first like to build the game in Java and then later set it up in a hardware description langauge to run on the FPGA. 

1. Start with a basic game system to get an idea of what the logic looks like and then scale up. 
