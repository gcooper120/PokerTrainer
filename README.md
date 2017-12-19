I think these are all the classes we will need to get this shit off the ground. They're all pretty self explanatory and most of it is trivial coding.

For the first part of this project, I want to have support for a single player at a table, and for the out engine to calculate outs at each phase of the game post flop. There are a few things in here that aren't necesary for that, but I thought it'd be nice to have them so expansion is easier down the line.




Classes:

Card:
This one doesn't really need anything.

Deck:
Hard code in all of the cards for an unshuffled deck
Shuffle Algorithm

Player:
This one doesn't really need anything.

Table:
Trivial add to community cards method
Add/Remove a player (probably needs to be done between hands?)

PokerDealer:
Deal hands to players
Lay down flop
Lay down turn
Lay down river
Will need to interact with table objects, might add a table to the instance variables. Idk what do you guys think?

OutEngine:
Out Algorithm





Algorithms:

Shuffle Algorithm:
	Somehow we need to get a pseudo random ordering of cards. My thought is this:
	1. Set counter = 0
	2. Generate random number between 0-51-counter, let's call it i
	3. Select ith element from the array, push into stack.
	4. Move the 51-counterth element to the ith element of the array.
	5. Repeat 2-4 until counter = 52.

Out Algorithm:
	Haven't really thought of this yet. Tim had an idea brewing though.
