# Maze-Generation
This is my progress on a maze generation project. This started out being a Lab that I never completed during my module. In the summer after spending mindless hours gaming.
I thought hey, lets try some of the Labs I didn't get time to complete during term time. This Lab has evolved to my own project that focuses on the generation and solving of mazes.
This is using Java and Java Swing for the visualisation.

I have so far implemented Depth-First-Search Backtracking. It generates a maze (Which so far hasn't quite been adjusted so that it fits the window) --> Another thing to implement

## How it works

In Panel.java there is a main function called paint. A Maze object is constructed. It requires both the HEIGHT and WIDTH. This automatically calls the function to solve and then we take that maze 
in and update where the walls are for each cell using a nested for loop. 

It is a tad clunky for now and I have some work to do in order to make it way more user friendly.

## Future Development Plans

### Big Plans
So this is not the end of the maze generator. I have a lot planned.
- I want to implement is a visualiser (Most likely with a toggle later on) So a person can see how the maze is generated.
- What is a maze generator without a solver? At first using a simple method such as DFS (I haven't looked into much detail about that yet) 
- I would like to have an interface with user input so they can toggle on the visualiser or click so that the maze can be solved
- 

### Small Life Improvements that I need to do
- Adjust the maze cell size so that it fits the window
- Make it easier for the user to change height and width


## Acknowledged Bugs 
- When readjusting the screen or clicking the screen again it generates a new Maze.
