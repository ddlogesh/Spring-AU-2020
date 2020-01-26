I came up with Composite DP, which uses hierarchical (tree-like) structure.

Leaf (Room) -> No. of tubelight, fan and windows.

Building    -> Floor1   -> Flat1    -> Room1
                                    -> Room2
                                    -> Room3

                        -> Flat2    -> Room1
                                    -> Room2

                        -> Flat3    -> Room1

            -> Floor2   -> Flat1    -> Room1
                                    -> Room2

                        -> Flat2    -> Room1

Theory: https://www.youtube.com/watch?v=mp5lwolO-wM
Practical: https://www.youtube.com/watch?v=Q1jZ4TI6MF4