Union Find
==========

Dynamic connectivity

Given a set of N objects
With a series of connections / unions
Is there a path between the two?
`connected(0, 7)`, `union(5, 0)`

'is connected to' is equivalence
- reflexive (p.p)
- symmetric (p.q -> q.p)
- transitive (p.q & q.r -> p.r)

Equivalence creates _connected components_
a maximal set of objects that are connected - no objects outside

### operations
unions merge connected components

### datatype
UF(int N)


