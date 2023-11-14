## Merge Two Sorted Linked Lists

Given pointers to the heads of two sorted linked lists,
merge them into a single, sorted linked list. Either head
pointer may be null meaning that the corresponding list is
empty.

Example

head A refers to 1 —> 3 — 7 —> NULL

head B refers to 1 —> 2 —> NULL

The new list is 1 —> 1 —>  2 —> 3 —> 7 —> NULL

Function Description

Complete the mergeLists function in the editor below.
mergelLists has the following parameters:

* SinglyLinkedListNode pointer head A: a reference to the
head of a list

* SinglyLinkedListNode pointer head B: a reference to the
head of a list

Returns

* SinglyLinkedListNode pointer: a reference to the head of
the merged list