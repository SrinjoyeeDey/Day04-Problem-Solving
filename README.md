# 🚀 LeetCode Medium Problems – Day 4

This repository contains detailed explanations, approaches, and dry runs for LeetCode Problems 71, 75, and 394.
I’ve documented every detail (edge cases, reasoning, and complexity analysis) so that future me—or anyone revisiting this—can understand without looking at external notes.


---

## ✅ Problem 71: Simplify Path

📌 Problem Statement

Given an absolute path for a file (Unix-style), simplify it.
Return the canonical path:

Must start with /

No trailing / (unless root)

"." means current dir → ignore

".." means go back → pop from stack if not empty

Multiple slashes // → treated as /



---

🔍 Approaches

1. Brute Force (String Manipulation)

Split by /

Manually build path, ignoring extra /, ".", and ".."

Hard to maintain → not efficient


2. Optimized Approach (Stack) ✅

Split path by /

Iterate over each part:

Skip empty & "."

".." → pop from stack (if not empty)

Else → push into stack


Join stack into final path



---

## 📊 Time & Space Complexity

Time: O(n) (traverse each directory once)

Space: O(n) (stack stores directory names)



---

⚡ Edge Cases

1. Input: "/../" → Output: "/"


2. Input: "/home//foo/" → Output: "/home/foo"


3. Input: "/a/./b/../../c/" → Output: "/c"


4. Input: "/../x/../" → Output: "/"




---

📝 Dry Run (Example)

Input: "/a/./b/../../c/"

Split → ["", "a", ".", "b", "..", "..", "c", ""]

Stack = []
"a" → push → ["a"]
"." → ignore
"b" → push → ["a", "b"]
".." → pop → ["a"]
".." → pop → []
"c" → push → ["c"]

Final = "/c"



---

## ✅ Problem 394: Decode String

📌 Problem Statement

Given an encoded string like "3[a2[c]]", decode it.
Rules:

k[encoded_string] → repeat string inside [] k times

Nested brackets allowed



---

🔍 Approach


1. Stack (Optimal) ✅

Use two stacks:

numStack → stores repetition counts

strStack → stores current string state


Traverse string:

If digit → form number

If [ → push current string & count

If ] → pop & repeat decoded string

Else → append character




---

## 📊 Time & Space Complexity

Time: O(maxK * n), where maxK is the maximum repeat count

Space: O(n) (stack for nested substrings)



---

⚡ Edge Cases

1. Input: "3[a]2[bc]" → Output: "aaabcbc"


2. Input: "3[a2[c]]" → Output: "accaccacc"


3. Input: "2[abc]3[cd]ef" → Output: "abcabccdcdcdef"


4. Input: "100[leetcode]" → Output: "leetcode" repeated 100 times




---

📝 Dry Run (Example)

Input: "3[a2[c]]"

StackNum = []
StackStr = []
currStr = ""
currNum = 0

'3' → currNum=3
'[' → push(3, ""), reset currStr=""
'a' → currStr="a"
'2' → currNum=2
'[' → push(2, "a"), reset currStr=""
'c' → currStr="c"
']' → pop(2,"a") → currStr="a" + "c"*2 = "acc"
']' → pop(3,"") → currStr="" + "acc"*3 = "accaccacc"

Final = "accaccacc"


---

🔑 Edge Cases with Examples

📒 Dry Runs for Better Clarity
