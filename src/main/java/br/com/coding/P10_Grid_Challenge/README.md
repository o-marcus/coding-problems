## Grid Challenge

Given a square grid of characters in the range ascii[a-z],
rearrange elements of each row alphabetically, ascending.
Determine if the columns are also in ascending
alphabetical order, top to bottom.

Return YES if they are or

NO if they are not.

Example

grid = ['abc’,’ade’,’efg’]
The grid is illustrated below.

abc

ade

efg

The rows are already in alphabetical order. The columns a
a e, b d fandc e gare also in alphabetical order, so the
answer would be YES. Only elements within the same row
can be rearranged. They cannot be moved to a different
row.