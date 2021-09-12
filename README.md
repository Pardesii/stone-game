# Stone Removal

This android project is an implementation of a problem based on game theory which appeared on [Codeforces](https://codeforces.com/contest/1382/problem/B).

## Description

There are **N** piles of stones arranged in a line, all of the piles contain **non-zero** amount of stones. Two players **Alice** and **Bob** play the game. First it is Alice's turn and then Bob's and so on. In each turn, a player has to remove a **non-zero** amount of stones from the first **non-empty** pile. The player who removes the last stone from the last pile is the winner of the game.

The whole process might seem trivial but it involves strategy. But formally, the first player who gets a pile containing more than one stone wins the game. That means, there is always a strategy for him to win no matter what. 

**Basic Implementation in JAVA**

```bash
int n=fs.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++)
{
    arr[i]=fs.nextInt();
}
int i=0;
int count=0;
while(i<n && arr[i]==1)
{
    count++;
    i++;
}
if(i==n)
{
    System.out.println(n%2==0?"Second":"First");
}
else
{
    System.out.println(count%2==0?"First":"Second");
}
```

## Demo(UI and functionality)

[Video link(32 secs)](https://user-images.githubusercontent.com/86518676/132977939-14fa13cc-8d11-46d2-b135-69173a3ed430.mp4)

**Explanation**
```
arr = [3,1,4,4,3]

Player 1 removes 2 stones
arr = [1,1,4,4,3]

Player 2 removes 1 stone
arr = [0,1,4,4,3]

Player 1 removes 1 stone
arr = [0,0,4,4,3]

Player 2 removes 4 stones
arr = [0,0,0,4,3]

Player 1 removes 4 stones
arr = [0,0,0,0,3]

Player 2 removes 3 stones
arr = [0,0,0,0,0]

Player 2 gets the last stone and wins the game. Other strategies were also possible.
```

## Project status
I made this project way back in 2020 when I was learning android development. There is scope for improvement and couple of more functionalities can be added including login/signup and tournament making. I will add them once I start working on the project again.



## Conclusion
I Thank You very much for reading till here. Have a nice day.
