
## Trees

![tree](https://i.ibb.co/bFknknN/Screenshot-from-2021-07-31-15-47-15.png)

-   Tree with _(n)_ nodes there will be _(n-1)_ links or edges(in given img each arrow can be called as link)
-   **Depth and height**:
    -   **Depth**: `depth of x = length of path from root to x` or `number of edges on path from root to x`
        -   _root_ node has depth of 0
    -   **Height**: `height of x = number edges in longest path from x to leaf`
        -   _leaf_ nodes have height of 0
        -   height of tree with only 1 node (_i.e root node_) is 0
        -   height of an empty tree is -1

### Binary Tree:

Each Node in binary tree can have **at most 2 children**

> -   Max No. of node at level _i_ is = 2<sup>_i_</sup>

> -   Max number of node _n_ in binary tree with height _h_
>     = 2<sup>0</sup> + 2<sup>1</sup> + . . . . . + 2<sup>_h_</sup>
>     = 2<sup>_h+1_</sup> - 1
>     = 2<sup>(_no of levels_)</sup> - 1

> -   Height of perfect binary tree _h_ with no. of node _n_
>     = log<sub>2</sub> (n+1) - 1

-   **Complete Binary Tree**: all levels except possibly the last are completely filled (i.e has two child), and at last level all nodes are as left as possible

-   **Perfect Binary Tree**: all levels must be completely filled (i.e should have left and right child except the last level)
-   **Balanced Binary Tree**: _difference between_ the **height of left** and **right sub-tree** for every node is _not more than k_ (mostly 1)
    > diff = | h<sub>left</sub> - h<sub>right</sub> |

#### Binary tree with array:

> for node at index _i_,
> left child index = _2i+1_
> left child index = _2i+2_
