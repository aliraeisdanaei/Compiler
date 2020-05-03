# compiler

This project was created to better understand the concepts of data structures and computational theory courses. 
It includes the following:
1. ADT & implementation of a stack & queue.
2. A Reverser of Queue that uses a stack to check that the stack & queue are working properlly. 
3. A lexical analyzer and parser for the grammar of brackets. 

The grammar that is as follows:\
s --> A1SA2|B1SB2|C1SC2\
S --> e\
A1 --> (\
A2 --> )\
B1 --> [\
B2 --> ]\
C1 --> {\
C2 --> }\

Basically any bracket that opens needs to close. This {{{()[]}}} is part of the language while this {] is not. \

The grammar has been simplified to chomsky's normal form for simplicity. 
