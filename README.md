# Java-Tic-Tac-Toe

This project is a solution for a problem proposed by JetBrains Academy.
The project is composed of a single main Java Class that can read the player's moves through the console input and
outputs the result of the game once finished.
It also verifies if the move is possible and output a message if not.

## Game rules and Description

Tic-tac-toe is a game played by two players on a 3x3 field.

One of the players plays as 'X', and the other player is 'O'. 'X' plays first, then the 'O' side plays, and so on.

The players write 'X' and 'O' on a 3x3 field.

The first player that writes 3 'X' or 3 'O' in a straight line (including diagonals) wins.

## Outputting results

The game goes from a state to another; Possible states:

- "Game not finished" - when no side has a three in a row but the field has empty cells;
- "Draw" - when no side has a three in a row and the field has no empty cells;
- "X wins" - when the field has three X in a row;
- "O wins" - when the field has three O in a row;
- "Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's that O's or vice versa (if the difference is 2 or more, should be 1 or 0).

## Example

The example below shows how your output might look.

X O X
O X O
X X O 
