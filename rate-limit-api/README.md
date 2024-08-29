# rate-limit-api

# Dependency
* bucket4j-core

# How the Token Bucket Algorithm Works
## Basic Concepts
  * Bucket: Imagine a bucket that can hold a fixed number of tokens.
  * Tokens: Each token represents permission to send a certain amount of data or process a request. For example, one token might allow one HTTP request or one packet of data to be sent.
  * Token Generation: Tokens are added to the bucket at a constant rate, up to a maximum capacity. If the bucket is full, additional tokens are discarded.
## Operation
  * Request Handling: When a request is made (e.g., to send data or process an API call), a token is removed from the bucket.
  * Insufficient Tokens: If there are no tokens in the bucket when a request arrives, the request is either delayed until a token is available (in a leaky bucket variant) or rejected (in a strict implementation).
  * Token Replenishment: Tokens are replenished over time at a fixed rate, simulating a steady flow of allowed operations.
  
## Example Scenario
   Consider an API that wants to limit the number of requests from a user to 5 requests per minute. Here's how the Token Bucket algorithm would manage this:
  * Bucket Capacity: The bucket can hold a maximum of 5 tokens.
  * Token Refill Rate: Tokens are added to the bucket at a rate of 1 token every 12 seconds (to total 5 tokens per minute).
  * Request Handling: Each incoming API request consumes one token from the bucket.
If a user makes a request and tokens are available, the request is processed, and one token is removed.
If no tokens are available, the request is either delayed or denied until tokens become available.


# Author
* Aarfi Siddique